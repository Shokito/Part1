import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class GasStationConsoleView extends Thread implements AbstractGasStationView{
	Scanner reader = new Scanner(System.in);
	private List<GasStationUIEventListener> listeners;
	
	public GasStationConsoleView(){
		listeners=new LinkedList<GasStationUIEventListener>();
		
	}
		public void run(){
		boolean run = true;
		
		while(run){
			System.out.println("welcome");
			System.out.println("1) Add car");
			System.out.println("2) Fill main Gas reserve");
			System.out.println("3) show Statistics");
			System.out.println("4) end work day");
			System.out.println(" please enter your choice:");
			int choice=reader.nextInt();
			
			switch(choice){
			
			case 1:
				addCar();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			}
		}
	}
	
	
	@Override
	public void addCar() {
		// TODO 
		
		
		
		for (GasStationUIEventListener listener : listeners )
			listener.addCarFromUI(222,60,false);
		System.out.println("Car was added");
	}

	@Override
	public void fillMainFuelPool() {
		// TODO 
		
	}

	@Override
	public void showStats() {
		// TODO 
		
	}

	@Override
	public void endWorkDay() {
		// TODO 
		
	}


	@Override
	public void registerListener(GasStationUIEventListener listener) {
		// TODO Auto-generated method stub
		listeners.add(listener);
		
	}
	
	
}
