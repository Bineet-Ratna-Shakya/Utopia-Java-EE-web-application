package utils;

public class StringUtils {
	
	// Start: DB Connection
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String LOCALHOST_URL = "jdbc:mysql://localhost:3306/Utopia";
	public static final String LOCALHOST_USERNAME = "root";
	public static final String LOCALHOST_PASSWORD = "";
	// End: DB Connection
	
	// Start: Queries
	public static final String REGISTER_USER_QUERY = "INSERT INTO user ("
	        + "user_first_name, user_last_name, user_email, user_password, user_phone, user_is_admin) "
	        + "VALUES (?, ?, ?, ?, ?, ?)";
	
    public static final String ADD_PRODUCT_QUERY = "INSERT INTO product (product_name, product_description, price, product_image) VALUES (?, ?, ?, ?)";


	public static final String GET_LOGIN_USER_INFO = "SELECT * FROM user WHERE user_phone = ?";
	public static final String IS_USER_ADMIN_QUERY = "SELECT user_is_admin FROM user WHERE user_is_admin = ?";
	public static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM product";

	
	
	// Start: Parameter Names
	
	public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String ADMIN = "admin";
	// End: Parameter Names
    
    // Register Page Messages
 	public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
 	public static final String MESSAGE_ERROR_REGISTER = "Please correct the form data.";
 	public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
 	public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
 	public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
 	public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";
 	public static final String MESSAGE_ERROR_INCORRECT_DATA = "Please correct all the fields.";

 	// Login Page Messages
 	public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
 	public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
 	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

 	// Other Messages
 	public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
 	public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
 	public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";
 	
 	public static final String MESSAGE_SUCCESS = "successMessage";
 	public static final String MESSAGE_ERROR = "errorMessage";
 	// End: Validation Messages
	
 // Start: JSP Route
 	public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
 	public static final String PAGE_URL_REGISTER = "/pages/register.jsp";
 	public static final String PAGE_URL_WELCOME = "/index.jsp";
 	public static final String URL_LOGIN = "/login.jsp";
 	public static final String URL_INDEX = "/pages/products.jsp";
 	public static final String URL_ADMIN = "/pages/admin.jsp";
 	
 	// End: JSP Route

 	// Start: Servlet Route
 	public static final String SERVLET_URL_LOGIN = "/loginuser";
 	public static final String SERVLET_URL_REGISTER = "/registeruser";
 	public static final String SERVLET_URL_LOGOUT = "/logout";
 	public static final String SERVLET_URL_HOME = "/home";
 	public static final String SERVLET_URL_MODIFY_USER = "/modifyUser";
 	public static final String SERVLET_URL_ADD_PRODUCT = "/addproduct";
 	public static final String SERVLET_URL_PRODUCT = "/product";
 	public static final String SERVLET_URL_ADMIN = "/admin";

 	// End: Servlet Route

 	// Start: Normal Text
 	public static final String USER = "user";
 	public static final String SUCCESS = "success";
 	public static final String TRUE = "true";
 	public static final String JSESSIONID = "JSESSIONID";
 	public static final String LOGIN = "Login";
 	public static final String LOGOUT = "Logout";
 	public static final String PRODUCT_LISTS = "productsList";
 	public static final String SLASH= "/";
 	public static final String DELETE_ID= "deleteId";
 	public static final String UPDATE_ID= "updateId";
 	
 	
 	// End: Normal Text
}
