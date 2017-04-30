/*************************************************************************************************************************
 *
 * CMSC 22 2nd Semester SY 2016-1017
 * Multithreading Example (with GUI): Cart
 * 
 * (c) Institute of Computer Science, CAS, UPLB
 * @author Miyah Queliste
 *
 *************************************************************************************************************************/
import java.util.Random;

/**********************************************************************************************
* Cart class which extends the Sprite class. 
* An object from the Cart class is a Runnable object used to create a thread.
***********************************************************************************************/
public class Cart extends Sprite implements Runnable {
	private String name;
	private int distance;
	private static Cart winner;

	private final static int TOTAL_DISTANCE = 420;

	/**********************************************************************************************
	* Cart constructor.
	* Calls the constructor of the Sprite class and then initializes the remaining attributes.
	***********************************************************************************************/
	public Cart(int x, int y, String name, String icon){
		super(x, y, icon);
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public static Cart getWinner(){
		return Cart.winner;
	}

	/**********************************************************************************************
	* A random value is genereated for the cart to move. 
	* If a cart reaches the TOTAL_DISTANCE, it is set to be the winner.
	***********************************************************************************************/
	private void move(){
		Random r = new Random();
		int step = r.nextInt(5)+5;

		this.distance += step;
		this.incXPos(step);
		System.out.println(this.name + " run " + distance + " meters.");

		if(this.distance>=Cart.TOTAL_DISTANCE) 
			Cart.winner = this; 
	}

	private boolean isRaceDone(){
		if(Cart.winner!=null) return true;
		else return false;
	}

	/**********************************************************************************************
	* Overrides the run method of the Runnable interface
	* When the thread is started, it continuously checks if there is already a winner.
	* While there is no winner yet, it moves and repaints the cart and sleeps for 30 milliseconds.
	***********************************************************************************************/
	@Override
	public void run(){
		while(true){
			this.move();
			this.repaint();
			try {
				Thread.sleep(30);
			} catch (Exception e){}
		}		
	}
}
