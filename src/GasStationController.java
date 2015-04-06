public class GasStationController implements GasStationUIEventListener,
		GasStationModelListener {

	private AbstractGasStationView absGasStation;
	private GasStation gasStationModel;

	public GasStationController(AbstractGasStationView view, GasStation model) {
		absGasStation = view;
		gasStationModel = model;
		
		gasStationModel.registerListener(this);
		absGasStation.registerListener(this);
	}

	@Override
	public void addCarFromUI(int licensePlate, int numOfLiters, boolean wantWash) {
		System.out.println("check controller");
		gasStationModel.addCarTModel(licensePlate, numOfLiters, wantWash);

	}

	@Override
	public void fillMainFuelPoolFromUI() {
		// TODO

	}

	@Override
	public void showStatsFromUI() {
		// TODO

	}

	@Override
	public void endWorkDayFromUI() {
		// TODO

	}

}
