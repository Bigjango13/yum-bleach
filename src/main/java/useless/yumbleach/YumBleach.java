package useless.yumbleach;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.item.ModItems;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;

public class YumBleach implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "yumbleach";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static ConfigHandler config;
    static {
        Properties prop = new Properties();
        prop.setProperty("starting_item_id", "16999");
        config = new ConfigHandler("yumbleach", prop);
        config.updateConfig();
    }
    public static Item bleach;

    @Override
    public void onInitialize() {
        LOGGER.info("yumbleach initialized.");
        bleach = new ItemBuilder(MOD_ID)
            .setIcon("yumbleach:item/bleach")
            .build(new ItemBleach("bleach", config.getInt("starting_item_id"), 6));
    }

    @Override
    public void beforeGameStart() {
    }

    @Override
    public void afterGameStart() {
    }

    @Override
    public void onRecipesReady() {
    }

    @Override
    public void initNamespaces() {
        RecipeBuilder.initNameSpace(MOD_ID);
    }
}
