/*************************************************************************************************************************
 *
 * CMSC 22 2nd Semester SY 2016-1017
 * Multithreading Example (with GUI): Cart
 * 
 * (c) Institute of Computer Science, CAS, UPLB
 * @author Miyah Queliste
 *
 *************************************************************************************************************************/
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**********************************************************************************************
* Stage class which is a JPanel. 
* Contains the Cart objects that will race.
***********************************************************************************************/
public class Stage extends JPanel {
	private Cart myCart, yourCart;
	private Pedestrian ped1, ped2;
	private Thread myCartThread, yourCartThread, ped1Thread, ped2Thread;	

	public Stage(){
		this.setBackground(Color.BLACK);
		this.setLayout(null);

		myCart = new Cart(0, 100, "myCartThread");
		yourCart = new Cart(0, 200, "yourCartThread");
		ped1 = new Pedestrian(300, 0, "ped1Thread");
		ped2 = new Pedestrian(400, 0, "ped2Thread");
		
		myCartThread = new Thread(myCart);
		yourCartThread = new Thread(yourCart);	
		ped1Thread = new Thread(ped1);
		ped2Thread = new Thread(ped2);

		this.add(myCart);
		this.add(yourCart);
		this.add(ped1);
		this.add(ped2);

		myCartThread.start();
		yourCartThread.start();
		ped1Thread.start();
		ped2Thread.start();
	}

	/**********************************************************************************************
	* This code runs in the main thread.
	* Waits for the two threads to finish before displaying the winner.
	***********************************************************************************************/
	public void displayWinner(){
		try{
			myCartThread.join();
			yourCartThread.join();
			ped1Thread.join();
			ped2Thread.join();
		} catch(Exception e){}

		// System.out.println("*****" + Cart.getWinner().getName() + " WON!*****");
	}
}