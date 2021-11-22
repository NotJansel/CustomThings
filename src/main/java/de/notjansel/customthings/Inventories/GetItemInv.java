package de.notjansel.customthings.Inventories;

import de.notjansel.customthings.CustomItems.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class GetItemInv implements InventoryHolder {

    private Inventory inv;

    public GetItemInv() {
       inv = Bukkit.createInventory(this, 54, "Custom Items");
       init();
    }

    private void init() {
        inv.addItem(ItemManager.enchanted_netherite_ingot);
        inv.addItem(ItemManager.enchanted_netherite_block);
        inv.addItem(ItemManager.enchanted_compressed_netherite_block);
        inv.addItem(ItemManager.upgraded_sword_1);
        inv.addItem(ItemManager.upgraded_sword_2);
        inv.addItem(ItemManager.upgraded_sword_3);
        inv.addItem(ItemManager.upgraded_sword_4);
        inv.addItem(ItemManager.upgraded_sword_5);
        inv.addItem(ItemManager.upgraded_sword_6);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inv;
    }
}
