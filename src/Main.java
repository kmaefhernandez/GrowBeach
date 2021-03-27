/*  Marina Hacks project! Plan is to design a mobile app that encourages you to limit grind by growing a healthy
 *  aquarium as you maintain a healthy work balance
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new OceanFrame();
        new Main().menu();
    }
    public void menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the beach!");
        System.out.println("1: Add Habit");
        System.out.println("2: Record Habit");
        System.out.println("3: Update Beach");
        System.out.println("4: Exit");
        try {
            boolean valid = false;
            while (!valid) {
                System.out.print("Choice = ");
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("1");
                        valid = true;
                        break;
                    case 2:
                        System.out.println("2");
                        valid = true;
                        break;
                    case 3:
                        System.out.println("3");
                        valid = true;
                        break;
                    case 4:
                        System.out.println("4");
                        System.exit(0);
                    default:
                        System.out.println("Choice not recognized, try again");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Invalid");
            menu();
        }
    }
}