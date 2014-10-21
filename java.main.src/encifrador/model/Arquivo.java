package encifrador.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Arquivo extends File {

	private String caminho, nome, caminhoCanonico;
	private byte[] conteudo;

	public String getCaminho() {
		return caminho;
	}

	private void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminhoCanonico() {
		return caminhoCanonico;
	}

	private void setCaminhoCanonico(String caminhoCanonico) {
		this.caminhoCanonico = caminhoCanonico;
	}

	public byte[] getConteudo() {
		return this.conteudo;
	}

	private Arquivo(String caminho) {
		super(caminho);
		this.setCaminho(caminho);

	}
	
	public static Arquivo CriarArquivo(String nome, String caminho, byte[] conteudo) throws IOException
	{
		Arquivo arquivo = new Arquivo(nome, caminho);
		if (oCaminhoEValido(arquivo))
		{
			arquivo.conteudo = conteudo;
			arquivo.SalvarComo(caminho);
			return arquivo;
		}
		else
		{
			throw new FileNotFoundException("Caminho inválido");
		}
	}

	private Arquivo(String nome, String caminho) 
	{
		super(caminho);
		this.setNome(nome);
		this.setCaminho(caminho);
	}

	public void SalvarComo(String caminho) throws IOException {
		Arquivo a = new Arquivo(caminho);
		if (oCaminhoEValido(a)) {
			Path p = a.toPath();
			Files.write(p, conteudo, StandardOpenOption.CREATE);
		}

	}

	private void carregarConteudoDoArquivo() throws IOException {
		Path p = this.toPath();
		if (this.length() <= (20 * 1024 * 1024)) // Menor que 20MB Ajuda evitar
													// OutOFMemory Exception
		{
			this.conteudo = Files.readAllBytes(p);
		} else {
			// TODO: Implementar rotina para arquivos grandes
		}

	}

	public static Arquivo AbrirArquivo(String nome, String caminho)
			throws FileNotFoundException, IOException {
		Arquivo arquivo = new Arquivo(nome, caminho);
		if (oCaminhoEValido(arquivo) && arquivo.canRead()) {
			arquivo.carregarConteudoDoArquivo();
			return arquivo;
		} else {
			throw new FileNotFoundException("O arquivo requerido nao existe");
		}
	}

	private static boolean oCaminhoEValido(Arquivo arquivo) {
		try {
			arquivo.setCaminhoCanonico(arquivo.getCanonicalPath());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.caminhoCanonico + " - " + this.nome;
	}

	@Override
	public boolean equals(Object o) {
		if (Arrays.equals(((Arquivo)o).getConteudo(), this.conteudo)) {
			return true;
		}

		return false;
	}
}
