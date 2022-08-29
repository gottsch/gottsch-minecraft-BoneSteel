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
package mod.gottsch.forge.bonesteel.item;

import java.util.function.Supplier;

import mod.gottsch.forge.bonesteel.BoneSteel;
import mod.gottsch.forge.bonesteel.setup.Registration;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * 
 * @author Mark Gottschling on Aug 17, 2022
 *
 */
public enum ModArmorMaterials implements ArmorMaterial {
	BONE("bone", 22, new int[]{ 2, 5, 6, 2}, 11, SoundEvents.ARMOR_EQUIP_LEATHER, 0.5F, 0.0F, () -> {
		return Ingredient.of(Items.BONE);
	}),
//	CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> {
//		return Ingredient.of(Items.IRON_INGOT);
//	}),
//	IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
//		return Ingredient.of(Items.IRON_INGOT);
//	}),
//	GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> {
//		return Ingredient.of(Items.GOLD_INGOT);
//	}),
	TITANIUM("titanium", 27, new int[]{3, 6, 8, 3}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, 
		() -> Ingredient.of(Registration.TITANIUM_INGOT.get()));
//	TURTLE("turtle", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_TURTLE, 0.0F, 0.0F, () -> {
//		return Ingredient.of(Items.SCUTE);
//	}),
//	NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
//		return Ingredient.of(Items.NETHERITE_INGOT);
//	});

	// health slot array = `boots, leggins, chest, helmet
	private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	/*
	 * 
	 */
	private ModArmorMaterials(String name, int durability, int[] slotProtections, int enchantability, SoundEvent sound, 
			float toughness, float knockbackResistance, Supplier<Ingredient> repair) {
		this.name = name;
		this.durabilityMultiplier = durability;
		this.slotProtections = slotProtections;
		this.enchantmentValue = enchantability;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = new LazyLoadedValue<>(repair);
	}

	public int getDurabilityForSlot(EquipmentSlot p_40484_) {
		return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
	}

	public int getDefenseForSlot(EquipmentSlot p_40487_) {
		return this.slotProtections[p_40487_.getIndex()];
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public SoundEvent getEquipSound() {
		return this.sound;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public String getName() {
		return BoneSteel.MODID + ":" + this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
