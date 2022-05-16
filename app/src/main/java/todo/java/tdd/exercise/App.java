package todo.java.tdd.exercise;

import java.util.List;

/**
 * @author Ma Peng
 */
public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run() {
        return listCommand.run();
    }

}
