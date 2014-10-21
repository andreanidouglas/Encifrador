package encifrador.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;


public class TestaOAlgoritimoDeCriptografia {

	public static Encifrador en;
	public static Chaveiro gdc;
	public static byte[] textoASerCifradoEmBytes;
	public static final String textoASerCifrado = "DJPSOIJDAPSODIUHQASDHasd";

	@BeforeClass
	public static void InicializaEncifrador() {
		Random r = new Random();
		gdc = new Chaveiro();
		en = new Encifrador();
		gdc.inicializadorDeChaves(r.nextLong());
		textoASerCifradoEmBytes = textoASerCifrado.getBytes();

	}

	@Test
	public void VerificaSeASaidaDoEncifradorEhDiferenteDaEntrada()
			throws Exception {

		assertFalse(
				"A string retornada é diferente",
				new String(en.encriptar(textoASerCifradoEmBytes,
						gdc.getPublicKey()), "UTF-8").equals(textoASerCifrado));
	}

	@Test
	public void VerificaSeASaidaDoDecifradorEhIgualAEntradaOriginal()
			throws Exception {

		byte[] stringCifrada = en.encriptar(textoASerCifradoEmBytes,
				gdc.getPublicKey());

		assertTrue("A string retornada é igual",
				new String(en.decriptar(stringCifrada, gdc.getPrivateKey()))
						.equals(textoASerCifrado));

	}

}
