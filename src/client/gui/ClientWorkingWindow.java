package client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientWorkingWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the frame.
	 */
	public ClientWorkingWindow(String ip, int port) {
		setUndecorated(true);
		setResizable(false);
		setBackground(new Color(1.0f,1.0f,1.0f,0.0f));

		setBounds(100, 100, 250, 250);
		setIconImage(new ImageIcon(ClientWorkingWindow.class.getResource("/images/Logo.png")).getImage());
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConnectedServersIp = new JLabel("Connected server's IP adress is:");
		lblConnectedServersIp.setBounds(22, 139, 184, 16);
		contentPane.add(lblConnectedServersIp);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setBounds(84, 160, 85, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ClientWorkingWindow.class.getResource("/images/TextInput.png")));
		label.setBounds(64, 157, 120, 25);
		contentPane.add(label);
		
		JLabel lblConnectedServersListening = new JLabel("Connected server's listening PORT is:");
		lblConnectedServersListening.setBounds(22, 195, 216, 16);
		contentPane.add(lblConnectedServersListening);
		
		JButton btnTerminate = new JButton("");
		btnTerminate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnTerminate.setRolloverIcon(new ImageIcon(ClientWorkingWindow.class.getResource("/images/button-terminate-small.png")));
		btnTerminate.setIcon(new ImageIcon(ClientWorkingWindow.class.getResource("/images/button-terminate.png")));
		btnTerminate.setBounds(57, 71, 137, 50);
		btnTerminate.setContentAreaFilled(false);
		btnTerminate.setBorderPainted(false);
		contentPane.add(btnTerminate);
		
		JButton btnMinimize = new JButton("\r\n");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(ICONIFIED);
			}
		});
		btnMinimize.setRolloverIcon(new ImageIcon(ClientWorkingWindow.class.getResource("/images/button-minimize-small.png")));
		btnMinimize.setFocusPainted(false);
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.setBorder(null);
		btnMinimize.setBorderPainted(false);
		btnMinimize.setIcon(new ImageIcon(ClientWorkingWindow.class.getResource("/images/button-minimize.png")));
		btnMinimize.setBounds(47, 13, 159, 50);
		contentPane.add(btnMinimize);
		
		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(97, 215, 56, 22);
		contentPane.add(textField_1);
		
		textField.setText(ip);
		textField_1.setText(String.format("%d", port));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ClientWorkingWindow.class.getResource("/images/TextInput.png")));
		label_1.setBounds(64, 212, 120, 25);
		contentPane.add(label_1);
	}


}
