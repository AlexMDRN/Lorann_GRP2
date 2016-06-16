package model;

public class Entity {
	private boolean isCollidable;
	private int positionX;
	private int positionY;
	private Sprite sprite;
	private static int width = 32;
	private static int height = 32; 

	public boolean getCollidable() {
		return isCollidable;
	}
	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public Sprite getSprite() {
		return sprite;
	}

	public Entity(boolean collidable, int posX, int posY, Sprite asprite) {
		isCollidable = collidable;
		positionX = posX;
		positionY = posY;
		sprite = asprite;
	}
}
