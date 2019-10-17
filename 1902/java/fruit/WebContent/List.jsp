<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, com.thzhima.bean.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap-theme.css">
    <script src="bower_components/jquery/dist/jquery.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
    <title>商品列表</title>
    <style>
    .pic{
        width: 50px;
        height:30px;
        position:absolute;
        z-index: 1;
    }
    .pic:hover{
        z-index: 1000;
        transform: scale(3);
    }
    </style>
</head>
<body>
    
    <div class="container">
        
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">商品列表</div>
                
                <!-- Table -->
                <table class="table table-borderd">
                    <thead>
                        <tr>
                            <th>名称</th>
                            <th>描述</th>
                            <th>单位</th>
                            <th>单价</th>
                            <th>产地</th>
                            <th>图片</th>
                            <th>在售状态</th>
                        </tr>
                       
                    </thead>
                    <tbody>
<%
List<Goods> list = (List<Goods>)request.getAttribute("list");
for(Goods g : list){
%>                    
                       <tr>
                           <td><% out.print(g.getGoodsName()); %></td>
                           <td><%=g.getDescription() %></td>
                           <td><%=g.getUnit() %></td>
                           <td><%=g.getPrice() %></td>
                           <td><%=g.getLocation() %></td>
                           <td><img src='/pictures/<%=g.getPicture() %>' class="pic"/></td>
                           <td><%=g.getSaleStatus()?"在售":"下架" %></td>
                       </tr>
<%} %>                       
                    </tbody>
                </table>
        </div>
        
    </div>
    
</body>
</html>