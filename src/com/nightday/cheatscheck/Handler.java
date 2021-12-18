package com.nightday.cheatscheck;

import static com.nightday.cheatscheck.Main.getInstance;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerInteractEntityEvent;

import org.bukkit.inventory.ItemStack;

public class Handler implements Listener {
	FileConfiguration config = getInstance().getConfig();
	@EventHandler
	public void onClick(PlayerInteractEntityEvent e) {
		if (e.getRightClicked().getType() != EntityType.PLAYER)
			return;
		ItemStack item = e.getPlayer().getInventory().getItem(e.getHand());
		Player p = (Player) e.getPlayer();
		Player c = (Player) e.getRightClicked();

		if (item != null && item.getType() == Material.STICK
				&& item.getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 10) {
			c.sendMessage(ChatColor.RED + config.getString("Message") + ChatColor.AQUA + p.getName());
			c.sendTitle(ChatColor.RED + config.getString("Title"),
					ChatColor.DARK_RED + config.getString("SubTitle"), 20,config.getInt("Time"), 20);
		}
	}
	
}