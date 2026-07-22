package org.kxml2.kdom;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: /root/release/classes2.dex */
public class Document extends Node {
    String encoding;
    protected int rootIndex = -1;
    Boolean standalone;

    @Override // org.kxml2.kdom.Node
    public void addChild(int i3, int i4, Object obj) {
        if (i4 == 2) {
            this.rootIndex = i3;
        } else {
            int i5 = this.rootIndex;
            if (i5 >= i3) {
                this.rootIndex = i5 + 1;
            }
        }
        super.addChild(i3, i4, obj);
    }

    public String getEncoding() {
        return this.encoding;
    }

    public String getName() {
        return "#document";
    }

    public Element getRootElement() {
        int i3 = this.rootIndex;
        if (i3 != -1) {
            return (Element) getChild(i3);
        }
        throw new RuntimeException("Document has no root element!");
    }

    public Boolean getStandalone() {
        return this.standalone;
    }

    @Override // org.kxml2.kdom.Node
    public void parse(XmlPullParser xmlPullParser) {
        xmlPullParser.require(0, null, null);
        xmlPullParser.nextToken();
        this.encoding = xmlPullParser.getInputEncoding();
        this.standalone = (Boolean) xmlPullParser.getProperty("http://xmlpull.org/v1/doc/properties.html#xmldecl-standalone");
        super.parse(xmlPullParser);
        if (xmlPullParser.getEventType() != 1) {
            throw new RuntimeException("Document end expected!");
        }
    }

    @Override // org.kxml2.kdom.Node
    public void removeChild(int i3) {
        int i4;
        int i5 = this.rootIndex;
        if (i3 != i5) {
            i4 = i3 < i5 ? i5 - 1 : -1;
            super.removeChild(i3);
        }
        this.rootIndex = i4;
        super.removeChild(i3);
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setStandalone(Boolean bool) {
        this.standalone = bool;
    }

    @Override // org.kxml2.kdom.Node
    public void write(XmlSerializer xmlSerializer) {
        xmlSerializer.startDocument(this.encoding, this.standalone);
        writeChildren(xmlSerializer);
        xmlSerializer.endDocument();
    }
}
