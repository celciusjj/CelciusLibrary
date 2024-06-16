package com.celcius.celciuslibrary.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColors {

    static final Pattern pattern =  Pattern.compile("#[a-fA-F0-9]{6}");

    public static String format(String msg){
            Matcher match = pattern.matcher(msg);
            while(match.find()) {
                String color = msg.substring(match.start(), match.end());
                msg = msg.replace(color, ChatColor.of(color) + "");
            }

        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static List<String> formatForList(List<String> msg){
        List<String> convertedList = new ArrayList<>();
        if(Bukkit.getVersion().contains("1.16")){
            for(int i = 0; i < msg.size(); i++){
                Matcher match = pattern.matcher(msg.get(i));
                while(match.find()) {
                    String color = msg.get(i).substring(match.start(), match.end());
                    convertedList.add(ChatColor.translateAlternateColorCodes('&',msg.get(i).replace(color, ChatColor.of(color) + "")));
                }
            }
        }
        return convertedList;
    }
}
