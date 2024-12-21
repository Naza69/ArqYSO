import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione un proceso para asignar un valor:");
            System.out.println("1. Proceso Uno (FIFO)");
            System.out.println("2. Proceso Dos (Round Robin)");
            System.out.println("3. Proceso Tres (Alta Prioridad)");
            System.out.println("4. Proceso Cuatro (Baja Prioridad)");
            System.out.println("5. Proceso Cinco (Multilevel Queue)");
            System.out.println("6. Salir");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre de la tarea: ");
                    sc.nextLine();
                    String tarea = sc.nextLine();
                    ProcesoUno.agregarTarea(tarea);
                    break;
                case 2:
                    ProcesoDos procesoDos = new ProcesoDos();
                    System.out.print("Ingrese la cantidad de tareas que tendra el algoritmo: ");
                    int cantidadTareas = sc.nextInt();
                    sc.nextLine();
                    procesoDos.agregarTareas(cantidadTareas, sc);
                    break;
                case 3:
                    ProcesoTres procesoTres = new ProcesoTres();
                    procesoTres.agregarTarea(sc);
                    procesoTres.ejecutarTareas();
                    break;
                case 4:
                    ProcesoCuatro procesoCuatro = new ProcesoCuatro();
                    procesoCuatro.agregarTarea(sc);
                    procesoCuatro.ejecutarTareas();
                    break;
                case 5:
                    ProcesoCinco procesoCinco = new ProcesoCinco();
                    procesoCinco.agregarTarea(sc);
                    procesoCinco.ejecutarTareas();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
            }
        }

        sc.close();
    }
}

class ProcesoUno {
    private static ArrayList<String> tareas = new ArrayList<>();

    public static void agregarTarea(String tarea) {
        tareas.add(tarea);
        System.out.println("Tarea agregada al Proceso Uno: " + tarea);
    }
}

class ProcesoDos {
    public void agregarTareas(int cantidad, Scanner sc) {
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese la tarea " + (i + 1) + ": ");
            String tarea = sc.nextLine();
            System.out.println("Tarea agregada al Proceso Dos: " + tarea);
        }
    }
}

class ProcesoTres {
    private ArrayList<String> tareas = new ArrayList<>();

    public void agregarTarea(Scanner sc) {
        System.out.print("Ingrese la tarea para alta prioridad: ");
        sc.nextLine();
        String tarea = sc.nextLine();
        tareas.add(tarea);
        System.out.println("Tarea agregada al Proceso Tres (Alta Prioridad): " + tarea);
    }

    public void ejecutarTareas() {
        System.out.println("Ejecutando tareas de alta prioridad...");
        for (String tarea : tareas) {
            System.out.println("Ejecutando tarea: " + tarea);
        }
        tareas.clear();
    }
}

class ProcesoCuatro {
    private ArrayList<String> tareas = new ArrayList<>();

    public void agregarTarea(Scanner sc) {
        System.out.print("Ingrese la tarea para baja prioridad: ");
        sc.nextLine();
        String tarea = sc.nextLine();
        tareas.add(tarea);
        System.out.println("Tarea agregada al Proceso Cuatro (Baja Prioridad): " + tarea);
    }

    public void ejecutarTareas() {
        System.out.println("Ejecutando tareas de baja prioridad...");
        for (String tarea : tareas) {
            System.out.println("Ejecutando tarea: " + tarea);
        }
        tareas.clear();
    }
}

class ProcesoCinco {
    private ArrayList<String> tareas = new ArrayList<>();

    public void agregarTarea(Scanner sc) {
        System.out.print("Ingrese la tarea para multilevel queue: ");
        sc.nextLine();
        String tarea = sc.nextLine();
        tareas.add(tarea);
        System.out.println("Tarea agregada al Proceso Cinco (Multilevel Queue): " + tarea);
    }

    public void ejecutarTareas() {
        System.out.println("Ejecutando tareas de multilevel queue...");
        for (String tarea : tareas) {
            System.out.println("Ejecutando tarea: " + tarea);
        }
        tareas.clear();
    }
}
