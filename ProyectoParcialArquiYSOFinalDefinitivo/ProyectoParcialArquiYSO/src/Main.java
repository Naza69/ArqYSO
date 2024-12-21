//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("Seleccione un proceso para asignar un valor:");
            System.out.println("1. Proceso Uno (FIFO)");
            System.out.println("2. Proceso Dos (Round Robin)");
            System.out.println("3. Proceso Tres (SJF no apropiativo)");
            System.out.println("4. Proceso Cuatro (Con prioridad)");
            System.out.println("6. Salir");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la cantidad de tareas: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer
                    ProcesoUno.crearTareas(cantidad);;
                    break;
                case 2:
                    ProcesoDos procesoDos = new ProcesoDos();
                    System.out.print("Ingrese la cantidad de tareas que tendra el algoritmo: ");
                    int cantidadTareas = sc.nextInt();
                    sc.nextLine();
                    procesoDos.agregarTareas(cantidadTareas);
                    break;
                case 3:
                    ProcesoTres procesoTres = new ProcesoTres();
                    procesoTres.agregarTareas();
                    procesoTres.start();
                    try {
                        procesoTres.join(); // Esperar a que termine la ejecución del procesoTres
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("El hilo principal fue interrumpido.");
                    }
                    break;
                case 4:
                    ProcesoCuatro procesoCuatro = new ProcesoCuatro();
                    procesoCuatro.agregarTareas();
                    procesoCuatro.start();
                    try {
                        procesoCuatro.join(); // Esperar a que termine la ejecución del procesoCuatro
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("El hilo principal fue interrumpido.");
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
            }
        }

    }
}
