import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TaskManager {
    private final List<Task> tasks;
    String TEST_FILE = "tasks.csv";
    File csvFile = new File(TEST_FILE);

    public TaskManager()  {
        try {
            this.tasks = new ArrayList<>();
            if (!csvFile.exists()) { csvFile.createNewFile(); }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTask(Task task) { this.tasks.add(task); }

    public List<Task> listTasks() { return this.tasks; }

    public void deleteTask(Task task) {
        for (Task i : this.tasks)
            if (i.isComplete() == task.isComplete())
                if (i.getTitle().equals(task.getTitle()) && i.getDescription().equals(task.getDescription())) {
                    this.tasks.remove(i);
                    break;
                    }
    }

    public void markTaskAsComplete(Task task) {
        deleteTask(task);
        task.markAsCompleted();
        addTask(task);
    }

    public void exit() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(this.csvFile),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            String[] header = new String[]{"Title,Description,isCompleted"};
            writer.writeNext(header);

            this.tasks.forEach(task -> {
                boolean status = task.isComplete();
                String title = task.getTitle();
                String description = task.getDescription();
                String row = String.format("%s,%s,%b", title, description, status);
                writer.writeNext(new String[]{row});
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}