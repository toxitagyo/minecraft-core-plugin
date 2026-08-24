package fr.toxitagyo.plugin.utility.commands;

import fr.toxitagyo.plugin.utility.UtilityManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChestCommand implements CommandExecutor {
    private UtilityManager utilityManager;

    public EnderChestCommand(UtilityManager utilityManager) {
        this.utilityManager = utilityManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;
        player.openEnderChest();
        player.sendMessage("§a✓ Ender Chest ouvert!");
        return true;
    }
}
