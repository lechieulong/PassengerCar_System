<%--
  Created by IntelliJ IDEA.
  User: vuade
  Date: 01/06/23
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<html>
<head>
    <jsp:include page="_metaAdmin.jsp"/>
    <title>Quản lí tuyến đường</title>
</head>
<body>
<jsp:include page="_headerAdmin.jsp"/>
<section class="section-content">
    <div class="container">
        <header class="section-heading py-4 d-flex justify-content-between">
            <h3 class="section-title">Quản lý Quãng đường</h3>
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/admin/routeManager/create"
               role="button"
               style="height: fit-content;">
                Thêm Quãng đường
            </a>
        </header>
        <main class="table-responsive-xl mb-5">
            <table class="table table-bordered table-striped table-hover align-middle">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">Tên quãng đường</th>
                    <th scope="col" style="width: 400px;">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="route" varStatus="loop" items="${requestScope.routeFromServer}">
                <tr>
                        <th scope="row">${loop.index + 1}</th>
                        <td>${route.id}</td>
                        <td>${route.name}</td>
                        <td class="text-center text-nowrap">
                            <a class="btn btn-primary me-2"
                               href="${pageContext.request.contextPath}/admin/routeManager/detail?id=${route.id}"
                               role="button">
                                Xem
                            </a>
                            <a class="btn btn-success me-2"
                               href="${pageContext.request.contextPath}/admin/routeManager/update?id=${route.id}"
                               role="button">
                                Sửa
                            </a>
                            <a class="btn btn-danger"
                               href="${pageContext.request.contextPath}/admin/routeManager/delete?id=${route.id}"
                               role="button"
                               onclick="return confirm('Bạn có muốn xóa?')">
                                Xóa
                            </a>
                        </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </main>
        <c:if test="${requestScope.totalPages != 0}">
            <nav class="mt-3 mb-5">
                <ul class="pagination justify-content-center">
                    <li class="page-item ${requestScope.page == 1 ? 'disabled' : ''}">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/routeManager?page=${requestScope.page - 1}">
                            Trang trước
                        </a>
                    </li>

                    <c:forEach begin="1" end="${requestScope.totalPages}" var="i">
                        <c:choose>
                            <c:when test="${requestScope.page == i}">
                                <li class="page-item active">
                                    <a class="page-link">${i}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item">
                                    <a class="page-link"
                                       href="${pageContext.request.contextPath}/admin/routeManager?page=${i}">
                                            ${i}
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <li class="page-item ${requestScope.page == requestScope.totalPages ? 'disabled' : ''}">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/routeManager?page=${requestScope.page + 1}">
                            Trang sau
                        </a>
                    </li>
                </ul>
            </nav>
        </c:if>
    </div> <!-- container.// -->
</section> <!-- section-content.// -->
<jsp:include page="_footerAdmin.jsp"/>

</body>
</html>
