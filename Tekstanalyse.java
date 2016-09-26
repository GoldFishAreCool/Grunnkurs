//This was hell. 

	private String originalString = "";
	private String string = "";
	private int[] antallTegn = new int[30];
	
	public Tekstanalyse() {}
	
	public Tekstanalyse(String string) 
	{
		originalString = string;
		this.string = string.toLowerCase();
	}
	
	public void setString(String string) 
	{
		originalString = string;
		this.string = string.toLowerCase();
	}
	
	public String getString()
	{
		return originalString; 
	}
	
	public String getString(String string2) 
	{
		return originalString;
	}
	
	public void addToArray() 
	{
		for (int i = 0; i < string.length(); i++) 
		{
			char tegn = string.charAt(i);
			antallTegn[charToArrayNumb(tegn)] += 1;
		}
	}
	
	public int charToArrayNumb(char a) 
	{
		int value = a; // char til int
		int plass;
		if (value >= 97 && value <= 122) 
		{
			plass = value - 97;
		} 
		else if (value == 230) 
		{ // æ
			plass = 26;
		} 
		else if (value == 248) 
		{ // ø
			plass = 27;
		} 
		else if (value == 229)
		{ // å
			plass = 28;
		} 
		else 
		{
			plass = 29;
		}
		return plass;
	}
	
	public String arrayNumbToChar(int i) 
	{
		String a = "";
		if (i >= 0 && i <= 25) 
		{
			a += (char) (i + 97);
		} 
		else if (i == 26) 
		{
			a += "æ"; 
		} 
		else if (i == 27) 
		{
			a += "ø";
		} 
		else if (i == 28) 
		{
			a += "å";
		} 
		else 
		{
			a += "thingies";
		}
		return a;
	}
	
	public int totalChars()
	{
		int counter = 0;
		for (int i = 0; i < antallTegn.length - 1; i++) 
		{
			counter += antallTegn[i];
		}
		return counter;
	}
	
	public int uniqueChars() 
	{
		int counter = 0;
		for (int i = 0; i < antallTegn.length - 1; i++) {
			if (antallTegn[i] != 0) {
				counter++;
			}
		}
		return counter;
	}
	
	public String mostOccuringLetter() 
	{
		String letter = " ";
		int numb = 0;
		for (int i = 0; i < antallTegn.length - 1; i++) 
		{
			if (antallTegn[i] > numb) 
			{
				numb = antallTegn[i];
				letter = arrayNumbToChar(i);
			} 
			else if (antallTegn[i] == numb) 
			{
				letter += arrayNumbToChar(i);
			}
		}
		return "Most of all: " + letter + " with " + numb + " times.";
	}
	
	public String outputArray() 
	{
		String outputString = " ";
		for (int i = 0; i < antallTegn.length; i++) 
		{
			outputString += arrayNumbToChar(i) + ": " + antallTegn[i] + "\n";
		}
		return outputString;
	}
	
	public String returnValue() 
	{
		String outputString = "";
		for (int i = 0; i < string.length(); i++) 
		{
			char tegn = string.charAt(i);
			int value = tegn; // char til int
			outputString += "Tegn: " + tegn + ", har litt verdi: " + value + "\n";
		}
		return outputString;
	}
	
	public String notLetters() 
	{
		int letters = 0;
		int percent = 100;
		int notLetters = antallTegn[29];
		for (int i = 0; i < antallTegn.length - 1; i++) 
		{
			letters += antallTegn[i];
		}
		if (letters != 0) {
			percent = (notLetters * 100) / (letters + notLetters);
		}
		return percent + "%";
	}
	
	public int getNumbofLetter(String bokstav) 
	{
	    int bestemtBokstav = bokstav.charAt(0);
	    if (bestemtBokstav >= 65 && bestemtBokstav <= 90) 
	    {
	      bestemtBokstav -= 'A';
	    } 
	    else if (bestemtBokstav >= 97 && bestemtBokstav <= 122) 
	    {
	    	bestemtBokstav -= 'a';
	    } 
	    else if (bestemtBokstav == 'Æ') 
	    {
	    	bestemtBokstav = 26;
	    } 
	    else if (bestemtBokstav == 'Ø') 
	    {
	    	bestemtBokstav = 27;
	    } 
	    else if (bestemtBokstav == 'Å') 
	    {
	    	bestemtBokstav = 28;
	    }
	    return antallTegn[bestemtBokstav] / 2;
	  }
	  
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Hell. Velg om du vil fortsette: ");
		
		System.out.println("\nNummer 1- continue. \nNummer 2- avslutte.");
		Scanner bs = new Scanner(System.in);
		int valg = bs.nextInt(); 
		
		char Char = 'a';
		
		String inputType = null; 
		switch(valg)
		{
		case 1: inputType = "Continue "; break;
		case 2: inputType = "Avslutt "; break; 
		case 3: inputType = "Some more hell"; break;
		
		default:
			System.out.println("Vær så snill, start programmet på nytt og velg tallet fra liste. ");
			return;
		}
		
		do 
		{
			System.out.println("\n1 for å gå videre til helvete.\n2 for avslutte.\nNummer 3 litt mer helvete. ");
			Scanner shit = new Scanner(System.in); 
			int hell = shit.nextInt();
			
			Tekstanalyse st = new Tekstanalyse();
		    
			if (hell == 1 && hell != 2) 
			{
				System.out.println("Hello there, sexy. ");
				st.setString(JOptionPane.showInputDialog("Skriv inn en string du vil analysere:"));
				st.addToArray(); 
		
	        	System.out.println(st.returnValue()); 
	        	
	        	System.out.println("Analyserer denne stringen: '" + st.getString() + "'");
	        	
	        	System.out.println(st.outputArray());
	        	
	        	System.out.println("Antall unike bokstaver: " + st.uniqueChars());
	        	
	        	System.out.println("Totalt antall bokstaver: " + st.totalChars());
	        	
	        	System.out.println(st.mostOccuringLetter());
	        	
	        	System.out.println(st.notLetters() + " av teksten er ikke bokstaver.");
			
	        	String bokstav = (JOptionPane.showInputDialog("Skriv inn ett bokstav, bare ett:"));
				st.addToArray();
				System.out.println("Bokstaven, that you have chosen... " + bokstav.charAt(0) + " is not a vinner but was used... " + st.getNumbofLetter(bokstav));
			}

			if (hell == 2 && hell != 1)
			{
				System.out.println("This was pain in the ass...");
				break;
			}
			}		
			while (valg == 1 && valg != 2);
	}
}
