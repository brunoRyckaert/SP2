package controller;

import java.sql.Date;

import javafx.beans.property.*;

public class VerlorenVoorwerpFX {

	
		private IntegerProperty itemId;
		private IntegerProperty klantId;
		private StringProperty beschrijving;
		private StringProperty station;
		private SimpleObjectProperty<Date> datumGevonden;
		private SimpleObjectProperty<Date> datumOpgehaald;
		private IntegerProperty kassierID;
		private StringProperty treinid;
		
		
		public VerlorenVoorwerpFX() {
			super();
		}
		
		

		public VerlorenVoorwerpFX(IntegerProperty itemId, IntegerProperty klantId, StringProperty beschrijving,
				StringProperty station, SimpleObjectProperty<Date> datumGevonden, IntegerProperty kassierID,
				StringProperty treinid) {
			super();
			this.itemId = itemId;
			this.klantId = klantId;
			this.beschrijving = beschrijving;
			this.station = station;
			this.datumGevonden = datumGevonden;
			this.kassierID = kassierID;
			this.treinid = treinid;
		}



		public IntegerProperty getItemId() {
			return itemId;
		}
		
		public int getItemId1()
		{
			return itemId.get();
		}
		public void setItemId(int itemId) {
			this.itemId.set(itemId);
		}
		public IntegerProperty getKlantId() {
			return klantId;
		}
		public int getKlantId1() {
			return klantId.get();
		}
		
		public void setKlantId(int klantId) {
			this.klantId.set(klantId);
		}
		public StringProperty getBeschrijving() {
			return beschrijving;
		}
		public String getBeschrijving1() {
			return beschrijving.get();
		}
				
		public void setBeschrijving(String beschrijving) {
			this.beschrijving.set(beschrijving);
		}
		public StringProperty getStation() {
			return station;
		}
		public String getStation1() {
			return station.get();
		}
		public void setStation(String station) {
			this.station.set(station);
		}
		
		public IntegerProperty getKassierID() {
			return kassierID;
		}
		public int getKassierID1() {
			return kassierID.get();
		}
		public void setKassierID(int kassierID) {
			this.kassierID.set(kassierID);
		}
		public StringProperty getTreinid() {
			return treinid;
		}
		public String getTreinid1() {
			return treinid.get();
		}
		public void setTreinid(String treinid) {
			this.treinid.set(treinid);
		}

		public SimpleObjectProperty<Date> getDatumGevonden() {
			return datumGevonden;
		}
		public Object getDatumGevonden1()
		{
			return datumGevonden.get();
		}

		public void setDatumGevonden(Date datumGevonden) {
			this.datumGevonden.set(datumGevonden);
		}



		public SimpleObjectProperty<Date> getDatumOpgehaald() {
			return datumOpgehaald;
		}

		public Object getDatumOpgehaald1()
		{
			return datumGevonden.get();
		}


		public void setDatumOpgehaald(Date datumOpgehaald) {
			this.datumOpgehaald.set(datumOpgehaald);
		}
		
		
		
	}

