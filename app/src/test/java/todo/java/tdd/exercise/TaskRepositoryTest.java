package todo.java.tdd.exercise;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ma Peng
 * @date 2022/5/22.
 */
class TaskRepositoryTest {
    @Test
    void should_delete_multiple_tasks() {

        TaskRepository taskRepository = new TaskRepository();

        taskRepository.delete(1);
        taskRepository.delete(3);

        List<Task> result = taskRepository.loadTasks();

        assertEquals(List.of(
                new Task(2, "task 02", false, false),
                new Task(4, "task 04", true, false)
        ), result);
    }

}
