<%--
  Created by IntelliJ IDEA.
  User: vuade
  Date: 01/06/23
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="vi_VN"/>
<html>
<head>
    <title>Sửa</title>
    <script>
      document.addEventListener('DOMContentLoaded', function() {
      const pickUpPointSelect = document.getElementById('pickUpPointSelect');
      const dropOffPointSelect = document.getElementById('dropOffPointSelect');
      const nameInput = document.getElementById('nameInput');
      pickUpPointSelect.addEventListener('change', updateNameInput);
      dropOffPointSelect.addEventListener('change', updateNameInput);
      function updateNameInput() {
        const pickUpOption = pickUpPointSelect.options[pickUpPointSelect.selectedIndex];
        const dropOffOption = dropOffPointSelect.options[dropOffPointSelect.selectedIndex];
        const pickUpCity = pickUpOption.text.split('-')[1].trim();
        const dropOffCity = dropOffOption.text.split('-')[1].trim();
        nameInput.value = pickUpCity + ' - ' + dropOffCity;
      }
    });
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/admin/routeManager">Quay lại</a>
    <form action="${pageContext.request.contextPath}/admin/routeManager/update" method="post">
      <input type="hidden" name="id" value="${requestScope.routeFromServer.id}">
      <label>Tên của chuyến
        <input id="nameInput" type="text" name="name" value="${requestScope.routeFromServer.name}">
      </label>
      <br>
      <label>
        <select id="pickUpPointSelect" name="pickUpPoint">
          <option value="">Lựa chọn điểm đi</option>
          <c:forEach var="city" varStatus="loop" items="${requestScope.citiesFromServer}">
            <option value="${city.id}">
                ${loop.index + 1} -   ${city.name}
            </option>
          </c:forEach>
        </select>
      </label>
      <br>
      <label>
        <select id="dropOffPointSelect" name="dropOffPoint" >
          <option value="">Lựa chọn điểm Đến</option>
          <c:forEach var="city" varStatus="loop"  items="${requestScope.citiesFromServer}">
            <option value="${city.id}">
                ${loop.index + 1} - ${city.name}
            </option>
          </c:forEach>
        </select>
      </label>
      <br>
      <button>Sửa</button>
    </form>
</body>
</html>
