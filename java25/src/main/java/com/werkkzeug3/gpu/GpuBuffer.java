package com.werkkzeug3.gpu;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 * Represents a native-capable buffer intended for future GPU interop.
 *
 * <p>This uses the Java 25 Foreign Function & Memory API to allocate off-heap
 * storage that can be passed to native GPU backends without JNI.</p>
 */
public final class GpuBuffer implements AutoCloseable {
    private final Arena arena;
    private final MemorySegment segment;

    private GpuBuffer(Arena arena, MemorySegment segment) {
        this.arena = arena;
        this.segment = segment;
    }

    public static GpuBuffer allocate(long bytes) {
        if (bytes <= 0) {
            throw new IllegalArgumentException("bytes must be positive");
        }
        Arena arena = Arena.ofShared();
        return new GpuBuffer(arena, arena.allocate(bytes));
    }

    public MemorySegment segment() {
        return segment;
    }

    public long size() {
        return segment.byteSize();
    }

    @Override
    public void close() {
        arena.close();
    }
}
