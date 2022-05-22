package todo.java.tdd.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> ids = Arrays.stream(args).map(Integer::valueOf).collect(Collectors.toList());
        taskRepository.all().stream()
                .filter(task -> ids.contains(task.getId()))
                .forEach(task -> taskRepository.delete(task.getId()));
        return List.of();
    }
}
