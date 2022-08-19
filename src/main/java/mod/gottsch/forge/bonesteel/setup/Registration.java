/*
 * This file is part of  Bone Steel.
 * Copyright (c) 2022 Mark Gottschling (gottsch)
 *
 * Bone Steel is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bone Steel is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Bone Steel.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package mod.gottsch.forge.bonesteel.setup;

import mod.gottsch.forge.bonesteel.BoneSteel;
import mod.gottsch.forge.bonesteel.item.ModArmorMaterials;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Mark Gottschling on Aug 16, 2022
 *
 */
public class Registration {
	/*
	 * deferred registries
	 */
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BoneSteel.MODID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BoneSteel.MODID);
	
	/*
	 * ores (blocks) 
	 */
	public static final RegistryObject<Block> TITANIUM_ORE = BLOCKS.register("titanium_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2F).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = BLOCKS.register("deepslate_titanium_ore",
			() -> new Block(BlockBehaviour.Properties.copy(TITANIUM_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));

	/*
	 * blocks
	 */
	public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5F, 6F).sound(SoundType.METAL)));
	
	public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(CommonSetup.ITEM_GROUP);
	/*
	 * ores (items)
	 */
	public static final RegistryObject<Item> TITANIUM_ORE_ITEM = fromBlock(TITANIUM_ORE, ITEM_PROPERTIES);
	public static final RegistryObject<Item> DEEPSLATE_TITANIUM_ORE_ITEM = fromBlock(DEEPSLATE_TITANIUM_ORE, ITEM_PROPERTIES);
	public static final RegistryObject<Item> TITANIUM_BLOCK_ITEM = fromBlock(TITANIUM_BLOCK, ITEM_PROPERTIES);
	
	/*
	 * raw ores (items)
	 */
	public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(ITEM_PROPERTIES));
	
	/*
	 *  ingots
	 */
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(ITEM_PROPERTIES));
	public static final RegistryObject<Item> BONE_STEEL_INGOT = ITEMS.register("bone_steel_ingot", () -> new Item(ITEM_PROPERTIES));
	public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(ITEM_PROPERTIES));
	public static final RegistryObject<Item> AUTIUM_INGOT = ITEMS.register("autium_ingot", () -> new Item(ITEM_PROPERTIES));
	
	/*
	 * tiers
	 */
	public static final ForgeTier BONE = new ForgeTier(2, 200, 6.25F, 2F, 16, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.BONE));
	public static final ForgeTier STEEL = new ForgeTier(2, 600, 6.5F, 2.25F, 15, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(STEEL_INGOT.get()));
	public static final ForgeTier BONE_STEEL = new ForgeTier(2, 550, 7F, 2.25F, 17, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(BONE_STEEL_INGOT.get()));
	public static final ForgeTier TITANIUM = new ForgeTier(2, 1300, 7F, 2.5F, 12, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(TITANIUM_INGOT.get()));
	public static final ForgeTier AUTIUM = new ForgeTier(2, 1200, 11F, 2.25F, 20, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(AUTIUM_INGOT.get()));
	
	/*
	 * armor materials
	 */
	
	/*
	 * weapons
	 */
	public static final RegistryObject<Item> BONE_SWORD = ITEMS.register("bone_sword", () -> new SwordItem(BONE, 3, -2.4F, ITEM_PROPERTIES));
	public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(STEEL, 3, -2.4F, ITEM_PROPERTIES));
	public static final RegistryObject<Item> BONE_STEEL_SWORD = ITEMS.register("bone_steel_sword", () -> new SwordItem(BONE_STEEL, 3, -2.4F, ITEM_PROPERTIES));
	public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () -> new SwordItem(TITANIUM, 3, -2.4F, ITEM_PROPERTIES));
	public static final RegistryObject<Item> AUTIUM_SWORD = ITEMS.register("autium_sword", () -> new SwordItem(AUTIUM, 3, -2.4F, ITEM_PROPERTIES));

	/*
	 * tools
	 */
	public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () -> new AxeItem(TITANIUM, 5, -3.1F, ITEM_PROPERTIES));
	public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () -> new HoeItem(TITANIUM, -3, 0F, ITEM_PROPERTIES));	
	public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () -> new PickaxeItem(TITANIUM, 1, -2.8F, ITEM_PROPERTIES));
	public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () -> new ShovelItem(TITANIUM, 1.5F, -3F, ITEM_PROPERTIES));
	
//	   public static final Item IRON_SHOVEL = registerItem("iron_shovel", new ShovelItem(Tiers.IRON, 1.5F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
//	   public static final Item IRON_PICKAXE = registerItem("iron_pickaxe", new PickaxeItem(Tiers.IRON, 1, -2.8F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
//	   public static final Item IRON_AXE = registerItem("iron_axe", new AxeItem(Tiers.IRON, 6.0F, -3.1F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
//	   public static final Item IRON_HOE = registerItem("iron_hoe", new HoeItem(Tiers.IRON, -2, -1.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
//	   
//	   public static final Item DIAMOND_SHOVEL = registerItem("diamond_shovel", new ShovelItem(Tiers.DIAMOND, 1.5F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
//	   public static final Item DIAMOND_PICKAXE = registerItem("diamond_pickaxe", new PickaxeItem(Tiers.DIAMOND, 1, -2.8F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
//	   public static final Item DIAMOND_AXE = registerItem("diamond_axe", new AxeItem(Tiers.DIAMOND, 5.0F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS)));
//	   public static final Item DIAMOND_HOE = registerItem("diamond_hoe", new HoeItem(Tiers.DIAMOND, -3, 0.0F, (new Item.Propert
	
	/*
	 * armor
	 */
	public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet", () -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlot.HEAD, ITEM_PROPERTIES));
	public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate", () -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlot.CHEST, ITEM_PROPERTIES));
	public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings", () -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlot.LEGS, ITEM_PROPERTIES));
	public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots", () -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlot.FEET, ITEM_PROPERTIES));
	
	//	public static final Item IRON_LEGGINGS = registerItem("iron_leggings", new ArmorItem(ArmorMaterials.IRON, EquipmentSlot.LEGS, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT)));
	public static void init() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		BLOCKS.register(eventBus);
		ITEMS.register(eventBus);
	}
	
	// conveniance method: take a RegistryObject<Block> and make a corresponding RegistryObject<Item> from it
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, Item.Properties itemProperties) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), itemProperties));
    }
}
