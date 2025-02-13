package reservas.cine;

public class Sala {
	private String nombre;
	private int numAsientos;
	private boolean[] asientos;

	public Sala(String nombre, int numAsientos) {
		this.nombre = nombre;
		this.numAsientos = numAsientos;
		this.asientos = new boolean[numAsientos];
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public boolean[] getAsientos() {
		return asientos;
	}

	public void setAsientos(boolean[] asientos) {
		this.asientos = asientos;
	}

	public boolean reservarAsiento(int numero) {
		boolean exito = false;
		if (asientos[numero] == false) {
			asientos[numero] = true;
			exito = true;
		}
		return exito;
	}

	public boolean liberarAsiento(int numero) {
		boolean exito = false;
		if (asientos[numero] == true) {
			asientos[numero] = false;
			exito = true;
		}
		return exito;
	}

	public void mostrarAsiento() {

		for (int i = 0; i < asientos.length; i++) {
			System.out.print((asientos[i]) ? "| O " : "| L ");
			if ((i + 1) % 10 == 0) {
				System.out.println("|\n --- --- --- --- --- --- --- --- --- --- ");
			}
		}
		System.out.println("\n");
	}

	public int calcularAsientos() {
		int numero = 0;
		for (int i = 0; i < asientos.length; i++) {
			if (asientos[i] == false) {
				numero++;
			}
		}

		return numero;
	}

}
