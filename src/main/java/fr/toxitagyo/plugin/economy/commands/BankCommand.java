package fr.toxitagyo.plugin.economy.commands;

import fr.toxitagyo.plugin.economy.EconomyManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BankCommand implements CommandExecutor {
    private EconomyManager economyManager;

    public BankCommand(EconomyManager economyManager) {
        this.economyManager = economyManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            showBankMenu(player);
            return true;
        }

        String subCommand = args[0].toLowerCase();
        switch (subCommand) {
            case "balance":
                showBalance(player);
                break;
            case "deposit":
                if (args.length < 2) {
                    player.sendMessage("§cUtilisation: /bank deposit <montant>");
                    return true;
                }
                try {
                    double amount = Double.parseDouble(args[1]);
                    economyManager.addBalance(player, amount);
                    player.sendMessage("§a✓ Dépôt de $" + amount + " effectué!");
                } catch (NumberFormatException e) {
                    player.sendMessage("§cLe montant doit être un nombre.");
                }
                break;
            case "withdraw":
                if (args.length < 2) {
                    player.sendMessage("§cUtilisation: /bank withdraw <montant>");
                    return true;
                }
                try {
                    double amount = Double.parseDouble(args[1]);
                    double balance = economyManager.getPlayerBalance(player);
                    if (balance < amount) {
                        player.sendMessage("§cFonds insuffisants! Votre solde: $" + balance);
                    } else {
                        economyManager.removeBalance(player, amount);
                        player.sendMessage("§a✓ Retrait de $" + amount + " effectué!");
                    }
                } catch (NumberFormatException e) {
                    player.sendMessage("§cLe montant doit être un nombre.");
                }
                break;
            default:
                showBankMenu(player);
                break;
        }
        return true;
    }

    private void showBankMenu(Player player) {
        player.sendMessage("§a§l=== Banque ===");
        player.sendMessage("§f/bank balance - Affiche votre solde");
        player.sendMessage("§f/bank deposit <montant> - Déposer de l'argent");
        player.sendMessage("§f/bank withdraw <montant> - Retirer de l'argent");
    }

    private void showBalance(Player player) {
        double balance = economyManager.getPlayerBalance(player);
        player.sendMessage("§a✓ Votre solde bancaire: §f$" + balance);
    }
}
