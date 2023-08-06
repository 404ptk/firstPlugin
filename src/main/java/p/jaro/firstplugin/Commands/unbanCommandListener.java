package p.jaro.firstplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

public class unbanCommandListener implements CommandExecutor {
    private final FirstPlugin plugin;

    public unbanCommandListener(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length==0){
            sender.sendMessage(ChatColor.GRAY+"Prawidlowe uzycie: "+ChatColor.DARK_AQUA+"/unban [nick]");
        }
        if (args.length>1){
            sender.sendMessage(ChatColor.GRAY+"Prawidlowe uzycie: "+ChatColor.DARK_AQUA+"/unban [nick]");
        }
        if (args.length==1){
            //
        }
        return true;
    }
}
