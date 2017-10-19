package Classe;

public class Usager {
	String UserID;
	String UserPW;
	int UserType;
	public Usager(){
		
	}
	public Usager(String id,String pw,int Type){
		this.UserID=id;
		this.UserPW=pw;
		UserType=Type;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserPW() {
		return UserPW;
	}
	public void setUserPW(String userPW) {
		UserPW = userPW;
	}
	public int getUserType() {
		return UserType;
	}
	public void setUserType(int userType) {
		UserType = userType;
	}
}
