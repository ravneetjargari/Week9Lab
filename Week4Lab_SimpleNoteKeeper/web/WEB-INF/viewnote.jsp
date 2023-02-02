<%-- 
    Document   : home
    Created on : 1-Feb-2023, 2:23:29 PM
    Author     : ravne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <form method="post" action="hello">
            Title: <p>${title}</p>
            Contents: <p>${contents}</p>
        </form>
        <a href="note?edit">Edit</a>
    </body>
</html>
