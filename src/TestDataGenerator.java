import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class TestDataGenerator {
	
	private static Random r = new Random();

	public static void main(String[] args) {
				
		int number = 1000000;
		final int minimumTokenCount = 3;
		final int maximumTokenCount = 5;
		final int maximumTokenValue = 99;
		
		
		try
		{
		    PrintWriter writer = new PrintWriter("equations.txt", "UTF-8");
		    
		    while (number-- >= 0)
		    {
		    	ArrayList<String> tokens = new ArrayList<>();
			    final int tokenCount = r.nextInt(maximumTokenCount + 1) + minimumTokenCount;
			    final int eqPosition = 1 + r.nextInt(tokenCount - 2);
			    tokens.add(generateValue(maximumTokenValue) + "x");
			    
			    for (int i = 0; i < tokenCount - 1; i++)
			    {
			    	String suffix = r.nextBoolean() ? "x" : "";
			    	
			    	tokens.add(generateValue(maximumTokenValue) + suffix);
			    }
			    
			    Collections.shuffle(tokens);
			    tokens.add(eqPosition, "=");
			    StringBuilder sb = new StringBuilder();
			    boolean first = true, eq = false;
			    
			    for (String token : tokens)
			    {
			    	if (first)
			    	{
			    		first = false;
			    		
			    		if (token.charAt(0) == '+')
			    			token = token.substring(1, token.length());
			    	}
			    	else if (token.equals("="))
			    	{
			    		eq = true;
			    	}
			    	else if (eq)
			    	{
			    		eq = false;
			    		
			    		if (token.charAt(0) == '+')
			    			token = token.substring(1, token.length());
			    	}
			    	
			    	sb.append(token);
			    }
			    
			    writer.println(sb.toString());
		    }
		    
		    writer.close();
		} catch (IOException e)
		{
		   System.out.println("Can not create a file!");
		}
		
	}
	
	private static String generateValue(int max)
	{
		return (r.nextBoolean() ? "-" : "+") + r.nextInt(max);
	}

}
