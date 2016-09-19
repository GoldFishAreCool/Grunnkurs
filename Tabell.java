import java.util.Scanner;

public class Tabell 
{
	static java.util.Random random = new java.util.Random(); 
	
	public static int ganger; 
	
	public Tabell(){}
	
	public Tabell(int ganger)
	{
		this.ganger = ganger;
	}
	
	public int getGanger()
	{
		return this.ganger; 
	}
	
	public void input()
	{
		do
		{
			System.out.println("\nHvor mange ganger vil du generere random tall? ");
			Scanner i = new Scanner(System.in);
			ganger = i.nextInt(); 
		}
		while (ganger == 0);
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("Number 1 to continue. Number 2 to exit.");
		Scanner bs = new Scanner(System.in);
		int valg = bs.nextInt(); 
		
		String inputType = null; 
		switch(valg)
		{
		case 1: inputType = "Continue "; break; 
		case 2: inputType = "Exit "; break; 
		
		default:
			System.out.println("Vær så snill, start programmet på nytt og velg tallet fra liste. ");
			return;
		}
		do
		{
			System.out.println("\n\nHello. 1 - For å skrive ut tabell og 2 om du vil avslutte.");
			Scanner a = new Scanner(System.in);
			int l = a.nextInt();
			
			if (l == 1)
			{
				Tabell p = new Tabell();
				p.input();
				
				int[] antall = new int[10];
		
				for (int t = 0; t < ganger; t++)
				{
					int tall = random.nextInt(10); 
					antall[tall] += 1;
		    
				}
		
				for (int m = 0; m < antall.length; m++)
				{
					String starshine = " "; 
					double number = antall[m]; 
					double numberStarshine = number; 
					for (int n = 0; n < numberStarshine; n++)
					{
						starshine += "*";
					}
					
					System.out.println("Ganger " + m + "- " + antall[m] + " " + starshine);
					}
				}
			
			if (l == 2 && l != 1)
			{
				System.out.println("\n\nThank you. Hope you gonna have a good day." );
				break; 
			}
		}
		while (valg == 1);

	}
}
