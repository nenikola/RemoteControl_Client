package client.gui;

import javax.swing.JOptionPane;

import client.*;


public class GUIControler {
	private static ClientStartingWindow csw;
	private static ClientWorkingWindow cww;
	private static ClientMain cm;

	public static void main(String[] args){
		csw=new ClientStartingWindow();
		csw.setVisible(true);
		
	}
	
	public static void startClient(String ipAdress, int port){
		cm=new ClientMain();
		cm.connection(ipAdress, port);
		csw.setVisible(false);
		cww=new ClientWorkingWindow(ipAdress,port);
		cww.setVisible(true);
	}
	public static void serverDisconnected(){
		cww.setVisible(false);
		cww=null;
		JOptionPane.showMessageDialog(csw, "Server disconnected!", "Program terminated", JOptionPane.INFORMATION_MESSAGE,null);
		csw.textInputReset();
		csw.setVisible(true);
		
	}
}
