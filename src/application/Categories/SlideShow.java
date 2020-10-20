package application.Categories;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SlideShow {
	Label slide;
	int imageCount = 0, index = 0;
	public SlideShow(ImageView[] images)//Take given array of ImageView objetcs and rotate through them using keyframe
	{
		slide = new Label();
		imageCount = images.length;
		slide.setMaxSize(1000, 450);
		slide = new Label();
		slide.setGraphic(images[0]);
		
		KeyFrame animation = new KeyFrame(Duration.millis(3000), e -> {
			index++;
			if(index == imageCount)
			index = 0;
			
			slide.setGraphic(images[index]);
		});
		
		Timeline start = new Timeline(animation);
		start.setCycleCount(Timeline.INDEFINITE);
		start.play();
	}
	/*Returns the Label to be used for output
	 * 
	 * @return a label object
	 * 
	 */
	public Label getSlide()
	{return slide;}
}
