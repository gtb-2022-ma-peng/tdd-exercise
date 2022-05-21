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

    private MyTaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new MyTaskRepository();
    }

    @Test
    void should_compose_task_name_using_multiple_args() {
        AddCommand addCommand = new AddCommand(taskRepository, "add", "foobar", "fizz");

        addCommand.execute();

        Assertions.assertEquals("foobar fizz", taskRepository.getName());
    }
    @Test
    void should_use_empty_name_when_no_args_provided() {
        AddCommand addCommand = new AddCommand(taskRepository, "add");

        addCommand.execute();

        Assertions.assertEquals("", taskRepository.getName());
    }

    private static class MyTaskRepository extends TaskRepository {

        private Task task;

        @Override
        List<String> create(Task task) {
            this.task = task;
            return List.of();
        }

        public String getName() {
            return this.task.getName();
        }
    }
}
