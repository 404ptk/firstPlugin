package p.jaro.firstplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.Listeners.LightningSwordListener;

public class swordCommandListener implements CommandExecutor {
    private LightningSwordListener lightningSwordListener;

    public swordCommandListener(LightningSwordListener lightningSwordListener){
        this.lightningSwordListener = lightningSwordListener;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("firstplugin.sword")){
            if(sender instanceof Player player){
                player.getInventory().addItem(lightningSwordListener.getLightningSword());
                player.sendMessage(ChatColor.DARK_AQUA+"Dodano lightning sword");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED+"Nie masz uprawnien!");
        }
        return true;
    }
}
