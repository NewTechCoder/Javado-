import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<String> tasks; // hint: will change in iteration 3

    public TaskManager() {
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
        this.tasks.clear();
    }
}