package p.jaro.firstplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

public class GodCommandListener implements CommandExecutor {
    private final Plugin plugin;

    public GodCommandListener(FirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("firstplugin.god")){
            if(args.length==0){
                if(sender instanceof Player player){
                    if (player.hasPermission("firstplugin.god")){
                        if(player.isInvulnerable()){
                            player.setInvulnerable(false);
                            player.sendMessage(ChatColor.RED+"Wylaczono "+ChatColor.GRAY+"niesmiertelnosc");
                        }
                        else{
                            player.setInvulnerable(true);
                            player.sendMessage(ChatColor.GREEN+"Wlaczono "+ChatColor.GRAY+"niesmiertelnosc");
                        }
                    }
                }
            }
            else if(args.length==1){
                if(args[0].equalsIgnoreCase("help")){
                    if (sender instanceof Player player){
                        if (player.hasPermission("firstplugin.god")){
                            player.sendMessage(ChatColor.GRAY+"Aby dac komus god mode wpisz "+ChatColor.DARK_AQUA+"/god [nick]\n"+
                                    ChatColor.GRAY+"Aby dac komus czasowo god mode wpisz "+ChatColor.DARK_AQUA+"/god [nick] [czas]");
                        }
                    }
                }
                else{
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (target != null) {
                        if(sender instanceof Player player){
                            if (player.hasPermission("firstplugin.god")){
                                if(target.isInvulnerable()){
                                    target.setInvulnerable(false);
                                    target.sendMessage(ChatColor.RED+"Wylaczono "+ChatColor.GRAY+"niesmiertelnosc");
                                    player.sendMessage(ChatColor.RED+"Wylaczono "+ChatColor.GRAY+"niesmiertelnosc graczowi "+ChatColor.DARK_AQUA+target.getName());
                                }
                                else{
                                    target.setInvulnerable(true);
                                    target.sendMessage(ChatColor.GREEN+"Wlaczono "+ChatColor.GRAY+"niesmiertelnosc");
                                    player.sendMessage(ChatColor.GREEN+"Wlaczono "+ChatColor.GRAY+"niesmiertelnosc graczowi "+ChatColor.DARK_AQUA+target.getName());
                                }
                            }
                        }
                    }
                    else if (target==null){
                        if (sender instanceof Player player){
                            if (player.hasPermission("firstplugin.god")){
                                player.sendMessage(ChatColor.DARK_AQUA+args[0]+ChatColor.RED+" jest offline");
                            }
                        }
                    }
                }
            }
            else if (args.length==2){
                int time = Integer.parseInt(args[1]);
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if(sender instanceof Player player){
                    if (player.hasPermission("firstplugin.god")){
                        if (target.isOnline()){
                            target.setInvulnerable(true);
                            target.sendMessage(ChatColor.GREEN+"Wlaczono niesmiertelnosc na "+ChatColor.DARK_AQUA+"%d ".formatted(time)+ChatColor.GREEN+"sekund/y");
                            Bukkit.getScheduler().runTaskLater(plugin,()->{
                                target.setInvulnerable(false);
                                target.sendMessage(ChatColor.RED+"Niesmiertelnosc wygasla");
                            },time*20L);
                        }
                        else {
                            if (player.hasPermission("firstplugin.god")){
                                player.sendMessage(ChatColor.DARK_AQUA+args[0]+ChatColor.RED+" jest offline");
                            }
                        }
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
