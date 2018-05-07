package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {
     
    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
       for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping"+i+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        int num=2;
        while (true) {
            try {
                this.setY(370); //
               
                for (int i = 370; i > 275; i=i-35) {
                    
                    super.setImage(sprite.get(num));
                    if (num ==0) {
                        num = 2;
                    } else {
                        num--;
                    }
                    super.setY(i);
                    Thread.sleep(350);
                    //           super.setX(700);
                    //           Thread.sleep(800);
                }
                
            } 
            catch (InterruptedException ex) {} 
        }
    }
}
