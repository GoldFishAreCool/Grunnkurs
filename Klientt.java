import java.util.Scanner;

class Student
{
	String navn; 
	int antOppg; 
	
	public Student(String navn, int antOppg)
	{
		this.navn = navn; 
		this.antOppg = antOppg;
	}
	
	public String getNavn()
	{
		return navn;
	}
	
	public int getAntOppg()
	{
		return antOppg;
	}
	
	public void okAntOppg(int okning)
	{
		antOppg += okning;
	}
	
	public String toString()
	{
		return navn + ", antall oppgaver godkjent: " + antOppg;
	}
}

/*class Test 
{
	public static void main(String[] args)
	{
		Student student = new Student("Potato Sweetpotato"); 
		System.out.println("\nIdk what to say: " + student.toString());
		student.okAntOppg(12);
		System.out.println("\nSomething more to say: " + student.toString());
	}
}*/

class Oppgaveoversikt
{
	Student[] studenter = new Student[0]; 
	int antStud = 0; 
	
	public Oppgaveoversikt()
	{	}
	
	public int getAntStud()
	{
		return studenter.length; 
	}
	
	public int getStudInd(String navn)
	{
		for (int i = 0; i < studenter.length; i++)
		{
			if (navn.matches(studenter[i].getNavn()))
			{
				return i;
			}
		}
		return 0;
	}
	
	public int getAntOppgLost(String navn)
	{
		int index = getStudInd(navn);
		return studenter[index].getAntOppg();
	}
	
	public int arrayExpand()
	{
		for (int i = 0; i < studenter.length; i++)
		{
			if (studenter[i] == null)
			{
				return i;
			}
		}
		
		Student[] newArray = new Student[studenter.length + 1]; 
		
		for (int i = 0; i < studenter.length; i++)
		{
			newArray[i] = studenter[i];
		}
		this.studenter = newArray; 
		return studenter.length - 1; 
	}
	
	public void nyStudent(String navn)
	{
		int index = arrayExpand();
		studenter[index] = new Student(navn, 0);
	}
	
	public void nyStudent(String navn, int antOppg)
	{
		int index = arrayExpand();
		studenter[index] = new Student(navn, antOppg);
	}
	
	public boolean okAntOppg(String navn, int okning)
	{
		int index = getStudInd(navn);
		if (index == 0)
		{
			return false;
		}
		
		studenter[index].okAntOppg(okning);
		return true;
	}
	
	public String toString()
	{
		String resultat = ""; 
		for (int i = 0; i < studenter.length; i++)
		{
			resultat += "Student: " + studenter[i].getNavn() + ", \nOppgaver lost: " + studenter[i].getAntOppg() + "\n";
		}
		return "\n" + resultat;
	}
}

class Input
{
	public Input(){}
	
	public int getInt(String dialog)
	{
		System.out.println(dialog); 
		Scanner inn = new Scanner(System.in);
		int input = inn.nextInt();
		return input;
	}
	
	public double getDouble(String dialog)
	{
		System.out.println(dialog);
		Scanner inn = new Scanner(System.in);
		double input = inn.nextDouble();
		return input;
	}
	
	public String getString(String dialog)
	{
		System.out.println(dialog);
		Scanner inn = new Scanner(System.in); 
		String input = inn.next();
		return input;
	}
	
	public long getLong(String dialog)
	{
		System.out.println(dialog);
		Scanner inn = new Scanner(System.in);
		long input = inn.nextLong();
		return input;
	}
}

class Klientt
{
	public static void main(String[] args)
	{

		boolean noExit = true;
		Input input = new Input();
		Oppgaveoversikt oppg = new Oppgaveoversikt();
		
		
		while (noExit)
		{
			//System.out.println(oppg.toString());
			
			switch(input.getInt("\n1- Legg inn student.\n2- Antall oppgaver lost.\n3- Vis antall studenter.\n4- Legg til oppgaver.\n0- avslutt"))
			{
			case 0: noExit = false; break; 
			case 1: oppg.nyStudent(input.getString("Navn: "), input.getInt("Antall oppgaver: ")); break;
			case 2: System.out.println("Oppgaver lost: " + oppg.getAntOppgLost(input.getString("Navn: "))); break;
			case 3: System.out.println("\nAntall studenter: " + oppg.getAntStud()); break; 
			case 4: String in = input.getString("Navnet på studentet: ");
					oppg.okAntOppg(in, input.getInt("\nHvor mange ekstra oppgaver skal godtjenes: ")); 
					System.out.println("Antall oppgaver lost: " + oppg.getAntOppgLost(in)); break;
			
			default: 
				System.out.println("\nJa... velg riktig verdi, plz.");
				return;
			}
		}
		
	}
}
