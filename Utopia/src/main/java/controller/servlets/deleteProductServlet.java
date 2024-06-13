package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import utils.StringUtils;

@WebServlet(urlPatterns = "/deleteProduct", asyncSupported = true)
public class deleteProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIdString = request.getParameter("id");
        if (productIdString != null && !productIdString.isEmpty()) {
            try {
                int productId = Integer.parseInt(productIdString);
                DatabaseController dbController = new DatabaseController();
                dbController.deleteProduct(productId);
                response.sendRedirect("/Utopia/admin"); // Redirect to product list page or another appropriate page
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID format.");
            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Product deletion failed.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product ID is missing.");
        }
    }
}
