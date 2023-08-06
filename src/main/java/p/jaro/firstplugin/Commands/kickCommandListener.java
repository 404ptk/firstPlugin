package p.jaro.firstplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

public class kickCommandListener implements CommandExecutor {
    private final FirstPlugin plugin;

    public kickCommandListener(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length==0){
            if (sender.hasPermission("firstplugin.kick")){
                sender.sendMessage(ChatColor.GRAY+"Prawidlowe uzycie: "+ChatColor.DARK_AQUA+"/kick [nick] [powod]");
            }
            else {
                sender.sendMessage(ChatColor.RED+"Nie masz uprawnien!");
            }
        }
        else if(args.length==1){
            if (sender.hasPermission("firstplugin.kick")){
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target!=null){
                    target.kick();
                    Bukkit.broadcastMessage(ChatColor.DARK_RED+target.getName()+ChatColor.RED+" dostal kicka");
                }
                else {
                    sender.sendMessage(ChatColor.RED+args[0]+" jest offline");
                }
            }
        }
        else if (args.length==2){
            if (sender.hasPermission("firstplugin.kick")){
                Player target = Bukkit.getServer().getPlayer(args[0]);
                String kick_message = args[1];
                target.kick();
                Bukkit.broadcastMessage(ChatColor.DARK_RED+target.getName()+ChatColor.RED+" dostal kicka.\n"+
                        ChatColor.GRAY+"Powod: '"+ChatColor.GRAY+ChatColor.ITALIC+kick_message+ChatColor.GRAY+"'");
            }
        }
        else{
            if (sender.hasPermission("firstplugin.kick")){
                sender.sendMessage(ChatColor.GRAY+"Prawidlowe uzycie: "+ChatColor.DARK_AQUA+"/kick [nick] "+ChatColor.GRAY+ChatColor.ITALIC+"[powod]");
            }
            else {
                sender.sendMessage(ChatColor.RED+"Nie masz uprawnien!");
            }
        }
        return true;
    }
}
