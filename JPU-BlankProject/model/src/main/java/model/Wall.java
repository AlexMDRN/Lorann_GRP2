package model; 

public class Wall extends Entity {
	private static Sprite sprite =new Sprite("Wall");
	private static boolean collidable = true;

	public Wall(boolean collidable, int posX, int posY, Sprite sprite){
		super(collidable, posX, posY, sprite);
	}
}