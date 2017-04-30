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
	private Thread myCartThread, yourCartThread;	

	public Stage(){
		this.setBackground(Color.BLACK);
		this.setLayout(null);

		myCart = new Cart(0, 100, "myCartThread");
		yourCart = new Cart(0, 200, "yourCartThread");
		
		myCartThread = new Thread(myCart);
		yourCartThread = new Thread(yourCart);	

		this.add(myCart);
		this.add(yourCart);

		myCartThread.start();
		yourCartThread.start();
	}

	/**********************************************************************************************
	* This code runs in the main thread.
	* Waits for the two threads to finish before displaying the winner.
	***********************************************************************************************/
	public void displayWinner(){
		try{
			myCartThread.join();
			yourCartThread.join();
		} catch(Exception e){}

		System.out.println("*****" + Cart.getWinner().getName() + " WON!*****");
	}
}