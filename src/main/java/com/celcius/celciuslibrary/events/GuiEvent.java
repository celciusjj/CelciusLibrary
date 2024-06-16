package com.celcius.celciuslibrary.events;
import com.celcius.celciuslibrary.utils.GuiManager;
import com.celcius.celciuslibrary.utils.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class GuiEvent implements Listener {
    private final GuiManager guiManager = new GuiManager();

    @EventHandler
    public void onOpen(InventoryOpenEvent event) {

        if (event.isCancelled()) return;

        if (event.getInventory().getHolder() instanceof Menu) guiManager.onOpen(event);

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (event.isCancelled()) return;

        //if (event.getInventory().getHolder() instanceof Menu) guiManager.onClick(event);

        guiManager.onClick(event);
    }

    @EventHandler
    public void onDrag(InventoryDragEvent event) {

        if (event.isCancelled()) return;

        if (event.getInventory().getHolder() instanceof Menu) guiManager.onDrag(event);

    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {

        if (event.getInventory().getHolder() instanceof Menu) guiManager.onClose(event);

    }
}
