/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helperClasses;
import java.awt.Toolkit;

/**
 *
 * @author Abdelhalim
 */
public class ScreenSizeClass {
    
    static Toolkit toolkit = Toolkit.getDefaultToolkit();
    
    public static int getWidth(int percentage){
        return ((int)toolkit.getScreenSize().getWidth() * percentage / 100);
    }
    
    public static int getHeight(int percentage){
        return ((int) toolkit.getScreenSize().getHeight() * percentage / 100);
    }
}
