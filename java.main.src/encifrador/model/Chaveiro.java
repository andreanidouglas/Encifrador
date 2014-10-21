package encifrador.model;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Hashtable;

public class Chaveiro {
	
	private PublicKey  publicKey;
	private PrivateKey privateKey;
	private Hashtable<String, PublicKey> chavesPublicas;
	private Hashtable<String, PublicKey> chavesPrivadas;
	
	public void inicializadorDeChaves(long seed)
	{
		try
		{
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
			random.setSeed(seed);
			kpg.initialize(1024, random);
			KeyPair kp = kpg.generateKeyPair();
			publicKey = kp.getPublic();
			privateKey = kp.getPrivate();
		}
		catch (Exception e)
		{
			//TODO: Implementar falhas na inicializacao da chave
			e.printStackTrace();
		}
	}
	
	public void adcionarChavePublica(String identificador, PublicKey publicKey)
	{
		chavesPublicas.put(identificador, publicKey);
	}
	public void removerChavePublica(String identificador)
	{
		PublicKey pk = chavesPublicas.get(identificador);
		chavesPublicas.remove(pk);
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

}
