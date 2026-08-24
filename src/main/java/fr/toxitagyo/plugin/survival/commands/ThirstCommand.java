package fr.toxitagyo.plugin.survival.commands;

import fr.toxitagyo.plugin.survival.SurvivalManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ThirstCommand implements CommandExecutor {
    private SurvivalManager survivalManager;

    public ThirstCommand(SurvivalManager survivalManager) {
        this.survivalManager = survivalManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;
        player.sendMessage("§a§l=== Votre Soif ===");
        player.sendMessage("§fNiveau de soif: §a100%");
        player.sendMessage("§fBuvez de l'eau pour vous désaltérer!");
        return true;
    }
}
