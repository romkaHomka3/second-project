import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        printMainMenu();
        int switchMain = scanner.nextInt();
        while (switchMain != 3) {
            if (switchMain == 1) {
                printTaskMenu();
                int switchTask = scanner.nextInt();
                switch (switchTask) {
                    case 1 -> {
                        manager.getAllTasks();
                    }
                    case 2 -> {
                        manager.deleteAllTask();
                    }
                    case 3 -> {
                        System.out.println("Введите идентификатор задачи");
                        System.out.println(manager.getTaskByNumber(scanner.nextInt()).toString());
                    }
                    case 4 -> {
                        manager.createTask(new Task());
                        System.out.println("Задача успешно создана");
                    }
                    case 5 -> {
                        System.out.println("Введите идентификатор задачи");
                        manager.UpdateTask(scanner.nextInt(), new Task());
                    }
                    case 6 -> {
                        System.out.println("Введите идентификатор задачи");
                        manager.deleteTask(scanner.nextInt());
                    }
                    case 7 -> {
                    }
                    default -> {
                        break;
                    }
                }
            }
            printMainMenu();
            switchMain = scanner.nextInt();
        }

    }

    static void printMainMenu() {
        System.out.println("Выберите тип задач");
        System.out.println("1. Задачи (Task)");
        System.out.println("2. Эпики (Epic)");
        System.out.println("3. Выход");
    }

    static void printTaskMenu() {
        System.out.println("1. Получить список всех задач");
        System.out.println("2. Удаление всех задач");
        System.out.println("3. Получение задачи по идентификатору");
        System.out.println("4. Создание задачи");
        System.out.println("5. Обновление задачи");
        System.out.println("6. Удаление по идентификатору");
        System.out.println("7. Выход");

    }


}

class Task {
    String title;
    String description;
    String status;

    public Task() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите (через Enter)");
        System.out.println("1.Укажите название задачи");
        System.out.println("2. Укажите описание задачи");
        this.title = scanner.nextLine();
        this.description = scanner.nextLine();
        this.status = "NEW";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" + "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'';
    }

}

class Subtask extends Task {
    int epicId;

    public Subtask(String title, String description, int id, String status, int epicId) {
        super();
        this.epicId = epicId;
    }
}

class Epic extends Task {
    HashMap<Integer, Subtask> subtasks;

    public Epic(String title, String description, int id, String status) {
        super();
        subtasks = new HashMap<>();
    }
}

class Manager {
    int taskId;
    HashMap<Integer, Epic> epics;
    HashMap<Integer, Subtask> subtasks;
    HashMap<Integer, Task> tasks;

    public Manager() {
        this.taskId = 0;
        epics = new HashMap<>();
        subtasks = new HashMap<>();
        tasks = new HashMap<>();
    }

//    void createTask() {
//        Scanner scanner = new Scanner(System.in);
//        String title = scanner.nextLine();
//        String description = scanner.nextLine();
//        Task task = new Task(title, description, "NEW");
//        tasks.put(taskId, task);
//        taskId += 1;
//    }

    Task createTask(Task task) {
        tasks.put(taskId, task);
        taskId += 1;
        return task;
    }

    void createEpic() {

    }

    void createSubTask() {

    }

    void getAllTasks() {
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            System.out.println(entry.toString());
        }
    }

    void deleteAllTask() {
        tasks.clear();
        System.out.println("Удаление всех задач - успешно");
    }

    Task getTaskByNumber(int taskId) {
        return tasks.get(taskId);
    }

    void UpdateTask(int id, Task newTask) {
        tasks.put(id, newTask);
        System.out.println("Обновление задачи с ключом " + taskId + " - успешно");
    }

    void deleteTask(int taskId) {
        tasks.remove(taskId);
        System.out.println("Удаление задачи с ключом " + taskId + " - успешно");
    }

}
