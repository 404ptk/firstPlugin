package p.jaro.firstplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

public class gmCommandListener implements CommandExecutor {
    private final FirstPlugin plugin;

    public gmCommandListener(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length==0){
            if (sender instanceof Player player){
                if (sender.hasPermission("firstplugin.gm")){
                    if(player.getGameMode()== GameMode.SURVIVAL){
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(ChatColor.GRAY+"Zmieniono tryb gry na "+ChatColor.DARK_AQUA+"Creative");
                    }
                    else if(player.getGameMode()==GameMode.CREATIVE){
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.GRAY+"Zmieniono tryb gry na "+ChatColor.DARK_AQUA+"Survival");
                    }
                }
            }
        }
        if (args.length==1){
            Player target = Bukkit.getPlayer(args[0]);
            if (sender instanceof Player player){
                if (target!=null){
                    if (sender.hasPermission("firstplugin.gm")){
                        if (target.isOnline()){
                            if(target.getGameMode()== GameMode.SURVIVAL){
                                target.setGameMode(GameMode.CREATIVE);
                                sender.sendMessage(ChatColor.GRAY+"Zmieniono tryb gry na "+ChatColor.DARK_AQUA+"Creative "+ChatColor.GRAY+"dla gracza "+ChatColor.DARK_AQUA+target.getName());
                                target.sendMessage(ChatColor.GRAY+"Zmieniono tryb gry na "+ChatColor.DARK_AQUA+"Creative");
                            }
                            else if(target.getGameMode()==GameMode.CREATIVE){
                                target.setGameMode(GameMode.SURVIVAL);
                                sender.sendMessage(ChatColor.GRAY+"Zmieniono tryb gry na "+ChatColor.DARK_AQUA+"Survival "+ChatColor.GRAY+"dla gracza "+ChatColor.DARK_AQUA+target.getName());
                                target.sendMessage(ChatColor.GRAY+"Zmieniono tryb gry na "+ChatColor.DARK_AQUA+"Survival");
                            }
                        }
                    }
                }
                else {
                    sender.sendMessage(ChatColor.DARK_AQUA+args[0]+ChatColor.RED+" jest offline");
                }
            }
        }
        return true;
    }
}
