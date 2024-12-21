public class ProcesoDos extends Thread {
    private int contador;
    private String nombre;
    private int id;
    String tipoAlgoritmo;

    public ProcesoDos(){}

    public ProcesoDos(String nombre, int id, String tipoAlgoritmo, int contador) {
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
        // Round Robin: Simulado mediante tiempos de espera
        System.out.println("Proceso Dos (Round Robin) ejecutándose...");
        try {
            Thread.sleep(500); // Simular tiempo de trabajo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
