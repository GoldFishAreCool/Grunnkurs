import java.util.Random;
import java.util.Scanner; 

public class Temperature
{ 
	static int in;
	double[][] temperature; 
	double[] midPerDag;
	
	public Temperature(int days)
	{
		this.temperature = new double[days][24];
		Days();
	}
	public Temperature() {} 
	
	public int getDaysInMonth() 
	{
		return temperature.length;
	}
	
	public void Days()
	{
		Random random = new Random();
		for (int i = 0; i < temperature.length; i++)
		{
			for (int o = 0; o < temperature[i].length; o++)
			{
				temperature[i][o] = (double) random.nextInt((50-(-40)) + 1) - 40; 
			}
		}
	}
	
	public double getMidTempPerDay(int day)
	{
		double midTempPerDay = 0;
		
		for (int o = 0; o < temperature[0].length; o++)
		{
			midTempPerDay += temperature[day ][0];
		}
		return (midTempPerDay / (temperature[0].length));
	}
	
	public double getMidTempPerHour(int hour)
	{
		double midTempPerHour = 0;
			
		for (int i = 0; i < temperature.length; i++)
		{
			midTempPerHour += temperature[i][hour];
		}
		return midTempPerHour / (temperature.length);
	}
	
	public double getMidTempMonth()
	{
		double midTempMonth = 0;
		
		for (int i = 0; i < temperature.length; i++)
		{
			for (int o = 0; o < temperature[i].length; o++)
			{
				midTempMonth += temperature[i][o];
			}
		}
		return midTempMonth / (temperature.length * temperature[0].length);
	}
	
	public int[] getGroupTemp()
	{
		int[] groupTemp = new int[5];
		
		for (int i = 0; i < in; i++)
		{
		    	if (getMidTempPerDay(i) < (-5))
    			{
	    			groupTemp[0]++;
		    	}
	    		else if (getMidTempPerDay(i) > (-5) && getMidTempPerDay(i) < 0)
		    	{
			    	groupTemp[1]++;
		    	}
    			else if (getMidTempPerDay(i) > 0 && getMidTempPerDay(i) < 5)
    			{
    				groupTemp[2]++;
    			}
    			else if (getMidTempPerDay(i) > 5 && getMidTempPerDay(i) < 10)
    			{
    				groupTemp[3]++;
    			}
    			else if (getMidTempPerDay(i) > 10)
    			{
    				groupTemp[4]++;
    			}
		}
		return groupTemp;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Number 6- Avslutt.\nNumber 5- Continue.");
		Scanner bs = new Scanner(System.in);
		int valg = bs.nextInt(); 
		
		String inputType = null; 
		switch(valg)
		{
		case 1: inputType = ""; break; 
		case 2: inputType = ""; break;
		case 5: inputType = "Continue"; break;
		case 6: inputType = "Avslutt"; break; 
		
		default:
			System.out.println("Vær så snill, start programmet på nytt og velg tallet fra liste. ");
			return;
		}
		
		do
		{
			System.out.println("\n\nVelg funksjonen fra liste.\n\nTall 1- Mid temp måned.\nTall 2- Mid temp dag.\nTall 3- Mid temp time.\n\nTall 6- Avslutt.");
			Scanner input = new Scanner(System.in);
			double inn = input.nextInt(); 
			String resultat = "";
			
			if (inn == 1 && inn != 6 && inn != 2)
			{
				System.out.println("Antall dager i måned: ");
				Scanner i = new Scanner(System.in); 
				in = i.nextInt(); 
				Temperature l = new Temperature(in);
				
				System.out.printf("Middel temperatur denne måned er: %.2f", l.getMidTempMonth());
				
				int[] grupper = l.getGroupTemp();
				resultat = "\nAnatall dager med temp under -5: " + grupper[0] + " dager.";
				resultat += "\nAntall dager med temp mellom -5 og 0: " + grupper[1] + " dager.";
				resultat += "\nAntall dager med temp mellom 0 og 5: " + grupper[2] + " dager.";
				resultat += "\nAntall dager med temp mellom 5 og 10: " + grupper[3] + " dager.";
				resultat += "\nAntall dager med temp over 10: " + grupper[4] + " dager.";
				System.out.print("\n\n" + resultat);
				
			}
			
			if (inn == 2 && inn != 1 && inn != 6)
			{
				System.out.println("Antall dager i måned: ");
				Scanner i = new Scanner(System.in); 
				int in = i.nextInt(); 
				Temperature l = new Temperature(in);
				System.out.println("Valgt dag: ");
				Scanner o = new Scanner(System.in); 
				int k = o.nextInt();
				
				System.out.printf("Middel temperatur denne dagen er: %.2f", l.getMidTempPerDay(k));	
			}
			
			if (inn == 3)
			{
				System.out.println("Antall dager i måned: ");
				Scanner i = new Scanner(System.in); 
				int in = i.nextInt(); 
				Temperature l = new Temperature(in);
				System.out.println("Valgt time: ");
				Scanner o = new Scanner(System.in); 
				int k = o.nextInt();
				
				System.out.printf("Middel temperatur denne timen er: %.2f", l.getMidTempPerHour(k));	
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
