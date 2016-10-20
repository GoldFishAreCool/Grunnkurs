import java.util.*;
import java.io.*;

class konto 
{
	public static void main(String[] args) throws IOException 
	{
		String saldoText = "Saldo.txt";
		File transakText = new File("Transaksjon.txt");
		
		FileReader tilFil1 = new FileReader(saldoText);
		BufferedReader leser1 = new BufferedReader(tilFil1);
		
		String saldo = leser1.readLine();
		double saldoLest = Double.parseDouble(saldo);
		leser1.close();
		
		FileReader tilFil2 = new FileReader(transakText);
		BufferedReader leser2 = new BufferedReader(tilFil2);
		Scanner scan = new Scanner(leser2);
		
		while (scan.hasNext()) 
		{
			String transaksjon = scan.nextLine();
			String[] UellerI = transaksjon.split("[ ]");
			
			if (UellerI[0].equals("U")) 
			{
				saldoLest -= Double.parseDouble(UellerI[1]);
			} 
			else if (UellerI[0].equals("I")) 
			{
				saldoLest += Double.parseDouble(UellerI[1]);
			}
		}
		leser2.close();
		
		if (saldoLest >= 0) 
		{
			FileWriter skriveFil = new FileWriter(saldoText);
			PrintWriter skriver = new PrintWriter(new BufferedWriter(skriveFil));
			skriver.print(saldoLest);
			skriver.close();
		}
		else if (saldoLest < 0)
		{
			 transakText.delete();
		}
	}
}
