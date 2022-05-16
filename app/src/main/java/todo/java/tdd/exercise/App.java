package todo.java.tdd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ma Peng
 */
public class App {

    private final TaskRepository taskRepository = new TaskRepository();

    public static void main(String[] args) {
        System.out.println(Constants.USER_HOME_PATH);

    }

    public List<String> run() {
        List<Task> tasks = taskRepository.loadTasks();
        List<String> result = new ArrayList<>();
        result.add("# To be done");
        for (Task task : tasks) {
            result.add(task.format());
        }
        return result;
    }
}
