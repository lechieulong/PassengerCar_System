<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:parseDate value="${objectType.departTime}" var="departDate" pattern="yyyy-MM-dd HH:mm:ss"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Trang chu</title>
    <jsp:include page="_metaAdmin.jsp"/>

    <style>
        body {
            font-size: .875rem;
        }

        .custom-btn {
            width: 130px;
            height: 40px;
            color: #fff;
            border-radius: 5px;
            padding: 10px 25px;
            font-family: 'Lato', sans-serif;
            font-weight: 500;
            background: transparent;
            cursor: pointer;
            transition: all 0.3s ease;
            position: relative;
            display: inline-block;
            box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5),
            7px 7px 20px 0px rgba(0, 0, 0, .1),
            4px 4px 5px 0px rgba(0, 0, 0, .1);
            outline: none;
        }

        /* 3 */
        .btn-3 {
            background: rgb(0, 172, 238);
            background: linear-gradient(0deg, rgba(0, 172, 238, 1) 0%, rgba(2, 126, 251, 1) 100%);
            width: 130px;
            height: 40px;
            line-height: 42px;
            padding: 0;
            border: none;

        }

        .btn-3 span {
            position: relative;
            display: block;
            width: 100%;
            height: 100%;
        }

        .btn-3:before,
        .btn-3:after {
            position: absolute;
            content: "";
            right: 0;
            top: 0;
            background: rgba(2, 126, 251, 1);
            transition: all 0.3s ease;
        }

        .btn-3:before {
            height: 0%;
            width: 2px;
        }

        .btn-3:after {
            width: 0%;
            height: 2px;
        }

        .btn-3:hover {
            background: transparent;
            box-shadow: none;
            color:black;
        }

        .btn-3:hover:before {
            height: 100%;
        }

        .btn-3:hover:after {
            width: 100%;
        }

        .btn-3 span:hover {
            color: rgba(2, 126, 251, 1);
        }

        .btn-3 span:before,
        .btn-3 span:after {
            position: absolute;
            content: "";
            left: 0;
            bottom: 0;
            background: rgba(2, 126, 251, 1);
            transition: all 0.3s ease;
        }

        .btn-3 span:before {
            width: 2px;
            height: 0%;
        }

        .btn-3 span:after {
            width: 0%;
            height: 2px;
        }

        .btn-3 span:hover:before {
            height: 100%;
        }

        .btn-3 span:hover:after {
            width: 100%;
        }

        /* 10 */
        .btn-10 {
            background: rgb(22, 9, 240);
            background: linear-gradient(0deg, rgba(22, 9, 240, 1) 0%, rgba(49, 110, 244, 1) 100%);
            color: #fff;
            border: none;
            transition: all 0.3s ease;
            overflow: hidden;
        }

        .btn-10:after {
            position: absolute;
            content: " ";
            top: 0;
            left: 0;
            z-index: -1;
            width: 100%;
            height: 100%;
            transition: all 0.3s ease;
            -webkit-transform: scale(.1);
            transform: scale(.1);
        }

        .btn-10:hover {
            color: #fff;
            border: none;
            background: transparent;
        }

        .btn-10:hover:after {
            background: rgb(0, 3, 255);
            background: linear-gradient(0deg, rgba(2, 126, 251, 1) 0%, rgba(0, 3, 255, 1) 100%);
            -webkit-transform: scale(1);
            transform: scale(1);
        }

        .img_transport {
        }

        .img_transport img {
            height: 16.5rem;
            width: 100%;
        }

        /*.main_content{*/
        /*    margin-left: 15rem;*/
        /*}*/
        .btn_filter {
            display: flex;
            justify-content: center;
            gap: 3rem;
        }

        .btn_filter button {
            padding-left: 2.5rem;
            padding-right: 2.5rem;
        }

        .card_trip {
            margin-left: 4rem;
            box-shadow: rgba(50, 50, 93, 0.25) 0px 30px 60px -12px, rgba(0, 0, 0, 0.3) 0px 18px 36px -18px;
        }

        .feather {
            width: 16px;
            height: 16px;
            vertical-align: text-bottom;
        }

        .sidebar {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            z-index: 100; /* Behind the navbar */
            padding: 48px 0 0; /* Height of navbar */
            box-shadow: inset 1px 0 0 rgba(0, 0, 0, .1);
        }

        @media (max-width: 767.98px) {
            .sidebar {
                top: 5rem;
            }
        }

        .sidebar-sticky {
            position: relative;
            top: 0;
            height: calc(100vh - 48px);
            padding-top: .5rem;
            overflow-x: hidden;
            overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
        }

        .sidebar .nav-link {
            font-weight: 500;
            color: #333;
        }

        .sidebar .nav-link .feather {
            margin-left: 4px;
            color: #727272;
        }

        .sidebar .nav-link.active {
            color: #2470dc;
        }

        .sidebar .nav-link:hover .feather,
        .sidebar .nav-link.active .feather {
            color: inherit;
        }

        .sidebar-heading {
            font-size: .75rem;
            text-transform: uppercase;
        }

        /*
         * Navbar
         */

        .navbar-brand {
            padding-top: .75rem;
            padding-bottom: .75rem;
            font-size: 1rem;
            background-color: rgba(0, 0, 0, .25);
            box-shadow: inset 1px 0 0 rgba(0, 0, 0, .25);
        }

        .navbar .navbar-toggler {
            top: .25rem;
            left: 1rem;
        }

        .navbar .form-control {
            padding: .75rem 1rem;
            border-width: 0;
            border-radius: 0;
        }

        .form-control-dark {
            color: #fff;
            background-color: rgba(255, 255, 255, .1);
            border-color: rgba(255, 255, 255, .1);
        }

        .form-control-dark:focus {
            border-color: transparent;
            box-shadow: 0 0 0 3px rgba(255, 255, 255, .25);
        }

        body {
            font-size: .875rem;
        }

        .feather {
            width: 16px;
            height: 16px;
            vertical-align: text-bottom;
        }

        /*
         * Sidebar
         */

        .sidebar {
            position: fixed;
            top: 0;
            /* rtl:raw:
            right: 0;
            */
            bottom: 0;
            /* rtl:remove */
            left: 0;
            z-index: 100; /* Behind the navbar */
            padding: 48px 0 0; /* Height of navbar */
            box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
        }

        @media (max-width: 767.98px) {
            .sidebar {
                top: 5rem;
            }
        }

        .sidebar-sticky {
            position: relative;
            top: 0;
            height: calc(100vh - 48px);
            padding-top: .5rem;
            overflow-x: hidden;
            overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
        }

        .sidebar .nav-link {
            font-weight: 500;
            color: #333;
        }

        .sidebar .nav-link .feather {
            margin-right: 4px;
            color: #727272;
        }

        .sidebar .nav-link.active {
            color: #2470dc;
        }

        .sidebar .nav-link:hover .feather,
        .sidebar .nav-link.active .feather {
            color: inherit;
        }

        .sidebar-heading {
            font-size: .75rem;
            text-transform: uppercase;
        }

        /*
         * Navbar
         */

        .navbar-brand {
            padding-top: .75rem;
            padding-bottom: .75rem;
            font-size: 1rem;
            background-color: rgba(0, 0, 0, .25);
            box-shadow: inset -1px 0 0 rgba(0, 0, 0, .25);
        }

        .navbar .navbar-toggler {
            top: .25rem;
            right: 1rem;
        }

        .navbar .form-control {
            padding: .75rem 1rem;
            border-width: 0;
            border-radius: 0;
        }

        .form-control-dark {
            color: #fff;
            background-color: rgba(255, 255, 255, .1);
            border-color: rgba(255, 255, 255, .1);
        }

        .form-control-dark:focus {
            border-color: transparent;
            box-shadow: 0 0 0 3px rgba(255, 255, 255, .25);
        }

        .comment_transport {
            width: 80px;
            height: 80px;
            margin-right: 1rem;
        }

        input {
            border: 0.2px solid rebeccapurple;
            border-radius: 12px;
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

        .answerCommentStyle {
            display: none;
        }
    </style>


</head>
<body>


<header
        class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom"
>
    <a
            href="/"
            class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none"
    >
        <svg
                class="bi me-2"
                width="40"
                height="32"
                role="img"
                aria-label="Bootstrap"
        >
            <use xlink:href="#bootstrap"/>
        </svg>
    </a>

    <ul
            class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0 gap-4"
    >
        <li><a href="${pageContext.request.contextPath}/" class="nav-link px-2 link-secondary"><i
                class="bi bi-house"> </i>Trang chủ</a></li>
        <li><a href="${pageContext.request.contextPath}/client/listTransport" class="nav-link px-2 link-secondary"><i
                class="bi bi-truck"> </i> Nhà xe</a></li>
        <li><a href="#" class="nav-link px-2 link-dark"> <i class="bi bi-sd-card"> </i> Vé xe</a></li>
    </ul>

    <div class="col-md-3 text-end">
        <c:if test="${empty sessionScope.currentUser}">
            <a href="${pageContext.request.contextPath}/client/signin" class="btn btn-outline-primary me-2">
                Login
            </a>
        </c:if>
        <c:if test="${empty sessionScope.currentUser}">

            <button type="button" class="btn btn-primary">Sign-up</button>
        </c:if>
        <c:if test="${not empty sessionScope.currentUser}">
            <a href="${pageContext.request.contextPath}/client/signout" class="btn btn-primary"> sign out</a>
        </c:if>
        <c:if test="${not empty sessionScope.currentUser}">
            <a href="${pageContext.request.contextPath}/setting">

            <button href="${pageContext.request.contextPath}/signout" type="button"
                    class="btn btn-outline-primary me-2"><i class="bi bi-people"></i></button>
            </a>

        </c:if>

    </div>
</header>

<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <h5 class=" d-flex justify-content-between align-items-center px-3 mt-4 mb-1 ">
                <span>Filter Condition <i class="bi bi-badge-4k-fill"></i> </span>
                <a class="link-secondary" href="#" aria-label="Add a new report">
                    <span data-feather="plus-circle"></span>
                </a>
            </h5>

            <div class="position-sticky pt-3">

                <div class="container mt-5">
                    <h6>Giá vé</h6>
                    <input type="range" min="0" max="100" value="0" class="range-slider" id="myRange">
                    <div class="d-flex justify-content-between ">
                        <small>0 đ</small>
                        <small>2.000.000 đ</small>
                    </div>
                </div>

                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-5 mb-1 text-muted">
                    <span>Tiêu Chuẩn</span>
                    <a class="link-secondary" href="#" aria-label="Add a new report">
                        <span data-feather="plus-circle"></span>
                    </a>
                </h6>

                <ul class="nav flex-column mb-2">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/sortCheapPrice">
                            <span data-feather="file-text"></span>
                            <i class="bi bi-arrow-bar-down"></i>
                            Giá rẻ nhất
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"  href="${pageContext.request.contextPath}/sortExpensivePrice">
                            <span data-feather="file-text"></span>
                            <i class="bi bi-arrow-bar-up"></i>
                            Giá đắt nhất
                        </a>
                    </li>
                    <li class="nav-item"  href="${pageContext.request.contextPath}/sortEarlyTime">
                        <a class="nav-link" href="#">
                            <span data-feather="file-text"></span>
                            <i class="bi bi-arrow-bar-up"></i>
                            sớm  nhất
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/sortLateTime">
                            <span data-feather="file-text"></span>
                            <i class="bi bi-clock-history"></i>
                            muộn nhất
                        </a>
                    </li>
                </ul>

                <ul class="nav flex-column  p-2">
                    <li class="nav-item">
                        <input class="type_choose" type="checkbox">Không cần thanh toán trước </input>
                    </li>
                    <li class="nav-item">
                        <input type="checkbox"> Chuyến có trung chuyển đón trả</input>
                    </li>
                    <li class="nav-item">
                        <input type="checkbox"> Chuyến được chọn chỗ ngồi  </input>
                    </li>
                    <li class="nav-item">
                        <input class="type_choose" type="checkbox"> Xe Limouse chất lượng</input>
                    </li>

                </ul>

            </div>
        </nav>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 ">

            <div class="table-responsive main_content">
                <div class=" p-4 btn_filter" >
                    <a href="${pageContext.request.contextPath}/sortTripXeNam"><button class="btn-3 custom-btn px-2">Xe Giường Nằm</button></a>
                  <a href="${pageContext.request.contextPath}/sortTripXeNgoi"> <button class="btn-3 custom-btn px-2">Xe ngồi </button></a>
                    <a href="${pageContext.request.contextPath}/sortTripByCar"> <button class="btn-3 custom-btn px-2">Uy tín nhất </button></a>
                </div>

                <p id="test"></p>
                <h5 class="container p-4"><i class="bi bi-x-diamond"> </i>Các Chuyến xe</h5>
                <c:if test="${fn:length(requestScope.tripsTransportFromServer) >= 1}">
                    <div action="${pageContext.request.contextPath}/comment" method="post">
                        <c:forEach var="objectType" varStatus="loop" items="${requestScope.tripsTransportFromServer}">
                            <div class="card mb-3 card_trip" style="max-width: 60rem;">
                                <div class="row g-0">
                                    <div class="col-md-3 img_transport">
                                        <img
                                                src="${pageContext.request.contextPath}/image/${objectType.imageName}"
                                                alt="Trendy Pants and Shoes"
                                                class="img-fluid rounded-start "
                                        />
                                    </div>
                                    <div class="col-md-8">
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between">
                                                <h5 class="card-title">${objectType.nameOfTransport}</h5>
                                                <p class="card-text">
                                                    <fmt:formatNumber value="${objectType.price}" type="currency"
                                                                      currencyCode="VND"/>
                                                </p>
                                            </div>
                                            <p class="card-text">
                                                <small class="text-muted">Mát lạnh, </small>

                                            </p>
                                            <div class="d-flex justify-content-between ">
                                                <p> ${objectType.routeName}</p>
                                                <p>
                                                    <i class="bi bi-clock"></i> ${objectType.departTime.substring(11, 16)}
                                                </p>

                                            </div>
                                            <div class="d-flex justify-content-between mt-3 mb-4">
                                                <p>Ghế trống: ${objectType.emptySeat} / ${objectType.totalSeat}</p>
                                                <p><i class="bi bi-table"></i> ${objectType.departTime.substring(0, 11)}
                                                </p>
                                            </div>
                                            <input type="hidden" name="tripsTransportId"
                                                   value="${objectType.tripsTransportId}">
                                            <div class="d-flex justify-content-between ">
                                                <a href="${pageContext.request.contextPath}/confirmServlet?id=${objectType.tripsTransportId}"
                                                   target="_blank">
                                                        <button class="btn btn-primary " type="button" >Đặt vé</button>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:forEach>

                    </div>
                </c:if>
                <c:if test="${fn:length(requestScope.tripsTransportFromServer) == 0}">
                    <p class="text-center mt-5">Không có chuyến nào, Sorry!!</p>
                    <div class="text-center">
                        <a href="${pageContext.request.contextPath}/" class="custom-btn btn-3"><i
                                class="bi bi-back"> </i>Tìm Chuyến lại </a>
                    </div>
                </c:if>
            </div>
        </main>
    </div>
</div>

<script>
    function showAnswer() {
        var answerComment = document.getElementsByClassName('answerCommentStyle');

        if (answerComment.style.display === "none") {
            answerComment.style.display = "block";
        } else {
            answerComment.style.display = "none";
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
