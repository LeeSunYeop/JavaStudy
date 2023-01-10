package kr.co.common.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.omg.CORBA.portable.InputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {
	
	public static String uploadFile(String uploadPath, 
									MultipartFile file,
									ServletContext sc) throws Exception{
		
		String originalFilename = file.getOriginalFilename();
		
		String filename = makeFilename(originalFilename);
		
		byte[] arr  = file.getBytes();
		// arr은 파일과 관련된 데이터를 바이트로 가져온다.
		
		// uploadPath = changeToAbsolutePath(uploadPath, sc);
		//상대경로
		
		String datePath = makePath(uploadPath); // /2023/01/05 
		
		
		File target = new File(uploadPath+datePath, filename);
		// uploadPath: D드라이브의 upload를 뜻함
		//D:/upload/2023/01/05 됨
		
		FileCopyUtils.copy(arr, target);
		
		String formatName = getFormatName(filename);
		MediaType mType = getMediaType(formatName);
		
		String uploadedFilename = null;
		
		if(mType == null) {
			uploadedFilename = makeIcon(datePath, filename);
			//  /2023/01/05/uuid_홍길동이력서.xlx 이런 파일명이 나온다.
		}else {
			uploadedFilename = makeThumbnail(datePath, filename, uploadPath);
			// 썸네일이 생성되고 생성된 파일은 uploadPath에 저장한다.
			// 썸네일의 파일명이 반환됨.			
			// flower.png
			// uuid_flower.png
			// /2023/01/05/uuid_flower.png
			// /2023/01/05/s_uuid_flower.png -> 반환됨
		}
		
		
		return uploadedFilename;
		
	}
	
	public static String makeThumbnail(String datePath, String filename, String uploadPath) throws Exception {
		
		String thumbnailName = "s_"+filename;
		File tFile = new File(uploadPath+datePath, thumbnailName);
		
		String formatName = getFormatName(filename);
		
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath+datePath, filename));
		BufferedImage destImg= Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, 
										Scalr.Mode.FIT_EXACT, 100);
		// FIT_TO_HEIGHT 세로길이를 기준으로 100으로 만든다는 의미
		// FIT_EXACT 100x100 썸네일이 만들어진다.
		
		ImageIO.write(destImg, formatName, tFile);
		
		String uploadedFilename = datePath + File.separator + thumbnailName; 
		uploadedFilename = uploadedFilename.replace(File.separatorChar, '/');
		
		
		return uploadedFilename;
	}
	
	
	public static String makeIcon(String datePath, String filename) {
		String uploadedFilename = datePath +File.separator+ filename;
		// \2023\01\06\asd_a.txt 가 나옴
		// /2023/01/06/asd_a.txt 으로 다시 바꿔주기
		
		uploadedFilename = uploadedFilename.replace(File.separatorChar, '/');
		
		return uploadedFilename;
	}
	

	public static String getOriginalFilename(String filename) {
		
		// 서버명의 파일이름이 아닌 원래의파일명을 가져오기
		int idx = filename.indexOf("_")   + 1 ;
		String originalFilename = filename.substring(idx);
		
		return originalFilename;
	}
	
	public static String makeFilename(String filename) {
		
		// 만약 같은 이름의 파일이 있을때
		// 오리지널 파일이름을 바꾸는게 아니라 서버에 있는 파일이름을 바꾼다 
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() +"_"+filename;
		return savedName;
	}
	
	
	public static String changeToAbsolutePath(String uploadPath, ServletContext sc) {
		//절대경로
		return sc.getRealPath(uploadPath);
	}
	
	
	
	public static MediaType getMediaType(String formatName) {
		formatName = formatName.toLowerCase();
		// 만약 확장자가 대문자로 되어있으면 밑에 값에 해당되는게 없기에 null값이 나온다
		// 그전에 전부다 소문자가 되도록 설정해 준다.
		
		Map<String, MediaType> map = new HashMap<String, MediaType>();
		
		
		map.put("png", MediaType.IMAGE_PNG);
		map.put("gif", MediaType.IMAGE_GIF);
		map.put("jpeg", MediaType.IMAGE_JPEG);
		map.put("jpg", MediaType.IMAGE_JPEG);
		// 만약 txt를 넣으면 null값이 나온다.
		
		return map.get(formatName);
	}
	
	
	public static String getFormatName(String filename) {
		//"aa.txt", "b.png", "c.gif", "d.jpg", "e.jpeg", "e.pdf"
		
		int idx = filename.lastIndexOf(".") + 1;
		String formatName = filename.substring(idx);
		
		return formatName;
		
	}
	
	
	public static String makePath(String uploadPath) {
		
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator+ cal.get(Calendar.YEAR);
		
		int month = cal.get(Calendar.MONTH)+1;
		String sMonth = month < 10? "0"+month : month+"";
		String monthPath = yearPath +File.separator+ sMonth;
		
		int date = cal.get(Calendar.DATE);
		String sDate = date < 10 ? "0"+date : date+"";
		
		// 파일경로 만들기
		String datePath = monthPath +File.separator+ sDate;
		
		makeDir(yearPath, monthPath, datePath, uploadPath);
		
		
		return datePath;
	}

	public static void makeDir(String yearPath, String monthPath, String datePath, String uploadPath) {
		File fy = new File(uploadPath, yearPath);		
		if(!fy.exists()) {// fy는 fileyear줄임 fy파일이 존재하면 넘어가고, 없으면 실행(만들어라)
			fy.mkdir();
		}
		
		
		File fm = new File(uploadPath, monthPath);
		if(!fm.exists()) {
			fm.mkdir();
		}
		
		File fd = new File(uploadPath, datePath);
		if(!fd.exists()) {
			fd.mkdir();
		}
		
	}

	public static void deleteUploadFiles(String uploadPath, 
									List<String> uploadedFileList) 
											throws Exception {
		
		for(int i=0;i<uploadedFileList.size();i++) {
			String uploadedFilename = uploadedFileList.get(i);
			File deleteFile = new File(uploadPath, uploadedFilename);
			
			if(deleteFile.exists()) {
				deleteFile.delete();
			}			
			
			int idx = uploadedFilename.indexOf("s_");
			
			if(idx != -1) { // idx가 -1이 아니면 일반파일이다(s_가 없는파일)
				String prefix = uploadedFilename.substring(0, idx);
				String suffix = uploadedFilename.substring(idx + 2);
				
				String filename = prefix + suffix;
				
				deleteFile = new File(uploadPath, filename);
				
				if(deleteFile.exists()) {
					deleteFile.delete();
				}
			}
			
			Thread.sleep(50);
		}
		
	}

	public static ResponseEntity<byte[]> showOrDownload(String uploadPath, String filename) {
		ResponseEntity<byte[]> entity = null;
		
		String formatname = getFormatName(filename);
		MediaType mType = getMediaType(formatname);
		
		HttpHeaders headers = new HttpHeaders();
		
		FileInputStream in = null;
		
		try {
			
			if (mType != null) {
				String prefix = filename.substring(0, 12);
				String suffix = filename.substring(14);
				
				filename = prefix + suffix;
				
				in = new FileInputStream(uploadPath+filename);
				
				headers.setContentType(mType); //화면에 출력
			} else {
				
				in = new FileInputStream(uploadPath+filename);
				
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				//파일을 다운로드하게함
				
				int idx = filename.indexOf("_") + 1;
				String originalFilename = filename.substring(idx);
				originalFilename = new String(originalFilename.getBytes("UTF-8"), "ISO-BB59-1");
				
				headers.add("Content-Disposition", "attachment;filename=\""+originalFilename+"\"");
			}
			
			byte[] arr = IOUtils.toByteArray(in);
			
			entity = new ResponseEntity<byte[]>(arr, headers, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {						
					e.printStackTrace();					
				}
			}
		}
							
		return entity;
	}

}
