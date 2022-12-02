package org.dssc;


import java.awt.image.BufferedImage;


public class Utils {
    static boolean compareImages(BufferedImage Image1, BufferedImage Image2){
        int width=(int) Image1.getWidth();
        int height=(int) Image2.getHeight();
        boolean flag=true;
        for(int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                flag=flag & (Image1.getRGB(i,j)==Image2.getRGB(i,j));
            }
        }

        return flag;
    }
}