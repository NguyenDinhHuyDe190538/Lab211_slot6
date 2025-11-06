/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab211_bai11_w8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dinhh
 */
public class CandidateManager {

    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Candidate> list = new ArrayList<>();
    private final Validator validator = new Validator();

    public void run() {
        while (true) {
            System.out.println("\nCANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = validator.getIntRange(1, 5);
            switch (choice) {
                case 1 ->
                    createExperience();
                case 2 ->
                    createFresher();
                case 3 ->
                    createIntern();
                case 4 ->
                    searchCandidate();
                case 5 -> {
                    System.out.println("Program exited.");
                    return;
                }
            }
        }
    }

    public Candidate inputCommonInfo(int type) {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("First name: ");
        String fn = sc.nextLine();
        System.out.print("Last name: ");
        String ln = sc.nextLine();
        int birth = validator.getValidYear();
        System.out.print("Address: ");
        String addr = sc.nextLine();
        String phone = validator.getValidPhone();
        String email = validator.getValidEmail();
        return new Candidate(id, fn, ln, birth, addr, phone, email, type);
    }

    public void createExperience() {
        do {
            Candidate c = inputCommonInfo(0);
            System.out.print("Years of experience (0–100): ");
            int exp = validator.getIntRange(0, 100);
            System.out.print("Professional skill: ");
            String skill = sc.nextLine();
            list.add(new Experience(c, exp, skill));
            System.out.print("Do you want to continue (Y/N)? ");
        } while (sc.nextLine().equalsIgnoreCase("Y"));
    }

    public void createFresher() {
        do {
            Candidate c = inputCommonInfo(1);
            System.out.print("Graduation date: ");
            String date = sc.nextLine();
            
            String rank;
            do {
                System.out.print("Graduation rank (Excellence, Good, Fair, Poor): ");
                rank = sc.nextLine();
            } while (!rank.matches("(?i)Excellence|Good|Fair|Poor")); 
            
            System.out.print("Education: ");
            String edu = sc.nextLine();
            
            list.add(new Fresher(c, date, rank, edu));
            System.out.print("Do you want to continue (Y/N)? ");
        } while (sc.nextLine().equalsIgnoreCase("Y"));
    }

    public void createIntern() {
        do {
            Candidate c = inputCommonInfo(2);
            System.out.print("Major: ");
            String major = sc.nextLine();

            System.out.print("Semester: ");
            int sem = validator.getIntRange(1, 10);

            System.out.print("University name: ");
            String uni = sc.nextLine();

            list.add(new Intern(c, major, sem, uni));
            System.out.print("Do you want to continue (Y/N)? ");
        } while (sc.nextLine().equalsIgnoreCase("Y"));
    }

    public void searchCandidate() {
        System.out.println("\nList of candidates:");
        for (Candidate c : list) {
            System.out.println(c.getFullName());
        }
        System.out.print("\nEnter candidate name (first or last): ");
        String name = sc.nextLine().toLowerCase();

        System.out.print("Enter type (0=Exp,1=Fresher,2=Intern): ");
        int type = validator.getIntRange(0, 2);
        System.out.println("\nThe candidates found:");
     
        for (Candidate c : list) {
            String first = c.getFirstName().toLowerCase();
            String last = c.getLastName().toLowerCase();
            
            if (c.getCandidateType() == type && (first.contains(name) || last.contains(name))) {
                System.out.println(c);
            }
        }
    }
}
