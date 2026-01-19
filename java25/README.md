# Werkkzeug3 Java 25 Migration

This module contains the first Java 25 port of the integer fixed-point math utilities used by Werkkzeug3. The goal is to preserve the original behavior while adopting Java 25 tooling and clean, testable code.

## Status

- ✅ Fixed-point constants and multiplications
- ✅ Sine/cosine lookup math
- ✅ Integer square root helpers
- ✅ Vector normalization logic (integer fixed-point)
- ⏳ Remaining engine systems (rendering, audio, serialization, tools)

## Notes

The original C++ math routines live in `werkkzeug3_kkrieger/_intmath.*`. This Java port mirrors the tables and formulas to keep deterministic results.

## Build

```bash
./gradlew :java25:build
```
