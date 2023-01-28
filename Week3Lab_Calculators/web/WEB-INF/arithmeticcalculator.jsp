<%-- 
    Document   : arithmeticcalculator
    Created on : 27-Jan-2023, 6:57:22 PM
    Author     : ravne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="arithmetic">
            First: <input type="text" name="enternum1" value="${enternum1}"><br>
            Second: <input type="text" name="enternum2" value="${enternum2}"><br>
            <input type="submit" value="+" name="submit" >
            <input type="submit" value="-" name="submit" >
            <input type="submit" value="*" name="submit">
            <input type="submit" value="/" name="submit" >
        </form>
        <p>Result:</p><p>${result}</p>
        <a href="age">Age Calculator</a>
    </body>
</html>
