/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package barebones.android;

import barebones.gameObjects.Coordinate;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.view.GestureDetector.SimpleOnGestureListener;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    public GameManager _engine;
    private Bitmap background;
    private GestureDetector _gestureDectector;
    
    class TouchControlReader extends SimpleOnGestureListener {    	
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
        	InputData.touchLocation = new Coordinate(e.getX(), e.getY());
        	return true;
        }
    }
    
    public boolean onTouchEvent(MotionEvent evt)
    {
    	_gestureDectector.onTouchEvent(evt);
    	return true;
    }
    
    public GameView(Context context) {
		super(context);
		initGameObjects();
		initInputs();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGameObjects();
	}

	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initGameObjects();
	}	
	
    private void initGameObjects()
    {
    	//add and load graphics
    	_engine = new GameManager(this);
    }
    
    private void initInputs()
    {
    	_gestureDectector = new GestureDetector(new TouchControlReader());
    }
    
    public void doDraw(Canvas canvas) {
		_engine.drawForeground(canvas);
	}
    
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		//resize background
		
		//initialize screen dimension based varibles in manager
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		//initialize screen dimension based varibles in engine
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
	
	
}