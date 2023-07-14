<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="_metaAdmin.jsp"/>

    <title>Quản lí chuyến xe</title>
    <style>
        .form-infor{
            box-shadow: rgba(50, 50, 93, 0.25) 0px 13px 27px -5px, rgba(0, 0, 0, 0.3) 0px 8px 16px -8px;
        }
    </style>

</head>
<body>

<jsp:include page="_headerAdmin.jsp"/>
<section class="section-content">
    <div class="container">
        <c:if test="${not empty sessionScope.successMessage}">
            <div class="alert alert-success mb-0 mt-4" role="alert">
                    ${sessionScope.successMessage}
            </div>
        </c:if>
        <c:if test="${not empty sessionScope.errorMessage}">
            <div class="alert alert-danger mb-0 mt-4" role="alert">
                    ${sessionScope.errorMessage}
            </div>
        </c:if>
        <c:remove var="successMessage" scope="session"/>
        <c:remove var="errorMessage" scope="session"/>
        <header class="section-heading py-4 d-flex justify-content-between">
            <h3 class="section-title">Quản lý chuyến đi</h3>
            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/admin/tripsManager/create"
               role="button"
               style="height: fit-content;">
                Thêm chuyến
            </a>
        </header> <!-- section-heading.// -->

        <main class="table-responsive-xl mb-5">
            <table class="table table-bordered table-striped table-hover align-middle">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Tên chuyến </th>
                    <th scope="col">Thời gian bắt đầu khời hành </th>
                    <th scope="col">Xe của theo chuyến</th>
                    <th scope="col" > số ghế</th>
                    <th scope="col">Đặt vé</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="trips" varStatus="loop" items="${requestScope.tripFromServer}">
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td >${trips.name} </td>
                    <td >${trips.tripsTransportDepartTime} </td>
                    <td >
                        <a href="${pageContext.request.contextPath}/admin/transportManager/detail?id=${trips.id}">
                                ${trips.nameOfTransport}
                        </a>
                    </td>
                    <td>${trips.totalSeat}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/ticketManager/confirm?id=${trips.tripsTransportId}">
                        Đặt vé chuyến xe này
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
                           href="${pageContext.request.contextPath}/admin/tripsManager?page=${requestScope.page - 1}">
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
                                       href="${pageContext.request.contextPath}/admin/tripsManager?page=${i}">
                                            ${i}
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <li class="page-item ${requestScope.page == requestScope.totalPages ? 'disabled' : ''}">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/tripsManager?page=${requestScope.page + 1}">
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
