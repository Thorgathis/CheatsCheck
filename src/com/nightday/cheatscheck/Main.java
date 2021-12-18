package com.nightday.cheatscheck;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static Main instance;

	public static Main getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		this.saveDefaultConfig();
		this.getConfig();
		this.saveConfig();
		FileConfiguration config = this.getConfig();
		config.addDefault("Message", "сообщение");
		config.addDefault("Title", "текст");
		config.addDefault("SubTitle", "подтекст");
		config.addDefault("Time", 120);

		Bukkit.getPluginManager().registerEvents(new Handler(), this);
		Bukkit.getPluginCommand("cheatscheck").setExecutor(new Give());
	}
	

	
}