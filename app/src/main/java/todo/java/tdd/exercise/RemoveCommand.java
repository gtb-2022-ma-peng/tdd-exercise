package todo.java.tdd.exercise;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ma Peng
 * @date 2022/5/21.
 */
public class RemoveCommand {
    private final TaskRepository taskRepository;
    private final String[] args;

    public RemoveCommand(TaskRepository taskRepository, String...args) {
        this.taskRepository = taskRepository;
        this.args = args;
    }

    public List<String> execute() {
        Arrays.stream(args).map(Integer::valueOf).forEach(this.taskRepository::delete);
        return List.of();
    }
}
