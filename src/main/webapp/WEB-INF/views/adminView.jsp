<%--
  Created by IntelliJ IDEA.
  User: vuade
  Date: 27/05/23
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
        <jsp:include page="_metaAdmin.jsp"/>
        <title> Quản lí Chung </title>
</head>
<body>
<jsp:include page="_headerAdmin.jsp"/>
<section class="section-content padding-y">
        <div class="container">
                <div class="card bg-light">
                        <div class="card-body p-5">
                                <h1 class="display-5 mb-5">Quản lý website bán vé xe</h1>
                                <div class="row">
                                        <div class="col-6 col-lg-3">
                                                <figure class="card">
                                                        <div class="p-3">
                                                                <h4 class="title">${requestScope.totalUsers}</h4>
                                                                <span>Người Dùng</span>
                                                        </div>
                                                </figure>
                                        </div>
                                        <div class="col-6 col-lg-3">
                                                <figure class="card">
                                                        <div class="p-3">
                                                                <h4 class="title">${requestScope.totalTransport}</h4>
                                                                <span>Phương Tiện</span>
                                                        </div>
                                                </figure>
                                        </div>
                                        <div class="col-6 col-lg-3">
                                                <figure class="card">
                                                        <div class="p-3">
                                                                <h4 class="title">${requestScope.totalRoute}</h4>
                                                                <span>Quãng Đường</span>
                                                        </div>
                                                </figure>
                                        </div>

                                </div>
                        </div>
                </div> <!-- card.// -->
        </div> <!-- container.// -->
</section> <!-- section-content.// -->

<jsp:include page="_footerAdmin.jsp"/>


</body>
</html>
