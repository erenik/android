package com.example.bitsurf;

import android.graphics.Canvas;
import android.graphics.Paint;

// Keeps track of the whole graphics state.
public class GraphicsState {
	int entitiesRendered;
	Canvas canvas;
	// Some default paint..
	Paint paint;
	
	// Constructor
	GraphicsState(){
		paint = new Paint();
		Nullify();
	}
	// Set zeroes where appropriate. Call once before each frame.
	void Nullify(){
		entitiesRendered = 0;
	}
}
