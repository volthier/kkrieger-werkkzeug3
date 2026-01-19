package com.werkkzeug3.audio;

/**
 * Contract for the audio pipeline (decode, mix, sync).
 */
public interface AudioEngine extends AutoCloseable {
    void initialize();

    void mixFrame(double timeSeconds);

    @Override
    void close();
}
