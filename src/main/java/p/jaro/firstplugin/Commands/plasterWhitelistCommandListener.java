package p.jaro.firstplugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

public class plasterWhitelistCommandListener implements CommandExecutor {
    private final FirstPlugin plugin;
    public plasterWhitelistCommandListener(FirstPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("firstplugin.plaster")){
            if(args.length==0 || args.length>2){
                if (sender instanceof Player player){
                    if (player.hasPermission("firstplugin.plaster")){
                        if (Bukkit.hasWhitelist()){
                            player.sendMessage(ChatColor.GRAY+"Aktualny stan whitelisty: "+ChatColor.GREEN+"ON");
                        }
                        else{
                            player.sendMessage(ChatColor.GRAY+"Aktualny stan whitelisty: "+ChatColor.RED+"OFF");
                        }
                        player.sendMessage(ChatColor.GRAY+"Prawidlowe uzycie: "+ChatColor.DARK_AQUA+"/plaster on/off");
                    }
                    else if (!player.hasPermission("firstplugin.plaster")){
                        player.sendMessage(ChatColor.RED+"Nie masz dostepu do tej komendy! Mozesz zobaczyc tylko stan whitelisty\n");
                        if (Bukkit.hasWhitelist()){
                            player.sendMessage(ChatColor.GRAY+"Aktualny stan whitelisty: "+ChatColor.GREEN+"ON");
                        }
                        else{
                            player.sendMessage(ChatColor.GRAY+"Aktualny stan whitelisty: "+ChatColor.RED+"OFF");
                        }
                    }
                }
                else if (sender.hasPermission("firstplugin.plaster")){
                    if (Bukkit.hasWhitelist()){
                        sender.sendMessage(ChatColor.GRAY+"Aktualny stan whitelisty: "+ChatColor.GREEN+"ON");
                    }
                    else{
                        sender.sendMessage(ChatColor.GRAY+"Aktualny stan whitelisty: "+ChatColor.RED+"OFF");
                    }
                    sender.sendMessage(ChatColor.GRAY+"Prawidlowe uzycie: "+ChatColor.DARK_AQUA+"/plaster on/off/remove/add");
                }
            }
            if (args.length==1) {
                if (args[0].equalsIgnoreCase("help")) {
                    if (sender.hasPermission("firstplugin.plaster")) {
                        sender.sendMessage(ChatColor.GRAY+"Aby odpalic whiteliste: "+ChatColor.DARK_AQUA+"/plaster on\n"+
                                ChatColor.GRAY+"Aby wylaczyc: "+ChatColor.DARK_AQUA+"/plaster off\n"+
                                ChatColor.GRAY+"Dodawanie do whitelisty: "+ChatColor.DARK_AQUA+"/plaster add [nick]\n"+
                                ChatColor.GRAY+"Usuwanie z whitelisty: "+ChatColor.DARK_AQUA+"/plaster remove [nick]");
                        if (Bukkit.hasWhitelist()) {
                            sender.sendMessage(ChatColor.GRAY + "Aktualny stan whitelisty: " + ChatColor.GREEN + "ON");
                        } else {
                            sender.sendMessage(ChatColor.GRAY + "Aktualny stan whitelisty: " + ChatColor.RED + "OFF");
                        }
                    }
                }
                else if (args[0].equalsIgnoreCase("on")) {
                    if (sender.hasPermission("firstplugin.plaster")) {
                        Bukkit.setWhitelist(true);
                        Bukkit.broadcastMessage(ChatColor.GRAY + "Mozecie grac spokojnie - " + ChatColor.GREEN + "Whitelist ON");
                    }
                    else if (!sender.hasPermission("firstplugin.plaster")){
                        sender.sendMessage(ChatColor.RED+"Nie masz dostepu do tej komendy! Mozesz zobaczyc tylko stan whitelisty\n");
                        if (Bukkit.hasWhitelist()){
                            sender.sendMessage(ChatColor.GRAY+"Aktualny stan whitelisty: "+ChatColor.GREEN+"ON");
                        }
                        else{
                            sender.sendMessage(ChatColor.GRAY+"Aktualny stan whitelisty: "+ChatColor.RED+"OFF");
                        }
                    }
                } else if(args[0].equalsIgnoreCase("off")){
                    if (sender.hasPermission("firstplugin.plaster")){
                        Bukkit.setWhitelist(false);

                    }
                }
                else if (args[0].equalsIgnoreCase("add")) {
                    if (sender.hasPermission("firstplugin.plaster")) {
                        sender.sendMessage(ChatColor.GRAY+"Poprawne uzycie: "+ChatColor.DARK_AQUA+"/plaster add [nick]");
                    }
                    else {
                        sender.sendMessage(ChatColor.RED+"Nie masz uprawnien!");
                    }
                } else if (args[0].equalsIgnoreCase("remove")) {
                    if (sender.hasPermission("firstplugin.plaster")) {
                        sender.sendMessage(ChatColor.GRAY+"Poprawne uzycie: "+ChatColor.DARK_AQUA+"/plaster remove [nick]");
                    }
                    else {
                        sender.sendMessage(ChatColor.RED+"Nie masz uprawnien!");
                    }
                }
            }
            else if (args.length==2){
                Player target = Bukkit.getServer().getPlayer(args[0]);
                String addNickname = args[1];
                if (sender.hasPermission("firstplugin.plaster")){
                    if (args[1].equalsIgnoreCase("add")){
                        if (target!=null){
                            if (Bukkit.hasWhitelist()){
                                if (Bukkit.getWhitelistedPlayers().contains(target)){
                                    sender.sendMessage(ChatColor.DARK_GRAY+args[1]+ChatColor.GRAY+" jest juz na whiteliscie");
                                }
                                else {
                                    target.setWhitelisted(true);
                                    sender.sendMessage(ChatColor.GRAY+"Dodano "+ChatColor.DARK_GRAY+target.getName()+ChatColor.GRAY+" do whitelisty");
                                }
                            }
                            else {
                                sender.sendMessage(ChatColor.GRAY+"Whitelista jest wylaczona. "+ChatColor.DARK_AQUA+"/plaster on");
                            }
                        }
                        else {
                            if (Bukkit.hasWhitelist()){
                                if (Bukkit.getWhitelistedPlayers().contains(addNickname)){
                                    sender.sendMessage(ChatColor.DARK_GRAY+addNickname+ChatColor.GRAY+" jest juz na whiteliscie");
                                }
                            }
                            else {
                                sender.sendMessage(ChatColor.GRAY+"podczas prac");
                                //tu chce dodac "addNickname/target/args[1]" do whitelisty, a uzytkownik jest offline
                            }
                        }
                    }
                    else if (args[1].equalsIgnoreCase("remove")){
                        if (sender.hasPermission("firstplugin.plaster")){
                            if (target!=null){
                                if (Bukkit.hasWhitelist()){
                                    if (Bukkit.getWhitelistedPlayers().contains(target)){
                                        target.setWhitelisted(false);
                                        sender.sendMessage(ChatColor.GRAY+"Usunieto "+ChatColor.DARK_GRAY+target.getName()+ChatColor.GRAY+" z whitelisty");
                                    }
                                    else {
                                        sender.sendMessage(ChatColor.DARK_GRAY+target.getName()+ChatColor.GRAY+" nie jest dodany na whiteliste");
                                    }
                                }
                                else {
                                    sender.sendMessage(ChatColor.GRAY+"Whitelista jest wylaczona. "+ChatColor.DARK_AQUA+"/plaster on");
                                }
                            }
                            else {
                                if (Bukkit.hasWhitelist()){
                                    if (Bukkit.getWhitelistedPlayers().contains(addNickname)){
                                        sender.sendMessage(ChatColor.DARK_GRAY+addNickname+ChatColor.GRAY+" jest juz na whiteliscie");
                                    }
                                }
                                else {
                                    sender.sendMessage(ChatColor.GRAY+"podczas prac");
                                    //tu chce usunac "addNickname/target/args[1]" do whitelisty, a uzytkownik jest offline
                                }
                            }
                        }
                    }
                }
                else {
                    sender.sendMessage(ChatColor.RED+"Nie masz uprawnien!");
                }
            }
        }
        else {
            sender.sendMessage(ChatColor.RED+"Nie masz uprawnien!");
        }
        return true;
    }
}
