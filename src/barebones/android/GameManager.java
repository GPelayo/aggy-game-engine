/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barebones.android;

import java.util.ArrayList;

import barebones.gameObjects.*;

import android.graphics.*;

public class GameManager{
	static final int SPAWN_LOCATION_X = 100;
	static final int SPAWN_LOCATION_Y = 100;
	
	private GameThread dartThread;
	private ArrayList<BaseGameObject> gameObjects;
	public GameManager(GameView gameView)
	{
		gameObjects = new ArrayList<BaseGameObject>();
		initGameObjects();
		dartThread = new GameThread(gameView, this);
		dartThread.start();
	}
	
    public void drawForeground(Canvas g)
    {
    	g.drawColor(Color.BLACK);
    	
    	for(BaseGameObject iGameObject : gameObjects)
    	{
    		iGameObject.draw(g);
    	}
    }
    
    public void updateObjects()
    {
    	for(BaseGameObject iGameObject : gameObjects)
    	{
    		iGameObject.update();
    	}
    }
    
    public void initGameObjects()
    {
    	Unit testUnit = new Unit(new Coordinate(SPAWN_LOCATION_X, SPAWN_LOCATION_Y));
    	gameObjects.add(testUnit);
    }
    
//    private void safetlyAddGameObjectToArray(GameObject newElement, GameObject[] array)
//    {
//    	boolean noVacantElements = true;
//		
//		for(int index = 0; (index < array.length)&&noVacantElements; index++)
//        {
//			if((array[index] == null)||(array[index].isCondemned()))
//			{
//				array[index] = newElement;
//				noVacantElements = false;
//			}
//        }
//		
//		if(noVacantElements)
//		{
//			array[0] = newElement;
//		}
//    }
}