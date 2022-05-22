package todo.java.tdd.exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRepository {

    private final TaskMarshaller taskMarshaller = new TaskMarshaller();

    List<Task> all() {
        return loadTasks().stream().filter(task -> !task.isDeleted()).collect(Collectors.toList());
    }

    private List<Task> loadTasks() {
        List<String> lines = readTaskLines();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(taskMarshaller.unmarshal(i + 1, lines.get(i)));
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

    public void create(Task task) {
        writeTask(task);
    }

    public void delete(Integer id) {
        List<Task> tasks = loadTasks();
        tasks.stream().filter(task -> task.getId() == id).forEach(Task::deleted);

        try (BufferedWriter bw = Files.newBufferedWriter(Constants.TASK_FILE_PATH)) {
            for (Task task : tasks) {
                String completedSign = task.isCompleted() ? "x" : "+";
                String deletedSign = task.isDeleted() ? "-" : "*";
                bw.write(completedSign + " " + deletedSign + " " + task.getName());
                bw.newLine();

            }
        } catch (IOException e) {
            throw new TodoException();
        }

    }

    private void writeTask(Task task) {
        try (BufferedWriter bw = Files.newBufferedWriter(Constants.TASK_FILE_PATH, StandardOpenOption.APPEND)) {
            String stringLine = taskMarshaller.marshal(task);
            bw.write(stringLine);
            bw.newLine();
        } catch (IOException e) {
            throw new TodoException();
        }
    }

}
