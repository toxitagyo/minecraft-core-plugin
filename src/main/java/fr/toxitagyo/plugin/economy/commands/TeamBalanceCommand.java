package fr.toxitagyo.plugin.economy.commands;

import fr.toxitagyo.plugin.MinecraftCorePlugin;
import fr.toxitagyo.plugin.economy.EconomyManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TeamBalanceCommand implements CommandExecutor {
    private EconomyManager economyManager;
    private Map<UUID, Double> teamBalances;
    private Map<String, String> teamColors;

    public TeamBalanceCommand(EconomyManager economyManager) {
        this.economyManager = economyManager;
        this.teamBalances = new HashMap<>();
        this.teamColors = new HashMap<>();
        initializeTeams();
    }

    private void initializeTeams() {
        teamColors.put("Red", "§c");
        teamColors.put("Blue", "§9");
        teamColors.put("Green", "§a");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        updateTeamBalances();
        
        sender.sendMessage("§6§l=== Soldes des Équipes ===");
        for (String team : teamBalances.keySet()) {
            String color = teamColors.getOrDefault(team, "§f");
            double balance = teamBalances.get(team);
            sender.sendMessage(color + team + "§f: §a$" + balance);
        }
        return true;
    }

    private void updateTeamBalances() {
        teamBalances.clear();
        for (Player player : Bukkit.getOnlinePlayers()) {
            double balance = economyManager.getPlayerBalance(player);
            // À implémenter: récupérer l'équipe du joueur depuis le SocialManager
            String team = "Neutre";
            teamBalances.merge(team, balance, Double::sum);
        }
    }
}
