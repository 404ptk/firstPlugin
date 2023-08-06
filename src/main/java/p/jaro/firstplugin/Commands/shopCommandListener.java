package p.jaro.firstplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

public class shopCommandListener implements CommandExecutor {
    private final FirstPlugin plugin;

    public shopCommandListener(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player){
            player.sendMessage(ChatColor.DARK_AQUA+"Witamy w sklepie z efektami!\nMozesz tu wymieniac przedmioty na efekty!\n"+
                    ChatColor.DARK_AQUA+"/haste [czas]"+ChatColor.GRAY+" - efekt Haste II (30s = 2 diamenty)\n"+
                            ChatColor.DARK_AQUA+"..."+ChatColor.GRAY+" - ...\n"+
                            ChatColor.DARK_AQUA+"..."+ChatColor.GRAY+" - ...\n"+
                            ChatColor.DARK_AQUA+"..."+ChatColor.GRAY+" - ...\n"
                    );
        }
        else {
            sender.sendMessage(ChatColor.RED+"Nie jestes graczem!");
        }
        return true;
    }
}
