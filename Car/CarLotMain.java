import java.util.Scanner;
public class CarLotMain {

	public static void main(String[] args) {
		CarLot lot = new CarLot();
		System.out.println("How many cars do you want in the Car Lot?");
		Scanner howMany = new Scanner(System.in);
		int carAmount = howMany.nextInt();
		//carAmount = lot.size();
	    //System.out.print(carAmount);
	}

}
