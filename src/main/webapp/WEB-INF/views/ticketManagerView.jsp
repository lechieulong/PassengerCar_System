<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>

<!DOCTYPE html>
<html lang="vi">

<head>
    <jsp:include page="_metaAdmin.jsp"/>
    <title>Quản lý đánh giá</title>
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

        <header class="section-heading py-4">
            <h3 class="section-title">Quản lý vé</h3>
        </header> <!-- section-heading.// -->

        <main class="table-responsive-xl mb-5">
            <table class="table table-bordered table-striped table-hover align-middle">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">Người dùng</th>
                    <th scope="col">Tên chuyến đi </th>
                    <th scope="col">Tổng tiền</th>
                    <th scope="col">Tên Nhà xe</th>
                    <th scope="col">Số ghế còn lại</th>

                    <th scope="col" style="width: 200px;">Tình trạng thanh toán</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ticket" varStatus="loop" items="${requestScope.tickets}">
                    <tr>
                        <th scope="row">${loop.index + 1}</th>
                        <td>${ticket.id}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/admin/userManager/detail?id=${ticket.user.id}">
                                    ${ticket.user.username}
                            </a>
                                (${ticket.user.fullName})
                        </td>
                        <td>
                            <c:if test="${ticket.tripsTransportByPointAndDate != null}">
                                ${ticket.tripsTransportByPointAndDate.routeName}
                            </c:if>
                        </td>
                        <td>
                                ${ticket.totalPrice}
                        </td>
                        <td>
                                ${ticket.tripsTransportByPointAndDate.nameOfTransport}
                        </td>
                        <td>
                                ${ticket.tripsTransportByPointAndDate.totalSeat}/${ticket.tripsTransportByPointAndDate.quantity}
                        </td>
                        <td>

                            <c:choose>
                                <c:when test="${ticket.status == 0}">
                                    Đã thanh toán
                                </c:when>
                                <c:otherwise>
                                    Chưa thanh toán
                                </c:otherwise>
                            </c:choose>


                        </td>
                        <td class="text-center text-nowrap">
                            <div class="btn-group" role="group">
                            <button type="submit"
                                    class="btn ${ticket.status == 0 ? 'btn-secondary' : 'btn-success'}"
                                    form="update-hide-${ticket.id}" ${ticket.status == 0 ? 'disabled' : ''}
                                    onclick="return confirm('Bạn có muốn xác nhận chưa chuyển khoản thành công  vé này?')">
                                Chưa thanh toán
                            </button>
                            <button type="submit"
                                    class="btn ${ticket.status == 1 ? 'btn-secondary' : 'btn-warning'}"
                                    form="update-show-${ticket.id}" ${ticket.status == 1 ? 'disabled' : ''}
                                    onclick="return confirm('Bạn có muốn xác nhận đã chuyển khoản thành công  vé này?')">
                                Đã thanh toán
                            </button>
                        </div>
                            <form action="${pageContext.request.contextPath}/admin/ticketManager/update" method="post"
                                  id="update-hide-${ticket.id}">
                                <input type="hidden" name="id" value="${ticket.id}">
                                <input type="hidden" name="action" value="HIDE">
                            </form>
                            <form action="${pageContext.request.contextPath}/admin/ticketManager/update" method="post"
                                  id="update-show-${ticket.id}">
                                <input type="hidden" name="id" value="${ticket.id}">
                                <input type="hidden" name="action" value="SHOW">
                            </form>
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
                           href="${pageContext.request.contextPath}/admin/ticketManager?page=${requestScope.page - 1}">
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
                                       href="${pageContext.request.contextPath}/admin/ticketManager?page=${i}">
                                            ${i}
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <li class="page-item ${requestScope.page == requestScope.totalPages ? 'disabled' : ''}">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/ticketManager?page=${requestScope.page + 1}">
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
