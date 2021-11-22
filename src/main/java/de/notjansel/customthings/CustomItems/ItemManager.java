package de.notjansel.customthings.CustomItems;

import de.notjansel.customthings.CustomEnchants.CEnchants;
import de.notjansel.customthings.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemManager {

    public static ItemStack upgraded_sword_1;
    public static ItemStack upgraded_sword_2;
    public static ItemStack upgraded_sword_3;
    public static ItemStack upgraded_sword_4;
    public static ItemStack upgraded_sword_5;
    public static ItemStack upgraded_sword_6;
    public static ItemStack enchanted_netherite_ingot;
    public static ItemStack enchanted_netherite_block;
    public static ItemStack enchanted_compressed_netherite_block;
    public static ItemStack crafting_anvil;
    public static ItemStack crafting_barrier;

    public static void init(){
        create_enchanted_netherite_ingot();
        create_enchanted_netherite_block();
        create_enchanted_compressed_netherite_block();
        create_upgraded_sword_1();
        create_upgraded_sword_2();
        create_upgraded_sword_3();
        create_upgraded_sword_4();
        create_upgraded_sword_5();
        create_upgraded_sword_6();
        create_crafting_anvil();
        create_crafting_barrier();
    }

    private static void create_crafting_barrier() {
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4Invalid Recipe");
        meta.setLore(Collections.singletonList(""));
        item.setItemMeta(meta);
        crafting_barrier = item;
    }

    private static void create_crafting_anvil() {
        ItemStack item = new ItemStack(Material.ANVIL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Craft");
        meta.setLore(Collections.singletonList("Click this to craft your Item"));
        meta.addEnchant(CEnchants.DUMMY, 0 ,false);
        item.setItemMeta(meta);
        crafting_anvil = item;
    }


    private static void create_enchanted_netherite_ingot() {
        ItemStack item = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(CEnchants.DUMMY, 0, false);
        meta.setDisplayName(ChatColor.RESET + "Enchanted Netherite Ingot");
        item.setItemMeta(meta);

        enchanted_netherite_ingot = item;

        ShapelessRecipe sr = new ShapelessRecipe(NamespacedKey.minecraft("enchanted_netherite_ingot"), item);
        sr.addIngredient(9, Material.NETHERITE_BLOCK);

        Bukkit.addRecipe(sr);
    }

    private static void create_enchanted_netherite_block() {
        ItemStack item = new ItemStack(Material.NETHERITE_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(CEnchants.DUMMY, 0, false);
        meta.setDisplayName(ChatColor.RESET + "Enchanted Netherite Block");
        item.setItemMeta(meta);

        enchanted_netherite_block = item;

        ShapelessRecipe sr = new ShapelessRecipe(NamespacedKey.minecraft("enchanted_netherite_block"), item);
        sr.addIngredient(9, enchanted_netherite_ingot);

        Bukkit.addRecipe(sr);
    }

    private static void create_enchanted_compressed_netherite_block() {
        ItemStack item = new ItemStack(Material.NETHERITE_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(CEnchants.DUMMY, 0, false);
        meta.setDisplayName(ChatColor.RESET + "Enchanted Compressed Netherite Block");
        item.setItemMeta(meta);

        enchanted_compressed_netherite_block = item;

        ShapelessRecipe sr = new ShapelessRecipe(NamespacedKey.minecraft("enchanted_compressed_netherite_block"), item);
        sr.addIngredient(9, enchanted_netherite_block);

        Bukkit.addRecipe(sr);
    }

    private static void create_upgraded_sword_1(){
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§r§6Netherite Sword §e✪");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§6§lLEGENDARY");
        meta.setLore(lore);
        item.setItemMeta(meta);



        upgraded_sword_1 = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("upgraded_sword_1"), item);
        sr.shape("DND", "NSN", "DND");
        sr.setIngredient('N', Material.NETHERITE_INGOT);
        sr.setIngredient('S', Material.NETHERITE_SWORD);
        sr.setIngredient('D', Material.DRAGON_BREATH);

        Bukkit.addRecipe(sr);
    }

    private static void create_upgraded_sword_2(){
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§r§dNetherite Sword §e✪✪");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 8, true);
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§d§lMYTHIC");
        meta.setLore(lore);
        item.setItemMeta(meta);

        upgraded_sword_2 = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("upgraded_sword_2"), item);
        sr.shape("DND", "NSN", "DND");
        sr.setIngredient('N', Material.NETHERITE_BLOCK);
        sr.setIngredient('S', upgraded_sword_1);
        sr.setIngredient('D', Material.DRAGON_BREATH);

        Bukkit.addRecipe(sr);
    }

    private static void create_upgraded_sword_3(){
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bNetherite Sword §e✪✪✪");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§b§lDIVINE");
        meta.setLore(lore);
        item.setItemMeta(meta);

        upgraded_sword_3 = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("upgraded_sword_3"), item);
        sr.shape("DND", "NSN", "DND");
        sr.setIngredient('N', enchanted_netherite_ingot);
        sr.setIngredient('S', upgraded_sword_2);
        sr.setIngredient('D', Material.DRAGON_BREATH);



        Bukkit.addRecipe(sr);
    }

    private static void create_upgraded_sword_4(){
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cNetherite Sword §e✪✪✪✪");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 12, true);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Sharpness XII");
        lore.add("");
        lore.add("§c§lSPECIAL");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);

        upgraded_sword_4 = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("upgraded_sword_4"), item);
        sr.shape("DND", "NSN", "DND");
        sr.setIngredient('N', enchanted_netherite_block);
        sr.setIngredient('S', upgraded_sword_3);
        sr.setIngredient('D', Material.DRAGON_BREATH);



        Bukkit.addRecipe(sr);
    }

    private static void create_upgraded_sword_5(){
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cNetherite Sword §e✪✪✪✪✪");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 14, true);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Sharpness XIV");
        lore.add("");
        lore.add(ChatColor.GRAY + "Congratulations, you wasted over 100.000 Ancient Debris on this.");
        lore.add(ChatColor.GRAY + "Here, this Sword is a Reward.");
        lore.add("");
        lore.add("§c§lVERY SPECIAL");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);

        upgraded_sword_5 = item;



        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("upgraded_sword_5"), item);
        ItemStack craftitem = new ItemStack(Material.NETHERITE_SWORD);
        NamespacedKey key1 = new NamespacedKey(Main.getInstance(), "ID");
        PersistentDataContainer container1 = meta.getPersistentDataContainer();
        craftitem.getItemMeta().getPersistentDataContainer().set(key1, PersistentDataType.STRING, "upgraded_sword_5");
        sr.shape("CNC", "NSN", "CNC");
        sr.setIngredient('N', enchanted_compressed_netherite_block);
        sr.setIngredient('S', upgraded_sword_4);

        sr.setIngredient('C', enchanted_netherite_block);



        Bukkit.addRecipe(sr);
    }

    private static void create_upgraded_sword_6(){
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Netherite Sword §c✪§e✪✪✪✪");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 20, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Sharpness XX");
        lore.add(ChatColor.GRAY + "Fire Aspect II");
        lore.add(ChatColor.GRAY + "Knockback II");
        lore.add(ChatColor.GRAY + "Mending");
        lore.add(ChatColor.GRAY + "Sweeping Edge III");
        lore.add(ChatColor.GRAY + "Unbreaking III");
        lore.add(ChatColor.GRAY + "Looting III");
        lore.add("");
        lore.add("§5§lGODLIKE");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);

        upgraded_sword_6 = item;



        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("upgraded_sword_6"), item);
        ItemStack craftitem = new ItemStack(Material.NETHERITE_SWORD);
        sr.shape("NNN", "NSN", "NNN");
        sr.setIngredient('N', enchanted_compressed_netherite_block);
        sr.setIngredient('S', upgraded_sword_5);



        Bukkit.addRecipe(sr);
    }
}
