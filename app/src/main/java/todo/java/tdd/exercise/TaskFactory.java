package todo.java.tdd.exercise;

public class TaskFactory {
    private TaskFactory() {
    }

    static Task createTask(int id, String line) {
        String[] fields = line.split(" ", 2);
        String name = fields[1];
        boolean isCompleted = fields[0].equals("x");
        return new Task(id, name, isCompleted);
    }
}