import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class TaskManager {
    private static final String TEST_FILE = "tasks.csv";
    File file = new File(TEST_FILE);
    private final List<String> tasks;

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
    }
}

/*
 *
 * import java.io.*;
import com.opencsv.CSVWriter;

public class WriteDataCSV {
public static void main(String[] args) {
    File fileObj = new File("C:\\Users\\HP\\Desktop\\sampleFile.txt");
    try {
FileWriter resultFile = new FileWriter(fileObj);
CSVWriter csvWriterObj = new CSVWriter(resultFile);
String[] fileHeader = { "empName", "empDesig", "empSal" };
csvWriterObj.writeNext(fileHeader);
String[] emp1 = { "John", "Tutor", "35000" };
csvWriterObj.writeNext(emp1);
String[] emp2 = { "Joseph", "Instructor", "35000" };
csvWriterObj.writeNext(emp2);
String[] emp3 = { "Alex", "Software Engineer", "40000" };
csvWriterObj.writeNext(emp3);
String[] emp4 = { "Seth", "Designer", "30000" };
csvWriterObj.writeNext(emp4);
String[] emp5 = { "Ambrose", "Instructor", "35000" };
csvWriterObj.writeNext(emp5);
System.out.println("Data Written to the CSV File Successfully");             csvWriterObj.close();
}
catch (IOException excep) {
              excep.printStackTrace();
}
}
}
 */