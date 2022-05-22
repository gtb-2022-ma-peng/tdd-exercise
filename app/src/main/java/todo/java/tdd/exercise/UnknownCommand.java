package todo.java.tdd.exercise;

import java.util.List;

/**
 * @author Ma Peng
 * @date 2022/5/22.
 */
public class UnknownCommand extends Command {

    private final String commandName;

    public UnknownCommand(TaskRepository taskRepository, String commandName) {
        super(taskRepository);
        this.commandName = commandName;
    }

    @Override
    List<String> execute() {
        return List.of("Unknown command: " + commandName + "!");
    }
}
