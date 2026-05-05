package com.telstra.rest.constants;

public final class AppConstants {

    private AppConstants() {
        // prevent instantiation
    }

    // ---- API Paths ----
    public static final String BASE_API = "/orders/v1";
    public static final String SERVICE_ORDER = "/serviceOrder";
    public static final String ID_PATH = "/{id}";

    // ---- Messages ----
    public static final String ORDER_CREATED_SUCCESS = "Order created successfully";
    public static final String ORDER_UPDATED_SUCCESS = "Order updated successfully";
    public static final String ORDER_DELETED_SUCCESS = "Order deleted successfully";

    // ---- Error Messages ----
    public static final String ORDER_NOT_FOUND = "Order not found with id: ";
    public static final String DB_ERROR_CREATE = "DB error while creating order";
    public static final String DB_ERROR_FETCH = "DB error while fetching order";
    public static final String DB_ERROR_UPDATE = "DB error while updating order";
    public static final String DB_ERROR_DELETE = "DB error while deleting order";
    public static final String UNEXPECTED_ERROR = "Unexpected error occurred";

    // ---- Default Values ----
    public static final String DEFAULT_STATUS = "CREATED";
}