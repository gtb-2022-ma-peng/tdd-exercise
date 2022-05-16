package todo.java.tdd.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Ma Peng
 * @date 2022/5/16.
 */
class TaskFactoryTest {
    @Test
    void should_parse_completed_property_for_task(){
        boolean isCompleted = TaskFactory.createTask(1, "+ task 01").isCompleted();
        Assertions.assertFalse(isCompleted);
    }

    @Test
    void should_support_name_with_multiple_spaces() {
        Assertions.assertEquals("   foo   fo  ", TaskFactory.createTask(1, "+    foo   fo  ").getName());
    }
}