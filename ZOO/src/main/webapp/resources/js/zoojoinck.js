function memberjoinck(form) {
	var idField = form.zm_id;
	var pwField = form.zm_pw;
	var pwckField = form.pwck;
	var nameField = form.zm_name;
	var birthField = form.birthday;
	var birthField2 = form.birthday2;
	var addr1Field = form.addr1;
	var addr2Field = form.addr2;
	var addr3Field = form.addr3;
	var photoField = form.zm_photo;
	// css값을 받아올때 우리가 흔히아는 red이런형식으로 받아오는게 아닌 rgb(0,0,0)형식으로 받아오기에
	// red의rgb값을 받아 조건문if를 ==rgb(255,0,0)으로 써야한다

	if (checkEmpty(idField) || containsHS(idField)
			|| $("#memberJoinID").css("color") == "rgb(255,0,0)") {
		alert(idCk);
		alert("id?");
		idField.value = "";
		idField.focus();
		return false;

	}
	if (checkEmpty(pwField) || notEquals(pwField, pwckField)
			|| notContain(pwField, "1234567890")) {
		alert("pw?");
		pwField.value = "";
		pwckField.value = "";
		return false;
	}
	if (checkEmpty(birthField) || shortThan(birthField, 6)
			|| shortThan(birthField2, 1) || checkEmpty(birthField2)
			|| isNotNum(birthField) || isNotNum(birthField2)) {

		alert("주민번호?");
		birthField.value = "";
		birthField2.value = "";
		return false;

	}
	if (checkEmpty(addr1Filed) || checkEmpty(addr2Filed)
			|| checkEmpty(addr3Filed)) {
		alert("주소?");
		addr1Filed.value("");
		addr2Filed.value("");
		addr3Filed.value("");
		addr1Filed.focus();
		return false;
	}

	if (checkEmpty(photoField) || isNotType(photoField, "png")
			&& isNotType(photoField, "jpg") && isNotType(photoField, "gif")) {
		alert("사진을 넣어주세요");
		return false;
	}

	return true;

}

function loginCheck(f) {
	var idFiled = f.zm_id;
	var pwFiled = f.zm_pw;
	if (checkEmpty(idFiled) || checkEmpty(pwFiled)) {
		alert("login?");
		idFiled.value = "";
		pwFiled.value = "";
		idFiled.focus();
		return false;

	}
}

function memberUpdateck(form) {
	var pwField = form.zm_pw;
	var pwckField = form.pwck;
	var nameField = form.zm_name;
	var addr1Field = form.addr1;
	var addr2Field = form.addr2;
	var addr3Field = form.addr3;
	var photoField = form.zm_photo;

	if (checkEmpty(pwField) || notEquals(pwField, pwckField)
			|| notContain(pwField, "1234567890")) {
		alert("pw?");
		pwField.value = "";
		pwckField.value = "";
		return false;
	}

	if (checkEmpty(addr1Filed) || checkEmpty(addr2Filed)
			|| checkEmpty(addr3Filed) || isNotNum(addr1Filed)
			|| shortThan(addr1Filed, 5)) {
		alert("주소?");
		addr1Filed.value("");
		addr2Filed.value("");
		addr3Filed.value("");
		addr1Filed.focus();
		return false;
	}

	if (isNotType(photoField, "png") && isNotType(photoField, "jpg")
			&& isNotType(photoField, "gif")) {
		alert("사진을 넣어주세요");
		return false;
	}
	if (checkEmpty(photoField)) {

		return true;

	}

	return true;

}

function snsupdateCk(f) {
	var txtIp = f.zs_txt;
	if (checkEmpty(txtIp)) {
		alert("내용을 입력해주세요");
		return false;
	}
	return true;
}

function snsWriteCheck(f) {
	var colorInput = f.zs_color;
	var txtInput = f.zs_txt;
	if (checkEmpty(colorInput) || checkEmpty(txtInput)) {
		alert("내용을 입력해주세요");
		return false;

	}
	return true;
}
function snsReplyWriteCheck(f) {
	var srtField = f.gsr_txt;
	if (checkEmpty(srtField)) {
		alert("내용?");
		return false;

	}
	return true;

}

function dataroomUpdateck(f) {
	var titleField = f.zd_title;
	var categoryField = f.zd_category;
	var fileField = f.zd_file;
	if (checkEmpty(titleField) || checkEmpty(categoryField)
			|| checkEmpty(fileField)) {
		alert("?");
		titleField.value = ("");
		fileField.value = ("");
		return false;

	}

}
function galleryUploadCk(f) {
	var titleField = f.zg_title;
	var photoField = f.zg_photo;
	if (checkEmpty(titleField) || checkEmpty(photoField)) {
		alert("내용");
		titleField.value = ("");
		phoField.value = ("");
		return false;

	}
	if (isNotType(phoField, "png") && isNotType(phoField, "jpg")
			&& isNotType(phoField, "gif")) {
		alert("사진")
		return false;

	}

}
