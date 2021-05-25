

package paquete1;


/**
 * Clase para Realizar operaciones con numeros enteros
 * @version 1.0
 *@author Martin
 *
 */

public class Enteros {

	/**
	 * Calcula el factorial de un numero recursivamente
	 * @param n numero del cual va a calcular el factorial
	 * @return devuelve su numero factorial
	 */
	public static int r_factorial(int n) {
		int resultado;

		if (n == 0) {
			resultado = 1;
		} else {
			resultado = n * r_factorial(n - 1);
		}
		return resultado;
	}
	
	/**
	 * Calcula el factorial de un numero
	 * @param n numero del cual va a calcular el factorial
	 * @return devuelve su numero factorial
	 */
	public static int factorial(int n) {
		int resultado;

		resultado = 1;
		for (int i = 2; i <= n; i++) {
			resultado = resultado * i;
		}
		return resultado;
	}
	

	/**
	 * Da la vuelta a una cadena
	 * @param cadena palabra la cual va a dar la vuelta
	 * @return devuelva la cadena ya dada la vuelta
	 */
	public static String alreves(String cadena) {
		String resultado = "";

		for (int i = cadena.length() - 1; i >= 0; i--) {
			resultado = resultado + cadena.charAt(i);
		}
		return resultado;
	}
	
	
	/**
	 * Te indica con true y false si un numero es capicuo
	 * @param n el numero el cual queremos saber si es capicuo
	 * @return devuelve true o false depende de si el numero es capicuo
	 */
	public static boolean capicua(int n) {
		boolean resultado;
		String cadena;

		cadena = Integer.toString(n);
		if (cadena.equals(alreves(cadena))) {
			resultado = true;
		} else {
			resultado = false;
		}

		return resultado;
	}

	/**
	 * Te indica con true y false sin un numero es divisible entre otro
	 * @param multiplo Es el numero que se va a dividir
	 * @param divisor Es el numero por el cual se va a dividir
	 * @return devuelve true o false segun si es divisible o no
	 */
	public static boolean divisible(int multiplo, int divisor) {
		boolean resultado;

		if (multiplo % divisor == 0) {
			resultado = true;
		} else {
			resultado = false;
		}

		return resultado;
	}
	
	
	/**
	 * Te indica con true y false sin un numero es multiplo de otro
	 * @param multiplo Es el numero que se va a dividir
	 * @param divisor Es el numero por el cual se va a dividir
	 * @return devuelve true o false segun si es divisible o no
	 */
	public static boolean multiplo(int mult, int divisor) {
		boolean resultado;

		try {
			if (mult % divisor == 0) {
				resultado = true;
			} else {
				resultado = false;
			}
		} catch (ArithmeticException e) {
			resultado = false;
		}
		return resultado;
	}
	
	/**
	 * Te indica con true y false sin el numero introducido es primo
	 * @param n numero el cual queremos comprobar si es primo
	 * @return devuelve true o false segun si es primo o no
	 */
	public static boolean esPrimo(int n) {
		boolean primo;

		if (n <= 1) {
			primo = false;
		} else {
			primo = true;
			int i = 2;
			while (primo && i <= n / 2) {
				if (divisible(n, i)) {
					primo = false;
				} else {
					i++;
				}
			}
		}
		return primo;
	}
	
	/**
	 * Calcula el numero de primos que hay desde el 2 hasta el numero introducido recursivamente
	 * @param n Es el numero primos hasta el que queremos buscar
	 * @return devuelve el numero total de numeros primos encontrados
	 */
	public static int n_primos(int n) {
		int resultado = 0;

		for (int i = 2; i <= n; i++) {
			if (esPrimo(i)) {
				resultado++;
			}
		}
		return resultado;
	}

	/**
	 * Calcula el numero de primos que hay hasta el numero introducido
	 * @param n Es el numero primos que queremos 
	 * @return devuelve todos los numeros primos encontrados en un array
	 */
	public static int[] primosHasta(int n) {
		int[] resultado;

		resultado = new int[n_primos(n)];
		int cont = 0;
		for (int i = 2; i <= n; i++) {
			if (esPrimo(i)) {
				resultado[cont] = i;
				cont++;
			}
		}

		return resultado;
	}

	/**
	 * Calcula los primeros hasta que haya espacio en el array 
	 * validando que n es un numero positivo
	 * @param n Es el numero de primos que queremos
	 * @return devuelve todos los primos encontrados en un array
	 */
	public static int[] primerosPrimos(int n) {
		int[] resultado = new int[(n < 0) ? 0 : n];

		int cont = 0;
		int i = 2;
		while (cont < n) {
			if (esPrimo(i)) {
				resultado[cont] = i;
				cont++;
			}
			i++;
		}

		return resultado;
	}
}
