package Classe;

public class Troncon {
private String CodT;
private String CodR;
private String nodeP;
private String nodeT;
private int TKm;
private int type;
public Troncon(){
	
}
public Troncon(String CodT,String CodR,String nodeP,String nodeT,int TKm,int type){
	this.CodT=CodT;
	this.CodR=CodR;
	this.nodeP=nodeP;
	this.nodeT=nodeT;
	this.TKm=TKm;
	this.type=type;
}
public String getCodT() {
	return CodT;
}
public void setCodT(String codT) {
	CodT = codT;
}
public String getCodR() {
	return CodR;
}
public void setCodR(String codR) {
	CodR = codR;
}
public String getNodeP() {
	return nodeP;
}
public void setNodeP(String nodeP) {
	this.nodeP = nodeP;
}
public String getNodeT() {
	return nodeT;
}
public void setNodeT(String nodeT) {
	this.nodeT = nodeT;
}
public int getTKm() {
	return TKm;
}
public void setTKm(int tKm) {
	TKm = tKm;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
}
