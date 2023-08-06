package p.jaro.firstplugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import p.jaro.firstplugin.FirstPlugin;

import java.util.UUID;

public class homeCommandListener implements CommandExecutor {
    private final FirstPlugin plugin;
    public homeCommandListener(FirstPlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player){
            UUID id = player.getUniqueId();

            if (!plugin.hasHome(id)){
                player.sendMessage(ChatColor.RED+"Nie masz ustawionego home!");
            }
            else{
                plugin.addQue(id);
                new BukkitRunnable() {
                    int delay = 3;

                    @Override
                    public void run() {
                        if (plugin.isQued(id)){
                            if(delay==0){
                                player.teleport(plugin.getHome(id));
                                player.sendMessage(ChatColor.DARK_AQUA+"Teleportuje na home...");
                                plugin.cancelQue(id);
                                this.cancel();
                            }
                            else {
                                player.sendMessage(ChatColor.GRAY+"Zostaniesz przeteleportowany za "+ChatColor.DARK_AQUA+delay);
                                delay=delay-1;
                            }
                        }
                        else {
                            player.sendMessage(ChatColor.RED+"Teleportacja przerwana!");
                            this.cancel();
                        }
                    }
                }.runTaskTimer(plugin, 0L, 20L);


            }
        }


        return true;
    }
}
