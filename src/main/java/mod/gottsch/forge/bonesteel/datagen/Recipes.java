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
package mod.gottsch.forge.bonesteel.datagen;

import java.util.function.Consumer;

import mod.gottsch.forge.bonesteel.setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * 
 * @author Mark Gottschling on Aug 17, 2022
 *
 */
public class Recipes extends RecipeProvider {

	public Recipes(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipe) {

		/*
		 * raw ores
		 */
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_TITANIUM.get()),
                Registration.TITANIUM_INGOT.get(), 1.0f, 200)
		.group("titanium_ingot")
        .unlockedBy("has_ore", inventoryTrigger(ItemPredicate.Builder.item().of(Registration.RAW_TITANIUM.get()).build()))
        .save(recipe, "titanium_ingot_from_raw");
		
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.TITANIUM_ORE.get()),
                Registration.TITANIUM_INGOT.get(), 1.0f, 200)
		.group("titanium_ingot")
        .unlockedBy("has_ore", inventoryTrigger(ItemPredicate.Builder.item().of(Registration.TITANIUM_ORE.get()).build()))
        .save(recipe, "titanium_ingot_from_ore");
		
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.DEEPSLATE_TITANIUM_ORE.get()),
                Registration.TITANIUM_INGOT.get(), 1.0f, 200)
		.group("titanium_ingot")
        .unlockedBy("has_ore", inventoryTrigger(ItemPredicate.Builder.item().of(Registration.DEEPSLATE_TITANIUM_ORE.get()).build()))
        .save(recipe, "titanium_ingot_from_deepslate_ore");
		
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.RAW_TITANIUM.get()),
                Registration.TITANIUM_INGOT.get(), 1.0f, 200)
		.group("titanium_ingot")
        .unlockedBy("has_ore", inventoryTrigger(ItemPredicate.Builder.item().of(Registration.RAW_TITANIUM.get()).build()))
        .save(recipe, "titanium_ingot_from_blasting_raw");

		SimpleCookingRecipeBuilder.blasting(Ingredient.of(Registration.TITANIUM_ORE.get()),
                Registration.TITANIUM_INGOT.get(), 1.0f, 200)
		.group("titanium_ingot")
        .unlockedBy("has_ore", inventoryTrigger(ItemPredicate.Builder.item().of(Registration.TITANIUM_ORE.get()).build()))
        .save(recipe, "titanium_ingot_from_blasting_ore");

		
		/*
		 * alloy ingots
		 */
        ShapelessRecipeBuilder.shapeless(Registration.STEEL_INGOT.get())
        .requires(Ingredient.of(Items.IRON_INGOT, Items.COAL))
        .group("steel_ingot")
        .unlockedBy("has_items", InventoryChangeTrigger.TriggerInstance.hasItems(Items.IRON_INGOT, Items.COAL))
        .save(recipe);
        
        ShapelessRecipeBuilder.shapeless(Registration.BONE_STEEL_INGOT.get())
        .requires(Ingredient.of(Registration.STEEL_INGOT.get(), Items.BONE))
        .group("bone_steel_ingot")
        .unlockedBy("has_items", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.STEEL_INGOT.get(), Items.BONE))
        .save(recipe);
        
        ShapelessRecipeBuilder.shapeless(Registration.AUTIUM_INGOT.get())
        .requires(Ingredient.of(Registration.TITANIUM_INGOT.get(), Items.GOLD_INGOT))
        .group("autium_ingot")
        .unlockedBy("has_items", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.TITANIUM_INGOT.get(), Items.GOLD_INGOT))
        .save(recipe);
        
		/*
		 * weapons
		 */
        ShapedRecipeBuilder.shaped(Registration.BONE_SWORD.get())
        .pattern(" x ")
        .pattern(" x ")
        .pattern(" s ")
        .define('x', Items.BONE)
        .define('s', Items.STICK)
        .group("bonesteel")
        .unlockedBy("has_bone", InventoryChangeTrigger.TriggerInstance.hasItems(Items.BONE))
        .save(recipe);
        
        ShapedRecipeBuilder.shaped(Registration.STEEL_SWORD.get())
        .pattern(" x ")
        .pattern(" x ")
        .pattern(" s ")
        .define('x', Registration.STEEL_INGOT.get())
        .define('s', Items.STICK)
        .group("bonesteel")
        .unlockedBy("has_steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.STEEL_INGOT.get()))
        .save(recipe);
        
        ShapedRecipeBuilder.shaped(Registration.BONE_STEEL_SWORD.get())
        .pattern(" x ")
        .pattern(" x ")
        .pattern(" s ")
        .define('x', Registration.BONE_STEEL_INGOT.get())
        .define('s', Items.STICK)
        .group("bonesteel")
        .unlockedBy("has_bone_steel_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BONE_STEEL_INGOT.get()))
        .save(recipe);
        
        ShapedRecipeBuilder.shaped(Registration.TITANIUM_SWORD.get())
        .pattern(" x ")
        .pattern(" x ")
        .pattern(" s ")
        .define('x', Registration.TITANIUM_INGOT.get())
        .define('s', Items.STICK)
        .group("bonesteel")
        .unlockedBy("has_titanium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.TITANIUM_INGOT.get()))
        .save(recipe);
        
        ShapedRecipeBuilder.shaped(Registration.AUTIUM_SWORD.get())
        .pattern(" x ")
        .pattern(" x ")
        .pattern(" s ")
        .define('x', Registration.AUTIUM_INGOT.get())
        .define('s', Items.STICK)
        .group("bonesteel")
        .unlockedBy("has_autium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.AUTIUM_INGOT.get()))
        .save(recipe);
        
        // tools
        ShapedRecipeBuilder.shaped(Registration.TITANIUM_AXE.get())
        .pattern(" xx")
        .pattern(" sx")
        .pattern(" s ")
        .define('x', Registration.TITANIUM_INGOT.get())
        .define('s', Items.STICK)
        .group("bonesteel")
        .unlockedBy("has_titanium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.TITANIUM_INGOT.get()))
        .save(recipe);
        
        ShapedRecipeBuilder.shaped(Registration.TITANIUM_HOE.get())
        .pattern(" xx")
        .pattern(" s ")
        .pattern(" s ")
        .define('x', Registration.TITANIUM_INGOT.get())
        .define('s', Items.STICK)
        .group("bonesteel")
        .unlockedBy("has_titanium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.TITANIUM_INGOT.get()))
        .save(recipe);
        
        ShapedRecipeBuilder.shaped(Registration.TITANIUM_PICKAXE.get())
        .pattern("xxx")
        .pattern(" s ")
        .pattern(" s ")
        .define('x', Registration.TITANIUM_INGOT.get())
        .define('s', Items.STICK)
        .group("bonesteel")
        .unlockedBy("has_titanium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.TITANIUM_INGOT.get()))
        .save(recipe);
        
        ShapedRecipeBuilder.shaped(Registration.TITANIUM_SHOVEL.get())
        .pattern(" x ")
        .pattern(" s ")
        .pattern(" s ")
        .define('x', Registration.TITANIUM_INGOT.get())
        .define('s', Items.STICK)
        .group("bonesteel")
        .unlockedBy("has_titanium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.TITANIUM_INGOT.get()))
        .save(recipe);
	}
}
