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
public class FruitShop {
    private List<Fruit> fruits = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    
        public void run(){
            addFruits();
            showFruits();
            shopping();
            viewOrder();
            
        }
    private void addFruits(){
        fruits.add(new Fruit("01", "banana", 3.0, 12, "VN"));
        fruits.add(new Fruit("02", "orange", 3.5, 120, "VN"));
        fruits.add(new Fruit("03", "apple", 1.5, 100, "VN"));
    }
    public void showFruits(){
        System.out.println("| Item | Fruit Name | Origin | Price | Quantity");
        int i = 1;
        for(Fruit f : fruits) {
            System.out.printf("%-5d | %-10d | $.2f$ | %d\n",
                    i++, f.getName(),f.getOrigin(), f.getPrice(), f.getQuantity());
        }
    }
    
        private void shopping(){
        Order order1 = new Order("Hung"); // khach 1
        List<OrderDetail> bag = new ArrayList<>();
        
        Fruit item1 = fruits.get(1);
        int qty1 = 10;
        item1.setQuantity(item1.getQuantity()-qty1);
        
        Fruit item2 = fruits.get(2);
        int qty2 = 10;
        item2.setQuantity(item2.getQuantity()-qty2);
        bag.add(new OrderDetail(item2, qty2));
        
        
        for(OrderDetail od : bag){
            order1.addDetail(od); 
        }
        orders.add(order1);
        //lam them 1 khach hang mua nua??
    }
        
       private void viewOrder(){
           System.out.println("danh sach chi tiet mua hang");
           for(Order o : orders){
               System.out.println(o);
           }
       }
    
}
