package fr.toxitagyo.plugin;

import fr.toxitagyo.plugin.economy.EconomyManager;
import fr.toxitagyo.plugin.social.SocialManager;
import fr.toxitagyo.plugin.survival.SurvivalManager;
import fr.toxitagyo.plugin.utility.UtilityManager;
import fr.toxitagyo.plugin.displays.DisplayManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class MinecraftCorePlugin extends JavaPlugin {

    private static MinecraftCorePlugin instance;

    private EconomyManager economyManager;
    private SocialManager socialManager;
    private SurvivalManager survivalManager;
    private UtilityManager utilityManager;
    private DisplayManager displayManager;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().log(Level.INFO, "Minecraft Core Plugin en cours de chargement...");

        // Créer le dossier de configuration s'il n'existe pas
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        // Initialiser les managers de modules
        try {
            economyManager = new EconomyManager(this);
            getLogger().log(Level.INFO, "Module Économie chargé");

            socialManager = new SocialManager(this);
            getLogger().log(Level.INFO, "Module Social chargé");

            survivalManager = new SurvivalManager(this);
            getLogger().log(Level.INFO, "Module Survie chargé");

            utilityManager = new UtilityManager(this);
            getLogger().log(Level.INFO, "Module Utilitaires chargé");

            displayManager = new DisplayManager(this);
            getLogger().log(Level.INFO, "Module Affichage chargé");

            getLogger().log(Level.INFO, "✓ Minecraft Core Plugin activé avec succès!");
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Erreur lors du chargement des modules", e);
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "Minecraft Core Plugin en cours de déchargement...");

        // Sauvegarder les données
        if (economyManager != null) economyManager.save();
        if (socialManager != null) socialManager.save();
        if (survivalManager != null) survivalManager.save();
        if (utilityManager != null) utilityManager.save();
        if (displayManager != null) displayManager.save();

        getLogger().log(Level.INFO, "✓ Minecraft Core Plugin désactivé");
    }

    public static MinecraftCorePlugin getInstance() {
        return instance;
    }

    public EconomyManager getEconomyManager() {
        return economyManager;
    }

    public SocialManager getSocialManager() {
        return socialManager;
    }

    public SurvivalManager getSurvivalManager() {
        return survivalManager;
    }

    public UtilityManager getUtilityManager() {
        return utilityManager;
    }

    public DisplayManager getDisplayManager() {
        return displayManager;
    }
}
