
public class Vehicle {
	// 1. declaram atributele obiectelor/le instantiem
	private static final String producedBy = "Ford"; // producatorul auto (ex: Ford, Volkswagen etc.)
	private final int productionYear;
	private final String vin; // Vehicle Identification Number - seria sasiului
	private String plateNumber; // numarul de inmatriculare al autovehiculului
	private double kilometers; // numarul de kilometri parcursi (de la fabricatie)
	private int lastSoldOnYear; // anul in care a fost vandut ultima oara autovehiculul
	private double positionX, positionY; // coordonatele GPS ale masinii

	// 2 f. constructorii 3 x

	public Vehicle(int productionYear, String vin) {

		this.productionYear = productionYear;
		this.vin = vin;
	}

	public Vehicle(int productionYear, String vin, int kilometers) {
		this(productionYear, vin);
		this.kilometers = kilometers;
	}

	public Vehicle(int productionYear, String vin, String plateNumber, int kilometers, int lastSoldOnYear) {
		this(productionYear, vin, kilometers);
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

	public static Vehicle initCar(int productionYear, String vin, String plateNumber, int kilometers,
			int lastSoldOnYear) {
		return new Vehicle(productionYear, vin, plateNumber, kilometers, lastSoldOnYear);
	}

	// 2 d,e; metode set si get pt parametrii plateNUmber si kilometers
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getPlateNumber() {
		return this.plateNumber;
	}

	public double getKilometers() {
		return this.kilometers;
	}
	// get si set pentru atributul lastSoldOnYear

	public void setlastSoldOnYear(int lastSoldOnYear) {
		this.lastSoldOnYear = lastSoldOnYear;
	}

	public int getlastSoldOnYear() {
		return this.lastSoldOnYear;
	}

	// 3.a. metoda de actualizare a datelor de vanzare
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

	// metoda de actualizare a pozitiei masinii

	public double moveCarTo(double positionX, double positionY) {
		kilometers += Math
				.sqrt(Math.pow(this.positionX - getPositionX(), 2) + Math.pow(this.positionY - getPositionY(), 2));

		this.positionX = positionX;
		this.positionY = positionY;

		return kilometers;
	}

	// 3.c metoda de validare a vin a unui auto

	public boolean isVinValid(String vin) {
		// boolean isDrivingInNorthAmerica = false;
		int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 2, 3, 4, 5, 0, 7, 0, 9, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] weights = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };

		String s = vin;
		s = s.replaceAll("-", "");
		s = s.replaceAll(" ", "");
		s = s.toUpperCase();
		if (s.length() != 17)
			throw new RuntimeException("VIN number must be 17 characters");

		int sum = 0;
		for (int i = 0; i < 17; i++) {
			char c = s.charAt(i);
			int value;
			int weight = weights[i];

			// letter
			if (c >= 'A' && c <= 'Z') {
				value = values[c - 'A'];
				if (value == 0)
					throw new RuntimeException("Illegal character: " + c);
			}
			// number
			else if (c >= '0' && c <= '9')
				value = c - '0';

			// illegal character
			else
				throw new RuntimeException("Illegal character: " + c);

			sum = sum + weight * value;

		}

		// check digit
		sum = sum % 11;
		char check = s.charAt(8);
		if (sum == 10 && check == 'X') {
			System.out.println("Valid");
			return true;
		} else if (sum == transliterate(check)) {
			System.out.println("Valid");
			return true;
		} else {
			System.out.println("Invalid");
			return false;
		}

	}

	// metoda de translitare a caracterului in numar

	private static int transliterate(char check) {
		if (check == 'A' || check == 'J') {
			return 1;
		} else if (check == 'B' || check == 'K' || check == 'S') {
			return 2;
		} else if (check == 'C' || check == 'L' || check == 'T') {
			return 3;
		} else if (check == 'D' || check == 'M' || check == 'U') {
			return 4;
		} else if (check == 'E' || check == 'N' || check == 'V') {
			return 5;
		} else if (check == 'F' || check == 'W') {
			return 6;
		} else if (check == 'G' || check == 'P' || check == 'X') {
			return 7;
		} else if (check == 'H' || check == 'Y') {
			return 8;
		} else if (check == 'R' || check == 'Z') {
			return 9;
		} else if (Integer.valueOf(Character.getNumericValue(check)) != null) { // hacky but works
			return Character.getNumericValue(check);
		}
		return -1;
	}

	// metoda de descompunere a vin

	public void printVinDecomposed(String vin) {
		if (isVinValid(vin)) {
			System.out.println(
					"Identificatorul producatorului: " + vin.substring(0, 3) + " \n " + " Atributele vehiculului:  "
							+ vin.substring(3, 8) + " \n " + " Cifra de verificare:  " + vin.charAt(8) + " \n "
							+ " Anul productiei modelului:  " + vin.charAt(9) + " \n " + " Seria fabricii:  "
							+ vin.charAt(10) + " \n " + " Identificatorul numeric: " + vin.substring(11));
		}
	}

	public void display() {

		System.out.println("Autovehicolul este produs de: " + producedBy);
		System.out.println("Autovehicolul este produs in anul: " + productionYear);
		System.out.println("Are vin codul:" + vin);
		System.out.println("Numar de inmatriculare: " + plateNumber);
		System.out.println("A parcurs kilometrii: " + kilometers);
		System.out.println("Anul in care a fost vanduta: " + lastSoldOnYear);
		System.out.println("S-a deplasat catre coordonatele: " + positionX + " , " + positionY);

	}

}
