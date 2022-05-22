package todo.java.tdd.exercise;

import java.util.List;

/**
 * @author Ma Peng
 * @date 2022/5/22.
 */
public abstract class Command {
    final TaskRepository taskRepository;

    protected Command(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    abstract List<String> execute();
}
