public class ProcesoTres extends Thread {
    private int contador;
    private String nombre;
    private int id;
    String tipoAlgoritmo;

    public ProcesoTres(){}

    public ProcesoTres(String nombre, int id, String tipoAlgoritmo, int contador) {
        this.nombre = nombre;
        this.id = id;
        this.tipoAlgoritmo = tipoAlgoritmo;
        this.contador = contador;
        setPriority(Thread.MAX_PRIORITY);
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
        System.out.println("Proceso Tres (Alta Prioridad) ejecutándose...");
    }

}