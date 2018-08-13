<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/ssmprojectEg/js/jquery-2.1.4.js"></script>
<script src="/ssmprojectEg/js/login.js"></script>
<title>注册验证</title>
</head>
<body>
<div id="reg">  
<FORM name="formUser"  action="<%=request.getContextPath()%>/MVC/register"  method=post>  
  <TABLE width="100%" align=center border=0>  
    <TBODY>  
      <TR>  
        <TD align=right width="15%"><STRONG>用户名:</STRONG></TD>
        <!-- 元素失交即检查 -->  
        <TD width="57%"><INPUT id="username" onBlur="checkUserName(this)"   
      name="username">  
            <SPAN id="username_notice" >*</SPAN></TD>  
      </TR>  
      <TR>  
        <TD align=right><STRONG>密码:</STRONG></TD>  
        <TD><INPUT id="password" onBlur="checkPassword(this)"   
      onkeyup="checkIntensity(this.value)" type="password" name="password">  
            <SPAN   
      id=password_notice >*</SPAN></TD>  
      </TR>  
      <TR>  
        <TD align=right><STRONG>密码强度:</STRONG></TD>  
        <TD><TABLE cellSpacing=0 cellPadding=1 width=145 border=0>  
          <TBODY>  
            <TR align=middle>  
              <TD id=pwd_lower width="33%">弱</TD>  
              <TD id=pwd_middle width="33%">中</TD>  
              <TD id=pwd_high width="33%">强</TD>  
            </TR>  
          </TBODY>  
        </TABLE></TD>  
      </TR>  
      <TR>  
        <TD align=right><STRONG>确认密码:</STRONG></TD>  
        <TD><INPUT id="conform_password" onBlur="checkConformPassword(this)"   
      type="password" name="confirm_password">  
            <SPAN id=conform_password_notice >*</SPAN></TD>  
      </TR>  
      <TR>  
        <TD> </TD>  
        <TD><LABEL>  
          <INPUT type="checkbox" id="agreement" onclick="checkAgreement(this)">  
          <B>我已看过并接受《<a href="#">用户协议</a>》</B></LABEL></TD>  
      </TR>  
      <TR>  
        <TD  ><INPUT type=hidden value=act_register name=act></TD>  
        <TD  ><input type=submit value=确认注册    name="Submit1" class="anniu" disabled></TD>
        <TD/>
         <TD  ><input type="button" value=已经注册，进入登录页码   name="Submit2" class="denglu" onclick="location.href='login.jsp'"></TD>    
      </TR>  
      <TR>  
        <TD colSpan=2> </TD>  
      </TR>  
    </TBODY>  
  </TABLE>  
</FORM>  
</div>           
</body>
</html>