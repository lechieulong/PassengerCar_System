<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Detail Transport </title>
    <jsp:include page="_metaAdmin.jsp"/>
    <style>
        .comment_transport {
            width: 80px;
            height: 80px;
            margin-right: 1rem;
        }

        input {
            border: 0.2px solid rebeccapurple;
            border-radius: 12px;
            padding: 6px 12px;
            background: #ddd;
        }

        input:hover {
            box-shadow: rgba(0, 0, 0, 0.1) 0px 4px 12px;
        }

        input:focus {
            background: lightblue;
            color: black;
            box-shadow: rgba(0, 0, 0, 0.1) 20px 24px 60px;
        }

        input::placeholder {
            color: rebeccapurple;
            text-shadow: rgba(0, 0, 0, 0.1) 0px 4px 12px;
        }

        #answerComment {
            display: none;
        }

    </style>
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
                                    <a href="#">Vé</a>
                                </li>
                                <li><a href="#">Liên hệ</a></li>
                                <c:if test="${empty sessionScope.currentUser}">
                                    <li><a href="${pageContext.request.contextPath}/client/signin">Đăng nhập</a></li>
                                </c:if>
                                <c:if test="${not empty sessionScope.currentUser}">
                                    <a href="${pageContext.request.contextPath}/setting">
                                        <span class="icon-user"></span>
                                    </a>
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

<!-- Project Banner Section -->
<div class="project-banner-section">
    <div class="image">
        <img src="${pageContext.request.contextPath}/img/trainStation.jpg" alt="error"/>
    </div>
</div>
<!-- End Project Banner Section -->

<!-- Project Detail Section -->
<section class="project-detail-section">
    <div class="auto-container">
        <div class="inner-container">
            <h2>${requestScope.transport.nameOfTransport}</h2>
            <p>${requestScope.transport.description}</p>
            <div class="info-boxed">
                <ul>
                    <li><span>Địa chỉ</span>131 Trần Hưng Đạo, Quảng Bình</li>
                    <li><span>Số điện thoại</span>0353346495</li>
                    <li><span>Email</span>lechieulong2016@gmail.com</li>
                    <li><span>Tổng số ghế </span> 30</li>
                </ul>
            </div>
            <h2>Ảnh </h2>
            <p></p>
        </div>

        <!-- Carousel Box -->
        <div class="carousel-box">
            <div class="single-item-carousel owl-carousel owl-theme">
                <div class="slide">
                    <div class="image">
                        <img src="${pageContext.request.contextPath}/image/${requestScope.transport.imageName}" alt=""/>
                    </div>
                </div>

            </div>
        </div>
        <!-- End Carousel Box -->
<%--        <section class="gradient-custom">--%>
<%--            <div class="container ">--%>
<%--                <div class="row d-flex justify-content-center">--%>
<%--                    <div class="col-md-12 col-lg-10 col-xl-8">--%>
<%--                        <div class="card">--%>
<%--                            <div class="card-body p-4">--%>
<%--                                <h4 class="text-center mb-4 pb-2">Đánh giá</h4>--%>
<%--                                <div class="row">--%>
<%--                                    &lt;%&ndash; form here&ndash;%&gt;--%>
<%--                                    <form class="col" action="${pageContext.request.contextPath}/comment" method="post">--%>

<%--                                        <select class="starReview ${not empty sessionScope.violations.ratingScoreViolations ? 'is-invalid' : (not empty sessionScope.values.ratingScore ? 'is-valid' : '')}"--%>
<%--                                                name="ratingScore">--%>
<%--                                            <c:forEach var="i" begin="1" end="5">--%>
<%--                                                <option value="${i}" ${sessionScope.values.ratingScore == i ? 'selected' : ''}>${i}</option>--%>
<%--                                            </c:forEach>--%>
<%--                                        </select>--%>

<%--                                        <div class=" mb-5 w-100 d-flex">--%>
<%--                                            <img class="rounded-circle shadow-1-strong mr-2 "--%>
<%--                                                 src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"--%>
<%--                                                 alt="avatar"--%>
<%--                                                 width="55" height="55"/>--%>
<%--                                            <input class="w-100" type="text"  name="content"--%>
<%--                                                    placeholder="Nhập comment ở đây nè !!"/>--%>
<%--                                            <button type="submit">Add</button>--%>
<%--                                        </div>--%>
<%--                                        <input type="hidden" value="${requestScope.tripstransportId}"--%>
<%--                                               name="tripstransportId">--%>
<%--                                        <input type="hidden" value="${requestScope.user.id}"--%>
<%--                                               name="userID">--%>
<%--                                        <c:if test="${fn:length(requestScope.listComment) >= 1}">--%>
<%--                                            <c:forEach var="comment" varStatus="loop"--%>
<%--                                                       items="${requestScope.listComment}">--%>
<%--                                                <div class="d-flex flex-start ">--%>
<%--                                                    <img class="rounded-circle shadow-1-strong comment_transport"--%>
<%--                                                         src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"--%>
<%--                                                         alt="avatar"--%>
<%--                                                    />--%>
<%--                                                    <div class="flex-grow-1 flex-shrink-1">--%>
<%--                                                        <div>--%>
<%--                                                            <div class="d-flex justify-content-between align-items-center">--%>
<%--                                                                <p class="mb-1">--%>
<%--                                                                        ${comment.fullName}<span--%>
<%--                                                                        class="small">- 2 hours ago</span>--%>
<%--                                                                </p>--%>


<%--                                                                <button type="button" onclick="showAnswer()"><i--%>
<%--                                                                        class="fas fa-reply fa-xs"></i><span--%>
<%--                                                                        class="small"> reply</span></button>--%>
<%--                                                            </div>--%>
<%--                                                            <p class="small mb-0">--%>
<%--                                                                    ${comment.content}--%>
<%--                                                            </p>--%>
<%--                                                        </div>--%>
<%--                                                            &lt;%&ndash;                                                    answerComment&ndash;%&gt;--%>
<%--                                                        <c:forEach var="answer" varStatus="loop"--%>
<%--                                                                   items="${requestScope.answerComment}">--%>
<%--                                                            <c:if test="${comment.id == answer.commentID}">--%>
<%--                                                                <div class="d-flex flex-start mt-4">--%>
<%--                                                                    <a class="me-3" href="#">--%>
<%--                                                                        <img class="rounded-circle shadow-1-strong"--%>
<%--                                                                             src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"--%>
<%--                                                                             alt="avatar"--%>
<%--                                                                             width="65" height="65"/>--%>
<%--                                                                    </a>--%>
<%--                                                                    <div class="flex-grow-1 flex-shrink-1">--%>
<%--                                                                        <div>--%>
<%--                                                                            <div class="d-flex justify-content-between align-items-center">--%>
<%--                                                                                <p class="mb-1">--%>
<%--                                                                                    Simona Disa <span class="small">- 3 hours ago</span>--%>
<%--                                                                                </p>--%>
<%--                                                                            </div>--%>
<%--                                                                            <p class="small mb-0">--%>
<%--                                                                                    ${answer.content}--%>
<%--                                                                            </p>--%>
<%--                                                                        </div>--%>
<%--                                                                    </div>--%>
<%--                                                                    <input type="text" id="answerComment">--%>
<%--                                                                </div>--%>
<%--                                                            </c:if>--%>
<%--                                                        </c:forEach>--%>
<%--                                                    </div>--%>
<%--                                                </div>--%>
<%--                                            </c:forEach>--%>
<%--                                        </c:if>--%>

<%--                                        <c:if test="${fn:length(requestScope.listComment) ==0 }">--%>
<%--                                            <p>No comment </p>--%>
<%--                                        </c:if>--%>
<%--                                    </form>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </section>--%>
    </div>
</section>
<!-- End Project Detail Section -->

<!-- New Projects Section -->
<section class="new-projects-section">
    <div class="auto-container">
        <div class="clearfix">
            <div class="pull-left">
                <a href="#"><span class="arrow icofont-rounded-left"></span> Dustin Villam, Spain</a>
            </div>
            <div class="pull-right">
                <a href="#">Cubic House <span class="arrow icofont-rounded-right"></span></a>
            </div>
        </div>
    </div>
</section>
<script>
    function showAnswer() {
        var x = document.getElementById("answerComment");
        if (x.style.display === 'none') {
            x.style.display = 'block';
        } else {
            x.style.display = 'none';
        }
    }


</script>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.fancybox.js"></script>
<script src="${pageContext.request.contextPath}/js/appear.js"></script>
<script src="${pageContext.request.contextPath}/js/owl.js"></script>
<script src="${pageContext.request.contextPath}/js/wow.js"></script>
<script src="${pageContext.request.contextPath}/js/parallax.min.js"></script>
<script src="${pageContext.request.contextPath}/js/tilt.jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.paroller.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
