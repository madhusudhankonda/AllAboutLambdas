package com.madhusudhan.wr.allaboutlambdas.domain;

public class Patient {
	long patientId = 0;
	private int seriousFactor = 0;
	public Patient(long id) {
		patientId = id;
	}
	public boolean isSerious(){
		return seriousFactor > 3;
	}
	public int getSeriousFactor() {
		return seriousFactor;
	}
	public void setSeriousFactor(int seriousFactor) {
		this.seriousFactor = seriousFactor;
	}
}
