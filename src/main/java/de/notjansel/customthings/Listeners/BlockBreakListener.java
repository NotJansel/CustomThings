package de.notjansel.customthings.Listeners;

import de.notjansel.customthings.CustomEnchants.CEnchants;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if (event.getPlayer().getInventory().getItemInMainHand() == null){ return; }
        if (!event.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) { return; }



        if (!event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(CEnchants.TELEKINESE)) { return; }
        if (event.getPlayer().getGameMode() == GameMode.CREATIVE || event.getPlayer().getGameMode() == GameMode.SPECTATOR) { return; }
        if (event.getPlayer().getInventory().firstEmpty() == -1) { return; }
        if (event.getBlock().getState() instanceof Container) { return; }

        event.setDropItems(false);
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Collection<ItemStack> drops = block.getDrops(player.getInventory().getItemInMainHand());
        if (drops.isEmpty()) { return; }
        player.getInventory().addItem(drops.iterator().next());
    }
}
