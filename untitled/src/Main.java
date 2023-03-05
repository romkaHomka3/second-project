import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

    }
}

class Task {
    String title;
    String description;
    int id;
    String status;

    public Task(String title, String description, int id, String status) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.status = status;
    }
}

class Subtask extends Task {
    int epicId;

    public Subtask(String title, String description, int id, String status, int epicId) {
        super(title, description, id, status);
        this.epicId = epicId;
    }
}

class Epic extends Task {
    HashMap<Integer, Subtask> subtasks;

    public Epic(String title, String description, int id, String status) {
        super(title, description, id, status);
        subtasks = new HashMap<>();
    }
}

class Manager {
    int taskId;
    HashMap<Integer, Epic> epics;
    HashMap<Integer, Subtask> subtasks;
    HashMap<Integer, Task> tasks;
    
}