public class ProcesoCinco extends Thread {
    private int contador;
    private String nombre;
    private int id;
    String tipoAlgoritmo;

    public ProcesoCinco(){}

    public ProcesoCinco(String nombre, int id, String tipoAlgoritmo, int contador) {
        this.nombre = nombre;
        this.id = id;
        this.tipoAlgoritmo = tipoAlgoritmo;
        this.contador = contador;
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
        // Simulando Multilevel Queue con prioridad media
        System.out.println("Proceso Cinco (Multilevel Queue) ejecutándose...");
    }

}
