import java.util.ArrayList;
public class CarLot {
	private ArrayList<Car> cars;
	CarLot() {
		cars = new ArrayList<Car>();
	}
	public Car find(String carId) {
		for (int i = 0; i < this.size(); i++) {
			if (carId.equals(this.getPosition(i).getCarId())) {
				return this.getPosition(i);
			}
		}
		return null;
		
	}
	public Car getPosition(int position) {
		return cars.get(position);
	}
	public double getCarAverageMPG() {
		double total = 0;
		int i;
		for (i = 0; i < this.size(); i++) {
			total += this.getPosition(i).getMpg();
		}
		return total/i;
	}
	public Car getCarBestMPG() {
		Car max = this.getPosition(0);
			for (int i = 0; i<this.size(); i++) {
				if (this.getPosition(i).compareMPG(max) > 0) {
					max = this.getPosition(i);
				}
			}
		return max;
	}
	public int size() {
		return cars.size();
	}
	public String toStringTwo() {
		String list = "";
		for (int i = 0; i < this.size(); i++) {
		list = list + "\n" + this.getPosition(i).toString();
		}
		return list;
	}
	public boolean addNewCar(Car carToAdd) {
		cars.add(carToAdd);
		return true;
	}
	public Car getCarHighestMilage() {
		Car max = this.getPosition(0);
		for (int i = 0; i < this.size(); i++) {
			if (this.getPosition(i).compareMiles(max) > 0) {
				max = this.getPosition(i);
			}
		}
		return max;
	}
	public int getTotalMilesTwo() {
		int total = 0;
		for (int i = 0; i < this.size(); i++) {
			 total = total + this.getPosition(i).getTotalMiles();
		}
		return total;
	}
	public ArrayList<Car> getSortedByMPG() {
		ArrayList<Car> newCars = new ArrayList<Car>();
		newCars.addAll(cars);
	    for (int i = 0; i < newCars.size() - 1; i++) {
	      Car current = newCars.get(i);
	      int currentMinIndex = i;
	      
	      for (int j = i + 1; j < newCars.size(); j++) {
	        if (current.getMpg() > newCars.get(j).getMpg()) {
	          current = newCars.get(j);
	          currentMinIndex = j;
	        }
	      }
	      if (currentMinIndex != i) {
	    	  newCars.set(currentMinIndex, newCars.get(i));
	    	  newCars.set(i, current);
	    	  }
	      }
		return newCars;
	}
	public String sortedArray() {
		String sorted = "";
		for (int i = 0; i < this.size(); i++) {
			sorted = sorted + "\n" + this.getSortedByMPG().get(i).toString();
		}
		return sorted;
	}
}
