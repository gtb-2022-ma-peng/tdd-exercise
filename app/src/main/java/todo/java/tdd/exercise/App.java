package todo.java.tdd.exercise;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author Ma Peng
 */
public class App {

    public static void main(String[] args) {

    }

    public List<String> run() {
        try {
            return Files.readAllLines(Path.of("E:\\IdeaProjects\\GitHub\\TW-gtb\\step6\\todo-java-tdd-exercise\\.todo\\tasks"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}
