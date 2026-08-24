package fr.toxitagyo.plugin.economy.listeners;

import fr.toxitagyo.plugin.economy.EconomyManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EconomyListener implements Listener {
    private EconomyManager economyManager;

    public EconomyListener(EconomyManager economyManager) {
        this.economyManager = economyManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (economyManager.getPlayerBalance(player) == 0) {
            double startingBalance = economyManager.getConfig().getDouble("starting-balance", 1000.0);
            economyManager.setPlayerBalance(player, startingBalance);
            player.sendMessage("§a✓ Compte créé avec un solde initial de $" + startingBalance);
        }
    }
}
