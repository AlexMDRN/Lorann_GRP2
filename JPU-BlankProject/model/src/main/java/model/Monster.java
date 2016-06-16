package model; 

public class Monster extends Alive {
	private static Sprite sprite = new Sprite("Monster");
	private static int speed = 10;

	public Monster(boolean collidable, int posX, int posY, Sprite sprite, int speed, boolean alive){
		super(collidable, posX, posY, sprite, speed, alive);
	}
}