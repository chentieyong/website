package com.shenzhou.core.util;


import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public abstract class StringUtils {
    public static boolean hasLength(CharSequence charseq) {
        return (charseq != null) && (charseq.length() > 0);
    }

    public static boolean hasText(CharSequence charseq) {
        int len;
        if ((charseq == null) || ((len = charseq.length()) == 0))
            return false;
        for (int i = 0; i < len; i++) {
            if (!Character.isWhitespace(charseq.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String slice(String str, int start, int end) {
        if (!hasLength(str)) {
            return str;
        }

        int len = str.length();
        start = start < 0 ? start + len : start;
        end = end < 0 ? end + len : end;
        return start > end ? "" : str.substring(start, end);
    }

    public static String capitalize(String str) {
        if (!hasLength(str)) {
            return str;
        }

        char[] chars = str.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }

    public static String decapitalize(String str) {
        if (!hasLength(str)) {
            return str;
        }

        if ((str.length() > 1) && (Character.isUpperCase(str.charAt(0))) && (Character.isUpperCase(str.charAt(1)))) {
            return str;
        }

        char[] chars = str.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }

    public String swapCase(String str) {
        if (hasLength(str)) {
            return str;
        }

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLowerCase(c))
                chars[i] = Character.toUpperCase(c);
            else if (Character.isUpperCase(c))
                chars[i] = Character.toLowerCase(c);
            else if (Character.isTitleCase(c)) {
                chars[i] = Character.toLowerCase(c);
            }
        }
        return new String(chars);
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    public static String ltrim(String str) {
        if (!hasLength(str)) {
            return str;
        }

        int st = 0;
        int len = str.length();
        while ((st < len) && (str.charAt(st) <= ' ')) st++;
        return st > 0 ? str.substring(st, len) : str;
    }

    public static String rtrim(String str) {
        if (!hasLength(str)) {
            return str;
        }

        int st = 0;
        int len = str.length();
        while ((0 < len) && (str.charAt(len - 1) <= ' ')) len--;
        return len < str.length() ? str.substring(0, len) : str;
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        return !hasLength(trim) ? null : trim;
    }

    public static String trimToEmpty(String str) {
        String trim = trim(str);
        return trim == null ? "" : trim;
    }

    public static String underscoreToCamelCase(String str, boolean firstCharUpperCase) {
        return delimitedToCamelCase(str, '_', firstCharUpperCase);
    }

    public static String delimitedToCamelCase(String str, char delimiter, boolean firstCharUpperCase) {
        if (!hasLength(str)) {
            return str;
        }

        StringCharacterIterator it = new StringCharacterIterator(str.toLowerCase(Locale.ENGLISH));
        StringBuilder segment = new StringBuilder(str.length());
        boolean undlerline = false;
        for (; it.getIndex() < it.getEndIndex(); it.next()) {
            char c = it.current();
            if (((0 == it.getIndex()) && (firstCharUpperCase)) || (undlerline)) {
                segment.append(Character.toUpperCase(c));
                undlerline = false;
            } else if (delimiter == c) {
                undlerline = true;
            } else {
                segment.append(c);
            }
        }

        return segment.toString();
    }

    public static String camelCaseToUnderscore(String str, boolean upperCase) {
        if (!hasLength(str)) {
            return str;
        }

        char[] chars = str.toCharArray();
        StringBuilder segment = new StringBuilder();
        segment.append(upperCase ? Character.toUpperCase(chars[0]) : Character.toLowerCase(chars[0]));

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                segment.append('_');
            }
            c = upperCase ? Character.toUpperCase(c) : Character.toLowerCase(c);
            segment.append(c);
        }

        return segment.toString();
    }

    public static String[] clean(String[] array) {
        if (array == null) {
            return new String[0];
        }
        List result = new ArrayList(array.length);
        for (String s : array) {
            if (hasLength(s)) {
                result.add(s);
            }
        }
        return (String[]) result.toArray(new String[result.size()]);
    }

    public static <T> String join(T[] array, String separator) {
        if (null == array) {
            return null;
        }

        separator = separator != null ? separator : "";

        StringBuilder buff = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buff.append(separator);
            }

            buff.append(array[i]);
        }

        return buff.toString();
    }
}
