public class Tarea {
    private String nombre;
    private int prioridad;
    int tiempoRestante;
    private int tiempoDeLlegada;
    private int tiempoEjecucion;

    // Constructor para tareas con nombre, prioridad, tiempo de ejecución y tiempo de llegada
    // Constructor para tareas con nombre, prioridad, tiempo de ejecución y tiempo de llegada
    // Constructor para tareas con nombre, prioridad, tiempo de ejecución y tiempo de llegada
    public Tarea(String nombre, int prioridad, int tiempoEjecucion, int tiempoDeLlegada) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoRestante = tiempoEjecucion; // Inicialmente tiempo restante es igual al tiempo de ejecución
        this.tiempoDeLlegada = tiempoDeLlegada;
    }


    public Tarea(String nombre, int tiempoEjecucion) {
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public Tarea(String nombre, int prioridad, int tiempoEjecucion) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    // Constructor para tareas con nombre, prioridad y tiempo de ejecución (sin tiempo de llegada)

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public int getTiempoDeLlegada() {
        return tiempoDeLlegada;
    }

    public void setTiempoDeLlegada(int tiempoDeLlegada) {
        this.tiempoDeLlegada = tiempoDeLlegada;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "nombre='" + nombre + '\'' +
                ", prioridad=" + prioridad +
                ", tiempoRestante=" + tiempoRestante +
                ", tiempoDeLlegada=" + tiempoDeLlegada +
                ", tiempoEjecucion=" + tiempoEjecucion +
                '}';
    }
}
