package todo.java.tdd.exercise;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 * @author Ma Peng
 */
public class App {

    public static void main(String[] args) {
        System.out.println(Constants.USER_HOME_PATH);

    }

    public List<String> run() {
        try {
            return Files.readAllLines(Constants.TASK_FILE_PATH, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}
