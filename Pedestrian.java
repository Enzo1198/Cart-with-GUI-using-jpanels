import java.util.Random;

public class Pedestrian extends Sprite implements Runnable{
	private String name;
	private int distance;
	boolean hitByCar;

	private final static int TOTAL_DISTANCE = 420;
	private final static String ICON = "pedestrian.png";

	public Pedestrian(int x, int y, String name){
		super(x, y, Pedestrian.ICON);
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public boolean isHitByCar(){
		return this.hitByCar;
	}

	private void move(){
		Random r = new Random();
		int step = r.nextInt(16);

		this.distance += step;
		this.incYPos(step);
		System.out.println(this.name + " walked " + this.distance + " meters.");
	}

	public void run(){
		while(true){
			this.move();
			this.repaint();
			try{
				Thread.sleep(30);
			}catch (Exception e){}
		}
	}
}