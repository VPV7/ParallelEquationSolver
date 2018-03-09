import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChaoticMultiThreadSolver implements Solver {

	private class SolveTask implements Runnable
	{
		private String equation;
		
		private SolveTask(String equation) {
			super();
			this.equation = equation;
		}

		@Override
		public void run() {
			double result = EquationUtils.solve(equation);
			System.out.println(equation + " <=> x = " + result);
		}
	}
	
	private ExecutorService executor = Executors.newFixedThreadPool(1);

	public ChaoticMultiThreadSolver() {
		super();
	}
	
	public void solve(List<String> equations)
	{
		for (String equation : equations)
		{
			executor.execute(new SolveTask(equation));
		}
		
		dispose();
	}
	
	private void dispose()
	{
		executor.shutdown();
		
		while (!executor.isTerminated());
	}
	
	
}
