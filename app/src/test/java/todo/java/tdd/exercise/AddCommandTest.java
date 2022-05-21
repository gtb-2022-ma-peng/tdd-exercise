package todo.java.tdd.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Ma Peng
 * @date 2022/5/21.
 */
class AddCommandTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);
    }

    @Test
    void should_compose_task_name_using_multiple_args() {
        AddCommand addCommand = createCommandFrom("add", "foobar", "fizz");

        addCommand.execute();

        verify(taskRepository).create(new Task(0, "foobar fizz", false));
    }
    @Test
    void should_use_empty_name_when_no_args_provided() {
        AddCommand addCommand = createCommandFrom("add");

        addCommand.execute();

        verify(taskRepository).create(new Task(0, "", false));
    }

    private AddCommand createCommandFrom(String...strings) {
        return new AddCommand(taskRepository, strings);
    }
}
