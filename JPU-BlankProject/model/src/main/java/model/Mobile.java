package model;
public class Mobile extends Entity {
	private int speed;
	private static boolean collidable = true;

	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	public void moveUp(int y) {
		y = (y-speed);
	}
	public void moveDown(int y) {
		y = (y+speed);
	}
	public void moveLeft(int x) {
		x = (x-speed);
	}
	public void moveRight(int x) {
		x = (x+speed);
	}

	public Mobile(boolean collidable, int posX, int posY, Sprite aSprite, int aSpeed) {
		super(collidable, posX, posY, aSprite);
		speed = aSpeed;
	}
}