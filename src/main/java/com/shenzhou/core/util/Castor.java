package com.shenzhou.core.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Calendar;
import java.util.Locale;

public abstract class Castor {
    private static final String DATE_FORMAT_PLAIN = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final String DATE_FORMAT_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    private static final String DATE_FORMAT_ISO8601_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String DATE_FORMAT_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    public static String asString(Object obj) {
        return obj == null ? null : obj.toString();
    }

    public static Boolean asBoolean(Object obj) {
        if ((obj instanceof Boolean)) {
            return (Boolean) obj;
        }

        if ((obj instanceof Number)) {
            int i = ((Number) obj).intValue();
            if (0 == i) {
                return Boolean.valueOf(false);
            }
            if (1 == i) {
                return Boolean.valueOf(true);
            }
        }

        String s = asString(obj);

        if ((s == null) || (0 == s.length())) {
            return null;
        }

        if (("true".equalsIgnoreCase(s)) || ("y".equalsIgnoreCase(s)) || ("yes".equalsIgnoreCase(s)) || ("on".equalsIgnoreCase(s)) || ("1".equalsIgnoreCase(s))) {
            return Boolean.valueOf(true);
        }

        if (("false".equalsIgnoreCase(s)) || ("n".equalsIgnoreCase(s)) || ("no".equalsIgnoreCase(s)) || ("off".equalsIgnoreCase(s)) || ("0".equalsIgnoreCase(s))) {
            return Boolean.valueOf(false);
        }

        throw throwClassCastException(obj, Boolean.class);
    }

    public static Byte asByte(Object obj) {
        return (Byte) asNumber(obj, Byte.class);
    }

    public static Short asShort(Object obj) {
        return (Short) asNumber(obj, Short.class);
    }

    public static Integer asInt(Object obj) {
        return (Integer) asNumber(obj, Integer.class);
    }

    public static Long asLong(Object obj) {
        return (Long) asNumber(obj, Long.class);
    }

    public static Float asFloat(Object obj) {
        return (Float) asNumber(obj, Float.class);
    }

    public static Double asDouble(Object obj) {
        return (Double) asNumber(obj, Double.class);
    }

    public static <N extends Number> N asNumber(Object obj, Class<N> targetClass) {
        if (obj == null) {
            return null;
        }

        try {
            obj = asBoolean(obj);
        } catch (ClassCastException ignore) {
        }
        String text;
        if ((obj instanceof Boolean)) {
            text = ((Boolean) obj).booleanValue() ? "1" : "0";
        } else {
            if ((obj instanceof Character)) {
                text = Integer.valueOf(((Character) obj).charValue()).toString();
            } else {
                text = asString(obj);
                if ((text == null) || (0 == text.length()))
                    return null;
            }
        }
        try {
            if ((Byte.class == targetClass) || (Byte.TYPE == targetClass)) {
                return (N) Byte.decode(text);
            }
            if ((Short.class == targetClass) || (Short.TYPE == targetClass)) {
                return (N) Short.decode(text);
            }
            if ((Integer.class == targetClass) || (Integer.TYPE == targetClass)) {
                return (N) Integer.decode(text);
            }
            if ((Long.class == targetClass) || (Long.TYPE == targetClass)) {
                return (N) Long.decode(text);
            }
            if ((Float.class == targetClass) || (Float.TYPE == targetClass)) {
                return (N) Float.valueOf(text);
            }
            if ((Double.class == targetClass) || (Double.TYPE == targetClass)) {
                return (N) Double.valueOf(text);
            }
            if (BigInteger.class == targetClass) {
                return (N) new BigInteger(text);
            }
            if ((BigDecimal.class == targetClass) || (Number.class == targetClass))
                return (N) new BigDecimal(text);
        } catch (NumberFormatException e) {
        }
        throw throwClassCastException(obj, Number.class);
    }

    public static Number parseNumber(String text) {
        StringCharacterIterator it = new StringCharacterIterator(text.trim().toUpperCase(Locale.ENGLISH));
        long number = 0L;
        StringBuilder buffer = null;
        boolean negative = false;

        while (it.getIndex() < it.getEndIndex()) {
            char c = it.current();
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    number *= 10L;
                    number += c - '0';
                    it.next();
                    break;
                case '+':
                case '-':
                    if (0L != number) {
                        break;
                    }
                    negative = '-' == c;
                    it.next();
                    break;
                case '.':
                case 'E':
                    buffer = new StringBuilder(16);
                    buffer.append(negative ? Character.valueOf('-') : "").append(number).append(c);
                    it.next();
                    break;
                case ',':
                case '/':
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                default:
                    it.next();
                    break;
            }
        }

        label282:
        if (buffer == null) {
            return Long.valueOf(negative ? -1L * number : number);
        }

        boolean dot = '.' == buffer.charAt(buffer.length() - 1);

        while (it.getIndex() < it.getEndIndex()) {
            char ch = it.current();

            switch (ch) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    buffer.append(ch);
                    it.next();
                    break;
                case '+':
                case '-':
                    if ('E' != buffer.charAt(buffer.length() - 1)) {
                        break;
                    }
                    buffer.append('-' == ch ? Character.valueOf(ch) : "");
                    it.next();
                    break;
                case '.':
                case 'E':
                    if ((('.' == ch) && (dot)) || (('E' == ch) && (!dot))) {
                        break;
                    }
                    buffer.append(ch);
                    it.next();
                case ',':
                case '/':
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                default:
                    break;
            }
        }
        label585:
        if ('E' == buffer.charAt(buffer.length() - 1)) {
            buffer.append('0');
        }
        return new Double(buffer.toString());
    }

    public static java.util.Date asDate(Object obj) {
        if ((obj == null) || ((obj instanceof java.util.Date))) {
            return (java.util.Date) obj;
        }

        if ((obj instanceof Calendar)) {
            return ((Calendar) obj).getTime();
        }

        if ((obj instanceof java.sql.Date)) {
            return new java.util.Date(((java.sql.Date) obj).getTime());
        }

        if ((obj instanceof Time)) {
            return new java.util.Date(((Time) obj).getTime());
        }

        if ((obj instanceof Timestamp)) {
            return new java.util.Date(((Timestamp) obj).getTime());
        }

        long offset = 0L;

        if ((obj instanceof String)) {
            String text = (String) obj;
            int len = text.length();

            if (0 == len) {
                return null;
            }

            if (-1 < text.indexOf('-')) {
                if ((len <= "yyyy-MM-dd HH:mm:ss.SSS".length()) && (-1 == text.indexOf('T'))) {
                    char c = text.charAt(len - 3);

                    if (':' == c) {
                        text = text + ".000";
                    } else if ('-' == c) {
                        text = text + " 00:00:00.000";
                    }
                    try {
                        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(text);
                    } catch (ParseException ignore) {
                    }
                } else if ((len <= "yyyy-MM-dd'T'HH:mm:ss.SSSZ".length()) && (-1 < text.indexOf('T'))) {
                    char c = text.charAt(len - 1);

                    if ('Z' == c) {
                        if (':' == text.charAt(len - 4)) {
                            StringBuilder buf = new StringBuilder(text);
                            buf.insert(len - 1, ".000");
                            text = buf.toString();
                        }
                        try {
                            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(text);
                        } catch (ParseException ignore) {
                        }
                    } else if (hasTimeZone(text)) {
                        char ch = text.charAt(len - 3);

                        if (':' == ch) {
                            text = new StringBuilder(text).deleteCharAt(len - 3).toString();
                        } else if (('+' == ch) || ('-' == ch)) {
                            text = text + "00";
                        }

                        if (Character.isDigit(text.charAt(text.length() - 9))) {
                            text = new StringBuilder(text).insert(text.length() - 5, ".000").toString();
                        }
                        try {
                            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(text);
                        } catch (ParseException ignore) {
                        }
                    } else {
                        StringBuilder sb = new StringBuilder(text);

                        int timeLen = len - text.lastIndexOf('T') - 1;
                        if (timeLen <= 8) {
                            sb.append(".000");
                        }
                        sb.append('Z');
                        text = sb.toString();
                        try {
                            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(text);
                        } catch (ParseException ignore) {
                        }
                    }
                }
            } else try {
                return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").parse(text);
            } catch (ParseException ignore) {
            }
            try {
                offset = Long.parseLong(text);
            } catch (NumberFormatException ignore) {
            }
        }
        if ((obj instanceof Number)) {
            offset = ((Number) obj).longValue();
        }

        if (offset <= 0L) {
            throw throwClassCastException(obj, java.util.Date.class);
        }

        return new java.util.Date(offset);
    }

    private static boolean hasTimeZone(String date) {
        int len = date.length();
        if (len >= 6) {
            char c = date.charAt(len - 6);
            if (('+' == c) || ('-' == c)) {
                return true;
            }

            c = date.charAt(len - 5);
            if (('+' == c) || ('-' == c)) {
                return true;
            }

            c = date.charAt(len - 3);
            if (('+' == c) || ('-' == c)) {
                return true;
            }
        }
        return false;
    }

    private static ClassCastException throwClassCastException(Object obj, Class<?> target) {
        throw new ClassCastException((obj != null ? obj.getClass().getName() : null) + "(" + obj + ")" + " cannot be cast to " + target.getName());
    }
}

 