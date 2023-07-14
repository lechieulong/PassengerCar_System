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

@WebServlet(name = "updateUser",value = "/admin/userManager/update")
public class updateUserServlet extends HttpServlet {
    private final UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Optional<User> userFromServer = userService.getById(id);

        if (userFromServer.isPresent()) {
            req.setAttribute("user", userFromServer.get());
            System.out.println(userFromServer.toString() );
            req.getRequestDispatcher("/WEB-INF/views/userUpdateView.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/admin/userManager");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setId( Long.parseLong(req.getParameter("id")));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setFullName(req.getParameter("fullname"));
        user.setEmail(req.getParameter("email"));
        user.setPhoneNumbers(req.getParameter("phoneNumber"));
        System.out.println(req.getParameter("phoneNumber"));
        user.setGender(Integer.parseInt(req.getParameter("gender")));
        user.setAddress(req.getParameter("address"));
        user.setRole(req.getParameter("role"));
        Map<String, List<String>> violations = new HashMap<>();
//        Optional<User> userByUsername =  userService.getByUsername(user.getUsername());
//        Optional<User> userByEmail =  userService.getByEmail(user.getEmail());
//        Optional<User> userByPhoneNumber =  userService.getByPhoneNumber(user.getPhoneNumber());
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

        int sumOfViolations = violations.values().stream().mapToInt(List::size).sum();

        if (sumOfViolations == 0) {
            req.setAttribute("user", user);
            userService.update(user);
        } else {
            req.setAttribute("user", user);
            req.setAttribute("violations", violations);
        }
        req.getRequestDispatcher("/WEB-INF/views/userUpdateView.jsp").forward(req, resp);
    }
}
