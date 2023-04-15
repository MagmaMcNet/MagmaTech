package net.magma_mc.magmatech.procedure;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.energy.CapabilityEnergy;

import net.magma_mc.magmatech.ElementsMagmaTechMod;

import java.util.Map;

@ElementsMagmaTechMod.ModElement.Tag
public class ProcedureSolarPanel_Update extends ElementsMagmaTechMod.ModElement {
	public ProcedureSolarPanel_Update(ElementsMagmaTechMod instance) 
	{
		super(instance, 7);
	}
	
	public static void executeProcedure(Map<String, Object> dependencies) {
	    int x = (int) dependencies.get("x");
	    int y = (int) dependencies.get("y");
	    int z = (int) dependencies.get("z");
	    World world = (World) dependencies.get("world");
	
	    if (world.canSeeSky(new BlockPos(x, y, z)) && world.isDaytime()) {
	        // Get the number of adjacent blocks
	        int adjacentBlocksCount = 0;
	        EnumFacing[] directions = EnumFacing.values();
	        for (EnumFacing direction : directions) {
	            if (direction == EnumFacing.UP) {
	                continue;
	            }
	            BlockPos adjacentPos = new BlockPos(x + direction.getFrontOffsetX(), y + direction.getFrontOffsetY(), z + direction.getFrontOffsetZ());
	            if (world.isBlockLoaded(adjacentPos)) {
	                TileEntity adjacentTileEntity = world.getTileEntity(adjacentPos);
	                if (adjacentTileEntity != null && adjacentTileEntity.hasCapability(CapabilityEnergy.ENERGY, direction.getOpposite())) {
	                    adjacentBlocksCount++;
	                }
	            }
	        }
	
	        // Distribute the total energy equally among all adjacent blocks
	        if (adjacentBlocksCount > 0) {
	            int energyPerBlock = 100 / adjacentBlocksCount;
	
	            for (EnumFacing direction : directions) {
	                if (direction == EnumFacing.UP) {
	                    continue;
	                }
	                BlockPos adjacentPos = new BlockPos(x + direction.getFrontOffsetX(), y + direction.getFrontOffsetY(), z + direction.getFrontOffsetZ());
	                if (world.isBlockLoaded(adjacentPos)) {
	                    TileEntity adjacentTileEntity = world.getTileEntity(adjacentPos);
	                    if (adjacentTileEntity != null && adjacentTileEntity.hasCapability(CapabilityEnergy.ENERGY, direction.getOpposite())) {
	                        IEnergyStorage adjacentEnergyStorage = adjacentTileEntity.getCapability(CapabilityEnergy.ENERGY, direction.getOpposite());
	                        if (adjacentEnergyStorage != null && adjacentEnergyStorage.canReceive()) {
	                            adjacentEnergyStorage.receiveEnergy(energyPerBlock, false);
	                        }
	                    }
	                }
	            }
	        }
	    }
	}
}
