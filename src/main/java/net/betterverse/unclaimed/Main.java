package net.betterverse.unclaimed;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    
    public static String PREFIX;
    
    public static final Logger log = Logger.getLogger("Minecraft");
    
    //private Econ economy;
    public Config config;
    public Commands cmds;

    @Override
    public void onDisable() {
        log.info(PREFIX + "disabled.");
    }
    
    @Override
    public void onEnable() {
        PluginDescriptionFile pdf = this.getDescription();
        PREFIX = "[" + pdf.getName() + "] ";
        
        config = new Config(this);
        cmds = new Commands(this);
        
        log.info(PREFIX + "version v" + pdf.getVersion() + " is enabled.");
    }
    
}
