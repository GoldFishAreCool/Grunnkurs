import java.util.Scanner;

public class Fraction
{
	private int nevner;
	private int teller;
	
	public Fraction()
	{	}
	
	public Fraction(int teller, int nevner)
	{
		this.teller = teller;
		this.nevner = nevner;
		
		if (nevner == 0)
		{
		throw new IllegalArgumentException("You typed in zero, you mofo");
		}
		
		if (nevner < 0)
		{
			nevner *= -nevner;
			teller *= -teller;
		}
	}
	
	public Fraction(int teller)
	{
		this.teller = teller; 
		this.nevner = 1;
	}
	
	public int getNevner()
	{
		return this.nevner;
	}
	
	public int getTeller()
	{
		return this.teller;
	}
	
	public int fellesLavestTing(int nevner1, int nevner2)
	{
		int factor = nevner1; 
		
		while ((nevner1 % nevner2) != 0)
		{
			nevner1 += factor;
		}
		
		return nevner1;
	}
	
	public int fellesNevnerTing(int nevner1, int nevner2) //Finner felles nevner ting //
	{
		int factor = nevner2;
		
		while (nevner2 !=0)
		{
			factor = nevner2;
			nevner2 = nevner1 % nevner2;
			nevner1 = factor;
		}
		return nevner1; 
	}
	
	private Fraction convert(int felles)
	{
		Fraction resultat = new Fraction(); 
		int factor = felles / nevner; 
		resultat.teller = teller * factor; 
		resultat.nevner = felles; 
		return resultat; 
	}
	
	public Fraction addisjon(Fraction b)
	{
		int felles = fellesLavestTing(nevner, b.nevner);
		Fraction fellesA = new Fraction();
		Fraction fellesB = new Fraction();
		
		fellesA = convert(felles); 
		fellesB = b.convert(felles);
		
		Fraction summert = new Fraction(); //Lager ny brøk som kan returneres som sum
		summert.teller = fellesA.teller + fellesB.teller;
		summert.nevner = felles;
		summert = summert.reduceFraction();
		return summert;
	}
	
	public Fraction subtraksjon(Fraction b)
	{
		int felles = fellesLavestTing(nevner, b.nevner);
		Fraction fellesA = new Fraction();
		Fraction fellesB = new Fraction();
		
		fellesA = convert(felles); 
		fellesB = b.convert(felles);
		
		Fraction diff = new Fraction(); //Lager ny brøk som kan returneres som sum
		diff.teller = fellesA.teller - fellesB.teller;
		diff.nevner = felles;
		diff = diff.reduceFraction();
		return diff;
	}
	
	public Fraction multiplikasjon(Fraction b)
	{
		Fraction multi = new Fraction(); 
		multi.teller = teller * b.teller; 
		multi.nevner = nevner * b.nevner;
		multi = multi.reduceFraction();
		return multi;
	}
	
	public Fraction divisjon(Fraction b)
	{
		Fraction divi = new Fraction();
		divi.teller = teller * b.nevner; 
		divi.nevner = nevner * b.teller;
		divi = divi.reduceFraction();
		return divi;
	}
	
	public void input()
	{
		System.out.println("\nBestem verdien for teller til brøk 1: ");
		Scanner i = new Scanner(System.in); 
		teller = i.nextInt();
		
		do
		{
			System.out.println("\nBestem verdien for nevner til brøk 1: ");
			Scanner o = new Scanner(System.in); 
			nevner = o.nextInt();
			
			if (nevner == 0)
			{
				System.out.println("\nFeil tall, mofo. Det kan ikke være 0. Prøv igjen");
			}
		}
		while (nevner == 0);
	}
	
	private Fraction reduceFraction()
	{
		Fraction resultat = new Fraction();
		int felles = 0;
		
		int t = Math.abs(teller);
		int n = Math.abs(nevner);
		
		if (t > n)
		{
			felles = fellesNevnerTing(t, n);
		}
		
		else if (t < n)
		{
			felles = fellesNevnerTing(n, t);
		}
		
		else 
		{
			felles = t;
		}
		
		resultat.teller = teller / felles;
		resultat.nevner = nevner / felles;
		return resultat;
	}
	
	public String toString()
	{
		String yes = teller + "/" + nevner + " eller " + (teller/nevner) + " " + (teller % nevner) + "/" + nevner;
		return yes;
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
		case 1: inputType = "Addisjon av to brøk "; break; 
		case 2: inputType = "Subtraksjon av to brøk  "; break;
		case 3: inputType = "Multiplikasjon av to brøk "; break; 
		case 4: inputType = "Divisjon av to bræk "; break;
		case 5: inputType = "Continue "; break;
		case 6: inputType = "Avslutt "; break; 
		
		default:
			System.out.println("Vær så snill, start programmet på nytt og velg tallet fra liste. ");
			return;
		}
		
		do
		{
			System.out.println("\nVelg funksjonen fra liste.\n\nTall 1- Addisjon av to brøk.\nTall 2- Subtraksjon av to brøk.\nTall 3- Multiplikasjon av to brøk.\nTall 4- Divisjon av to brøk.\n\nTall 6- Avslutt.");
			Scanner input = new Scanner(System.in);
			double inn = input.nextInt(); 
			
			Fraction F1 = new Fraction();
			Fraction F2 = new Fraction();			
					
		if (inn == 1 && inn != 6)
		{
			System.out.println("Addisjon: ");
			System.out.println("\n\nBrøk 1: ");
			F1.input();
			System.out.println("\n\nBrøk 2: ");
			F2.input();
			System.out.println(F1.addisjon(F2));
		}
		
		if (inn == 2 && inn != 6)
		{
			System.out.println("Subtraksjon: ");
			System.out.println("\n\nBrøk 1: ");
			F1.input();
			System.out.println("\n\nBrøk 2: ");
			F2.input();
			System.out.println(F1.subtraksjon(F2));
		}
		
		if (inn == 3 && inn != 6)
		{
			System.out.println("Multiplikasjon: ");
			System.out.println("\n\nBrøk 1: ");
			F1.input();
			System.out.println("\n\nBrøk 2: ");
			F2.input();
			System.out.println(F1.multiplikasjon(F2));
		}
		
		if (inn == 6 && inn != 6)
		{
			System.out.println("Divisjon: ");
			System.out.println("\n\nBrøk 1: ");
			F1.input();
			System.out.println("\n\nBrøk 2: ");
			F2.input();
			System.out.println(F1.divisjon(F2));
		}
		
		if (inn == 6 && inn != 1 && inn != 2 && inn != 3 && inn != 4) 
		{
			System.out.println("\nTakk at du brukte meg. Bye bye, asshole. :)"); 
			break;
		}
		}
		while (valg != 6 && valg == 5);
	}
}
