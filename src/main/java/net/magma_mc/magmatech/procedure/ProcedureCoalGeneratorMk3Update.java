package net.magma_mc.magmatech.procedure;

import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.block.state.IBlockState;

import net.magma_mc.magmatech.ElementsMagmaTechMod;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;

@ElementsMagmaTechMod.ModElement.Tag
public class ProcedureCoalGeneratorMk3Update extends ElementsMagmaTechMod.ModElement {
	public ProcedureCoalGeneratorMk3Update(ElementsMagmaTechMod instance) {
		super(instance, 25);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CoalGeneratorMk3Update!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CoalGeneratorMk3Update!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CoalGeneratorMk3Update!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CoalGeneratorMk3Update!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double Generation = 0;
		double MaxBuffer = 0;
		double MaxMT = 0;
		double Tick = 0;
		double Energy = 0;
		Generation = (double) 35;
		MaxBuffer = (double) 512;
		MaxMT = (double) 286720;
		Generation = (double) ((Generation) * (((new Object() {
			public int getAmount(BlockPos pos, int sltid) {
				TileEntity inv = world.getTileEntity(pos);
				if (inv instanceof TileEntityLockableLoot) {
					ItemStack stack = ((TileEntityLockableLoot) inv).getStackInSlot(sltid);
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (2))) * 0.25) + 1));
		MaxBuffer = (double) ((MaxBuffer) * (((new Object() {
			public int getAmount(BlockPos pos, int sltid) {
				TileEntity inv = world.getTileEntity(pos);
				if (inv instanceof TileEntityLockableLoot) {
					ItemStack stack = ((TileEntityLockableLoot) inv).getStackInSlot(sltid);
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (1))) * 0.35) + 1));
		Energy = (double) (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "MT"));
		Tick = (double) (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "Tick"));
		if (!world.isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			IBlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().setDouble("MaxBuffer", (MaxBuffer));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			IBlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().setDouble("MaxMT", (MaxMT));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			IBlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().setDouble("Generation", (Generation));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			IBlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().setDouble("ItemValue", ((Generation) * (MaxBuffer)));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (((new Object() {
			public boolean canReceiveEnergy(World world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null) {
						_retval.set(capability.canReceive());
					}
				}
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) x, (int) (y + 1), (int) z))) && ((Energy) > 0))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) - (Generation)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			Energy = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "MT"));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y + 1), (int) z));
				int _amount = (int) (Generation);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						if (capability.canReceive() && capability.getEnergyStored() < capability.getMaxEnergyStored() - 5)
							capability.receiveEnergy(_amount, false);
				}
			}
		}
		if (((new Object() {
			public boolean canReceiveEnergy(World world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null) {
						_retval.set(capability.canReceive());
					}
				}
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) x, (int) (y - 1), (int) z))) && ((Energy) > 0))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) - (Generation)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			Energy = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "MT"));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y - 1), (int) z));
				int _amount = (int) (Generation);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						if (capability.canReceive() && capability.getEnergyStored() < capability.getMaxEnergyStored() - 5)
							capability.receiveEnergy(_amount, false);
				}
			}
		}
		if (((new Object() {
			public boolean canReceiveEnergy(World world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null) {
						_retval.set(capability.canReceive());
					}
				}
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) (x - 1), (int) (y - 0), (int) z))) && ((Energy) > 0))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) - (Generation)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			Energy = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "MT"));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 1), (int) (y - 0), (int) z));
				int _amount = (int) (Generation);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						if (capability.canReceive() && capability.getEnergyStored() < capability.getMaxEnergyStored() - 5)
							capability.receiveEnergy(_amount, false);
				}
			}
		}
		if (((new Object() {
			public boolean canReceiveEnergy(World world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null) {
						_retval.set(capability.canReceive());
					}
				}
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) (x + 1), (int) (y - 0), (int) z))) && ((Energy) > 0))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) - (Generation)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			Energy = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "MT"));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 1), (int) (y - 0), (int) z));
				int _amount = (int) (Generation);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						if (capability.canReceive() && capability.getEnergyStored() < capability.getMaxEnergyStored() - 5)
							capability.receiveEnergy(_amount, false);
				}
			}
		}
		if (((new Object() {
			public boolean canReceiveEnergy(World world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null) {
						_retval.set(capability.canReceive());
					}
				}
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) (x + 0), (int) (y - 0), (int) (z + 1)))) && ((Energy) > 0))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) - (Generation)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			Energy = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "MT"));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 0), (int) (y - 0), (int) (z + 1)));
				int _amount = (int) (Generation);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						if (capability.canReceive() && capability.getEnergyStored() < capability.getMaxEnergyStored() - 5)
							capability.receiveEnergy(_amount, false);
				}
			}
		}
		if (((new Object() {
			public boolean canReceiveEnergy(World world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null) {
						_retval.set(capability.canReceive());
					}
				}
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) (x + 0), (int) (y - 0), (int) (z - 1)))) && ((Energy) > 0))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) - (Generation)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			Energy = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "MT"));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 0), (int) (y - 0), (int) (z - 1)));
				int _amount = (int) (Generation);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						if (capability.canReceive() && capability.getEnergyStored() < capability.getMaxEnergyStored() - 5)
							capability.receiveEnergy(_amount, false);
				}
			}
		}
		if ((((Tick) > 0) && ((Energy) < (MaxMT)))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + ((Generation) * 1)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			Energy = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "MT"));
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("Tick", ((Tick) - 1));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((((Tick) <= 0) && ((new Object() {
			public int getAmount(BlockPos pos, int sltid) {
				TileEntity inv = world.getTileEntity(pos);
				if (inv instanceof TileEntityLockableLoot) {
					ItemStack stack = ((TileEntityLockableLoot) inv).getStackInSlot(sltid);
					if (stack != null)
						return stack.getCount();
				}
				return 0;
			}
		}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) != 0))) {
			{
				TileEntity inv = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
				if (inv != null && (inv instanceof TileEntityLockableLoot)) {
					ItemStack _setstack = new ItemStack(Items.COAL, (int) (1), 0);
					_setstack.setCount(((new Object() {
						public int getAmount(BlockPos pos, int sltid) {
							TileEntity inv = world.getTileEntity(pos);
							if (inv instanceof TileEntityLockableLoot) {
								ItemStack stack = ((TileEntityLockableLoot) inv).getStackInSlot(sltid);
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(new BlockPos((int) x, (int) y, (int) z), (int) (0))) - 1));
					((TileEntityLockableLoot) inv).setInventorySlotContents((int) (0), _setstack);
				}
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("Tick", (MaxBuffer));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if (((Energy) > (MaxMT))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", (MaxMT));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if (((Energy) < 0)) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", 0);
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
