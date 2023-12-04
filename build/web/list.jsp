<%-- 
    Document   : List
    Created on : Nov 17, 2023, 12:07:19 PM
    Author     : Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phan Trang</title>
        <style>
            table{
                border-collapse: collapse;
            }
            .content{
                margin: auto;
                width: 80%;
                float: left;
                margin-left: 30px;
                height: auto;
            }
            .pagination{
                display: inline-block;
            }
            .pagination a{
                color: black;
                font-size: 22px;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }
            .pagination a.active{
                background-color: #4CAF50;
                color: white;
            }
            .pagination a:hover:not(active){
                background-color: chocolate;
            }
        </style>
    </head>
    <body>
        <div class="content">
            <h1>List of products</h1>
            <c:set var="page" value="${requestScope.page}"/>
            <div class="pagination">
                <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                    <a class="${i==page?"active":""}" href="list?page=${i}">${i}</a>
                </c:forEach>
            </div>
            <table border="1px">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>image</th>
                    <th>Quantity</th>
                    <th>ReleaseDate</th>
                    <th>Describe</th>
                    <th>Category Name</th>
                </tr>
                <c:forEach items="${requestScope.data}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>
                            <img src="${p.image}" width="80px" height="80px"/>
                        </td>
                        <td>${p.quantity}</td>
                        <td>${p.releaseDate}</td>
                        <td>${p.describe}</td>
                        <td>${p.category.name}</td>
                    </tr>

                </c:forEach>
                
            </table>
        </div>
    </body>
</html>
