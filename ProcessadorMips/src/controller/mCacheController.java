package controller;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class mCacheController {
	@FXML
	private ImageView imageCache;
	
	
	int count = 0;
    public void botao() {
                if(count != 5) {
                File file = new File("./imagens/memoria"+count+".png");
                Image image = new Image(file.toURI().toString());
                imageCache.setImage(image);
                count++;
            }
            else if(count == 5) {
                count = 0;
            }
        }

}
