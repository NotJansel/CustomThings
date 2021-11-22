package de.notjansel.customthings.Commands;

import de.notjansel.customthings.CustomItems.ItemManager;
import de.notjansel.customthings.Inventories.GetItemInv;
import de.notjansel.customthings.Main;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class GiveCustomCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

       if (!(sender instanceof Player)) { return true; }

       Player player = (Player) sender;
       GetItemInv gui = new GetItemInv();
       player.openInventory(gui.getInventory());

        return true;
    }

}
