package client;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.net.Socket;

public class ClientMain {
	
	Socket socket = null;	
	
	
	public void connection(String ip, int port) {
	
		Robot robot = null;
		Rectangle rectangle = null;
		
		try {

			socket = new Socket(ip,port);
						
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gd = ge.getDefaultScreenDevice();
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension dim = toolkit.getScreenSize();
			rectangle = new Rectangle(dim);
			robot = new Robot(gd);
			new ScreenSender(socket,robot,rectangle);
			new CommandsReceiver(socket, robot);
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
