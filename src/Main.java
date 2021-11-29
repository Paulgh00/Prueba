import java.util.Date;

public class Main {

	public static void main(String[] args) {
		System.out.println("Cantidad de núcleos del procesador: " + Runtime.getRuntime().availableProcessors());
		int[] v = new int[44_000_000];

		System.out.println("Cargando el vector.");
		for (int i = 0; i < v.length; i++) {
			v[i] = (int) (Math.random() * 44_000_000);
			//System.out.println(v[i]);
		}
			System.out.println("Fin de la carga del vector.");
			

			Date d1 = new Date();

			Hilo hilo1 = new Hilo();
			hilo1.fijarRango(0, v.length / 2, v);
			Hilo hilo2 = new Hilo();
			hilo2.fijarRango(v.length / 2 + 1, v.length - 1, v);
			hilo1.start();
			hilo2.start();

			try {
				hilo1.join();
				hilo2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Mayor elemento del vector:");
			if (hilo1.may > hilo2.may) {
				System.out.println(hilo1.may);
			} else {
				System.out.println(hilo2.may);
			}

			Date d2 = new Date();
			long milisegundos = (d2.getTime() - d1.getTime());

			System.err.println("Milisegundos requeridos con 2 hilos: " + milisegundos + " milisegundos");
		}

}
