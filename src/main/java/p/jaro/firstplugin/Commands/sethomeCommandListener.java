package p.jaro.firstplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

import java.util.UUID;

public class sethomeCommandListener implements CommandExecutor {
    private final FirstPlugin plugin;
    public sethomeCommandListener(FirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            UUID id = player.getUniqueId();
            Location location = player.getLocation();

            if(plugin.hasHome(id)){
                player.sendMessage(ChatColor.DARK_AQUA+"Twoj poprzedni home zostal nadpisany");
            }

            plugin.addHome(id,location);
            player.sendMessage(ChatColor.GOLD+"Ustawiono home");

            plugin.getFiles().addHome(id,location);

        }

        return true;
    }
}
