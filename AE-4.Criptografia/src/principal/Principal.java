package principal;

import java.util.Scanner;

import controlador.Asimetrica;
import controlador.Simetrica;

public class Principal {
	public static boolean salir = false;
	public static int opcion; // Guardaremos la opcion del usuario
	static Scanner sn = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);
	static String datos;
	static String matricula;
	static String marca;
	static String modelo;
	static String precio;
	static int nota;
	static String mensajeCifrado;

	public static void main(String[] args) throws Exception {
		/*
		 * String casa;
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * casa=sc.nextLine();
		 * 
		 * System.out.println(casa);
		 */

		while (!salir) {
			System.err.println("      POR FAVOR SELECCIONA UN METODO DE CIFRADO    ");
			System.out.println();
			System.out.println("******** INTRODUCE 1 PARA CIFRADO ASIMETRICO ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 2 PARA CIFRADO SIMETRICO ***************");
			System.out.println();
			System.out.println("******** INTRODUCE 6 PARA FINALIZAR EL PROGRAMA ***********");
			System.out.println();
			Scanner sc = new Scanner(System.in);

			nota = sc.nextInt();
			switch (nota) {
			case 1:
				System.out.println();
				System.err.println("Has seleccionado la opcion 1 -> CIFRADO ASIMETRICO ");
				System.out.println();
				Asimetrica.ASI();
				break;
			case 2:
				System.out.println();
				System.err.println("Has seleccionado la opcion 2 -> CIFRADO SIMETRICO ");
				System.out.println();
                Simetrica.SIME();
                break;
			case 6:
				System.out.println();
				System.err.println("Has seleccionado la opcion 6 -> FINALIZAR PROGRAMA ");
				System.out.println("");
				System.out.println(" PROGRAMA FINALIZADO  ");
				salir = true;
				sc.close();   // cerramos scanner
				
				break;

			default:
				System.out.println();
				System.err.println("Solo números entre 1 y 6");
                System.out.println();
			}

		}
	}
}
