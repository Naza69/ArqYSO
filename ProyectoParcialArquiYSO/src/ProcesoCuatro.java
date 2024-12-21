public class ProcesoCuatro extends Thread {
    private int contador;
    private String nombre;
    private int id;
    String tipoAlgoritmo;

    public ProcesoCuatro(){}

    public ProcesoCuatro(String nombre, int id, String tipoAlgoritmo, int contador) {
        this.nombre = nombre;
        this.id = id;
        this.tipoAlgoritmo = tipoAlgoritmo;
        this.contador = contador;
        setPriority(Thread.MIN_PRIORITY);
    }

    public String getNombre() {
        return nombre;
    }

    public int getContador() {
        return contador;
    }

    public String getTipoAlgoritmo() {
        return tipoAlgoritmo;
    }

    @Override
    public void run() {
        System.out.println("Proceso Cuatro (Baja Prioridad) ejecutándose...");
    }

}
