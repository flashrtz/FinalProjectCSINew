package com.perisic.beds.peripherals;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import com.perisic.beds.questionnaire.QuestionSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

 
public class QuestionsGUI extends JFrame implements ActionListener  {
	
	private JFrame frame;
	
	public static void main(String [] args ) { 
		QuestionsGUI myGUI = new QuestionsGUI(); 
		myGUI.setVisible(true); 
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1077856539035586635L;
	
	// The GUI only interacts with the QuestionnairePanel class. 
	private QuestionSet questionnaire = new QuestionSet(); 
/**
 * Two possible actions are implemented here: 
 * start the questionnaire and analyses the answers. 
 * To do: refractor code to separate into different concerns; also:  
 * password protect the actions (questionnaire, analysis of data). 
 */
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(nextButton)) { 
			
			for(int i = 0; i < questionnaire.numberOfQuestions(); i++) {

				String message = questionnaire.getQuestion(i); 
				String [] options = questionnaire.getOptions(i); 

				int selectedValue = JOptionPane.showOptionDialog(null, 
						message, "Question "+i, JOptionPane.DEFAULT_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options, options[0]);  
				
				questionnaire.submitAnswer(i, options[selectedValue]);
			}
		} 
		
	}

	JButton nextButton = new JButton("Start Questionnaire");	
	private final JLabel lblNewLabel = new JLabel("New label");
	private final JLabel lblNewLabel_1 = new JLabel("This Questionnaire is based on to see how motivated are the people working \r\ntheir daily jobs considering basic asnwers.Thankyou for participating in this\r\n Questionnaire where you'll be helping us to gather information regarding\r\n this matter.");
	private final JLabel lblNewLabel_2 = new JLabel("To sign in as administrator");
	private final JLabel lblNewLabel_3 = new JLabel("Click Here");

/**
 * Constructor	
 */
	
	private QuestionsGUI() {
		super();
		
		int scrWidth = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
		int scrHeight = (int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		setTitle("QuestionsGUI");
		setSize(640, 480);
		setLocation((scrWidth / 2) - (640 / 2), (scrHeight / 2) - (480 /2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	
		
		JPanel panel = new JPanel(); 
		panel.setLayout(null);
		nextButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		nextButton.setBounds(172, 194, 253, 40);
		nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Login lg = new Login();
				lg.login();
				//frame.dispose();
				lg.setVisible(true);
				this.dispose();
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(355, 379, 83, 16);
		
		panel.add(lblNewLabel_3);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(137, 378, 218, 16);
		
		panel.add(lblNewLabel_2);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(26, 74, 571, 116);
		
		panel.add(lblNewLabel_1);
		
		panel.add(nextButton); 
		nextButton.addActionListener(this); 
		lblNewLabel.setIcon(new ImageIcon("E:\\image.jpeg"));
		lblNewLabel.setBounds(0, 0, 622, 433);
		
		panel.add(lblNewLabel);
				
		getContentPane().add(panel);
		panel.repaint();
		

	}
	
	

}