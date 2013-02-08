package net.betterverse.unclaimed.util;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CheckProtection {

    /**
     * Checks whether a chunk contains protections protected
     *
     * @param chunk {@link org.bukkit.Chunk} to check
     * @return true if protected, false if not or no plugins registered
     */
    public static ProtectionInfo isProtected(Chunk chunk) {
        for (Protection protection : UnclaimedRegistry.getProtections()) {
            if (protection.isProtected(chunk)) {
                return new ProtectionInfo(
                        protection.getName() != null ? protection.getName() : protection.getClass().getSimpleName(),
                        protection.getMessage(chunk) != null ? protection.getMessage(chunk) : null
                );
            }
        }
        return ProtectionInfo.UNPROTECTED;
    }

    /**
     * Checks whether a specific {@link org.bukkit.Location location} is protected
     *
     * @param location {@link org.bukkit.Location} to check
     * @return true if protected, false if not or no plugins registered
     */
    public static ProtectionInfo isProtected(Location location) {
        for (Protection protection : UnclaimedRegistry.getProtections()) {
            if (protection.isProtected(location)) {
                return new ProtectionInfo(
                        protection.getName() != null ? protection.getName() : protection.getClass().getSimpleName(),
                        protection.getMessage(location) != null ? protection.getMessage(location) : null
                        );
            }
        }
        return ProtectionInfo.UNPROTECTED;
    }
    
    /**
     * Checks whether a specific {@link org.bukkit.Location location} is protected from a specific {@link org.bukkit.entity.Player}
     *
     * @param player {@link org.bukkit.entity.Player} to check
     * @param location {@link org.bukkit.Location} to check
     * @return true if protected, false if not or no plugins registered
     */
    public static ProtectionInfo isProtectedFrom(Player player, Location location)
    {
        for (Protection protection : UnclaimedRegistry.getProtections()) {
            if (protection.isProtectedFrom(player, location)) {
            	ProtectionInfo info = new ProtectionInfo(
                        protection.getName() != null ? protection.getName() : protection.getClass().getSimpleName(),
                        protection.getMessage(location) != null ? protection.getMessage(location) : null
                        );
            	
            	System.out.println("PROTECTION INFO: " + info.toString());
            	
            	return info;
            }
        }
        return ProtectionInfo.UNPROTECTED;
    }
}
