package p.jaro.firstplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

public class opCommandListener implements CommandExecutor {
    private final FirstPlugin plugin;

    public opCommandListener(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("firstplugin.op")){
            if (args.length==0){
                if (sender.isOp()){
                    sender.sendMessage(ChatColor.GRAY+"Posiadasz juz uprawnienia "+ChatColor.RED+"operatora");
                    sender.sendMessage(ChatColor.GRAY+"Prawidlowe uzycie: "+ChatColor.DARK_AQUA+"/op [nick]");
                }
            }
            if (args.length==1){
                if (sender.isOp()){
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if (target!=null){
                        if (target.isOp()){
                            sender.sendMessage(ChatColor.GRAY+"Gracz "+ChatColor.DARK_AQUA+target.getName()+ChatColor.GRAY+
                                    " ma juz uprawnienia "+ChatColor.RED+"operatora");
                        }
                        else {
                            target.setOp(true);
                            target.setPlayerListName(ChatColor.RED+target.getName());
                            sender.sendMessage(ChatColor.GRAY+"Nadano uprawnienia "+ChatColor.RED+"operatora "
                                    +ChatColor.GRAY+"graczowi "+ChatColor.DARK_AQUA+target.getName());
                            target.sendMessage(ChatColor.GRAY+"Przyznano ci uprawnienia "+ChatColor.RED+"operatora");
                        }
                    }
                    else {
                        sender.sendMessage(ChatColor.DARK_AQUA+args[0]+ChatColor.RED+" jest offline.");
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
