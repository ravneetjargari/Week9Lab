<%-- 
    Document   : shoppinglist
    Created on : 22-Feb-2023, 1:18:43 PM
    Author     : ravne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="">Logout</a></p>
        <h2>List</h2>
        <form method="post" action="shoppinglist">
            Add item: <input type="text" name="itemToAdd">
            <input type="submit" name="item" value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
        <form action="" method="post">
            <ul>
                <c:forEach var="item" items="${list}">
                    <li>
                        <input type="radio" name="item" value="${item}"> ${item}
                    </li>
                </c:forEach>
            </ul>
            
            <input type="submit" value="Delete Item">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
