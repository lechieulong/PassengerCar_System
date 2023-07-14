<%--
  Created by IntelliJ IDEA.
  User: vuade
  Date: 02/06/23
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<c:if test="${not empty sessionScope.currentUser}">
    <meta name="currentUserId" content="${sessionScope.currentUser.id}"/>
</c:if>
<link href="${pageContext.request.contextPath}/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.png" type="image/x-icon" />
<link rel="icon" href="${pageContext.request.contextPath}/imt/favicon.png" type="image/x-icon" />
<meta name="msapplication-TileImage" content="${pageContext.request.contextPath}/img/favicon.png" />
<!-- Bootstrap v5.0.1 -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" rel="stylesheet">

<!-- Link of Long-->
<link href="${pageContext.request.contextPath}/css/main.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/my.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/responsive.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrapl.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animation.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-icons.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/elegenticon.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/fontawesome.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/hover.css" type="text/css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/icofont.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/ionicons.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/jquery.fancybox.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/jquery.mCustomScrollbar.min.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/jquery-ui.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/linearicons.css" type="text/css" rel="stylesheet">
<%--<link href="${pageContext.request.contextPath}/VNPAYAssets/bootstrap.min.css" type="text/css" rel="stylesheet">--%>
<%--<link href="${pageContext.request.contextPath}/VNPAYAssets/jumbotron-narrow.css" type="text/css" rel="stylesheet">--%>

<link href="${pageContext.request.contextPath}/css/owl.css" type="text/css" rel="stylesheet">

<link href="${pageContext.request.contextPath}/css/payment.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/simple-line-icons.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/styles.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/themify-icons.css" type="text/css" rel="stylesheet">

<!--Link of Long -->


<!-- Bootstrap Icons v1.5.0 -->
<link href="${pageContext.request.contextPath}/css/bootstrap-icons.css" type="text/css" rel="stylesheet">
<!-- Custom Styles -->
<link href="${pageContext.request.contextPath}/css/styles.css" type="text/css" rel="stylesheet">
<!--Jquery date picker-->
<link href="${pageContext.request.contextPath}/css/bootstrap-icons.css" rel="stylesheet" type="text/css">


<!-- autoFill name datePicker timePicker rangeDisplay -->
<link href="${pageContext.request.contextPath}/js/flatpickr.min.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/flatpickr.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/+-.js" type="module"></script>
<script src="${pageContext.request.contextPath}/js/extension.js" type="module"></script>
<script src="${pageContext.request.contextPath}/js/dateTimePicker.js" type="module"></script>
<script src="${pageContext.request.contextPath}/js/timePicker.js" type="module"></script>
<script src="${pageContext.request.contextPath}/js/rangeDisplay.js" type="module"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.js" type="text/javascript"></script>


<!-- Link JS cua Long -->
<%--<script src="${pageContext.request.contextPath}/js/jquery.js" ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/popper.min.js" ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery.mCustomScrollbar.concat.min.js" ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery.fancybox.js" ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/appear.js" ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/owl.js" ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/wow.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/parallax.min.js" ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/tilt.jquery.min.js"  ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery.paroller.min.js"  ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/jquery-ui.js" ></script>--%>
<%--<script src="${pageContext.request.contextPath}/js/script.js"  ></script>--%>
<!-- end Link JS cua Long -->






