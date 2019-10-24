<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>首页</title>
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="./bower_components/bootstrap/dist/css/bootstrap-theme.css">
    <script src="./bower_components/jquery/dist/jquery.js"></script>
    <script src="./bower_components/bootstrap/dist/js/bootstrap.js"></script>
    <style>
        #head {
            width: 100%;
            height: 138px;
            background: red url("./imgs/banel_b.jpg");
            line-height: 138px;
            font-size: 40px;
            text-align: center;
            color: wheat;

        }
    </style>
</head>

<body>

    <div class="container">

        <div id="head">
            <nobr>国际软件外包培训中心专业技术博客</nobr>
        </div>
       
        <!-------------------------------导航--------------------------------------->
        <nav class="navbar navbar-default" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span>
    <c:if test="${!empty userInfo }">            
               <c:out value="你好${userInfo.userName }" default=""/>
   </c:if>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
  <%
  Object o = session.getAttribute("userInfo");
   if (null == o){
  %>              
                    <li><a href="Regist.jsp" target="_blank">注册</a></li>
                    <li><a href="Login.jsp" target="_blank">登录</a></li>
  <% 
  }else{%>  
                                
  
                    <li><a href="/logout.do" target="_blank">注销</a></li>
  <% }%>                  
                </ul>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
<c:if test="${sessionScope.userInfo != null}">         


    <c:choose> 
   
          <c:when test="${sessionScope.blogInfo == null }">
                    <li><a href="./apply.html" >申请博客</a></li>
          </c:when>
          <c:otherwise>
                    <li><a href="#">我的博客</a></li>
           </c:otherwise>
    </c:choose>   
</c:if>                       
                    
<!--                     <li class="dropdown"> -->
<!--                         <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a> -->
<!--                         <ul class="dropdown-menu"> -->
<!--                             <li><a href="#">Action</a></li> -->
<!--                             <li><a href="#">Another action</a></li> -->
<!--                             <li><a href="#">Something else here</a></li> -->
<!--                             <li><a href="#">Separated link</a></li> -->
<!--                         </ul> -->
<!--                     </li> -->
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>

    </div>
    <!-------------------------------导航结束--------------------------------------->


</body>

</html>