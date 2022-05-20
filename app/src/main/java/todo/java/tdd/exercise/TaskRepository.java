package todo.java.tdd.exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    List<Task> loadTasks() {
        List<String> lines = readTaskLines();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(TaskFactory.createTask(i + 1, lines.get(i)));
        }
        return tasks;
    }

    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASK_FILE_PATH, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    List<String> create(Task task) {
        writeTask(task);
        return List.of();
    }

    private void writeTask(Task task) {
        String name = task.getName();
        try (BufferedWriter bw = Files.newBufferedWriter(Constants.TASK_FILE_PATH, StandardOpenOption.APPEND)) {
            bw.write("+ " + name);
            bw.newLine();
        } catch (IOException e) {
            throw new TodoException();
        }
    }
}
