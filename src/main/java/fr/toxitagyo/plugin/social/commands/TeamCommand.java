package fr.toxitagyo.plugin.social.commands;

import fr.toxitagyo.plugin.social.SocialManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamCommand implements CommandExecutor {
    private SocialManager socialManager;

    public TeamCommand(SocialManager socialManager) {
        this.socialManager = socialManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cUtilisation: /team <joueur>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("§cLe joueur spécifié n'existe pas.");
            return true;
        }

        String team = socialManager.getPlayerTeam(target.getUniqueId());
        sender.sendMessage("§a" + target.getName() + " est dans l'équipe: §f" + team);
        return true;
    }
}
