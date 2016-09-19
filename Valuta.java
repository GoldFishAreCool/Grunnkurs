import java.util.Scanner;

public class Valuta
{
	private static double amount;
	private double rate;
	private int enhet;
		  
	public Valuta(double amount, double rate, int enhet) 
	{
		this.amount = amount;
		this.rate = rate;
		this.enhet = enhet;
	}
	
	public double beregnFraNok() 
	{
		return amount / rate * enhet;
	}
		  
	public double beregnTilNok() 
	{
		return amount * rate / enhet;
	}
	
	public String toString ()
	{
		return "\nKurs: " + rate + " NOK" + "\nEnhet: " + enhet;		
	}
	public static void main(String[] args)  
	{
		System.out.println("Velkommen til valuta kalkulator\n");
		
		System.out.println("Number 4- Avslutt.\nNumber 5- Continue.");
		System.out.println("Velg funksjonen fra liste.\n " );
		Scanner bs = new Scanner(System.in);
		int valg = bs.nextInt(); 
		
		String inputType = null; 
		switch(valg)
		{
		case 1: inputType = "Svenske Kroner "; break; 
		case 2: inputType = "Amerikanske dollar "; break;
		case 3: inputType = "Euro "; break; 
		case 4: inputType = "Avslutt "; break;
		case 5: inputType = "Continue"; break;
		case 6: inputType = "Få valutakurs"; break; 
		
		default:
			System.out.println("Vær så snill, start programmet på nytt og velg tallet fra liste. ");
			return;
		}
		
		while (valg != 4 && valg == 5)
		{
			System.out.println("\nVelg valuta inn fra liste du vil veksle fra eller avslutt.\nNumber 1- SEK.\nNumber 2- USD.\nNumber 3- EURO.\nNumber 4- Avslutt.\nNumber 6- Få valutakurs. ");
			Scanner input = new Scanner(System.in);
			double inn = input.nextDouble(); 
			
			Valuta USD = new Valuta(amount, 8.21, 1);
			Valuta EUR = new Valuta(amount, 9.25, 1); 
			Valuta SEK = new Valuta(amount, 97.32, 100); 
					
		if (inn == 1 && inn != 4)
		{
			System.out.println("\nSkriv inn belop du vil veksle til norske kroner: ");
			Scanner Amount = new Scanner(System.in);
			amount = Amount.nextDouble();
			
			System.out.printf("Belop er: %.2f" + " NOK", SEK.beregnTilNok());
		}
		
		if (inn == 2 && inn != 4)
		{
			System.out.println("\nSkriv inn belop du vil veksle til norkse kroner: ");
			Scanner Amount = new Scanner(System.in);
			amount = Amount.nextDouble();
		
			System.out.printf("Belop er: %.2f" + " NOK", USD.beregnTilNok());
		}
		
		if (inn == 3 && inn != 4)
		{
			System.out.println("\nSkriv inn belop du vil veksle til norske kroner: ");
			Scanner Amount = new Scanner(System.in);
			amount = Amount.nextDouble();
			
			System.out.printf("Belop er: %.2f" + " NOK", EUR.beregnTilNok());
		}
		
		if (inn == 6 && inn != 4)
		{
			System.out.printf( "\nSvenske Kroner: " + SEK.toString() + " SEK" + "\n\nAmerikanske Dollar: " + USD.toString() + " USD" + "\n\nEuro: " + EUR.toString() + " EUR");
		}
		
		if (inn == 4 && inn != 1 && inn != 2 && inn != 3) 
		{
			System.out.println("\nTakk at du brukte meg. Bye bye. :)"); 
			break;
		}
		}
	}

}
