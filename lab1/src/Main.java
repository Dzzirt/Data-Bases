import java.io.*;
import java.nio.file.Files;

/**
 * Created by nikita.kuzin on 9/26/16.
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String pathToCsv = "/Users/nikita.kuzin/Data-Bases/lab1/db.csv";
        System.out.print("Enter username: ");
        boolean hasId = false;
        try {
            String name = consoleReader.readLine();
            assert (name != null);
            BufferedReader file = new BufferedReader(new FileReader(pathToCsv));
            String line = "";
            System.out.print("Record id's: ");
            while ((line = file.readLine()) != null) {
                String[] splited = line.split(",");
                if (splited[4].equals(name)) {
                    String id = splited[0];
                    System.out.println(Long.valueOf(id));
                    hasId = true;
                }
            }
        } catch (IOException ignored) {
        }
        if (!hasId) {
            System.out.print("id's not found");
        }
    }
}
