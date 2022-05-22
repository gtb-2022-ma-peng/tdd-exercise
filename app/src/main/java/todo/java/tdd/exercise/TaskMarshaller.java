package todo.java.tdd.exercise;

public class TaskMarshaller {

    Task unmarshal(int id, String line) {
        String[] fields = line.split(" ", 3);
        String name = fields[2];
        boolean isCompleted = fields[0].equals("x");
        boolean isDeleted = fields[1].equals("-");
        return new Task(id, name, isCompleted, isDeleted);
    }

    String marshal(Task task) {
        return "+ * " + task.getName();
    }
}
