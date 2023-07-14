<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:parseDate value="${objectType.departTime}" var="departDate" pattern="yyyy-MM-dd HH:mm:ss"/>
<html>
<head>
    <title></title>
    <jsp:include page="_meta.jsp"/>
</head>
<body>
<jsp:include page="_header.jsp"/>
<c:forEach var="objectType" varStatus="loop" items="${requestScope.tripsTransportFromServer}">

    <div><h5 class="float-start me-3">${productReview.user.fullName}</h5>
        <div class="ratting-star float-end">
                    <span class="rating-stars me-2">
                      <c:forEach begin="1" end="5" step="1" var="i">
                          <i class="bi bi-star-fill ${i <= productReview.ratingScore ? 'active' : ''}"></i>
                      </c:forEach>
                    </span>
            <span>(${productReview.ratingScore})</span>
            <c:choose>
                <c:when test="${productReview.isShow == 1}">
                    ${productReview.content}
                </c:when>
                <c:otherwise>
                    <em>Nội dung đánh giá đã được ẩn bởi quản trị viên</em>
                </c:otherwise>
            </c:choose>
        </div>
        Chuyến đi ngày: ${requestScope.dateFromServer}<br>
        Giá tiền: <fmt:formatNumber value="${objectType.price}" type="currency" currencyCode="VND"/><br>
        Tổng số ghế: ${objectType.totalSeat}<br>
        Số ghế còn trống: ${objectType.quantity}<br>
        Tên chuyến xe: ${objectType.routeName}<br>
        Hình ảnh của xe: <img src="${objectType.imageName}" alt="Hình ảnh ở đây" class="img-fluid"><br>
        Tên phương tiện: ${objectType.nameOfTransport}<br>
        Ngày khởi hành:<fmt:formatDate value="${departDate}" pattern="dd/MM/yyyy"/><br>
        Giờ khởi hành: ${objectType.departTime.substring(11, 16)}<br>
        Thời gian trung chuyển: ${objectType.timeOfTrips.substring(11, 16)}<br>
        <input type="hidden" name="tripsTransportId" value="">
        <a href="${pageContext.request.contextPath}/confirmServlet?id=${objectType.tripsTransportId}" target="_blank">Chọn
            xe này</a>
    </div>
    <h3 id="review-form" class="pb-2">Thêm đánh giá</h3>

    <c:if test="${not empty sessionScope.errorAddReviewMessage}">
        <div class="alert alert-danger" role="alert">${sessionScope.errorAddReviewMessage}</div>
    </c:if>
    <c:choose>
    <c:when test="${not empty sessionScope.currentUser}">
        <div class="ratting-form-wrapper">
            <div class="ratting-form">
                <form action="${pageContext.request.contextPath}/addProductReview" method="post">
                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <select class="form-select ${not empty sessionScope.violations.ratingScoreViolations
                                ? 'is-invalid' : (not empty sessionScope.values.ratingScore ? 'is-valid' : '')}"
                                    name="ratingScore">
                                <option disabled ${not empty sessionScope.values.ratingScore ? '' : 'selected'}>
                                    Cho sao
                                </option>
                                <c:forEach var="i" begin="1" end="5">
                                    <option value="${i}" ${sessionScope.values.ratingScore == i ? 'selected' : ''}>${i}</option>
                                </c:forEach>
                            </select>
                            <c:if test="${not empty sessionScope.violations.ratingScoreViolations}">
                                <div class="invalid-feedback">
                                    <ul class="list-unstyled mb-0">
                                        <c:forEach var="violation"
                                                   items="${sessionScope.violations.ratingScoreViolations}">
                                            <li>${violation}</li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col">
                      <textarea class="form-control ${not empty sessionScope.violations.contentViolations
                                  ? 'is-invalid' : (not empty sessionScope.values.content ? 'is-valid' : '')}"
                                name="content"
                                placeholder="Nội dung đánh giá"
                                rows="3">${sessionScope.values.content}</textarea>
                            <c:if test="${not empty sessionScope.violations.contentViolations}">
                                <div class="invalid-feedback">
                                    <ul class="list-unstyled mb-0">
                                        <c:forEach var="violation"
                                                   items="${sessionScope.violations.contentViolations}">
                                            <li>${violation}</li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <input type="hidden" name="userId" value="${sessionScope.currentUser.id}">
                    <input type="hidden" name="tripsTransportId" value="${objectType.tripsTransportId}">
                    <button type="submit" class="btn btn-primary">Gửi đánh giá</button>
                </form>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <p>Vui lòng <a href="${pageContext.request.contextPath}/signin">đăng nhập</a> để đánh giá sản
            phẩm.</p>
    </c:otherwise>
    </c:choose>
    <c:remove var="values" scope="session"/>
    <c:remove var="violations" scope="session"/>
    <c:remove var="successMessage" scope="session"/>
    <c:remove var="errorAddReviewMessage" scope="session"/>
    <c:remove var="errorDeleteReviewMessage" scope="session"/>
</c:forEach>
</body>
</html>
