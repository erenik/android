package com.example.bitsurf;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Entity {

	Vector2i position;
	// On the R/B scale for now.
	Vector3i color;
	// Constructor?
	Entity(){
		System.out.println("EntityConstructor");
		// Initialize own variables?
		position = new Vector2i();
		color = new Vector3i();
		color.x = 255;
		color.y = 0;
	}
	void SetRandomPosition(Vector2i min, Vector2i max){
		Vector2i size = max.Minus(min);
		position.x = (int)(Math.random() * size.x);
		position.y = (int)(Math.random() * size.y);
	//	System.out.println("Pos: "+position.x+", "+position.y);
	}
	void Render(GraphicsState graphicsState){
		Canvas canvas = graphicsState.canvas;
		Paint paint = graphicsState.paint;
		
		paint.setARGB(255, color.x, color.y, color.z);
	//	paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
		
		canvas.drawCircle(position.x, position.y, 2, graphicsState.paint);
	}
}
