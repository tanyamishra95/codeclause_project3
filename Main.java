import java.util.ArrayList;
import java.util.Scanner;

class Bug {
    private String title;
    private String description;
    private boolean resolved;

    public Bug(String title, String description) {
        this.title = title;
        this.description = description;
        this.resolved = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void markResolved() {
        this.resolved = true;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Description: " + description + ", Resolved: " + resolved;
    }
}

class BugTracker {
    private ArrayList<Bug> bugs;

    public BugTracker() {
        bugs = new ArrayList<>();
    }

    public void addBug(Bug bug) {
        bugs.add(bug);
    }

    public void listBugs() {
        for (Bug bug : bugs) {
            System.out.println(bug);
        }
    }

    public void markBugResolved(String title) {
        for (Bug bug : bugs) {
            if (bug.getTitle().equals(title)) {
                bug.markResolved();
                return;
            }
        }
        System.out.println("Bug with title '" + title + "' not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        BugTracker bugTracker = new BugTracker();

        
        Bug bug1 = new Bug("UI Issue", "The button is not aligned properly");
        Bug bug2 = new Bug("Login Error", "Users unable to login");

        bugTracker.addBug(bug1);
        bugTracker.addBug(bug2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. List Bugs");
            System.out.println("2. Mark Bug Resolved");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    bugTracker.listBugs();
                    break;
                case 2:
                    System.out.print("Enter bug title to mark as resolved: ");
                    String bugTitle = scanner.nextLine();
                    bugTracker.markBugResolved(bugTitle);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
