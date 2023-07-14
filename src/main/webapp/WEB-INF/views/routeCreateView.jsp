<%--
  Created by IntelliJ IDEA.
  User: vuade
  Date: 01/06/23
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<html>
<head>
    <jsp:include page="_metaAdmin.jsp"/>
    <title>Tạo quãng đường</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        .center-div {
            flex-grow: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>

</head>
<body>
<jsp:include page="_headerAdmin.jsp"/>

<div class="center-div">
    <form id="routeForm" action="${pageContext.request.contextPath}/admin/routeManager/create" method="POST" class="row g-3">
        <c:if test="${not empty requestScope.successMessage}">
            <div class="alert alert-success mb-3" role="alert">
            ${requestScope.successMessage}
            </div>
        </c:if>
        <c:if test="${not empty requestScope.errorMessage}">
            <div class="alert alert-danger mb-3" role="alert">
            ${requestScope.errorMessage}
            </div>
        </c:if>
        <c:if test="${not empty requestScope.violations.name}">
            <div class="alert alert-danger mb-3" role="alert">
                <c:forEach var="violation" items="${requestScope.violations.name}">
                    ${violation}
                </c:forEach>
            </div>
        </c:if>
        <div class="col-md-6">
            <label for="nameInput" class="form-label">Tên của chuyến</label>
            <input id="nameInput" type="text" name="name" class="form-control" placeholder="Hãy chọn điểm đi và điểm đến trước">
        </div>
        <div class="col-md-3">
            <label for="pickUpPointSelect" class="form-label">Lựa chọn điểm đi</label>
            <select id="pickUpPointSelect" name="pickUpPoint" class="form-select" aria-label="Default select example">
                <option value="">Lựa chọn điểm đi</option>
                <c:forEach var="city" varStatus="loop" items="${requestScope.cityFromServer}">
                    <option value="${city.id}">
                            ${loop.index + 1} - ${city.name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-3">
            <label for="dropOffPointSelect" class="form-label">Lựa chọn điểm đến</label>
            <select id="dropOffPointSelect" name="dropOffPoint" class="form-select" aria-label="Default select example">
                <option value="">Lựa chọn điểm đến</option>
                <c:forEach var="city" varStatus="loop" items="${requestScope.cityFromServer}">
                    <option value="${city.id}">
                            ${loop.index + 1} - ${city.name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Thêm</button>
        </div>
    </form>

</div>
    <jsp:include page="_footerAdmin.jsp"/>
</body>
</html>
