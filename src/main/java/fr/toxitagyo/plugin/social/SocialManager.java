package fr.toxitagyo.plugin.social;

import fr.toxitagyo.plugin.MinecraftCorePlugin;
import fr.toxitagyo.plugin.social.commands.TeamCommand;
import fr.toxitagyo.plugin.social.commands.PartyCommand;
import fr.toxitagyo.plugin.social.listeners.SocialListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

public class SocialManager {
    private final MinecraftCorePlugin plugin;
    private File configFile;
    private FileConfiguration config;
    private Map<UUID, String> playerTeams;
    private Map<UUID, String> playerParties;

    public SocialManager(MinecraftCorePlugin plugin) {
        this.plugin = plugin;
        this.playerTeams = new HashMap<>();
        this.playerParties = new HashMap<>();
        loadConfig();
        registerCommands();
        registerListeners();
    }

    private void loadConfig() {
        configFile = new File(plugin.getDataFolder(), "social.yml");
        if (!configFile.exists()) {
            createDefaultConfig();
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    private void createDefaultConfig() {
        try {
            configFile.createNewFile();
            FileConfiguration newConfig = YamlConfiguration.loadConfiguration(configFile);
            
            newConfig.set("max-team-members", 10);
            newConfig.set("max-party-members", 5);
            newConfig.set("friendly-fire", false);
            newConfig.set("quests.enabled", true);
            
            newConfig.save(configFile);
            plugin.getLogger().log(Level.INFO, "Fichier social.yml créé avec succès");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la création de social.yml", e);
        }
    }

    private void registerCommands() {
        plugin.getCommand("team").setExecutor(new TeamCommand(this));
        plugin.getCommand("party").setExecutor(new PartyCommand(this));
    }

    private void registerListeners() {
        plugin.getServer().getPluginManager().registerEvents(new SocialListener(this), plugin);
    }

    public void save() {
        try {
            config.save(configFile);
            plugin.getLogger().log(Level.INFO, "Données sociales sauvegardées");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la sauvegarde des données sociales", e);
        }
    }

    public String getPlayerTeam(UUID uuid) {
        return playerTeams.getOrDefault(uuid, "Aucune");
    }

    public void setPlayerTeam(UUID uuid, String team) {
        playerTeams.put(uuid, team);
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
