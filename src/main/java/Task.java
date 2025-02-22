public class Task {
    private final String taskName;
    private final String taskDescription;
    private boolean isTaskCompleted;

    public Task(String taskName, String taskDescription, boolean isTaskCompleted) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isTaskCompleted = isTaskCompleted;
    }

    public String getTitle() { return taskName; }

    public String getDescription() { return taskDescription; }

    public boolean isComplete() { return isTaskCompleted; }

    public void markAsCompleted() { isTaskCompleted = true; }
}