package todo.java.tdd.exercise;

import java.util.List;

/**
 * @author Ma Peng
 */
public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        System.out.println(Constants.USER_HOME_PATH);

    }

    public List<String> run() {
        return listCommand.run();
    }

}
