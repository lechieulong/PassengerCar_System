<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="departTime" value="${requestScope.trips.tripsTransportDepartTime}"/>
<fmt:parseDate var="parsedDate" value="${departTime}" pattern="yyyy-MM-dd HH:mm:ss"/>

<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Trang chu</title>
    <jsp:include page="_metaAdmin.jsp"/>
    <title>Title</title>


    <style>
        .discount{
            background-color: #bfd1ec;
            border-radius: 5px;
        }
        input[type=number]::-webkit-inner-spin-button,
        input[type=number]::-webkit-outer-spin-button {
            opacity: 1;
        }

        input[type=number]::-webkit-outer-spin-button,
        input[type=number]::-webkit-inner-spin-button {
            -webkit-appearance: inner-spin-button !important;
            width: 60px;
            position: absolute;
            top: 0;
            right: 0;
            height: 100%;
            color: red;
        }
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            text-align: center;
        }

        .card {
            border: 1px solid #ccc;
            border-radius: 8px;
            margin-top: 20px;
        }

        .price {
            position: absolute;
            top: 10px;
            right: 10px;
            font-weight: bold;
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
                                    <a href="${pageContext.request.contextPath}/ticketModifie">Vé</a>
                                </li>
                                <li><a href="#">Liên hệ</a></li>
                                <c:if test="${empty sessionScope.currentUser}">
                                    <li><a href="${pageContext.request.contextPath}/client/signin">Đăng nhập</a></li>
                                </c:if>
                                <c:if test="${not empty sessionScope.currentUser}">
                                    <span class="icon-user"></span>
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


<header class="section-heading py-4">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6 text-center">
                <h3 class="section-title">Xác nhận vé </h3>
            </div>
        </div>
    </div>
</header>
<form id="paymentForm" action="${pageContext.request.contextPath}/payment" method="GET">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card p-4">
                    <div class="row">
                        <div class="col-md-4 d-flex align-items-center">
                            <img src="${pageContext.request.contextPath}/image/${requestScope.trips.imageName}"
                                 alt="Hình ảnh ở đây" class="img-fluid">
                        </div>
                        <div class="col-md-8">
                            <div id="price" class="price">Giá tiền:
                                <fmt:formatNumber value="${requestScope.seatTransport.price}" type="number"
                                                  pattern="#,### VNĐ"/>
                            </div>
                            <h5 class="card-title">${requestScope.trips.nameOfTransport}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${requestScope.trips.name}</h6>
                            <p class="card-text">Ngày khởi hành: <fmt:formatDate value="${parsedDate}"
                                                                                 pattern="dd-MM-yyyy"/></p>
                            <p class="card-text">Giờ khởi hành: <fmt:formatDate value="${parsedDate}"
                                                                               pattern="HH:mm:ss"/></p>
                            <p class="card-text">Số lượng ghế:</p>
                            <div class="input-group">
                                <button type="button" onclick="decreaseQuantity()" class="btn btn-primary btn-sm">-
                                </button>
                                <input type="text" id="quantity" min="0" max="${requestScope.trips.emptySeat}"
                                       class="form-control" name="quantity" value="1">
                                <button type="button" onclick="increaseQuantity()" class="btn btn-primary btn-sm">+
                                </button>
                            </div>
                            <c:if test="${not empty requestScope.violations.quantity}">
                                <div class="invalid-feedback">
                                    <ul class="list-unstyled">
                                        <c:forEach var="violation" items="${requestScope.violations.quantity}">
                                            <li>${violation}</li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </c:if>
                            <label for="totalPrice">Tổng tiền</label>
                            <input type="text" id="totalPrice" class="form-control" name="totalPrice" value="${requestScope.seatTransport.price}"
                                   readonly>
                            <div class="mt-4">
                                <p>HIện tại bạn có   điểm tích lũy</p>
                                <label class="mr-5 text-capitalize text-warning">Discount</label>
                                <input class="p-2 ml-5 discount " type="number" id="discountNumber" name="discount" min="0" max="20" value="0" onclick="discountPrice()">
                                <br/><small class="text-success" id="message_discount"></small>
                            </div>

                            <input type="hidden" name="price" value="${requestScope.seatTransport.price}">
                            <input type="hidden" name="seatTransportId" value="${requestScope.seatTransport.id}">
                            <input type="hidden" name="nameTransport" value="${requestScope.trips.nameOfTransport}">
                            <input type="hidden" name="tripsTransportId" value="${requestScope.trips.tripsTransportId}">
                            <input type="hidden" id="inputQuantity" name="quantity" value="0">
                            <input type="hidden" name="tripName" value="${requestScope.trips.name}">
                            <input type="hidden" name="dateDepart"
                                   value="<fmt:formatDate value="${parsedDate}" pattern="dd-MM-yyyy" />">
                            <button type="submit" class="btn btn-primary mt-3" >Xác nhận</button>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>


<jsp:include page="_footerClient.jsp"/>

<script>
    function increaseQuantity() {
        const quantityInput = document.getElementById("quantity");
        const currentQuantity = parseInt(quantityInput.value);

        if (currentQuantity < parseInt(quantityInput.max)) {
            quantityInput.value = currentQuantity + 1;
        }
        updateTotalPrice();
    }

    function decreaseQuantity() {
        const quantityInput = document.getElementById("quantity");
        const currentQuantity = parseInt(quantityInput.value);
        if (currentQuantity > parseInt(quantityInput.min)) {
            quantityInput.value = Math.max(currentQuantity - 1, 0);
        }
        updateTotalPrice();
    }

    function updateTotalPrice() {
        const quantity = parseInt(document.getElementById("quantity").value);
        const price = parseInt(document.getElementById("price").innerText.replace(/\D/g, ''));
        const totalPrice = quantity * price;
        // const formattedTotalPrice = formatPrice(totalPrice);

        document.getElementById("totalPrice").value = totalPrice;
        document.getElementById("inputQuantity").value = quantity;
    }

    function formatPrice(price) {
        return price.toLocaleString("vi-VN");
    }

    function discountPrice(){
        const discountNumber = parseInt(document.getElementById("discountNumber").value);
        const quantity = parseInt(document.getElementById("quantity").value);
        const price = parseInt(document.getElementById("price").innerText.replace(/\D/g, ''));
        const message_discount = document.getElementById("message_discount");

        const totalPrice = quantity * price;

        const discountPrice = totalPrice * (discountNumber / 100);
        const finalPrice = totalPrice - discountPrice;
        const message = "bạn đã được giảm "+discountNumber + "%";

        document.getElementById("message_discount").innerText = message;
        document.getElementById("totalPrice").value = finalPrice;
        document.getElementById("inputQuantity").value = quantity;
    }


</script>
</body>
</html>
