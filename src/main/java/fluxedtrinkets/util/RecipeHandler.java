package fluxedtrinkets.util;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import fluxedtrinkets.api.SolderingRecipe;
import fluxedtrinkets.blocks.FTBlocks;
import fluxedtrinkets.items.FTItems;

public class RecipeHandler {

	public static void init() {
		registerOreDict();
		registerRecipes();

	}

	private static void registerOreDict() {
		OreDictionary.registerOre("wireLead", FTItems.leadWire);
		OreDictionary.registerOre("circuit", FTItems.circuit);
		OreDictionary.registerOre("circuitAdvanced", FTItems.advancedCircuit);
	}

	private static void registerRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(FTBlocks.solderingStation, new Object[] { "gcg", "ili", "i i", 'l', "wireLead", 'g', "gearInvar", 'c', new ItemStack(Blocks.crafting_table), 'i', "ingotInvar" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTBlocks.trinketAssembler, new Object[] { "gcg", "ili", "ici", 'l', "wireLead", 'g', "gearInvar", 'c', new ItemStack(Blocks.crafting_table), 'i', "ingotInvar" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(FTItems.leadWire, 6), new Object[] { "l  ", "l  ", "l  ", 'l', "ingotLead" }));
		GameRegistry.addRecipe(new ItemStack(FTItems.modularBelt), new Object[] { "iii", "i i", "iii", 'i', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(FTItems.modularRing), new Object[] { " i ", "i i", " i ", 'i', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(FTItems.modularAmulet), new Object[] { " bb", "ibb", "ii ", 'i', new ItemStack(Items.iron_ingot), 'b', new ItemStack(Blocks.iron_bars) });
		GameRegistry.addRecipe(new ShapedOreRecipe(FTItems.solderingIron, new Object[] { " ic", " li", "b  ", 'l', "wireLead", 'c', "ingotCopper", 'i', "nuggetIron", 'b', FTItems.basicBattery }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTItems.basicBattery, new Object[] { " w ", "lrl", "lsl", 'w', "wireLead", 'l', "ingotLead", 'r', Items.redstone, 's', "dustSulfur" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTItems.circuit, new Object[] { "sws", "ccc", "ooo", 's', "dustSulfur", 'w', Items.water_bucket, 'c', "dustCopper", 'o', "dustObsidian" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTItems.advancedCircuit, new Object[] { "rsr", "scs", "rsr", 's', "nuggetSignalum", 'r', Items.redstone, 'c', FTItems.circuit }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTBlocks.machineCube, new Object[] { "iei", "ece", "iei", 'i', "ingotInvar", 'e', "ingotIron", 'c', FTItems.circuit }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTBlocks.heatGenerator, new Object[] { "iei", "ece", "iei", 'i', FTItems.circuitFire, 'e', Blocks.furnace, 'c', FTBlocks.machineCube }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTBlocks.kineticGenerator, new Object[] { "iei", "ece", "iei", 'i', FTItems.circuitEarth, 'e', FTItems.circuitAir, 'c', FTBlocks.machineCube }));
		GameRegistry.addRecipe(new ShapedOreRecipe(FTItems.ftWrench, new Object[] { "  i", " c ", "i  ", 'i', Items.iron_ingot, 'c', "ingotInvar" }));
		GameRegistry.addShapelessRecipe(new ItemStack(FTItems.manual), new ItemStack(FTItems.basicBattery), new ItemStack(Items.book));
		
		SolderingRecipe.addRecipe(new ItemStack(FTItems.circuit), new ItemStack(Blocks.dirt), new ItemStack(Blocks.dirt), new ItemStack(Blocks.dirt), new ItemStack(Blocks.dirt), new ItemStack(FTItems.advancedCircuit));
	}

}
