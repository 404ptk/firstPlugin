package p.jaro.firstplugin.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import p.jaro.firstplugin.FirstPlugin;

import java.util.UUID;

public class PlayerListener implements Listener {
    private final FirstPlugin plugin;
    public PlayerListener(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        if(!event.getFrom().getBlock().equals(event.getTo().getBlock())){
            Player player = event.getPlayer();
            UUID id = player.getUniqueId();
            if(plugin.isQued(id)){
                plugin.cancelQue(id);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            UUID id = player.getUniqueId();
            if(plugin.isQued(id)){
                plugin.cancelQue(id);
            }
        }
    }
}
