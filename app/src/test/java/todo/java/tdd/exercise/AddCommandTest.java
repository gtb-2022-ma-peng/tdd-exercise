package todo.java.tdd.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Ma Peng
 * @date 2022/5/21.
 */
class AddCommandTest {
    @Test
    void should_compose_task_name_using_multiple_args() {
        final var taskRepository = new TaskRepository() {

            private Task task;

            @Override
            List<String> create(Task task) {
                this.task = task;
                return List.of();
            }

            public String getName() {
                return this.task.getName();
            }
        };
        AddCommand addCommand = new AddCommand(taskRepository, "add", "foobar", "fizz");

        addCommand.execute();

        String taskName = taskRepository.getName();
        Assertions.assertEquals("foobar fizz", taskName);
    }
}
