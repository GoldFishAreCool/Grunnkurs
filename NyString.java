import javax.swing.JOptionPane;

public class NyString
{
	private static String text = "";
	
	public NyString(String text)
	{
		this.text = text; 
	}
	
	String getText()
	{
		return text;
	}
	
	public String getKortere()
	{
		String[] word = text.split(" ");
		String kortereText = "";
		
		for (int i = 0; i < word.length; i++)
		{
			kortereText += word[i].charAt(0);
		}
		return kortereText; 
	}
	
	public String getFjerneTing(char bokstav)
	{
		String fjerning = " ";
		if (text != null)
		{
			fjerning = text.replace(bokstav,  ' ');
		}
		return fjerning; 
	}
	
	public static void main(String[] args)
	{
		String resultat = " ";
		
		NyString analyse = new NyString(JOptionPane.showInputDialog("Skriv inn tekst: ")); 
		
		String tegnRemove = JOptionPane.showInputDialog("Hvilket bokstav vil du fjerne? ");
		
		char bokstav = tegnRemove.charAt(0);		
		
		resultat = "\nTegnene i ordene er: " + analyse.getKortere();
		resultat += "\nTeksten blir til: " + analyse.getFjerneTing(bokstav);
		
		JOptionPane.showMessageDialog(null, resultat);
	}
}
