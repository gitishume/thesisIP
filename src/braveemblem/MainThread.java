/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package braveemblem;


public class MainThread extends Thread {
    
    private boolean runFlag = false;
    private final double delta = 1.0/60.0;
    double time;
    int count=0;
    double elapsedTime;
    
    @Override
    public void run() {
        runFlag = true;
        
        time = System.currentTimeMillis()/1000;
        double nextTime = (double)System.nanoTime() / 1000000000.0;
        double maxTimeDiff = 0.5;
        int skippedFrames = 1;
        int maxSkippedFrames = 5;
        
        while(runFlag) {
            // convert the time to seconds
            elapsedTime = (System.currentTimeMillis()/1000) - time;
            double currTime = (double)System.nanoTime() / 1000000000.0;
            if((currTime - nextTime) > maxTimeDiff) nextTime = currTime;
            if(currTime >= nextTime)
            {
                // assign the time for the next update
                nextTime += delta;
                NewJFrame.update(); //process user input, check calculations, and update the game state
                
                count++;
                if(elapsedTime>=1) {
                    time = System.currentTimeMillis()/1000;
                    //System.out.println(count); //prints fps
                    count=0;
                }
                
                if((currTime < nextTime) || (skippedFrames > maxSkippedFrames))
                {
                    NewJFrame.draw();
                    //System.out.println("\t"+count);
                    skippedFrames = 1;
                }
                else
                {
                    skippedFrames++;
                }
            }
            else
            {
                // calculate the time to sleep
                int sleepTime = (int)(1000.0 * (nextTime - currTime));
                
                // sanity check
                if(sleepTime > 0)
                {
                    //System.out.println(sleepTime);
                    // sleep until the next update
                    try
                    {
                        Thread.sleep(sleepTime);
                    }
                    catch(InterruptedException e)
                    {
                        // do nothing
                    }
                }
            }
        }
    } //End Run
    
    
}
