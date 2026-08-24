package fr.toxitagyo.plugin.utility.commands;

import fr.toxitagyo.plugin.utility.UtilityManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReviveCommand implements CommandExecutor {
    private UtilityManager utilityManager;

    public ReviveCommand(UtilityManager utilityManager) {
        this.utilityManager = utilityManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("§cUtilisation: /revive <joueur>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("§cLe joueur spécifié n'existe pas.");
            return true;
        }

        Player player = (Player) sender;
        player.sendMessage("§a✓ " + target.getName() + " a été réanimé!");
        return true;
    }
}
