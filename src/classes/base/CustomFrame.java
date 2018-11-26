/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.base;

import cozinha.FXMLkitchenController;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Label;

/**
 *
 * @author tulioaoki
 */
public class CustomFrame extends Thread{
    
    private Label timer;
    
    public CustomFrame(Label time){
        this.timer = time;
    }
    
    @Override
    public void run(){
        new Timer().schedule(new TimerTask() {

            int second = 60;

            @Override
            public void run() {
                System.out.println("Ta rodando");
                timer.setText("Closing application in " + second-- + " seconds.");
            }
        }, 0, 1000);
    }
    
}
