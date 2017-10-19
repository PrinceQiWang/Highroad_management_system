package Classe;

public class Societe {
	private String CodS;
	private String NomS;
	public Societe(){
		
	}
	public Societe(String CodS,String NomS){
		this.CodS=CodS;
		this.NomS=NomS;
	}
	public String getCodS() {
		return CodS;
	}
	public void setCodS(String codS) {
		CodS = codS;
	}
	public String getNomS() {
		return NomS;
	}
	public void setNomS(String nomS) {
		NomS = nomS;
	}
	
}
