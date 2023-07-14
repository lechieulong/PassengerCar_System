<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Comment trip </title>
    <jsp:include page="_metaAdmin.jsp"/>
    <style>
        .comment_transport {
            width: 50px;
            height: 50px;
            margin-right: 1rem;
        }

        input {
            border: 0.2px solid rebeccapurple;
            border-radius: 12px;
            padding: 6px 12px;
            background: #ddd;
        }

        .comment_items{
            box-shadow: rgba(0, 0, 0, 0.16) 0px 3px 6px, rgba(0, 0, 0, 0.23) 0px 3px 6px;
        }
        input:hover {
            box-shadow: rgba(0, 0, 0, 0.1) 0px 4px 12px;
        }

        input:focus {
            color: black;
            box-shadow: rgba(0, 0, 0, 0.1) 20px 24px 60px;
        }

        input::placeholder {
            text-shadow: rgba(0, 0, 0, 0.1) 0px 4px 12px;
        }

        #answerComment {
            display: none;
        }

        .wrapper .outer{

            margin-left: 17rem;
            height: 135px;
            width: 135px;
            overflow: hidden;
        }
        .outer .emojis{
            height: 500%;
            display: flex;
            flex-direction: column;
        }
        .outer .emojis li{
            height: 20%;
            width: 100%;
            list-style: none;
            transition: all 0.3s ease;
        }
        .outer li img{
            height: 100%;
            width: 100%;
        }
        #star-2:checked ~ .content .emojis .slideImg{
            margin-top: -135px;
        }
        #star-3:checked ~ .content .emojis .slideImg{
            margin-top: -270px;
        }
        #star-4:checked ~ .content .emojis .slideImg{
            margin-top: -405px;
        }
        #star-5:checked ~ .content .emojis .slideImg{
            margin-top: -540px;
        }
        .wrapper .stars{
            margin-top: 30px;
        }
        .stars label{
            font-size: 30px;
            margin: 0 3px;
            color: #ccc;
        }
        #star-1:hover ~ .content .stars .star-1,
        #star-1:checked ~ .content .stars .star-1,

        #star-2:hover ~ .content .stars .star-1,
        #star-2:hover ~ .content .stars .star-2,
        #star-2:checked ~ .content .stars .star-1,
        #star-2:checked ~ .content .stars .star-2,

        #star-3:hover ~ .content .stars .star-1,
        #star-3:hover ~ .content .stars .star-2,
        #star-3:hover ~ .content .stars .star-3,
        #star-3:checked ~ .content .stars .star-1,
        #star-3:checked ~ .content .stars .star-2,
        #star-3:checked ~ .content .stars .star-3,

        #star-4:hover ~ .content .stars .star-1,
        #star-4:hover ~ .content .stars .star-2,
        #star-4:hover ~ .content .stars .star-3,
        #star-4:hover ~ .content .stars .star-4,
        #star-4:checked ~ .content .stars .star-1,
        #star-4:checked ~ .content .stars .star-2,
        #star-4:checked ~ .content .stars .star-3,
        #star-4:checked ~ .content .stars .star-4,

        #star-5:hover ~ .content .stars .star-1,
        #star-5:hover ~ .content .stars .star-2,
        #star-5:hover ~ .content .stars .star-3,
        #star-5:hover ~ .content .stars .star-4,
        #star-5:hover ~ .content .stars .star-5,
        #star-5:checked ~ .content .stars .star-1,
        #star-5:checked ~ .content .stars .star-2,
        #star-5:checked ~ .content .stars .star-3,
        #star-5:checked ~ .content .stars .star-4,
        #star-5:checked ~ .content .stars .star-5{
            color: #fd4;
        }
        .wrapper .footer{
            border-top: 1px solid #ccc;
            background: #f2f2f2;
            width: 100%;
            height: 55px;
            padding: 0 20px;
            border-radius: 0 0 10px 10px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        .footer span{
            font-size: 17px;
            font-weight: 400;
        }
        .footer .text::before{
            content: "Rate your experience";
        }
        .footer .numb::before{
            content: "0 out of 5";
        }
        #star-1:checked ~ .footer .text::before{
            content: "I just hate it";
        }
        #star-1:checked ~ .footer .numb::before{
            content: "1 out of 5";
        }
        #star-2:checked ~ .footer .text::before{
            content: "I don't like it";
        }
        #star-2:checked ~ .footer .numb::before{
            content: "2 out of 5";
        }
        #star-3:checked ~ .footer .text::before{
            content: "This is awesome";
        }
        #star-3:checked ~ .footer .numb::before{
            content: "3 out of 5";
        }
        #star-4:checked ~ .footer .text::before{
            content: "I just like it";
        }
        #star-4:checked ~ .footer .numb::before{
            content: "4 out of 5";
        }
        #star-5:checked ~ .footer .text::before{
            content: "I just love it";
        }
        #star-5:checked ~ .footer .numb::before{
            content: "5 out of 5";
        }
        input[type="radio"]{
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
        <section class="gradient-custom">
            <div class="container ">
                <div class="row d-flex justify-content-center">
                    <div class="col-md-12 col-lg-10 col-xl-8">
                        <div class="card">
                            <div class="card-body p-4">
                                <h4 class="text-center mb-4 pb-2">Đánh giá</h4>
                                <div class="row">
                                    <%-- form here--%>
                                    <form class="col" action="${pageContext.request.contextPath}/comment" method="post">

                                        <div class="wrapper text-center">
                                            <input type="radio" name="ratingScore" id="star-1" value="1">
                                            <input type="radio" name="ratingScore" id="star-2" value="2">
                                            <input type="radio" name="ratingScore" id="star-3" value="3">
                                            <input type="radio" name="ratingScore" id="star-4" value="4">
                                            <input type="radio" name="ratingScore" id="star-5" value="5">
                                            <div class="content">
                                                <div class="outer">
                                                    <div class="emojis ">
                                                        <li class="slideImg"><img src="${pageContext.request.contextPath}/img/emoji-1.png" alt=""></li>
                                                        <li><img src="${pageContext.request.contextPath}/img/emoji-2.png" alt=""></li>
                                                        <li><img src="${pageContext.request.contextPath}/img/emoji-3.png" alt=""></li>
                                                        <li><img src="${pageContext.request.contextPath}/img/emoji-4.png" alt=""></li>
                                                        <li><img src="${pageContext.request.contextPath}/img/emoji-5.png" alt=""></li>
                                                    </div>
                                                </div>
                                                <div class="stars">
                                                    <label for="star-1" class="star-1 fas fa-star">1</label>
                                                    <label for="star-2" class="star-2 fas fa-star">2</label>
                                                    <label for="star-3" class="star-3 fas fa-star">3</label>
                                                    <label for="star-4" class="star-4 fas fa-star">4</label>
                                                    <label for="star-5" class="star-5 fas fa-star">5</label>
                                                </div>
                                            </div>
                                            <div class="footer mb-3">
                                                <span class="text"></span>
                                                <span class="numb"></span>
                                            </div>
                                        </div>

<%--                                        <select class="starReview ${not empty sessionScope.violations.ratingScoreViolations ? 'is-invalid' : (not empty sessionScope.values.ratingScore ? 'is-valid' : '')}"--%>
<%--                                                name="ratingScore">--%>
<%--                                            <c:forEach var="i" begin="1" end="5">--%>
<%--                                                <option value="${i}" ${sessionScope.values.ratingScore == i ? 'selected' : ''}>${i}</option>--%>
<%--                                            </c:forEach>--%>
<%--                                        </select>--%>

                                        <div class=" mb-5 w-100 d-flex justify-content-between">
                                            <img class="rounded-circle shadow-1-strong mr-2 "
                                                 src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"
                                                 alt="avatar"
                                                 width="50" height="50"/>
                                            <input class="w-75" type="text"  name="content"
                                                    placeholder="Nhập comment ở đây nè !!"/>
                                            <button type="submit" class="btn btn-success">Đánh giá </button>
                                        </div>
                                        <input type="hidden" value="${requestScope.ticketId}"
                                               name="ticketId">
                                        <input type="hidden" value="${requestScope.user.id}"
                                               name="userID">
                                        <c:if test="${fn:length(requestScope.listComment) >= 1}">
                                            <c:forEach var="comment" varStatus="loop"
                                                       items="${requestScope.listComment}">
                                                <div class="d-flex flex-start p-3  mb-2 comment_items">
                                                    <img class="rounded-circle shadow-1-strong comment_transport"
                                                         src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(11).webp"
                                                         alt="avatar"
                                                    />
                                                    <div class="flex-grow-1 flex-shrink-1">
                                                        <div>
                                                            <div class="d-flex justify-content-between align-items-center">
                                                                <p class="mb-1">
                                                                        ${comment.fullName}
                                                                            <span class="small">- 2 hours ago</span>
                                                                </p>
                                                            </div>
                                                            <p class="small mb-0">
                                                                    ${comment.content}
                                                            </p>
                                                        </div>
                                                            <%--                                                    answerComment--%>
<%--                                                        <c:forEach var="answer" varStatus="loop"--%>
<%--                                                                   items="${requestScope.answerComment}">--%>
<%--                                                            <c:if test="${comment.id == answer.commentID}">--%>
<%--                                                                <div class="d-flex flex-start mt-4 ">--%>
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
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${fn:length(requestScope.listComment) ==0 }">
                                            <p>No comment </p>
                                        </c:if>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
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
