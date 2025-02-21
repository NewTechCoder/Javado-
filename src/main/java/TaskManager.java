import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class TaskManager {
    private final List<String> tasks;
    private final PrintWriter printWriter;

    public TaskManager() {
        try {
            String TEST_FILE = "tasks.csv";
            File csvFile = new File(TEST_FILE);
            this.printWriter = new PrintWriter(csvFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        this.tasks.add(task);
    }

    public List<String> listTasks() {
        return this.tasks;
    }

    public void deleteTask(String task){
        this.tasks.remove(task);
    }

    public void exit() {
        this.tasks.forEach(this.printWriter::println);
        this.printWriter.close();
    }
}