import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("equations.txt"));
		String line;
		ArrayList<String> equations = new ArrayList<>();
		
		while ((line = br.readLine()) != null)
		{
			equations.add(line);
		}
		
		br.close();
		long start = System.currentTimeMillis();
		Solver solver = new MultiThreadSolver();
		solver.solve(equations);
		
		System.out.println("Total time: " + (System.currentTimeMillis() - start));
	}
	
}
