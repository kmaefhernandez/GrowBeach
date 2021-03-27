/* Marina Hacks project! Plan is to design a mobile app that encourages you to limit grind by growing a healthy
aquarium as you maintain a healthy work balance
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    int enviroState = 0; // Scale 0-3 with 0 being very dirty and 3 being very clean
    ArrayList<Habit> userHabits = new ArrayList<>(0); // Collection of user created habits, represented by fish

    public static void main(String[] args) {
        
        //new OceanFrame();
        new Main().menu();
    }
//----------------------------------------------------------------------------------------------------------------------
    public void menu() {
        Scanner in = new Scanner(System.in);
        try {
            boolean valid = true;
            while (valid) {
                System.out.println("\tWelcome to the beach!\n"
                + "1: Add Habit\n"
                + "2: Record Habit\n"
                + "3: Update Beach\n"
                + "4: Exit\n\n"
                + "Choice: ");
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1:
                        Habit habit = new Habit();
                        habit.setName(in);
                        habit.setType(in);
                        userHabits.add(habit);
                        System.out.println(habit.getName() + " Added");
                        break;
                    case 2:
                        recordSelection(in);
                        break;
                    case 3:
                        System.out.println("3");
                        break;
                    case 4:
                        System.out.println("Exiting, Goodbye!");
                        valid = false;
                        break;
                    default:
                        System.out.println("** Choice not recognized, try again **");
                }
            }
            in.close();
            System.exit(0);
        } catch (InputMismatchException e) {
            System.out.println("** Input Invalid **");
            menu();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void recordSelection(Scanner in) {
        int i = 0;
        for (Habit elem : userHabits) {
            System.out.println(i + ": " + elem.name);
            i++;
        }
        try {
            boolean valid = false;
            while(!valid) {
                System.out.println("Habit Completed: ");
                int choice = in.nextInt();
                in.nextLine();
                if(choice >= userHabits.size() || choice < 0) {
                    System.out.println("** Out Of Bounds **");
                } else {
                    Habit h = userHabits.get(choice);
                    h.record();
                    System.out.println(h.getName() + " Completed: " + h.getDaily());
                    enviroState += 1;
                    valid = true;
                }
            }
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("** Invalid Input **");
            in.nextLine();
        }
    }
}
