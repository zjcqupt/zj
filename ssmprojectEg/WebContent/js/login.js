/**
 * 
 */
var name_flag=false;
var email_flag=false;
var password_flag=false;
var accept_flag=false;

$(function(){
	
	
	
});

function checkUserName(object){
	if (checks(object.value) == false) {
		document.getElementById("username_notice").innerHTML="- 用户名只能是由字母数字以及下划线组成.";
	}
	else if(object.value.length<1)
		{document.getElementById("username_notice").innerHTML="<span style='COLOR:#ff0000'>  × 用户名不能为空!</span>";}
	else {
		$.ajax({
			type:"post",
			url:"/ssmprojectEg/MVC/login",
			datatype:'json',
			data:{
				userName:object.value //id识别也可以
			},
			success:function(data){
				if(data.flag)
					{document.getElementById("username_notice").innerHTML="<span style='COLOR:#ff0000'> 用户名可以使用</span>";}
				else{
					document.getElementById("username_notice").innerHTML="<span style='COLOR:#ff0000'> × 用户名已经存在,请重新输入!</span>";
					name_flag=true;
				}
			}
		});
		
	}
};

function checkConformPassword(object){
	var FirstInput=$("#password").val();
	if ( object.value!= FirstInput)
		{document.getElementById("conform_password_notice").innerHTML="密码输入不一致";}
	else{
		document.getElementById("conform_password_notice").innerHTML="密码输入一致";
		password_flag=true;
	}
};

function checkPassword(password ){
	if(password.value.length < 1){
		 password_flag=false;
        document.getElementById("password_notice").innerHTML="密码不能为空"; }
	 else  
     {  
		 document.getElementById("password_notice").innerHTML="密码格式正确"; 
		//还没确认
     }  	
};

function checkAgreement(){
	if(document.getElementById("agreement").checked){
		accept_flag=true;
		change_submit();//默认此时提交按钮生效，实际上每一步都需要实时更新，方便测试
	}
	else{
		alert("请确认用户协议");
	}
};


//更新提交按钮函数
function change_submit()  
{   	
	name_flag=true;
	if(name_flag&&password_flag&&accept_flag){
		  document.forms['formUser'].elements['Submit1'].disabled = '';  
	}
   else  
     {  
          document.forms['formUser'].elements['Submit1'].disabled = 'disabled';  
     }  
}  


/*
 * 用户名检测是否包含非法字符
 */
function checks(t){
	szMsg = "[#%&\'\"\\,;:=!^@]"
		for (i = 1; i < szMsg.length + 1; i++) {
			if (t.indexOf(szMsg.substring(i - 1, i)) > -1) {//包含错误字符
				return false;
			}
		}
	return true;
}