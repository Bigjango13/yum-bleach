package useless.yumbleach;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.world.World;

public class ItemBleach extends ItemFood {
    public ItemBleach(String name, int id, int hurtamount) {
        super(name, id, hurtamount, 7, false, 8);
    }

    @Override
    public ItemStack onUseItem(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (itemstack.consumeItem(entityplayer)) {
            entityplayer.hurt(entityplayer, this.getHealAmount(), DamageType.GENERIC);
        }
        return itemstack;
    }
}
