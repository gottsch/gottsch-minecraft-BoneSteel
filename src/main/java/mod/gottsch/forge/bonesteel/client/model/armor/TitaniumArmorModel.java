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
package mod.gottsch.forge.bonesteel.client.model.armor;

import mod.gottsch.forge.bonesteel.BoneSteel;
import mod.gottsch.forge.bonesteel.item.TitaniumArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

/**
 * 
 * @author Mark Gottschling on Aug 18, 2022
 *
 */
public class TitaniumArmorModel extends AnimatedGeoModel<TitaniumArmorItem> {

	@Override
	public ResourceLocation getAnimationFileLocation(TitaniumArmorItem animatable) {
		return new ResourceLocation(BoneSteel.MODID, "animations/armor_animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(TitaniumArmorItem object) {
		return new ResourceLocation(BoneSteel.MODID, "geo/titanium_armor.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(TitaniumArmorItem object) {
		return new ResourceLocation(BoneSteel.MODID, "textures/models/armor/titanium_armor_texture.png");
	}

}
