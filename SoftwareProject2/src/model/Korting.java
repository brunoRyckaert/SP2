package model;

public class Korting {

	private enum Type {
		Gezin(0), Weekend(1), OuderDan60(2), TrampolineWeekendRijsel(3), EscapadeLuxemburg(4), BeneluxYouth(5);
		private int getal;

		Type(int getal) {
			this.setGetal(getal);
		}

		public void setGetal(int getal) {
			this.getal = getal;
		};
	}
	private int kortingID;
	private double prijs;
	private Boolean isProcent;
	private int aantal;
	private Boolean isAantal;
	private Type type;
	
	
	public int getKortingID() {
		return kortingID;
	}
	public void setKortingID(int kortingID) {
		this.kortingID = kortingID;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	public Boolean getIsProcent() {
		return isProcent;
	}
	public void setIsProcent(Boolean isProcent) {
		this.isProcent = isProcent;
	}
	public int getAantal() {
		return aantal;
	}
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}
	public Boolean getIsAantal() {
		return isAantal;
	}
	public void setIsAantal(Boolean isAantal) {
		this.isAantal = isAantal;
	}
	public Type getType(){
		return type;
	}
	public int getTypeGetal(){
		return this.type.getal;
	}
	public void setType(int type) {
		if(type == 0){
			this.type = Type.Gezin;
		}
		if(type == 1){
			this.type = Type.Weekend;
		}
		if(type == 2){
			this.type = Type.OuderDan60;
		}
		if(type == 3){
			this.type = Type.TrampolineWeekendRijsel;
		}
		if(type == 4){
			this.type = Type.EscapadeLuxemburg;
		}
		if(type == 5){
			this.type = Type.BeneluxYouth;
		}
	}
}
