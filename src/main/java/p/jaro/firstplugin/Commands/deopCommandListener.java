package p.jaro.firstplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

public class deopCommandListener implements CommandExecutor {
    private final FirstPlugin plugin;

    public deopCommandListener(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("firstplugin.deop")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GRAY + "Prawidlowe uzycie: " + ChatColor.DARK_AQUA + "/deop [nick]");
            } else if (args.length == 1) {
                if (sender.isOp()) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (target != null) {
                        if (target.isOp()) {
                            target.setOp(false);
                            target.sendMessage(ChatColor.GRAY + "Nie posiadasz juz uprawnien " + ChatColor.RED + "operatora");
                            sender.sendMessage(ChatColor.GRAY + "Zabrales uprawnienia " + ChatColor.RED + "operatora "
                                    + ChatColor.GRAY + "graczowi " + ChatColor.DARK_AQUA + target.getName());
                            target.setPlayerListName(ChatColor.YELLOW + target.getName());
                        } else {
                            sender.sendMessage(ChatColor.GRAY + "Gracz " + ChatColor.DARK_AQUA + target.getName() + ChatColor.GRAY
                                    + " nie ma uprawnien " + ChatColor.RED + "operatora");
                        }
                    } else {
                        sender.sendMessage(ChatColor.DARK_AQUA + args[0] + ChatColor.RED + " jest offline.");
                    }
                }
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "Nie masz uprawnien!");
        }
        return true;
    }
}
