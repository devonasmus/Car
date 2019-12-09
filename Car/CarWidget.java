import javax.swing.*;
import java.awt.event.*;
public class CarWidget implements ActionListener{
	JFrame f;
	JLabel id, milage, mpg, cost, price, sold, bestMpg, highestMilage, fleetAverage, profit;
	JTextField idText, milageText, mpgText, costText, priceText, soldText;
	JButton sale, make;
	JTextArea listOfCars, sortByMpg;
	CarLot lot = new CarLot();
	int totalProfit = 0;
	CarWidget() {
		f = new JFrame();
		id = new JLabel("New Car ID");
		milage = new JLabel("New Car Milage");
		mpg = new JLabel("New Car MPG");
		cost = new JLabel("Cost To Acquire");
		price = new JLabel("Price To Sell");
		sold = new JLabel("Sold Car ID");
		bestMpg = new JLabel("Best MPG");
		highestMilage = new JLabel("Highest Milage");
		fleetAverage = new JLabel("Fleet Average MPG");
		profit = new JLabel("Profit:");
		listOfCars = new JTextArea("CarLot as entered");
		sortByMpg = new JTextArea("CarLot by MPG");
		idText = new JTextField();
		milageText = new JTextField();
		mpgText = new JTextField();
		costText = new JTextField();
		priceText = new JTextField();
		soldText = new JTextField();
		sale = new JButton("Press here to record a sale.");
		make = new JButton("Make a new Car");
		f.setSize(900, 700);
		id.setBounds(50, 50, 175, 25); idText.setBounds(145, 50, 100, 25);
		milage.setBounds(250, 50, 175, 25); milageText.setBounds(345, 50, 100, 25);
		mpg.setBounds(450, 50, 175, 25); mpgText.setBounds(545, 50, 100, 25);
		cost.setBounds(50, 75, 175, 25); costText.setBounds(145, 75, 100, 25);
		price.setBounds(250, 75, 175, 25); priceText.setBounds(345, 75, 100, 25);
		sold.setBounds(650, 50, 175, 25); soldText.setBounds(745, 50, 100, 25);
		sale.setBounds(650, 75, 200, 25); make.setBounds(50, 100, 200, 25);
		bestMpg.setBounds(50, 125, 175, 25); highestMilage.setBounds(250, 125, 175, 25);
		fleetAverage.setBounds(450, 125, 175, 25); profit.setBounds(650, 125, 175, 25);
		listOfCars.setBounds(50, 150, 800, 200); sortByMpg.setBounds(50, 400, 800, 200);
		f.add(id); f.add(idText);
		f.add(milage); f.add(milageText);
		f.add(mpg); f.add(mpgText);
		f.add(cost); f.add(costText);
		f.add(price); f.add(priceText);
		f.add(sold); f.add(soldText);
		f.add(sale); f.add(make);
		f.add(bestMpg); f.add(highestMilage);
		f.add(fleetAverage); f.add(profit);
		f.add(listOfCars); f.add(sortByMpg);
		f.setLayout(null);
		f.setVisible(true);
		sale.addActionListener(this);
		make.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == make) {
		try {
			String idOfCar = idText.getText();
			int milageOfCar = Integer.parseInt(milageText.getText());
			double mpgOfCar = Double.parseDouble(mpgText.getText());
			int costOfCar = Integer.parseInt(costText.getText());
			int priceOfCar = Integer.parseInt(priceText.getText());
			Car newCar = new Car(idOfCar, milageOfCar, mpgOfCar, costOfCar, priceOfCar);
			lot.addNewCar(newCar);
			listOfCars.setText("CarLot as entered" + lot.toStringTwo());
			sortByMpg.setText("CarLot by MPG" + lot.sortedArray());
			bestMpg.setText("Best MPG " + lot.getCarBestMPG().getCarId());
			highestMilage.setText("Highest Milage " + lot.getCarHighestMilage().getCarId());
			fleetAverage.setText("Fleet Average MPG " + lot.getCarAverageMPG());
		}
		catch (Exception e1) {
			
		}
		}
		else if (e.getSource() == sale) {
			try {
				String soldCarId = soldText.getText();
				Car soldCar = lot.find(soldCarId);
				soldCar.setSold(true);
				totalProfit = totalProfit + soldCar.getProfit();
				listOfCars.setText("CarLot as entered" + lot.toStringTwo());
				sortByMpg.setText("CarLot by MPG" + lot.sortedArray());
				profit.setText("Profit: " + Integer.toString(totalProfit));
				}
			catch (Exception e2) {
				
			}
		}
	}
	public static void main(String[] args) {
		new CarWidget();
	}

}
