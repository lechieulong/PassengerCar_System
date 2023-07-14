<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/26/2023
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li>
                <c:if test="${empty sessionScope.currentUser}">
                <a href="${pageContext.request.contextPath}/client/signin">Đăng nhập</a>
                </c:if>
                </li>
                <li>
                <c:if test="${not empty sessionScope.currentUser}">
                  </c:if>
                  <span class="icon-user"></span>
                <li>
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
      <div class="menu-outer"><!--Here Menu Will Come Automatically Via Javascript / Same Menu as in Header--></div>
    </nav>
  </div>
  <!-- End Mobile Menu -->

</header>