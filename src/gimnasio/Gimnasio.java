/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasio;

import javax.swing.UIManager;

/**
 *
 * @author UnTalNose
 */
public class Gimnasio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel");
        } catch (Exception e){
        }
        
        Login obj= new Login();
        obj.setTitle("Login");
        obj.setVisible(true);
        obj.setLocationRelativeTo(null);
        
    }
    
}
