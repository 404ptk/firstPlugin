package p.jaro.firstplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class helpCommandListener implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            player.sendMessage(ChatColor.DARK_AQUA+"\nUTOPIASZ PLUGIN" +ChatColor.GRAY+" v0.02"+ChatColor.DARK_GRAY+" [1.19.4]\n"+
                    ChatColor.GRAY+"Discord:"+ChatColor.DARK_AQUA+" http://discord.gg/Kmx2FVm\n"+
//                    "Aby uzyskac pomoc wpisz: " + ChatColor.DARK_AQUA+"/utopiasz help"+
                    ChatColor.GRAY+"\nDostepne komendy:"+
                    ChatColor.DARK_AQUA+"\n/spawn" + ChatColor.GRAY+" - teleportacja na spawn"+
                    ChatColor.DARK_AQUA+"\n/sethome" + ChatColor.GRAY+" - ustawianie home"+
                    ChatColor.DARK_AQUA+"\n/home" + ChatColor.GRAY+" - teleportacja na home"+
                    ChatColor.DARK_AQUA+"\n/pv" + ChatColor.GRAY+" - prywatna wiadomosc"+
                    ChatColor.DARK_AQUA+"\n/tpa" + ChatColor.GRAY+" - tepanie do graczy"+ChatColor.DARK_GRAY+" (Podczas prac)"+
                    ChatColor.DARK_AQUA+"\n/sklep" + ChatColor.GRAY+" - sklep z efektami"+ChatColor.DARK_GRAY+" (Podczas prac)"+
                    ChatColor.DARK_AQUA+"\n/discord" + ChatColor.GRAY+" - link do discorda"+
                    ChatColor.DARK_AQUA+"\n/checkop" + ChatColor.GRAY+" - sprawdzanie czy dany gracz ma operatora"+
                    ChatColor.DARK_AQUA+"\n/kick" + ChatColor.GRAY+" - kick "+ChatColor.RED+"(OP)"+
                    ChatColor.DARK_AQUA+"\n/ban" + ChatColor.GRAY+" - ban na nick "+ChatColor.RED+"(OP)"+
                    ChatColor.DARK_AQUA+"\n/gm" + ChatColor.GRAY+" - szybka zmiana gamemoda "+ChatColor.RED+"(OP)"+
                    ChatColor.DARK_AQUA+"\n/fly" + ChatColor.GRAY+" - latanie "+ChatColor.RED+"(OP)"+
                    ChatColor.DARK_AQUA+"\n/god" + ChatColor.GRAY+" - god mode "+ChatColor.RED+"(OP)"+
                    ChatColor.DARK_AQUA+"\n/plaster" + ChatColor.GRAY+" - whitelist on/off "+ChatColor.RED+"(OP)"+
                    ChatColor.GRAY+"\nPomoc: "+ChatColor.DARK_AQUA+"/[komenda] help"+
                    "");
        }
        return true;
    }
}
