package org.mapsforge.map.reader;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import org.mapsforge.core.model.Tile;

/* loaded from: /root/release/classes2.dex */
final class QueryCalculations {
    private QueryCalculations() {
        throw new IllegalStateException();
    }

    static int calculateTileBitmask(Tile tile, int i3) {
        if (i3 == 1) {
            return getFirstLevelTileBitmask(tile);
        }
        int i4 = i3 - 2;
        long j3 = tile.tileX >>> i4;
        long j4 = tile.tileY >>> i4;
        long j5 = j4 >>> 1;
        long j6 = (j3 >>> 1) % 2;
        return (j6 == 0 && j5 % 2 == 0) ? getSecondLevelTileBitmaskUpperLeft(j3, j4) : (j6 == 1 && j5 % 2 == 0) ? getSecondLevelTileBitmaskUpperRight(j3, j4) : (j6 == 0 && j5 % 2 == 1) ? getSecondLevelTileBitmaskLowerLeft(j3, j4) : getSecondLevelTileBitmaskLowerRight(j3, j4);
    }

    static int calculateTileBitmask(Tile tile, Tile tile2, int i3) {
        int i4 = 0;
        for (int i5 = tile.tileX; i5 <= tile2.tileX; i5++) {
            for (int i6 = tile.tileY; i6 <= tile2.tileY; i6++) {
                i4 |= calculateTileBitmask(new Tile(i5, i6, tile.zoomLevel, tile.tileSize), i3);
            }
        }
        return i4;
    }

    private static int getFirstLevelTileBitmask(Tile tile) {
        int i3 = tile.tileX;
        if (i3 % 2 == 0 && tile.tileY % 2 == 0) {
            return 52224;
        }
        if (i3 % 2 == 1 && tile.tileY % 2 == 0) {
            return 13056;
        }
        return (i3 % 2 == 0 && tile.tileY % 2 == 1) ? 204 : 51;
    }

    private static int getSecondLevelTileBitmaskLowerLeft(long j3, long j4) {
        long j5 = j3 % 2;
        if (j5 == 0 && j4 % 2 == 0) {
            return 128;
        }
        if (j5 == 1 && j4 % 2 == 0) {
            return 64;
        }
        return (j5 == 0 && j4 % 2 == 1) ? 8 : 4;
    }

    private static int getSecondLevelTileBitmaskLowerRight(long j3, long j4) {
        long j5 = j3 % 2;
        if (j5 == 0 && j4 % 2 == 0) {
            return 32;
        }
        if (j5 == 1 && j4 % 2 == 0) {
            return 16;
        }
        return (j5 == 0 && j4 % 2 == 1) ? 2 : 1;
    }

    private static int getSecondLevelTileBitmaskUpperLeft(long j3, long j4) {
        long j5 = j3 % 2;
        if (j5 == 0 && j4 % 2 == 0) {
            return 32768;
        }
        if (j5 == 1 && j4 % 2 == 0) {
            return 16384;
        }
        if (j5 == 0 && j4 % 2 == 1) {
            return 2048;
        }
        return UserVerificationMethods.USER_VERIFY_ALL;
    }

    private static int getSecondLevelTileBitmaskUpperRight(long j3, long j4) {
        long j5 = j3 % 2;
        if (j5 == 0 && j4 % 2 == 0) {
            return 8192;
        }
        if (j5 == 1 && j4 % 2 == 0) {
            return 4096;
        }
        return (j5 == 0 && j4 % 2 == 1) ? UserVerificationMethods.USER_VERIFY_NONE : UserVerificationMethods.USER_VERIFY_HANDPRINT;
    }
}
