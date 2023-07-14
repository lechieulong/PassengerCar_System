<%--
  Created by IntelliJ IDEA.
  User: vuade
  Date: 27/05/23
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<html>
<head>
    <jsp:include page="_metaAdmin.jsp"/>
    <title>Thông tin phương tiện #${requestScope.transport.id}</title>
</head>
<body>
<jsp:include page="_headerAdmin.jsp"/>
<section class="section-content">
    <div class="container">
        <header class="section-heading py-4">
            <h3 class="section-title">Thông tin phương tiện</h3>
        </header> <!-- section-heading.// -->
        <div class="card mb-5">
            <div class="card-body">
                <dl class="row">
                    <dt class="col-md-3">ID</dt>
                    <dd class="col-md-9">${requestScope.transport.id}</dd>

                    <dt class="col-md-3">Tên thể loại</dt>
                    <dd class="col-md-9">
                        <a href="${pageContext.request.contextPath}/transport?id=${requestScope.transport.id}" target="_blank">
                            ${requestScope.transport.nameOfTransport}
                        </a>
                    </dd>

                    <dt class="col-md-3">Mô tả phương tiện</dt>
                    <dd class="col-md-9">${requestScope.transport.description}</dd>

                    <dt class="col-md-3">Hình phương tiện</dt>
                    <dd class="col-md-9">
                        <c:choose>
                            <c:when test="${empty requestScope.transport.imageName}">
                                <img width="50" src="${pageContext.request.contextPath}/img/50px.png"
                                     alt="50px.png">
                            </c:when>
                            <c:otherwise>
                                <img width="50" src="${pageContext.request.contextPath}/image/${requestScope.transport.imageName}"
                                     alt="${requestScope.transport.imageName}">
                            </c:otherwise>
                        </c:choose>
                    </dd>
                </dl>
            </div>
        </div> <!-- card.// -->
    </div> <!-- container.// -->
</section> <!-- section-content.// -->

<jsp:include page="_footerAdmin.jsp"/>


</body>
</html>
