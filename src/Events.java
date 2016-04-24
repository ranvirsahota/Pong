import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Events implements MouseMotionListener, MouseListener{

	@Override
	public void mouseDragged(MouseEvent mouse) {
		
	}

	@Override
	public void mouseMoved(MouseEvent mouse) {
		Globals.mouseY = mouse.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (Globals.btnPlayClicked == false) {
			if (e.getX() > 150 && e.getX() < 250) {
				if (e.getY() > 150 && e.getY() < 200) {
					Globals.btnPlayClicked = true;
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
