package entities;

import java.util.ArrayList;

public class Gabbia {
	private int id;
	private int numerogabbia;
	private String tipoabitat;
	private ArrayList<Animale> animali;
	private ArrayList<Addetto> addetti;
	public Gabbia(int id, int numerogabbia, String tipoabitat, ArrayList<Animale> animali, ArrayList<Addetto> addetti) {
		super();
		this.id = id;
		this.numerogabbia = numerogabbia;
		this.tipoabitat = tipoabitat;
		this.animali = animali;
		this.addetti = addetti;
	}
	public Gabbia(int id, int numerogabbia, String tipoabitat) {
		super();
		this.id = id;
		this.numerogabbia = numerogabbia;
		this.tipoabitat = tipoabitat;
	
	}
	public Gabbia(int id, int numerogabbia, String tipoabitat, ArrayList<Animale> animali) {
		super();
		this.id = id;
		this.numerogabbia = numerogabbia;
		this.tipoabitat = tipoabitat;
		this.animali = animali;
		
	}
	public Gabbia(int id, int numerogabbia,  ArrayList<Addetto> addetti, String tipoabitat) {
		super();
		this.id = id;
		this.numerogabbia = numerogabbia;
		this.tipoabitat = tipoabitat;
		
		this.addetti = addetti;
	}
	public Gabbia( int numerogabbia, String tipoabitat) {
		super();
		this.numerogabbia = numerogabbia;
		this.tipoabitat = tipoabitat;
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumerogabbia() {
		return numerogabbia;
	}
	public void setNumerogabbia(int numerogabbia) {
		this.numerogabbia = numerogabbia;
	}
	public String getTipoabitat() {
		return tipoabitat;
	}
	public void setTipoabitat(String tipoabitat) {
		this.tipoabitat = tipoabitat;
	}
	public ArrayList<Animale> getAnimali() {
		return animali;
	}
	public void setAnimali(ArrayList<Animale> animali) {
		this.animali = animali;
	}
	public ArrayList<Addetto> getAddetti() {
		return addetti;
	}
	public void setAddetti(ArrayList<Addetto> addetti) {
		this.addetti = addetti;
	}
	@Override
	public String toString() {
		return "Gabbia [id=" + id + ", numerogabbia=" + numerogabbia + ", tipoabitat=" + tipoabitat + ", animali="
				+ animali + ", addetti=" + addetti + "]";
	}
	
	
	
}
