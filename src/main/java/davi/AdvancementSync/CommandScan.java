package davi.AdvancementSync;

import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Iterator;

public class CommandScan implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("Usage: /scan <player>");
            return true;
        }
        Iterator<Advancement> iterator = Bukkit.advancementIterator();
        Player player = Bukkit.getPlayer(args[0]);
        while (iterator.hasNext()) {
            AdvancementProgress progress = player.getAdvancementProgress(iterator.next());
            if (!progress.getAdvancement().getKey().getKey().startsWith("recipes/")) {
                if (progress.isDone()) {
                    String adv_name = progress.getAdvancement().getKey().getKey();
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "advancement grant @a only minecraft:" + adv_name);
                }
            }
        }

        return true;
    }
}
