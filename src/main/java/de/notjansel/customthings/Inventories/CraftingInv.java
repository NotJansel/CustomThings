package de.notjansel.customthings.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class CraftingInv implements InventoryHolder {

    private Inventory inv;

    public CraftingInv() {
        inv = Bukkit.createInventory(this, InventoryType.WORKBENCH);

        init();
    }

    private void init() {
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inv;
    }
}
