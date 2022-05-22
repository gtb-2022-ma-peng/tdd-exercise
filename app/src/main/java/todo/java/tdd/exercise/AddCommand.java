package todo.java.tdd.exercise;

import java.util.List;

public class AddCommand extends Command {
    private final String[] args;

    public AddCommand(TaskRepository taskRepository, String... args) {
        super(taskRepository);
        this.args = args;
    }

    @Override
    List<String> execute() {
        String taskName = String.join(" ", args);
        taskRepository.create(new Task(0, taskName, false, false));
        return List.of();
    }

}
