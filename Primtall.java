import static javax.swing.JOptionPane.*;

//make a codey code for primary numbers//

public class primtallyah
{
	public static void main (String[] args)
	{
		int number = Integer.parseInt(showInputDialog("Choose number, sucker: "));
		int divisor = 2;
		int counter = 0; 
		
		while (number != 0)
		{
			while (divisor <= (number / 2))
			{
				if (number % divisor == 0)
				{
					counter++;
				}
			divisor++;
			}
			
			if (counter > 0)
			{
				System.out.println("The number ain't prime as fuck: " + number);
			}
			else 
			{
				System.out.println("The number is prime as fuck: " + number);
			}
			number= Integer.parseInt(showInputDialog("Choose number, sucker: "));
			divisor = 2; 
			counter = 0; 
		}
	}	
}	
