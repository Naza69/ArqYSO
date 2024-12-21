//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("Seleccione un proceso para asignar un valor:");
            System.out.println("1. Proceso Uno (FIFO)");
            System.out.println("2. Proceso Dos (Round Robin)");
            System.out.println("3. Proceso Tres (Alta Prioridad)");
            System.out.println("4. Proceso Cuatro (Baja Prioridad)");
            System.out.println("5. Proceso Cinco (Multilevel Queue)");
            System.out.println("6. Salir");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ProcesoUno procesoUno = new ProcesoUno();
                    procesoUno.start();
                    break;
                case 2:
                    ProcesoDos procesoDos = new ProcesoDos();
                    procesoDos.start();
                    break;
                case 3:
                    ProcesoTres procesoTres = new ProcesoTres();
                    procesoTres.start();
                    break;
                case 4:
                    ProcesoCuatro procesoCuatro = new ProcesoCuatro();
                    procesoCuatro.start();
                    break;
                case 5:
                    ProcesoCinco procesoCinco = new ProcesoCinco();
                    procesoCinco.start();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
            }
        }

        scanner.close();
    }
}
