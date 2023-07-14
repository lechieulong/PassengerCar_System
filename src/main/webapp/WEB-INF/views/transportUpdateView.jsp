<%--
  Created by IntelliJ IDEA.
  User: vuade
  Date: 27/05/23
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="_metaAdmin.jsp"/>
    <title>Sửa Phương tiện</title>
</head>
<body>
<jsp:include page="_headerAdmin.jsp"/>

<section class="section-content">
    <div class="container">
        <header class="section-heading py-4">
            <h3 class="section-title">Sửa thể loại</h3>
        </header> <!-- section-heading.// -->

        <main class="row mb-5">
            <form class="col-lg-6" method="POST" action="${pageContext.request.contextPath}/admin/transportManager/update"
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
                   ? 'is-invalid' : (not empty requestScope.category.name ? 'is-valid' : '')}"
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
                    <label for="transport-description" class="form-label">Mô tả phương tiện</label>
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
                    <label for="category-imageName" class="form-label d-block">Hình phương tiện</label>
                    <c:choose>
                        <c:when test="${not empty requestScope.transport.imageName}">
                            <img width="50"
                                 class="img-thumbnail mb-3"
                                 src="${pageContext.request.contextPath}/image/${requestScope.transport.imageName}"
                                 alt="${requestScope.transport.imageName}"
                                 title="${requestScope.transport.imageName}">
                            <div class="mb-3 form-check">
                                <input class="form-check-input"
                                       type="checkbox"
                                       value="deleteImage"
                                       id="delete-image"
                                       name="deleteImage" ${not empty requestScope.deleteImage ? 'checked' : ''}>
                                <label class="form-check-label" for="delete-image">Xóa hình này?</label>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="fst-italic mb-3">Không có hình</div>
                        </c:otherwise>
                    </c:choose>
                    <input type="file"
                           class="form-control"
                           id="category-imageName"
                           name="image"
                           accept="image/*">
                    <div class ="mb-3">
                        <label> Total Seat
                            <input type="range" min = 10 max = 30 name="licensePlate" value="requestScope.transport.licensePlate">
                        </label>
                    </div>
                </div>
                <input type="hidden" name="id" value="${requestScope.category.id}">
                <input type="hidden" name="imageName" value="${requestScope.category.imageName}">
                <button type="submit" class="btn btn-primary me-2 mb-3">
                    Sửa
                </button>
                <button type="reset"
                        class="btn btn-warning me-2 mb-3"
                        onclick="return confirm('Bạn có muốn để giá trị mặc định?')">
                    Mặc định
                </button>
                <a class="btn btn-danger mb-3"
                   href="${pageContext.request.contextPath}/admin/transportManager"
                   role="button"
                   onclick="return confirm('Bạn có muốn hủy?')">
                    Hủy
                </a>
            </form>
        </main>
    </div> <!-- container.// -->
</section> <!-- section-content.// -->

<jsp:include page="_footerAdmin.jsp"/>



</body>
</html>
