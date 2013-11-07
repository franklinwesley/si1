package lab1;

public class NumeroPorExtenso {

	private final int DEZENA = 10;
	private final int CENTENA = 100;
	private final int MILHAR = 1000;
	private final int MILHOES = 1000000;
	private final int BILHAO = 1000000000;
	private String[] numerosComUmaPalavra = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "quartoze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
	private String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta", "sesenta", "setenta", "oitenta", "noventa"};
	private String[] centenas = {"cem", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};
	public String[] milharesMilhoesBilhoes = {"mil", "milhão", "milhões", "bilhão"};
	
	public String escreverNumeroPorExtenso (int numero) {
		if (numero >= 0 && numero < 20) {
			return escreverNumerosAte19PorExtenso(numero);
		} else if (numero >= 20 && numero < 100) {
			return escreverDezenasPorExtenso(numero);
		} else if (numero >= 100 && numero < 1000) {
			return escreverCentenasPorExtenso(numero);
		} else if (numero >= 1000 && numero < 1000000) {
			return escreverMilharesPorExtenso(numero);
		}
		return null;
	}
	
	public String escreverNumerosAte19PorExtenso(int numero) {
		return numerosComUmaPalavra[numero];		
	}
	
	public String escreverDezenasPorExtenso(int numero) {
		String[] numeros = String.valueOf(numero).split("");
		if (numero % DEZENA != 0) {
			return dezenas[Integer.parseInt(numeros[1])] + " e " + numerosComUmaPalavra[Integer.parseInt(numeros[2])];
		} else {
			return dezenas[Integer.parseInt(numeros[1])];
		}
	}
	
	public String escreverCentenasPorExtenso(int numero) {
		String[] numeros = String.valueOf(numero).split("");
		if (numero % CENTENA != 0) {
			return centenas[Integer.parseInt(numeros[1])] + " e " + escreverNumeroPorExtenso(ultimosNumeros(numeros, 2));
		} else if (numero == 100) {
			return centenas[0];
		} else {
			return centenas[Integer.parseInt(numeros[1])];
		}
	}
	
	public String escreverMilharesPorExtenso(int numero) {
		String[] numeros = String.valueOf(numero).split("");
		if (numero % MILHAR != 0) {
			if (Integer.parseInt(numeros[2]) == 0) {
				if (Integer.parseInt(numeros[1]) == 1) {
					return milharesMilhoesBilhoes[0] + " e " + escreverNumeroPorExtenso(ultimosNumeros(numeros, 3));
				} else {
					return escreverNumeroPorExtenso(primeirosNumeros(numeros, 3)) + " "+ milharesMilhoesBilhoes[0] + " e " + escreverNumeroPorExtenso(ultimosNumeros(numeros, 3));
				}
			} else {
				if (primeirosNumeros(numeros, 3) == 1) {
					return milharesMilhoesBilhoes[0] + " " + escreverNumeroPorExtenso(Integer.parseInt(numeros[2] + numeros[3] + numeros[4]));
				} else {
					return escreverNumeroPorExtenso(primeirosNumeros(numeros, 3)) + " " + milharesMilhoesBilhoes[0] + " " + escreverNumeroPorExtenso(ultimosNumeros(numeros, 3));
				}
			}
		} else if (numero == MILHAR) {
			return milharesMilhoesBilhoes[0];
		} else {
			return escreverNumeroPorExtenso(primeirosNumeros(numeros, 3)) + " " + milharesMilhoesBilhoes[0];
		}
	}
	
	private int primeirosNumeros (String[] numeros, int casasdecimais) {
		String result = "";
		for (int i = 1; i < numeros.length - casasdecimais; i++) {
			result += numeros[i];
		}
		return Integer.parseInt(result);
	}
	
	private int ultimosNumeros (String[] numeros, int casasdecimais) {
		String result = "";
		for (int i = numeros.length - casasdecimais; i < numeros.length; i++) {
			result += numeros[i];
		}
		return Integer.parseInt(result);
	}

	public String escreverMilhoesPorExtenso(int numero) {
		String[] numeros = String.valueOf(numero).split("");
		if (numero % MILHOES != 0) {
			if (primeirosNumeros(numeros, 6) == 1) {
				return escreverNumeroPorExtenso(primeirosNumeros(numeros, 6)) + " " + milharesMilhoesBilhoes[1] + " " + escreverNumeroPorExtenso(ultimosNumeros(numeros, 6));
			} else {
				return escreverNumeroPorExtenso(primeirosNumeros(numeros, 6)) + " " + milharesMilhoesBilhoes[2] + " " + escreverNumeroPorExtenso(ultimosNumeros(numeros, 6));
			}
		} else if (numero == MILHOES) {
			return escreverNumeroPorExtenso(Integer.parseInt(numeros[1])) + " " + milharesMilhoesBilhoes[1];
		} else if (numero == BILHAO) {
			return escreverNumeroPorExtenso(Integer.parseInt(numeros[1])) + " " + milharesMilhoesBilhoes[3];
		} else {
			return escreverNumeroPorExtenso(primeirosNumeros(numeros, 6)) + " " + milharesMilhoesBilhoes[2];
		} 
	}
}