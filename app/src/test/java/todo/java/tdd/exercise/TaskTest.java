package todo.java.tdd.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author Ma Peng
 * @date 2022/5/22.
 */
class TaskTest {

    @Nested
    class EqualsTest {
        @Nested
        class ShouldReturnTrueTest {
            @Test
            void when_all_properties_are_same() {
                Assertions.assertEquals(new Task(1, "foobar", false, false), new Task(1, "foobar", false, false));
            }
        }
        @Nested
        class ShouldReturnFalseTest {
            @Test
            void when_all_properties_is_different() {
                Assertions.assertNotEquals(new Task(1, "foobar", true, false), new Task(1, "foobar", false, false));
            }
        }
    }

}
