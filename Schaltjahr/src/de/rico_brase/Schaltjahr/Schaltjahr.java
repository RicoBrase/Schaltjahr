package de.rico_brase.Schaltjahr;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Schaltjahr extends JFrame{

	private static final long serialVersionUID = 906833793103825957L;
	
	public JTextField yearField;
	public JLabel yearLabel;
	public JTextField resultField;
	public JLabel resultLabel;
	
	public Schaltjahr(){
		super("Schaltjahr-Berechner");
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(0, 0, 350, 120);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		init();
	}
	
	public static void main(String[] args){
		new Schaltjahr();
	}
	
	public void init(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
		}
		
		yearLabel = new JLabel("Bitte geben Sie das gewünschte Jahr ein:");
		yearLabel.setBounds(5, 5, 340, 15);
		
		yearField = new JTextField();
		yearField.setBounds(5, 20, 335, 25);
		
		resultLabel = new JLabel("Ergebnis:");
		resultLabel.setBounds(5, 45, 340, 15);
		
		resultField = new JTextField();
		resultField.setBounds(5, 60, 335, 25);
		resultField.setEditable(false);
		
		yearField.addKeyListener(new SchaltjahrKeyListener(yearField, resultField));
		
		this.add(yearLabel);
		this.add(yearField);
		this.add(resultLabel);
		this.add(resultField);
		
		this.setVisible(true);
		
	}

}
