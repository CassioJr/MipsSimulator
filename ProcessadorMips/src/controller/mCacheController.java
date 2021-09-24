package controller;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class mCacheController {
	@FXML
	private ImageView imageCache;
	
	int count = 0;
    public void botaoProximo() {
                if(count != 5) {
                count++;
                File file = new File("./Imagens/memoria"+count+".png");
                Image image = new Image(file.toURI().toString());
                imageCache.setImage(image);
                System.out.println(count);
            }
            else if(count == 5) {
                count = 0;
            }
        }
    
    public void botaoAnterior() {
        if(count > 0) {
        count--;
        File file = new File("./Imagens/memoria"+count+".png");
        Image image = new Image(file.toURI().toString());
        imageCache.setImage(image);
        System.out.println(count);
    }
}
    
}
