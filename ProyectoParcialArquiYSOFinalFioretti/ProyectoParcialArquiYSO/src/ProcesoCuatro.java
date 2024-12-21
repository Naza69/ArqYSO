import java.util.*;

class ProcesoCuatro extends Thread {
    private final List<Tarea> tareas = new ArrayList<>();

    public void agregarTareas() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de tareas: ");
        int numTareas = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer

        for (int i = 0; i < numTareas; i++) {
            System.out.print("Ingrese el nombre de la tarea " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la prioridad de la tarea " + (i + 1) + " (número menor = mayor prioridad): ");
            int prioridad = scanner.nextInt();
            System.out.print("Ingrese el tiempo de ejecución de la tarea " + (i + 1) + " (en segundos): ");
            int tiempoEjecucion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            Tarea tarea = new Tarea(nombre, prioridad, tiempoEjecucion);
            tareas.add(tarea);
        }
    }

    @Override
    public void run() {
        // Ordenar las tareas por prioridad (menor número = mayor prioridad)
        tareas.sort(Comparator.comparingInt(t -> t.getPrioridad()));

        System.out.println("\nOrden de ejecución de las tareas (Con prioridad):");
        for (Tarea tarea : tareas) {
            System.out.println("Ejecutando " + tarea.getNombre() + " con prioridad " + tarea.getPrioridad() + "...");
            try {
                Thread.sleep(tarea.getTiempoRestante() * 1000L); // Simula la duración de la tarea
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("El hilo fue interrumpido durante la ejecución de la tarea.");
                return;
            }
            System.out.println("Tarea " + tarea.getNombre() + " completada.");
        }
    }
}
