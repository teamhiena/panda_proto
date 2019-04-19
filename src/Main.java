import java.io.IOException;
import java.util.Scanner;

/**
 * A szkeletonhoz tartozo Main osztaly, mely tartalmazza a main() fuggvenyt.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line;
            line = scanner.nextLine();

            if (line == null) break;

            runCommand(line);
        }

    }
}