<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<html>
<head>
    <jsp:include page="_metaAdmin.jsp"/>
    <title>Tạo chuyến</title>
</head>
<body>
<jsp:include page="_headerAdmin.jsp"/>
<section class="section-content">
    <div class="container">
        <header class="section-heading py-4">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <h3 class="section-title">Thêm chuyến xe</h3>
                    </div>
                </div>
            </div>
        </header>

        <main class="row mb-5">
            <form class="col-lg-6 " method="POST" action="${pageContext.request.contextPath}/admin/tripsManager/create">
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

                <div class="mb-3">
                    <label for="trips-routes" class="form-label">Lựa chọn quãng đường <span class="text-danger">*</span></label>
                    <select name="routesId" class="form-select" id="trips-routes" aria-label="Default select example">
                        <c:forEach var="routes" items="${requestScope.routes}">
                            <option value="${routes.id}">${routes.name}</option>
                        </c:forEach>
                    </select>
                </div>
<%--                <div class="mb-3">--%>
<%--                    <label for="hourSelect" class="form-label">Chọn thời gian trung chuyển (Chọn theo đơn vị giờ ) <span--%>
<%--                            class="text-danger">*</span></label>--%>
<%--                    <div class="input-group">--%>
<%--                        <select class="form-select" id="hourSelect" name="hourSelect"></select>--%>
<%--                        <span class="input-group-text">:</span>--%>
<%--                        <label for="minuteSelect"></label><select class="form-select" id="minuteSelect" name="minuteSelect"></select>--%>
<%--                    </div>--%>
<%--                </div>--%>
                <div class="mb-3">
                    <label for="transportSelect" class="form-label">Chọn phương tiện <span class="text-danger">*</span></label>
                    <select name="transportId" class="form-select" id="transportSelect">
                        <c:forEach var="transport" items="${requestScope.transports}">
                            <option value="${transport.id}">${transport.nameOfTransport}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="datetimeInput" class="form-label">Chọn ngày và thời gian khởi hành <span
                            class="text-danger">*</span></label>
                    <div class="input-group">
                        <input type="text" id="datetimeInput" name="datetimeInput" readonly>
                        <span class="input-group-text"><i class="bi bi-clock"></i></span>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary me-2 mb-3">
                    Thêm
                </button>
                <button type="reset"
                        class="btn btn-warning me-2 mb-3"
                        onclick="return confirm('Bạn có muốn để giá trị mặc định?')">
                    Mặc định
                </button>
                <a class="btn btn-danger mb-3"
                   href="${pageContext.request.contextPath}/admin/categoryManager"
                   role="button"
                   onclick="return confirm('Bạn có muốn hủy?')">
                    Hủy
                </a>
            </form>

        </main>
    </div> <!-- container.// -->
</section> <!-- section-content.// -->


</body>
</html>
