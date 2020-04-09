
public class Main {

	public static void main(String[] args) {
		Vehicle ford = new Vehicle(2010, "1M8GDM9AXKP042788", 100);
		
	// coordonate initiale
		
		System.out.println("Coordonatele initiale sunt:");
		ford.setPositionX(25);

		ford.setPositionY(35);
System.out.println(ford.getPositionX());
System.out.println(ford.getPositionY());

System.out.println();

// coordonate noi
System.out.println("Coordonatele noi sunt:");
ford.setPositionX(50);

ford.setPositionY(70);
System.out.println(ford.getPositionX());
System.out.println(ford.getPositionY());

System.out.println();

// metoda de mutare a masinii

System.out.println("mutam masina la coordonatele noi:");
	ford.moveCarTo(110, 130);
	
	System.out.println(ford.getKilometers());
	
	System.out.println("Distanta parcursa este:");
	
	System.out.println(ford.moveCarTo(110, 130));
 
	System.out.println(ford.getKilometers());
	
	System.out.println(ford.getPositionX() + " " + ford.getPositionY());
	
	// verific metoda de validare a vin
	
	ford.isVinValid("1M8GDM9AXKP042788");
	System.out.println();
	
	
	// verifacm metoda de print a vin
	
	ford.printVinDecomposed("1M8GDM9AXKP042788");
	System.out.println();
	
	// metoda de afisare a caracteristicilor auto
	
	ford.display();
	}

}
