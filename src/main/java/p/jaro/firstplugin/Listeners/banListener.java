package p.jaro.firstplugin.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class banListener implements Listener {
    @EventHandler
    public void ifBanned(PlayerLoginEvent event){
        if (event.getResult()==PlayerLoginEvent.Result.KICK_BANNED){
            event.setKickMessage("");
        }
    }
}
