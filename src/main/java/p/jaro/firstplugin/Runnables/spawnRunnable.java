package p.jaro.firstplugin.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class spawnRunnable extends BukkitRunnable implements Listener {
    private int counter=3;
    private final Player player;
    private final Location teleportSpawnLocation;

    public spawnRunnable(Plugin plugin, Player player) {
        this.player=player;
        this.teleportSpawnLocation=player.getLocation().clone();
        Bukkit.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @Override
    public void run(){
        World world = Bukkit.getWorlds().get(0);
        if(counter==0){
            player.sendMessage(ChatColor.DARK_AQUA+"Teleportacja na spawn...");
            player.teleport(world.getSpawnLocation());
            cancel();
        }else{
            player.sendMessage(ChatColor.GRAY+"Zostaniesz przeteleportowany za "+ChatColor.DARK_AQUA+counter);
            counter=counter-1;
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        if(!event.getPlayer().getUniqueId().equals(player.getUniqueId())){
            return;
        }
        if (player.getLocation().distanceSquared(teleportSpawnLocation)>0.5*0.5){
            player.sendMessage(ChatColor.RED+"Wykryto ruch! "+ChatColor.GRAY+"Przerywam teleportacje.");
            cancel();
        }
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event){
        if(event.getDamager().getUniqueId().equals(player.getUniqueId())){
            player.sendMessage(ChatColor.RED+"Otrzymales obrazenia! "+ChatColor.GRAY+"Przerywam teleportacje.");
            cancel();
        }
        else if(event.getDamager().getUniqueId().equals(player.getUniqueId())){
            player.sendMessage(ChatColor.RED+"Zadales obrazenia! "+ChatColor.GRAY+"Przerywam teleportacje.");
            cancel();
        }
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event){
        if(event.getEntity().getUniqueId().equals(player.getUniqueId())){
            player.sendMessage(ChatColor.RED+"Otrzymales obrazenia! "+ChatColor.GRAY+"Przerywam teleportacje.");
            cancel();
        }
    }

    @Override
    public synchronized void cancel() throws IllegalStateException {
        HandlerList.unregisterAll(this);
        super.cancel();
    }
}

