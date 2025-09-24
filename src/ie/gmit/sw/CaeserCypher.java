package ie.gmit.sw;

import java.util.Iterator;

public class CaeserCypher {
	
	private CypherKey key;

	public CypherKey getKey() {
		return key;
	}

	public void setKey(CypherKey key) {
		this.key = key;
	}

	public String encrypt(String plainText) throws CypherException {
		return new String(encrypt(plainText.getBytes()));
	}

	public byte[] encrypt(byte[] plainText) throws CypherException {
		for (int i = 0; i < plainText.length; i++) {
			plainText[i] += Integer.parseInt(key.getKey());
		}
		return plainText;
	}

	public String decrypt(String cypherText) throws CypherException {
		return new String(decrypt(cypherText.getBytes()));
	}

	public byte[] decrypt(byte[] cypherText) throws CypherException {
		for (int i = 0; i < cypherText.length; i++) {
			cypherText[i] -= Integer.parseInt(key.getKey());
		}
		return cypherText;
	}

	@SuppressWarnings("removal")
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
	
	public class CypherKeyImpl implements CypherKey {
		
		private int key;

		@Override
		public void setKey(String key) throws CypherException {
			this.key = Integer.parseInt(key);
		}

		@Override
		public String getKey() {
			return "" + key;
		}
		
	}
	
}
