package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;



@SuppressWarnings("serial")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Apustua {
	
	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id @GeneratedValue
	private int apustuNumber;
	private double apostuDirua;
	@XmlIDREF
	private User u;
	@XmlIDREF
	private Kuota k;
	

	public Apustua(double dirukop, User u, Kuota k) {
		super();
		this.apostuDirua = dirukop;
		this.u=u;
		
		this.k=k;
		
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public Kuota getK() {
		return k;
	}

	public void setK(Kuota k) {
		this.k = k;
	}

	public double getDirukop() {
		return apostuDirua;
	}

	public void setDirukop(double dirukop) {
		this.apostuDirua = dirukop;
	}
	
	
	
	
	
	

}
