
public class Car {
	private String carId;
	private int totalMiles;
	private double mpg;
	private int costToAcquire;
	private int priceToSell;
	private boolean sold;
	public Car()
	{
		totalMiles = 0;
	}
	
	public Car(String carId) {
		setCarId(carId);
	}
	public Car(String carId, int totalMiles, double mpg, int costToAcquire, int priceToSell) {
		setCarId(carId);
		setTotalMiles(totalMiles);
		setMpg(mpg);
		setCostToAcquire(costToAcquire);
		setPriceToSell(priceToSell);
		//These make assignments to the variables on top
	}
	public void setCarId(String newCarId) {
		carId = newCarId;
	}
	public void setTotalMiles(int newTotalMiles) {
		if(newTotalMiles>0) {
			totalMiles = newTotalMiles;
		}
		else {
			totalMiles = 0;
		}
	}
	public void setMpg(double newMpg) {
		mpg = newMpg;
	}
	public void setCostToAcquire(int newCostToAcquire) {
		costToAcquire = newCostToAcquire;
	}
	public void setPriceToSell(int newPriceToSell) {
		priceToSell = newPriceToSell;
	}
	public void setSold(boolean newSold) {
		sold = newSold;
	}
	public void addMiles(int milesToAdd)
	{
		setTotalMiles(this.totalMiles + milesToAdd);
	}
	public String getCarId() {
		return carId;
	}
	public int getTotalMiles() {
		return totalMiles;
	}
	
	public double getMpg() {
		return mpg;
	}
	
	public int getCostToAcquire() {
		return costToAcquire;
	}
	
	public int getPriceToSell() {
		return priceToSell;
	}
	
	public boolean isSold() {
		return sold;
	}
	public int getProfit() {
		return priceToSell - costToAcquire;
	}
	public int compareMPG(Car otherCar) {
		return (int)this.getMpg() - (int)otherCar.getMpg();
	}
	public int compareMiles(Car otherCar) {
		return this.getTotalMiles() - otherCar.getTotalMiles();
	}
	public int comparePrice(Car otherCar) {
		return this.getPriceToSell() - otherCar.getPriceToSell();
	}
	public String toString() {
		boolean s = this.isSold();
		String display = "";
		String profit = "";
		if (s) {
			display = "Is Sold";
			profit = ", Profit: " + this.getProfit();
		}
		else {
			display = "Is Not Sold";
		}
		return ("Car ID: " + this.getCarId() + ", Milage: " + this.getTotalMiles() + ", MPG: " + this.getMpg() + ", Cost: " + this.getCostToAcquire() + ", Price: " + this.getPriceToSell() + ", " + display + profit);
	}
}
