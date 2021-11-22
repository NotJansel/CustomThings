package de.notjansel.customthings.Commands;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.notjansel.customthings.Main.db;

public class MoneyCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {return true;}
        if (args.length == 1) {
            Player player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[0]);
                MongoCollection<Document> collection = db.getCollection(offlinePlayer.getUniqueId().toString());
                Document doc = collection.find(eq("playername", args[0])).first();
                sender.sendMessage(offlinePlayer.getName() + "'s Money: " + doc.getLong("money"));
                return true;
            }
            MongoCollection<Document> collection = db.getCollection(player.getUniqueId().toString());
            Document doc = collection.find(eq("playername", args[0])).first();
            sender.sendMessage(player.getName() + "'s Money: " + doc.getLong("money"));
            return true;
        }
        Player player = (Player) sender;
        MongoCollection<Document> collection = db.getCollection(player.getUniqueId().toString());
        Document doc = collection.find(eq("playername", sender.getName())).first();
        sender.sendMessage("Your Money: " + doc.get("money").toString());
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> tabComplete = new ArrayList<>();
        if (args.length == 1) {
            for (OfflinePlayer all : Bukkit.getOfflinePlayers()) {
                tabComplete.add(all.getName());
            }
            for (Player player : Bukkit.getOnlinePlayers()) {
                tabComplete.add(player.getName());
            }
        }
        return tabComplete;
    }
}
