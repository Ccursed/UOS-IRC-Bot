/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uos.irc.bot;

import org.jibble.pircbot.*;
import java.lang.String;
import java.util.*;

/**
 *
 * @author lukas
 */
public class BotMain extends PircBot {
    
    
    private String m_BotName;
    private int m_ShutUpLevel;    // 0 -> everything, 1 -> no useless spam, but commands and important things
                                // 2 -> just command answers
    private Boolean m_Disabled;
    
    List<BotCommand> m_Commands;
    List<String> m_ViolentWords;
    
    
    /**
     * Constructor
     */
    public BotMain() {
        m_BotName = "Bernd-der-Bot";
        m_ShutUpLevel = 0;
        m_Disabled = false;
        
        m_Commands = new ArrayList<BotCommand>();
        // add commands
        m_Commands.add(new Set());
        m_Commands.add(new time());
        m_Commands.add(new dance());
        
        // Add violent words
        m_ViolentWords = new ArrayList<String>();
        m_ViolentWords.add("schlampe");
        m_ViolentWords.add("arsch");
        m_ViolentWords.add("scheiß");
        m_ViolentWords.add("bitch");
        
        
                
        
        
        
        
        this.setName(m_BotName);
    }
    
    public void SetNick(String newNick)
    {
        m_BotName = newNick;
        changeNick(newNick);
    }
    public void SetSilentLevel(int level)
    {
        m_ShutUpLevel = level;
    }
    public int GetSilentLevel()
    {
        return m_ShutUpLevel;
    }
    
    @Override
    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        // check enabled state
        if(m_Disabled)
        {
            if(message.toLowerCase().equals("!enable"))
            { 
                m_Disabled = false;
            }
            return;
        }
        else
        {
            if(message.toLowerCase().equals("!disable"))
            {
                m_Disabled = true;
                return;
            }
        }
        
        
        CheckCommands(channel, sender, login, hostname, message);
        if(m_ShutUpLevel<=0)
        {
            CheckViolentSpeech(message, sender, channel);
        }
        
    }
    
    public void CheckCommands(String channel, String sender, String login, String hostname, String message)
    {
        if(!message.startsWith("!"))
            return;
        
        String params[] = message.split(" ");
        
        
        String commandName = params[0].substring(1).toLowerCase();
        
        
        for(BotCommand com : m_Commands)
        {
            if(com.GetCommandName().equals(commandName))
            {
                com.Execute(this, channel, sender, login, hostname, message, params);
            }
        }
        
    }
    
    
    private void CheckViolentSpeech(String message, String sender, String channel)
    {
        for(String word: m_ViolentWords)
        {
            if(message.toLowerCase().contains(word))
            {
                sendMessage(channel, "Nana, sowas sagt man aber nicht, " + sender);
                break;
            }
        }
    }

    public boolean checkUserOp(String sender)
    {
        for(User user : getUsers(getChannels()[0]))
            if(user.toString().equals(sender))
                return user.isOp();
        return false;      
    }
    
}
