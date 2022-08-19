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
package mod.gottsch.forge.bonesteel;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mod.gottsch.forge.bonesteel.setup.CommonSetup;
import mod.gottsch.forge.bonesteel.setup.Registration;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

/**
 * 
 * @author Mark Gottschling on Aug 16, 2022
 *
 */
@Mod(BoneSteel.MODID)
public class BoneSteel {
	public static final Logger LOGGER = LogManager.getLogger();

	public static final String MODID = "bonesteel";
	
	/**
	 * 
	 */
	public BoneSteel() {
		// register the deferred registries
		Registration.init();
		CommonSetup.setup();
		
		// register the server config
//		ModLoadingContext.get().registerConfig(Type.CLIENT, Config.CLIENT_SPEC);
//		ModLoadingContext.get().registerConfig(Type.SERVER, Config.SERVER_SPEC);
		// create the default config
//		createServerConfig(Config.ECHELONS_SPEC, "echelons", ECHELONS_CONFIG_VERSION);

		// register the setup method for mod loading
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		// register 'ModSetup::init' to be called at mod setup time (server and client)
		modEventBus.addListener(CommonSetup::init);
//		modEventBus.addListener(this::config);
		
		// register 'ClientSetup::init' to be called at mod setup time (client only)
//		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modEventBus.addListener(ClientSetup::init));
	}
	
	/**
	 * 
	 * @param spec
	 * @param suffix
	 */
	private static void createServerConfig(ForgeConfigSpec spec, String suffix, String version) {
		// TODO ensure to include a version # to the filename so it can be overridden in future
		String fileName = "bonesteel-" + suffix + "-" + version + ".toml";
		ModLoadingContext.get().registerConfig(Type.SERVER, spec, fileName);
		File defaults = new File(FMLPaths.GAMEDIR.get() + "/defaultconfigs/" + fileName);

		if (!defaults.exists()) {
			try {
				FileUtils.copyInputStreamToFile(
						Objects.requireNonNull(BoneSteel.class.getClassLoader().getResourceAsStream(fileName)),
						defaults);
			} catch (IOException e) {
				LOGGER.error("Error creating default config for " + fileName);
			}
		}
	}

	/**
	 * On a config event.
	 * @param event
	 */
//	private void config(final ModConfigEvent event) {
//		if (event.getConfig().getModId().equals(MODID)) {
//			if (event.getConfig().getType() == Type.SERVER) {
//				IConfigSpec<?> spec = event.getConfig().getSpec();
//				// get the toml config data
//				CommentedConfig commentedConfig = event.getConfig().getConfigData();
//
//				if (spec == Config.ECHELONS_SPEC) {
//					// transform/copy the toml into the config
//					Config.transformEchelons(commentedConfig);
//	
//				} 
//			}
//		}
//	}
}