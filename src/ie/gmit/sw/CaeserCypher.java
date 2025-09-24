package ie.gmit.sw;

import java.util.Iterator;

public class CaeserCypher implements Cypherable {

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
		doCypher(plainText, true);
		return plainText;
	}

	public String decrypt(String cypherText) throws CypherException {
		return new String(decrypt(cypherText.getBytes()));
	}

	public byte[] decrypt(byte[] cypherText) throws CypherException {
		doCypher(cypherText, false);
		return cypherText;
	}

	private byte[] doCypher(byte[] bytes, boolean encrypt) {
		for (int i = 0; i < bytes.length; i++) {
			if (encrypt) {
				bytes[i] += Integer.parseInt(key.getKey());
			} else {
				bytes[i] -= Integer.parseInt(key.getKey());
			}
		}
		
		return bytes;

	}

	@SuppressWarnings("removal")
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	public class CaeserCypherKeyImpl implements CypherKey {

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
