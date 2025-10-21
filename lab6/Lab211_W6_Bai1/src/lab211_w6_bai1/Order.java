/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211_w6_bai1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dinhh
 */
public class Order {

    private String customerName;
    private List<OrderDetail> items = new ArrayList<>();
    private double total;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public void addDetail(OrderDetail od) {
        items.add(od);
        total += od.getAmount();
    }

    public String GetcustomerName() {
        return customerName;
    }

    public List<OrderDetail> getDetails() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customerName).append("\n");
        sb.append("Product      | Qty | Price | Amount\n");
        int i = 1;
        for (OrderDetail od : items) {
            sb.append(i++).append(" .").append(od.toString()).append("\n");
        }
        sb.append("Total: ").append(String.format("%.2f$", total)).append("\n");
        return sb.toString();
    }

}
