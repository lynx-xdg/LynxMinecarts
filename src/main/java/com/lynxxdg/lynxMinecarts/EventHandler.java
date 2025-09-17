package com.lynxxdg.lynxMinecarts;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class Eventhandler implements Listener {
    public static float VANILLA_MAX = 0.4F;
    @EventHandler(ignoreCancelled = true)
    private void onVehicleMovement(VehicleMoveEvent event) {
        if (event.getVehicle().getType() != EntityType.MINECART)
            return;

        Minecart minecart = (Minecart) event.getVehicle();
        if (minecart.isEmpty())
            return;
        if (minecart.getPassengers().getFirst().getType() != EntityType.PLAYER)
            return;
        minecart.setMaxSpeed(0.4 * 10.0);
    }

    @EventHandler(ignoreCancelled = true)
    private void onVehicleExit(VehicleExitEvent event) {
        if (event.getVehicle().getType() != EntityType.MINECART)
            return;
        Minecart minecart = (Minecart) event.getVehicle();
        if (minecart.getMaxSpeed() > VANILLA_MAX) {
            minecart.setMaxSpeed(VANILLA_MAX);
        }
    }
}
