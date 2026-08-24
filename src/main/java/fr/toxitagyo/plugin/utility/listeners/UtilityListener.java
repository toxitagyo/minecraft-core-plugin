package fr.toxitagyo.plugin.utility.listeners;

import fr.toxitagyo.plugin.utility.UtilityManager;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UtilityListener implements Listener {
    private UtilityManager utilityManager;

    public UtilityListener(UtilityManager utilityManager) {
        this.utilityManager = utilityManager;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        ItemMeta meta = item.getItemMeta();
        
        if (meta != null && meta.hasDisplayName()) {
            String displayName = meta.getDisplayName();
            
            // Détection du Chunk Loader
            if (displayName.contains("Chunk Loader")) {
                // Logique pour placer un chunk loader
                // À implémenter selon vos besoins
            }
            
            // Détection de l'Ender Chest
            if (displayName.contains("Ender Chest")) {
                // Logique pour l'ender chest
                // À implémenter selon vos besoins
            }
        }
    }
}
