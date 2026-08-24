package fr.toxitagyo.plugin.economy.commands;

import fr.toxitagyo.plugin.MinecraftCorePlugin;
import fr.toxitagyo.plugin.economy.EconomyManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.stream.Collectors;

public class ShowRankingCommand implements CommandExecutor {
    private EconomyManager economyManager;
    private Map<String, String> teamColors;

    public ShowRankingCommand(EconomyManager economyManager) {
        this.economyManager = economyManager;
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
        Map<String, Double> teamBalances = calculateTeamBalances();
        List<Map.Entry<String, Double>> ranking = teamBalances.entrySet()
            .stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .collect(Collectors.toList());
        
        sender.sendMessage("§6§l╔═══════════════════════════════╗");
        sender.sendMessage("§6§l║   CLASSEMENT DES ÉQUIPES   §6§l║");
        sender.sendMessage("§6§l╠═══════════════════════════════╣");
        
        int rank = 1;
        for (Map.Entry<String, Double> entry : ranking) {
            String team = entry.getKey();
            double balance = entry.getValue();
            String color = teamColors.getOrDefault(team, "§f");
            String medal = getMedal(rank);
            sender.sendMessage("§6§l║ " + medal + " " + rank + ". " + color + team + "§f: §a$" + balance + "§6§l ║");
            rank++;
        }
        
        sender.sendMessage("§6§l╚═══════════════════════════════╝");
        return true;
    }

    private String getMedal(int rank) {
        switch (rank) {
            case 1:
                return "§6★";
            case 2:
                return "§7✦";
            case 3:
                return "§6✦";
            default:
                return "►";
        }
    }

    private Map<String, Double> calculateTeamBalances() {
        Map<String, Double> teamBalances = new HashMap<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            double balance = economyManager.getPlayerBalance(player);
            String team = "Neutre";
            teamBalances.merge(team, balance, Double::sum);
        }
        return teamBalances;
    }
}
