package de.notjansel.customthings.Listeners;

import de.notjansel.customthings.CustomItems.CraftAPI;
import de.notjansel.customthings.CustomItems.ItemManager;
import de.notjansel.customthings.Inventories.CustomCraftingInv;
import de.notjansel.customthings.Inventories.GetItemInv;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class InventoryEvents implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        CraftAPI api = new CraftAPI();
        if(e.getClickedInventory() == null) { return; }
        if(e.getClickedInventory().getHolder() instanceof GetItemInv) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if(e.getCurrentItem() == null) { return; }
            player.getInventory().addItem(e.getCurrentItem());
        }
        if(e.getClickedInventory().getHolder() instanceof CustomCraftingInv) {
            if(e.getCurrentItem() == null) { return; }
            if (e.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() == Material.BARRIER) {
                e.setCancelled(true);
            }
            if (e.getCurrentItem().getType() == Material.ANVIL){
                e.setCancelled(true);
            }
            if (e.getClickedInventory().getItem(2) == null || e.getClickedInventory().getItem(6) == null)
                return;
            if (api.craftable(e.getClickedInventory().getHolder())) {
                e.getClickedInventory().setItem(4, ItemManager.crafting_anvil);
            }
            if (!api.craftable(e.getClickedInventory().getHolder())) {
                e.getClickedInventory().setItem(4, ItemManager.crafting_barrier);
            }


        }
    }

    @EventHandler
    public void onSlotPlace(InventoryInteractEvent e) {

    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
