package controller.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.DatabaseController;
import utils.StringUtils;

import javax.servlet.annotation.MultipartConfig;

@WebServlet(urlPatterns = StringUtils.SERVLET_URL_ADD_PRODUCT, asyncSupported = true)
@MultipartConfig
public class addproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseController DatabaseController;

	public void init() throws ServletException {
		DatabaseController = new DatabaseController();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Extracting product details from the request
        String productName = request.getParameter("product_name");
        String productDescription = request.getParameter("product_description");
        String productPrice = request.getParameter("product_price");
        Part productImagePart = request.getPart("product_image");
        InputStream productImageInputStream = null;
        System.out.println("Product Name: [" + productName + "]");

        if (productImagePart != null && productImagePart.getSize() > 0) {
            // If an image is uploaded, set the input stream
            productImageInputStream = productImagePart.getInputStream();
        }

        try {
            Connection conn = DatabaseController.getConnection();
            PreparedStatement statement = conn.prepareStatement(StringUtils.ADD_PRODUCT_QUERY);

            // Setting parameters in the prepared statement
            statement.setString(1, productName);
            statement.setString(2, productDescription);
            statement.setString(3, productPrice);
            if (productImageInputStream != null) {
                statement.setBlob(4, productImageInputStream);
            } else {
                // If no image is uploaded, set the image column to NULL
                statement.setNull(4, java.sql.Types.BLOB);
            }

            // Executing the query
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                response.sendRedirect(request.getContextPath() + "/pages/admin.jsp");
            } else {
                // Product insertion failed
                // You can redirect to an error page or perform any other action
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Database connection problem.", e);
        }
    }
}
