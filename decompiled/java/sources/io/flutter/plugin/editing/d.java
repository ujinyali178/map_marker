package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.editing.e;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import t1.s;

/* loaded from: /root/release/classes.dex */
public class d extends BaseInputConnection implements e.b {

    /* renamed from: a, reason: collision with root package name */
    private final View f3051a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3052b;

    /* renamed from: c, reason: collision with root package name */
    private final s f3053c;

    /* renamed from: d, reason: collision with root package name */
    private final e f3054d;

    /* renamed from: e, reason: collision with root package name */
    private final EditorInfo f3055e;

    /* renamed from: f, reason: collision with root package name */
    private ExtractedTextRequest f3056f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3057g;

    /* renamed from: h, reason: collision with root package name */
    private CursorAnchorInfo.Builder f3058h;

    /* renamed from: i, reason: collision with root package name */
    private ExtractedText f3059i;

    /* renamed from: j, reason: collision with root package name */
    private InputMethodManager f3060j;

    /* renamed from: k, reason: collision with root package name */
    private final Layout f3061k;

    /* renamed from: l, reason: collision with root package name */
    private io.flutter.plugin.editing.a f3062l;

    /* renamed from: m, reason: collision with root package name */
    private final a f3063m;

    /* renamed from: n, reason: collision with root package name */
    private int f3064n;

    public interface a {
        boolean a(KeyEvent keyEvent);
    }

    public d(View view, int i3, s sVar, a aVar, e eVar, EditorInfo editorInfo) {
        this(view, i3, sVar, aVar, eVar, editorInfo, new FlutterJNI());
    }

    public d(View view, int i3, s sVar, a aVar, e eVar, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.f3057g = false;
        this.f3059i = new ExtractedText();
        this.f3064n = 0;
        this.f3051a = view;
        this.f3052b = i3;
        this.f3053c = sVar;
        this.f3054d = eVar;
        eVar.a(this);
        this.f3055e = editorInfo;
        this.f3063m = aVar;
        this.f3062l = new io.flutter.plugin.editing.a(flutterJNI);
        this.f3061k = new DynamicLayout(eVar, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, BitmapDescriptorFactory.HUE_RED, false);
        this.f3060j = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    private boolean b(int i3) {
        if (i3 == 16908319) {
            setSelection(0, this.f3054d.length());
            return true;
        }
        if (i3 == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.f3054d);
            int selectionEnd = Selection.getSelectionEnd(this.f3054d);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.f3051a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f3054d.subSequence(min, max)));
                this.f3054d.delete(min, max);
                setSelection(min, min);
            }
            return true;
        }
        if (i3 == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.f3054d);
            int selectionEnd2 = Selection.getSelectionEnd(this.f3054d);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.f3051a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f3054d.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        }
        if (i3 != 16908322) {
            return false;
        }
        ClipData primaryClip = ((ClipboardManager) this.f3051a.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip != null) {
            CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.f3051a.getContext());
            int max2 = Math.max(0, Selection.getSelectionStart(this.f3054d));
            int max3 = Math.max(0, Selection.getSelectionEnd(this.f3054d));
            int min2 = Math.min(max2, max3);
            int max4 = Math.max(max2, max3);
            if (min2 != max4) {
                this.f3054d.delete(min2, max4);
            }
            this.f3054d.insert(min2, coerceToText);
            int length = min2 + coerceToText.length();
            setSelection(length, length);
        }
        return true;
    }

    private CursorAnchorInfo c() {
        CursorAnchorInfo.Builder builder = this.f3058h;
        if (builder == null) {
            this.f3058h = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.f3058h.setSelectionRange(this.f3054d.i(), this.f3054d.h());
        int g3 = this.f3054d.g();
        int f3 = this.f3054d.f();
        if (g3 < 0 || f3 <= g3) {
            this.f3058h.setComposingText(-1, "");
        } else {
            this.f3058h.setComposingText(g3, this.f3054d.toString().subSequence(g3, f3));
        }
        return this.f3058h.build();
    }

    private ExtractedText d(ExtractedTextRequest extractedTextRequest) {
        ExtractedText extractedText = this.f3059i;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.selectionStart = this.f3054d.i();
        this.f3059i.selectionEnd = this.f3054d.h();
        this.f3059i.text = (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) ? this.f3054d.toString() : this.f3054d;
        return this.f3059i;
    }

    private boolean e(boolean z3, boolean z4) {
        int selectionStart = Selection.getSelectionStart(this.f3054d);
        int selectionEnd = Selection.getSelectionEnd(this.f3054d);
        boolean z5 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        int max = z3 ? Math.max(this.f3062l.b(this.f3054d, selectionEnd), 0) : Math.min(this.f3062l.a(this.f3054d, selectionEnd), this.f3054d.length());
        if (selectionStart == selectionEnd && !z4) {
            z5 = true;
        }
        if (z5) {
            setSelection(max, max);
        } else {
            setSelection(selectionStart, max);
        }
        return true;
    }

    private boolean g(boolean z3, boolean z4) {
        int selectionStart = Selection.getSelectionStart(this.f3054d);
        int selectionEnd = Selection.getSelectionEnd(this.f3054d);
        boolean z5 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z4) {
            z5 = true;
        }
        beginBatchEdit();
        if (z5) {
            if (z3) {
                Selection.moveUp(this.f3054d, this.f3061k);
            } else {
                Selection.moveDown(this.f3054d, this.f3061k);
            }
            int selectionStart2 = Selection.getSelectionStart(this.f3054d);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z3) {
                Selection.extendUp(this.f3054d, this.f3061k);
            } else {
                Selection.extendDown(this.f3054d, this.f3061k);
            }
            setSelection(Selection.getSelectionStart(this.f3054d), Selection.getSelectionEnd(this.f3054d));
        }
        endBatchEdit();
        return true;
    }

    private byte[] h(InputStream inputStream, int i3) {
        int i4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i3];
        while (true) {
            try {
                i4 = inputStream.read(bArr);
            } catch (IOException unused) {
                i4 = -1;
            }
            if (i4 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i4);
        }
    }

    @Override // io.flutter.plugin.editing.e.b
    public void a(boolean z3, boolean z4, boolean z5) {
        this.f3060j.updateSelection(this.f3051a, this.f3054d.i(), this.f3054d.h(), this.f3054d.g(), this.f3054d.f());
        ExtractedTextRequest extractedTextRequest = this.f3056f;
        if (extractedTextRequest != null) {
            this.f3060j.updateExtractedText(this.f3051a, extractedTextRequest.token, d(extractedTextRequest));
        }
        if (this.f3057g) {
            this.f3060j.updateCursorAnchorInfo(this.f3051a, c());
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.f3054d.b();
        this.f3064n++;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i3) {
        return super.clearMetaKeyStates(i3);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public void closeConnection() {
        super.closeConnection();
        this.f3054d.l(this);
        while (this.f3064n > 0) {
            endBatchEdit();
            this.f3064n--;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i3 & 1) != 0) {
            try {
                inputContentInfo.requestPermission();
                if (inputContentInfo.getDescription().getMimeTypeCount() > 0) {
                    inputContentInfo.requestPermission();
                    Uri contentUri = inputContentInfo.getContentUri();
                    String mimeType = inputContentInfo.getDescription().getMimeType(0);
                    Context context = this.f3051a.getContext();
                    if (contentUri != null) {
                        try {
                            InputStream openInputStream = context.getContentResolver().openInputStream(contentUri);
                            if (openInputStream != null) {
                                byte[] h3 = h(openInputStream, 65536);
                                HashMap hashMap = new HashMap();
                                hashMap.put("mimeType", mimeType);
                                hashMap.put("data", h3);
                                hashMap.put("uri", contentUri.toString());
                                this.f3053c.b(this.f3052b, hashMap);
                                inputContentInfo.releasePermission();
                                return true;
                            }
                        } catch (FileNotFoundException unused) {
                            inputContentInfo.releasePermission();
                            return false;
                        }
                    }
                    inputContentInfo.releasePermission();
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i3) {
        return super.commitText(charSequence, i3);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i3, int i4) {
        if (this.f3054d.i() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i3, i4);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i3, int i4) {
        return super.deleteSurroundingTextInCodePoints(i3, i4);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.f3064n--;
        this.f3054d.d();
        return endBatchEdit;
    }

    public boolean f(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            if (keyEvent.getKeyCode() == 21) {
                return e(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 22) {
                return e(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 19) {
                return g(true, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 20) {
                return g(false, keyEvent.isShiftPressed());
            }
            if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                EditorInfo editorInfo = this.f3055e;
                if ((131072 & editorInfo.inputType) == 0) {
                    performEditorAction(editorInfo.imeOptions & 255);
                    return true;
                }
            }
            int selectionStart = Selection.getSelectionStart(this.f3054d);
            int selectionEnd = Selection.getSelectionEnd(this.f3054d);
            int unicodeChar = keyEvent.getUnicodeChar();
            if (selectionStart >= 0 && selectionEnd >= 0 && unicodeChar != 0) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                beginBatchEdit();
                if (min != max) {
                    this.f3054d.delete(min, max);
                }
                this.f3054d.insert(min, (CharSequence) String.valueOf((char) unicodeChar));
                int i3 = min + 1;
                setSelection(i3, i3);
                endBatchEdit();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        return this.f3054d;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i3) {
        boolean z3 = (i3 & 1) != 0;
        if (z3 == (this.f3056f == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z3 ? "on" : "off");
            g1.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f3056f = z3 ? extractedTextRequest : null;
        return d(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i3) {
        beginBatchEdit();
        boolean b4 = b(i3);
        endBatchEdit();
        return b4;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i3) {
        if (i3 == 0) {
            this.f3053c.o(this.f3052b);
        } else if (i3 == 1) {
            this.f3053c.g(this.f3052b);
        } else if (i3 == 2) {
            this.f3053c.f(this.f3052b);
        } else if (i3 == 3) {
            this.f3053c.l(this.f3052b);
        } else if (i3 == 4) {
            this.f3053c.m(this.f3052b);
        } else if (i3 == 5) {
            this.f3053c.h(this.f3052b);
        } else if (i3 != 7) {
            this.f3053c.e(this.f3052b);
        } else {
            this.f3053c.j(this.f3052b);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.f3053c.i(this.f3052b, str, bundle);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i3) {
        if ((i3 & 1) != 0) {
            this.f3060j.updateCursorAnchorInfo(this.f3051a, c());
        }
        boolean z3 = (i3 & 2) != 0;
        if (z3 != this.f3057g) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z3 ? "on" : "off");
            g1.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f3057g = z3;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.f3063m.a(keyEvent);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i3, int i4) {
        return super.setComposingRegion(i3, i4);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i3) {
        beginBatchEdit();
        boolean commitText = charSequence.length() == 0 ? super.commitText(charSequence, i3) : super.setComposingText(charSequence, i3);
        endBatchEdit();
        return commitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i3, int i4) {
        beginBatchEdit();
        boolean selection = super.setSelection(i3, i4);
        endBatchEdit();
        return selection;
    }
}
