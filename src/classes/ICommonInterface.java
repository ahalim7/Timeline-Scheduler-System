/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commonInterfaces;

import java.awt.Component;

/**
 *
 * @author Abdelhalim
 */
public interface ICommonInterface {

    /**
     * declare the common method
     */
    public void start();

    public void initialization();

    public void buttonActionsIntialization();
    
    public void setComponentSize();

    public void setComponentColor();

    public void setComponentText();

    public void addChildren();
}
