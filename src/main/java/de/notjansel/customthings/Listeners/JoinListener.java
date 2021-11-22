package de.notjansel.customthings.Listeners;

import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static de.notjansel.customthings.Main.db;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin (PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.getFirstPlayed() == 0) {
            db.createCollection(player.getUniqueId().toString());
            BasicDBObject doc = new BasicDBObject("playername", player.getName());
            doc.append("money", (long) 0);
            db.getCollection(player.getUniqueId().toString()).insertOne(Document.parse(doc.toJson()));
        } else {
            try {
                db.getCollection(player.getUniqueId().toString());
                Document doc = db.getCollection(player.getUniqueId().toString()).find().first();
                doc.replace("playername", player.getName());
            } catch (Exception e) {
                db.createCollection(player.getUniqueId().toString());
                BasicDBObject doc = new BasicDBObject("playername", player.getName());
                doc.append("money", 0L);
                db.getCollection(player.getUniqueId().toString()).insertOne(Document.parse(doc.toJson()));
            }

        }
    }
}
