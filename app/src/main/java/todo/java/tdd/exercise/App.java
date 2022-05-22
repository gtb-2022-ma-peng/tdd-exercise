package todo.java.tdd.exercise;

import java.util.List;

/**
 * @author Ma Peng
 */
public class App {

    private final TaskRepository taskRepository = new TaskRepository();

    public static void main(String[] args) {
        new App().run("list").forEach(System.out::println);
    }

    public List<String> run(String ... args) {

        if (args.length <= 0) {
            throw new TodoException();
        }

        return CommandFactory.create(this.taskRepository, args).execute();
    }

}
