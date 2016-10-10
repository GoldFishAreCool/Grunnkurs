import java.util.Scanner;

class Personalia  
{
  String name;
  String surname;
  int birthyear;
  
  public Personalia(String name, String surname, int birthyear) 
  {
    this.name = name;
    this.surname = surname;
    this.birthyear = birthyear;
  }
  
  public String getName() 
  {
    return name;
  }
  
  public String getSurname() 
  {
    return surname;
  }
  
  public int getBirthyear() 
  {
    return birthyear;
  }
}

class ArbTaker 
{
	  java.util.GregorianCalendar calendar = new java.util.GregorianCalendar();
	  int year = calendar.get(java.util.Calendar.YEAR);
	  Personalia personalia;
	  long employeeNumb;
	  int employmentYear;
	  int monthPay;
	  double tax;
	  
	  public ArbTaker(Personalia personalia, long employeeNumb, int employmentYear, int monthPay, double tax) 
	  {
	    this.personalia = personalia;
	    this.employeeNumb = employeeNumb;
	    this.monthPay = monthPay;
	    this.employmentYear = employmentYear;
	    this.tax = tax;
	  }
	  
	  public Personalia getPersonalia() 
	  {
	    return personalia;
	  }
	  
	  public long getEmployeeNumb() 
	  {
	    return employeeNumb;
	  }
	  
	  public int getEmploymentYear() 
	  {
	    return employmentYear;
	  }
	  
	  public int getMonthPay() 
	  {
	    return monthPay;
	  }
	  
	  public double getTax() 
	  {
	    return tax;
	  }
	  
	  public void setMonthPay(int newMonthPay) 
	  {
	    monthPay = newMonthPay;
	  }
	  
	  public void setTax(double newTax) 
	  {
	    tax = newTax;
	  }
	  
	  public int taxPerMonth() 
	  {
		java.util.GregorianCalendar calendar = new java.util.GregorianCalendar();
		int month = calendar.get(java.util.Calendar.MONTH);
		if (month == 6)
		{
			return 0; 
		}
		else if (month == 12)
		{
			return (int) ((double) getMonthPay() * getTax() / 200);
		}
		else 
		{ 
			return (int) ((double) monthPay * tax / 100);
		}
	  }
	  
	  public int payPerYear() 
	  { 
	    return monthPay * 12;
	  }
	  
	  public int taxPerYear() 
	  {
	    return (int) ((double) taxPerMonth() * 10.5);
	  }
	  
	  public String nombre() 
	  {
	    return personalia.getSurname() + ", " + personalia.getName();
	  }
	  
	  public int age() 
	  {
	    return year - personalia.getBirthyear();
	  }
	  
	  public int yearEmployement() 
	  {
	    return year - employmentYear;
	  }
	  
	  public boolean employedLongerThan(int numbYears) 
	  {
	    return (yearEmployement() > numbYears) ? true : false;
	  }
	  
	  public String toString()
	  {
		  return "\nNavn: " + personalia.getName() + " " + personalia.getSurname() + "\nFødselsår: " + personalia.getBirthyear() + "\nAlder: " + age() + " år\nÅr ansatt: " + yearEmployement() + "år\nArbeidstaker nummer: " + getEmployeeNumb() + "\nSkatteprosent: " + getTax() + "%\nBrutto månedslønn: " + getMonthPay() + "NOK\nMånedlig skattetrekk: " + taxPerMonth() + "\nÅrlig bruttolønn: " + payPerYear() + " NOK\nÅrlig skattetrekk: " + taxPerYear();
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

public class Client
{
	public static void main(String[] args)
	{
		java.util.GregorianCalendar calendar = new java.util.GregorianCalendar();
		int year = calendar.get(java.util.Calendar.YEAR);
		Personalia personalia = new Personalia ("Potato", "SweetPotato", 1900);
		ArbTaker arbtkr = new ArbTaker(personalia, 11545487, 2000, 24000, 25);
		Input input = new Input();
		
		boolean noExit = true;
		
		
		
		while (noExit)
		{
			System.out.println(arbtkr.toString());
			
			switch(input.getInt("\n1- Legg inn ny person.\n2- Sett ny månedslønn.\n3- Sett ny skatteprosent.\n0- avslutt"))
			{
			case 0: noExit = false; break; 
			case 1: personalia = new Personalia(input.getString("\nFornavn: "), input.getString("\nEtternavn: "), input.getInt("\nFødselsår: ")); 
					arbtkr = new ArbTaker(personalia, input.getLong("\nAnsatt nummer: "), input.getInt("\nAnsattelsesår: "), input.getInt("\nMånedslønn: "), input.getDouble("\nSkatteprosent: ")); break;
			case 2: arbtkr.setMonthPay(input.getInt("\nNy månedslønn: ")); break;
			case 3: arbtkr.setTax(input.getDouble("\nNy skatteprosent: ")); break;
			
			default: 
				System.out.println("\nJa... velg riktig verdi, plz.");
				return;
			}
		}
		
	}
}
