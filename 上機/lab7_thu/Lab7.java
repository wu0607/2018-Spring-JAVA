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
import javafx.scene.input.MouseButton;
import javafx.event.EventHandler;
//Effect
import javafx.scene.effect.Reflection;
import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.stage.Stage;



public class Lab7 extends Application {
 

	private ImageView imageView;
	private Image[] images;
	//
	private double fraction;
	private Reflection reflection;
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
		//
		final Animation animation = new Transition() {
			{
				setCycleDuration(Duration.millis(600));
				setCycleCount(Animation.INDEFINITE);
			}
 
			protected void interpolate(double frac) {
				// System.out.print(((int)frac)%12+"\n");
				//System.out.print(frac+"\n");
				imageView.setImage(images[(int)(frac*11)]);
				
			}
		};
		
		animation.play();

		scene.setOnMouseClicked(new EventHandler<MouseEvent>(){
		@Override 
			public void handle(MouseEvent event) {
				// write your code
				if(event.getButton() == MouseButton.PRIMARY){
					double x = event.getX() - imageView.getFitWidth()/2;
					double y = event.getY() - imageView.getFitHeight()/2;
				
					imageView.setX(x);
					imageView.setY(y);
				}
			}
		});
		
		
		reflection = new Reflection();
		reflection.setFraction(0.1);
		imageView.setEffect(reflection);
		//write your code
		
		scene.setOnScroll(new EventHandler<ScrollEvent>() {
		//double fraction =0;
		@Override 
			public void handle(ScrollEvent event) {
				//System.out.print(event.getDeltaX()+" ");
				//System.out.print(event.getDeltaY()+"\n");
				
				if(event.getDeltaY()>=0){
					fraction += 0.01;
				}else{
					fraction -= 0.01;
				}
				
				//System.out.print(fraction+" ");
				reflection.setFraction(fraction);
				//imageView.setEffect(new Reflection(1, 1, 1, 1));
			}
		});
		//
		primaryStage.setTitle("project pratice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

 
    public static void main(String[] args) {
        launch(args);
    }
}