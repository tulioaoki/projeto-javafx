package cozinha;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author tulioaoki
 */
public class Kitchen extends Application {
    
    public static Stage kitchen_stage;

    
    private final Runnable startTask = new Runnable(){
         @Override
         public void run() {
             System.out.println("Rodando");
            try{
                long mTime = System.currentTimeMillis();
                long end = mTime + 5000; // 5 seconds 
                while (mTime < end) {
                    mTime = System.currentTimeMillis();
                }      
                System.out.println("close stage");
                
            } catch (Exception e){}
        }     
    };
    
    private void startTimer() throws InterruptedException, Exception{
        Thread thread = new Thread(startTask);
        thread.start();
        
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
        kitchen_stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("kitchen.fxml"));
        Scene scene = new Scene(root);
        kitchen_stage.centerOnScreen(); 
        kitchen_stage.setResizable(false);
        kitchen_stage.setScene(scene);
        kitchen_stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
   public static Stage getStage() {
        return Kitchen.kitchen_stage;
    }

    public static void setStage(Stage s) {
        Kitchen.kitchen_stage = s;
    } 
    
    
}