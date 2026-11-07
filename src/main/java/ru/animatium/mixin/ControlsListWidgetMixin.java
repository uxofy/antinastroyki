package ru.animatium.mixin;

import net.minecraft.client.gui.screen.option.ControlsListWidget;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Locale;

/**
 * Filters selected rows after Minecraft has populated the Controls list.
 * This only changes the visible list; registered keybindings remain untouched.
 */
@Mixin(ControlsListWidget.class)
public abstract class ControlsListWidgetMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void animatium$hideSelectedRows(CallbackInfo ci) {
        ControlsListWidget self = (ControlsListWidget) (Object) this;

        self.children().removeIf(entry -> {
            if (!(entry instanceof ControlsListWidget.KeyBindingEntry)) {
                return false;
            }

            KeyBinding binding =
                    ((KeyBindingEntryAccessor) (Object) entry).animatium$getBinding();

            String id = binding.getId().toLowerCase(Locale.ROOT);

            return id.contains("macecore")
                    || id.equals("key.shieldbreaker.open_gui");
        });
    }
}
