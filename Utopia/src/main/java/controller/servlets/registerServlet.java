package controller.servlets;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DatabaseController;
import model.UtopiaModel;
import utils.StringUtils;
import utils.ValidationUtils;

@WebServlet(asyncSupported = true, urlPatterns = { "/registeruser" })
public class registerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final DatabaseController DatabaseController;

    public registerServlet() {
        this.DatabaseController = new DatabaseController();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        String firstName = request.getParameter(StringUtils.FIRST_NAME);
        String lastName = request.getParameter(StringUtils.LAST_NAME);
        String email = request.getParameter(StringUtils.EMAIL);
        String password = request.getParameter(StringUtils.PASSWORD);
        String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);

        // Check if phoneNumber is not null and is a valid integer string
        if (phoneNumber != null && ValidationUtils.isNumbersOnly(phoneNumber)) {
            // phoneNumber is valid, proceed with the user registration
        } else {
            // Handle the case when phoneNumber is invalid
            // For example, set an error message and forward the request to the register page
            request.setAttribute(StringUtils.MESSAGE_ERROR, "Invalid phone number");
            request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
            return; // Don't proceed further since the phone number is invalid
        }  	
        boolean admin = Boolean.parseBoolean(request.getParameter(StringUtils.ADMIN)); // Assuming admin is a boolean

        UtopiaModel user = new UtopiaModel(firstName, lastName, email, password, phoneNumber, admin);

        // Implement data validation here (e.g., check for empty fields, email format, etc.)
        if (!ValidationUtils.isTextOnly(firstName) ||
                !ValidationUtils.isTextOnly(lastName) ||
                !ValidationUtils.isEmail(email) ||
               	!ValidationUtils.isValidPassword(password) ||
               	!ValidationUtils.isNumbersOnly(phoneNumber))
        {
            // Handle the case when data validation fails
            // For example, set an error message and forward the request to the register page
            request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_INCORRECT_DATA);
            request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
            return; // Don't proceed further since the data is incorrect
        }

        // Register the user in the database
        int result = DatabaseController.registerUser(user);
        if (result > 0) {
            // Set success message attribute
            request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_REGISTER);
            
            // Redirect to login page with success parameter
            response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_LOGIN + "?success=true");
        } else {
            // Set appropriate error message attribute
            if (result == 0) {
                request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_REGISTER);
                request.getRequestDispatcher(request.getContextPath() + StringUtils.PAGE_URL_REGISTER).forward(request, response);
            } else {
                request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
                request.getRequestDispatcher(request.getContextPath() + StringUtils.PAGE_URL_REGISTER).forward(request, response);

            }
            
            // Forward to register page
            request.getRequestDispatcher(StringUtils.PAGE_URL_REGISTER).forward(request, response);
        }
    }
}