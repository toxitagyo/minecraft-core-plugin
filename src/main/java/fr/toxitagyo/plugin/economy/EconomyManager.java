package fr.toxitagyo.plugin.economy;

import fr.toxitagyo.plugin.MinecraftCorePlugin;
import fr.toxitagyo.plugin.economy.commands.BankCommand;
import fr.toxitagyo.plugin.economy.commands.MoneyCommand;
import fr.toxitagyo.plugin.economy.commands.ShopCommand;
import fr.toxitagyo.plugin.economy.listeners.EconomyListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

public class EconomyManager {
    private final MinecraftCorePlugin plugin;
    private File configFile;
    private FileConfiguration config;
    private Map<UUID, Double> playerBalances;
    private Map<UUID, Double> teamBalances;

    public EconomyManager(MinecraftCorePlugin plugin) {
        this.plugin = plugin;
        this.playerBalances = new HashMap<>();
        this.teamBalances = new HashMap<>();
        loadConfig();
        registerCommands();
        registerListeners();
    }

    private void loadConfig() {
        configFile = new File(plugin.getDataFolder(), "economy.yml");
        if (!configFile.exists()) {
            createDefaultConfig();
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    private void createDefaultConfig() {
        try {
            configFile.createNewFile();
            FileConfiguration newConfig = YamlConfiguration.loadConfiguration(configFile);
            
            // Configuration par défaut
            newConfig.set("starting-balance", 1000.0);
            newConfig.set("interest-rate", 0.5);
            newConfig.set("bank-fees", 5.0);
            newConfig.set("shop.enabled", true);
            newConfig.set("shop.update-interval", 48);
            
            newConfig.save(configFile);
            plugin.getLogger().log(Level.INFO, "Fichier economy.yml créé avec succès");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la création de economy.yml", e);
        }
    }

    private void registerCommands() {
        plugin.getCommand("money").setExecutor(new MoneyCommand(this));
        plugin.getCommand("bank").setExecutor(new BankCommand(this));
        plugin.getCommand("shop").setExecutor(new ShopCommand(this));
    }

    private void registerListeners() {
        plugin.getServer().getPluginManager().registerEvents(new EconomyListener(this), plugin);
    }

    public void save() {
        try {
            config.save(configFile);
            plugin.getLogger().log(Level.INFO, "Données économie sauvegardées");
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Erreur lors de la sauvegarde des données économie", e);
        }
    }

    // Méthodes utilitaires
    public double getPlayerBalance(Player player) {
        return playerBalances.getOrDefault(player.getUniqueId(), config.getDouble("starting-balance", 1000.0));
    }

    public void setPlayerBalance(Player player, double amount) {
        playerBalances.put(player.getUniqueId(), Math.max(0, amount));
    }

    public void addBalance(Player player, double amount) {
        double current = getPlayerBalance(player);
        setPlayerBalance(player, current + amount);
    }

    public void removeBalance(Player player, double amount) {
        double current = getPlayerBalance(player);
        setPlayerBalance(player, current - amount);
    }

    public FileConfiguration getConfig() {
        return config;
    }
}
