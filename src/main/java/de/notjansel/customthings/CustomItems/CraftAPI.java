package de.notjansel.customthings.CustomItems;

import de.notjansel.customthings.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class CraftAPI {

    private boolean craft = false;
    private boolean isCorrectItem = false;
    private boolean hasNBT = false;

    public boolean craftable(InventoryHolder inv){

        if (checkSlots(inv.getInventory().getItem(2), inv.getInventory().getItem(6)) == true){
            return craft = true;
        }

        return craft = false;
    }

    private boolean checkSlots(ItemStack item, ItemStack item2) {

        if(checkNBT(item) == true && item2.getType() == Material.NETHERITE_BLOCK && item2.getAmount() == 4){
            return isCorrectItem = true;
        }



        return isCorrectItem = false;
    }

    private boolean checkNBT(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(Main.getInstance(), "ID");
        if (meta.getPersistentDataContainer().get(key, PersistentDataType.STRING) == "upgraded_sword_1") {
            return hasNBT = true;
        }
        return hasNBT = false;
    }


}
