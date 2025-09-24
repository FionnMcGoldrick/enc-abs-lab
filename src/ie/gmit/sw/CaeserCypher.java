package ie.gmit.sw;

import java.util.Iterator;

public class CaeserCypher {
	
	public int key;

	public String encrypt(String plainText) throws CypherException {
		return new String(encrypt(plainText.getBytes()));
	}

	public byte[] encrypt(byte[] plainText) throws CypherException {
		for (int i = 0; i < plainText.length; i++) {
			plainText[i] += key;
		}
		return plainText;
	}

	public String decrypt(String cypherText) throws CypherException {
		return new String(decrypt(cypherText.getBytes()));
	}

	public byte[] decrypt(byte[] cypherText) throws CypherException {
		for (int i = 0; i < cypherText.length; i++) {
			cypherText[i] -= key;
		}
		return cypherText;
	}

	@SuppressWarnings("removal")
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
	
	
}
