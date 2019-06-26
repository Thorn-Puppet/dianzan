package com.zan.vo;

public class ProductVO {
    private long product_Id;
    private String product_Name;
    private long product_Min_Price;
    private boolean zan;

    public ProductVO() {
    }

    public ProductVO(long product_Id, String product_Name, long product_Min_Price, boolean zan) {
        this.product_Id = product_Id;
        this.product_Name = product_Name;
        this.product_Min_Price = product_Min_Price;
    }

    public long getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(long product_Id) {
        this.product_Id = product_Id;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public long getProduct_Min_Price() {
        return product_Min_Price;
    }

    public void setProduct_Min_Price(long product_Min_Price) {
        this.product_Min_Price = product_Min_Price;
    }

    public boolean isZan() {
        return zan;
    }

    public void setZan(boolean zan) {
        this.zan = zan;
    }
}
