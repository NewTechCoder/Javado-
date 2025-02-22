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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskName.equals(task.taskName)
                && taskDescription.equals(task.taskDescription)
                && isTaskCompleted == task.isTaskCompleted;
    }
}