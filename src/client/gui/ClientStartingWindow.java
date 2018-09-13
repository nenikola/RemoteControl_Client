package client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientStartingWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public ClientStartingWindow() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new LineBorder(new Color(160, 160, 160), 0, true));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setPreferredSize(new Dimension(10, 30));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRemoteControl = new JLabel("Remote Control - Client");
		lblRemoteControl.setBorder(new EmptyBorder(0, 5, 0, 0));
		lblRemoteControl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		panel.add(lblRemoteControl, BorderLayout.WEST);
		
		JButton btnX = new JButton("");
		btnX.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnX.setContentAreaFilled(false);
		btnX.setFocusPainted(false);
		btnX.setRolloverIcon(new ImageIcon(ClientStartingWindow.class.getResource("/images/RemoteExitSmall.png .png")));
		btnX.setIcon(new ImageIcon(ClientStartingWindow.class.getResource("/images/RemoteExit.png")));
		btnX.setBorder(new EmptyBorder(0, 0, 0, 5));
		btnX.setBorderPainted(false);
		panel.add(btnX, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.scrollbar, 10, true));
		panel_1.setBackground(SystemColor.scrollbar);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setOpaque(false);
		textField.setBorder(null);
		textField.setBounds(80, 34, 96, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ClientStartingWindow.class.getResource("/images/TextInput.png")));
		label.setBounds(68, 34, 120, 22);
		panel_1.add(label);
		
		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setAutoscrolls(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(80, 117, 96, 22);
		panel_1.add(textField_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(ClientStartingWindow.class.getResource("/images/TextInput.png")));
		label_1.setBounds(68, 117, 120, 22);
		panel_1.add(label_1);
		
		JLabel lblTypeServerIpv = new JLabel("Type server's IPv4 adress:");
		lblTypeServerIpv.setForeground(SystemColor.controlDkShadow);
		lblTypeServerIpv.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblTypeServerIpv.setBounds(39, 13, 176, 16);
		panel_1.add(lblTypeServerIpv);
		
		JLabel lblTypeServersListening = new JLabel("Type server's listening port:");
		lblTypeServersListening.setForeground(SystemColor.controlDkShadow);
		lblTypeServersListening.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblTypeServersListening.setBounds(39, 95, 199, 16);
		panel_1.add(lblTypeServersListening);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String ip = textField.getText();
				int port = Integer.parseInt(textField_1.getText());
				GUIControler.startClient(ip, port);
				} catch (NumberFormatException ex){
					GUIControler.serverNotAvailable();
				}
				
			}
		});
		button.setRolloverIcon(new ImageIcon(ClientStartingWindow.class.getResource("/images/button-ok-small.png")));
		button.setPressedIcon(new ImageIcon(ClientStartingWindow.class.getResource("/images/button-ok-small.png")));
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setContentAreaFilled(false);
		button.setIcon(new ImageIcon(ClientStartingWindow.class.getResource("/images/button-ok.png")));
		button.setBounds(79, 166, 97, 25);
		panel_1.add(button);
	}
	public void textInputReset(){
		textField.setText("");
		textField_1.setText("");
	}
}
