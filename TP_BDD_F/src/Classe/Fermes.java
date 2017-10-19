package Classe;

import java.util.Date;

public class Fermes {
	private int CodF;
	private String CodT;
	private String DateD;
	private String DateF;
	private String Cause;
	
	public Fermes(int CodF,String CodT,String DateD,String DateF,String Cause){
		this.CodF=CodF;
		this.CodT=CodT;
		this.DateD=DateD;
		this.DateF=DateF;
		this.Cause=Cause;
	}

	public int getCodF() {
		return CodF;
	}

	public void setCodF(int codF) {
		CodF = codF;
	}

	public String getCodT() {
		return CodT;
	}

	public void setCodT(String codT) {
		CodT = codT;
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

	public String getCause() {
		return Cause;
	}

	public void setCause(String cause) {
		Cause = cause;
	}
	
}
