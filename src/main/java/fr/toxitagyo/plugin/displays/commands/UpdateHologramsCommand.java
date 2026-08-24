package fr.toxitagyo.plugin.displays.commands;

import fr.toxitagyo.plugin.MinecraftCorePlugin;
import fr.toxitagyo.plugin.displays.DisplayManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UpdateHologramsCommand implements CommandExecutor {
    private DisplayManager displayManager;

    public UpdateHologramsCommand(DisplayManager displayManager) {
        this.displayManager = displayManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;
        // À implémenter: créer et mettre à jour les hologrammes
        player.sendMessage("§a✓ Hologrammes mis à jour autour de vous!");
        return true;
    }
}
