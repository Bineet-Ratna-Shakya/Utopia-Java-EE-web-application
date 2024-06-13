package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.productModel;

@WebServlet(asyncSupported = true, urlPatterns = "/updateProductAction")
public class updateProductActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        int price = Integer.parseInt(request.getParameter("price"));
        String productImage = request.getParameter("productImage");

        productModel product = new productModel(productId, productName, productDescription, price, productImage);
        
        try {
            DatabaseController dbController = new DatabaseController();
            dbController.updateProduct(product);
            response.sendRedirect("/Utopia/admin"); // Redirect to a success page
        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to update product.");
        }
    }
}
