import java.util.List;

public class SingleThreadSolver implements Solver {

	@Override
	public void solve(List<String> equations) {
		for (String equation : equations)
		{
			System.out.println(equation + " <=> x = " + EquationUtils.solve(equation));
		}
	}
	
	public void solvePart(List<String> equations, int start, int end)
	{
		while (start != end)
		{
			String equation = equations.get(start++);
			System.out.println(equation + " <=> x = " + EquationUtils.solve(equation));
		}
	}

}
