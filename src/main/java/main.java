import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        do {
            int choice = 0;

            System.out.println("\n=== Task Manager ===\n");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = scanner.nextInt();
                manager.processMenuChoice(choice);
            } catch (InputMismatchException | IllegalArgumentException e) {
                choice = -1;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("=== Add Task ===\n");
                    while (true) {
                        System.out.print("Title: ");
                        String title = scanner.nextLine().strip();
                        System.out.print("Description: ");
                        String description = scanner.nextLine().strip();
                        if ( !description.isBlank() && !title.isBlank() ) {
                            boolean status = false;
                            manager.addTask(new Task(title, description, status));
                            break;
                        } else System.out.println("Invalid Task!!\n");
                    }
                    System.out.println("\n=== Task Added ===");

                    break;
                case 2:
                    System.out.println("=== Task List ===\n");

                    if ( manager.listTasks().isEmpty() )
                        System.out.println("No tasks to display!\n");
                    else
                        manager.listTasks().forEach(task -> {
                            int taskNumber = manager.listTasks().indexOf(task) + 1;
                            System.out.println("Task (" + taskNumber + "): " + task.getTitle());
                            System.out.println("Description: " + task.getDescription());
                            System.out.println("Completed: " + task.isComplete());
                            System.out.println();
                        });

                    System.out.println("=== === === === ===");
                    break;
                case 3:
                    System.out.println("=== Task Done ===\n");
                    System.out.print("Title: ");
                    String titleToMark = scanner.nextLine();
                    System.out.print("Description: ");
                    String descriptionToMark = scanner.nextLine();
                    boolean statusToMark = false;
                    try {
                        manager.markTaskAsComplete(new Task(titleToMark, descriptionToMark, statusToMark));
                        System.out.println("\n=== Task Marked ===");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n=== Task Not Marked ===");
                    }
                    break;
                case 4:
                    // TODO: Handle Task Deletion Errors
                    System.out.println("=== Delete Task ===\n");
                    System.out.print("Title: ");
                    String titleToDel = scanner.nextLine();
                    System.out.print("Description: ");
                    String descriptionToDel = scanner.nextLine();
                    System.out.print("Is it completed? (Y/N): ");
                    boolean statusToDel = scanner.nextLine().equalsIgnoreCase("y");
                    try {
                        manager.deleteTask(new Task(titleToDel, descriptionToDel, statusToDel));
                        System.out.println("\n=== Task Deleted ===");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n=== Task Not Deleted ===");
                    }
                    break;
                case 5:
                    manager.exit();
                    System.out.println("Exiting......");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        } while (true);
    }
}