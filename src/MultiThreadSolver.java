import java.util.ArrayList;
import java.util.List;

public class MultiThreadSolver implements Solver {

	private final int tnum = 2;
	
	@Override
	public void solve(List<String> equations) {
		int size = equations.size();
		final int num = size / tnum;
		int i = 0;
		ArrayList<Thread> threads = new ArrayList<>();
		
		while (i < size)
		{
			final int start = i;
			final int end = start + num;
			final int removed = end >= size ? end - size : 0;
			i = end;
			
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					new SingleThreadSolver().solvePart(equations, start, end - removed);
				}
			});
			
			thread.start();
			
			threads.add(thread);
		}
		
		for (Thread thread : threads)
		{
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
