package controller.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.UtopiaModel;
import model.passwordEncryption;
import model.productModel;
import utils.StringUtils;

public class DatabaseController {

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(StringUtils.DRIVER_NAME);
		return DriverManager.getConnection(StringUtils.LOCALHOST_URL, StringUtils.LOCALHOST_USERNAME,
				StringUtils.LOCALHOST_PASSWORD);
	}

	public int registerUser(UtopiaModel Utopia) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.REGISTER_USER_QUERY);

			stmt.setString(1, Utopia.getFirstName());
			stmt.setString(2, Utopia.getLastName());
			stmt.setString(3, Utopia.getEmail());
			stmt.setString(4,
					passwordEncryption.encrypt(String.valueOf(Utopia.getPhoneNumber()), Utopia.getPassword()));
			stmt.setString(5, Utopia.getPhoneNumber());
			stmt.setBoolean(6, Utopia.isAdmin()); // Assuming isAdmin returns a boolean value

			// Statement Run
			int result = stmt.executeUpdate();

			if (result > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1;
		}
	}

	public int getUserLoginInfo(String phoneNumber, String password) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.GET_LOGIN_USER_INFO);
			st.setString(1, phoneNumber);
			ResultSet result = st.executeQuery();

			if (result.next()) {
				// User name and password match in the database
				String userDb = result.getString("user_phone");
				String passwordDb = result.getString("user_password");
				int userId = result.getInt("user_id");

				// Decrypt the password from the database using the username (phoneNumber)
				String decryptedPassword = passwordEncryption.decrypt(passwordDb, phoneNumber);

				if (decryptedPassword != null && decryptedPassword.equals(password))
					return userId; // Return the user's ID for successful login
				else
					return 0; // Return 0 for failed login
			} else {
				return 0; // Return 0 for failed login
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1; // Return -1 for error
		}
	}

	public boolean isUserAdmin(int userId) {
		try (Connection con = getConnection()) {
			PreparedStatement st = con.prepareStatement(StringUtils.IS_USER_ADMIN_QUERY);
			st.setInt(1, userId);
			ResultSet result = st.executeQuery();

			if (result.next()) {
				// Check if the user is an admin
				int isAdminInt = result.getInt("user_is_admin");
				boolean isAdmin = isAdminInt == 1; // Check if isAdminInt is 1
				System.out.println("isAdmin value retrieved from database: " + isAdmin);
				return isAdmin;
			}
			return false; // User is not admin or not found
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return false; // Return false for error
		}
	}

	public int addProduct(String productName, String productDescription, String productPrice,
			InputStream productImage) {
		try {
			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.ADD_PRODUCT_QUERY);

			stmt.setString(1, productName);
			stmt.setString(2, productDescription);
			stmt.setString(3, productPrice);
			stmt.setBlob(4, productImage);

			int rowsInserted = stmt.executeUpdate();

			if (rowsInserted > 0) {
				try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						int productId = generatedKeys.getInt(1);
						return productId; // Return the generated product ID
					} else {
						return 0; // Failed to retrieve the generated product ID
					}
				}
			} else {
				return 0; // Failed to add product
			}

		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			return -1; // Error occurred
		}
	}
	
	public ArrayList<productModel> retrieveProductsFromDatabase() {
		try {
            PreparedStatement stmt = getConnection().prepareStatement(StringUtils.GET_ALL_PRODUCTS_QUERY);
            ResultSet result = stmt.executeQuery();

            ArrayList<productModel> products = new ArrayList<productModel>();

            while (result.next()) {
            	productModel product = new productModel();
            	product.setProductId(result.getInt("product_id"));
                product.setProductName(result.getString("product_name"));
                product.setProductDescription(result.getString("product_description"));
                product.setPrice(result.getInt("price"));
                product.setProductImage(result.getString("product_image"));
                products.add(product);
 
            }
            return products;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	  public productModel getProductById(int productId) throws SQLException, ClassNotFoundException {
	        String sql = "SELECT * FROM product WHERE product_id = ?";
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, productId);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    productModel product = new productModel();
	                    product.setProductId(rs.getInt("product_id"));
	                    product.setProductName(rs.getString("product_name"));
	                    product.setProductDescription(rs.getString("product_description"));
	                    product.setPrice(rs.getInt("price"));
	                    product.setProductImage(rs.getString("product_image"));
	                    return product;
	                }
	            }
	        }
	        return null; // Return null if no product found
	    }
	  
	  public void updateProduct(productModel product) throws SQLException, ClassNotFoundException {
		    String sql = "UPDATE product SET product_name = ?, product_description = ?, price = ?, product_image = ? WHERE product_id = ?";
		    try (Connection conn = this.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql)) {
		        stmt.setString(1, product.getProductName());
		        stmt.setString(2, product.getProductDescription());
		        stmt.setInt(3, product.getPrice());
		        stmt.setString(4, product.getProductImage());
		        stmt.setInt(5, product.getProductId());
		        stmt.executeUpdate();
		    }
		}
	  
	  public void deleteProduct(int productId) throws SQLException, ClassNotFoundException {
		    String sql = "DELETE FROM product WHERE product_id = ?";
		    try (Connection conn = this.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql)) {
		        stmt.setInt(1, productId);
		        int affectedRows = stmt.executeUpdate();
		        if (affectedRows == 0) {
		            throw new SQLException("Deleting product failed, no rows affected.");
		        }
		    }
		}



}