/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uos.irc.bot;

/**
 *
 * @author lukas
 */
public class Set implements BotCommand{

    @Override
    public String GetCommandName() {
        return "set";
    }

    @Override
    public void Execute(BotMain bot, String channel, String sender, String login, String hostname, String message, String[] param) {
        if(param[1].trim().equals("name"))
        {
            if(!param[2].trim().equals(""))
            { 
                bot.SetNick(param[2].trim());
            }
            else
            {
                bot.sendMessage(channel, "No name given!");
            }
        }
        else if(param[1].trim().equals("silent_level"))
        {
            String par = param[2].trim();
            if(!par.equals("") && (par.equals("0") || par.equals("1") || par.equals("2")))
            {
                bot.SetSilentLevel(Integer.parseInt(par));
            }
            else
            {
                bot.sendMessage(channel, "No valid level given!");
            }
        }
        else
        {
            bot.sendMessage(channel, "Not a valid property to set!");
        }
    }
    
}
