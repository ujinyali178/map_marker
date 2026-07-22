package org.kxml2.kdom;

import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: /root/release/classes2.dex */
public class Element extends Node {
    protected Vector attributes;
    protected String name;
    protected String namespace;
    protected Node parent;
    protected Vector prefixes;

    public void clear() {
        this.attributes = null;
        this.children = null;
    }

    @Override // org.kxml2.kdom.Node
    public Element createElement(String str, String str2) {
        Node node = this.parent;
        return node == null ? super.createElement(str, str2) : node.createElement(str, str2);
    }

    public int getAttributeCount() {
        Vector vector = this.attributes;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public String getAttributeName(int i3) {
        return ((String[]) this.attributes.elementAt(i3))[1];
    }

    public String getAttributeNamespace(int i3) {
        return ((String[]) this.attributes.elementAt(i3))[0];
    }

    public String getAttributeValue(int i3) {
        return ((String[]) this.attributes.elementAt(i3))[2];
    }

    public String getAttributeValue(String str, String str2) {
        for (int i3 = 0; i3 < getAttributeCount(); i3++) {
            if (str2.equals(getAttributeName(i3)) && (str == null || str.equals(getAttributeNamespace(i3)))) {
                return getAttributeValue(i3);
            }
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public int getNamespaceCount() {
        Vector vector = this.prefixes;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public String getNamespacePrefix(int i3) {
        return ((String[]) this.prefixes.elementAt(i3))[0];
    }

    public String getNamespaceUri(int i3) {
        return ((String[]) this.prefixes.elementAt(i3))[1];
    }

    public String getNamespaceUri(String str) {
        int namespaceCount = getNamespaceCount();
        for (int i3 = 0; i3 < namespaceCount; i3++) {
            if (str == getNamespacePrefix(i3) || (str != null && str.equals(getNamespacePrefix(i3)))) {
                return getNamespaceUri(i3);
            }
        }
        Node node = this.parent;
        if (node instanceof Element) {
            return ((Element) node).getNamespaceUri(str);
        }
        return null;
    }

    public Node getParent() {
        return this.parent;
    }

    public Node getRoot() {
        Element element = this;
        while (true) {
            Node node = element.parent;
            if (node == null) {
                return element;
            }
            if (!(node instanceof Element)) {
                return node;
            }
            element = (Element) node;
        }
    }

    public void init() {
    }

    @Override // org.kxml2.kdom.Node
    public void parse(XmlPullParser xmlPullParser) {
        for (int namespaceCount = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth() - 1); namespaceCount < xmlPullParser.getNamespaceCount(xmlPullParser.getDepth()); namespaceCount++) {
            setPrefix(xmlPullParser.getNamespacePrefix(namespaceCount), xmlPullParser.getNamespaceUri(namespaceCount));
        }
        for (int i3 = 0; i3 < xmlPullParser.getAttributeCount(); i3++) {
            setAttribute(xmlPullParser.getAttributeNamespace(i3), xmlPullParser.getAttributeName(i3), xmlPullParser.getAttributeValue(i3));
        }
        init();
        boolean isEmptyElementTag = xmlPullParser.isEmptyElementTag();
        xmlPullParser.nextToken();
        if (!isEmptyElementTag) {
            super.parse(xmlPullParser);
            if (getChildCount() == 0) {
                addChild(7, "");
            }
        }
        xmlPullParser.require(3, getNamespace(), getName());
        xmlPullParser.nextToken();
    }

    public void setAttribute(String str, String str2, String str3) {
        if (this.attributes == null) {
            this.attributes = new Vector();
        }
        if (str == null) {
            str = "";
        }
        for (int size = this.attributes.size() - 1; size >= 0; size--) {
            String[] strArr = (String[]) this.attributes.elementAt(size);
            if (strArr[0].equals(str) && strArr[1].equals(str2)) {
                if (str3 == null) {
                    this.attributes.removeElementAt(size);
                    return;
                } else {
                    strArr[2] = str3;
                    return;
                }
            }
        }
        this.attributes.addElement(new String[]{str, str2, str3});
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNamespace(String str) {
        if (str == null) {
            throw new NullPointerException("Use \"\" for empty namespace");
        }
        this.namespace = str;
    }

    protected void setParent(Node node) {
        this.parent = node;
    }

    public void setPrefix(String str, String str2) {
        if (this.prefixes == null) {
            this.prefixes = new Vector();
        }
        this.prefixes.addElement(new String[]{str, str2});
    }

    @Override // org.kxml2.kdom.Node
    public void write(XmlSerializer xmlSerializer) {
        if (this.prefixes != null) {
            for (int i3 = 0; i3 < this.prefixes.size(); i3++) {
                xmlSerializer.setPrefix(getNamespacePrefix(i3), getNamespaceUri(i3));
            }
        }
        xmlSerializer.startTag(getNamespace(), getName());
        int attributeCount = getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            xmlSerializer.attribute(getAttributeNamespace(i4), getAttributeName(i4), getAttributeValue(i4));
        }
        writeChildren(xmlSerializer);
        xmlSerializer.endTag(getNamespace(), getName());
    }
}
