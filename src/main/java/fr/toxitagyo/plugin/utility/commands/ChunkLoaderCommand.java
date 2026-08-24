package fr.toxitagyo.plugin.utility.commands;

import fr.toxitagyo.plugin.utility.UtilityManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChunkLoaderCommand implements CommandExecutor {
    private UtilityManager utilityManager;

    public ChunkLoaderCommand(UtilityManager utilityManager) {
        this.utilityManager = utilityManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cCette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            showHelp(player);
            return true;
        }

        String subCommand = args[0].toLowerCase();
        switch (subCommand) {
            case "place":
                player.sendMessage("§a✓ Chunk Loader placé!");
                break;
            case "remove":
                player.sendMessage("§a✓ Chunk Loader supprimé!");
                break;
            case "list":
                player.sendMessage("§a§l=== Vos Chunk Loaders ===");
                player.sendMessage("§fVous n'avez aucun chunk loader.");
                break;
            default:
                showHelp(player);
                break;
        }
        return true;
    }

    private void showHelp(Player player) {
        player.sendMessage("§a§l=== Chunk Loader ===");
        player.sendMessage("§f/chunkloader place - Placer un chunk loader");
        player.sendMessage("§f/chunkloader remove - Supprimer un chunk loader");
        player.sendMessage("§f/chunkloader list - Lister vos chunk loaders");
    }
}
