package com.example.bitsurf;

public class Vector2i {
	public int x;
	public int y;
	Vector2i(){
		System.out.println("Vector2iConstructor");
		
	}
	Vector2i(int x, int y){
		System.out.println("Vector2iConstructor");
		this.x = x;
		this.y = y;
	}
	public Vector2i Minus(Vector2i other){
		Vector2i newVec = new Vector2i();
		newVec.x = x - other.x;
		newVec.y = y - other.y;
		return newVec;
	}
}
