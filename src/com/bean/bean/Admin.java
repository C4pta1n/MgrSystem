package com.bean.bean;

public class Admin {
	private int ano;
	private String aname;
	private String asex;
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAsex() {
		return asex;
	}
	public void setAsex(String asex) {
		this.asex = asex;
	}
	public Admin(int ano, String aname, String asex) {
		this.ano = ano;
		this.aname = aname;
		this.asex = asex;
	}
	public Admin() {

		// TODO Auto-generated constructor stub
	}
	
	
}
