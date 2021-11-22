package de.notjansel.customthings.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        StringBuilder strbld = new StringBuilder();
        for (String str : strings) {
            strbld.append(str + " ");
        }

        Bukkit.broadcastMessage("§4§l==================BROADCAST==================");
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§a" + strbld.toString());
        Bukkit.broadcastMessage("");
        Bukkit.broadcastMessage("§4§l==================BROADCAST==================");
        return true;
    }
}
