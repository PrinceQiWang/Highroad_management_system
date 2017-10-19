package Classe;

import java.util.Date;

public class Peage {
	private int CodPG;
	private int Frais;
	private String DateD;
	private String DateF;
	private String CodS;
	private String CodT;
	
	public Peage(int CodPG,int Frais,String CodS,String CodT,String DateD,String DateF){
		this.CodPG=CodPG;
		this.Frais=Frais;
		this.DateD=DateD;
		this.DateF=DateF;
		this.CodS=CodS;
		this.CodT=CodT;
		
	}

	public int getCodPG() {
		return CodPG;
	}

	public void setCodPG(int codPG) {
		CodPG = codPG;
	}

	public int getFrais() {
		return Frais;
	}

	public void setFrais(int frais) {
		Frais = frais;
	}

	public String getDateD() {
		return DateD;
	}

	public void setDateD(String dateD) {
		DateD = dateD;
	}

	public String getDateF() {
		return DateF;
	}

	public void setDateF(String dateF) {
		DateF = dateF;
	}

	public String getCodS() {
		return CodS;
	}

	public void setCodS(String codS) {
		CodS = codS;
	}

	public String getCodT() {
		return CodT;
	}

	public void setCodT(String codT) {
		CodT = codT;
	}
	
}
