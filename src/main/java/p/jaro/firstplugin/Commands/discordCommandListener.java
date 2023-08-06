package p.jaro.firstplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

public class discordCommandListener implements CommandExecutor {
    private final FirstPlugin plugin;

    public discordCommandListener(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player){
            player.sendMessage(ChatColor.GRAY+"Discord: "+ChatColor.DARK_AQUA+"http://discord.gg/Kmx2FVm");
        }
        else {
            sender.sendMessage(ChatColor.GRAY+"Discord: "+ChatColor.DARK_AQUA+"http://discord.gg/Kmx2FVm");
        }

        return true;

    }
}
