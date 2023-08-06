package p.jaro.firstplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

public class checkPlayerOpCommand implements CommandExecutor {
    private final FirstPlugin plugin;

    public checkPlayerOpCommand(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length==1){
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target!=null){
                if (target.isOp()){
                    sender.sendMessage(ChatColor.DARK_AQUA+target.getName()+ChatColor.GRAY+" ma operatora.");
                }
                else {
                    sender.sendMessage(ChatColor.DARK_AQUA+target.getName()+ChatColor.GRAY+" nie ma operatora.");
                }
            }
            else {
                sender.sendMessage(ChatColor.DARK_AQUA+args[0]+ChatColor.RED+" jest offline.");
            }
        }
        else {
            sender.sendMessage(ChatColor.GRAY+"Poprawne uzycie: "+ChatColor.DARK_AQUA+"/checkop [nick]");
        }
        return true;
    }
}
