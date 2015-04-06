
public interface GasStationUIEventListener {

	public void addCarFromUI(int licensePlate,int numOfLiters, boolean wantWash);
	public void fillMainFuelPoolFromUI();
	public void showStatsFromUI();
	public void endWorkDayFromUI();
}
