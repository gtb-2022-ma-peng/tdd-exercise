package todo.java.tdd.exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class TestUtil {
    static void writeDataFile(List<String> lines) {
        try (BufferedWriter bw = Files.newBufferedWriter(Constants.TASK_FILE_PATH)) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
