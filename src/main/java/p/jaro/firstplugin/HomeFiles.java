package p.jaro.firstplugin;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class HomeFiles {
    private final FirstPlugin plugin;
    public HomeFiles(FirstPlugin plugin){
        this.plugin = plugin;
    }

    public void init(){
        File homeFile = new File(plugin.getDataFolder(),"homes.yml");
        if(homeFile.exists()){
            YamlConfiguration homeConfig = YamlConfiguration.loadConfiguration(homeFile);
            for (String s : homeConfig.getKeys(false)){
                UUID id = UUID.fromString(s);
                Location home = homeConfig.getLocation(s);
                plugin.addHome(id,home);
            }
        }
    }
    public void terminate(){
        File homeFile = new File(plugin.getDataFolder(),"homes.yml");
        if (!homeFile.exists()){
            try{
                homeFile.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
            YamlConfiguration homeConfig = YamlConfiguration.loadConfiguration(homeFile);
            for (UUID id : plugin.getHomes().keySet()){
                homeConfig.set(id.toString(),plugin.getHome(id));
            }
            try{
                homeConfig.save(homeFile);
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
    public void addHome(UUID id, Location location){
        File homeFile = new File(plugin.getDataFolder(),"homes.yml");
        if (!homeFile.exists()){
            try{
                homeFile.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }

            YamlConfiguration homeConfig = YamlConfiguration.loadConfiguration(homeFile);
            homeConfig.set(id.toString(),location);

            try{
                homeConfig.save(homeFile);
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}