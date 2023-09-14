package com.ms.jun161sdi.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Snack {
	// 기본형급
	private String name;
	private int price;
	//객체급
	private Company maker;
	//컬렉션급
	private String[] ingredients;
	private ArrayList<String>style;
	private HashMap<String, Double>nutrient;
	public Snack() {
		// TODO Auto-generated constructor stub
	}
	public Snack(String name, int price, Company maker, String[] ingredients, ArrayList<String> style,
			HashMap<String, Double> nutrient) {
		super();
		this.name = name;
		this.price = price;
		this.maker = maker;
		this.ingredients = ingredients;
		this.style = style;
		this.nutrient = nutrient;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Company getMaker() {
		return maker;
	}
	public void setMaker(Company maker) {
		this.maker = maker;
	}
	public String[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}
	public ArrayList<String> getStyle() {
		return style;
	}
	public void setStyle(ArrayList<String> style) {
		this.style = style;
	}
	public HashMap<String, Double> getNutrient() {
		return nutrient;
	}
	public void setNutrient(HashMap<String, Double> nutrient) {
		this.nutrient = nutrient;
	}
	
	
	
}
