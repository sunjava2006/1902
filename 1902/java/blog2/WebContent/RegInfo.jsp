<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册信息</title>
</head>
<body>
   <h1>${msg }</h1>  
   
   <% 
   String msg = (String)request.getAttribute("msg");
   out.print(msg);
   %>
</body>
</html>