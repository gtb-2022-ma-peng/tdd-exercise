package todo.java.tdd.exercise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * @author Ma Peng
 */
public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String...args) {
        if (args.length > 0 && args[0].equals("add")) {
            try (BufferedWriter bw = Files.newBufferedWriter(Constants.TASK_FILE_PATH, StandardOpenOption.APPEND)) {
                String taskName = args[1];
                bw.write("+ " + taskName);
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException();
            }
            return List.of();
        }
        return listCommand.run();
    }

}
