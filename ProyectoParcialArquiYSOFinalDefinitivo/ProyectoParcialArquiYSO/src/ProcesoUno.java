import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ProcesoUno extends Thread {
    private static final Queue<Tarea> colaDeTareas = new LinkedList<>();
    private static final List<String> ordenFinalizacion = new ArrayList<>();

    public static void crearTareas(int cantidad) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre de la tarea " + (i + 1) + ": ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese la duración de la tarea " + (i + 1) + " en segundos: ");
            int duracion = sc.nextInt() * 1000; // Convertir segundos a milisegundos
            sc.nextLine(); // Limpiar el buffer
            int tiempoDeLlegada = 0; //Llegan todos al mismo tiempo
            int prioridad = 0; //No les pongo prioridad
            Tarea tarea = new Tarea(nombre, prioridad, duracion, tiempoDeLlegada);
            agregarTarea(tarea);
        }
    }

    public static void agregarTarea(Tarea tarea) {
        synchronized (colaDeTareas) {
            colaDeTareas.add(tarea);
            System.out.println("Tarea agregada a la cola: " + tarea.getNombre());
            System.out.println("Cola actual: " + obtenerNombresDeTareas());
            colaDeTareas.notify(); //Notifior al hilo que hay una nueva tarea
        }
    }

    private static String obtenerNombresDeTareas() {
        StringBuilder nombres = new StringBuilder("[");
        for (Tarea tarea : colaDeTareas) {
            nombres.append(tarea.getNombre()).append(", ");
        }
        if (nombres.length() > 1) {
            nombres.setLength(nombres.length() - 2);
        }
        nombres.append("]");
        return nombres.toString();
    }

    private void ejecutarTarea(Tarea tarea) {
        System.out.println("Ejecutando " + tarea.getNombre() + "...");
        int tiempoEjecucion = tarea.getTiempoRestante();
        try {
            Thread.sleep(tiempoEjecucion);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El hilo fue interrumpido durante la ejecución de la tarea.");
        }
        System.out.println("Tarea " + tarea.getNombre() + " completada.");
        synchronized (ordenFinalizacion) {
            ordenFinalizacion.add(tarea.getNombre());
        }
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            Tarea tarea;
            synchronized (colaDeTareas) {
                while (colaDeTareas.isEmpty()) {
                    try {
                        System.out.println("No hay más tareas en la cola. Esperando...");
                        colaDeTareas.wait();
                    } catch (InterruptedException e) {
                        System.out.println("El hilo fue interrumpido.");
                        return; //Sale del bucle si se interrumpe el proceso
                    }
                }
                tarea = colaDeTareas.poll();
                System.out.println("Tarea tomada de la cola: " + tarea.getNombre());
                System.out.println("Cola después de tomar la tarea: " + obtenerNombresDeTareas());
            }
            if (tarea != null) {
                ejecutarTarea(tarea);
            }
        }
    }



}



