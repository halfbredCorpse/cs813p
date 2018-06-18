/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Jasmin Rose
 */
public class CommonDesign {
    
    private JFrame frame;
    private ImageIcon closeIcon;
    private ImageIcon closeIconHover;
    private ImageIcon minIcon;
    private ImageIcon minIconHover;
    
    private int px;
    private int py;
    
    public CommonDesign(JFrame frame) {
        this.frame = frame;
        
        closeIcon = new ImageIcon("src\\desktopapp\\img\\Close Window_25px.png");
        closeIconHover = new ImageIcon("src\\desktopapp\\img\\Close Window_hover_25px.png");
        
        minIcon = new ImageIcon("src\\desktopapp\\img\\Minimize Window_25px.png");
        minIconHover = new ImageIcon("src\\desktopapp\\img\\Minimize Window_Hover_25px.png");
        
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(179,136,103)));
   }  
    
    public Font createFont(String fontPath, int size){
        Font font = null;
        
        // Load font face to environment
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
            font  = font.deriveFont(Font.PLAIN, 14F);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        }
        catch(FontFormatException | IOException e) {
            e.printStackTrace();
        }
        
        return font;
    }
    
    public static void changeAllFont(Component component, Font font) {
        component.setFont(font);
        if (component instanceof Container ){
            for (Component child : ((Container)component).getComponents()) {
                changeAllFont(child,font);
            }
        }
    }
    
     // Redirect user to sign up page in browser
    public static void openSignUp(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public ImageIcon getImageClose() {
        return closeIcon;
    }
    
    public ImageIcon getImageCloseHover() {
        return closeIconHover;
    }
    
    public ImageIcon getImageMin() {
        return minIcon;
    }
    
    public ImageIcon getImageMinHover() {
        return minIconHover;
    }
    
}
