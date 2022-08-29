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
import mod.gottsch.forge.bonesteel.client.renderer.armor.BoneArmorRenderer;
import mod.gottsch.forge.bonesteel.client.renderer.armor.TitaniumArmorRenderer;
import mod.gottsch.forge.bonesteel.item.BoneArmorItem;
import mod.gottsch.forge.bonesteel.item.TitaniumArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

/**
 * 
 * @author Mark Gottschling on Aug 19, 2022
 *
 */
@Mod.EventBusSubscriber(modid = BoneSteel.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void init(final FMLClientSetupEvent event) {
    	
    }
    
	@SubscribeEvent
	public static void registerArmorRenderers(EntityRenderersEvent.AddLayers event) {
		GeoArmorRenderer.registerArmorRenderer(BoneArmorItem.class, BoneArmorRenderer::new);
		GeoArmorRenderer.registerArmorRenderer(TitaniumArmorItem.class, TitaniumArmorRenderer::new);
	}
}
