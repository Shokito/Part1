public class Main {

	public static void main(String[] args) {
		GasStation orenGas= new GasStation(2);
		orenGas.start();
			Car car1 = new Car(1,10,false,orenGas);
			Car car2 = new Car(2,10,false,orenGas);
			car1.start();
			car2.start();

		

	}

	public static Car GetCarInput() {
		return null;
	}

}
