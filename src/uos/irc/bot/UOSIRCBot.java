/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uos.irc.bot;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

/**
 *
 * @author lukas
 */
public class UOSIRCBot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BotMain myBot = new BotMain();
        
        myBot.setVerbose(true);
        try {
            myBot.connect("irc.rizon.net");
        } catch (IOException ex) {
            Logger.getLogger(UOSIRCBot.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IrcException ex) {
            Logger.getLogger(UOSIRCBot.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        myBot.joinChannel("#informatik-uos");
    }
}
