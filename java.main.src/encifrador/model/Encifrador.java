package encifrador.model;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class Encifrador {
	
	private PublicKey _publicKey;
	private PrivateKey _privateKey;
	private final String cifrador="RSA/ECB/PKCS1Padding";
	
	public Encifrador()
	{
		
	}
	
	public void inicializadorDeChave()
	{
		try
		{
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(1024);
			KeyPair kp = kpg.generateKeyPair();
			_publicKey = kp.getPublic();
			_privateKey = kp.getPrivate();
		}
		catch (Exception e)
		{
			//TODO: Implementar falhas
			e.printStackTrace();
		}
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

	public PrivateKey get_privateKey() {
		return _privateKey;
	}

	public PublicKey get_publicKey() {
		return _publicKey;
	}

	
}
