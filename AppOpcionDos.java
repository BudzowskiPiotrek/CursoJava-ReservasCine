package reservas.cine;

import java.util.Scanner;

public class AppOpcionDos {
	public static Sala[] salas = new Sala[20];
	public static Scanner sn = new Scanner(System.in);
	public static Scanner st = new Scanner(System.in);

	public static void main(String[] args) {

		menu();
	}

	private static void menuOpciones(int flag) {
		switch (flag) {
		case 1:
			crearSala();
			break;
		case 2:
			reservarAsiento();
			break;
		case 3:
			liberarAsiento();
			break;
		case 4:
			mostrar();
			break;
		case 5:
			mostrarAsientosTotales();
			break;
		case 6:
			mostrarAsientosLibres();
			break;
		}
	}

	private static void menu() {
		int flag = 0;
		do {
			System.out.println("Pulsa 1 Crear una nueva sala");
			System.out.println("Pulsa 2 Reservar un asiento");
			System.out.println("Pulsa 3 Liberar un asiento");
			System.out.println("Pulsa 4 Mostrar el mapa de asiento de cada sala");
			System.out.println("Pulsa 5 Mostrar el mapa de asientos del total");
			System.out.println("Pulsa 6 Mostrar asientos libres");
			System.out.println("Pulsa 7 Para Salir");
			flag = st.nextInt();
			menuOpciones(flag);
		} while (flag != 7);
	}

	private static void crearSala() {
		int posicion = buscarPrimeraPosicionLibre();
		if (posicion != -1) {
			System.out.println("¿Dime el nombre de la sala?");
			String nombre = st.next();
			System.out.println("¿Qué número de asientos tiene?");
			int numero = sn.nextInt();
			salas[posicion] = new Sala(nombre, numero);
			System.out.println("La sala fue agregada con éxito\n");
		} else {
			System.out.println("No hay espacio libre para agregar más salas.\n");
		}
	}

	private static void reservarAsiento() {
		System.out.println("Escribe el numero de la sala y el numero del asiento");
		int numeroSala = sn.nextInt();
		int numeroAsiento = sn.nextInt();
		if (numeroSalaValido(numeroSala)) {
			salas[numeroSala].reservarAsiento(numeroAsiento);
			System.out.println((salas[numeroSala].reservarAsiento(numeroAsiento)) ? "Lo siento esta ya ocupado"
					: "Exito reservaste el asiento");
		} else {
			System.out.println("Esta sala no existe.");
		}
	}

	private static void liberarAsiento() {
		System.out.println("Escribe el número de la sala y el número del asiento");
		int numeroSala = sn.nextInt();
		int numeroAsiento = sn.nextInt();
		if (numeroSalaValido(numeroSala)) {
			salas[numeroSala].liberarAsiento(numeroAsiento);
			System.out.println((salas[numeroSala].liberarAsiento(numeroAsiento)) ? "Asiento liberado con éxito."
					: "Este asiento no estaba reservado.");
		} else {
			System.out.println("Esta sala no existe.");
		}
	}

	private static void mostrar() {
		System.out.println("¿De qué sala?");
		int numeroSala = sn.nextInt();
		if (numeroSalaValido(numeroSala)) {
			salas[numeroSala].mostrarAsiento();
		} else {
			System.out.println("Esta sala no existe.");
		}
	}

	private static void mostrarAsientosTotales() {
		System.out.println("Mapa de asientos de todas las salas:");
		for (int i = 0; i < salas.length; i++) {
			if (salas[i] != null) {
				System.out.println("Sala " + i + ":");
				salas[i].mostrarAsiento();
			}
		}
	}

	private static void mostrarAsientosLibres() {
		for (int i = 0; i < salas.length; i++) {
			if (salas[i] != null) {
				int asientosLibres = salas[i].calcularAsientos();
				System.out.println("Sala " + i + ": " + asientosLibres + " asientos libres.");
			}
		}
	}

	private static int buscarPrimeraPosicionLibre() {
		for (int i = 0; i < salas.length; i++) {
			if (salas[i] == null) {
				return i;
			}
		}
		return -1;
	}

	private static boolean numeroSalaValido(int numeroSala) {
		return numeroSala >= 0 && numeroSala < salas.length && salas[numeroSala] != null;
	}
}
