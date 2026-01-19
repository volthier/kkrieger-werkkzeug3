# Werkkzeug3 Java 25 Migration

This module contains the first Java 25 port of the integer fixed-point math utilities used by Werkkzeug3. The goal is to preserve the original behavior while adopting Java 25 tooling and clean, testable code.

## Status

- ✅ Fixed-point constants and multiplications
- ✅ Sine/cosine lookup math
- ✅ Integer square root helpers
- ✅ Vector normalization logic (integer fixed-point)
- ⏳ Remaining engine systems (rendering, audio, serialization, tools)
- 🔧 Planned GPU bridge using Java 25's Foreign Function & Memory (FFM) API for native backends

## Notes

The original C++ math routines live in `werkkzeug3_kkrieger/_intmath.*`. This Java port mirrors the tables and formulas to keep deterministic results.

## GPU Direction

The Java 25 migration will lean on modern JVM capabilities. The `com.werkkzeug3.gpu` package starts the groundwork for native GPU interop using the Java 25 FFM API, so higher-level rendering and compute layers can bind to Vulkan/Metal/DirectX without JNI glue.

## Build

```bash
./gradlew :java25:build
```
