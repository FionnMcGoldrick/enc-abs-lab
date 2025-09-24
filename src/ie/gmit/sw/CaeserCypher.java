package ie.gmit.sw;

import java.util.Iterator;

public class CaeserCypher extends AbstractCypher {

	public byte[] doCypher(byte[] bytes, boolean encrypt) {
		int k = Integer.parseInt(super.getCypherKey().getPattern());
		for (int i = 0; i < bytes.length; i++) {
			if (encrypt) {
				bytes[i] += k;
			} else {
				bytes[i] -= k;
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
		public void setPattern(String key) throws CypherException {
			this.key = Integer.parseInt(key);
		}

		@Override
		public String getPattern() {
			return "" + key;
		}

	}

}
