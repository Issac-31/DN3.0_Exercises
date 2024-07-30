class TaskNode {
    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private TaskNode head;

    public TaskManagementSystem() {
        this.head = null;
    }

    // Add a task to the list
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added: " + task);
    }

    // Search for a task by taskId
    public Task searchTask(String taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse all tasks
    public void traverseTasks() {
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by taskId
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            System.out.println("Task deleted with ID: " + taskId);
            return;
        }

        TaskNode current = head;
        TaskNode previous = null;
        while (current != null && !current.task.getTaskId().equals(taskId)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
            System.out.println("Task deleted with ID: " + taskId);
        } else {
            System.out.println("Task not found with ID: " + taskId);
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        Task task1 = new Task("T001", "Design database schema", "In Progress");
        Task task2 = new Task("T002", "Implement authentication", "Not Started");
        Task task3 = new Task("T003", "Set up CI/CD pipeline", "Completed");

        tms.addTask(task1);
        tms.addTask(task2);
        tms.addTask(task3);

        System.out.println("\nTraversing all tasks:");
        tms.traverseTasks();

        System.out.println("\nSearching for task with ID T002:");
        Task searchedTask = tms.searchTask("T002");
        if (searchedTask != null) {
            System.out.println("Task found: " + searchedTask);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting task with ID T001:");
        tms.deleteTask("T001");

        System.out.println("\nTraversing all tasks after deletion:");
        tms.traverseTasks();
    }
}


class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
