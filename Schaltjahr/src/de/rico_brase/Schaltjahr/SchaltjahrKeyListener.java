package de.rico_brase.Schaltjahr;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class SchaltjahrKeyListener implements KeyListener{
	
	protected char[] chars = {'0','1','2','3','4','5','6','7','8','9'}; 
	protected List<Character> allowed;
	
	JTextField year;
	JTextField result;
	
	public SchaltjahrKeyListener(JTextField in, JTextField out){
		super();
		this.year = in;
		this.result = out;
		allowed = new ArrayList<Character>();
		for(char c : chars){
			allowed.add(c);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(allowed.contains(e.getKeyChar())){
			year.setText(year.getText() + e.getKeyChar());
			
			if(auswerten(year.getText())){
				result.setText("Schaltjahr!");
			}else{
				result.setText("Kein Schaltjahr!");
			}
			
		}
		
		e.consume();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_V && e.isControlDown()){
			e.consume();
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			
			if(year.getText().isEmpty()){
				result.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			
			if(!year.getText().isEmpty()){
				if(auswerten(year.getText())){
					result.setText("Schaltjahr!");
				}else{
					result.setText("Kein Schaltjahr!");
				}
			}
		}
	}
	
	public boolean auswerten(String year){
		try{
			int iYear = Integer.parseInt(year);
			if(iYear%4 == 0){
				if(iYear%100 == 0){
					if(iYear%400 == 0){
						return true;
					}else{
						return false;
					}
				}else{
					return true;
				}
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}

}
