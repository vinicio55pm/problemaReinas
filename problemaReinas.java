package reinas;

import javax.swing.JOptionPane;

public class problemaReinas {

	public static void main(String[] args) {
		String[][] tablero = { { " ", " ", " ", " " }, { " ", " ", " ", " " }, { " ", " ", " ", " " },
				{ " ", " ", " ", " " } };
		
		int tamaño = 8;
		
		tablero = generarTablero(tamaño);
		ubicarReina(tablero, 0);
	}

	public static void ubicarReina(String[][] tablero, int etapa) {

		for (int i = 0; i < tablero.length; i++) {
			if (isValido(tablero, i, etapa)) {
				tablero[i][etapa] = "R";

				if (etapa < tablero.length - 1) {
					ubicarReina(tablero, etapa + 1);
				} else {
					imprimirMatriz(tablero);
					System.out.println("________________\r");
				}

				tablero[i][etapa] = " ";
			}

		}
	}

	public static boolean isValido(String[][] tablero, int i, int etapa) {

		for (int x = 0; x < etapa; x++) {
			if (tablero[i][x].equals("R")) {
				return false;
			}
		}

		for (int j = 0; j < tablero.length && (i - j) >= 0 && (etapa - j) >= 0; j++) {

			if (tablero[i - j][etapa - j].equals("R")) {
				return false;
			}

		}

		for (int j = 0; j < tablero.length && (i + j) < tablero.length && etapa - j >= 0; j++) {

			if (tablero[i + j][etapa - j].equals("R")) {
				return false;
			}
		}

		return true;

	}

	public static String[][] generarTablero(int length) {
		String[][] res = new String[length][length];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				res[i][j] = " ";
			}
		}
		return res;
	}

	public static void imprimirMatriz(String[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j] + ".");
			}
			System.out.println();
		}
	}
}
