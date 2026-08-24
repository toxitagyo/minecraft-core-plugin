package fr.toxitagyo.plugin.utility.crafting;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import fr.toxitagyo.plugin.MinecraftCorePlugin;

import java.util.ArrayList;
import java.util.List;

public class ChunkLoaderRecipe {
    private ShapedRecipe recipe;

    public ChunkLoaderRecipe() {
        ItemStack chunkLoader = createChunkLoaderItem();
        NamespacedKey key = new NamespacedKey(MinecraftCorePlugin.getInstance(), "custom_chunk_loader");
        
        recipe = new ShapedRecipe(key, chunkLoader);
        recipe.shape(
            "OEO",
            "EDE",
            "OEO"
        );
        
        // O = Obsidian
        recipe.setIngredient('O', Material.OBSIDIAN);
        // E = Ender Pearl
        recipe.setIngredient('E', Material.ENDER_PEARL);
        // D = Diamond
        recipe.setIngredient('D', Material.DIAMOND);
    }

    private ItemStack createChunkLoaderItem() {
        ItemStack item = new ItemStack(Material.OBSIDIAN, 1);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName("§6§lChunk Loader");
            List<String> lore = new ArrayList<>();
            lore.add("§7Charge les chunks autour de vous");
            lore.add("§7Parfait pour les fermes!");
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
