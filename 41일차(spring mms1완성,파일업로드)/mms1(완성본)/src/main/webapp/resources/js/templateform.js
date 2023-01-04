/**
 * 
 */
 
 
function getReplyAll(bno, reply_list){
	
	let tagstrs = '';
	
	$.getJSON("/replies/"+bno+"/all", function(result){
		for(let i=0; i<result.length;i++){
			let replyDto = result[i];
			let tagstr = reply_form(replyDto.rno, 
			replyDto.id, replyDto.reply, 
			replyDto.updatedate)
			
			tagstrs = tagstrs + tagstr;
		}
		
		reply_list.html(tagstrs)
		
	});
	
	
}
 
 
 
function reply_form(rno, id, reply, updatedate){
	
	let tagstr = `
	<div class="card row my-4">
				<h6 class="card-header">
					댓글번호: <span class="reply_rno">${rno}</span>
					<span class="reply_id float-right">작성자:  ${id}</span>
					
				</h6>
				<div class="card-body" data-rno="${rno}" data-id="${id}">
					<p class="card-text reply">${reply}</p>
					<a href="#" class="btn btn-warning btn-sm read_btn_replyui_update">수정</a>
					<a href="#" class="btn btn-warning btn-sm read_btn_replyui_delete">삭제</a>
					<span class="float-right">수정일: ${updatedate}</span>
				</div>
			</div>
	
	
	`;
	
	return tagstr;
	
}