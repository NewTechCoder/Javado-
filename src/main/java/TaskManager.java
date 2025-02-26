import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    File csvFile = new File("tasks.csv");

    public TaskManager() throws IOException {
        this.tasks = new ArrayList<>();
        if ( !csvFile.exists() )
            System.out.println( csvFile.createNewFile() );

        try (  CSVReader reader = new CSVReader( new FileReader(this.csvFile) ) ) {
                String[] nextLine;
                while ( (nextLine = reader.readNext() ) != null) {
                    String title = nextLine[0].split(",")[0];
                    String description = nextLine[0].split(",")[1];
                    boolean status = Boolean.parseBoolean( nextLine[0].split(",")[2] );
                    addTask( new Task(title, description, status) );
                }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTask(Task task) { this.tasks.add(task); }

    public List<Task> listTasks() { return this.tasks; }

    public void deleteTask(Task task) {
        if ( !this.tasks.removeIf(i -> i.equals(task)) )
            throw new IllegalArgumentException( "Task not found!" );
    }

    public void markTaskAsComplete(Task task) {
        deleteTask(task);
        task.markAsCompleted();
        addTask(task);
    }

    public void exit() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(this.csvFile));
             CSVReader reader = new CSVReader(new FileReader(this.csvFile))) {
                String[] header = new String[]{ "Title,Description,isCompleted" };
                if ( reader.readNext() == null )
                    writer.writeNext(header, false);

                this.tasks.forEach(task -> {
                    boolean status = task.isComplete();
                    String title = task.getTitle();
                    String description = task.getDescription();
                    String row = String.format( "%s,%s,%b", title, description, status );
                    writer.writeNext( new String[]{row}, false );
                });
        } catch ( IOException | CsvValidationException e ) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

    public void processMenuChoice( int choice ) {
        if ( choice < 1 || choice > 5 )
            throw new IllegalArgumentException( "Invalid menu option!" );
    }
}