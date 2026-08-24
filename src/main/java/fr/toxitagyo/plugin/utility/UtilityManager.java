package fr.toxitagyo.plugin.utility;

import fr.toxitagyo.plugin.MinecraftCorePlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

public class UtilityManager {
    private final MinecraftCorePlugin plugin;
    private File configFile;
    private FileConfiguration config;
    private Map<UUID, String> enderStorageColors;
    private Map<UUID, Integer> chunkLoaders;

    public UtilityManager(MinecraftCorePlugin plugin) {
        this.plugin = plugin;
        this.enderStorageColors = new HashMap<>();
        this.chunkLoaders = new HashMap<>();
        loadConfig();
    }

    private void loadConfig() {
        configFile = new File(plugin.getDataFolder(), "utility.yml");
        if (!configFile.exists()) {
            createDefaultConfig();
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    private void createDefaultConfig() {
        try {
            configFile.createNewFile();
            FileConfiguration newConfig = YamlConfiguration.loadConfiguration(configFile);
            
            newConfig.set("ender-storage.enabled", true);
            newConfig.set("ender-storage.color-coded", true);
            newConfig.set("chunk-loader.enabled", true);
            newConfig.set("chunk-loader.max-per-player", 5);
            newConfig.set("improved-sleeping.enabled", true);
            newConfig.set("improved-sleeping.percentage", 30);
            newConfig.set("player-revive.enabled", true);
            newConfig.set("player-revive.bleed-time", 30);
            
            newConfig.save(configFile);
            plugin.getLogger().log(Level.INFO, "Fichier utility.yml créé avec succès");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la création de utility.yml", e);
        }
    }

    public void save() {
        try {
            config.save(configFile);
            plugin.getLogger().log(Level.INFO, "Données utilitaires sauvegardées");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la sauvegarde des données utilitaires", e);
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
