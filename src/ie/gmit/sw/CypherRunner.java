package ie.gmit.sw;

public class CypherRunner {
	public static void main(String[] args) throws CypherException {
		CaeserCypher cc = new CaeserCypher();
		
		CypherKey ck = cc.new CypherKeyImpl();
		
		String s = "Happy days";
		String t = cc.encrypt(s);
		
		System.out.println(t);
		System.out.println(cc.decrypt(t));
	}
}
