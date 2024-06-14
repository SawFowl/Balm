package net.blay09.mods.balm.mixin;

import net.blay09.mods.balm.api.client.BalmClient;
import net.blay09.mods.balm.neoforge.client.rendering.NeoForgeBalmModels;
import net.minecraft.client.resources.model.ModelBakery;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBakery.class)
public class ModelBakeryMixin {
    @Inject(method = "bakeModels(Lnet/minecraft/client/resources/model/ModelBakery$TextureGetter;)V", at = @At("RETURN"))
    private void apply(ModelBakery.TextureGetter textureGetter, CallbackInfo callbackInfo) {
        ((NeoForgeBalmModels) BalmClient.getModels()).onBakeModels((ModelBakery) (Object) this, textureGetter);
    }
}
