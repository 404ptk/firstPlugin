package p.jaro.firstplugin.Listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import p.jaro.firstplugin.FirstPlugin;

import java.util.List;

public class LightningSwordListener implements Listener {
    private NamespacedKey lightningSwordKey;

    public LightningSwordListener(FirstPlugin plugin){
        lightningSwordKey=new NamespacedKey(plugin, "lightning_sword");
    }

    public ItemStack getLightningSword(){
        ItemStack sword = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta = sword.getItemMeta();

        Component displayName = Component.text("Lightning Sword")
                .decoration(TextDecoration.ITALIC,false)
                .color(TextColor.color(6, 120, 200));
        meta.displayName(displayName);

        meta.lore(List.of(
                Component.text(ChatColor.DARK_RED+""+ChatColor.BOLD+"Zdobyty nielegalnie!"),
                Component.text(ChatColor.GRAY+"Uderzenie stwarza "+ChatColor.DARK_BLUE+"piorun!")
        ));

        meta.addEnchant(Enchantment.LUCK,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.getPersistentDataContainer().set(lightningSwordKey, PersistentDataType.INTEGER, 1);
        sword.setItemMeta(meta);
        return sword;
    }


    @EventHandler
    public void onMobHit(EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof Player player){ // czy to gracz
            if(event.getEntity() instanceof LivingEntity mob){ // czy jest mobem (ten co dostaje dmg)
                ItemStack itemInHand = player.getInventory().getItemInMainHand(); // sprawdzam item w rece
                if(itemInHand.isSimilar(getLightningSword())){
                    World world = mob.getWorld(); // swiat
                    world.strikeLightning(mob.getLocation()); // piorun w lokalizacji
                }
            }
        }
    }
}
