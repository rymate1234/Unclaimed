package net.betterverse.unclaimed;

import net.betterverse.unclaimed.commands.UnclaimedCommmand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Unclaimed extends JavaPlugin {
    
    private Configuration configuration;

    @Override
    public void onEnable() {
        configuration = new Configuration(this);
        Bukkit.getServer().getPluginCommand("unclaimed").setExecutor(new UnclaimedCommmand(this));
        Bukkit.getLogger().info("Loaded " + this.getDescription().getVersion());
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * Reloads configuration file and {@link Configuration} class
     */
    @Override
    public void reloadConfig() {
        super.reloadConfig();
        configuration.reload();
    }
}
