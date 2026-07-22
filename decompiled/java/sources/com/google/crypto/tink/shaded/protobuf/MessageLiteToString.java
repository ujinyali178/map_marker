package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.io.IOUtils;

/* loaded from: /root/release/classes.dex */
final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        char[] cArr = new char[80];
        INDENT_BUFFER = cArr;
        Arrays.fill(cArr, ' ');
    }

    private MessageLiteToString() {
    }

    private static void indent(int i3, StringBuilder sb) {
        while (i3 > 0) {
            char[] cArr = INDENT_BUFFER;
            int length = i3 > cArr.length ? cArr.length : i3;
            sb.append(cArr, 0, length);
            i3 -= length;
        }
    }

    private static boolean isDefaultValue(Object obj) {
        Object obj2;
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        }
        if (obj instanceof Float) {
            return Float.floatToRawIntBits(((Float) obj).floatValue()) == 0;
        }
        if (obj instanceof Double) {
            return Double.doubleToRawLongBits(((Double) obj).doubleValue()) == 0;
        }
        if (obj instanceof String) {
            obj2 = "";
        } else {
            if (!(obj instanceof ByteString)) {
                return obj instanceof MessageLite ? obj == ((MessageLite) obj).getDefaultInstanceForType() : (obj instanceof java.lang.Enum) && ((java.lang.Enum) obj).ordinal() == 0;
            }
            obj2 = ByteString.EMPTY;
        }
        return obj.equals(obj2);
    }

    private static String pascalCaseToSnakeCase(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i3 = 1; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    static void printField(StringBuilder sb, int i3, String str, Object obj) {
        String escapeBytes;
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                printField(sb, i3, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                printField(sb, i3, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        indent(i3, sb);
        sb.append(pascalCaseToSnakeCase(str));
        if (obj instanceof String) {
            sb.append(": \"");
            escapeBytes = TextFormatEscaper.escapeText((String) obj);
        } else {
            if (!(obj instanceof ByteString)) {
                if (obj instanceof GeneratedMessageLite) {
                    sb.append(" {");
                    reflectivePrintWithIndent((GeneratedMessageLite) obj, sb, i3 + 2);
                } else if (!(obj instanceof Map.Entry)) {
                    sb.append(": ");
                    sb.append(obj);
                    return;
                } else {
                    sb.append(" {");
                    Map.Entry entry = (Map.Entry) obj;
                    int i4 = i3 + 2;
                    printField(sb, i4, "key", entry.getKey());
                    printField(sb, i4, "value", entry.getValue());
                }
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                indent(i3, sb);
                sb.append("}");
                return;
            }
            sb.append(": \"");
            escapeBytes = TextFormatEscaper.escapeBytes((ByteString) obj);
        }
        sb.append(escapeBytes);
        sb.append('\"');
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder sb, int i3) {
        int i4;
        java.lang.reflect.Method method;
        String substring;
        Object invokeOrDie;
        java.lang.reflect.Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        java.lang.reflect.Method[] declaredMethods = messageLite.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i5 = 0;
        while (true) {
            i4 = 3;
            if (i5 >= length) {
                break;
            }
            java.lang.reflect.Method method3 = declaredMethods[i5];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i5++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring2 = ((String) entry.getKey()).substring(i4);
            if (substring2.endsWith(LIST_SUFFIX) && !substring2.endsWith(BUILDER_LIST_SUFFIX) && !substring2.equals(LIST_SUFFIX) && (method2 = (java.lang.reflect.Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                substring = substring2.substring(0, substring2.length() - 4);
                invokeOrDie = GeneratedMessageLite.invokeOrDie(method2, messageLite, new Object[0]);
            } else if (!substring2.endsWith(MAP_SUFFIX) || substring2.equals(MAP_SUFFIX) || (method = (java.lang.reflect.Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                if (hashSet.contains("set" + substring2)) {
                    if (substring2.endsWith(BYTES_SUFFIX)) {
                        if (treeMap.containsKey("get" + substring2.substring(0, substring2.length() - 5))) {
                        }
                    }
                    java.lang.reflect.Method method4 = (java.lang.reflect.Method) entry.getValue();
                    java.lang.reflect.Method method5 = (java.lang.reflect.Method) hashMap.get("has" + substring2);
                    if (method4 != null) {
                        Object invokeOrDie2 = GeneratedMessageLite.invokeOrDie(method4, messageLite, new Object[0]);
                        if (method5 == null ? !isDefaultValue(invokeOrDie2) : ((Boolean) GeneratedMessageLite.invokeOrDie(method5, messageLite, new Object[0])).booleanValue()) {
                            printField(sb, i3, substring2, invokeOrDie2);
                        }
                    }
                }
                i4 = 3;
            } else {
                substring = substring2.substring(0, substring2.length() - 3);
                invokeOrDie = GeneratedMessageLite.invokeOrDie(method, messageLite, new Object[0]);
            }
            printField(sb, i3, substring, invokeOrDie);
            i4 = 3;
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> it = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
            while (it.hasNext()) {
                Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object> next = it.next();
                printField(sb, i3, "[" + next.getKey().getNumber() + "]", next.getValue());
            }
        }
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) messageLite).unknownFields;
        if (unknownFieldSetLite != null) {
            unknownFieldSetLite.printWithIndent(sb, i3);
        }
    }

    static String toString(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        reflectivePrintWithIndent(messageLite, sb, 0);
        return sb.toString();
    }
}
