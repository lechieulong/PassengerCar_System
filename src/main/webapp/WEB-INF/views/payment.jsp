<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 7/8/2023
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Trang chu</title>
  <jsp:include page="_metaAdmin.jsp"/>

  <style>
    .person_infor {
      padding: 2rem;
      box-shadow: rgba(50, 50, 93, 0.25) 0px 50px 100px -20px,
      rgba(0, 0, 0, 0.3) 0px 30px 60px -30px,
      rgba(10, 37, 64, 0.35) 0px -2px 6px 0px inset;
    }
    .ticket_infor {
      border-bottom: 1px solid black;
    }
    .guide_ticket {
      padding: 2rem;
      box-shadow: rgba(149, 157, 165, 0.2) 0px 8px 24px;
    }
    .guide_infor {
      border-bottom: 1px solid black;
    }
    .guide_infor h6 {
      font-size: 22px;
      font-weight: 600;
      background-image: linear-gradient(to left, #553c9a, #b393d3);
      color: transparent;
      background-clip: text;
      -webkit-background-clip: text;
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
      box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
      7px 7px 20px 0px rgba(0,0,0,.1),
      4px 4px 5px 0px rgba(0,0,0,.1);
      outline: none;
    }


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


    /* 3 */
    .btn-3 {
      background: rgb(0,172,238);
      background: linear-gradient(0deg, rgba(0,172,238,1) 0%, rgba(2,126,251,1) 100%);
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
      background: rgba(2,126,251,1);
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
    .btn-3:hover{
      background: transparent;
      box-shadow: none;
      color:brown;

    }
    .btn-3:hover:before {
      height: 100%;
    }
    .btn-3:hover:after {
      width: 100%;
    }
    .btn-3 span:hover{
      color: rgba(2,126,251,1);
    }
    .btn-3 span:before,
    .btn-3 span:after {
      position: absolute;
      content: "";
      left: 0;
      bottom: 0;
      background: rgba(2,126,251,1);
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
<%--                                <li>--%>
<%--                                <c:if test="${empty sessionScope.currentUser}">--%>
<%--                                  <a href="${pageContext.request.contextPath}/client/signin">Đăng nhập</a>--%>
<%--                                </c:if>--%>
<%--                                <li>--%>
                                </li>
                                <c:if test="${not empty sessionScope.currentUser}">
                                    <span class="icon-user"></span>
                                </c:if>
                                </li>

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

<section class="container ">

    </form>
  <div class="row mt-5 gap-4">
      <form action="${pageContext.request.contextPath}/vnpayajax" id="frmCreateOrder" method="post" class="w-100">
        <div class="col-md-4 person_infor">
          <h5 class="mb-4 text-center">Thông tin vé</h5>
          <div class="form-group">
            <div class="ticket_infor">
              <small>Họ và tên:</small>
              <p>${requestScope.user.fullName}</p>
            </div>
            <div class="ticket_infor">
              <small> Điểm lên xe </small>
              <p>${requestScope.trips.pickUpPoint}</p>
            </div>
            <div class="ticket_infor">
              <small> Điểm xuống  xe </small>
              <p>${requestScope.trips.dropOffPoint}</p>
            </div>
            <div class="ticket_infor">
              <small>tên xe:</small>
              <p>${requestScope.trips.nameOfTransport}</p>
            </div>
            <div class="ticket_infor">
              <small>Chuyến:</small>
              <p> ${requestScope.trips.routeName}</p>
            </div>
            <div class="ticket_infor">
              <small>Số lượng ghế:</small>
              <p>${requestScope.quantity}</p>
            </div>
            <div class="ticket_infor">
              <small>Chi phí:</small>
              <input <fmt:formatNumber value="${requestScope.totalPrice} VND" type="currency" currencyCode="VND" />
            </div>
              <input name="amount" value="${requestScope.totalPrice}" type="hidden">
              <input name="quantity" value="${requestScope.quantity}" type="hidden" >
              <input name="tripsID" value="${requestScope.trips.tripsTransportId}"  type="hidden" >
              <button type="submit" class="btn btn-primary w-100 mt-3">Thanh toán</button>
          </div>
        </div>

      </form>

  </div>
</section>

<jsp:include page="_footerClient.jsp" />
<script>
    $("#frmCreateOrder").submit(function () {
        var postData = $("#frmCreateOrder").serialize();
        var submitUrl = $("#frmCreateOrder").attr("action");
        $.ajax({
            type: "POST",
            url: submitUrl,
            data: postData,
            dataType: 'JSON',
            success: function (x) {
                if (x.code === '00') {
                    if (window.vnpay) {
                        vnpay.open({width: 768, height: 600, url: x.data});
                    } else {
                        location.href = x.data;
                    }
                    return false;
                } else {
                    alert(x.Message);
                }
            }
        });
        return false;
    });
</script>
</body>
</html>
