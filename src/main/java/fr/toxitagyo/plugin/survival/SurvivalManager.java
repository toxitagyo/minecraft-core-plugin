package fr.toxitagyo.plugin.survival;

import fr.toxitagyo.plugin.MinecraftCorePlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

public class SurvivalManager {
    private final MinecraftCorePlugin plugin;
    private File configFile;
    private FileConfiguration config;
    private Map<UUID, Double> playerThirst;
    private Map<UUID, Double> playerTemperature;
    private boolean bloodMoonActive;

    public SurvivalManager(MinecraftCorePlugin plugin) {
        this.plugin = plugin;
        this.playerThirst = new HashMap<>();
        this.playerTemperature = new HashMap<>();
        this.bloodMoonActive = false;
        loadConfig();
    }

    private void loadConfig() {
        configFile = new File(plugin.getDataFolder(), "survival.yml");
        if (!configFile.exists()) {
            createDefaultConfig();
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    private void createDefaultConfig() {
        try {
            configFile.createNewFile();
            FileConfiguration newConfig = YamlConfiguration.loadConfiguration(configFile);
            
            newConfig.set("thirst.enabled", true);
            newConfig.set("thirst.depletion-rate", 0.5);
            newConfig.set("temperature.enabled", true);
            newConfig.set("temperature.cold-damage", 1);
            newConfig.set("temperature.hot-damage", 0.5);
            newConfig.set("dynamic-difficulty.enabled", true);
            newConfig.set("blood-moon.enabled", true);
            newConfig.set("blood-moon.frequency", 7);
            newConfig.set("blood-moon.mob-multiplier", 1.5);
            
            newConfig.save(configFile);
            plugin.getLogger().log(Level.INFO, "Fichier survival.yml créé avec succès");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la création de survival.yml", e);
        }
    }

    public void save() {
        try {
            config.save(configFile);
            plugin.getLogger().log(Level.INFO, "Données survie sauvegardées");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la sauvegarde des données survie", e);
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
