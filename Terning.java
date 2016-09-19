public class Terning
{
	java.util.Random terning = new java.util.Random(); /*Tilfeldigtallgenerator*/
	private int sum = 0;
	private int kast; 
	public boolean done = false; 
	
	public Terning()
	{	}
	
	public int getPoeng()
	{
		return sum; 
	}

	public void kastTerning()
	{
		kast = terning.nextInt(6) + 1; /*tilfeldig tall [0,5]*/
		if (kast == 1)
		{
			sum = 0;
		}
		
		else 
		{
			sum += kast;
		}
	}
	
	public boolean done()
	{
		if (sum == 100)
		{
			done = true;
		}
		
		else 
		{
			done = false; 
		}
		
		return done; 
	}
	/*klient program*/
	public static void main(String[] args)
	{
		int round = 0; 
		
		Terning playerA = new Terning(); /*Tar inn class Terning, lager to objekter til klassen*/
		Terning playerB = new Terning();
		
		while (!playerA.done() && !playerB.done())
		{
			playerA.kastTerning(); /*kjører klasser*/
			playerB.kastTerning();
			
			round++; /*legger til runder til poengsum blir 100*/
			
			System.out.println("Runde: " + round + "\nPoeng spiller A: " + playerA.getPoeng());
			System.out.println("Runde: " + round + "\nPoeng spiller B: " + playerB.getPoeng());
		}
		
		if (playerA.done)
		{
			System.out.println("Spiller A har fått 100 poeng og har vunnet spillet. Fuck you, player B. :)");
		}
		else 
		{
			System.out.println("Spiller B har fått 100 poeng og har vunnet spillet. Fuck you, player A. Nobody likes you. :)");
		}
	}
}
