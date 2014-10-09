package encifrador.model;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestaOAlgoritimoDeCriptografia {

	public static Encifrador en;
	public static byte[] textoASerCifradoEmBytes;
	public static final String textoASerCifrado = "DJPSOIJDAPSODIUHQASDHasd";

	@BeforeClass
	public static void InicializaEncifrador() {
		Random r = new Random();
		en = new Encifrador();
		en.inicializadorDeChave(r.nextLong());
		textoASerCifradoEmBytes = textoASerCifrado.getBytes();

	}

	@Test
	public void VerificaSeASaidaDoEncifradorEhDiferenteDaEntrada()
			throws Exception {

		assertFalse(
				"A string retornada é diferente",
				new String(en.encriptar(textoASerCifradoEmBytes,
						en.get_publicKey()), "UTF-8").equals(textoASerCifrado));

	}

	@Test
	public void VerificaSeASaidaDoDecifradorEhIgualAEntradaOriginal()
			throws Exception {

		byte[] stringCifrada = en.encriptar(textoASerCifradoEmBytes,
				en.get_publicKey());

		assertTrue("A string retornada é igual",
				new String(en.decriptar(stringCifrada, en.get_privateKey()))
						.equals(textoASerCifrado));

	}

}
