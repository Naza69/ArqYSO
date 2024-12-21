public class Desk {
  private boolean[] silverware;

  public Desk(int numSilverware) {
    this.silverware = new boolean[numSilverware];
  }

  public int leftSilverware(int i) {
    return i;
  }

  public int rightSilverware(int i) {
    if (i == 0) {
      return this.silverware.length - 1;
    } else {
      return i - 1;
    }
  }

  public synchronized void takeSilverware(int Philosopher) {
    while (silverware[leftSilverware(Philosopher)] || silverware[rightSilverware(Philosopher)]) {
      try {
        wait();
      } catch (InterruptedException e) {
        System.out.println("Error en el wait de agarrar tenedores" + e);
      }
    }

    silverware[leftSilverware(Philosopher)] = true;
    silverware[rightSilverware(Philosopher)] = true;

  }

  public synchronized void leaveSilverware(int Philosopher) {
    silverware[leftSilverware(Philosopher)] = false;
    silverware[rightSilverware(Philosopher)] = false;

    notifyAll();
  }

}