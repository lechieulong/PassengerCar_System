package booking.filter;

import booking.beans.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

@WebFilter(filterName = "bookTicketFilter", value = "/confirmServlet")
public class BookTicketFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String loginURI = request.getContextPath() + "/client/signin";
        //
        Optional<String> userRole = Optional.ofNullable(session)
                .map(s -> (User) s.getAttribute("currentUser"))
                .map(User::getRole);
        //
        boolean isAdmin = userRole.map("ADMIN"::equals).orElse(false);
        boolean isEmployee = userRole.map("EMPLOYEE"::equals).orElse(false);
        boolean customer = userRole.map("CUSTOMER"::equals).orElse(false);
        boolean loginRequest = request.getRequestURI().equals(loginURI);


        if (isAdmin || isEmployee || loginRequest || customer) {
                filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }

    }
}
