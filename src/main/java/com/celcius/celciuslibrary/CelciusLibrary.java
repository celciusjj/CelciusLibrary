package com.celcius.celciuslibrary;
import com.celcius.celciuslibrary.models.PluginInterface;
import com.celcius.celciuslibrary.utils.Chat;
import com.celcius.celciuslibrary.utils.IReplacementHook;
import com.celcius.celciuslibrary.utils.Menu;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CelciusLibrary {
    private final ConcurrentHashMap<UUID, Menu> openedMenus = new ConcurrentHashMap<>();
    private Chat chat;
    private static PluginInterface plugin;
    private static CelciusLibrary instance;
    public String serverVersion;

    public static synchronized CelciusLibrary getInstance() {
        if (instance == null) {
            instance = new CelciusLibrary();
        }
        return instance;
    }
    // CHAT SETUP FOR PLUGINS
    public void setupChat(String identifier, IReplacementHook hookValue){
        this.chat = new Chat();
        chat.registerHook(identifier, hookValue);
    }


    public Map<UUID, Menu> getPlayerOpenMenu() {
        return this.openedMenus;
    }

    public String getServerVersion() {
        if (this.serverVersion == null || this.serverVersion.isEmpty()) plugin.setServerVersion();
        return this.serverVersion;
    }

    public PluginInterface getPlugin() {
        return plugin;
    }

    public void setPlugin(final PluginInterface plugin) {
        this.plugin = plugin;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public enum DatabaseType {
        MYSQL, SQLITE
    }
}