<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="_metaAdmin.jsp"/>
    <title>Thêm phương tiện di chuyển</title>
</head>
<body>
<jsp:include page="_headerAdmin.jsp"/>

<section class="section-content">
    <div class="container">
        <header class="section-heading py-4">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <h3 class="section-title">Thêm Phương tiện</h3>
                    </div>
                </div>
            </div>
        </header>

        <main class="row mb-5">
            <form class="col-lg-6 " method="POST" action="${pageContext.request.contextPath}/admin/transportManager/create"
                  enctype="multipart/form-data">
                <c:if test="${not empty requestScope.successMessage}">
                    <div class="alert alert-success mb-3" role="alert">
                            ${requestScope.successMessage}
                    </div>
                </c:if>
                <c:if test="${not empty requestScope.errorMessage}">
                    <div class="alert alert-danger mb-3" role="alert">
                            ${requestScope.errorMessage}
                    </div>
                </c:if>
                <div class="mb-3">
                    <label for="transport-name" class="form-label">Tên phương tiện <span class="text-danger">*</span></label>
                    <input type="text"
                           class="form-control ${not empty requestScope.violations.nameViolations
                   ? 'is-invalid' : (not empty requestScope.transport.nameOfTransport ? 'is-valid' : '')}"
                           id="transport-name"
                           name="nameOfTransport"
                           value="${requestScope.transport.nameOfTransport}"
                           required>
                    <c:if test="${not empty requestScope.violations.nameViolations}">
                        <div class="invalid-feedback">
                            <ul class="list-unstyled">
                                <c:forEach var="violation" items="${requestScope.violations.nameViolations}">
                                    <li>${violation}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="transport-licensePlate" class="form-label">Biển số xe</label>
                    <input type="text"
                           class="form-control"
                           id="transport-licensePlate"
                           name="licensePlate"
                    >
                </div>
                <div class="mb-3">
                    <label for="transport-description" class="form-label">Mô tả thể loại</label>
                    <textarea class="form-control ${not empty requestScope.violations.descriptionViolations
                      ? 'is-invalid' : (not empty requestScope.transport.description ? 'is-valid' : '')}"
                              id="transport-description"
                              rows="5"
                              name="description">${requestScope.transport.description}</textarea>
                    <c:if test="${not empty requestScope.violations.descriptionViolations}">
                        <div class="invalid-feedback">
                            <ul class="list-unstyled">
                                <c:forEach var="violation" items="${requestScope.violations.descriptionViolations}">
                                    <li>${violation}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="transport-imageName" class="form-label">Hình thể loại</label>
                    <input type="file"
                           class="form-control"
                           id="transport-imageName"
                           name="image"
                           accept="image/*">
                </div>
                <input type="hidden" name="transportId" value="${requestScope.transport.id}">
                <div class="mb-3">
                    <label for="transport-seatType" class="form-label">Chọn loại ghế </label>
                    <br>
                    <select name="seatTypeId" id="transport-seatType" rows="5" class="form-control">
                        <c:forEach var="seatType" varStatus="loop" items="${requestScope.seatTypeFromServer}">
                            <option value="${seatType.id}">
                                    ${seatType.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="transport-l" class="form-label">Nhập Giá </label>
                    <br>
                    <input type="text"
                           class="form-control"
                           id="transport-l"
                           name="price"
                    >
                </div>
                <div class="mb-3">
                    <label for="quantity" class="form-label">Số lượng ghế</label>
                    <br>
                    <input type="range" name="quantity" id="quantity" min="1" max="50" onchange="updateRangeValue()" />
                    <div id="rangeValue"></div>
                </div>
                <button type="submit" class="btn btn-primary me-2 mb-3">
                    Thêm
                </button>
                <button type="reset"
                        class="btn btn-warning me-2 mb-3"
                        onclick="return confirm('Bạn có muốn để giá trị mặc định?')">
                    Mặc định
                </button>
                <a class="btn btn-danger mb-3"
                   href="${pageContext.request.contextPath}/admin/categoryManager"
                   role="button"
                   onclick="return confirm('Bạn có muốn hủy?')">
                    Hủy
                </a>
            </form>
        </main>
    </div> <!-- container.// -->
</section> <!-- section-content.// -->

<%--<jsp:include page="_footerAdmin.jsp"/>--%>
<script>
    function updateRangeValue() {
        const rangeValue = document.getElementById("quantity").value;
        const finalResult = document.getElementById("rangeValue").textContent = rangeValue;
        finalResult.innerText = "Số lượng ghế trên phương tiện " + rangeElement.value;
    }
</script>
</body>
</html>
