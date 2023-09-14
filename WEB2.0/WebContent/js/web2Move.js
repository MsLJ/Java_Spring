function bye(){
	var really=prompt("탈퇴하려면 탈퇴라 입력");
	if(really=="탈퇴"){
		location.href="ByeController";
	}
}

function deletePhoto(no){
	if(confirm("really")){
		location.href="PhotoZoneDeleteController?no="+no;
	}
}
function snsWriteCheck(){
	var confirmwr=document.snsWriteForm.txt;
	if(checkEmpty(confirmwr)){
		alert("내용을 입력해주세요");
		return false;
	}
	
}
function deleteSNS(no){
	if(confirm("really")){
		location.href="SnsDeleteController?no="+no;
	}
}
function deleteReply(no){
	var really=prompt("삭제라 입력");
	if(really=="삭제"){
		location.href="SnsReplyController?no="+no;
	}
}

function updateSNSMsg(no,txt){
	var txt=prompt("수정할 내용",txt);
	if(txt!=null&&txt.length<251){
		location.href="SNSUpdateController?no="+no+"&txt="+txt;
	}
}
function snsREChek(f){
	var txtField=f.txt;
	if(checkEmpty(txtField)){
		alert("내용을 입력해주세요");
		return false;
	}
	return true;
}
function photoCheck(){
	var photoFiled=document.photoF.photo;
	if(checkEmpty(photoFiled)||isNotType(photoFiled, "png") && isNotType(photoFiled, "jpg") && isNotType(photoFiled, "gif")){
	alert("사진을 넣어주세요");
	return false;
	}
	return true;
}