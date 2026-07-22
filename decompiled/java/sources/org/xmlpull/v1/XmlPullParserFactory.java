package org.xmlpull.v1;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: /root/release/classes2.dex */
public class XmlPullParserFactory {
    public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
    private static final String RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
    static final Class referenceContextClass;
    protected String classNamesLocation;
    protected Hashtable features = new Hashtable();
    protected Vector parserClasses;
    protected Vector serializerClasses;

    static {
        new XmlPullParserFactory();
        referenceContextClass = XmlPullParserFactory.class;
    }

    protected XmlPullParserFactory() {
    }

    public static XmlPullParserFactory newInstance() {
        return newInstance(null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.xmlpull.v1.XmlPullParserFactory newInstance(java.lang.String r12, java.lang.Class r13) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.v1.XmlPullParserFactory.newInstance(java.lang.String, java.lang.Class):org.xmlpull.v1.XmlPullParserFactory");
    }

    public boolean getFeature(String str) {
        Boolean bool = (Boolean) this.features.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isNamespaceAware() {
        return getFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES);
    }

    public boolean isValidating() {
        return getFeature(XmlPullParser.FEATURE_VALIDATION);
    }

    public XmlPullParser newPullParser() {
        Vector vector = this.parserClasses;
        if (vector == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Factory initialization was incomplete - has not tried ");
            stringBuffer.append(this.classNamesLocation);
            throw new XmlPullParserException(stringBuffer.toString());
        }
        if (vector.size() == 0) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("No valid parser classes found in ");
            stringBuffer2.append(this.classNamesLocation);
            throw new XmlPullParserException(stringBuffer2.toString());
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i3 = 0; i3 < this.parserClasses.size(); i3++) {
            Class cls = (Class) this.parserClasses.elementAt(i3);
            try {
                XmlPullParser xmlPullParser = (XmlPullParser) cls.newInstance();
                Enumeration keys = this.features.keys();
                while (keys.hasMoreElements()) {
                    String str = (String) keys.nextElement();
                    Boolean bool = (Boolean) this.features.get(str);
                    if (bool != null && bool.booleanValue()) {
                        xmlPullParser.setFeature(str, true);
                    }
                }
                return xmlPullParser;
            } catch (Exception e3) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(cls.getName());
                stringBuffer4.append(": ");
                stringBuffer4.append(e3.toString());
                stringBuffer4.append("; ");
                stringBuffer3.append(stringBuffer4.toString());
            }
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("could not create parser: ");
        stringBuffer5.append((Object) stringBuffer3);
        throw new XmlPullParserException(stringBuffer5.toString());
    }

    public XmlSerializer newSerializer() {
        Vector vector = this.serializerClasses;
        if (vector == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Factory initialization incomplete - has not tried ");
            stringBuffer.append(this.classNamesLocation);
            throw new XmlPullParserException(stringBuffer.toString());
        }
        if (vector.size() == 0) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("No valid serializer classes found in ");
            stringBuffer2.append(this.classNamesLocation);
            throw new XmlPullParserException(stringBuffer2.toString());
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i3 = 0; i3 < this.serializerClasses.size(); i3++) {
            Class cls = (Class) this.serializerClasses.elementAt(i3);
            try {
                return (XmlSerializer) cls.newInstance();
            } catch (Exception e3) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(cls.getName());
                stringBuffer4.append(": ");
                stringBuffer4.append(e3.toString());
                stringBuffer4.append("; ");
                stringBuffer3.append(stringBuffer4.toString());
            }
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append("could not create serializer: ");
        stringBuffer5.append((Object) stringBuffer3);
        throw new XmlPullParserException(stringBuffer5.toString());
    }

    public void setFeature(String str, boolean z3) {
        this.features.put(str, new Boolean(z3));
    }

    public void setNamespaceAware(boolean z3) {
        this.features.put(XmlPullParser.FEATURE_PROCESS_NAMESPACES, new Boolean(z3));
    }

    public void setValidating(boolean z3) {
        this.features.put(XmlPullParser.FEATURE_VALIDATION, new Boolean(z3));
    }
}
