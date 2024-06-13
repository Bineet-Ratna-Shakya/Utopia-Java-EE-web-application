package controller.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.database.DatabaseController;
import model.productModel;
import utils.StringUtils;


@WebServlet(asyncSupported = true, urlPatterns = "/admin")
public class adminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final DatabaseController DatabaseController;
    
    public adminServlet() {
        this.DatabaseController = new DatabaseController();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	  try {
    	        ArrayList<productModel> products = DatabaseController.retrieveProductsFromDatabase();
    	        System.out.println("Retrieved products: " + products);
    	        request.setAttribute(StringUtils.PRODUCT_LISTS, products);
    	        request.getRequestDispatcher(StringUtils.URL_ADMIN).forward(request, response);  // Using StringUtils constant

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred: " + e.getMessage());
    	    }
    }
}