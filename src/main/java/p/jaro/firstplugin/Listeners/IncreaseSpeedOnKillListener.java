package p.jaro.firstplugin.Listeners;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IncreaseSpeedOnKillListener implements Listener {
    @EventHandler
    public void onKill(EntityDeathEvent event){
        Player player = event.getEntity().getKiller();
        LivingEntity e = event.getEntity();

        if(player != null){
            event.getEntityType();
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 3*20, 0));
        }
    }
}
