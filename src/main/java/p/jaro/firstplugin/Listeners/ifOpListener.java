package p.jaro.firstplugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ifOpListener implements Listener {
    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event){
        Player player = (Player) event.getPlayer();
        String message = event.getMessage();
        if (player.isOp()){
            //moge to poprawic jak napisze wlasna komende na opa, wtedy gdy kogos bede opowal z komenda bede dawal mu kolor na tabie i na odwrot
            player.setPlayerListName(ChatColor.RED+player.getName());
            event.setFormat(ChatColor.RED+player.getName()+": "+ChatColor.GRAY+message);
        }
        else {
            player.setPlayerListName(ChatColor.YELLOW+player.getName());
            event.setFormat(ChatColor.YELLOW+player.getName()+": "+ChatColor.GRAY+message);
        }
    }
}
