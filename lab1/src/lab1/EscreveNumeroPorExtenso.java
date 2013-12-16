package lab1;

import java.util.Scanner;

public class EscreveNumeroPorExtenso {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String entrada = "";
		do {
			entrada = entrada(scanner);
		} while (entrada.equals(""));
		while (!isInt(entrada)) {
			System.out.println("Você deve informar um número.");
			entrada = entrada(scanner);
		}
		NumeroPorExtenso num = new NumeroPorExtenso();
		System.out.println(num.escreverNumeroPorExtenso(Integer.parseInt(entrada)));
	}
	
	public static void entradaErrada (Scanner entrada, String mensagem) {
		System.out.println(mensagem);
		while (!entrada.hasNextInt()) {
			System.out.println(mensagem);
		}
	}
	
	public static String entrada (Scanner sc) {
		System.out.print("Informe um n�mero: ");
		String entrada = sc.nextLine();
		return entrada;
	}
	
	@SuppressWarnings("unused")
	public static boolean isInt (String entrada) {
		boolean result = true;
		try {
			int i = Integer.parseInt(entrada);
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}
}
