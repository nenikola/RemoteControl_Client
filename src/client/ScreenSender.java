package client;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;

public class ScreenSender extends Thread {
	
	Socket socket = null;
	Robot robot = null;
	Rectangle rectangle = null;
	
	public ScreenSender(Socket s, Robot rob, Rectangle r) {
		socket = s;
		robot = rob;
		rectangle = r;
		start();
	}
	
	@Override
	public void run() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(rectangle);
			
			while(true) {
				BufferedImage image = robot.createScreenCapture(rectangle);
				ImageIcon imageIcon = new ImageIcon(image);
				
				oos.writeObject(imageIcon);
				oos.reset();
				
				Thread.sleep(100);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
