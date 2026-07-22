package com.google.firebase.encoders;

/* loaded from: /root/release/classes.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d3);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f3);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i3);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j3);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z3);

    @Deprecated
    ObjectEncoderContext add(String str, double d3);

    @Deprecated
    ObjectEncoderContext add(String str, int i3);

    @Deprecated
    ObjectEncoderContext add(String str, long j3);

    @Deprecated
    ObjectEncoderContext add(String str, Object obj);

    @Deprecated
    ObjectEncoderContext add(String str, boolean z3);

    ObjectEncoderContext inline(Object obj);

    ObjectEncoderContext nested(FieldDescriptor fieldDescriptor);

    ObjectEncoderContext nested(String str);
}
