import java.util.HashMap;
import java.util.Scanner;

/**
 * A szkeletonhoz tartozo Main osztaly, mely tartalmazza a main() fuggvenyt.
 */
public class Main {
    public static void main(String[] args) {

        Menu mainMenu = new Menu();
        Scanner scanner = new Scanner(System.in);
        int chosenUseCase = 1; //GoMBI  tesztel
        InputLanguage inlang=new InputLanguage();
        System.out.println("Udv1 a tesztprogramunkban! Kilepes '0'-val\n");

        String input=scanner.nextLine();

        //Object ret=null;
        while (!input.equals("exit")){

            //ret=inlang.compile(input.split(" "));
            inlang.compile(input.split(" "));
            input=scanner.nextLine();
            //System.out.println(inlang.variables.get("p"));

        }

        /*do {
            mainMenu.show();
            input=scanner.nextLine();
            chosenUseCase = Integer.parseInt(input);
            mainMenu.manageUseCase(chosenUseCase);
            inlang.compile(input.split(" "));
        } while (chosenUseCase != 0);*/

        scanner.close();
        System.out.println("Viszlat!!");
    }
}