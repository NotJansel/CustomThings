package de.notjansel.customthings.CustomEnchants;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentOffer;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CEnchants {

    public static final Enchantment TELEKINESE = new TelekineseWrapper("telekinese", "Telekinese", 0);
    public static final Enchantment DUMMY = new DummyWrapper("dummy", "Dummy", 0);

    public static void register() {
        List<Enchantment> listtoget = Arrays.asList(
                TELEKINESE,
                DUMMY
        ) ;
        boolean registered = Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(listtoget);
        if (!registered) {
            for (Enchantment ench : listtoget) { registerEnchantment(ench);}
        }
    }

    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        try {
           Field f = Enchantment.class.getDeclaredField("acceptingNew");
           f.setAccessible(true);
           f.set(null, true);
           Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
           registered = false;
           e.printStackTrace();
        }
    }

}
