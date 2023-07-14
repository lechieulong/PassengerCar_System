<%--
  Created by IntelliJ IDEA.
  User: vuade
  Date: 26/05/23
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <jsp:include page="_metaAdmin.jsp"/>
    <title>Đăng nhập</title>
</head>
<body class="bg-light">
<section class="section-content mx-auto" style="margin: 100px 0; max-width: 380px;">
    <h3 class="mb-3 p-3 text-center bg-primary text-white rounded"> Nhà xe Long Phú</h3>
    <div class="card">
        <div class="card-body">
            <h4 class="card-title mb-3">Đăng nhập </h4>
            <form action="${pageContext.request.contextPath}/client/signin" method="post">
                <div class="mb-3">
                    <input name="username"
                           class="form-control ${not empty requestScope.violations.usernameViolations
                   ? 'is-invalid' : (not empty requestScope.values.username ? 'is-valid' : '')}"
                           placeholder="Tên đăng nhập"
                           type="text"
                           autocomplete="off"
                           value="${requestScope.values.username}">
                    <c:if test="${not empty requestScope.violations.usernameViolations}">
                        <div class="invalid-feedback">
                            <ul class="list-unstyled">
                                <c:forEach var="violation" items="${requestScope.violations.usernameViolations}">
                                    <li>${violation}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                </div>
                <div class="mb-3">
                    <input name="password"
                           class="form-control ${not empty requestScope.violations.passwordViolations
                   ? 'is-invalid' : (not empty requestScope.values.password ? 'is-valid' : '')}"
                           placeholder="Mật khẩu"
                           type="password"
                           autocomplete="off"
                           value="${requestScope.values.password}">
                    <c:if test="${not empty requestScope.violations.passwordViolations}">
                    <div class="invalid-feedback">
                        <ul class="list-unstyled">
                            <c:forEach var="violation" items="${requestScope.violations.passwordViolations}">
                                <li>${violation}</li>
                            </c:forEach>
                        </ul>
                    </div>
                    </c:if>
                    <br>
                    <div class="mb-3 btn btn-primary w-100">
                        <i class="bi bi-google "></i>
                        <a class="text-light" href="https://accounts.google.com/o/oauth2/auth?client_id=1088499236693-v50rr2v1k9p3t17khkcum2og4l0g3a3v.apps.googleusercontent.com&redirect_uri=http://localhost:8080/demo1_war_exploded/callback&response_type=code&scope=email&prompt=select_account" >
                            Đăng nhập bằng tài khoản Google
                        </a>
                    </div>
                    <div>
                        <a class="text-danger" href="${pageContext.request.contextPath}/signup" >
                         <button class="btn btn-primary w-100" type="button">
                             Đăng ký
                         </button>

                        </a>
                    </div>
                    <br/>
                    <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
            </form>
        </div> <!-- card-body.// -->
    </div> <!-- card .// -->
</section> <!-- section-content.// -->
</body>
</html>
