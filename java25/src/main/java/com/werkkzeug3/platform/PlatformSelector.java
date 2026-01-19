package com.werkkzeug3.platform;

import java.util.Locale;

/**
 * Selects a default GPU backend based on the current OS/architecture.
 */
public final class PlatformSelector {
    private PlatformSelector() {
    }

    public static PlatformTarget defaultTarget() {
        String os = System.getProperty("os.name", "unknown").toLowerCase(Locale.ROOT);
        String arch = System.getProperty("os.arch", "unknown").toLowerCase(Locale.ROOT);

        if (os.contains("mac") || os.contains("darwin")) {
            return PlatformTarget.METAL;
        }

        if (os.contains("win")) {
            return PlatformTarget.DIRECTX_12;
        }

        if (arch.contains("arm") || arch.contains("aarch")) {
            return PlatformTarget.VULKAN;
        }

        return PlatformTarget.VULKAN;
    }
}
