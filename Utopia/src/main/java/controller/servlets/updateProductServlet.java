package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.productModel;

@WebServlet(asyncSupported = true, urlPatterns = "/update")
public class updateProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIdString = request.getParameter("id");
        try {
            // Convert String ID to Integer
            int productId = Integer.parseInt(productIdString);

            // Create an instance of DatabaseController
            DatabaseController databaseController = new DatabaseController();

            // Retrieve product from the database
            productModel product = databaseController.getProductById(productId);
            if (product == null) {
                // No product found, handle accordingly
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found.");
                return;
            }

            // Set the product as an attribute to request
            request.setAttribute("product", product);

            // Forward to the update product JSP page
            request.getRequestDispatcher("/pages/updateProduct.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Handle case where ID is not a valid integer
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID format.");
        } catch (Exception e) {
            // Handle other exceptions such as SQLExceptions
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to retrieve product data.");
        }
    }
}
