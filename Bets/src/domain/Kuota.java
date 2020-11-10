package domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Kuota {
	
	@XmlID
	@XmlJavaTypeAdapter(IntegerAdapter.class)
	@Id @GeneratedValue
	private int kuotaNumber;
	private String onura;
	private String emaitza;
	private Double lortutakoEtekina;
	private ArrayList<Apustua> apustuak;
	
	
	
	public String getEmaitza() {
		return emaitza;
	}
	public void setEmaitza(String emaitza) {
		this.emaitza = emaitza;
	}
	private Question galdera;
	
	public Kuota(){
		super();
	}
//	public Kuota(String emaitza, String onura) {
//		super();
//		this.emaitza = emaitza;
//		this.onura = onura;
//
//		//this.event = event;
//	}
	
	
	public Kuota(String emaitza, String onura, Question galdera){
		super();
		//this.kuotaNumber = kuotaNumber;
		this.emaitza = emaitza;   
		this.onura = onura;
		this.galdera = galdera;
		this.lortutakoEtekina=0.0;
		this.apustuak=new ArrayList<Apustua>();
	}
	
	public Double getLortutakoEtekina() {
		return lortutakoEtekina;
	}
	public void setLortutakoEtekina(Double lortutakoEtekina) {
		this.lortutakoEtekina = lortutakoEtekina;
	}
	public int getKuotaNumber() {
		return kuotaNumber;
	}
	public void setKuotaNumber(int kuotaNumber) {
		this.kuotaNumber = kuotaNumber;
	}
	public String getOnura() {
		return onura;
	}
	public void setOnura(String onura) {
		this.onura = onura;
	}
	public ArrayList<Apustua> getApustuak() {
		return apustuak;
	}
	public void setApustuak(ArrayList<Apustua> apustuak) {
		this.apustuak = apustuak;
	}
	public Question getGaldera() {
		return galdera;
	}
	public void setGaldera(Question galdera) {
		this.galdera = galdera;
	}
	public String toString(){
		return "Onura: "+onura+" eta emaitza: "+emaitza;
	}
	public int getKNumber() {
		return this.kuotaNumber;
	}
	public void addApustua(Apustua a) {
		this.apustuak.add(a);
		
	}
	public ArrayList<Apustua> getApuestuLista(){
		return this.apustuak;
	}
	public String toStringEtekina() {
		return "Kuotaren etekina: " + this.lortutakoEtekina.toString();
	}
}
