import java.util.InputMismatchException;
import java.util.Scanner;

public class Habit {
    String name;
    String type;
    boolean dailyCheck;
//----------------------------------------------------------------------------------------------------------------------
    protected void setName(Scanner in) {
        System.out.println("Habit Name: ");
        name = in.nextLine();
    }
//----------------------------------------------------------------------------------------------------------------------
    protected String getName() { return name; }
//----------------------------------------------------------------------------------------------------------------------
    protected void setType(Scanner in) {
        System.out.println("\tSelect a Category\n"
                + "1: Productivity\n"
                + "2: Self-Love\n"
                + "3: Health\n\n"
                + "Choice: ");
        try {
            boolean valid = false;
            while(!valid) {
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1:
                        type = "Productivity";
                        valid = true;
                        break;
                    case 2:
                        type = "Self-Love";
                        valid = true;
                        break;
                    case 3:
                        type = "Health";
                        valid = true;
                        break;
                    default:
                        System.out.println("** Choice not recognized, try again **");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("** Input Invalid **");
            in.nextLine();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    protected String getType() { return type; }
//----------------------------------------------------------------------------------------------------------------------
    protected boolean getDaily() { return dailyCheck; }
//----------------------------------------------------------------------------------------------------------------------
    protected void record() { dailyCheck = true; }
}
