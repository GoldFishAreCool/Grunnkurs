import java.util.Scanner; 

public class mathbitch
{
	public static void main (String[] args)
	{
		int num1, num2, num3, num4;
		Scanner a = new Scanner(System.in);
		System.out.println("Skriv inn tallet du vil få gange tabell av ");
		num1 = a.nextInt(); 
		Scanner b = new Scanner(System.in);
		System.out.println("Skriv inn tall du vil ha gange tabell til ");
		num2 = b.nextInt();
		
		for (num3 = num1; num3 <= num2; num3++)
		{
			System.out.println("Gange tabell av " + num3);
			
			for (num4 = 1; num4 <= 10; num4++)
			{
				System.out.println(num3 + " * " + num4 + " = " + (num3*num4));
			}
		}
	}
}
