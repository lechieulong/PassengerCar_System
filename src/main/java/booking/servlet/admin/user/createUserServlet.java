package booking.servlet.admin.user;

import booking.Service.UserService;
import booking.Utils.Validator;
import booking.beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "createUser",value = "/admin/userManager/create")
public class createUserServlet extends HttpServlet {
    private final UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/userCreateView.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setFullName(req.getParameter("fullName"));
        user.setEmail(req.getParameter("email"));
        user.setPhoneNumbers(req.getParameter("phoneNumber"));
        user.setGender(Integer.parseInt(req.getParameter("gender")));
        user.setAddress(req.getParameter("address"));
        user.setRole(req.getParameter("role"));



        Map<String, List<String>> violations = new HashMap<>();
//        Optional<User> userByUsername = userService.getByUsername(user.getUsername());
//        Optional<User> userByEmail =  userService.getByEmail(user.getEmail());
//        Optional<User> userByPhoneNumber =  userService.getByPhoneNumber(user.getPhoneNumber());

        //-------------Validation time !--------------//
        violations.put("usernameViolations", Validator.of(user.getUsername())
                .toList());
        violations.put("passwordViolations", Validator.of(user.getPassword())
                .toList());
        violations.put("fullnameViolations", Validator.of(user.getFullName())
                .toList());
        violations.put("emailViolations", Validator.of(user.getEmail())
                .toList());
        violations.put("phoneNumberViolations", Validator.of(user.getPhoneNumbers())
                .toList());
        violations.put("genderViolations", Validator.of(user.getGender())
                .toList());
        violations.put("addressViolations", Validator.of(user.getAddress())
                .toList());
        violations.put("roleViolations", Validator.of(user.getRole())
                .toList());

        // Đếm lỗi trong map, nếu có lỗi trả về
        int sumOfViolations = violations.values().stream().mapToInt(List::size).sum();
        if (sumOfViolations == 0) {
            userService.insert(user);
        } else {
            req.setAttribute("user", user);
            req.setAttribute("violations", violations);
        }

        req.getRequestDispatcher("/WEB-INF/views/userCreateView.jsp").forward(req,resp);
    }
}
