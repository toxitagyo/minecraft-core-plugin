package fr.toxitagyo.plugin.utility.crafting;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import fr.toxitagyo.plugin.MinecraftCorePlugin;

import java.util.ArrayList;
import java.util.List;

public class EnderChestRecipe {
    private ShapedRecipe recipe;

    public EnderChestRecipe() {
        ItemStack enderChest = createEnderChestItem();
        NamespacedKey key = new NamespacedKey(MinecraftCorePlugin.getInstance(), "custom_ender_chest");
        
        recipe = new ShapedRecipe(key, enderChest);
        recipe.shape(
            "OBO",
            "BEB",
            "OBO"
        );
        
        // O = Obsidian
        recipe.setIngredient('O', Material.OBSIDIAN);
        // B = Eye of Ender
        recipe.setIngredient('B', Material.ENDER_EYE);
        // E = Ender Pearl
        recipe.setIngredient('E', Material.ENDER_PEARL);
    }

    private ItemStack createEnderChestItem() {
        ItemStack item = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§5§lEnder Chest Magique");
            List<String> lore = new ArrayList<>();
            lore.add("§7Accédez à votre stockage Ender");
            lore.add("§7depuis n'importe où!");
            lore.add("§7");
            lore.add("§eRecette Custom");
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
        return item;
    }

    public ShapedRecipe getRecipe() {
        return recipe;
    }
}
