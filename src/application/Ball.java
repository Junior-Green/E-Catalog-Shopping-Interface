package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ball 
{
	double xPos, yPos, ballWidth, ballHeight, xDir, yDir;
	Image imgBall;
	ImageView iviewBall;
	
	public Ball() //No-arg constructor
	{}
	//Sets position and ball Image
	public Ball(double xPos, double yPos, Image imgBall)
	{
		this.xPos =  xPos;
		this.yPos = yPos;
		this.imgBall = imgBall;
		iviewBall = new ImageView(imgBall);
		xDir = 5;
		yDir = 5;
		
	}
	//Sets position, image and ball speed
	public Ball(double xPos, double yPos, Image imgBall, double ballHeight, double ballWidth, double xDir, double yDir)
	{
		this.xPos =  xPos;
		this.yPos = yPos;
		this.imgBall = imgBall;
		iviewBall = new ImageView(imgBall);
		iviewBall.resize(ballWidth, ballHeight);
		this.ballHeight = ballHeight;
		this.ballWidth = ballWidth;	
		this.xDir = xDir;
		this.yDir = yDir;
	}
	
	/*Returns the ball image's height
	 * 
	 * @return double representing 
	 * ball's height 
	 */
	public double getHeight()
	{
		return ballHeight;
	}
	/*Returns the ball image's width
	 * 
	 * @return double representing 
	 * ball's width 
	 */
	public double getWidth()
	{
		return ballWidth;
	}
	/*Returns the ball's image
	 * 
	 * @return An Image object 
	 * used for Ball
	 */
	public Image getImage()
	{
		return imgBall;
	}
	/*Returns the ball's image view
	 * 
	 * @return An Image view object 
	 * used for Ball
	 */
	public ImageView getNode()
	{
		return iviewBall;
	}
	/*Returns the ball's X coordinate
	 * 
	 * @return a Double representing 
	 * the Ball's X-coordinate
	 */
	public double getX()
	{
		return xPos;
	}
	/*Returns the ball's Y coordinate
	 * 
	 * @return a Double representing 
	 * the Ball's Y-coordinate
	 */
	public double getY()
	{
		return yPos;
	}
	/*Changes x and y coordinates
	 * to move object 
	 * 
	 * @return void
	 */
	public void move()
	{
		xPos += xDir;
		yPos += yDir;
	}
	/*Reverses direction of movement
	 * 
	 * @param A boolean which changes between
	 * the x or y values
	 * 
	 * @return void 
	 */
	public void reverseDirection(boolean xORy)
	{
		if (xORy == true)
			xDir = -xDir;

		else 
			yDir = -yDir;
		
	}
	/*Changes x and y coordinates
	 * to move object 
	 * 
	 * @param 2 doubles which set how much to
	 * move the ball in boh directions
	 * in pixels
	 * 
	 * @return void
	 */
	public void move(double xDir, double yDir)
	{	
		this.xDir = xDir;
		this.yDir = yDir;
		xPos += xDir;
		yPos += yDir;
	}
	/*Set the ball's width
	 * 
	 * @param takes a double which
	 * will be used to set the ball's width
	 * 
	 * @return void
	 */
	public void setWidth(double width)
	{
		ballWidth = width;
	}
	/*Set the ball's height
	 * 
	 * @param takes a double which
	 * will be used to set the ball's height
	 * 
	 * @return void
	 */
	public void setHeight(double height)
	{
		ballHeight = height;
	}
	/*Set the ball's image
	 * 
	 * @param takes a Image object
	 * 
	 * @return void
	 */
	public void setImage(Image imgBall)
	{
		this.imgBall = imgBall;
	}
	/*Sets the x position of the
	 * object
	 * 
	 * @param takes a double 
	 * which is used to set the
	 * ball's x-position
	 */
	public void setX(double x)
	{
		xPos = x;
	}
	/*Sets the y position of the
	 * object
	 * 
	 * @param takes a double 
	 * which is used to set the
	 * ball's y-position
	 */
	public void setY(double y)
	{
		yPos = y; 
	}
	/*Sets the x and y position of the
	 * object
	 * 
	 * @param takes two doubles 
	 * which is used to set the
	 * ball's x-position and y-position
	 */
	public void setDirection(double xDir, double yDir)
	{
		this.xDir = xDir;
		this.yDir = yDir;
	}
	
	
	
}
