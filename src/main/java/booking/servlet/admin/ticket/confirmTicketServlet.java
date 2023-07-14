package booking.servlet.admin.ticket;

import booking.Service.SeatTransportService;
import booking.Service.TripsTransportWithRoutesService;
import booking.Utils.QrCodeConstants;
import booking.beans.SeatTransport;
import booking.beans.User;
import booking.dto.TripsTransportWithRoutes;
import booking.dto.VietQRRequest;
import booking.dto.VietQRResponse;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Optional;



@WebServlet(name = "ticketConfirm",value = "/admin/ticketManager/confirm")
public class confirmTicketServlet extends HttpServlet {
    private final TripsTransportWithRoutesService tripsTransportWithRoutesService = new TripsTransportWithRoutesService();

    private final SeatTransportService seatTransportService = new SeatTransportService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tripsTransportId = req.getParameter("id"); // Lấy mã chuyến xe
        Optional<TripsTransportWithRoutes>  tripsTransportWithRoutesFromServer = tripsTransportWithRoutesService.getById(Long.parseLong(tripsTransportId));
        Optional<SeatTransport> seatTransport = seatTransportService.getQuantityAndPriceByTrips(Long.parseLong(tripsTransportId));
        req.setAttribute("trips",tripsTransportWithRoutesFromServer.get()); // trả về chuyến xe đã chọn
        req.setAttribute("seatTransport",seatTransport.get());
        req.getRequestDispatcher("/WEB-INF/views/confirmAdminView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        VietQRRequest requestData = new VietQRRequest();
//        ---------------------------------- Trả về để tạo vé ---------------------------------------
        String tripsTransportId = req.getParameter("tripsTransportId"); // Lấy mã chuyến xe
        String seatTransportId = req.getParameter("seatTransportId"); // Lấy mã ghế
        User user = (User) session.getAttribute("currentUser"); // Lấy mã người dùng hiện tại\

        Optional<TripsTransportWithRoutes>  tripsTransportWithRoutesFromServer = tripsTransportWithRoutesService.getById(Long.parseLong(tripsTransportId));
        Optional<SeatTransport> seatTransport = seatTransportService.getQuantityAndPriceByTrips(Long.parseLong(tripsTransportId));
        //  Tính tiền theo số lượng
        String quantity = req.getParameter("quantity");
        String price = req.getParameter("price");
        double totalPrice = Double.parseDouble(quantity) * Double.parseDouble(price);

        // Cài đặt thuộc tính của Request của Bean tới Json của bên thứ 3
        requestData.setAccountNo("19070293758017");
        requestData.setAccountName("Duong Thanh Phu");
        requestData.setAcqId("970407");
        requestData.setAmount(totalPrice);
        requestData.setAddInfo("Chuyen tien ve xe");
        requestData.setFormat("text");
        requestData.setTemplate("print");

        try {
            // Tạo HTTP Client
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Tạo yêu cầu POST
            HttpPost httpPost = new HttpPost(QrCodeConstants.URL);

            // Thiết lập Header
            httpPost.setHeader("x-client-id", QrCodeConstants.CLIENT_ID);
            httpPost.setHeader("x-api-key", QrCodeConstants.API_KEY);
            httpPost.setHeader("Content-Type", "application/json");

            // Thiết lập dữ liệu yêu cầu
            StringEntity entity = new StringEntity(new Gson().toJson(requestData));
            httpPost.setEntity(entity);
            // Gửi yêu cầu POST và nhận phản hồi
            HttpResponse httpResponse = httpClient.execute(httpPost);
            // Xử lý phản hồi
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                // Đọc dữ liệu phản hồi
                HttpEntity responseEntity = httpResponse.getEntity();
                String responseBody = EntityUtils.toString(responseEntity);
                // Chuyển đổi JSON thành đối tượng VietQRResponse
                VietQRResponse vietQRResponse = new Gson().fromJson(responseBody, VietQRResponse.class);

                req.setAttribute("tripsTransportIdSecondReq",tripsTransportId); // Trả về mã chuyến xe
                req.setAttribute("seatTransportId",seatTransportId); // Trả về mã của ghế ngồi theo mã xe
                req.setAttribute("userId",user.getId()); // Trả về id của người dùng hiện tại
                req.setAttribute("quantity",quantity); // Trả về số lương
                req.setAttribute("totalPrice",totalPrice); // Trả về tổng tiền
                req.setAttribute("qrDataURL", vietQRResponse.getData().getQrDataURL());
                req.setAttribute("trips",tripsTransportWithRoutesFromServer.get()); // trả về chuyến xe đã chọn
                req.setAttribute("seatTransport",seatTransport.get());
                req.getRequestDispatcher("/WEB-INF/views/confirmAdminView.jsp").forward(req,resp);
            } else {
                System.out.println("Lỗi: " + statusCode);
            }
            // Đóng HTTP Client
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
