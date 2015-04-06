
public class Program {

	public static void main(String[] args) {
		
		GasStation model = new GasStation(2);
		GasStationConsoleView console = new GasStationConsoleView();
		console.start();
		model.start();
		GasStationController controller = new GasStationController(console,model);
	}
}
