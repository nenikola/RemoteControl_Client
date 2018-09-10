package client;


import java.awt.Rectangle;
import java.awt.Robot;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import client.gui.GUIControler;

public class CommandsReceiver extends Thread 
{
	ClientMain cMain = null;
	Robot robot = null;
	public CommandsReceiver(ClientMain cm, Robot r) {
		cMain=cm;
		robot = r;
		start();
	}
	
	
	@Override
	public void run() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(cMain.socket.getInputStream());

            while(true){

                int command = scanner.nextInt();

                switch(command){
                    case -1:
                        robot.mousePress(scanner.nextInt());
                    break;
                    case -2:
                        robot.mouseRelease(scanner.nextInt());
                    break;
                    case -3:
                        robot.keyPress(scanner.nextInt());
                    break;
                    case -4:
                        robot.keyRelease(scanner.nextInt());
                    break;
                    case -5:
                        robot.mouseMove(scanner.nextInt(), scanner.nextInt());
                    break;
                    case 0:
                    	cMain.programTerminatedConnectionClosing();
                    	GUIControler.serverDisconnected();
                    break;
                    	
                }
            }
		} catch (IOException e) {
			cMain.programTerminatedConnectionClosing();
			GUIControler.serverDisconnected();
			
		}

	}
}
