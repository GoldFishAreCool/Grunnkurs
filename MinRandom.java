import java.util.Scanner;

public class MinRandom
{
	static java.util.Random MinRandom = new java.util.Random(); 
	
	private double nedre; 
	private double ovre;
	private int ned; 
	private int opp;
	
	public MinRandom()
	{ } 
	
	public MinRandom(double nedre, double ovre, int ned, int opp)
	{
		this.nedre = nedre;
		this.ovre = ovre; 
		this.opp = opp;
		this.ned = ned;
	}
	
	public int nesteHeltall()
	{
		int ranTall= MinRandom.nextInt((opp + 1) - ned) + ned;
		return ranTall;
	}
	
	public double nesteDesimaltall()
	{
		double tall =  nedre + (ovre - nedre) * MinRandom.nextDouble();
		return tall;
	}
	
	public void inputInt()
	{
		System.out.println("\nBestem nedre grense: ");
		Scanner i = new Scanner(System.in); 
		ned = i.nextInt();
		
		System.out.println("\nBestem ovre grense: ");
		Scanner o = new Scanner(System.in); 
		opp = o.nextInt();
	}
	
	public void inputDouble()
	{
		System.out.println("\nBestem nedre grense: ");
		Scanner i = new Scanner(System.in); 
		nedre = i.nextDouble();
		
		System.out.println("\nBestem ovre grense: ");
		Scanner o = new Scanner(System.in); 
		ovre = o.nextDouble();
	}
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Hell. Velg hva du vil gjøre med programmet. ");
		
		System.out.println("Number 6- Avslutt.\nNumber 5- Continue.");
		Scanner bs = new Scanner(System.in);
		int valg = bs.nextInt(); 
		
		String inputType = null; 
		switch(valg)
		{
		case 1: inputType = "Random desimaltall i intervallet: "; break; 
		case 2: inputType = "Random heltall i intervallet: "; break;
		case 5: inputType = "Continue "; break;
		case 6: inputType = "Avslutt "; break; 
		
		default:
			System.out.println("Vær så snill, start programmet på nytt og velg tallet fra liste. ");
			return;
		}
		
		do
		{
			System.out.println("\n\nVelg funksjonen fra liste.\n\nTall 1- Random desimaltall i intervallet.\nTall 2- Random heltall i intervallet.\n\nTall 6- Avslutt.");
			Scanner input = new Scanner(System.in);
			double inn = input.nextInt(); 
			
			MinRandom R = new MinRandom();
			
			if (inn == 1 && inn != 6 && inn != 2)
			{
				System.out.println("Random Desimaltall. Good choice, bromigo: ");
				System.out.println("\n\nIntervallet: ");
				R.inputDouble();
				
				System.out.printf("And the lucky number is: %.2f", R.nesteDesimaltall());
				
			}
			
			if (inn == 2 && inn != 1 && inn != 6)
			{
				System.out.println("Random Integerrrrrtall thing. Eggcellent choice. ");
				System.out.println("\n\nIntervallet er da: ");
				R.inputInt();
				
				System.out.println("And the winning number is: " + R.nesteHeltall());
			}
			
			if(inn == 6 && inn != 1 && inn != 2)
			{
				System.out.println("Your loss, chub. Byebye. C: ");
				break;
			}
		}
		
		while (valg == 5 && valg != 6);
	}
}
