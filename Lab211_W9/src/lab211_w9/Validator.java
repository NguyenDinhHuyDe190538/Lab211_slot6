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

public class Validator {
    private static final Scanner scanner = new Scanner(System.in);

    // Kiểm tra đầu vào dạng chuỗi (không rỗng)
    public static String checkInputString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.err.println("Giá trị không được rỗng. Vui lòng nhập lại.");
            }
        }
    }

    // Kiểm tra đầu vào dạng float với điều kiện lớn hơn giá trị min
    public static float checkInputFloat(String message, float min) {
        while (true) {
            System.out.print(message);
            try {
                float value = Float.parseFloat(scanner.nextLine());
                // Yêu cầu: Total area must be greater than 0.
                if (value > min) {
                    return value;
                } else {
                    System.err.println("Giá trị phải lớn hơn " + min + ". Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Giá trị không hợp lệ. Vui lòng nhập số thực.");
            }
        }
    }

    // Kiểm tra đầu vào dạng int trong phạm vi min-max (dùng cho Menu)
    public static int checkInputIntLimit(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.err.println("Lựa chọn nằm ngoài phạm vi. Vui lòng nhập số từ " + min + " đến " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.err.println("Đầu vào không hợp lệ. Vui lòng nhập một số nguyên.");
            }
        }
    }
}