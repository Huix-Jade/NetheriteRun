package huix.netherite_run.mixins.world;

import huix.netherite_run.init.RegistryInit;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin( ChunkProviderHell.class )
public class ChunkProviderHellMixin {
    @Shadow
    private Random hellRNG;
    @Shadow
    private World worldObj;

    @Inject(method = "populate", at = @At(value = "INVOKE", target = "Lnet/minecraft/WorldInfo;getEarliestMITEReleaseRunIn()I", ordinal = 1, shift = At.Shift.BEFORE))
    private void injectGenAdamantium(IChunkProvider par1IChunkProvider, int par2, int par3, CallbackInfo ci){
        //vine max
        WorldGenMinable genMinable = (new WorldGenMinable(RegistryInit.ancient_debris.blockID, 1, Block.netherrack.blockID)).setMinableBlockMetadata(0);

        //chunk max
        int var4 = par2 * 16;
        int var5 = par3 * 16;
        int count = this.hellRNG.nextInt(5) + 1;
        for(int i = 0; i < count; ++i) {
            int x = var4 + this.hellRNG.nextInt(16);
            int y = this.hellRNG.nextInt(20) + 35;
            int z = var5 + this.hellRNG.nextInt(16);
            genMinable.generate(this.worldObj, this.hellRNG, x, y, z);
        }
    }

}
