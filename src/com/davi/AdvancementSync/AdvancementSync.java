package com.davi.AdvancementSync;

import org.bukkit.plugin.java.JavaPlugin;

public class AdvancementSync extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ListenerAdv(), this);
        this.getCommand("scan").setExecutor(new CommandScan());
        this.getCommand("scanprogress").setExecutor(new CommandProgress());
    }

    @Override
    public void onDisable() {

    }
}
