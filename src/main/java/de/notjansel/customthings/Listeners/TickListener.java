package de.notjansel.customthings.Listeners;

import com.destroystokyo.paper.event.server.ServerTickStartEvent;
import de.notjansel.customthings.CustomItems.CraftAPI;
import de.notjansel.customthings.CustomItems.ItemManager;
import de.notjansel.customthings.Inventories.CustomCraftingInv;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class TickListener implements Listener {
    @EventHandler
    public void onTick(ServerTickStartEvent event) {
        for (Player player : Bukkit.getOnlinePlayers()){
            Inventory inv = (Inventory) player.getOpenInventory().getTopInventory();
            if (inv instanceof CustomCraftingInv) {
                CraftAPI api = new CraftAPI();
                if (api.craftable(inv.getHolder())) {
                    inv.setItem(4, ItemManager.crafting_anvil);
                }
                if (!api.craftable(inv.getHolder())) {
                    inv.setItem(4, ItemManager.crafting_barrier);
                }
            }
        }
    }
}
