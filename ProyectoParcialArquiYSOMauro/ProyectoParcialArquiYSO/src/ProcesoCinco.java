import java.util.*;

class ProcesoCinco extends Thread {
    private final Queue<Tarea> tareas = new PriorityQueue<>(new Comparator<Tarea>() {
        @Override
        public int compare(Tarea tarea1, Tarea tarea2) {
            // Comparar primero por tiempo de llegada, si son iguales, por tiempo de ejecución
            if (tarea1.getTiempoDeLlegada() != tarea2.getTiempoDeLlegada()) {
                return Integer.compare(tarea1.getTiempoDeLlegada(), tarea2.getTiempoDeLlegada());
            } else {
                return Integer.compare(tarea1.getTiempoEjecucion(), tarea2.getTiempoEjecucion());
            }
        }
    });

    public void agregarTareas() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de tareas: ");
        int numTareas = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer

        for (int i = 0; i < numTareas; i++) {
            System.out.print("Ingrese el nombre de la tarea " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el tiempo de llegada de la tarea " + (i + 1) + " (en segundos desde inicio): ");
            int tiempoDeLlegada = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer
            System.out.print("Ingrese el tiempo de ejecución de la tarea " + (i + 1) + " (en segundos): ");
            int tiempoEjecucion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            Tarea tarea = new Tarea(nombre, 0, tiempoEjecucion, tiempoDeLlegada);
            tareas.add(tarea);
        }
    }

    @Override
    public void run() {
        System.out.println("\nOrden de ejecución de las tareas (SJF apropiativo):");

        // Simular la llegada de las tareas
        while (!tareas.isEmpty()) {
            Tarea tarea = tareas.poll();
            if (tarea != null) {
                int tiempoDeEspera = tarea.getTiempoDeLlegada();
                System.out.println("Esperando " + tiempoDeEspera + " segundos para ejecutar " + tarea.getNombre() + "...");
                try {
                    Thread.sleep(tiempoDeEspera * 1000L); // Espera según el tiempo de llegada
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("El hilo fue interrumpido durante la espera.");
                    return;
                }
                System.out.println("Ejecutando " + tarea.getNombre() + "...");
                try {
                    Thread.sleep(tarea.getTiempoEjecucion() * 1000L); // Simula la duración de la tarea
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("El hilo fue interrumpido durante la ejecución de la tarea.");
                    return;
                }
                System.out.println("Tarea " + tarea.getNombre() + " completada.");
            }
        }
    }
}