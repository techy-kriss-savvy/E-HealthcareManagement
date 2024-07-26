package com.model;

public class Patient {
	
	private int Pid;
	 
	  private String Doctor;
	  private String Conditions;

  public int getPid() {
		return Pid;
	}
	public void setPid(int Pid) {
	    this.Pid = Pid;
	}

	public String getDoctor() {
		return Doctor;
	}
	public void setDoctor(String doctor) {
		Doctor = doctor;
	}
	public String getConditions() {
		return Conditions;
	}
	public void setConditions(String conditions) {
		Conditions = conditions;
	}
	
	@Override
	public String toString() {
		return "Patient [Pid=" + Pid + ", Doctor=" + Doctor + ", Condition="
				+ Conditions + "]";
	}

	
}
