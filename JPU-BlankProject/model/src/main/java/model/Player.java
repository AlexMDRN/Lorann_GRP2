package model; 

public class Player extends Alive {
	private static Sprite sprite "Player";
	private static int speed = 10;

	public Player(boolean collidable, int posX, int posY, Sprite sprite, int speed, boolean alive){
		super(collidable, posX, posY, sprite, speed, alive);
	}
}