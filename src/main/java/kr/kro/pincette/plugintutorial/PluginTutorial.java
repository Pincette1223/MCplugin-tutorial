package kr.kro.pincette.plugintutorial;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class PluginTutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.print("[PluginTutorial] 플러그인이 가동되었습니다.\n");
    }

    @Override
    public void onDisable() {
        System.out.print("[PluginTutorial] 플러그인이 중지되었습니다.\n");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equals("tutorial")) {
            if(sender instanceof Player) {
                sender.sendMessage("안녕하세요, "+ sender.getName() + "님!");
            }
            else if(sender instanceof ConsoleCommandSender) {
                sender.sendMessage("안녕하세요!");
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> players_name = new ArrayList<>();

        for(Player players : Bukkit.getOnlinePlayers()) {
            players_name.add(players.getName());
        }

        if(command.getName().equals("tutorial")) {

            List<String> returns1 = new ArrayList<>();

            for(String returns : players_name) {
                if(returns.toLowerCase().startsWith(args[0].toLowerCase())) {
                    returns1.add(returns);
                }
            }

           if(args.length == 1) {
               return returns1;
           }
        }
        return null;
    }
}
