package fr.toxitagyo.plugin.economy.commands;

import fr.toxitagyo.plugin.economy.EconomyManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {
    private EconomyManager economyManager;

    public ShopCommand(EconomyManager economyManager) {
        this.economyManager = economyManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;
        player.sendMessage("§a§l=== Boutique ===");
        player.sendMessage("§fDésolé, la boutique n'est pas encore implémentée.");
        player.sendMessage("§fRevenir bientôt...");
        return true;
    }
}
