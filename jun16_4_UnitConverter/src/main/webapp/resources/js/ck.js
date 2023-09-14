function check(){
	var valueInput=document.f.value;
	if(checkEmpty(valueInput)||isNotNum(valueInput)){
		alert("입력값을 입력 숫자만");
		valueInput.value="";
		valueInput.focus();
		return false;
	}
	return true;

		
	
}