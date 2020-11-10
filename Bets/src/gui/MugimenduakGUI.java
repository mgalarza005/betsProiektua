package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacade;
import domain.User;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MugimenduakGUI extends JFrame {

	private JPanel contentPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MugimenduakGUI frame = new MugimenduakGUI(args[1]);
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
	public MugimenduakGUI(String usr) {

		//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1024, 522);
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(12, 110, 982, 22);
		contentPane.add(comboBox);
		
		JButton btnMugimenduakIkusi = new JButton("Mugimenduak ikusi");
		btnMugimenduakIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BLFacade negozioLogika=MainGUI.getBusinessLogic();
				ArrayList<String> emaitza= negozioLogika.lortuMugimenduak(usr);
				for(int i=0; i<emaitza.size();i++) {
					comboBox.addItem(emaitza.get(i));
				}
//				
//
//				}
				
			}
		});
		btnMugimenduakIkusi.setBounds(825, 70, 169, 25);
		contentPane.add(btnMugimenduakIkusi);
		
		JLabel lblMugimenduak = new JLabel("MUGIMENDUAK");
		lblMugimenduak.setForeground(Color.BLACK);
		lblMugimenduak.setHorizontalAlignment(SwingConstants.CENTER);
		lblMugimenduak.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMugimenduak.setBounds(175, 30, 223, 25);
		contentPane.add(lblMugimenduak);
		
		
	}
}
