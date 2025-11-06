/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211_w9;

/**
 *
 * @author dinhh
 */
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        int choice;

        do {
            choice = manager.displayMenu();
            
            switch (choice) {
                case 1:
                    manager.addCountryInformation();
                    break;
                case 2:
                    manager.getRecentlyEnteredInformation();
                    break;
                case 3:
                    manager.searchInformationByName();
                    break;
                case 4:
                    manager.sortInformationByAscendingOrder();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
            }
            
            if (choice != 5) {
                System.out.print("Nhấn Enter để quay lại Menu...");
                new Scanner(System.in).nextLine();
            }
        } while (choice != 5);
    }
}