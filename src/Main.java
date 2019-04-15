import java.util.Scanner;

/**
 * A szkeletonhoz tartozo Main osztaly, mely tartalmazza a main() fuggvenyt.
 */
public class Main {
    public static void main(String[] args) {

        Menu mainMenu = new Menu();
        Scanner scanner = new Scanner(System.in);
        int chosenUseCase = 0;

        System.out.println("Udv1 a tesztprogramunkban! Kilepes '0'-val\n");
        do {
            mainMenu.show();
            chosenUseCase = Integer.parseInt(scanner.nextLine());
            mainMenu.manageUseCase(chosenUseCase);
        } while (chosenUseCase != 0);
        scanner.close();
        System.out.println("Viszlat!!");
    }
}