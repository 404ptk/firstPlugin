package p.jaro.firstplugin;

import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import p.jaro.firstplugin.Commands.*;
import p.jaro.firstplugin.Listeners.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class FirstPlugin extends JavaPlugin implements Listener {
    private LightningSwordListener lightningSwordListener;
    private HashMap<UUID, Location> homes;
    private HomeFiles files;
    private List<UUID> que;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.homes = new HashMap<>();
        this.files = new HomeFiles(this);
        this.que = new ArrayList<>();
        this.files.init();
        if(!getDataFolder().exists()){
            getDataFolder().mkdir();
        }

        this.lightningSwordListener = new LightningSwordListener(this);
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(lightningSwordListener,this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(),this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(),this);
        getServer().getPluginManager().registerEvents(new IncreaseSpeedOnKillListener(),this);
        getServer().getPluginManager().registerEvents(new PlayerListener(this),this);
        getServer().getPluginManager().registerEvents(new ifOpListener(),this);
        getServer().getPluginManager().registerEvents(new killDeathListener(),this);
        //getServer().getPluginManager().registerEvents(new banListener(),this);

        getCommand("god").setExecutor(new GodCommandListener(this));
        getCommand("utopiasz").setExecutor(new helpCommandListener());
        getCommand("sword").setExecutor(new swordCommandListener(lightningSwordListener));
        getCommand("spawn").setExecutor(new spawnCommandListener(this));
        getCommand("fly").setExecutor(new FlyCommandListener(this));
        getCommand("sethome").setExecutor(new sethomeCommandListener(this));
        getCommand("home").setExecutor(new homeCommandListener(this));
        getCommand("gm").setExecutor(new gmCommandListener(this));
        getCommand("plaster").setExecutor(new plasterWhitelistCommandListener(this));
        getCommand("directmessage").setExecutor(new pvMessageCommandListener(this));
        getCommand("discord").setExecutor(new discordCommandListener(this));
        getCommand("kick").setExecutor(new kickCommandListener(this));
        getCommand("ban").setExecutor(new banCommandListener(this));
        getCommand("unban").setExecutor(new unbanCommandListener(this));
        getCommand("sklep").setExecutor(new shopCommandListener(this));
        getCommand("checkop").setExecutor(new checkPlayerOpCommand(this));
        getCommand("op").setExecutor(new opCommandListener(this));
        getCommand("deop").setExecutor(new deopCommandListener(this));
    }

    public void addHome(UUID id, Location location){
        this.homes.put(id,location);
    }
    public Location getHome(UUID id){
        return this.homes.get(id);
    }
    public boolean hasHome(UUID id){
        return this.homes.containsKey(id);
    }
    public HashMap<UUID, Location> getHomes(){
        return homes;
    }

    public HomeFiles getFiles() {
        return files;
    }
    public void addQue(UUID id){
        this.que.add(id);
    }
    public void cancelQue(UUID id){
        this.que.remove(id);
    }
    public boolean isQued(UUID id){
        return this.que.contains(id);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.files.terminate();
    }
}
