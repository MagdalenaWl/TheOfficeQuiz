<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>The Office Quiz</title>
    <link rel="stylesheet"
          href="<c:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"/>"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"/>"
          rel="stylesheet">
    <style><%@include file="/css/style.css"%>
    </style>
    <link rel="stylesheet" href="<c:url value="https://use.fontawesome.com/releases/v5.5.0/css/all.css"/>"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>

<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            The Office <span>Quiz</span>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link" href="/login">logowanie</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href="/register">rejestracja</a>
            </li>

            <%--            <li>--%>
            <%--                <%  HttpSession sess = request.getSession();--%>
            <%--                    if (sess.getAttribute("adminID")!=null) {%>--%>
            <%--                <a href="/dashboard">--%>
            <%--                    <div class="circle-div text-center">--%>
            <%--                        <i class="fas fa-user icon-user"></i>--%>
            <%--                    </div>--%>
            <%--                </a>--%>
            <%--                <% } %>--%>
            <%--            </li>--%>
        </ul>
    </nav>
</header>
