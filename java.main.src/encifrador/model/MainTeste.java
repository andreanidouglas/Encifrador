package encifrador.model;

import java.io.UnsupportedEncodingException;

public class MainTeste {
	public static void main (String args[])
	{

		byte[] stringASerCifrada;
		stringASerCifrada = "Ola Mundo".getBytes();
		Encifrador en = new Encifrador();
		en.inicializadorDeChave();
		
		try {
			stringASerCifrada = en.encriptar(stringASerCifrada, en.get_publicKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(stringASerCifrada.toString());
		
		try
		{
			stringASerCifrada = en.decriptar(stringASerCifrada, en.get_privateKey());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		try {
			System.out.println(new String(stringASerCifrada, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
