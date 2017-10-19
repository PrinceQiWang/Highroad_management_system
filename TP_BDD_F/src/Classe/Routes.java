package Classe;

public class Routes {
	private String CodR;
	private String NomR;
	private String VilleP;
	private String VilleT;
	private int RKm;
	
	public Routes(String CodR,String NomR,String VilleP,String VilleT,int RKm){
		this.CodR=CodR;
		this.NomR=NomR;
		this.VilleP=VilleP;
		this.VilleT=VilleT;
		this.RKm=RKm;
	}

	public String getCodR() {
		return CodR;
	}

	public void setCodR(String codR) {
		CodR = codR;
	}

	public String getNomR() {
		return NomR;
	}

	public void setNomR(String nomR) {
		NomR = nomR;
	}

	public String getVilleP() {
		return VilleP;
	}

	public void setVilleP(String villeP) {
		VilleP = villeP;
	}

	public String getVilleT() {
		return VilleT;
	}

	public void setVilleT(String villeT) {
		VilleT = villeT;
	}

	public int getRKm() {
		return RKm;
	}

	public void setRKm(int rKm) {
		RKm = rKm;
	}
	
	
}
