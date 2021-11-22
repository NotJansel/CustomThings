package de.notjansel.customthings;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import de.notjansel.customthings.Commands.*;
import de.notjansel.customthings.CustomEnchants.CEnchants;
import de.notjansel.customthings.CustomItems.ItemManager;
import de.notjansel.customthings.Listeners.BlockBreakListener;
import de.notjansel.customthings.Listeners.InventoryEvents;
import de.notjansel.customthings.Listeners.JoinListener;
import de.notjansel.customthings.Listeners.TickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static MongoDatabase db;
    public static Main instance;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        if (getConfig().getString("plugin.dblink") == null) {
            Bukkit.getConsoleSender().sendMessage("No Database Link provided. Disabling Plugin...");
            getPluginLoader().disablePlugin(this);
        }
        ConnectionString connectionString = new ConnectionString(getConfig().getString("plugin.dblink"));
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        db = mongoClient.getDatabase("test");
        instance = this;
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        getServer().getPluginManager().registerEvents(new TickListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);

        CEnchants.register();
        getCommand("craft").setExecutor(new CraftCommand());
        getCommand("givecustom").setExecutor(new GiveCustomCommand());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("customcraft").setExecutor(new CustomCraftCommand());
        getCommand("money").setExecutor(new MoneyCommand());
        getCommand("addmoney").setExecutor(new AddMoneyCommand());
        getCommand("addmoney").setTabCompleter(new AddMoneyCommand());
        getCommand("removemoney").setExecutor(new RemoceMoneyCommand());
        getCommand("removemoney").setTabCompleter(new RemoceMoneyCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }
}
