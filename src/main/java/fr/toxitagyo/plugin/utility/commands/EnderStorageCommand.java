package fr.toxitagyo.plugin.utility.commands;

import fr.toxitagyo.plugin.utility.UtilityManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderStorageCommand implements CommandExecutor {
    private UtilityManager utilityManager;

    public EnderStorageCommand(UtilityManager utilityManager) {
        this.utilityManager = utilityManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;
        player.sendMessage("§a§l=== Ender Storage ===");
        player.sendMessage("§fVotre stockage Ender est vide.");
        player.sendMessage("§fTrouvez ou créez une Ender Pouch pour accéder à votre stockage partagé!");
        return true;
    }
}
