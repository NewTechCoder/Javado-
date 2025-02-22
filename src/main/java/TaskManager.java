import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TaskManager {
    private final List<String> tasks;
    String TEST_FILE = "tasks.csv";
    File csvFile = new File(TEST_FILE);

    public TaskManager()  {
        try {
            if (!csvFile.exists()) {
                csvFile.createNewFile();
            }
        } catch (IOException e) {
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
        try (CSVWriter writer = new CSVWriter(new FileWriter(this.csvFile),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            for (String task : tasks) {
                writer.writeNext(new String[]{task});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}