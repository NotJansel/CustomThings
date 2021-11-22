package de.notjansel.customthings.Commands;

import de.notjansel.customthings.Inventories.CustomCraftingInv;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CustomCraftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        CustomCraftingInv ccinv = new CustomCraftingInv();
        player.openInventory(ccinv.getInventory());
        return true;
    }
}
