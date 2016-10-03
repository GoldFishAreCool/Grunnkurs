import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Tekstbehandling 
{
	String text; 
	int numbWords; 
	int numbLetters; 
	
	public Tekstbehandling(String text)
	{
		this.text = text;
		
		StringTokenizer analyze = new StringTokenizer(text);
		numbWords = analyze.countTokens();
		
		while(analyze.hasMoreTokens())
		{
			String words = analyze.nextToken();
			numbLetters += words.length();
		}
	}
	
	public int getNumbWords()
	{
		return numbWords;
	}
	
	public double getAverageWordLength()
	{
		double averageWordLength = 0.0;
		if (numbWords > 0)
		{
			averageWordLength = (double) numbLetters / (double) numbWords;
		}
		
		return averageWordLength;
	}
	
	public double getAverageNumbWordsPeriod()
	{
		String[] period = text.split("[.!:?]");
		int numbWordsPeriod = 0;
		
		for(int i = 0; i < period.length; i++)
		{
			String[] wordPeriod = period[i].split("[ ]");
			
			for(int o = 0; o < wordPeriod.length; o++)
			{
				if(wordPeriod[o].length() > 0)
				{
					numbWordsPeriod++;
				}
			}
		}
		double averageNumbWordsPeriod = (double) numbWordsPeriod / period.length; 
		return averageNumbWordsPeriod; 
	}
	
	public String changeWord(String wordToChange, String wordChangeTo)
	{
		String wordChanged = text.replace(wordToChange, wordChangeTo);
		return wordChanged; 
	}
	
	public String getText()
	{
		return text;
	}
	
	public String getCapitalText()
	{
		String capitalText = text.toUpperCase();
		return capitalText;
	}
	
	public static void main(String[] args)
	{
		String resultat = "";
		
		System.out.println("\nNummer 1- continue. \nNummer 2- avslutte.");
		Scanner bs = new Scanner(System.in);
		int valg = bs.nextInt(); 
		
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
			System.out.println("\nNummer 1 for å skrive ut tekst.\nNummer 2 for å bytte ut ord. ");
			Scanner inn = new Scanner(System.in);
			int hell = inn.nextInt();
		    
			if (hell == 1 && hell != 2) 
			{
				Tekstbehandling analyse = new Tekstbehandling(JOptionPane.showInputDialog("Skriv inn tekst: "));
				resultat = "\nTeksten som du skrev ut er " + analyse.getText();
				resultat += "\nTeksten i store bokstaver " + analyse.getCapitalText();
				resultat += "\nAntall ord i teksten " + analyse.getNumbWords();
				resultat += "\nGjennomsnittlig antall ord per periode " + analyse.getAverageNumbWordsPeriod();
				resultat += "\nGjennomsnittlig ord lengde " + analyse.getAverageWordLength();
				
				JOptionPane.showMessageDialog(null, resultat);
			}

			if (hell == 2 && hell != 1)
			{
				Tekstbehandling analyse = new Tekstbehandling(JOptionPane.showInputDialog("Skriv inn tekst: "));
				String word = JOptionPane.showInputDialog("Hvilket ord vil du bytte ut? ");
				String wordTo = JOptionPane.showInputDialog("Til hvilket ord vil du bytte? ");
				
				resultat = analyse.changeWord(word, wordTo);
				JOptionPane.showMessageDialog(null, resultat);
			}
			}		
			while (valg == 1 && valg != 2);
	}
	
}
