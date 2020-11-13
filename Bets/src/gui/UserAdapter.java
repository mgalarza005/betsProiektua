package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import businessLogic.BLFacade;
import domain.Apustua;
import domain.User;

public class UserAdapter extends AbstractTableModel{
	private List<String> apustuak;
	private User u;
	private String[] colNames = new String[] {"Mugimenduak"};


	public UserAdapter(User u1) {
		BLFacade negozioLogika=MainGUI.getBusinessLogic();
		ArrayList<String> emaitza= negozioLogika.lortuMugimenduak("m");

		apustuak =emaitza;
		this.u=u1;
	}


	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override     
	public String getColumnName(int col) {  
		return colNames[col];     
		
	} 
	@Override
	public int getRowCount() {
		return apustuak.size();
	}


	@Override
	public Object getValueAt(int a, int b) {
		return ((Object) apustuak.get(a));
	}



}
