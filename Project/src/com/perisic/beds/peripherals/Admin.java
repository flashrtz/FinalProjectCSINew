package com.perisic.beds.peripherals;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.perisic.beds.questionnaire.JavaMailUtil;
import com.perisic.beds.questionnaire.QuestionSet;
import com.perisic.beds.questionnaire.email;
import com.perisic.beds.rmiinterface.Question;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;

public class Admin {

	private QuestionSet questionnaire = new QuestionSet(); 
	private email E =new email();
	private JavaMailUtil J = new JavaMailUtil(); 
	

	private JFrame frmAdmin;

	/**
	 * Launch the application.
	 */
	public static void admins() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int scrWidth = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
		int scrHeight = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		frmAdmin = new JFrame();
		frmAdmin.setTitle("Admin");
		frmAdmin.setBounds(100, 100, 522, 358);
		frmAdmin.setSize(640, 480);
		frmAdmin.setLocation((scrWidth / 2) - (640 / 2), (scrHeight / 2) - (480 /2));
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    if (response == JOptionPane.NO_OPTION) {
				      
				    } else if (response == JOptionPane.YES_OPTION) {
				      System.exit(0); 
				    } 
			}
		});
		btnNewButton_3.setBounds(254, 348, 110, 49);
		frmAdmin.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("E-mail");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					J.sendMail("imandissanayake12@gmail.com");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//E.SendEmail();
			//	System.out.print("Email Sent");
			}
		});
		btnNewButton_2.setBounds(450, 163, 123, 49);
		frmAdmin.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Print PDF");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {	String pdfFileName = "E:\\test.pdf";
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
				document.open();
				
			//	questionnaire.printAnswers();
				for(int i = 0;i< questionnaire.returnAnswers().size();i++){
					Question qq = questionnaire.returnAnswers().elementAt(i);
					System.out.print(qq.getQuestionText() +'\n');
					//document.add(qq.getQuestionText()+'\n');
					Paragraph para = new Paragraph(qq.getQuestionText() +'\n');			
					document.add(para);
					String[] answers = qq.getAnswers();
					for(int j = 0 ; j<answers.length;j++){
						System.out.print(answers[j]+"\":"+qq.getFrequency(answers[j]) + '\n');
						Paragraph para1 = new Paragraph(answers[j]+"\":"+qq.getFrequency(answers[j]) + '\n');			
						document.add(para1);
					}
					Paragraph para2 = new Paragraph('\n');			
					document.add(para2);
					System.out.print('\n');
				}
			
						
				document.close();
				System.out.print("Done");
			}catch (Exception e) {
				System.out.print(e);
			}
			}
			}
			
		);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(267, 163, 138, 49);
		frmAdmin.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Analyze Answers");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				questionnaire.reportAnswers(); 

			}
		});
		btnNewButton.setBounds(54, 163, 171, 49);
		frmAdmin.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Administrator");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(213, 56, 192, 49);
		frmAdmin.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setLabelFor(frmAdmin);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ishan\\Desktop\\goluboi-fon-abstraktsiia-design-background-polygonal-texture.jpg"));
		lblNewLabel.setBounds(0, 0, 622, 433);
		frmAdmin.getContentPane().add(lblNewLabel);
	}

}
