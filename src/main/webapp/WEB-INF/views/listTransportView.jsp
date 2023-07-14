<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/25/2023
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Trang chu</title>
    <jsp:include page="_metaAdmin.jsp"/>
    <title>Title</title>

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
                                <li><a href="#">ADMIN PAGE </a></li>
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
            <div class="menu-outer"><!--Here Menu Will Come Automatically Via Javascript / Same Menu as in Header--></div>
        </nav>
    </div>
    <!-- End Mobile Menu -->

</header>
<div class="page-title-section text-center">
    <div class="auto-container">
        <h2 class="car_title">Các nhà xe </h2>
        <ul class="post-meta">
            <li><a href="index.html">trang chủ</a></li>
            <li>nhà xe</li>
        </ul>
    </div>
</div>
<!-- End Page Title Section -->

<!-- Gallery Section -->
    <section class="gallery-section">
        <div class="container">

            <!--Gallery Masonry-->
            <div class="sortable-masonry ">
                <!--Filter-->
                <div class="filters">
                    <ul class="filter-tabs filter-btns clearfix">

                        <a href="${pageContext.request.contextPath}/allCar"><li class="filter active" data-role="button" data-filter=".limouse">tất cả </li></a>
                        <a href="${pageContext.request.contextPath}/sortLieCar"><li class="filter" data-role="button" data-filter=".limouse">Xe giường nằm </li></a>
                        <a href="${pageContext.request.contextPath}/sortSitCar"><li class="filter" data-role="button" data-filter=".limouse">Xe ngồi </li></a>
                    </ul>
                </div>
                <!--transports-->
                <div class="row row-cols-1 row-cols-md-3 g-4">
                    <c:forEach var="transport" varStatus="loop" items="${requestScope.listTransport}">
                        <div class="col-md-4">
                            <div class="card h-100">
                                <img src="${pageContext.request.contextPath}/image/${transport.imageName}" class="card-img-top"
                                     alt="Skyscrapers" style="height: 300px;"/>
                                <div class="card-body text-center">
                                    <h5 class="card-title">${transport.nameOfTransport}</h5>
                                    <p class="card-text">
                                            Mô tả về xe: ${transport.description}
                                    </p>
                                    <p>Biển số xe:    ${transport.licensePlate} </p>
                                    <p>Tổng số ghế: ${transport.totalSeat}</p>
                                    <a href="${pageContext.request.contextPath}/client/transport/detail?id=${transport.id}">
                                        Xem Chi tiết
                                    </a>
                                </div>
                            </div>
                        </div>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>

</body>
</html>
