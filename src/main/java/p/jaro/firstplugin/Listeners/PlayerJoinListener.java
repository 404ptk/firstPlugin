package p.jaro.firstplugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(null);
        Player player = (Player) event.getPlayer();
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"&2+ &8"+event.getPlayer().getName()));
        if (player.isOp()){
            player.setPlayerListName(ChatColor.RED+player.getName());
        }
        else if(!(player.isOp())){
            player.setPlayerListName(ChatColor.YELLOW+player.getName());
        }
    }
}
