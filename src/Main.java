import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable {
	private Thread thread;
	private boolean running = false;
	private Events events;
	private Graphics g;
	private Player player;
	private Ball ball;
	private AI ai;
	
	public void run() {
		long lastTime = System.nanoTime();
		final double frameRate = 100000000.0 / 30.0;
		long now = 0;
		double delta = 0;
		boolean shouldRender = false;
		while (running == true) {
			now = System.nanoTime();
			delta = delta + (now - lastTime) / frameRate;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
				shouldRender = true;
			}
			
			if (shouldRender) {
				render();
			}
		}
	}
	
	public void update() {
		player.playerUpdate();
		ai.aiUpdate();
		ball.ballUpdate();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if (Globals.btnPlayClicked == false) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(150, 150, 100, 50);
			g.setColor(Color.WHITE);
			g.drawString("Play", 190, 180);
		}
		else {
			if (Globals.btnPlayClicked == true) {
				player.playerRender(g);
				ai.aiRender(g);
				ball.ballRender(g);
			}
		}
		bs.show();
		g.dispose();
	}
	
	private void start() {
		requestFocus();
		if (running == false) {
			running = true;
			thread = new Thread(this);
			try {
				thread.start();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	private void stop() {
		if (running == true) {
			running = false;
			try {
				thread.join();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	public Main() {
		events = new Events();
		player = new Player();
		ai = new AI();
		ball = new Ball();
		addMouseMotionListener(events);
		addMouseListener(events);
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		JFrame frame = new JFrame("Pong");
		frame.setSize(400, 400);
		frame.add(main);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		main.start();
	}
}
