package Classe;

public class Ville {
private int CodPT;
private String NomV;
private String CodP;
public Ville(){
	
}
public Ville(int CodPT,String NomV,String CodP){
	this.CodPT=CodPT;
	this.NomV=NomV;
	this.CodP=CodP;
}
public int getCodPT() {
	return CodPT;
}
public void setCodPT(int codPT) {
	CodPT = codPT;
}
public String getNomV() {
	return NomV;
}
public void setNomV(String nomV) {
	NomV = nomV;
}
public String getCodP() {
	return CodP;
}
public void setCodP(String codP) {
	CodP = codP;
}
}
