package net.magma_mc.magmatech.procedure;

import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;

import net.magma_mc.magmatech.ElementsMagmaTechMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@ElementsMagmaTechMod.ModElement.Tag
public class ProcedureInputBlockTemplate extends ElementsMagmaTechMod.ModElement {
	public ProcedureInputBlockTemplate(ElementsMagmaTechMod instance) {
		super(instance, 29);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure InputBlockTemplate!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure InputBlockTemplate!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure InputBlockTemplate!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure InputBlockTemplate!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double MaxMT = 0;
		double Energy = 0;
		double ExtractNumb = 0;
		MaxMT = (double) 5000;
		ExtractNumb = (double) 15;
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
				_tileEntity.getTileData().setDouble("MaxMT", (MaxMT));
			world.notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if ((((new Object() {
			public int extractEnergySimulate(World world, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						_retval.set(capability.extractEnergy(_amount, true));
				}
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos((int) x, (int) (y + 1), (int) z), (int) (ExtractNumb))) == (ExtractNumb))
				&& ((Energy) < (MaxMT)))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y + 1), (int) z));
				int _amount = (int) (MaxMT);
				if (_ent != null && _ent.hasCapability(CapabilityEnergy.ENERGY, null)) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null && capability.canExtract()) {
						capability.extractEnergy(_amount, false);
					}
				}
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (MaxMT)));
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
		}
		if ((((new Object() {
			public int extractEnergySimulate(World world, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						_retval.set(capability.extractEnergy(_amount, true));
				}
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos((int) x, (int) (y - 1), (int) z), (int) (ExtractNumb))) == (ExtractNumb))
				&& ((Energy) < (MaxMT)))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y - 1), (int) z));
				int _amount = (int) (ExtractNumb);
				if (_ent != null && _ent.hasCapability(CapabilityEnergy.ENERGY, null)) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null && capability.canExtract()) {
						capability.extractEnergy(_amount, false);
					}
				}
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if ((((new Object() {
			public int extractEnergySimulate(World world, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						_retval.set(capability.extractEnergy(_amount, true));
				}
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos((int) (x + 1), (int) (y - 0), (int) (z - 0)), (int) (ExtractNumb))) == (ExtractNumb))
				&& ((Energy) < (MaxMT)))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 1), (int) (y - 0), (int) (z - 0)));
				int _amount = (int) (ExtractNumb);
				if (_ent != null && _ent.hasCapability(CapabilityEnergy.ENERGY, null)) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null && capability.canExtract()) {
						capability.extractEnergy(_amount, false);
					}
				}
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if ((((new Object() {
			public int extractEnergySimulate(World world, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						_retval.set(capability.extractEnergy(_amount, true));
				}
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos((int) (x - 1), (int) (y - 0), (int) (z - 0)), (int) (ExtractNumb))) == (ExtractNumb))
				&& ((Energy) < (MaxMT)))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 1), (int) (y - 0), (int) (z - 0)));
				int _amount = (int) (ExtractNumb);
				if (_ent != null && _ent.hasCapability(CapabilityEnergy.ENERGY, null)) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null && capability.canExtract()) {
						capability.extractEnergy(_amount, false);
					}
				}
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if ((((new Object() {
			public int extractEnergySimulate(World world, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						_retval.set(capability.extractEnergy(_amount, true));
				}
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos((int) (x - 0), (int) (y - 0), (int) (z + 1)), (int) (ExtractNumb))) == (ExtractNumb))
				&& ((Energy) < (MaxMT)))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 0), (int) (y - 0), (int) (z + 1)));
				int _amount = (int) (ExtractNumb);
				if (_ent != null && _ent.hasCapability(CapabilityEnergy.ENERGY, null)) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null && capability.canExtract()) {
						capability.extractEnergy(_amount, false);
					}
				}
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if ((((new Object() {
			public int extractEnergySimulate(World world, BlockPos pos, int _amount) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null)
						_retval.set(capability.extractEnergy(_amount, true));
				}
				return _retval.get();
			}
		}.extractEnergySimulate(world, new BlockPos((int) (x - 0), (int) (y - 0), (int) (z - 1)), (int) (ExtractNumb))) == (ExtractNumb))
				&& ((Energy) < (MaxMT)))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 0), (int) (y - 0), (int) (z - 1)));
				int _amount = (int) (ExtractNumb);
				if (_ent != null && _ent.hasCapability(CapabilityEnergy.ENERGY, null)) {
					IEnergyStorage capability = _ent.getCapability(CapabilityEnergy.ENERGY, null);
					if (capability != null && capability.canExtract()) {
						capability.extractEnergy(_amount, false);
					}
				}
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if ((((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)), "MT")) >= (ExtractNumb)) && ((Energy) < (MaxMT)))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)), "MT")) - (ExtractNumb)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if ((((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0)), "MT")) >= (ExtractNumb)) && ((Energy) < (MaxMT)))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0)), "MT")) - (ExtractNumb)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if ((((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) (x + 1), (int) (y - 0), (int) (z + 0)), "MT")) >= (ExtractNumb)) && ((Energy) < (MaxMT)))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y - 0), (int) (z + 0));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (x + 1), (int) (y - 0), (int) (z + 0)), "MT")) - (ExtractNumb)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if ((((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) (x - 1), (int) (y - 0), (int) (z + 0)), "MT")) >= (ExtractNumb)) && ((Energy) < (MaxMT)))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 0), (int) (z + 0));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (x - 1), (int) (y - 0), (int) (z + 0)), "MT")) - (ExtractNumb)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if ((((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) (x - 0), (int) (y - 0), (int) (z + 1)), "MT")) >= (ExtractNumb)) && ((Energy) < (MaxMT)))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) (x - 0), (int) (y - 0), (int) (z + 1));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (x - 0), (int) (y - 0), (int) (z + 1)), "MT")) - (ExtractNumb)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if ((((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) (x - 0), (int) (y - 0), (int) (z - 1)), "MT")) >= (ExtractNumb)) && ((Energy) < (MaxMT)))) {
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) (x - 0), (int) (y - 0), (int) (z - 1));
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (x - 0), (int) (y - 0), (int) (z - 1)), "MT")) - (ExtractNumb)));
				world.notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
			if (!world.isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				IBlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().setDouble("MT", ((Energy) + (ExtractNumb)));
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
		}
		if (((Energy) > (MaxMT))) {
			Energy = (double) (MaxMT);
		}
		if (((Energy) > 0)) {
			Energy = (double) 0;
		}
	}
}
