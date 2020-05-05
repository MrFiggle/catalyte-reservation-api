package io.training.catalyte.hotelapi.constants;

public class StringConstants {

  public static final String DATE_FORMAT = "MM-dd-yyyy";
  public static final String DATE_FORMAT_ERROR = "date did not meet required format of MM-dd-yyyy";


  public static final String NOT_FOUND = "Not Found";
  public static final String SERVER_ERROR = "Server Error";
  public static final String REQUIRED_FIELD = " is a required field";
  public static final String PASSWORD_INVALID = "Password should be at least 8 characters.";
  public static final String INVALID_ZIP = "Zip should be a valid 5 or 9 digit zip code.";
  public static final String EMAIL_INVALID = "Email should be a well-formed email address.";
  public static final String INVALID_NUMBER = " must be greater than or equal to 0.";
  public static final String SERVER_ERROR_MESSAGE = "An unexpected error occurred.";
  public static final String DATABASE_EXCEPTION = "Database exception";
  public static final String CONFLICT_ERROR = "Conflict with information currently stored in the database";

  // Auth
  public static final String UNAUTHORIZED = "Unauthorized";
  public static final String INVALID_EMAIL_PASSWORD = "Invalid email or password.";
  public static final String ISSUER = "gcapi";
  public static final String SECRET_KEY = "secret";
  public static final String CLAIMS_ATTRIBUTE = "claims";
  public static final String EMAIL_ATTRIBUTE = "email";
  public static final String ROLES_ATTRIBUTE = "roles";
  public static final String MANAGER_ROLE_TYPE = "manager";
  public static final String EMPLOYEE_ROLE_TYPE = "employee";
  public static final String AUTHORIZATION_HEADER_NAME = "Authorization";
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String MISSING_INVALID_ERROR = "Missing or invalid Authorization header";
  public static final String APPLICATION_JSON = "application/json";

  // User Domain
  public static final String USER_NOT_FOUND_LOG = "Unable to retrieve user with id of ";
  public static final String USER_NOT_FOUND = "User not found.";
  public static final String USER_EMAIL_CONFLICT_LOG = "Attempted addUser but a conflict occurred with email: ";
  public static final String USER_EMAIL_CONFLICT = "Email already in use.";
  public static final String INVALID_ROLES_LOG = "Invalid roles provided";
  public static final String INVALID_ROLES = "Roles should be ADMIN and/or EMPLOYEE.";
  public static final String ERROR_LOG = "Error: ";
}
