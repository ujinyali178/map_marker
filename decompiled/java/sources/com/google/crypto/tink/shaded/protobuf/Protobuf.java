package com.google.crypto.tink.shaded.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@CheckReturnValue
/* loaded from: /root/release/classes.dex */
final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    int getTotalSchemaSize() {
        int i3 = 0;
        for (Schema<?> schema : this.schemaCache.values()) {
            if (schema instanceof MessageSchema) {
                i3 += ((MessageSchema) schema).getSchemaSize();
            }
        }
        return i3;
    }

    <T> boolean isInitialized(T t3) {
        return schemaFor((Protobuf) t3).isInitialized(t3);
    }

    public <T> void makeImmutable(T t3) {
        schemaFor((Protobuf) t3).makeImmutable(t3);
    }

    public <T> void mergeFrom(T t3, Reader reader) {
        mergeFrom(t3, reader, ExtensionRegistryLite.getEmptyRegistry());
    }

    public <T> void mergeFrom(T t3, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        schemaFor((Protobuf) t3).mergeFrom(t3, reader, extensionRegistryLite);
    }

    public Schema<?> registerSchema(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.putIfAbsent(cls, schema);
    }

    public Schema<?> registerSchemaOverride(Class<?> cls, Schema<?> schema) {
        Internal.checkNotNull(cls, "messageType");
        Internal.checkNotNull(schema, "schema");
        return this.schemaCache.put(cls, schema);
    }

    public <T> Schema<T> schemaFor(Class<T> cls) {
        Internal.checkNotNull(cls, "messageType");
        Schema<T> schema = (Schema) this.schemaCache.get(cls);
        if (schema != null) {
            return schema;
        }
        Schema<T> createSchema = this.schemaFactory.createSchema(cls);
        Schema<T> schema2 = (Schema<T>) registerSchema(cls, createSchema);
        return schema2 != null ? schema2 : createSchema;
    }

    public <T> Schema<T> schemaFor(T t3) {
        return schemaFor((Class) t3.getClass());
    }

    public <T> void writeTo(T t3, Writer writer) {
        schemaFor((Protobuf) t3).writeTo(t3, writer);
    }
}
