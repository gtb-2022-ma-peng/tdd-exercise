package todo.java.tdd.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        TestUtil.writeDataFile(List.of(
                "+ * task 01",
                "+ * task 02",
                "x * task 03",
                "x * task 04"));
        app = new App();
    }


    @Nested
    class TestRemove {
        @Nested
        class SingleTest {
            @Test
            void should_remove_single_task() {
                app.run("remove", "1");
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "2 task 02",
                        "# Completed",
                        "3 task 03",
                        "4 task 04"), app.run());
            }
        }
        @Nested
        class MultipleTest {
            @Test
            void should_remove_them_all() {
                app.run("remove", "1", "3");
                Assertions.assertEquals(List.of(
                        "# To be done",
                        "2 task 02",
                        "# Completed",
                        "4 task 04"), app.run());
            }
        }
    }



    @Nested
    class TestList {
        @Test
        void should_list_all_existing_tasks() {
            // Given
            // When
            app.run();
            // Then
            List<String> result = app.run();
            Assertions.assertEquals(List.of(
                    "# To be done",
                    "1 task 01",
                    "2 task 02",
                    "# Completed",
                    "3 task 03",
                    "4 task 04"), result);
        }
    }


    @Nested
    class TestAdd {
        @Test
        void should_add_task_with_single_world_as_name() {
            // Given
            // When
            app.run("add", "foobar");
            // Then
            List<String> result = app.run();
            Assertions.assertEquals(List.of(
                    "# To be done",
                    "1 task 01",
                    "2 task 02",
                    "5 foobar",
                    "# Completed",
                    "3 task 03",
                    "4 task 04"), result);
        }
        @Test
        void should_add_task_with_multiple_world_as_name() {
            // Given
            // When
            app.run("add", "foobar", "fizz");
            // Then
            List<String> result = app.run();
            Assertions.assertEquals(List.of(
                    "# To be done",
                    "1 task 01",
                    "2 task 02",
                    "5 foobar fizz",
                    "# Completed",
                    "3 task 03",
                    "4 task 04"), result);
        }
    }

}
