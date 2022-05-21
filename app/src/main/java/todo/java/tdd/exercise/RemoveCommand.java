package todo.java.tdd.exercise;

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
        taskRepository.delete(Integer.valueOf(args[0]));
        return List.of();
    }
}
