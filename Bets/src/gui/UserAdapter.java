package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Apustua;
import domain.User;

public class UserAdapter extends AbstractTableModel{
	private List<Apustua> apustuak;
	private User u;
	private String[] colNames = new String[] {"Mugimenduak"};
	
	
	public UserAdapter(User u1) {
		apustuak = (List<Apustua>) u1.getGertatukoMugimendua();
		this.u=u1;
	}


	@Override
	public int getColumnCount() {
		return 1;
	}


	@Override
	public int getRowCount() {
		return apustuak.size();
	}


	@Override
	public Object getValueAt(int a, int b) {
		return ((Object) apustuak.get(b));
	}
	
	

}
