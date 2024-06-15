package runner;
import generator.*;

public class runner {

	
	public static void main (String[] args) {
		
		sheetGenerator gen = new sheetGenerator();
		
		String[] results = gen.createSheet();
		for (int i = 0; i < results.length; i++) {
			
			System.out.println(results[i]);
		}
		
	}
}
