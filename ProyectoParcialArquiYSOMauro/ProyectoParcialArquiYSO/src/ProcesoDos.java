import java.util.*;
import java.util.concurrent.*;

public class ProcesoDos {

    static class TareaRunnable implements Runnable {
        private Tarea tarea;
        private int quantum;
        private final List<Tarea> tareasFinalizadas;

        public TareaRunnable(Tarea tarea, int quantum, List<Tarea> tareasFinalizadas) {
            this.tarea = tarea;
            this.quantum = quantum;
            this.tareasFinalizadas = tareasFinalizadas;
        }

        @Override
        public void run() {
            while (tarea.getTiempoRestante() > 0) {
                System.out.println("Ejecutando: " + tarea.getNombre());
                int tiempoEjecucion = Math.min(quantum, tarea.getTiempoRestante());
                try {
                    Thread.sleep(tiempoEjecucion * 1000L);  // Simulación del tiempo de ejecución
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                tarea.tiempoRestante -= tiempoEjecucion;
                if (tarea.tiempoRestante > 0) {
                    System.out.println("Interrumpiendo: " + tarea.getNombre());
                } else {
                    System.out.println("Finalizó: " + tarea.getNombre());
                    synchronized (tareasFinalizadas) {
                        tareasFinalizadas.add(tarea);
                    }
                }
            }
        }
    }

    public void agregarTareas(int numTareas) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el quantum (en segundos): ");
        int quantum = scanner.nextInt();
        scanner.nextLine();  // Limpio el buffer

        List<Tarea> tareas = new ArrayList<>();
        List<Tarea> tareasFinalizadas = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < numTareas; i++) {
            System.out.print("Ingrese el nombre de la tarea " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            System.out.println(" ");
            System.out.print("Ingrese la prioridad de la tarea " + (i + 1) + ": ");
            int prioridad = scanner.nextInt();
            System.out.println(" ");
            System.out.print("Tiempo de ejecución en segundos: ");
            int tiempoEjecucion = scanner.nextInt();
            scanner.nextLine();

            Tarea tarea = new Tarea(nombre, prioridad, tiempoEjecucion); //Creo la tarea
            tareas.add(tarea); //Adhiero la tarea
        }

        ExecutorService executor = Executors.newFixedThreadPool(numTareas);

        for (Tarea tarea : tareas) {
            TareaRunnable tareaRunnable = new TareaRunnable(tarea, quantum, tareasFinalizadas);
            executor.submit(tareaRunnable);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nOrden de finalización de las tareas:");
        for (Tarea tarea : tareasFinalizadas) {
            System.out.println(tarea.getNombre());
        }
    }
}

