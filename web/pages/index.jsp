<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.05.2016
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <% request.setCharacterEncoding("UTF-8"); %>
    <div>
        <h1> Hello JSP!</h1>
    </div>
    <form name="username" action="StartServlet" method="POST">
        <input type="text" name="username" value="Введите имя..." size="20" />
        <input type="submit" value="Войти" />
    </form>
</body>
</html>
