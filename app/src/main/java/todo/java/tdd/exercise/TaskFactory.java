package todo.java.tdd.exercise;

public class TaskFactory {
    private TaskFactory() {
    }

    static Task createTask(int id, String line) {
        String[] fields = line.split(" ", 3);
        String name = fields[2];
        boolean isCompleted = fields[0].equals("x");
        boolean isDeleted = fields[1].equals("-");
        return new Task(id, name, isCompleted, isDeleted);
    }

    static String objectToString(Task task) {
        return "+ * " + task.getName();
    }
}
