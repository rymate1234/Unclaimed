package net.betterverse.unclaimed;

import net.betterverse.unclaimed.util.CheckProtection;
import net.betterverse.unclaimed.util.ProtectionInfo;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEvent;


public class Listener implements org.bukkit.event.Listener {

    private Unclaimed instance;

    public Listener(Unclaimed instance) {
        this.instance = instance;
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ProtectionInfo protectionInfo = CheckProtection.isProtected(player.getLocation());
        if (!protectionInfo.isProtected() && !player.hasPermission("unclaimed.break")) {
            event.setCancelled(true);
            player.sendMessage(instance.getDescription().getPrefix() + instance.getConfiguration().getBuildMessage());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        ProtectionInfo protectionInfo = CheckProtection.isProtected(player.getLocation());
        if (!protectionInfo.isProtected() && !player.hasPermission("unclaimed.break")) {
            event.setCancelled(true);
            player.sendMessage(instance.getDescription().getPrefix() + instance.getConfiguration().getBuildMessage());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerBucket(PlayerBucketEvent event) {
        Player player = event.getPlayer();
        ProtectionInfo protectionInfo = CheckProtection.isProtected(player.getLocation());
        if (!protectionInfo.isProtected() && !player.hasPermission("unclaimed.break")) {
            event.setCancelled(true);
            player.sendMessage(instance.getDescription().getPrefix() + instance.getConfiguration().getBuildMessage());
        }
    }
}
