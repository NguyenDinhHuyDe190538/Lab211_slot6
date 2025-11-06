/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211_w9;

/**
 *
 * @author dinhh
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ManageEastAsiaCountries {
    private List<EastAsiaCountries> countryList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addCountryInformation() {
        System.out.println("====== Input the information of 11 countries in East Asia ======");
        
        while (countryList.size() < 11) {
            System.out.println("--- Nhập thông tin nước thứ " + (countryList.size() + 1) + " ---");
            
            // Sử dụng Validator
            String code = Validator.checkInputString("Enter code of country: ");

            // Sử dụng Validator
            String name = Validator.checkInputString("Enter name of country: ");

            // Sử dụng Validator (Total area must be greater than 0)
            float area = Validator.checkInputFloat("Enter total Area (>0): ", 0);

            // Sử dụng Validator
            String terrain = Validator.checkInputString("Enter terrain of country: ");

            EastAsiaCountries newCountry = new EastAsiaCountries(code, name, area, terrain);
            countryList.add(newCountry);

            System.out.println("Đã thêm thành công. Số lượng hiện tại: " + countryList.size() + "/11.");
            
            if (countryList.size() < 11) {
                System.out.print("Bạn có muốn tiếp tục nhập (Y/N)? ");
                if (scanner.nextLine().trim().equalsIgnoreCase("N")) {
                    break;
                }
            }
        }
    }

    public void getRecentlyEnteredInformation() {
        if (countryList.isEmpty()) {
            System.err.println("Chưa có thông tin quốc gia nào được nhập.");
            return;
        }
        
        System.out.println("================== Information of Countries You've Just Input ==================");
        System.out.printf("%-10s%-20s%-15s%-15s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries country : countryList) {
            country.display();
        }
    }

    public List<EastAsiaCountries> searchInformationByName() {
        if (countryList.isEmpty()) {
            System.err.println("Không có dữ liệu để tìm kiếm.");
            return Collections.emptyList();
        }

        String searchName = Validator.checkInputString("Enter the name you want to search for: ");
        List<EastAsiaCountries> resultList = new ArrayList<>();

        for (EastAsiaCountries country : countryList) {
            if (country.getCountryName().toLowerCase().contains(searchName.toLowerCase())) {
                resultList.add(country);
            }
        }

        if (resultList.isEmpty()) {
            System.out.println("Không tìm thấy quốc gia nào có tên chứa '" + searchName + "'.");
        } else {
            System.out.println("================== Search Results ==================");
            System.out.printf("%-10s%-20s%-15s%-15s\n", "ID", "Name", "Total Area", "Terrain");
            for (EastAsiaCountries country : resultList) {
                country.display();
            }
        }
        return resultList;
    }

    public void sortInformationByAscendingOrder() {
         if (countryList.isEmpty()) {
            System.err.println("Không có dữ liệu để sắp xếp.");
            return;
        }
        
        List<EastAsiaCountries> sortedList = new ArrayList<>(countryList);

        Collections.sort(sortedList, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries c1, EastAsiaCountries c2) {
                return c1.getCountryName().compareTo(c2.getCountryName());
            }
        });

        System.out.println("================== Countries Sorted By Name (Ascending) ==================");
        System.out.printf("%-10s%-20s%-15s%-15s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries country : sortedList) {
            country.display();
        }
    }
    
    public int displayMenu() {
        System.out.println("\n==========================================================================");
        System.out.println("                                M E N U                                     ");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("==========================================================================");
        
        // Sử dụng Validator
        return Validator.checkInputIntLimit("Enter your option (1-5): ", 1, 5);
    }
}