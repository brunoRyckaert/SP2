package controller;

public class BetaalSchermController {
private double prijs; 
private int korting; 
private double totaal; 
private double betalen; 
private int backAction; 

public BetaalSchermController(){
	super(); 
}

public BetaalSchermController(double prijs, int korting, double totaal, double betalen, int backAction) {
	super();
	this.prijs = prijs;
	this.korting = korting;
	this.totaal = totaal;
	this.betalen = betalen;
	this.backAction = backAction;
}

public double getPrijs() {
	return prijs;
}

public void setPrijs(double prijs) {
	this.prijs = prijs;
}

public int getKorting() {
	return korting;
}

public void setKorting(int korting) {
	this.korting = korting;
}

public double getTotaal() {
	return totaal;
}

public void setTotaal(double totaal) {
	this.totaal = totaal;
}

public double getBetalen() {
	return betalen;
}

public void setBetalen(double betalen) {
	this.betalen = betalen;
}

public int getBackAction() {
	return backAction;
}

public void setBackAction(int backAction) {
	this.backAction = backAction;
}

}
