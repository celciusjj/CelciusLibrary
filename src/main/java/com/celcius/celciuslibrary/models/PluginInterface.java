package com.celcius.celciuslibrary.models;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginLogger;

public interface PluginInterface {
    FileConfiguration getConfig();
    FileConfiguration getLang();
    void setServerVersion();
    PluginLogger getLogger();
}