/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uos.irc.bot;

/**
 *
 * @author lukas
 */
public class time implements BotCommand{

    @Override
    public String GetCommandName() {
        return "time";
    }

    @Override
    public void Execute(BotMain bot, String channel, String sender, String login, String hostname, String message, String[] param) {
        String time = new java.util.Date().toString();
        bot.sendMessage(channel, "The time is now " + time);
    }
    
}
