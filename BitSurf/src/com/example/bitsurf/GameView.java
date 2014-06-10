package com.example.bitsurf;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/// View that takes care of rendering the content?
public class GameView extends View {

	/// Fetch screen-stats
    Vector2i viewMin = new Vector2i(), viewMax = new Vector2i();
    
	Paint paint = new Paint();
	// Entitieiiies!
	List<Entity> entities = new ArrayList<Entity>();
	Boolean entitiesCreated = false;
	GraphicsState graphicsState = new GraphicsState();
	Entity playerEntity = new Entity();

	
	public GameView(Context context){
		super(context);
		
		System.out.println("Creating GameView");
		setFocusable(true);
        setFocusableInTouchMode(true);
        
        /// Fill a background-color first?
      	this.setBackgroundColor(0xFFFFFF);
      		

      	playerEntity.color = new Vector3i(0,125,255);
      	
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
        
        
        
        

     //   ClearGestures(); // make sure everything is gone
    }
	
	public void CreateEntities(Vector2i min, Vector2i max){
		System.out.println("CreateEntities");
        /// Create some entities.
        int entitiesToCreate = 20;
        for (int i = 0; i < entitiesToCreate; ++i){
        	Entity entity = new Entity();
        	entity.SetRandomPosition(min, max);
        	entities.add(entity);
        }
	}
	
	@Override
	public void onDraw(Canvas canvas){
		if (!entitiesCreated){
			System.out.println("Creating entities.");
			int width = getWidth();
			int height = getHeight();
			viewMin.x = viewMin.y = 0; 
			viewMax.x = width;
			viewMax.y = height;
			System.out.println("View max: "+viewMax.x+", "+viewMax.y);
			CreateEntities(viewMin, viewMax);
			entitiesCreated = true;
			playerEntity.SetRandomPosition(viewMin, viewMax);
		}
		graphicsState.canvas = canvas;
		
		/// Draw bg and stuffs!
		super.onDraw(canvas);
	//	System.out.println("GameView::onDraw");
		
		// Fill bg.. please..
		paint.setStyle(Paint.Style.FILL);
		
		
		// Entitiiies!
		if (entities.size() > 0)
			;//System.out.println("Rendering "+entities.size()+" entities.");
		for (int i = 0; i < entities.size(); ++i){
			Entity entity = entities.get(i);
			entity.Render(graphicsState);
		}
		// Default circle, player mayber?
		int x, y;
		x = y = 20;
		canvas.drawCircle(x, y, 2, paint);
		
		/// Render the player!
		playerEntity.Render(graphicsState); 
		playerEntity.position.y += 1;
		
		/*
		//Log.d("DrawView", "onDraw:" + canvas);
		for (int c=0; c<points.size()-1; c++){
			Point2D point = points.get(c);
			Point2D point2 = points.get((c+1)%points.size());
			canvas.drawLine(point.x, point.y, point2.x, point2.y, paint);
			canvas.drawCircle(point.x, point.y, 2, paint);
		}
		*/
		/*
		// gesture render version
		int nr_gestures = gestures.size();
		for(int gesture_index=0; gesture_index<nr_gestures; gesture_index++)
		{
			Gesture active_gesture = gestures.elementAt(gesture_index);
			int gesture_points = active_gesture.points.size();
//			paint.setColor(Color.RED);
			for(int point=0; point<gesture_points-1; point++)
			{
				Point2D current_point = active_gesture.points.get(point);
				Point2D next_point = active_gesture.points.get((point+1));
				canvas.drawLine(current_point.x, current_point.y, next_point.x, next_point.y, paint);
				canvas.drawCircle(current_point.x, current_point.y, 2, paint);
			}
	//        paint.setColor(Color.WHITE);
			
		}
		*/
	}
}
