package org.dssc;

import java.awt.*;

import java.awt.image.BufferedImage;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.awt.image.BufferedImage.TYPE_BYTE_BINARY;

public class Screen{
    private static int height = 32;
    private static int width = 64;
    private static int scale=5;

    private BufferedImage backend;
    private Boolean[][]  chip8_pixels = new Boolean[width][height];

    // At start Screen is black
    public Screen(int scale) {
        super();
        this.scale=scale;
        backend=new BufferedImage(width*scale,height*scale,TYPE_BYTE_BINARY);
        int[] temp= new int[32*64*scale*scale];
        Arrays.fill(temp,Color.BLACK.getRGB());
        backend.setRGB(0,0,64*scale,32*scale,temp,0, 64*scale);
    }

    public Screen() {
        this.scale=1;
        backend=new BufferedImage(width,height,TYPE_BYTE_BINARY);
        int[] temp= new int[32*64*scale*scale];
        Arrays.fill(temp,Color.BLACK.getRGB());
        backend.setRGB(0,0,64*scale,32*scale,temp,0, 64*scale);
    }


    private void clear_screen(){
        int[] temp= new int[32*64];
        Arrays.fill(temp,Color.BLACK.getRGB());
        backend.setRGB(0,0,64*scale,32*scale,temp,0, 64*scale);
    }


    public void DrawPixel_simple(int i, int j){
        backend.setRGB(i,j,Color.WHITE.getRGB());
    }

    public void DrawPixel(int i, int j){
        int[] temp=new int[scale*scale];
        Arrays.fill(temp,Color.WHITE.getRGB());
        backend.setRGB(i*scale,j*scale,scale,scale,temp,0, scale);

    }




    public void CancelPixel_simple(int i, int j){
        backend.setRGB(i,j,Color.BLACK.getRGB());

    }



    public int getPixel(int i, int j){
        return backend.getRGB(i,j);
    }

    public BufferedImage snapshot(){
        return backend;
    }

}