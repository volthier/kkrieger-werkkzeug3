package com.werkkzeug3.runtime;

import com.werkkzeug3.audio.AudioEngine;
import com.werkkzeug3.procedural.ProceduralPipeline;
import com.werkkzeug3.render.RenderBackend;

import java.util.Objects;

/**
 * Coordinates the runtime boot order to mirror the original engine flow.
 */
public final class EngineBootstrap {
    private final ProceduralPipeline procedural;
    private final AudioEngine audio;
    private final RenderBackend renderer;

    public EngineBootstrap(ProceduralPipeline procedural, AudioEngine audio, RenderBackend renderer) {
        this.procedural = Objects.requireNonNull(procedural, "procedural");
        this.audio = Objects.requireNonNull(audio, "audio");
        this.renderer = Objects.requireNonNull(renderer, "renderer");
    }

    public void initialize() {
        procedural.initialize();
        procedural.generate();
        audio.initialize();
        renderer.initialize();
    }
}
