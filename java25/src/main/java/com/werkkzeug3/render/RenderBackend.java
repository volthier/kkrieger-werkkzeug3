package com.werkkzeug3.render;

import com.werkkzeug3.platform.PlatformTarget;

/**
 * Contract for a platform-specific rendering backend.
 */
public interface RenderBackend extends AutoCloseable {
    PlatformTarget target();

    void initialize();

    void renderFrame();

    @Override
    void close();
}
