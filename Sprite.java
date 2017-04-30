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
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

/**********************************************************************************************
* Sprite class which is a JPanel. 
* Contains attributes and methods to render an object as a JPanel with image.
***********************************************************************************************/
public class Sprite extends JPanel {
	private Image img;
	private int xPos, yPos, xPosInit, yPosInit;

	final static int TOTAL_DISTANCE = 420;

	/**********************************************************************************************
	* Sprite constructor.
	* Initializes the attributes and loads the image for this sprite.
	***********************************************************************************************/
	public Sprite(int xPos, int yPos, String filename){
		this.setOpaque(false);
		this.setSize(500,500);
		this.xPos = xPos;
		this.yPos = yPos;
		this.xPosInit = xPos;
		this.yPosInit = yPos;
		this.loadImage(filename);
	}

	private void loadImage(String filename){
		try{
			img = Toolkit.getDefaultToolkit().getImage(filename);
		} catch(Exception e){}	
	}

	public Image getImage(){
		return this.img;
	}

	public int getXPos(){
		return this.xPos;
	}

	public int getYPos(){
		return this.yPos;
	}

	public void incXPos(int distance){
		if((this.xPos+=distance)<=TOTAL_DISTANCE) this.xPos+=distance;
		else this.xPos = this.xPosInit;
	}

	public void incYPos(int distance){
		if((this.yPos+=distance)<=TOTAL_DISTANCE) this.yPos+=distance;
		else this.yPos = this.yPosInit;
	}

	/**********************************************************************************************
	* Overrides the paintComponent method of JPanel.
	* Draws the image on its x and y coordinates.
	***********************************************************************************************/
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(this.getImage(),this.getXPos(),this.getYPos(),null);
		Toolkit.getDefaultToolkit().sync();
	}
}