public class Philosopher extends Thread {
  private Desk desk;
  private int idPhilosopher;
  private int indexPhilosopher;

  public Philosopher(Desk m, int idPhilosopher) {
    this.desk = m;
    this.idPhilosopher = idPhilosopher;
    this.indexPhilosopher = idPhilosopher - 1;
  }

  @Override
  public void run() {
    while (true) {
      this.think();
      this.desk.takeSilverware(this.indexPhilosopher);
      this.eat();
      this.desk.leaveSilverware(this.indexPhilosopher);
    }
  }

  public void think() {
    System.out.println("Filosofo " + this.idPhilosopher + " esta pensando");
    try {
      sleep((long) (Math.random() * 5000) + 1000);
    } catch (InterruptedException e) {
      System.out.println("Error en piensa " + e);
    }
  }

  public void eat() {
    System.out.println("Filosofo " + this.idPhilosopher + " comiendo");
    try {
      sleep((long) (Math.random() * 5000) + 1000);
    } catch (InterruptedException e) {
      System.out.println("Error en piensa " + e);
    }
  }
}