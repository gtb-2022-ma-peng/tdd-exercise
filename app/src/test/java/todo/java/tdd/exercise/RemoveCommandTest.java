package todo.java.tdd.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Ma Peng
 * @date 2022/5/22.
 */
class RemoveCommandTest {

    @BeforeEach
    void setUp() {
        TestUtil.writeDataFile(List.of(
                "+ * task 01",
                "+ * task 02",
                "x * task 03",
                "x * task 04"));
    }

    @Test
    void should_remove_multiple_tasks() {
        TaskRepository taskRepository = mock(TaskRepository.class);

        RemoveCommand removeCommand = new RemoveCommand(taskRepository,"1","3");

        removeCommand.execute();

        verify(taskRepository).delete(1);
        verify(taskRepository).delete(3);
    }

}
