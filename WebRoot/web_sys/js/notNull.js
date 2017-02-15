/**
 * 查询表单不为空
 */
function yzStu(){
	var result = true;
	var name = document.getElementById("name").value;
	if(name==""){
		result = false;
		alert("请输入学生姓名!");
	}else if(name.length>3){
		result = false;
		alert("姓名的长度在1到3之间!");
	}
	return result;
}