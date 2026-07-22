package com.google.android.gms.internal.play_billing;

import java.lang.reflect.Method;
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
final class zzge {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzgc zzgcVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzgcVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i3, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i3, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i3, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i3, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i4 = 1; i4 < str.length(); i4++) {
                char charAt = str.charAt(i4);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzhb.zza(new zzdt(((String) obj).getBytes(zzfd.zzb))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdw) {
            sb.append(": \"");
            sb.append(zzhb.zza((zzdw) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzex) {
            sb.append(" {");
            zzd((zzex) obj, sb, i3 + 2);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            zzc(i3, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i5 = i3 + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i5, "key", entry.getKey());
        zzb(sb, i5, "value", entry.getValue());
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        zzc(i3, sb);
        sb.append("}");
    }

    private static void zzc(int i3, StringBuilder sb) {
        while (i3 > 0) {
            int i4 = 80;
            if (i3 <= 80) {
                i4 = i3;
            }
            sb.append(zza, 0, i4);
            i3 -= i4;
        }
    }

    private static void zzd(zzgc zzgcVar, StringBuilder sb, int i3) {
        int i4;
        Object obj;
        Method method;
        String substring;
        Object zzl;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzgcVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i5 = 0;
        while (true) {
            i4 = 3;
            if (i5 >= length) {
                break;
            }
            Method method3 = declaredMethods[i5];
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
            if (substring2.endsWith("List") && !substring2.endsWith("OrBuilderList") && !substring2.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                substring = substring2.substring(0, substring2.length() - 4);
                zzl = zzex.zzl(method2, zzgcVar, new Object[0]);
            } else if (!substring2.endsWith("Map") || substring2.equals("Map") || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                if (hashSet.contains("set".concat(substring2)) && (!substring2.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring2.substring(0, substring2.length() - 5)))))) {
                    Method method4 = (Method) entry.getValue();
                    Method method5 = (Method) hashMap.get("has".concat(substring2));
                    if (method4 != null) {
                        Object zzl2 = zzex.zzl(method4, zzgcVar, new Object[0]);
                        if (method5 != null) {
                            if (!((Boolean) zzex.zzl(method5, zzgcVar, new Object[0])).booleanValue()) {
                            }
                            zzb(sb, i3, substring2, zzl2);
                        } else if (zzl2 instanceof Boolean) {
                            if (!((Boolean) zzl2).booleanValue()) {
                            }
                            zzb(sb, i3, substring2, zzl2);
                        } else if (zzl2 instanceof Integer) {
                            if (((Integer) zzl2).intValue() == 0) {
                            }
                            zzb(sb, i3, substring2, zzl2);
                        } else if (zzl2 instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzl2).floatValue()) == 0) {
                            }
                            zzb(sb, i3, substring2, zzl2);
                        } else if (zzl2 instanceof Double) {
                            if (Double.doubleToRawLongBits(((Double) zzl2).doubleValue()) == 0) {
                            }
                            zzb(sb, i3, substring2, zzl2);
                        } else {
                            if (zzl2 instanceof String) {
                                obj = "";
                            } else if (zzl2 instanceof zzdw) {
                                obj = zzdw.zzb;
                            } else if (zzl2 instanceof zzgc) {
                                if (zzl2 == ((zzgc) zzl2).zzf()) {
                                }
                                zzb(sb, i3, substring2, zzl2);
                            } else {
                                if ((zzl2 instanceof Enum) && ((Enum) zzl2).ordinal() == 0) {
                                }
                                zzb(sb, i3, substring2, zzl2);
                            }
                            if (zzl2.equals(obj)) {
                            }
                            zzb(sb, i3, substring2, zzl2);
                        }
                    }
                }
                i4 = 3;
            } else {
                substring = substring2.substring(0, substring2.length() - 3);
                zzl = zzex.zzl(method, zzgcVar, new Object[0]);
            }
            zzb(sb, i3, substring, zzl);
            i4 = 3;
        }
        if (zzgcVar instanceof zzeu) {
            throw null;
        }
        zzhe zzheVar = ((zzex) zzgcVar).zzc;
        if (zzheVar != null) {
            zzheVar.zzi(sb, i3);
        }
    }
}
