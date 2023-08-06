package p.jaro.firstplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.Runnables.spawnRunnable;

public class spawnCommandListener implements CommandExecutor {
    private final Plugin plugin;

    public spawnCommandListener(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player player){
            new spawnRunnable(plugin,player).runTaskTimer(plugin,0L,20L);

        }
        return true;
    }
}
