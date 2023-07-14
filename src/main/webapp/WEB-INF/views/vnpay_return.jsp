<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="booking.servlet.client.VNpay.Config" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>VNPAY RESPONSE</title>
        <jsp:include page="_metaAdmin.jsp"/>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/VNPAYAssets/bootstrap.min.css" type="text/css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/VNPAYAssets/jumbotron-narrow.css" type="text/css" rel="stylesheet">
    </head>
    <body>
    <jsp:include page="_headerClient.jsp"/>

        <%
            //Begin process return from VNPAY
            Map fields = new HashMap();
            for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }

            String vnp_SecureHash = request.getParameter("vnp_SecureHash");
            if (fields.containsKey("vnp_SecureHashType")) {
                fields.remove("vnp_SecureHashType");
            }
            if (fields.containsKey("vnp_SecureHash")) {
                fields.remove("vnp_SecureHash");
            }
            String signValue = Config.hashAllFields(fields);

        %>
        <!--Begin display -->
        <div class="container">
            <div class="header ">
                <h3 class="text-muted">VNPAY RESPONSE</h3>
            </div>
            <div class="table-responsive">
                <div class="form-group">
                    <label >Merchant Transaction Code:</label>
                    <label><%=request.getParameter("vnp_TxnRef")%></label>
                </div>
                <div class="form-group">
                    <label >Amount:</label>
                    <label><%=request.getParameter("vnp_Amount")%></label>
                </div>
                <div class="form-group">
                    <label >Order info:</label>
                    <label><%=request.getParameter("vnp_OrderInfo")%></label>
                </div>
                <div class="form-group">
                    <label >VNPAY Response Code:</label>
                    <label><%=request.getParameter("vnp_ResponseCode")%></label>
                </div>
                <div class="form-group">
                    <label >VNPAY Transaction Code:</label>
                    <label><%=request.getParameter("vnp_TransactionNo")%></label>
                </div>
                <div class="form-group">
                    <label >Bank Code:</label>
                    <label><%=request.getParameter("vnp_BankCode")%></label>
                </div>
                <div class="form-group">
                    <label >Pay Date:</label>
                    <label><%=request.getParameter("vnp_PayDate")%></label>
                </div>
                <div class="form-group">
                    <label >Payment Status:</label>
                    <label>
                        <%
                            if (signValue.equals(vnp_SecureHash)) {
                                if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
                                    out.print("Success");
                                } else {
                                    out.print("Failed");
                                }

                            } else {
                                out.print("invalid signature");
                            }
                        %></label>
                </div>
            </div>

            <footer class="footer">
                <p>&copy; VNPAY 2020</p>
            </footer>
        </div>
        <script src="${pageContext.request.contextPath}/VNPAYAssets/jquery-1.11.3.min.js" type="text/javascript"></script>
    </body>
</html>
