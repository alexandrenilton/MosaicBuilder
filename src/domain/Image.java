/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.awt.Color;
import java.io.File;

import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Classs representing a input image.
 * @author Max
 */
public abstract class Image {
    /**
     * Image's dimensions.
     */
    public final int width;
    public final int height;
    
    public File file;
    
    public final BufferedImage img;
    
    /**
     * Matrix representing the image.
     */
    protected Color[][] pixelMatrix;
    
    public Image(String imagePath) throws IOException{
        file = new File(imagePath);
        
        img = ImageIO.read(file);
        
        width = img.getWidth();
        height = img.getHeight();
        
        pixelMatrix = new Color[width][height];
    }
    
    public Image(String imagePath, int width, int height){
        file = new File(imagePath);
        
        this.width = width;
        this.height = height;
        
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }
    
    public Image(int width, int height){
        this.width = width;
        this.height = height;
        
        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }
    
    public Color getPixelColor(int x, int y){
        return pixelMatrix[x][y];
    }
    
    public boolean equals(Image image){
        return file.getName().equals(image.file.getName());
    }
}