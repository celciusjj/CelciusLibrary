package com.celcius.celciuslibrary.utils;

import org.bukkit.OfflinePlayer;

public interface IReplacementHook {
    String replace(OfflinePlayer player, OfflinePlayer target, String str,String text);
}
