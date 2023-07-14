<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Trang chu</title>
  <jsp:include page="_metaAdmin.jsp"/>
  <style>

    /* 5 */
    .btn-5 {
      width: 130px;
      height: 40px;
      line-height: 42px;
      padding: 0;
      border: none;
      background: rgb(255,27,0);
      background: linear-gradient(0deg, rgba(255,27,0,1) 0%, rgba(251,75,2,1) 100%);
    }
    .btn-5:hover {
      color: #f0094a;
      background: transparent;
      box-shadow:none;
    }
    .btn-5:before,
    .btn-5:after{
      content:'';
      position:absolute;
      top:0;
      right:0;
      height:2px;
      width:0;
      background: #f0094a;
      box-shadow:
              -1px -1px 5px 0px #fff,
              7px 7px 20px 0px #0003,
              4px 4px 5px 0px #0002;
      transition:400ms ease all;
    }
    .btn-5:after{
      right:inherit;
      top:inherit;
      left:0;
      bottom:0;
    }
    .btn-5:hover:before,
    .btn-5:hover:after{
      width:100%;
      transition:800ms ease all;
    }
    .custom-btn {
      width: 130px;
      height: 40px;
      color: #fff;
      border-radius: 5px;
      padding: 10px 80px;
      font-family: 'Lato', sans-serif;
      font-weight: 500;
      background: transparent;
      cursor: pointer;
      transition: all 0.3s ease;
      position: relative;
      display: inline-block;
      box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
      7px 7px 20px 0px rgba(0,0,0,.1),
      4px 4px 5px 0px rgba(0,0,0,.1);
      outline: none;
    }

  </style>

</head>
<body>
<div class="page-wrapper">

  <!-- Main Header-->
  <header class="main-header">
    <!-- Header Upper -->
    <div class="header-upper">
      <div class="outer-container">
        <div class="inner-container clearfix">
          <div class="pull-left logo-box">
            <div class="logo">
              <a href="index.html"
              ><img src="images/cover.png" alt="" title=""
              /></a>
            </div>
          </div>

          <div class="nav-outer pull-left clearfix">
            <!-- Mobile Navigation Toggler -->
            <div class="mobile-nav-toggler">
              <span class="icon ti-menu"></span>
            </div>
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
                  <c:if test="${not empty sessionScope.currentUser}">
                    <li>
                      <a href="${pageContext.request.contextPath}/signout" >
                          <p>Đăng xuất</p>
                      </a>
                    </li>
                  </c:if>

                </ul>
              </div>
            </nav>
          </div>

          <!-- Outer Box -->
          <div class="outer-box clearfix">
            <!-- Mobile Navigation Toggler -->
            <div class="mobile-nav-toggler">
              <span class="icon ion-android-menu"></span>
            </div>
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
        <div class="nav-logo">
          <a href="index.html"
          ><img src="images/cover.png" alt="" title=""
          /></a>
        </div>
        <div class="menu-outer">
          <!--Here Menu Will Come Automatically Via Javascript / Same Menu as in Header-->
        </div>
      </nav>
    </div>
    <!-- End Mobile Menu -->
  </header>
  <!--End Main Header -->

  <!-- Banner Section -->
  <section class="banner-section">
    <div class="main-slider-carousel owl-carousel owl-theme">
      <div
              class="slide"
              style="background-image: url(${pageContext.request.contextPath}/img/leaderboard1.jpg)"
      >
        <div class="p-5 text-center text-white">
          <h3>BẠN MUỐN ĐI ĐÂU?</h3>
        </div>
        <div class="container">
          <!-- Content Boxed -->
          <div class="content-boxed">
            <form class="p-4 bg-light"  method="GET" action="${pageContext.request.contextPath}/transport">
              <div class="d-flex justify-content-around route-form">
                <!-- Destination -->
                <div class="d-flex p-3 w-75 justify-content-between">
                  <div>
                    <label>Điểm đi</label>
                    <div>
                      <i class="fab fa-xing"></i>
                      <select name="pickUpPoint">
                        <c:forEach var="city" varStatus="loop" items="${requestScope.cityFromServer}">
                          <option value="${city.id}">${city.name}</option>
                        </c:forEach>

                      </select>
                    </div>
                  </div>
                  <div class="">
                    <label>Điểm đến</label>
                    <div>
                      <i class="fab fa-yandex-international"></i>
                      <select name="dropOffPoint">
                        <c:forEach var="city" varStatus="loop" items="${requestScope.cityFromServer}">
                          <option value="${city.id}">${city.name}</option>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
                  <div class="flatpickr-date-wrapper">
                    <label class="">Ngày bắt đầu đi </label>
                    <div class="">
                      <input type="text" id="datePicker" placeholder="Pick day here!!! "  name="date" readonly="readonly"/>
                    </div>
                  </div>
                  <div class="d-flex justify-content-center align-items-center">
                    <button type="submit" class="btn  btn-success">Tìm Chuyến</button>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- End Banner Section -->
  <!-- Project Section -->
  <section class="project-section">
    <!-- Project Tabs -->
    <div class="project-tab">
      <div class="auto-container">
        <div class="tab-btns-box">
          <!--Tabs Header-->
          <div class="tabs-header">
            <div class="clearfix">
              <div class="pull-left">
                <!-- Sec Title -->
                <div class="sec-title">
                  <h2>Các Tuyến nổi bật </h2>
                </div>
              </div>
              <div class="pull-left ml-5">
                <ul class="d-flex text-black-50">
                  <a href="${pageContext.request.contextPath}/allTripPopular">
                  <li class="nav-link fs-5" >
                    TẤT CẢ
                  </li>
                  </a>
                  <a href="${pageContext.request.contextPath}/sortMorning"> <li class="nav-link fs-5"> BUỔI SÁNG  </li>     </a>
                  <a href="${pageContext.request.contextPath}/sortAfternoon"><li class="nav-link fs-5"> BUỔI TRƯA  </li>  </a>
                  <a href="${pageContext.request.contextPath}/sortNight"> <li class="nav-link fs-5"> BUỔI TỐI </li>   </a>
                </ul>
              </div>
              <div class="pull-right">

              </div>
            </div>
          </div>
        </div>
      </div>

      <!--Tabs Content-->
      <div class="p-tabs-content">
        <!-- Portfolio Tab / Active Tab -->
        <div class="p-tab active-tab" id="p-tab-1">
          <div class="project-carousel owl-theme owl-carousel">
            <!-- Gallery Block -->
            <c:if test="${fn:length(requestScope.tripFromServer) >= 1}">

            <c:forEach var="trips" varStatus="loop" items="${requestScope.tripFromServer}">
              <div class="gallery-block">
                <div class="inner-box">
                  <div class="image">
                    <img src="${pageContext.request.contextPath}/image/${trips.imageName}" style="height: 500px;" alt="" />
                    <div class="overlay-box">
                      <div class="content">
                        <div class="category">
                            ${trips.nameOfTransport} <br />
                            ${trips.timeOfTrips}
                          <br />

                        </div>
                        <h2>
                          <a href="${pageContext.request.contextPath}/confirmServlet?id=${trips.tripsTransportId}">    ${trips.tripName}</a>
                        </h2>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
            </c:if>


          </div>
          <c:if test="${fn:length(requestScope.tripFromServer) <= 0}">
            <h3 class="text-center">Không có chuyến nào</h3>
          </c:if>
        </div>
      </div>
    </div>
  </section>
  <!-- End Project Section -->


  <!-- Footer -->
  <footer class="text-center text-lg-start bg-white text-muted">
    <!-- Section: Social media -->
    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
      <!-- Left -->
      <div class="me-5 d-none d-lg-block">
        <span>Get connected with us on social networks:</span>
      </div>
      <!-- Left -->

      <!-- Right -->
      <div>
        <a href="" class="me-4 link-secondary">
          <i class="fab fa-facebook-f"></i>
        </a>
        <a href="" class="me-4 link-secondary">
          <i class="fab fa-twitter"></i>
        </a>
        <a href="" class="me-4 link-secondary">
          <i class="fab fa-google"></i>
        </a>
        <a href="" class="me-4 link-secondary">
          <i class="fab fa-instagram"></i>
        </a>
        <a href="" class="me-4 link-secondary">
          <i class="fab fa-linkedin"></i>
        </a>
        <a href="" class="me-4 link-secondary">
          <i class="fab fa-github"></i>
        </a>
      </div>
      <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
      <div class="container text-center text-md-start mt-5">
        <!-- Grid row -->
        <div class="row mt-3">
          <!-- Grid column -->
          <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
            <!-- Content -->
            <h6 class="text-uppercase fw-bold mb-4">
              <i class="fas fa-gem me-3 text-secondary"></i>Company name
            </h6>
            <p>
              Here you can use rows and columns to organize your footer content. Lorem ipsum
              dolor sit amet, consectetur adipisicing elit.
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">
              Products
            </h6>
            <p>
              <a href="#!" class="text-reset">Angular</a>
            </p>
            <p>
              <a href="#!" class="text-reset">React</a>
            </p>
            <p>
              <a href="#!" class="text-reset">Vue</a>
            </p>
            <p>
              <a href="#!" class="text-reset">Laravel</a>
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">
              Useful links
            </h6>
            <p>
              <a href="#!" class="text-reset">Pricing</a>
            </p>
            <p>
              <a href="#!" class="text-reset">Settings</a>
            </p>
            <p>
              <a href="#!" class="text-reset">Orders</a>
            </p>
            <p>
              <a href="#!" class="text-reset">Help</a>
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
            <p><i class="fas fa-home me-3 text-secondary"></i> New York, NY 10012, US</p>
            <p>
              <i class="fas fa-envelope me-3 text-secondary"></i>
              info@example.com
            </p>
            <p><i class="fas fa-phone me-3 text-secondary"></i> + 01 234 567 88</p>
            <p><i class="fas fa-print me-3 text-secondary"></i> + 01 234 567 89</p>
          </div>
          <!-- Grid column -->
        </div>
        <!-- Grid row -->
      </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.025);">
      © 2021 Copyright:
      <a class="text-reset fw-bold" href="https://mdbootstrap.com/">MDBootstrap.com</a>
    </div>
    <!-- Copyright -->
  </footer>
  <!-- Footer -->
  <%--  end popular  trip--%>
</div>

<script type="text/javascript">
  flatpickr("#datePicker", {
    minDate: "today",
    dateFormat: "Y-m-d"
  });

  document.getElementById("datePickerButton").addEventListener("click", function() {
    document.getElementById("datePicker")._flatpickr.open();
  });


</script>
<script src="${pageContext.request.contextPath}/js/jquery.js" ></script>
<script src="${pageContext.request.contextPath}/js/popper.min.js" ></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
<script src="${pageContext.request.contextPath}/js/jquery.mCustomScrollbar.concat.min.js" ></script>
<script src="${pageContext.request.contextPath}/js/jquery.fancybox.js" ></script>
<script src="${pageContext.request.contextPath}/js/appear.js" ></script>
<script src="${pageContext.request.contextPath}/js/owl.js" ></script>
<script src="${pageContext.request.contextPath}/js/wow.js"></script>
<script src="${pageContext.request.contextPath}/js/parallax.min.js" ></script>
<script src="${pageContext.request.contextPath}/js/tilt.jquery.min.js"  ></script>
<script src="${pageContext.request.contextPath}/js/jquery.paroller.min.js"  ></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js" ></script>
<script src="${pageContext.request.contextPath}/js/script.js"  ></script>
</body>
</html>
