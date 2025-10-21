/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211_w6_bai1;

/**
 *
 * @author dinhh
 */
public class OrderDetail {
    private Fruit fruit; // thuoc tinh co kieu doi tuong ? 
    private int quantity;
    private double amount;

    public OrderDetail(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.amount = fruit.getPrice() * quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %5d | %5.2f$ | %5.2f$", fruit.getName(), quantity );
    }
  
}
