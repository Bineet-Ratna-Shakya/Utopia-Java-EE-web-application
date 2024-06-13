package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import utils.StringUtils;


@WebServlet(urlPatterns = "/login", asyncSupported = true)
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final DatabaseController DatabaseController;

    public loginServlet() {
        this.DatabaseController = new DatabaseController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        int user_id = DatabaseController.getUserLoginInfo(phoneNumber, password);

        if (user_id > 0) {
            // User authenticated, create session
            HttpSession session = request.getSession(true);
            
            // Set user information in the session
            session.setAttribute("phoneNumber", phoneNumber);
            
            // Check if the user is an admin
            boolean isAdmin = DatabaseController.isUserAdmin(user_id);
            session.setAttribute("isAdmin", isAdmin);
            
            int loginResult = DatabaseController.getUserLoginInfo(phoneNumber, password);

            if (loginResult == 1) { // Assuming 1 is the result for a successful login
                if (isAdmin) {
                    HttpSession userSession = request.getSession();
                    userSession.setAttribute(StringUtils.PHONE_NUMBER, phoneNumber); // Set username in session
                    userSession.setMaxInactiveInterval(30*60);

                    Cookie userCookie = new Cookie(StringUtils.PHONE_NUMBER, phoneNumber); // Set username in cookie
                    userCookie.setMaxAge(30*60);
                    response.addCookie(userCookie);

                    request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_LOGIN);
                    response.sendRedirect(request.getContextPath() + StringUtils.SERVLET_URL_ADMIN);
                } else {
                    HttpSession userSession = request.getSession();
                    userSession.setAttribute(StringUtils.PHONE_NUMBER, phoneNumber);
                    userSession.setMaxInactiveInterval(30*60);

                    Cookie userCookie = new Cookie(StringUtils.PHONE_NUMBER, phoneNumber);
                    userCookie.setMaxAge(30*60);
                    response.addCookie(userCookie);

                    request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_LOGIN);
                    response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_WELCOME);
                }
            } else if (loginResult == 0) {
                // Username or password mismatch
                request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_LOGIN);
                request.setAttribute(StringUtils.PHONE_NUMBER, phoneNumber);
                request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
            } else if (loginResult == -1) {
                // Username not found
                request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);
                request.setAttribute(StringUtils.PHONE_NUMBER, phoneNumber);
                request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
            } else {
                // Internal server error
                request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
                request.setAttribute(StringUtils.PHONE_NUMBER, phoneNumber);
                request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
            }
        }
    }
}

