function bye() {
	var really = prompt("bye");
	if (really == "bye") {
		location.href = "member.bye";

	}
}

function snsPageChange(page) {
	location.href = "sns.page.change?page=" + page;

}
function deleteMSG(no) {
	if (confirm("게시물을 삭제하실깝쇼?")) {
		location.href = "sns.delete?zs_no=" + no;

	}

}

function updateMSG(no, txt, page) {
	
	//java의 replace는 다 바꾸는거
//	txt=txt.replace("<br>","\r\n");
	//JS:첫번째꺼만 바꾸게 ->정규식
	txt=txt.replace(/<br>/g,"\r\n");
	$("#snsUpdatezs_no").val(no);
	$("#snsUpdatezs_Txt").val(txt);
	$("#snsUpdatePage").val(page);
	
	$("#blackArea").css("left","0px");
	$("#blackArea").css("top","0px");
	$("#blackArea").css("opacity","1");
//	var txt = $("#blackArea").find("textarea");
//	if (txt.val() != null) {
//		location.href = "sns.update?zs_no=" + no + "&zs_txt=" + txt.val() + "&page="
//				+ page;
//
//	}

}
function deletesnsRe(no,page) {
	if (confirm("댓글 삭제?")) {
		location.href = "sns.re.delete?zsr_no=" + no + "&page=" + page;

	}

}

function deletedata(no) {
	if (confirm("삭제?")) {
		location.href="dataroom.delete?zd_no="+no;
		
	}
	
}


