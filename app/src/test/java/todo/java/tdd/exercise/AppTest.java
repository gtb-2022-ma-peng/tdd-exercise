package todo.java.tdd.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {
    @Test
    void should_list_all_existing_tasks() {
        List<String> result = new App().run();
        Assertions.assertEquals(List.of("task 01", "task 02"), result);
    }
}
