package todo.java.tdd.exercise;

import java.util.Arrays;

public class CommandFactory {

    private CommandFactory() {
    }

    static Command create(TaskRepository taskRepository, String[] args) {
        String commandName = args[0];
        String[] restArgs = Arrays.copyOfRange(args, 1, args.length);

        Command command = new ListCommand(taskRepository);
        if (commandName.equals("add")) {
            command = new AddCommand(taskRepository, restArgs);
        }

        if (commandName.equals("remove")) {
            command = new RemoveCommand(taskRepository, restArgs);
        }
        return command;
    }
}
