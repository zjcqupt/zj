<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>直接登录</title>
</head>
<body>
<FORM name="formUser"  action="<%=request.getContextPath()%>/MVC/oldcus"  method=post>  
<TABLE width="100%" align=center border=0>  
    <TBODY>  
      <TR>  
        <TD align=right width="15%"><STRONG>用户名:</STRONG></TD>
        <TD width="57%"><INPUT id="username"    name="username">            
      </TR>  
      <TR>  
        <TD align=right><STRONG>密码:</STRONG></TD>  
        <TD><INPUT id="password" type="password" name="password">  
 		</TD>
      </TR>
      <tr>
       <TD >
       <input type=submit value=登录   name="Submit1" class="anniu" align="center">
       </TD>
      </tr>   
</TBODY>
</TABLE>

</FORM>  
</body>
</html>