package org.dssc;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_BYTE_BINARY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    void test_compare_images_true() {
        BufferedImage Image1 = new BufferedImage(10, 20,TYPE_BYTE_BINARY);
        Image1.setRGB(0, 0, Color.WHITE.getRGB());
        BufferedImage Image2 = new BufferedImage(10, 20, TYPE_BYTE_BINARY);
        Image2.setRGB(0, 0, Color.WHITE.getRGB());
        assertEquals(true, Utils.compareImages(Image1, Image2));
    }

    @Test
    void test_compare_images_false() {
        BufferedImage Image1 = new BufferedImage(20, 10,TYPE_BYTE_BINARY);
        Image1.setRGB(0, 0, Color.WHITE.getRGB());
        BufferedImage Image2 = new BufferedImage(20, 10, TYPE_BYTE_BINARY);
        Image2.setRGB(0, 0, Color.BLACK.getRGB());
        assertEquals(true, Utils.compareImages(Image1, Image2));
    }
    @Test
    void test_render_pixel(){
        Screen screen1= new Screen();
        screen1.DrawPixel_simple(0,1);
        assertEquals(true, Color.WHITE.getRGB()==screen1.getPixel(0,1));
    }



    @Test
    void test_snapshot() {
        Screen screen1 = new Screen();
        screen1.DrawPixel_simple(0, 0);
        screen1.DrawPixel_simple(1, 0);
        System.out.println(screen1.getPixel(0,0));
        BufferedImage Image1= screen1.snapshot();
        BufferedImage Image2 = new BufferedImage(64, 32,TYPE_BYTE_BINARY);
        Image2.setRGB(0, 0, Color.WHITE.getRGB());
        Image2.setRGB(1, 0, Color.WHITE.getRGB());
        assertEquals(true,Utils.compareImages(Image1, Image2));
    }



}
