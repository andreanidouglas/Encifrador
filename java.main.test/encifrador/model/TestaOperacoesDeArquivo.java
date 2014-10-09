package encifrador.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class TestaOperacoesDeArquivo {

	public static Arquivo arquivo;

	@Test
	public void verificaSeConsegueAbrirUmArquivoExistente() {
		try {
			arquivo = Arquivo.AbrirArquivo("arquivo",
					"C:\\Users\\DOUGLAS\\Dropbox\\hello.exe");
			// imprime algumas informacoes sobre o arquivo
			System.out.println(arquivo.toString());
			assertEquals(true, true);
		} catch (Exception e) {
			assertEquals(true, false);
		}
	}

	@Test(expected = FileNotFoundException.class)
	public void verificaSeRetornaExcecaoCasoOArquivoNaoExista()
			throws FileNotFoundException, IOException {
		arquivo = Arquivo.AbrirArquivo("arquivo", "c:\teste.txt");
	}
	
	@Test
	public void testaSeConsegueCopiarOArquivo() throws FileNotFoundException, IOException
	{
		arquivo = Arquivo.AbrirArquivo("arquivo", "C:\\Users\\DOUGLAS\\Dropbox\\hello.exe");
		arquivo.SalvarComo("c:\\temp\\teste.exe");
		
		Arquivo arquivoB = Arquivo.AbrirArquivo("arquivo2", "c:\\temp\\teste.exe");
		
		assertTrue(arquivoB.equals(arquivo));
	}

}
