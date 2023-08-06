package p.jaro.firstplugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class killDeathListener implements Listener {
    @EventHandler
    public void playerKillplayer(PlayerDeathEvent event){
        Entity killed = event.getEntity();
        Entity killer = event.getEntity().getKiller();
        if (killer instanceof Player player && killed instanceof Player target){
            event.setDeathMessage(null);
            Bukkit.broadcastMessage(ChatColor.DARK_AQUA+player.getName()+ChatColor.RED+" zabil gracza "+ChatColor.DARK_AQUA+target.getName());
        }
        else {
            Player player = event.getEntity();
            EntityDamageEvent.DamageCause damageCause = player.getLastDamageCause().getCause();
            switch (damageCause) {
                case FALL:
                    event.setDeathMessage(null);
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " zginął z powodu upadku.");
                    break;
                case DROWNING:
                    event.setDeathMessage(null);
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " zginął przez utonięcie.");
                    break;
                case FIRE:
                case FIRE_TICK:
                    event.setDeathMessage(null);
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " zginął od ognia.");
                    break;
                case SUICIDE:
                    event.setDeathMessage(null);
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " popełnił samobójstwo.");
                    break;
                case BLOCK_EXPLOSION:
                    event.setDeathMessage(null);
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " zginął w wyniku eksplozji.");
                    break;
                case FALLING_BLOCK:
                    event.setDeathMessage(null);
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " zginął od spadającego bloku.");
                    break;
                case FLY_INTO_WALL:
                    event.setDeathMessage(null);
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " zginął w wyniku uderzenia w ścianę w locie.");
                    break;
                case LAVA:
                    event.setDeathMessage(null);
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " zginął od lawy.");
                    break;
                case POISON:
                    event.setDeathMessage(null);
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " zginął od zatrucia.");
                    break;
                default:
                    event.setDeathMessage(null);
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + player.getName() + ChatColor.RED + " zginął z nieznanej przyczyny.");
                    break;
            }
        }
    }
}
