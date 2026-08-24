package fr.toxitagyo.plugin.utility;

import fr.toxitagyo.plugin.MinecraftCorePlugin;
import fr.toxitagyo.plugin.utility.commands.ChunkLoaderCommand;
import fr.toxitagyo.plugin.utility.commands.EnderStorageCommand;
import fr.toxitagyo.plugin.utility.commands.ReviveCommand;
import fr.toxitagyo.plugin.utility.commands.EnderChestCommand;
import fr.toxitagyo.plugin.utility.listeners.UtilityListener;
import fr.toxitagyo.plugin.utility.crafting.EnderChestRecipe;
import fr.toxitagyo.plugin.utility.crafting.ChunkLoaderRecipe;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.Recipe;

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
    private EnderChestRecipe enderChestRecipe;
    private ChunkLoaderRecipe chunkLoaderRecipe;

    public UtilityManager(MinecraftCorePlugin plugin) {
        this.plugin = plugin;
        this.enderStorageColors = new HashMap<>();
        this.chunkLoaders = new HashMap<>();
        loadConfig();
        registerCommands();
        registerListeners();
        registerRecipes();
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
            
            // Crafting recipes
            newConfig.set("crafting.ender-chest.enabled", true);
            newConfig.set("crafting.chunk-loader.enabled", true);
            
            newConfig.save(configFile);
            plugin.getLogger().log(Level.INFO, "Fichier utility.yml créé avec succès");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la création de utility.yml", e);
        }
    }

    private void registerCommands() {
        plugin.getCommand("enderstorage").setExecutor(new EnderStorageCommand(this));
        plugin.getCommand("chunkloader").setExecutor(new ChunkLoaderCommand(this));
        plugin.getCommand("revive").setExecutor(new ReviveCommand(this));
        plugin.getCommand("enderchest").setExecutor(new EnderChestCommand(this));
    }

    private void registerListeners() {
        plugin.getServer().getPluginManager().registerEvents(new UtilityListener(this), plugin);
    }

    private void registerRecipes() {
        if (config.getBoolean("crafting.ender-chest.enabled", true)) {
            enderChestRecipe = new EnderChestRecipe();
            plugin.getServer().addRecipe(enderChestRecipe.getRecipe());
            plugin.getLogger().log(Level.INFO, "Recette Ender Chest enregistrée");
        }

        if (config.getBoolean("crafting.chunk-loader.enabled", true)) {
            chunkLoaderRecipe = new ChunkLoaderRecipe();
            plugin.getServer().addRecipe(chunkLoaderRecipe.getRecipe());
            plugin.getLogger().log(Level.INFO, "Recette Chunk Loader enregistrée");
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

    public MinecraftCorePlugin getPlugin() {
        return plugin;
    }
}
