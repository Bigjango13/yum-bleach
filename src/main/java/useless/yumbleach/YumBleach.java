package useless.yumbleach;

import goocraft4evr.nonamedyes.NoNameDyes;
import goocraft4evr.nonamedyes.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemHelper;
import turniplabs.halplibe.helper.RecipeHelper;
import turniplabs.halplibe.util.ConfigHandler;

import java.util.Properties;


public class YumBleach implements ModInitializer {
    public static ConfigHandler config;
    static {
        Properties prop = new Properties();
        prop.setProperty("starting_item_id", "16999");
        config = new ConfigHandler("yumbleach", prop);
        config.updateConfig();
    }
    public static final String MOD_ID = "yumbleach";
    public static Item bleach = ItemHelper.createItem(MOD_ID, new ItemBleach("bleach", config.getInt("starting_item_id"), 6), "bleach", "bleach.png");
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("yumbleach initialized.");
    }
}
