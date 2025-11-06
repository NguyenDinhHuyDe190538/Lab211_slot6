/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211_bai11_w8;

import java.util.Calendar;
import java.util.Scanner;


/**
 *
 * @author dinhh
 */
public class Validator {

    private final Scanner sc = new Scanner(System.in);

    public int getValidYear() {
        int current = Calendar.getInstance().get(Calendar.YEAR);
        while (true) {
            try {
                System.out.print("Birth year (1900–" + current + "): ");
                int y = Integer.parseInt(sc.nextLine());
                if (y >= 1900 && y <= current) {
                    return y;
                }
            } catch (Exception e) {
                // ignore
            }
            System.out.println("Invalid year!");
        }
    }

    public String getValidPhone() {
        while (true) {
            System.out.print("Phone (>=10 digits): ");
            String p = sc.nextLine();

            if (p.length() < 10) {
                System.out.println("Invalid phone! Must be at least 10 digits.");
                continue;
            }

            boolean isAllDigits = true;
            for (int i = 0; i < p.length(); i++) {
                if (!Character.isDigit(p.charAt(i))) {
                    isAllDigits = false;
                    break;
                }
            }

            if (isAllDigits) {
                return p;
            } else {
                System.out.println("Invalid phone! Must contain only digits.");
            }
        }
    }

    public String getValidEmail() {
        while (true) {
            System.out.print("Email: ");
            String email = sc.nextLine().trim();

            if (email.isEmpty()) {
                System.out.println("Email cannot be empty!");
                continue;
            }

            int atIndex = email.indexOf('@');
            if (atIndex <= 0 || atIndex == email.length() - 1) {
                System.out.println("Invalid email! Must contain '@' and not at the start/end.");
                continue;
            }

            int dotIndex = email.lastIndexOf('.');
            if (dotIndex <= atIndex + 1 || dotIndex == email.length() - 1) {
                System.out.println("Invalid email! Must contain a '.' after '@' and not at the end.");
                continue;
            }

            String domainPart = email.substring(dotIndex + 1);
            if (domainPart.length() < 2) {
                System.out.println("Invalid email! Domain extension must be at least 2 characters.");
                continue;
            }
            return email;
        }
    }

    public int getIntRange(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                }
            } catch (Exception ignored) {
            }
            System.out.print("Enter again (" + min + "–" + max + "): ");
        }
    }
}
