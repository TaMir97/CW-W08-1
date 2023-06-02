package org.example.entity;

import java.util.Date;

public class Product {
    private int productID;
    private String productName;
    private Date createdDate;
    private int categoryID;
    private int brandID;

    public Product() {};

    public Product(String productName, Date createdDate, int categoryID, int brandID) {
        this.productName = productName;
        this.createdDate = createdDate;
        this.categoryID = categoryID;
        this.brandID = brandID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", createdDate=" + createdDate +
                ", categoryID=" + categoryID +
                ", brandID=" + brandID +
                '}';
    }
}
