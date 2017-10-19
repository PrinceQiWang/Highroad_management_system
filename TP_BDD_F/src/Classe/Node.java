package Classe;

public class Node {
private String CodP;
private String CodR;


private int CodPT;
public Node(){
	
}
public Node(String CodP,String CodR){
	this.CodP=CodP;
	this.CodR=CodR;
}
public String getCodP() {
	return CodP;
}
public void setCodP(String codP) {
	CodP = codP;
}
public String getCodR() {
	return CodR;
}
public void setCodR(String codR) {
	CodR = codR;
}
public int getCodPT() {
	return CodPT;
}
public void setCodPT(int codPT) {
	CodPT = codPT;
}


}
