import java.util.*;

class ProcesoTres extends Thread {
    private final List<Tarea> tareas = new ArrayList<>();

    public void agregarTareas() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de tareas: ");
        int numTareas = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer

        for (int i = 0; i < numTareas; i++) {
            System.out.print("Ingrese el nombre de la tarea " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el tiempo de ejecución de la tarea " + (i + 1) + " (en segundos): ");
            int tiempoEjecucion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            Tarea tarea = new Tarea(nombre, tiempoEjecucion); // Se crea la tarea con nombre y tiempo de ejecución
            tareas.add(tarea);
        }

        // Ordenar las tareas por tiempo de ejecución (SJF)
        tareas.sort(Comparator.comparingInt(Tarea::getTiempoEjecucion));
    }

    @Override
    public void run() {
        System.out.println("\nOrden de ejecución de las tareas (SJF no apropiativo):");
        for (Tarea tarea : tareas) {
            System.out.println("Ejecutando " + tarea.getNombre() + "...");
            try {
                Thread.sleep(tarea.getTiempoEjecucion() * 1000L); // Simula la duración de la tarea en segundos
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("El hilo fue interrumpido durante la ejecución de la tarea.");
                return;
            }
            System.out.println("Tarea " + tarea.getNombre() + " completada.");
        }
    }
}


