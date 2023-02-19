package com.hmmbo.minion;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class minionlist implements Listener {
    Cuboid cuboid;
    Plugin plugin;
    Maiin maiin;
    public List<Material> blockslist;

    public minionlist(Plugin pluign, Maiin maiin) {
        this.plugin = pluign;
        this.maiin = maiin;
    }
    public void bb(){
        blockslist.add(Material.STONE);
        blockslist.add(Material.COAL_ORE);
    }

    public List firstspawn(World world,int x1, int y1, int z1,int x2,int y2,int z2,Location loli) {
        List<Location> locations = new ArrayList<>();
        while(x1<x2&&z1<z2){
            for (int i = x1; i < x2; i++) {
                Location lol = new Location(world,i, y1, z1);
                if(lol!=loli)
                {locations.add(lol);}
            }
            for (int i = x1; i < x2; i++) {
                Location lol = new Location(world,i, y1, z2);
                if(lol!=loli)
                {locations.add(lol);}
            }
            for (int i = z1; i < z2; i++) {
                Location lol = new Location(world,x1, y1, i);
                if(lol!=loli)
                {locations.add(lol);}
            }
            for (int i = z1; i <= z2; i++) {
                Location lol = new Location(world,x2, y1, i);
                if(lol!=loli)
                {locations.add(lol);}
            }
            x1++;
            z1++;
        }
        return locations;


    }




    public void spawnerr(List<Location> lmao, World world,Location lax,Material mat){

        int i=1;
        for (Location loc : lmao) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (loc.getBlock().getType() == Material.AIR) {
                        Block block = loc.getBlock();
                        block.setType(mat);

                        placer(lmao,world,lax,mat);
                    }
                }
            }.runTaskLater(plugin, 20 * i); //delay of 20s
            i++;
        }


    }
    public boolean Boolean(Location lax){
        for(Entity goblin1 : lax.getWorld().getNearbyEntities(lax, 1, 1, 1)) {
            if(goblin1.getName().contains("minion")){
                return true;
            }
        }

        return false;
    }
    public void supspawnerr(Location loc, World world,Location lax,Material mat) {
        if (Boolean(lax)) {

            int i = 1;
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (loc.getBlock().getType() == Material.AIR) {
                        Block block = loc.getBlock();
                        block.setType(mat);

                    }
                }
            }.runTaskLater(plugin, 20 * i); //delay of 20s

        }
    }


    public void placer(List<Location> lmao, World world,Location lax, Material mat) {

            int i = 1, flag = 1;
            for (Location loc : lmao) {
                if (loc.getBlock().getType() == Material.AIR) {
                    flag = 0;
                }
            }
            if (flag == 1) {
                for (Location loc : lmao) {


                    new BukkitRunnable() {
                        int num=0;

                        @Override
                        public void run() {
                            for (Material i : blockslist) {
                                if (loc.getBlock().getType() == i) {
                                    Block block = loc.getBlock();
                                    if (Boolean(lax)) {
                                        block.breakNaturally();
                                    }
                                    Bukkit.getScheduler().runTaskLater(plugin, () -> {

                                        supspawnerr(loc, world, lax,mat);
                                    }, 20);
                                }
                            }
                        }
                    }.runTaskLater(plugin, 200 * i); //delay of 20s
                    i++;
                }

            }
        }
        public int val = 0;
        public Integer into(Integer inta){
        val = inta;
        return val;
        }
        public Integer interger(){
        return  val;
        }
    @EventHandler
    public final void lefto(PlayerInteractEntityEvent e){
        e.setCancelled(true);
        if (e.getRightClicked().getType() == EntityType.ARMOR_STAND) {
           Inventory inv = Bukkit.createInventory(e.getPlayer(),InventoryType.CHEST,"Storage");
           inv.addItem(new ItemStack(Material.STONE,interger()));
        }
    }




    public List<Location> mixer(List<Location> l, World world){
        Collections.shuffle(l);
        return l;
    }

    public void createcube(World world, Integer x1, Integer y1, Integer z1, Integer x2, Integer y2, Integer z2) {
        cuboid = new Cuboid(world, x1, y1, z1, x2, y2, z2);
    }

    @EventHandler
    public void onarmorplace(EntitySpawnEvent event) {
        if (event.getEntity().getType() == EntityType.ARMOR_STAND) {
            ArmorStand stand = (ArmorStand) event.getEntity();
            Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, new Runnable() {
                int num = 245;

                @Override
                public void run() {
                    if (num < 360) {
                        stand.setRightArmPose(new EulerAngle(Math.toRadians(num), 0, 0));
                        num = num + 5;
                    } else if (num == 360) {
                        num = 245;
                    }
                }
            }, 0, 4);

        }
    }

    @EventHandler
    public void onarmor(EntitySpawnEvent event) {
        if (event.getEntity().getType() == EntityType.ARMOR_STAND) {
            ArmorStand stand = (ArmorStand) event.getEntity();
                Location loc = event.getEntity().getLocation();
                createcube(event.getLocation().getWorld(), loc.getBlockX() - 2, loc.getBlockY() - 1, loc.getBlockZ() - 2,
                        loc.getBlockX() + 2, loc.getBlockY() - 1, loc.getBlockZ() + 2);
                int x1= Math.min(cuboid.x1, cuboid.x2);
            int x2= Math.max(cuboid.x1, cuboid.x2);
            int z1= Math.min(cuboid.z1, cuboid.z2);
            int z2= Math.max(cuboid.z1, cuboid.z2);
            Material mat=null;
            Location lax = event.getEntity().getLocation();
             List<Location> loca = firstspawn(event.getLocation().getWorld(),cuboid.x1,cuboid.y1,cuboid.z1,cuboid.x2,cuboid.y2, cuboid.z2,event.getEntity().getLocation().add(0,-1,0));
             List<Location> fl= mixer(loca,loc.getWorld());
             if(stand.getName().equals("Stone minion")){
                 mat =Material.STONE;
             }
            if(stand.getName().equals("Coal minion")){
                mat =Material.COAL_ORE;
            }
             spawnerr(fl,loc.getWorld(),lax,mat);

             //spawner(fl, loc.getWorld());
             //breaker(fl,loc.getWorld());
        }
    }

    @EventHandler
    public void blockregen(BlockBreakEvent e) {
        if(cuboid != null) {
            if (cuboid.contains(e.getBlock().getLocation())) {
                e.setCancelled(true);

            }
        }
    }

}
