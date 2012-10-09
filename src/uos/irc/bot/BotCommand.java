/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uos.irc.bot;

/**
 *
 * @author lukas
 */
public interface BotCommand {
    
    public abstract String GetCommandName();
    public abstract void Execute(BotMain bot, String channel, String sender, String login, String hostname, String message, String param[]);
    
    
}
