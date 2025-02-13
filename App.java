package reservas.cine;

import java.util.Scanner;

public class App {
	public static Sala[] salas = new Sala[20];
	public static Scanner sn = new Scanner(System.in);
	public static Scanner st = new Scanner(System.in);
	public static int contador;

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
			libelarAsiento();
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

	private static void mostrarAsientosLibres() {
		for (int i = 0; i < salas.length; i++) {
			if (salas[i] != null) {
				int asientosLibres = salas[i].calcularAsientos();
				System.out.println("Sala " + i + ": " + asientosLibres + " asientos libres.");
			}
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

	private static void menu() {
		int flag = 0;

		do {
			System.out.println("\nPulsa 1 Crear una nueva sala");
			System.out.println("Pulsa 2 Reservar un asiento");
			System.out.println("Pulsa 3 Liberar un asiento");
			System.out.println("Pulsa 4 Mostrar el mapa de asiento de cada salas");
			System.out.println("Pulsa 5 Mostrar el mapa de asientos del tota");
			System.out.println("Pulsa 6 Mostrar asientos libres");
			System.out.println("Pulsa 7 Para Salir");
			System.out.println(contador);
			flag = st.nextInt();
			menuOpciones(flag);
		} while (flag != 7);
	}

	private static void mostrar() {
		System.out.println("De que sala?");
		int numeroSala = sn.nextInt();
		if (numeroSala < contador) {
			salas[numeroSala].mostrarAsiento();
		} else {
			System.out.println("Esta sala no existe");
		}

	}

	private static void libelarAsiento() {
		System.out.println("escribe numero de la sala (pulsa enter), y escribe numero de asiento");
		int numeroSala = sn.nextInt();
		int numeroAsiento = sn.nextInt();
		if (numeroSala < contador) {
			salas[numeroSala].liberarAsiento(numeroAsiento);
			System.out.println((salas[numeroSala].reservarAsiento(numeroAsiento)) ? "Lo siento no existe esta reserva"
					: "Acabas de liberar Asiento");

		} else {
			System.out.println("Esta sala no existe");
		}

	}

	private static void reservarAsiento() {
		System.out.println("escribe numero de la sala (pulsa enter), y escribe numero de asiento");
		int numeroSala = sn.nextInt();
		int numeroAsiento = sn.nextInt();
		if (numeroSala < contador) {
			salas[numeroSala].reservarAsiento(numeroAsiento);
			System.out.println((salas[numeroSala].reservarAsiento(numeroAsiento)) ? "Lo siento esta ya ocupado"
					: "Exito reservaste el asiento");

		} else {
			System.out.println("Esta sala no existe");
		}

	}

	private static void crearSala() {
		if (contador < salas.length) {
			System.out.println("¿Dime nombre de la sala?");
			String nombre = st.next();
			System.out.println("¿Que numero de asientos tiene?");
			int numero = sn.nextInt();
			salas[contador] = new Sala(nombre, numero);
			System.out.println("La sala fue agregada con exito\n");
			contador++;
		} else {
			System.out.println("No hay espacio libre!\n");
		}

	}

}
