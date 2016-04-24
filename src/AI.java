import java.awt.Color;
import java.awt.Graphics;

public class AI {
	
	public void aiUpdate() {
		if (Globals.aiY + 100 < 400 || Globals.aiY > 0) {
			if (Globals.aiY < Globals.ballY) {
				Globals.aiY++;
			}
		
			else if (Globals.aiY > Globals.ballY) {
				Globals.aiY--;
			}
		}
		
		if (Globals.ballX == 380) {		
			if (Globals.ballY >= Globals.aiY && Globals.ballY <= Globals.aiY + 100) {
				Globals.playerHitBall = false;
			}
		}

	}
	
	public void aiRender(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(380, Globals.aiY, 5, 100);
	}
}
