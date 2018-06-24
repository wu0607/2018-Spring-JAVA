import javafx.application.Application;
//Animation
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.util.Duration;
//Image
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//MouseEvent
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
//Effect
import javafx.scene.effect.GaussianBlur;
import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.stage.Stage;




public class Lab7 extends Application {
 

	private ImageView imageView;
	private Image[] images;
	//
	private double blurRadius;
	private GaussianBlur blur;
	//
	@Override
    public void start(Stage primaryStage) throws Exception{
        
		images = new Image[12];
		for (int i = 0;i < images.length;i++)
			images[i] = new Image(getClass().getResource("./pictures/dove"+i+".gif").toExternalForm());
		imageView = new ImageView();
		imageView.setImage(images[0]);
		imageView.setX(0); 
		imageView.setY(0); 
		imageView.setFitHeight(200);
		imageView.setFitWidth(200);
		imageView.setPreserveRatio(true);
		
		Group root = new Group(imageView);
        Scene scene = new Scene(root, 600, 480);
		
		
		
		scene.setOnMouseMoved(new EventHandler<MouseEvent>(){
		@Override 
			public void handle(MouseEvent event) {
			//write your code
			}
		});
		
		//animation
		
		
		
		//
		primaryStage.setTitle("project pratice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }
}