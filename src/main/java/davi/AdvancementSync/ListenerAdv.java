package davi.AdvancementSync;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class ListenerAdv implements Listener {
    @EventHandler
    public void onAdv(PlayerAdvancementDoneEvent event) {
        String adv_name = event.getAdvancement().getKey().getKey();
        if (!adv_name.startsWith("recipes/")) {
            String cmd = "advancement grant @a only minecraft:" + adv_name;
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd);
        }
    }
}
