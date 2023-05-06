package davi.AdvancementSync;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CommandProgress implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getLogger().info(ChatColor.RED + "This command is only executable as a Player.");
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage("Usage: /scanprogress <advancement name>");
            return true;
        }
        Iterator<Advancement> iterator = Bukkit.advancementIterator();
        Player player = Bukkit.getPlayer(sender.getName());
        Advancement adv = null;
        while (iterator.hasNext()) {
            Advancement iter = iterator.next();
            if (iter.getKey().getKey().equals(args[0])) {
                adv = iter;
                break;
            }
        }
        if (adv == null) {
            sender.sendMessage("Usage: /scanprogress <advancement name>");
            return true;
        }
        AdvancementProgress progress = player.getAdvancementProgress(adv);
        Collection<String> faltando = progress.getRemainingCriteria();
        String adv_name = progress.getAdvancement().getKey().getKey();
        List<String> criterios = new ArrayList<>(faltando);
        sender.sendMessage("Criteria remaining for " + adv_name + ": " + criterios.toString());
        return true;
    }
}
