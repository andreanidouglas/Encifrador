package encifrador.controller;

import java.security.PublicKey;

import encifrador.model.Arquivo;
import encifrador.model.Encifrador;

public class EncriptografaArquivo {
	
	private byte[] conteudoArquivoEncriptado;
	private Arquivo arquivoEncriptado;
	private Encifrador encifrador;
	
	public void encifraArquivo(String caminho, PublicKey publicKey) {

		try {
			encifrador = new Encifrador();
			Arquivo arquivo = Arquivo.AbrirArquivo("arquivo a ser encriptado", caminho);
			conteudoArquivoEncriptado = encifrador.encriptar(arquivo.getConteudo(), publicKey);
		} catch (Exception e) {
			// TODO:Exception
		}
	}
	
	@SuppressWarnings("unused")
	private void salvarArquivoEncriptado(String nome, String caminho)
	{
		try
		{
			arquivoEncriptado = Arquivo.CriarArquivo(nome, caminho, conteudoArquivoEncriptado);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
