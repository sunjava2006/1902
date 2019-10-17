<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.thzhima.blog.listeners.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div>
        总访问数：<%=application.getAttribute(StartupListener.TOTAL_ACCESS_COUNT) %>
    </div>
</body>
</html>