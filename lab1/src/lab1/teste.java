package lab1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class teste {

	NumeroPorExtenso numeroExtenso;
	
	@Before
	public void iniciaObjeto() {
		numeroExtenso = new NumeroPorExtenso();
	}
	
	@Test
	public void testEscreverNumeroPorExtenso() {
		assertEquals("onze", numeroExtenso.escreverNumeroPorExtenso(11));
		assertEquals("sete", numeroExtenso.escreverNumeroPorExtenso(7));
		assertEquals("cinquenta e cinco", numeroExtenso.escreverNumeroPorExtenso(55));
		assertEquals("duzentos e cinquenta e três", numeroExtenso.escreverNumeroPorExtenso(253));
		assertEquals("setecentos e setenta e sete", numeroExtenso.escreverNumeroPorExtenso(777));
		assertEquals("onze mil cento e onze", numeroExtenso.escreverNumeroPorExtenso(11111));
		assertEquals("novecentos e noventa e nove mil novecentos e noventa e nove", numeroExtenso.escreverNumeroPorExtenso(999999));
		assertEquals("um bilhão", numeroExtenso.escreverMilhoesPorExtenso(1000000000));
	}
	
	@Test
	public void testNumerosComUmaPalavraPorExtenso() {
		assertEquals("dez", numeroExtenso.escreverNumerosAte19PorExtenso(10));
		assertEquals("zero", numeroExtenso.escreverNumerosAte19PorExtenso(0));
		assertEquals("cinco", numeroExtenso.escreverNumerosAte19PorExtenso(5));
	}

	@Test
	public void testDezenas() {
		assertEquals("vinte e um", numeroExtenso.escreverDezenasPorExtenso(21));
		assertEquals("noventa e nove", numeroExtenso.escreverDezenasPorExtenso(99));
		assertEquals("cinquenta", numeroExtenso.escreverDezenasPorExtenso(50));
	}
	
	@Test
	public void testCentenas() {
		assertEquals("cento e um", numeroExtenso.escreverCentenasPorExtenso(101));
		assertEquals("novecentos e noventa e nove", numeroExtenso.escreverCentenasPorExtenso(999));
		assertEquals("cem", numeroExtenso.escreverCentenasPorExtenso(100));
		assertEquals("quinhentos", numeroExtenso.escreverCentenasPorExtenso(500));
	}
	
	@Test
	public void testMilhares() {
		assertEquals("mil e um", numeroExtenso.escreverMilharesPorExtenso(1001));
		assertEquals("mil e onze", numeroExtenso.escreverMilharesPorExtenso(1011));
		assertEquals("mil cento e onze", numeroExtenso.escreverMilharesPorExtenso(1111));
		assertEquals("nove mil novecentos e noventa e nove", numeroExtenso.escreverMilharesPorExtenso(9999));
		assertEquals("mil", numeroExtenso.escreverMilharesPorExtenso(1000));
		assertEquals("cinco mil", numeroExtenso.escreverMilharesPorExtenso(5000));
		assertEquals("onze mil cento e onze", numeroExtenso.escreverNumeroPorExtenso(11111));
		assertEquals("doze mil", numeroExtenso.escreverMilharesPorExtenso(12000));
		assertEquals("trinta e cinco mil", numeroExtenso.escreverMilharesPorExtenso(35000));
		assertEquals("cem mil", numeroExtenso.escreverMilharesPorExtenso(100000));
		assertEquals("trezentos e trinta e três mil trezentos e trinta e três", numeroExtenso.escreverMilharesPorExtenso(333333));
	}
	
	@Test
	public void testMilhoes() {
		assertEquals("um milhão", numeroExtenso.escreverMilhoesPorExtenso(1000000));
		assertEquals("cinquenta e cinco milhões", numeroExtenso.escreverMilhoesPorExtenso(55000000));
		assertEquals("um milhão cento e onze mil cento e onze", numeroExtenso.escreverMilhoesPorExtenso(1111111));
		assertEquals("noventa milhões novecentos mil", numeroExtenso.escreverMilhoesPorExtenso(90900000));
	}
}
