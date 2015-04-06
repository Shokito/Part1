
import java.util.LinkedList;

import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GasStation extends Thread {

	private Lock noFreePumpLock = new ReentrantLock();
	private Condition noFreePump = noFreePumpLock.newCondition();

	private MainFuelPool mainFuelPool = new MainFuelPool();
	private CleaningService cleaningService = new CleaningService();
	//private Queue<Car> fuelWaitingList;
	private Queue<FuelPump> freePumps;
	private Vector<GasStationModelListener> listeners;
	
	public GasStation(int numOfPumps) {
		//fuelWaitingList = new LinkedList<Car>();
		freePumps = new LinkedList<FuelPump>();
		listeners = new Vector<GasStationModelListener>();
		for (int i=0;i<numOfPumps;i++)
			freePumps.add(new FuelPump());
	}

	public void registerListener(GasStationModelListener gasStationListener) {
		listeners.add(gasStationListener);
	}

	@Override
	public void run() {
		//needed???????
	}

	public FuelPump getFreePump() throws Exception{
		// TODO Auto-generated method stub
		noFreePumpLock.lock();
		FuelPump pump=freePumps.poll();
		while(pump==null){
			System.out.println("waiting for fuel pump");
			noFreePump.await();
			System.out.println("waking up for fuel pump");
			pump = freePumps.poll();
		}
		noFreePumpLock.unlock();
		return pump;
	}

	public void releasePump(FuelPump fuelPump) {
		// TODO Auto-generated method stub
		noFreePumpLock.lock();
		freePumps.add(fuelPump);
		noFreePump.signal();
		noFreePumpLock.unlock();
		
	}
	
	
	public MainFuelPool getMainFuelPool() {
		return mainFuelPool;
	}

	public void setMainFuelPool(MainFuelPool mainFuelPool) {
		this.mainFuelPool = mainFuelPool;
	}

	public CleaningService getCleaningService() {
		return cleaningService;
	}

	public void setCleaningService(CleaningService cleaningService) {
		this.cleaningService = cleaningService;
	}

	public synchronized void addCarTModel(int licensePlate, int numOfLiters,
			boolean wantWash) {
		// TODO Auto-generated method stub
		Car car = new Car(licensePlate, numOfLiters, wantWash, this);
		//fuelWaitingList.add(car);
		car.start();
		System.out.println("in model");
		this.notify();
	}

//	public synchronized void notifyCar() {
//		Car firstCar = fuelWaitingList.poll();
//		System.out.println("car wants" + firstCar.getNumOfLiters());
//		if (firstCar != null) {
//			System.out.println("Gas Station is notifying car #"
//					+ firstCar.getId());
//			synchronized (firstCar) {
//				firstCar.notifyAll();
//			}
//		}
//
//	}

	
}
