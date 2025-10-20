import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		try
		{

			EncriptacionBlowfish encriptacion = new EncriptacionBlowfish();
			Scanner scanner = new Scanner(System.in);

			// Pedimos el texto encriptado por consola
			System.out.print("Ingresa el texto encriptado: ");
			String textoEncriptado = scanner.nextLine();

			// Desencriptamos y volvemos a encriptar concatenando con la fecha actual
			String textoFinalEncriptado = encriptacion.encriptarConFecha(textoEncriptado);
			System.out.println("Encriptado: " + textoFinalEncriptado);

			// Desencriptamos el texto final para mostrar el resultado
			String textoDesencriptadoFinal = encriptacion.desencriptar(textoFinalEncriptado);
			System.out.println("Texto: " + textoDesencriptadoFinal);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}

	}
}
