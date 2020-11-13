package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacadeImplementation;
import domain.User;


public class HasierakoPantailaGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HasierakoPantailaGUI frame = new HasierakoPantailaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HasierakoPantailaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton LoginButton = new JButton("Log in");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				LoginGUI frame = new LoginGUI();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		LoginButton.setBounds(232, 63, 173, 61);
		contentPane.add(LoginButton);
		
		JButton GertaerakButton = new JButton("Gertaerak begiratu");
		GertaerakButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FindQuestionsGUI frame = new FindQuestionsGUI();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
			}
		});
		GertaerakButton.setBounds(106, 169, 203, 25);
		contentPane.add(GertaerakButton);
		
		
		
		
		JButton ErregistratuButton = new JButton("Erregistratu");
		ErregistratuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ErregistratuGUI frame = new ErregistratuGUI();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		ErregistratuButton.setBounds(23, 63, 157, 61);
		contentPane.add(ErregistratuButton);
		
		JButton btnNewButton = new JButton("Apustuak ikusi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BLFacadeImplementation bl = new BLFacadeImplementation();
				User user = bl.getUser("m");
				UserAdapter model= new UserAdapter(user);
				
				JFrame j = new JFrame();
				JTable table = new JTable(model);
				j.add(new JScrollPane(table)); 
				
				j.setTitle(user.getLog()+"'s bets"); 
				j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
				j.pack(); 
				j.setVisible(true);
				
				
				//wt.setVisible(true);
				//KuotakIkusiGUI ki= new KuotakIkusiGUI();
				//ki.setVisible(true);
			}
		});
		btnNewButton.setBounds(106, 207, 203, 25);
		contentPane.add(btnNewButton);
	}
}

