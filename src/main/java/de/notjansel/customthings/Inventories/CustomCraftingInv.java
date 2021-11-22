package de.notjansel.customthings.Inventories;

import de.notjansel.customthings.CustomItems.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomCraftingInv implements InventoryHolder {

    private Inventory inv;

    public CustomCraftingInv() {
        inv = Bukkit.createInventory(this, 9, "Upgrade Sword");

        init();
    }

    private void init() {
        ItemStack item;
        for (int i = 0; i < 2; i++) {
            item = createItem("", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(i, item);
        }

        item = createItem("", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(""));
        inv.setItem(3, item);
        inv.setItem(4, ItemManager.crafting_barrier);
        item = createItem("", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(""));
        inv.setItem(5, item);

        for (int i = 7; i < 9; i++) {
            item = createItem("", Material.GRAY_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(i, item);
        }
    }

    private ItemStack createItem(String name, Material mat, List<String> lore) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inv;
    }
}
