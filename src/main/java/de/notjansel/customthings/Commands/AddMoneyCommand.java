package de.notjansel.customthings.Commands;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static de.notjansel.customthings.Main.db;

public class AddMoneyCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {return true;}
        Player player = Bukkit.getPlayer(args[0]);
        MongoCollection<Document> collection = db.getCollection(player.getUniqueId().toString());
        Document query = new Document().append("playername", player.getName());
        Document doc = collection.find(eq("playername", args[0])).first();
        long oldval = doc.getLong("money");
        long newval = oldval + java.lang.Long.parseLong(args[1]);

        Bson updates = Updates.combine(
          Updates.set("money", newval)
        );
        UpdateOptions options = new UpdateOptions().upsert(true);
        UpdateResult result = collection.updateOne(query, updates, options);
        System.out.println("Modified Docs: " + result.getModifiedCount());
        sender.sendMessage("The Players new Moneyvalue is " + newval);
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> tabComplete = new ArrayList<>();

        if (args.length == 1) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                tabComplete.add(all.getName());
            }
        }

        return tabComplete;
    }
}
