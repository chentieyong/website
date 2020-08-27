package com.shenzhou.core.util;

import java.util.Arrays;


public abstract class Base64 {
    private static final int CHUNK_SIZE = 76;
    private static final char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final char[] URL_SAFE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".toCharArray();
    private static final int[] INV = new int[256];
    private static final int[] URL_SAFE_INV = new int[256];
    private static final char PADDING = '=';
    public static final byte[] EMPTY_BYTES = new byte[0];
    public static final char[] EMPTY_CHARS = new char[0];

    public static String encodeToUrlSafeString(byte[] bytes) {
        return encodeToUrlSafeString(bytes, false);
    }

    public static String encodeToUrlSafeString(byte[] bytes, boolean lineSep) {
        return String.valueOf(encodeToChars(bytes, lineSep, true));
    }

    public static String encodeToString(byte[] bytes) {
        return encodeToString(bytes, false);
    }

    public static String encodeToString(byte[] bytes, boolean lineSep) {
        return new String(encodeToChars(bytes, lineSep));
    }

    public static char[] encodeToChars(byte[] bytes, boolean lineSeparator) {
        return encodeToChars(bytes, lineSeparator, false);
    }

    public static byte[] encode(byte[] bytes) {
        return encode(bytes, false);
    }

    public static byte[] encode(byte[] bytes, boolean lineSeparator) {
        return encode(bytes, lineSeparator, false);
    }

    public static char[] encodeToChars(byte[] bytes, boolean lineSeparator, boolean urlSafe) {
        char[] TAB = urlSafe ? URL_SAFE_CHARS : CHARS;
        int len = bytes != null ? bytes.length : 0;
        if (len == 0) {
            return EMPTY_CHARS;
        }

        int evenlen = len / 3 * 3;
        int cnt = (len - 1) / 3 + 1 << 2;
        int destLen = cnt + (lineSeparator ? (cnt - 1) / 76 << 1 : 0);
        char[] dest = new char[destLen];

        int s = 0;
        int d = 0;
        for (int cc = 0; s < evenlen; ) {
            int i = (bytes[(s++)] & 0xFF) << 16 | (bytes[(s++)] & 0xFF) << 8 | bytes[(s++)] & 0xFF;

            dest[(d++)] = TAB[(i >>> 18 & 0x3F)];
            dest[(d++)] = TAB[(i >>> 12 & 0x3F)];
            dest[(d++)] = TAB[(i >>> 6 & 0x3F)];
            dest[(d++)] = TAB[(i & 0x3F)];

            if (lineSeparator) {
                cc++;
                if ((cc == 19) && (d < destLen - 2)) {
                    dest[(d++)] = '\r';
                    dest[(d++)] = '\n';
                    cc = 0;
                }
            }
        }
        int left = len - evenlen;
        if (left > 0) {
            int i = (bytes[evenlen] & 0xFF) << 10 | (left == 2 ? (bytes[(len - 1)] & 0xFF) << 2 : 0);

            dest[(destLen - 4)] = TAB[(i >> 12)];
            dest[(destLen - 3)] = TAB[(i >>> 6 & 0x3F)];
            dest[(destLen - 2)] = (left == 2 ? TAB[(i & 0x3F)] : '=');
            dest[(destLen - 1)] = '=';
        }
        return dest;
    }

    public static byte[] encode(byte[] bytes, boolean lineSep, boolean urlSafe) {
        char[] TAB = urlSafe ? URL_SAFE_CHARS : CHARS;
        int len = bytes != null ? bytes.length : 0;
        if (len == 0) {
            return EMPTY_BYTES;
        }

        int evenlen = len / 3 * 3;
        int cnt = (len - 1) / 3 + 1 << 2;
        int destlen = cnt + (lineSep ? (cnt - 1) / 76 << 1 : 0);
        byte[] dest = new byte[destlen];

        int s = 0;
        int d = 0;
        for (int cc = 0; s < evenlen; ) {
            int i = (bytes[(s++)] & 0xFF) << 16 | (bytes[(s++)] & 0xFF) << 8 | bytes[(s++)] & 0xFF;

            dest[(d++)] = ((byte) TAB[(i >>> 18 & 0x3F)]);
            dest[(d++)] = ((byte) TAB[(i >>> 12 & 0x3F)]);
            dest[(d++)] = ((byte) TAB[(i >>> 6 & 0x3F)]);
            dest[(d++)] = ((byte) TAB[(i & 0x3F)]);

            if (lineSep) {
                cc++;
                if ((cc == 19) && (d < destlen - 2)) {
                    dest[(d++)] = 13;
                    dest[(d++)] = 10;
                    cc = 0;
                }
            }
        }
        int left = len - evenlen;
        if (left > 0) {
            int i = (bytes[evenlen] & 0xFF) << 10 | (left == 2 ? (bytes[(len - 1)] & 0xFF) << 2 : 0);

            dest[(destlen - 4)] = ((byte) TAB[(i >> 12)]);
            dest[(destlen - 3)] = ((byte) TAB[(i >>> 6 & 0x3F)]);
            dest[(destlen - 2)] = (left == 2 ? (byte) TAB[(i & 0x3F)] : 61);
            dest[(destlen - 1)] = 61;
        }
        return dest;
    }

    public static byte[] decode(String base64) {
        return decode(base64, false);
    }

    public static byte[] decode(String base64, boolean urlSafe) {
        return decode(base64.toCharArray(), urlSafe);
    }

    public static byte[] decode(char[] base64Chars) {
        return decode(base64Chars, false);
    }

    public static byte[] decode(char[] base64Chars, boolean urlSafe) {
        int[] DECODE_TAB = urlSafe ? URL_SAFE_INV : INV;
        int length = base64Chars.length;
        if (length == 0) {
            return EMPTY_BYTES;
        }

        int sndx = 0;
        int endx = length - 1;
        int pad = base64Chars[endx] == '=' ? 1 : base64Chars[(endx - 1)] == '=' ? 2 : 0;
        int cnt = endx - sndx + 1;
        int sepCnt = length > 76 ? (base64Chars[76] == '\r' ? cnt / 76 + 2 : 0) << 1 : 0;
        int len = ((cnt - sepCnt) * 6 >> 3) - pad;
        byte[] dest = new byte[len];

        int d = 0;
        int cc = 0;
        for (int eLen = len / 3 * 3; d < eLen; ) {
            int i = DECODE_TAB[base64Chars[(sndx++)]] << 18 | DECODE_TAB[base64Chars[(sndx++)]] << 12 | DECODE_TAB[base64Chars[(sndx++)]] << 6 | DECODE_TAB[base64Chars[(sndx++)]];

            dest[(d++)] = ((byte) (i >> 16));
            dest[(d++)] = ((byte) (i >> 8));
            dest[(d++)] = ((byte) i);

            if (sepCnt > 0) {
                cc++;
                if (cc == 19) {
                    sndx += 2;
                    cc = 0;
                }
            }
        }
        if (d < len) {
            int i = 0;
            for (int j = 0; sndx <= endx - pad; j++) {
                i |= DECODE_TAB[base64Chars[(sndx++)]] << 18 - j * 6;
            }
            for (int r = 16; d < len; r -= 8) {
                dest[(d++)] = ((byte) (i >> r));
            }
        }

        return dest;
    }

    public static byte[] decode(byte[] base64Bytes) {
        return decode(base64Bytes, false);
    }

    public static byte[] decode(byte[] base64Bytes, boolean urlSafe) {
        int[] DECODE_TAB = urlSafe ? URL_SAFE_INV : INV;
        int length = base64Bytes.length;
        if (length == 0) {
            return EMPTY_BYTES;
        }

        int sndx = 0;
        int endx = length - 1;
        int pad = base64Bytes[endx] == 61 ? 1 : base64Bytes[(endx - 1)] == 61 ? 2 : 0;
        int cnt = endx - sndx + 1;
        int sepCnt = length > 76 ? (base64Bytes[76] == 13 ? cnt / 78 : 0) << 1 : 0;
        int len = ((cnt - sepCnt) * 6 >> 3) - pad;
        byte[] dest = new byte[len];

        int d = 0;
        int cc = 0;
        for (int eLen = len / 3 * 3; d < eLen; ) {
            int i = DECODE_TAB[base64Bytes[(sndx++)]] << 18 | DECODE_TAB[base64Bytes[(sndx++)]] << 12 | DECODE_TAB[base64Bytes[(sndx++)]] << 6 | DECODE_TAB[base64Bytes[(sndx++)]];

            dest[(d++)] = ((byte) (i >> 16));
            dest[(d++)] = ((byte) (i >> 8));
            dest[(d++)] = ((byte) i);

            if (sepCnt > 0) {
                cc++;
                if (cc == 19) {
                    sndx += 2;
                    cc = 0;
                }
            }
        }
        if (d < len) {
            int i = 0;
            for (int j = 0; sndx <= endx - pad; j++) {
                i |= DECODE_TAB[base64Bytes[(sndx++)]] << 18 - j * 6;
            }
            for (int r = 16; d < len; r -= 8) {
                dest[(d++)] = ((byte) (i >> r));
            }
        }
        return dest;
    }

    static {
        Arrays.fill(INV, -1);
        int i = 0;
        for (int iS = CHARS.length; i < iS; i++) {
            INV[CHARS[i]] = i;
        }
        INV[61] = 0;

        Arrays.fill(URL_SAFE_INV, -1);

        i = 0;
        for (int iS = URL_SAFE_CHARS.length; i < iS; i++) {
            URL_SAFE_INV[URL_SAFE_CHARS[i]] = i;
        }
        URL_SAFE_INV[61] = 0;
    }
}

 