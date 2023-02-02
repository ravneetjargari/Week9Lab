<%-- 
    Document   : editnote
    Created on : 1-Feb-2023, 4:03:07 PM
    Author     : ravne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Editor</title>
    </head>
    <body>
        <h1>Simple Note Editor</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            <p>
                <b>Title:</b>
                <input type="text" name="titleEdit" value="${title}">
            </p>
            <p>
                <b>Contents:</b><br>
                <textarea name="contentsEdit">${contents}</textarea>
            </p>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
