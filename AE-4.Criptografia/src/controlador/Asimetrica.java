package controlador;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import coches.Coche;

public class Asimetrica {
	public static boolean salir = false;
	public static int opcion; // Guardaremos la opcion del usuario
	static Scanner sn = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);
	static String datos;
	static String matricula;
	static String marca;
	static String modelo;
	static String precio;
	int nota;
	static String mensajeCifrado;
	static String mensajeDescifrado;

	public static void ASI() throws IOException, Exception {

		while (!salir) {
			 System.out.println( );
			System.out.println("1. Opcion 1: ENCRIPTACION DE FRASE ");// SOLO SE GUARDA 1 FRASE CADA VEZ
			System.out.println("2. Opcion 2: MOSTRAR FRASE ENCRIPTADA 'NO LEGIBLE' ");
			System.out.println("3. Opcion 3: MOSTRAR FRASE DESENCRIPTADA ");
			System.out.println("4. Opcion 4: ENCRIPTAR COCHE ");
			System.out.println("6. Salir ");
			System.out.println("Escribe una de las opciones");
			opcion = sn.nextInt();
			try {
				///// PARTE DE ENCRIPTACION

				switch (opcion) {
				case 1:
					 System.out.println( );
					System.err.println("*********** ENCRIPTACION DE FRASE  ***************");
					System.out.println( );
					System.out.println("POR FAVOR INTRODUCE LA FRASE ");
					datos = sc.nextLine();
					// Obtenemos el par de claves (publica y privada)
					// Objeto que nos permitira encriptar o desencriptar a partir de una
					// clave (o palo espartano)
					KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
					KeyPair claves = generador.generateKeyPair();
					// Ahora el cifrador lo configuramos para que use la clave simetrica
					// para encriptar

					Cipher cifrador = Cipher.getInstance("RSA");
					// esto es datos por consola\\ String mensajeOriginal = "Un gran poder implica
					// una gran responsabilidad";
					// El cifrador trabaja con bytes, lo convertimos
					cifrador.init(Cipher.ENCRYPT_MODE, claves.getPublic());
					byte[] bytesMensajeOriginal = datos.getBytes();
					// ciframos el mensaje
					byte[] bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
					// El cifrador devuelve una cadena de bytes

					mensajeCifrado = new String(bytesMensajeCifrado);
					cifrador.init(Cipher.DECRYPT_MODE, claves.getPrivate());
					byte[] bytesMensajeDescifrado = cifrador.doFinal(bytesMensajeCifrado);
					mensajeDescifrado = new String(bytesMensajeDescifrado);
					 System.out.println( );
					break;
				case 2:
					 System.out.println( );
					// aqui muestro el mensaje pero esta encriptado
					
					System.err.println("*********** MOSTRAR FRASE ENCRIPTADA ***************");
					System.out.println( );
					System.out.println(" Mensaje Cifrado: " + mensajeCifrado);
					 System.out.println( );
					break;

				case 3:// aqui muestro el mensaje desencriptado
					 System.out.println( );
					
					System.err.println("*********** MOSTRAR FRASE DESENCRIPTADA ***************");
					System.out.println( );
					
					System.out.println(" Mensaje Descifrado: " + mensajeDescifrado);
					 System.out.println( );
					break;
				case 4:
					 System.out.println( );
					System.err.println("*********** ENCRIPTAR COCHE ***************");

					System.out.println("POR FAVOR INTRODUCE LA MATRICULA ");
					matricula = sc.nextLine();
					System.out.println("POR FAVOR INTRODUCE LA MARCA");
					marca = sc.nextLine();
					System.out.println("POR FAVOR INTRODUCE LA MODELO");
					modelo = sc.nextLine();
					System.out.println("POR FAVOR INTRODUCE EL PRECIO");
					precio = sc.nextLine();

					Coche coche = new Coche(matricula, marca, modelo, precio);
					// no dice nada el requerimiento 2 de visualizar los datos
					// asi que meto la visualizacion de los datos
					// AQUI CIFRO EL COCHE
					KeyGenerator generador_clave_coche = KeyGenerator.getInstance("AES");
					SecretKey paloCoche = generador_clave_coche.generateKey();
					Cipher cifrador_coche = Cipher.getInstance("AES");
					cifrador_coche.init(Cipher.ENCRYPT_MODE, paloCoche);
					SealedObject so = new SealedObject(coche, cifrador_coche);
					System.out.println( );
					System.out.println(" COCHE CIFRADO: " + so);
					System.out.println( );
					// AQUI DESCIFRO EL COCHE
					cifrador_coche.init(Cipher.DECRYPT_MODE, paloCoche);
					Coche coche_descifrado = (Coche) so.getObject(cifrador_coche);
					System.out.println( );
					System.out.println("COCHE DESCIFRADO : " + coche_descifrado);
					System.out.println();
					 
					break;

				case 6:
					 System.out.println( );
					
					System.err.println(" VOLVIENDO AL MENU PRINCIPAL  ");
					salir = true;
					
					 System.out.println( );
					break;
				default:
					System.out.println("Solo números entre 1 y 6");
				}
				// Simplificamos las excepciones capturando GeneralSecurityException
			} catch (GeneralSecurityException gse) {
				System.out.println("Algo ha fallado.." + gse.getMessage());
				System.out.println("Excepcion de tipo: " + gse.getClass().getName());
				gse.printStackTrace();
			}

		}

	}

}