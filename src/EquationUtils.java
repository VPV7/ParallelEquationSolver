import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationUtils {

	public static double solve(final String equation) 
	{
		int eqPos = equation.indexOf('=');
		String left = equation.substring(0, eqPos);
		String right = equation.substring(eqPos + 1, equation.length());
		double x = 0d;
		double num = 0d;
		double[] leftRes = extract(left);
		double[] rigthRes = extract(right);
		x = leftRes[0] - rigthRes[0];
		num = rigthRes[1] - leftRes[1];
		
		return x == 0d ? Double.NaN : num / x;
	}
	
	private static double[] extract(String str)
	{
		double x = 0d;
		double num = 0d;
		Pattern pattern = Pattern.compile("[+-]{0,1}\\d*x{0,1}");
		Matcher matcher = pattern.matcher(str);
		
		while (matcher.find())
		{
			boolean isx = false;
			String token = str.substring(matcher.start(), matcher.end());
			
			if (token.isEmpty())
			{
				continue;
			}
			
			if (token.charAt(token.length() - 1) == 'x')
			{
				isx = true;
				token = token.substring(0, token.length() - 1);
				
				if (token.length() == 0 || token.equals("+") || token.equals("-"))
				{
					token += 1;
				}
			}
			
			if (isx)
			{
				x += Double.parseDouble(token);
			}
			else
			{
				num += Double.parseDouble(token);
			}
		}
		
		return new double[] { x, num };
	}
	
}
