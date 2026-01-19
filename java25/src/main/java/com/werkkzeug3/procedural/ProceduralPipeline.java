package com.werkkzeug3.procedural;

/**
 * Contract for the procedural generation pipeline (materials, meshes, scenes).
 */
public interface ProceduralPipeline {
    void initialize();

    void generate();
}
