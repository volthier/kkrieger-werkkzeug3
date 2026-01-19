package com.werkkzeug3.math;

import java.util.Objects;

/**
 * Fixed-point 3D vector using 1:15:16 integer units.
 */
public final class FixedVector3 {
    private int x;
    private int y;
    private int z;

    public FixedVector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public int z() {
        return z;
    }

    public FixedVector3 set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public FixedVector3 add(FixedVector3 other) {
        Objects.requireNonNull(other, "other");
        x += other.x;
        y += other.y;
        z += other.z;
        return this;
    }

    public FixedVector3 subtract(FixedVector3 other) {
        Objects.requireNonNull(other, "other");
        x -= other.x;
        y -= other.y;
        z -= other.z;
        return this;
    }

    public FixedVector3 addScaled(FixedVector3 other, int scale) {
        Objects.requireNonNull(other, "other");
        x += FixedMath.iMul(other.x, scale);
        y += FixedMath.iMul(other.y, scale);
        z += FixedMath.iMul(other.z, scale);
        return this;
    }

    public FixedVector3 unit() {
        int lengthSquared = FixedMath.iMul(x, x) + FixedMath.iMul(y, y) + FixedMath.iMul(z, z);
        int inverseLength = FixedMath.iSqrt15D(lengthSquared) >> 9;
        x = FixedMath.iMul(x, inverseLength);
        y = FixedMath.iMul(y, inverseLength);
        z = FixedMath.iMul(z, inverseLength);
        return this;
    }
}
