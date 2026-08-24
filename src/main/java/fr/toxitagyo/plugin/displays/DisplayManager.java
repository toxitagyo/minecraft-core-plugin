package fr.toxitagyo.plugin.displays;

import fr.toxitagyo.plugin.MinecraftCorePlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

public class DisplayManager {
    private final MinecraftCorePlugin plugin;
    private File configFile;
    private FileConfiguration config;
    private Map<UUID, String> activeHolograms;

    public DisplayManager(MinecraftCorePlugin plugin) {
        this.plugin = plugin;
        this.activeHolograms = new HashMap<>();
        loadConfig();
    }

    private void loadConfig() {
        configFile = new File(plugin.getDataFolder(), "displays.yml");
        if (!configFile.exists()) {
            createDefaultConfig();
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    private void createDefaultConfig() {
        try {
            configFile.createNewFile();
            FileConfiguration newConfig = YamlConfiguration.loadConfiguration(configFile);
            
            newConfig.set("holograms.enabled", true);
            newConfig.set("holograms.update-interval", 20);
            newConfig.set("holograms.view-distance", 32);
            newConfig.set("rankings.enabled", true);
            newConfig.set("rankings.format", "§6%rank%. §f%team%: §a$%balance%");
            
            newConfig.save(configFile);
            plugin.getLogger().log(Level.INFO, "Fichier displays.yml créé avec succès");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la création de displays.yml", e);
        }
    }

    public void save() {
        try {
            config.save(configFile);
            plugin.getLogger().log(Level.INFO, "Données affichage sauvegardées");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la sauvegarde des données affichage", e);
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
