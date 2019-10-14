<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <form action="/Logon" method="get">
            <table>
            	<tr>
            		<td>用户名</td>
            		<td><input type="text" name="userName"></td>
            	</tr>
            	<tr>
            		<td>密码</td>
            		<td><input type="password"  name="pwd"/></td>
            	</tr>
            	<tr>
            		<td> ${msg }</td>
            		<td><input type="submit"  value="登录"/></td>
            	</tr>
            </table>
       </form>
      
</body>
</html>