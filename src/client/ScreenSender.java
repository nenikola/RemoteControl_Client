package client;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;

import client.gui.GUIControler;

public class ScreenSender extends Thread {
	
	ClientMain cMain = null;
	Robot robot = null;
	Rectangle rectangle = null;
	
	public ScreenSender(ClientMain cm, Robot rob, Rectangle r) {
		cMain=cm;
		robot = rob;
		rectangle = r;
		start();
	}
	
	@Override
	public void run() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(cMain.socket.getOutputStream());
			oos.writeObject(rectangle);
			
			while(true) {
				BufferedImage image = robot.createScreenCapture(rectangle);
				ImageIcon imageIcon = new ImageIcon(image);
				
				oos.writeObject(imageIcon);
				oos.reset();
				
				Thread.sleep(100);
			}
			
		} catch (Exception e) {
			cMain.programTerminatedConnectionClosing();
			GUIControler.serverDisconnected();
		}
		
	}

}
