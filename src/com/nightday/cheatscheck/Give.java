package com.nightday.cheatscheck;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Give implements CommandExecutor{

	public void oncomm(Player p) {

			
			ItemStack stick = new ItemStack(Material.STICK);
			ItemMeta stickmeta = stick.getItemMeta();
			stickmeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 10, true);
			stick.setItemMeta(stickmeta);
			stick.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
			stick.setType(Material.STICK);
						p.getInventory().addItem(stick);
						p.updateInventory();

				
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("blocksell")) {
       	 Player p = (Player) sender;
       	 System.out.println("give stick");
        	oncomm(p);


        }
        return true;
}
	
}
