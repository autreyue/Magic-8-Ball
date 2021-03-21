import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.Random;
import java.util.ArrayList;

/**
 * this program recreates a magic 8 ball using 10 separate images
 *      when the button is clicked, the program shows an image with the answer
 * created by Trey Foehner
 * 03.2020
 */

public class Magic8Ball extends Application {
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage){

        //create the banner, send to hbox and make adjustments
        Image img = new Image("banner.png");
        ImageView banner = new ImageView(img);
        banner.setPreserveRatio(true);
        HBox bannerBox = new HBox(10, banner);
        bannerBox.setAlignment(Pos.TOP_CENTER);
        bannerBox.setPadding(new Insets(30));

        //create a string array containing 10 elements
        String[] filePath  = new String[10];

        //this loop fills the contents of the String array with each filename
        for(int i = 0; i < 10; i++){
            //extension name
            String s = ".gif";
            //concat set file name with extension
            filePath[i] = i + s;
        }

        //create images using the string array contents
        Image i1 = new Image(filePath[0]);
        Image i2 = new Image(filePath[1]);
        Image i3 = new Image(filePath[2]);
        Image i4 = new Image(filePath[3]);
        Image i5 = new Image(filePath[4]);
        Image i6 = new Image(filePath[5]);
        Image i7 = new Image(filePath[6]);
        Image i8 = new Image(filePath[7]);
        Image i9 = new Image(filePath[8]);
        Image i10 = new Image(filePath[9]);

        //create an ArrayList full of the images
        ArrayList<Image> imgList = new ArrayList<Image>();
        imgList.add(i1);
        imgList.add(i2);
        imgList.add(i3);
        imgList.add(i4);
        imgList.add(i5);
        imgList.add(i6);
        imgList.add(i7);
        imgList.add(i8);
        imgList.add(i9);
        imgList.add(i10);

        //create the ImageView obj
        ImageView image = new ImageView();
        image.setPreserveRatio(true);

        //create button obj
        Button button = new Button("CLICK HERE TO FIND YOUR ANSWER");

        //make event handler
        button.setOnAction(e ->
        {   //new random obj
            Random ra = new Random();
            //set the ImageView object, passing the location of sequential filenames in memory
            image.setImage(imgList.get(ra.nextInt(imgList.size())));
            //change button text
            button.setText("CLICK AGAIN TO ASK ANOTHER QUESTION");
        });

        //adjust position of objects
        HBox buttonBox = new HBox(button);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        //create the image HBox
        HBox displayBox = new HBox (10, image);
        displayBox.setAlignment(Pos.BASELINE_CENTER);
        displayBox.setPadding(new Insets(10));

        //put all hboxes in one root vbox
        VBox rootBox = new VBox(10, bannerBox, displayBox, buttonBox);
        rootBox.setAlignment(Pos.CENTER);
        rootBox.setPadding(new Insets(10));

        //create scene obj
        Scene scene = new Scene(rootBox, 600, 650);

        //give this thing a title, slap it on the stage, and showtime
        stage.setTitle("TREY's MAGIC 8BALL");
        stage.setScene(scene);
        stage.show();
    }
}
