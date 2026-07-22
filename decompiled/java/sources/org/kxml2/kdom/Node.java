package org.kxml2.kdom;

import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: /root/release/classes2.dex */
public class Node {
    public static final int CDSECT = 5;
    public static final int COMMENT = 9;
    public static final int DOCDECL = 10;
    public static final int DOCUMENT = 0;
    public static final int ELEMENT = 2;
    public static final int ENTITY_REF = 6;
    public static final int IGNORABLE_WHITESPACE = 7;
    public static final int PROCESSING_INSTRUCTION = 8;
    public static final int TEXT = 4;
    protected Vector children;
    protected StringBuffer types;

    public void addChild(int i3, int i4, Object obj) {
        obj.getClass();
        if (this.children == null) {
            this.children = new Vector();
            this.types = new StringBuffer();
        }
        if (i4 == 2) {
            if (!(obj instanceof Element)) {
                throw new RuntimeException("Element obj expected)");
            }
            ((Element) obj).setParent(this);
        } else if (!(obj instanceof String)) {
            throw new RuntimeException("String expected");
        }
        this.children.insertElementAt(obj, i3);
        this.types.insert(i3, (char) i4);
    }

    public void addChild(int i3, Object obj) {
        addChild(getChildCount(), i3, obj);
    }

    public Element createElement(String str, String str2) {
        Element element = new Element();
        if (str == null) {
            str = "";
        }
        element.namespace = str;
        element.name = str2;
        return element;
    }

    public Object getChild(int i3) {
        return this.children.elementAt(i3);
    }

    public int getChildCount() {
        Vector vector = this.children;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public Element getElement(int i3) {
        Object child = getChild(i3);
        if (child instanceof Element) {
            return (Element) child;
        }
        return null;
    }

    public Element getElement(String str, String str2) {
        int indexOf = indexOf(str, str2, 0);
        int indexOf2 = indexOf(str, str2, indexOf + 1);
        if (indexOf != -1 && indexOf2 == -1) {
            return getElement(indexOf);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Element {");
        stringBuffer.append(str);
        stringBuffer.append("}");
        stringBuffer.append(str2);
        stringBuffer.append(indexOf == -1 ? " not found in " : " more than once in ");
        stringBuffer.append(this);
        throw new RuntimeException(stringBuffer.toString());
    }

    public String getText(int i3) {
        if (isText(i3)) {
            return (String) getChild(i3);
        }
        return null;
    }

    public int getType(int i3) {
        return this.types.charAt(i3);
    }

    public int indexOf(String str, String str2, int i3) {
        int childCount = getChildCount();
        while (i3 < childCount) {
            Element element = getElement(i3);
            if (element != null && str2.equals(element.getName()) && (str == null || str.equals(element.getNamespace()))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public boolean isText(int i3) {
        int type = getType(i3);
        return type == 4 || type == 7 || type == 5;
    }

    public void parse(XmlPullParser xmlPullParser) {
        boolean z3 = false;
        do {
            int eventType = xmlPullParser.getEventType();
            if (eventType != 1) {
                if (eventType == 2) {
                    Element createElement = createElement(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    addChild(2, createElement);
                    createElement.parse(xmlPullParser);
                } else if (eventType != 3) {
                    if (xmlPullParser.getText() != null) {
                        if (eventType == 6) {
                            eventType = 4;
                        }
                        addChild(eventType, xmlPullParser.getText());
                    } else if (eventType == 6 && xmlPullParser.getName() != null) {
                        addChild(6, xmlPullParser.getName());
                    }
                    xmlPullParser.nextToken();
                }
            }
            z3 = true;
        } while (!z3);
    }

    public void removeChild(int i3) {
        this.children.removeElementAt(i3);
        int length = this.types.length() - 1;
        while (i3 < length) {
            StringBuffer stringBuffer = this.types;
            int i4 = i3 + 1;
            stringBuffer.setCharAt(i3, stringBuffer.charAt(i4));
            i3 = i4;
        }
        this.types.setLength(length);
    }

    public void write(XmlSerializer xmlSerializer) {
        writeChildren(xmlSerializer);
        xmlSerializer.flush();
    }

    public void writeChildren(XmlSerializer xmlSerializer) {
        Vector vector = this.children;
        if (vector == null) {
            return;
        }
        int size = vector.size();
        for (int i3 = 0; i3 < size; i3++) {
            int type = getType(i3);
            Object elementAt = this.children.elementAt(i3);
            switch (type) {
                case 2:
                    ((Element) elementAt).write(xmlSerializer);
                    break;
                case 3:
                default:
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Illegal type: ");
                    stringBuffer.append(type);
                    throw new RuntimeException(stringBuffer.toString());
                case 4:
                    xmlSerializer.text((String) elementAt);
                    break;
                case 5:
                    xmlSerializer.cdsect((String) elementAt);
                    break;
                case 6:
                    xmlSerializer.entityRef((String) elementAt);
                    break;
                case 7:
                    xmlSerializer.ignorableWhitespace((String) elementAt);
                    break;
                case 8:
                    xmlSerializer.processingInstruction((String) elementAt);
                    break;
                case 9:
                    xmlSerializer.comment((String) elementAt);
                    break;
                case 10:
                    xmlSerializer.docdecl((String) elementAt);
                    break;
            }
        }
    }
}
