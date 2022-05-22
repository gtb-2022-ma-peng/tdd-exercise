package todo.java.tdd.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author Ma Peng
 * @date 2022/5/16.
 */
class TaskMarshallerTest {

    private TaskMarshaller taskMarshaller;


    @BeforeEach
    void setUp() {
        taskMarshaller = new TaskMarshaller();
    }

    @ParameterizedTest
    @MethodSource("lines_and_tasks")
    void should_marshal_to_plain_text(String line, Task task) {
        Assertions.assertEquals(line, taskMarshaller.marshal(task));
    }

    @ParameterizedTest
    @MethodSource("lines_and_tasks")
    void should_unmarshal_to_plain_text(String line, Task task) {
        Assertions.assertEquals(task, taskMarshaller.unmarshal(0, line));
    }
    public static Stream<Arguments> lines_and_tasks() {
        return Stream.of(
                Arguments.of("+ * task 01", new Task(0, "task 01", false, false)),
                Arguments.of("x * task 01", new Task(0, "task 01", true, false)),
                Arguments.of("+ *    foo   fo  ", new Task(0, "   foo   fo  ", false, false))
        );
    }
}
