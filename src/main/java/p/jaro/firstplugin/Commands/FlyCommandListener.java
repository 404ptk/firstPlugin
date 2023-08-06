package p.jaro.firstplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FlyCommandListener implements CommandExecutor {
    private final Plugin plugin;
    private ArrayList<Player> list_of_flying_player = new ArrayList<>();


    public FlyCommandListener(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("firstplugin.fly")){
            if(args.length==0){
                if(sender instanceof Player player){
                    if(player.hasPermission("firstplugin.fly")){
                        if(list_of_flying_player.contains(player)){
                            list_of_flying_player.remove(player);
                            player.setAllowFlight(false);
                            player.sendMessage(ChatColor.RED+"Wylaczono fly");
                        }
                        else if(!list_of_flying_player.contains(player)){
                            list_of_flying_player.add(player);
                            player.setAllowFlight(true);
                            player.sendMessage(ChatColor.GREEN+"Wlaczono fly");
                        }
                    }
                    else{
                        player.sendMessage(ChatColor.RED+"Nie masz permisji!");
                    }
                }
            }
            else if(args.length==1){
                Player target = Bukkit.getPlayer(args[0]);
                if(sender instanceof Player player){
                    if(player.hasPermission("firstplugin.fly")){
                        if(list_of_flying_player.contains(target)){
                            list_of_flying_player.remove(target);
                            target.setAllowFlight(false);
                            player.sendMessage(ChatColor.RED+"Wylaczono "+ChatColor.GRAY+"fly dla gracza "+ChatColor.DARK_AQUA+target.getName());
                            target.sendMessage(ChatColor.RED+"Wylaczono fly");
                        }
                        else if(!list_of_flying_player.contains(target)){
                            list_of_flying_player.add(target);
                            target.setAllowFlight(true);
                            player.sendMessage(ChatColor.GREEN+"Wlaczono "+ChatColor.GRAY+"fly dla gracza "+ChatColor.DARK_AQUA+target.getName());
                            target.sendMessage(ChatColor.GREEN+"Wlaczono fly");
                        }
                    }
                    else{
                        player.sendMessage(ChatColor.RED+"Nie masz permisji!");
                    }
                }
            }
        }
        else {
            sender.sendMessage(ChatColor.RED+"Nie masz uprawnien!");
        }
        return true;
    }
}
