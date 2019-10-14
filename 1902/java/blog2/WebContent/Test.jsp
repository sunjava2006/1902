<%@ page language="java" contentType="text/html; charset=UTF-8"
   import="com.thzhima.blog.service.*, com.thzhima.bean.*" isErrorPage="true"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
        String userName = request.getParameter("userName");
        String  pwd = request.getParameter("pwd");
        
        UserService us = new UserService();
        User u =  us.logon(userName, pwd);
   %>
   <%if(null ==u){ %>
        登录失败
   <% }else{ %>
   <%
         session.setAttribute("userInfo", u);
   
   %>
       登录成功。
   <%} %>
</body>
</html>