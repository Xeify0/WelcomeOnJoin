package me.xeify.welcome;

import com.google.gson.Gson;
import me.xeify.welcome.commands.WelcomeCommand;
import me.xeify.welcome.commands.readGreeting;
import me.xeify.welcome.events.JoinAndLeave;
import me.xeify.welcome.utils.GeneralUtils;
import me.xeify.welcome.utils.configs.ConfigFile;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;

import java.util.logging.Logger;

import java.io.*;

public final class Welcome extends JavaPlugin implements Listener {

    private static Welcome plugin;

    public static Welcome INSTANCE;

    private ConfigFile config;
    private boolean filesLoaded;

    PluginManager pm = Bukkit.getServer().getPluginManager();

    @Override
    public void onEnable() {

        INSTANCE = this;
        plugin = this;

        GeneralUtils.logMessage("Loading Welcome...");

        saveDefaultConfig();
        this.filesLoaded = this.loadFiles();

        pm.registerEvents(new JoinAndLeave(), this);
        checkStorage();
        this.getCommand("welcome").setExecutor((new WelcomeCommand()));
        this.getCommand("read").setExecutor((new readGreeting()));

        if (!this.filesLoaded) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }


    @Override
    public void onDisable() {
        GeneralUtils.logMessage("Welcome is disabling.");
        this.getServer().getScheduler().cancelTasks(this);
    }


    private void checkStorage() {
            File pluginDirectory = getDataFolder();
            if (!pluginDirectory.exists()) {
                pluginDirectory.mkdirs();
            }
        }

    public boolean loadFiles() {
            try {
                this.config = new ConfigFile(this, "config.yml");

                if (Welcome.INSTANCE.isEnabled()) {
                    GeneralUtils.logMessage("All files have been loaded correctly!");
                }
                return true;
            } catch (IOException | InvalidConfigurationException e) {
                if (!Welcome.INSTANCE.isEnabled()) return false;
                GeneralUtils.logMessage("&4&lERROR WHILE LOADING CONFIG");
                GeneralUtils.logMessage("&cPlease check for any configuration mistakes: ");
                GeneralUtils.logMessage("&4&lERROR WHILE LOADING CONFIG");
                e.printStackTrace();
                return false;
            }
        }
    }