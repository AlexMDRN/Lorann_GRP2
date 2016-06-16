package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Timer;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */



public class View implements IView, Runnable {
	
	boolean running = true;

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}
	
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	
	private BufferedImage testImage;
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_Z:
				return ControllerOrder.Up;
			case KeyEvent.VK_S:
				return ControllerOrder.Down;
			case KeyEvent.VK_D:
				return ControllerOrder.Right;
			case KeyEvent.VK_Q:
				return ControllerOrder.Left;
			case KeyEvent.VK_UP:
				return ControllerOrder.Up;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.Down;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.Right;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.Left;
			 default:
				return null;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	
	
		private void init(){
			System.out.println("Init");
			testImage = ImageLoader.LoadImage("model/res/textures/bone.png");}
		
		private void tick(){
			System.out.println("Tick");
		}
		
		private void render(){
			System.out.println("Render");
			bs = ViewFrame.getCanvas().getBufferStrategy();
			if(bs == null){
				ViewFrame.getCanvas().createBufferStrategy(3);
				return;
			}
			g = bs.getDrawGraphics();
			
			g.clearRect(0, 0, ViewFrame.width, ViewFrame.height);
			
			
			//Draw
			g.setColor(Color.BLACK);
			g.fillRect(0,0, ViewFrame.width, ViewFrame.height);
			//g.drawRect(10, 50, 50, 70);
			
			//End
			
			bs.show();
			g.dispose();
		}
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		init();
		this.viewFrame.setVisible(true);
		System.out.println("Poulet");
		
		while(running){
			tick();
			render();
			System.out.println("Poulet2");
		}
		stop();
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
