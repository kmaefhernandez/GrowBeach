import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Habit {
    private String name;
    private String type;
    private boolean check;
    private String frequency;
    private Instant end;

    public Habit() {
        this.name = "Habit";
        this.type = "Type";
        this.check = false;
        this.frequency = "hourly";
        this.end = Instant.now().plus(1, ChronoUnit.HOURS);

    }
//----------------------------------------------------------------------------------------------------------------------
    public Habit(String name, String type, boolean check, String frequency, Instant end) {
        this.name = name;
        this.type = type;
        this.check = check;
        this.frequency = frequency;
        this.end = end;
    }
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
    protected void setFrequency(Scanner in) {
        System.out.println("\tSelect a Frequency\n"
                + "1: Daily\n"
                + "2: Hourly\n\n"
                + "Choice: ");
        try {
            boolean valid = false;
            while(!valid) {
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1:
                        frequency = "Daily";
                        end = Instant.now().plus(1, ChronoUnit.DAYS);
                        valid = true;
                        break;
                    case 2:
                        frequency = "Hourly";
                        end = Instant.now().plus(1, ChronoUnit.HOURS);
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
    protected String getFrequency() { return frequency; }
//----------------------------------------------------------------------------------------------------------------------
    protected boolean getCheck() { return check; }
//----------------------------------------------------------------------------------------------------------------------
    protected Instant getEnd() { return end; }
//----------------------------------------------------------------------------------------------------------------------
    protected void record() {
        if(Instant.now().isBefore(end)) {
            System.out.println(this.getName() + " Completed: true");
            check = true;
        } else {
            System.out.println(this.getName() + " Completed: false");
            check = false;
        }
        if(frequency.equals("Hourly")) {
            end = Instant.now().plus(1, ChronoUnit.HOURS);
        } else {
            end = Instant.now().plus(1, ChronoUnit.DAYS);
        }
    }
}
