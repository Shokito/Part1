

public class Car extends Thread {

	private int id;
	private float numOfLiters;
	private boolean wantCleaning;
	private GasStation gasStation;

	public Car(int id, float numOfLiters, boolean wantCleaning,
			GasStation gasStation) {

		this.id = id;
		this.numOfLiters = numOfLiters;
		this.wantCleaning = wantCleaning;
		this.gasStation = gasStation;

	}

	@Override
	public void run() {
		try {
			synchronized (this) {

				selectQueue();// not used
				doFueling();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doFueling() throws Exception {
		FuelPump fuelPump = null;
		int i=3000+(int)Math.random()*2000;
		fuelPump = gasStation.getFreePump();
		sleep(i);
		System.out.println("finished fueling");

		gasStation.releasePump(fuelPump);

	}

	public float getNumOfLiters() {
		return numOfLiters;
	}

	private void selectQueue() {
		// TODO Auto-generated method stub

	}

}
