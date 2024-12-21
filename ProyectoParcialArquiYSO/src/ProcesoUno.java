public class ProcesoUno extends Thread {
    private int contador;
    private String nombre;
    private int id;
    String tipoAlgoritmo;

    public ProcesoUno(){}

    public ProcesoUno(String nombre, int id, String tipoAlgoritmo, int contador) {
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
        // FIFO: Se ejecuta en el orden de llegada
        System.out.println("Proceso Uno (FIFO) ejecutándose...");
    }
}
