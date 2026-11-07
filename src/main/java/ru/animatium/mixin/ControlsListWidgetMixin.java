package ru.animatium.mixin;

import net.minecraft.client.gui.screen.option.ControlsListWidget;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Locale;

@Mixin(ControlsListWidget.class)
public abstract class ControlsListWidgetMixin {
    @Shadow
    public abstract List<ControlsListWidget.Entry> children();

    @Inject(method = "update", at = @At("TAIL"))
    private void animatium$hideSelectedRows(CallbackInfo ci) {
        children().removeIf(entry -> {
            if (!(entry instanceof ControlsListWidget.KeyBindingEntry)) {
                return false;
            }

            KeyBinding binding = ((KeyBindingEntryAccessor) entry).animatium$getBinding();
            String id = binding.getId().toLowerCase(Locale.ROOT);

            return id.startsWith("key.macecore.")
                    || id.startsWith("key.mace_core.")
                    || id.equals("key.shieldbreaker.open_gui");
        });
    }
}
