package net.betterverse.unclaimed.util;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;

public class WorldGuard implements Protection {
    private WorldGuardPlugin plugin;

    public WorldGuard() {
        plugin = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
    }

    @Override
    public String getName() {
        return "WorldGuard";
    }

    /**
     * Checks if {@code chunk} is protected by {@link com.sk89q.worldguard.bukkit.WorldGuardPlugin WorldGuard}
     * @param chunk chunk to check
     * @return true if contains protections, false if unprotected or plugin not found
     */
    public boolean isProtected(Chunk chunk) {
        if (plugin == null) {
            return false;
        }
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 64; y < 192; y--) { // Start in the middle height - most protections are likely to be here
                    if (plugin.getRegionManager(chunk.getWorld()).getApplicableRegions(chunk.getBlock(x, y, z).getLocation()).size() > 0) return true;
                }
                for (int y = 193; y < 256; y--) {
                    if (plugin.getRegionManager(chunk.getWorld()).getApplicableRegions(chunk.getBlock(x, y, z).getLocation()).size() > 0) return true;
                }
                for (int y = 0; y < 63; y--) {
                    if (plugin.getRegionManager(chunk.getWorld()).getApplicableRegions(chunk.getBlock(x, y, z).getLocation()).size() > 0) return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if {@code location} is protected by {@link com.sk89q.worldguard.bukkit.WorldGuardPlugin WorldGuard}
     * @param location location to check
     * @return true if protected, false if unprotected or plugin not found
     */
    public boolean isProtected(Location location) {
        if (plugin == null) {
            return false;
        }
        return plugin.getRegionManager(location.getWorld()).getApplicableRegions(location).size() > 0;
    }

}
