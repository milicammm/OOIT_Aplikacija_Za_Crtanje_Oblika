package introduction;

public class Variables {

	public static void main(String[]args)
	{
		//DEKLARACIJA PROMENLJIVE
		
		double firstNumber;
		
		//INICIJALIZACIJA PROMENLJIVE
		
		firstNumber=1;
		double secondNumber=5;
		
		double doubleResult=(firstNumber/secondNumber);
		System.out.println(doubleResult); //0.2
		
		int result=(int)(firstNumber/secondNumber); 
		System.out.println(result); //0
		
		boolean alwaysTrue=true;
		boolean alwaysFalse=false;
		
		//LOGICKI OPERATORI
		
		//KONJUKCIJA AND
		
		System.out.println(alwaysTrue &&alwaysFalse); //false
		
		//DISJUNKCIJA OR
		
		System.out.println(alwaysTrue||alwaysFalse); //true
		
		//NEGACIJA NOT
		
		System.out.println(!alwaysTrue); //false
		
		//KONKATENACIJA-SPAJANJE STRINGOVA
		
		String name="Petar";
		String lastName= "Petrovic";
	    System.out.println(name+" " +lastName + " "+ "Njegos");
	    
	    //FAKTORIJEL BROJA 5	
	    
	    int number=5;
	    int factoriel =1;
	    
	    while(number>=1)
	    {
	    	factoriel=factoriel*number;
	    	number--;
	    }
		System.out.println("Faktorijel broja 5 je : " + factoriel);
		
		//ISPISATI UZ POMOC FOR PETLJE NEPARNE BROJEVE OD 1 DO 10
		
		for(int i=0;i<10;i++)
		{
			if(i%2==1)
			System.out.println(i);
		}
		
	}
}
