package com.sully.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/9.
 * ����orders���Ӧ��ʵ����:

 */
public class Order implements Serializable {
    /**
     *
     CREATE TABLE orders(
     order_id INT PRIMARY KEY AUTO_INCREMENT,
     order_no VARCHAR(20),
     order_price FLOAT
     );
     INSERT INTO orders(order_no, order_price) VALUES('aaaa', 23);
     INSERT INTO orders(order_no, order_price) VALUES('bbbb', 33);
     INSERT INTO orders(order_no, order_price) VALUES('cccc', 22);
     );
     */

    //Orderʵ��������������orders���е��ֶ����ǲ�һ����
    private int id;                //id===>order_id
    private String orderNo;        //orderNo===>order_no
    private float price;        //price===>order_price

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderNo=" + orderNo + ", price=" + price+ "]";
    }
}