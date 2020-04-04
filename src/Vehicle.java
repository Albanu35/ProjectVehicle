
public class Vehicle {
	// 1. declaram atributele obiectelor/le instantiem
	private static final String producedBy = "Ford"; // producatorul auto (ex: Ford, Volkswagen etc.)
	private final int productionYear;
	private final String vin; // Vehicle Identification Number - seria sasiului
	private String plateNumber;  //numarul de inmatriculare al autovehiculului
	private int kilometers; // numarul de kilometri parcursi (de la fabricatie)
	private int lastSoldOnYear; // anul in care a fost vandut ultima oara autovehiculul
	private double positionX, positionY; // coordonatele GPS ale masinii

	// 2 f. constructorii 3 x
	
	public Vehicle( int productionYear, String vin) {
		
		this.productionYear = productionYear;
		this.vin = vin;
	}
public Vehicle( int productionYear, String vin, int kilometers) {
		this(productionYear, vin);
		this.kilometers= kilometers;
	}
	public Vehicle ( int productionYear, String vin, String plateNumber, int kilometers,int lastSoldOnYear ) {
		this( productionYear, vin, kilometers);
		this.plateNumber = plateNumber;
		this.lastSoldOnYear = lastSoldOnYear;
	}
	
	// metode de initializare
	
	public static Vehicle initCar(int productionYear, String vin) {
		return new Vehicle(productionYear, vin);
	}
	
	public static Vehicle initCar(int productionYear, String vin, int kilometers) {
		return new Vehicle(productionYear, vin, kilometers);
	}
	
	public static Vehicle initCar(int productionYear, String vin, String plateNumber, int kilometers,int lastSoldOnYear) {
		return new Vehicle(productionYear, vin, plateNumber, kilometers, lastSoldOnYear);
	}
	//2 d,e; metode set si get pt parametrii plateNUmber si kilometers
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getPlateNumber(String plateNumber) {
		return plateNumber;
	}
	public int getKilometers(int kilometers) {
		return kilometers;
	}
	// get si set pentru atributul lastSoldOnYear
	
	public void setlastSoldOnYear(int lastSoldOnYear) {
		this.lastSoldOnYear = lastSoldOnYear;
	}
	public int getlastSoldOnYear(int lastSoldOnYear) {
		return lastSoldOnYear;
	}
	
	//3.a. metoda de actualizare a datelor de vanzare
	public void sellVehicle(String plateNumber, int lastSoldOnYear) {
		this.plateNumber = plateNumber;
		this.lastSoldOnYear = lastSoldOnYear;
	}
	
	// getter si setter pt coordonatele X si Y

		public void setPositionX(double positionX) {
			this.positionX = positionX;
		}

		public double getPositionX() {
			return positionX;
		}

		public void setPositionY(double positionY) {
			this.positionY = positionY;
		}

		public double getPositionY() {
			return positionY;
		}
		
		// metoda de calcul a distantei parcurse de catre masina
		
		public double getDistance(Vehicle newPosition) {
			double distance = Math.sqrt(Math.pow(this.getPositionX() - newPosition.getPositionX(), 2)
					+ Math.pow(this.getPositionY() - newPosition.getPositionY(), 2));

			return distance;

		}
		public void setDistance(double distance) {
			//this.distance = distance;
		}
		
		// metoda de actualizare a pozitiei masinii
		
		public void moveCarTo(double positionX, double positionY, Vehicle newPosition) {
			double distance = Math.sqrt(Math.pow(this.getPositionX() - newPosition.getPositionX(), 2)
					+ Math.pow(this.getPositionY() - newPosition.getPositionY(), 2));

			setPositionX(positionX);
			setPositionY(positionY);
		}


}
