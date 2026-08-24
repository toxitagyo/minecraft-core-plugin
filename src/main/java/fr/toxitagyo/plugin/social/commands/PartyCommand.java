package fr.toxitagyo.plugin.social.commands;

import fr.toxitagyo.plugin.social.SocialManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommand implements CommandExecutor {
    private SocialManager socialManager;

    public PartyCommand(SocialManager socialManager) {
        this.socialManager = socialManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;
        player.sendMessage("§a§l=== Party ===");
        player.sendMessage("§fSystème de party en développement...");
        return true;
    }
}
