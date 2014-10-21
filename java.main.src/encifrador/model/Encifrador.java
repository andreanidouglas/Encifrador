package encifrador.model;

import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class Encifrador {
	
	private final String cifrador="RSA/ECB/PKCS1Padding"; //TODO: Interface de selecao de cifra
	
	public Encifrador()
	{
		
	}
	
	public byte[] encriptar(byte[] bytesDeEntrada, PublicKey publicKey) throws Exception
	{
		Cipher cipher = Cipher.getInstance(cifrador);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(bytesDeEntrada);
	}
	
	public byte[] decriptar(byte[] bytesDeEntrada, PrivateKey privateKey) throws Exception
	{
		Cipher cipher = Cipher.getInstance(cifrador);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(bytesDeEntrada);
	}
}
