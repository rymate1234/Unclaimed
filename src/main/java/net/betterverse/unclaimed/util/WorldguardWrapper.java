package net.betterverse.unclaimed.util;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.bukkit.BukkitPlayer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WorldguardWrapper implements ProtectionProvider {
    private WorldGuardPlugin plugin;

    public WorldguardWrapper() throws ClassNotFoundException {
        plugin = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
        if (plugin == null) {
            throw new ClassNotFoundException();
        }
    }

    @Override
    public String getMessage(Chunk chunk) {
        if (plugin == null) {
            return null;
        }
       /* ApplicableRegionSet regions;
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 64; y < 192; y--) { // Start in the middle height - most protections are likely to be here
                    regions = plugin.getRegionManager(chunk.getWorld()).getApplicableRegions(chunk.getBlock(x, y, z).getLocation());
                    if (regions.size() > 0) {
                        return regions.iterator().next().getId();
                    }
                }
                for (int y = 193; y < 256; y--) {
                    regions = plugin.getRegionManager(chunk.getWorld()).getApplicableRegions(chunk.getBlock(x, y, z).getLocation());
                    if (regions.size() > 0) {
                        return regions.iterator().next().getId();
                    }
                }
                for (int y = 0; y < 63; y--) {
                    regions = plugin.getRegionManager(chunk.getWorld()).getApplicableRegions(chunk.getBlock(x, y, z).getLocation());
                    if (regions.size() > 0) {
                        return regions.iterator().next().getId();
                    }
                }
            }
        }*/
        return "Claimed by WorldGuard.";
    }

    @Override
    public String getMessage(Location location) {
        if (plugin == null) {
            return null;
        }
        ApplicableRegionSet regions = plugin.getRegionManager(location.getWorld()).getApplicableRegions(location);
        if (regions.size() > 0) {
            return regions.iterator().next().getId();
        }
        return null;
    }

    @Override
    public String getName() {
        return "WorldGuard";
    }

    /**
     * Checks if {@code chunk} is protected by {@link com.sk89q.worldguard.bukkit.WorldGuardPlugin WorldguardWrapper}
     *
     * @param chunk chunk to check
     * @return true if contains protections, false if unprotected or plugin not found
     */
    @Override
    public boolean isProtected(Chunk chunk) {
        if (plugin == null) {
            return false;
        }
        
        return plugin.getRegionManager(chunk.getWorld()).getApplicableRegions(chunk.getBlock(0, 0, 0).getLocation()).size() > 0;
        //Vector v = toVector();
        //return plugin.canBuild(null, null)
        /*for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 64; y < 192; y--) { // Start in the middle height - most protections are likely to be here
                    if (plugin.getRegionManager(chunk.getWorld()).getApplicableRegions(chunk.getBlock(x, y, z).getLocation()).size() > 0)
                        return true;
                }
                for (int y = 193; y < 256; y--) {
                    if (plugin.getRegionManager(chunk.getWorld()).getApplicableRegions(chunk.getBlock(x, y, z).getLocation()).size() > 0)
                        return true;
                }
                for (int y = 0; y < 63; y--) {
                    if (plugin.getRegionManager(chunk.getWorld()).getApplicableRegions(chunk.getBlock(x, y, z).getLocation()).size() > 0)
                        return true;
                }
            }
        }
        return false;*/
    }

    /**
     * Checks if {@code location} is protected by {@link com.sk89q.worldguard.bukkit.WorldGuardPlugin WorldguardWrapper}
     *
     * @param location location to check
     * @return true if protected, false if unprotected or plugin not found
     */
    @Override
    public boolean isProtected(Location location) {
        if (plugin == null) {
            return false;
        }
        return plugin.getRegionManager(location.getWorld()).getApplicableRegions(location).size() > 0;
    }

    @Override
    public boolean isProtectedFrom(Player player, Location location) {
            return plugin.getRegionManager(location.getWorld()).getApplicableRegions(location).isMemberOfAll(plugin.wrapPlayer(player));
    }

}