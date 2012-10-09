/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uos.irc.bot;

/**
 *
 * @author lukas
 */
public class dance implements BotCommand{

    @Override
    public String GetCommandName() {
        return "dance";
    }

    @Override
    public void Execute(BotMain bot, String channel, String sender, String login, String hostname, String message, String[] param) {
        String out = "\\o\\   /o/   ~ô~";
        bot.sendMessage(channel, out);
    }
    
}
