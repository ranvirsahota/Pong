import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int matchesPlayerWon = 0;
	private int matchesCPUWon = 0;
	public void ballUpdate() {
		if (Globals.ballUp) {
			Globals.ballY--;
			if (Globals.ballY == 0) {
				Globals.ballUp = false;
			}
		}
		else {
			Globals.ballY++;
			if (Globals.ballY + 40 == 400) {
				Globals.ballUp = true;
			}
		}
		if (Globals.playerHitBall) {
			Globals.ballX++;
		}
		
		else {
			Globals.ballX--;
		}
		
		if (Globals.ballX == 0) {
			matchesCPUWon++;
			Globals.ballUp = false;
			Globals.playerHitBall = true;
			Globals.ballX = 200;
			Globals.ballY = 10;
		}
		
		else if (Globals.ballX + 10 == 400) {
			matchesPlayerWon++;
			Globals.ballUp = false;
			Globals.playerHitBall = false;
			Globals.ballX = 200;
			Globals.ballY = 10;
		}
	}
	
	public void ballRender(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(Globals.ballX, Globals.ballY, 10, 10);
		g.drawString("Player: " + matchesPlayerWon, 0, 10);
		g.drawString("CPU: " + matchesCPUWon, 50, 10);
	}
}
