
public class Hilo extends Thread {
	int[] v;
	int ini, fin;
	int may;

	void fijarRango(int i, int f, int[] v) {
		this.ini = i;
		this.fin = f;
		this.v = v;
	}
	@Override
	public void run() {
		may = v[ini];
		for (int f = ini + 1; f < fin; f++) {
			if (v[f] > may) {
				may = v[f];
			}
		}
	}

}
