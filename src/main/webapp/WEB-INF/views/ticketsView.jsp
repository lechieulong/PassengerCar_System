<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="_metaAdmin.jsp"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Quản lí chuyến xe</title>

</head>
<body>
<header class="main-header header-style-two">

    <!-- Header Upper -->
    <div class="header-upper">
        <div class="outer-container">
            <div class="inner-container clearfix">

                <div class="pull-left logo-box">
                    <div class="logo">
                        <a href="index.html">
                            <img src="images/logo-4.png" alt="" title="">
                        </a>
                    </div>
                </div>

                <div class="nav-outer pull-left clearfix">
                    <!-- Mobile Navigation Toggler -->
                    <div class="mobile-nav-toggler"><span class="icon ti-menu"></span></div>
                    <!-- Main Menu -->
                    <nav class="main-menu navbar-expand-md">
                        <div class="navbar-header">
                            <button
                                    class="navbar-toggler"
                                    type="button"
                                    data-toggle="collapse"
                                    data-target="#navbarSupportedContent"
                                    aria-controls="navbarSupportedContent"
                                    aria-expanded="false"
                                    aria-label="Toggle navigation"
                            >
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>

                        <div
                                class="navbar-collapse show collapse clearfix"
                                id="navbarSupportedContent"
                        >
                            <ul class="navigation clearfix">
                                <li class="current">
                                    <a href="${pageContext.request.contextPath}/">Trang chủ</a>
                                </li>

                                <li>
                                    <a href="${pageContext.request.contextPath}/client/listTransport">Nhà xe</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/ticket2">Vé</a>
                                </li>
                                <li><a href="#">ADMIN PAGE</a></li>
                                <c:if test="${empty sessionScope.currentUser}">
                                    <li><a href="${pageContext.request.contextPath}/client/signin">Đăng nhập</a></li>
                                </c:if>
                                <c:if test="${not empty sessionScope.currentUser}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/setting" >
                                            <span class="icon-user"></span>
                                        </a>
                                    </li>
                                </c:if>
                                </ul>
                        </div>
                    </nav>

                </div>

                <!-- Outer Box -->
                <div class="outer-box clearfix">
                    <ul class="language-list">
                        <li><a href="#">End</a></li>
                        <li><a href="#">Fra</a></li>
                    </ul>
                    <!-- Mobile Navigation Toggler -->
                    <div class="mobile-nav-toggler"><span class="icon ion-android-menu"></span></div>
                </div>

            </div>
        </div>
    </div>
    <!--End Header Upper-->

    <!-- Mobile Menu  -->
    <div class="mobile-menu">
        <div class="menu-backdrop"></div>
        <div class="close-btn"><span class="icon lnr lnr-cross"></span></div>

        <nav class="menu-box">
            <div class="nav-logo"><a href="index.html"><img src="images/logo-2.png" alt="" title=""></a></div>
            <div class="menu-outer">
                <!--Here Menu Will Come Automatically Via Javascript / Same Menu as in Header--></div>
        </nav>
    </div>
    <!-- End Mobile Menu -->

</header>


<section class="section-content">
    <div class="container">
        <main class="table-responsive-xl mb-5">
            <table class="table table-bordered table-striped table-hover align-middle">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Tên chuyến </th>
                    <th scope="col">Tên nhà xe</th>
                    <th scope="col">Thời gian bắt đầu  </th>
x                    <th scope="col">số lượng ghế</th>
                    <th scope="col" >Số tiền</th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ticket" varStatus="loop" items="${requestScope.listTicket}">
                    <tr>
                        <th scope="row">${loop.index + 1}</th>
                        <td >${ticket.routeName} </td>
                        <td >${ticket.nameOfTransport} </td>
                        <td >${ticket.timeDepart} </td>
                        <td >${ticket.quantity} </td>
                        <td >${ticket.totalPrice}</td>
                        <td >${ticket.status} </td>
                        <c:if test="${ticket.status == 0}">
                        <td>
                            <a href="${pageContext.request.contextPath}/client/detailTicket?id=${ticket.id}">
                                Xem chi tiết
                            </a>
                        </td>
                        </c:if>
                        <c:if test="${ticket.status == 1}">
                        <td>
                            <a href="${pageContext.request.contextPath}/payment2?id=${ticket.id}">
                                Thanh toán
                            </a>
                        </td>
                        </c:if>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </main>

<%--        <c:if test="${requestScope.totalPages != 0}">--%>
<%--            <nav class="mt-3 mb-5">--%>
<%--                <ul class="pagination justify-content-center">--%>
<%--                    <li class="page-item ${requestScope.page == 1 ? 'disabled' : ''}">--%>
<%--                        <a class="page-link"--%>
<%--                           href="${pageContext.request.contextPath}/admin/tripsManager?page=${requestScope.page - 1}">--%>
<%--                            Trang trước--%>
<%--                        </a>--%>
<%--                    </li>--%>

<%--                    <c:forEach begin="1" end="${requestScope.totalPages}" var="i">--%>
<%--                        <c:choose>--%>
<%--                            <c:when test="${requestScope.page == i}">--%>
<%--                                <li class="page-item active">--%>
<%--                                    <a class="page-link">${i}</a>--%>
<%--                                </li>--%>
<%--                            </c:when>--%>
<%--                            <c:otherwise>--%>
<%--                                <li class="page-item">--%>
<%--                                    <a class="page-link"--%>
<%--                                       href="${pageContext.request.contextPath}/admin/tripsManager?page=${i}">--%>
<%--                                            ${i}--%>
<%--                                    </a>--%>
<%--                                </li>--%>
<%--                            </c:otherwise>--%>
<%--                        </c:choose>--%>
<%--                    </c:forEach>--%>

<%--                    <li class="page-item ${requestScope.page == requestScope.totalPages ? 'disabled' : ''}">--%>
<%--                        <a class="page-link"--%>
<%--                           href="${pageContext.request.contextPath}/admin/tripsManager?page=${requestScope.page + 1}">--%>
<%--                            Trang sau--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--            </nav>--%>
<%--        </c:if>--%>
    </div> <!-- container.// -->
</section> <!-- section-content.// -->

<jsp:include page="_footerClient.jsp"/>

</body>
</html>
