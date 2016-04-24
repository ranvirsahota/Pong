import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	public void playerUpdate() {
		if (Globals.playerY < 400 || Globals.playerY > 0) {
			if (Globals.playerY < Globals.mouseY) {
				Globals.playerY++;
			}
		
			else if (Globals.playerY > Globals.mouseY) {
				Globals.playerY--;
			}
		}
		
		if (Globals.ballX == 5) {
			//System.out.println("Ball" + ballX);
			if (Globals.ballY > Globals.playerY-50 && Globals.ballY < Globals.playerY-50 + 100) {
				Globals.playerHitBall = true;
				//System.out.println("Player: " + playerY);
			}
		}
	}
	
	public void playerRender(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, Globals.playerY-50, 5, 100);
	}
}
