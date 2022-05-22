package todo.java.tdd.exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Ma Peng
 * @date 2022/5/22.
 */
class RemoveCommandTest {

    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(TaskRepository.class);

        when(taskRepository.all()).thenReturn(List.of(
                new Task(1, "Task 01", false, false),
                new Task(2, "Task 02", false, false),
                new Task(3, "Task 03", false, false),
                new Task(4, "Task 04", false, false)
        ));
    }

    @Test
    void should_remove_multiple_tasks() {

        RemoveCommand removeCommand = new RemoveCommand(taskRepository,"1","3");

        removeCommand.execute();

        verify(taskRepository).delete(1);
        verify(taskRepository).delete(3);
    }
    @Test
    void should_only_remove_existing_tasks() {

        RemoveCommand removeCommand = new RemoveCommand(taskRepository,"1", "3", "404");


        removeCommand.execute();

        verify(taskRepository).delete(1);
        verify(taskRepository).delete(3);
        verify(taskRepository, never()).delete(404);
    }

}
