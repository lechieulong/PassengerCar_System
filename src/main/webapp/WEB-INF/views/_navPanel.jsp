<%--
  Created by IntelliJ IDEA.
  User: phudu
  Date: 6/26/2023
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="col-md-3 mb-md-0 mb-3">
  <nav class="list-group">
    <a class="list-group-item ${param.active == 'USER' ? 'active' : ''}"
       href="${pageContext.request.contextPath}/user" role="button">
      Tài khoản
    </a>
    <a class="list-group-item ${param.active == 'CHANGE_PASSWORD' ? 'active' : ''}"
       href="${pageContext.request.contextPath}/changePassword" role="button">
      Đổi mật khẩu
    </a>
    <a class="list-group-item ${param.active == 'SETTING' ? 'active' : ''}"
       href="${pageContext.request.contextPath}/setting" role="button">
      Thiết đặt
    </a>
    <a class="list-group-item" href="${pageContext.request.contextPath}/signout" role="button">Đăng xuất</a>
  </nav>
</aside> <!-- col.// -->
