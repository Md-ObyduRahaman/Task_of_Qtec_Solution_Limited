package com.ecommerce.ProductManagementAPI.constants;

public final class ProductsConstants {

    private ProductsConstants() {
        // restrict instantiation
    }
    public static final String  STATUS_201 = "201";
    public static final String  MESSAGE_201 = "Product created successfully";
    public static final String  STATUS_202 = "202";
    public static final String  MESSAGE_202 = "Product Deleted successfully";
    public static final String  STATUS_200 = "200";
    public static final String  MESSAGE_200 = "updated successfully";
    public static final String  STATUS_417 = "417";
    public static final String  MESSAGE_417_UPDATE= "Update operation failed. Please try again or contact Dev team";
    public static final String  MESSAGE_417_DELETE= "Delete operation failed. Please try again or contact Dev team";
    public static final String  STATUS_418 = "418";
    public static final String  MESSAGE_418_STOCK_UPDATE= "StockQuantity Update operation failed. Please try again or contact Dev team";

}
