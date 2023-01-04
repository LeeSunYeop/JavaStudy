package kr.co.common.utils;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class UploadFileUtils {
	
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
		
		int idx = filename.lastIndexOf(".") + 1; // .뒤에 확장자명을 가지고 온다
		String formatName = filename.substring(idx);
		
		return formatName;
	}
	
	public static String makePath(String uploadPath) {
		
		Calendar cal = Calendar.getInstance();
		
		// 파일경로 만들기
		String yearPath = File.separator+ cal.get(Calendar.YEAR);	
		
		int month = cal.get(Calendar.MONTH)+1;
		String sMonth = month < 10? "0"+month : month+"";		
		String monthPath = yearPath +File.separator+ sMonth;
		
		int date = cal.get(Calendar.DATE);
		String sDate = date < 10? "0"+date : date+"";
		String datePath = monthPath +File.separator+ sDate;
		
		makeDir(yearPath, monthPath, datePath, uploadPath);
		
		return datePath;
	}

	public static void makeDir(String yearPath, String monthPath, String datePath, String uploadPath) {
		
		File fy = new File(uploadPath, yearPath);
		
		if (!fy.exists()) {  // fy는 fileyear줄임 fy파일이 존재하면 넘어가고, 없으면 실행(만들어라)
			fy.mkdir();
		}
		
		File fm = new File(uploadPath, monthPath);
		if (!fm.exists()) {
			fm.mkdir();
		} else {
			System.out.println(monthPath+">>>>>>>>>>>");
		}
		
		File fd = new File(uploadPath, datePath);
		if (!fd.exists()) {
			fd.mkdir();
		}
		
	}

}
