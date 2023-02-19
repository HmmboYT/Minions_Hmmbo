package com.hmmbo.minion;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Maiin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new minionlist(this,this),this);
        Bukkit.getPluginManager().registerEvents(new minionplace(this,this),this);
        Objects.requireNonNull(getCommand("minions")).setExecutor(new minioncmd(this,this ));


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
