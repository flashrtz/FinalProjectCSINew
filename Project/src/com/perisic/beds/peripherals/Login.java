package com.perisic.beds.peripherals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField admin_name;
	private JPasswordField admin_password;

	/**
	 * Launch the application.
	 */
	public static void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int scrWidth = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
		int scrHeight = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setSize(640, 480);
		frmLogin.setLocation((scrWidth / 2) - (640 / 2), (scrHeight / 2) - (480 /2));
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		admin_password = new JPasswordField();
		admin_password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String ann = "admin";
					String app = "admin";
					String an=admin_name.getText();
					String ap=admin_password.getText();
					boolean a = ann.matches(an);
					boolean b = app.matches(ap);
							if("".equals(admin_name.getText()))
					            {
					                JOptionPane.showMessageDialog(null,"Pleace provide your User Name");
					            }
							else if("".equals(admin_password.getText()))
				            {
				                JOptionPane.showMessageDialog(null,"Pleace provide your Password");
				            }
							else if(a == false)
							{
								JOptionPane.showMessageDialog(null,"Username Invalid");	
							}
							else if (b == false)
							{
								JOptionPane.showMessageDialog(null,"Password Invalid");	
							}
							else
							{
								Admin ad = new Admin();
								ad.admins();
								frmLogin.setVisible(false);
							}
				}
			}
		});
		admin_password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		admin_password.setBounds(240, 159, 162, 39);
		frmLogin.getContentPane().add(admin_password);
		
		admin_name = new JTextField();
		admin_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		admin_name.setBounds(240, 94, 162, 39);
		frmLogin.getContentPane().add(admin_name);
		admin_name.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String ann = "admin";
			String app = "admin";
			String an=admin_name.getText();
			String ap=admin_password.getText();
			boolean a = ann.matches(an);
			boolean b = app.matches(ap);
					if("".equals(admin_name.getText()))
			            {
			                JOptionPane.showMessageDialog(null,"Pleace provide your User Name");
			            }
					else if("".equals(admin_password.getText()))
		            {
		                JOptionPane.showMessageDialog(null,"Pleace provide your Password");
		            }
					else if(a == false)
					{
						JOptionPane.showMessageDialog(null,"Username Invalid");	
					}
					else if (b == false)
					{
						JOptionPane.showMessageDialog(null,"Password Invalid");	
					}
					else
					{
						Admin ad = new Admin();
						ad.admins();
						frmLogin.setVisible(false);
					}
			
			}
		});
		btnNewButton.setBounds(240, 317, 149, 58);
		frmLogin.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(88, 169, 116, 16);
		frmLogin.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(88, 104, 116, 16);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ishan\\Desktop\\goluboi-fon-abstraktsiia-design-background-polygonal-texture.jpg"));
		lblNewLabel.setBounds(0, 0, 622, 433);
		frmLogin.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
