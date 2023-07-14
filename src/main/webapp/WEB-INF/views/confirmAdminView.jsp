<%--
Created by IntelliJ IDEA.
User: phudu
Date: 6/22/2023
Time: 2:23 AM
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="departTime" value="${requestScope.trips.tripsTransportDepartTime}" />
<fmt:parseDate var="parsedDate" value="${departTime}" pattern="yyyy-MM-dd HH:mm:ss" />

<html>
<head>
  <jsp:include page="_metaAdmin.jsp"/>
  <title>Title</title>



  <style>
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
<jsp:include page="_headerAdmin.jsp"/>
<header class="section-heading py-4">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-6 text-center">
        <h3 class="section-title">Xác nhận vé </h3>
      </div>
    </div>
  </div>
</header>
<form id="paymentForm" action="${pageContext.request.contextPath}/admin/ticketManager/confirm" method="POST">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-body">
            <div id="price" class="price">Giá tiền:
              <fmt:formatNumber value="${requestScope.seatTransport.price}" type="number" pattern="#,### VNĐ" />
            </div>
            <h5 class="card-title">${requestScope.trips.nameOfTransport}</h5>
            <h6 class="card-subtitle mb-2 text-muted">${requestScope.trips.name}</h6>
            <img src="${requestScope.trips.imageName}" alt="Hình ảnh ở đây" class="img-fluid">
            <p class="card-text">Ngày khởi hành: <fmt:formatDate value="${parsedDate}" pattern="dd-MM-yyyy" /></p>
            <p class="card-text">Tổng số ghế: ${requestScope.seatTransport.quantity}</p>
            <p class="card-text">Số lượng ghế:</p>
            <div class="input-group">
              <button type="button" onclick="decreaseQuantity()" class="btn btn-primary btn-sm">-</button>
              <input type="text" id="quantity" class="form-control" name="quantity" value="0">
              <button type="button" onclick="increaseQuantity()" class="btn btn-primary btn-sm">+</button>
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
            <input type="text" id="totalPrice" class="form-control" name="totalPrice" value="0 VNĐ" readonly>
            <input type="hidden" id="inputQuantity" name="quantity" value="0">
            <input type="hidden" name="price" value="${requestScope.seatTransport.price}">
            <input type="hidden" name="seatTransportId" value="${requestScope.seatTransport.id}">
            <input type="hidden" name="tripsTransportId" value="${requestScope.trips.tripsTransportId}">
            <button type="submit" class="btn btn-primary mt-3">Thanh toán</button>
            <a class="btn btn-danger mt-3" href="${pageContext.request.contextPath}/admin/tripsManager" role="button" onclick="return confirm('Bạn có muốn hủy?')">Hủy</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</form>

<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-backdrop="static">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Quét mã QR để thanh toán</h5>
        <p class="modal-title text-danger">Lưu ý: Không được bấm Hủy nếu đang trong tiến trình thanh toán</p>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <!-- Nội dung chi tiết của modal -->
        <img id="qrImage" src="${requestScope.qrDataURL}" alt="QR Code" class="img-fluid">
      </div>
      <div class="modal-footer">
        <p class="fw-semibold text-center">
          <span class="d-inline-block">Gọi điện theo hotLine để xác nhận thanh toán phía nhà xe</span><span class="text-primary ">0912345678</span>
        </p>
        <form action="${pageContext.request.contextPath}/admin/ticketManager/create" method="POST">
          <input type="hidden" name="tripstransportId" value="${requestScope.tripsTransportIdSecondReq}">
          <input type="hidden" name="seatTransportId" value="${requestScope.seatTransportId}">
          <input type="hidden" name="userId" value="${requestScope.userId}">
          <input type="hidden" name="quantity" value="${requestScope.quantity}">
          <input type="hidden" name="totalPrice" value="${requestScope.totalPrice}">
          <button  type="submit" class="btn btn-success">Chuyển tới trang quản lí vé</button>
        </form>

        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
      </div>
    </div>
  </div>
</div>

<script>
  function increaseQuantity() {
    const quantityInput = document.getElementById("quantity");
    const currentQuantity = parseInt(quantityInput.value);
    quantityInput.value = currentQuantity + 1;
    updateTotalPrice();
  }

  function decreaseQuantity() {
    const quantityInput = document.getElementById("quantity");
    const currentQuantity = parseInt(quantityInput.value);
    quantityInput.value = Math.max(currentQuantity - 1, 0);
    updateTotalPrice();
  }

  function updateTotalPrice() {
    const quantity = parseInt(document.getElementById("quantity").value);
    const price = parseInt(document.getElementById("price").innerText.replace(/\D/g, ''));
    const totalPrice = quantity * price;
    const formattedTotalPrice = formatPrice(totalPrice);

    document.getElementById("totalPrice").value = formattedTotalPrice + " VNĐ";
    document.getElementById("inputQuantity").value = quantity;
  }
  function formatPrice(price) {
    return price.toLocaleString("vi-VN");
  }

  document.addEventListener("DOMContentLoaded", function() {
    updateTotalPrice();
  });

  function removeModalBackdrop() {
    const backdrop = document.querySelector('.modal-backdrop');

    if (backdrop) {
      // Loại bỏ phần tử backdrop khỏi DOM
      backdrop.parentNode.removeChild(backdrop);
    }
  }



  function displayModalWithData() {
    const qrImage = document.getElementById('qrImage');
    const qrDataURL = qrImage.getAttribute('src');

    if (qrDataURL) {
      const myModal = new bootstrap.Modal(document.getElementById('myModal'));
      myModal.show();
    }

    removeModalBackdrop();
  }

  document.addEventListener('DOMContentLoaded', function() {
    displayModalWithData();

  });


</script>
</body>
</html>
