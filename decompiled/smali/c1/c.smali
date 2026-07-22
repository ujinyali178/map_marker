.class public final Lc1/c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lu1/l$c;


# instance fields
.field private final c:Lc1/b;

.field private d:Lu1/l;


# direct methods
.method constructor <init>(Lc1/b;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lc1/c;->c:Lc1/b;

    return-void
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/String;
    .registers 3

    if-nez p0, :cond_4

    const/4 p0, 0x0

    return-object p0

    :cond_4
    const/4 v0, -0x1

    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v1

    sparse-switch v1, :sswitch_data_56

    goto :goto_43

    :sswitch_d
    const-string v1, "action_voice"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_16

    goto :goto_43

    :cond_16
    const/4 v0, 0x4

    goto :goto_43

    :sswitch_18
    const-string v1, "action_view"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_21

    goto :goto_43

    :cond_21
    const/4 v0, 0x3

    goto :goto_43

    :sswitch_23
    const-string v1, "settings"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2c

    goto :goto_43

    :cond_2c
    const/4 v0, 0x2

    goto :goto_43

    :sswitch_2e
    const-string v1, "action_application_details_settings"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_37

    goto :goto_43

    :cond_37
    const/4 v0, 0x1

    goto :goto_43

    :sswitch_39
    const-string v1, "action_location_source_settings"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_42

    goto :goto_43

    :cond_42
    const/4 v0, 0x0

    :goto_43
    packed-switch v0, :pswitch_data_6c

    return-object p0

    :pswitch_47
    const-string p0, "android.intent.action.VOICE_COMMAND"

    return-object p0

    :pswitch_4a
    const-string p0, "android.intent.action.VIEW"

    return-object p0

    :pswitch_4d
    const-string p0, "android.settings.SETTINGS"

    return-object p0

    :pswitch_50
    const-string p0, "android.settings.APPLICATION_DETAILS_SETTINGS"

    return-object p0

    :pswitch_53
    const-string p0, "android.settings.LOCATION_SOURCE_SETTINGS"

    return-object p0

    :sswitch_data_56
    .sparse-switch
        -0x622942da -> :sswitch_39
        -0x446fb208 -> :sswitch_2e
        0x5582bc23 -> :sswitch_23
        0x5e66e70e -> :sswitch_18
        0x6e78c1e9 -> :sswitch_d
    .end sparse-switch

    :pswitch_data_6c
    .packed-switch 0x0
        :pswitch_53
        :pswitch_50
        :pswitch_4d
        :pswitch_4a
        :pswitch_47
    .end packed-switch
.end method

.method private static b(Ljava/util/Map;)Landroid/os/Bundle;
    .registers 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "*>;)",
            "Landroid/os/Bundle;"
        }
    .end annotation

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    if-nez p0, :cond_8

    return-object v0

    :cond_8
    invoke-interface {p0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_10
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_d0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {p0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    instance-of v4, v3, Ljava/lang/Integer;

    if-eqz v4, :cond_2e

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    goto :goto_10

    :cond_2e
    instance-of v4, v3, Ljava/lang/String;

    if-eqz v4, :cond_38

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/BaseBundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_10

    :cond_38
    instance-of v4, v3, Ljava/lang/Boolean;

    if-eqz v4, :cond_46

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_10

    :cond_46
    instance-of v4, v3, Ljava/lang/Double;

    if-eqz v4, :cond_54

    check-cast v3, Ljava/lang/Double;

    invoke-virtual {v3}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v3

    invoke-virtual {v0, v2, v3, v4}, Landroid/os/BaseBundle;->putDouble(Ljava/lang/String;D)V

    goto :goto_10

    :cond_54
    instance-of v4, v3, Ljava/lang/Long;

    if-eqz v4, :cond_62

    check-cast v3, Ljava/lang/Long;

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-virtual {v0, v2, v3, v4}, Landroid/os/BaseBundle;->putLong(Ljava/lang/String;J)V

    goto :goto_10

    :cond_62
    instance-of v4, v3, [B

    if-eqz v4, :cond_6c

    check-cast v3, [B

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putByteArray(Ljava/lang/String;[B)V

    goto :goto_10

    :cond_6c
    instance-of v4, v3, [I

    if-eqz v4, :cond_76

    check-cast v3, [I

    invoke-virtual {v0, v2, v3}, Landroid/os/BaseBundle;->putIntArray(Ljava/lang/String;[I)V

    goto :goto_10

    :cond_76
    instance-of v4, v3, [J

    if-eqz v4, :cond_80

    check-cast v3, [J

    invoke-virtual {v0, v2, v3}, Landroid/os/BaseBundle;->putLongArray(Ljava/lang/String;[J)V

    goto :goto_10

    :cond_80
    instance-of v4, v3, [D

    if-eqz v4, :cond_8a

    check-cast v3, [D

    invoke-virtual {v0, v2, v3}, Landroid/os/BaseBundle;->putDoubleArray(Ljava/lang/String;[D)V

    goto :goto_10

    :cond_8a
    const-class v4, Ljava/lang/Integer;

    invoke-static {v3, v4}, Lc1/c;->e(Ljava/lang/Object;Ljava/lang/Class;)Z

    move-result v4

    if-eqz v4, :cond_99

    check-cast v3, Ljava/util/ArrayList;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putIntegerArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_10

    :cond_99
    const-class v4, Ljava/lang/String;

    invoke-static {v3, v4}, Lc1/c;->e(Ljava/lang/Object;Ljava/lang/Class;)Z

    move-result v4

    if-eqz v4, :cond_a8

    check-cast v3, Ljava/util/ArrayList;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putStringArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    goto/16 :goto_10

    :cond_a8
    invoke-static {v3}, Lc1/c;->d(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_b9

    check-cast v3, Ljava/util/Map;

    invoke-static {v3}, Lc1/c;->b(Ljava/util/Map;)Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    goto/16 :goto_10

    :cond_b9
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unsupported type "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_d0
    return-object v0
.end method

.method private static c(Ljava/util/Map;)Landroid/os/Bundle;
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "*>;)",
            "Landroid/os/Bundle;"
        }
    .end annotation

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    if-nez p0, :cond_8

    return-object v0

    :cond_8
    invoke-interface {p0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_10
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_f9

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {p0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    const-class v4, Ljava/lang/Boolean;

    invoke-static {v3, v4}, Lc1/c;->e(Ljava/lang/Object;Ljava/lang/Class;)Z

    move-result v4

    const/4 v5, 0x0

    if-eqz v4, :cond_4a

    check-cast v3, Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    new-array v4, v4, [Z

    :goto_31
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-ge v5, v6, :cond_46

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    aput-boolean v6, v4, v5

    add-int/lit8 v5, v5, 0x1

    goto :goto_31

    :cond_46
    invoke-virtual {v0, v2, v4}, Landroid/os/Bundle;->putBooleanArray(Ljava/lang/String;[Z)V

    goto :goto_10

    :cond_4a
    const-class v4, Ljava/lang/Integer;

    invoke-static {v3, v4}, Lc1/c;->e(Ljava/lang/Object;Ljava/lang/Class;)Z

    move-result v4

    if-eqz v4, :cond_73

    check-cast v3, Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    new-array v4, v4, [I

    :goto_5a
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-ge v5, v6, :cond_6f

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    aput v6, v4, v5

    add-int/lit8 v5, v5, 0x1

    goto :goto_5a

    :cond_6f
    invoke-virtual {v0, v2, v4}, Landroid/os/BaseBundle;->putIntArray(Ljava/lang/String;[I)V

    goto :goto_10

    :cond_73
    const-class v4, Ljava/lang/Long;

    invoke-static {v3, v4}, Lc1/c;->e(Ljava/lang/Object;Ljava/lang/Class;)Z

    move-result v4

    if-eqz v4, :cond_9d

    check-cast v3, Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    new-array v4, v4, [J

    :goto_83
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-ge v5, v6, :cond_98

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Long;

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    aput-wide v6, v4, v5

    add-int/lit8 v5, v5, 0x1

    goto :goto_83

    :cond_98
    invoke-virtual {v0, v2, v4}, Landroid/os/BaseBundle;->putLongArray(Ljava/lang/String;[J)V

    goto/16 :goto_10

    :cond_9d
    const-class v4, Ljava/lang/Double;

    invoke-static {v3, v4}, Lc1/c;->e(Ljava/lang/Object;Ljava/lang/Class;)Z

    move-result v4

    if-eqz v4, :cond_c7

    check-cast v3, Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    new-array v4, v4, [D

    :goto_ad
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-ge v5, v6, :cond_c2

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Double;

    invoke-virtual {v6}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    aput-wide v6, v4, v5

    add-int/lit8 v5, v5, 0x1

    goto :goto_ad

    :cond_c2
    invoke-virtual {v0, v2, v4}, Landroid/os/BaseBundle;->putDoubleArray(Ljava/lang/String;[D)V

    goto/16 :goto_10

    :cond_c7
    const-class v4, Ljava/lang/String;

    invoke-static {v3, v4}, Lc1/c;->e(Ljava/lang/Object;Ljava/lang/Class;)Z

    move-result v4

    if-eqz v4, :cond_e2

    check-cast v3, Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    new-array v4, v4, [Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/BaseBundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    goto/16 :goto_10

    :cond_e2
    new-instance p0, Ljava/lang/UnsupportedOperationException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unsupported type "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p0

    :cond_f9
    return-object v0
.end method

.method private static d(Ljava/lang/Object;)Z
    .registers 3

    instance-of v0, p0, Ljava/util/Map;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    check-cast p0, Ljava/util/Map;

    invoke-interface {p0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object p0

    invoke-interface {p0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_10
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_21

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_10

    instance-of v0, v0, Ljava/lang/String;

    if-nez v0, :cond_10

    return v1

    :cond_21
    const/4 p0, 0x1

    return p0
.end method

.method private static e(Ljava/lang/Object;Ljava/lang/Class;)Z
    .registers 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Ljava/lang/Class<",
            "*>;)Z"
        }
    .end annotation

    instance-of v0, p0, Ljava/util/ArrayList;

    const/4 v1, 0x0

    if-nez v0, :cond_6

    return v1

    :cond_6
    check-cast p0, Ljava/util/ArrayList;

    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_c
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1f

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_c

    invoke-virtual {p1, v0}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_c

    return v1

    :cond_1f
    const/4 p0, 0x1

    return p0
.end method


# virtual methods
.method f(Lu1/d;)V
    .registers 4

    iget-object v0, p0, Lc1/c;->d:Lu1/l;

    if-eqz v0, :cond_e

    const-string v0, "MethodCallHandlerImpl"

    const-string v1, "Setting a method call handler before the last was disposed."

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {p0}, Lc1/c;->g()V

    :cond_e
    new-instance v0, Lu1/l;

    const-string v1, "dev.fluttercommunity.plus/android_intent"

    invoke-direct {v0, p1, v1}, Lu1/l;-><init>(Lu1/d;Ljava/lang/String;)V

    iput-object v0, p0, Lc1/c;->d:Lu1/l;

    invoke-virtual {v0, p0}, Lu1/l;->e(Lu1/l$c;)V

    return-void
.end method

.method g()V
    .registers 3

    iget-object v0, p0, Lc1/c;->d:Lu1/l;

    if-nez v0, :cond_c

    const-string v0, "MethodCallHandlerImpl"

    const-string v1, "Tried to stop listening when no methodChannel had been initialized."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_c
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lu1/l;->e(Lu1/l$c;)V

    iput-object v1, p0, Lc1/c;->d:Lu1/l;

    return-void
.end method

.method public n(Lu1/k;Lu1/l$d;)V
    .registers 14

    const-string v0, "action"

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lc1/c;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v0, "flags"

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    move-object v3, v0

    check-cast v3, Ljava/lang/Integer;

    const-string v0, "category"

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    move-object v4, v0

    check-cast v4, Ljava/lang/String;

    const-string v0, "data"

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    const/4 v10, 0x0

    if-eqz v1, :cond_33

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    move-object v5, v0

    goto :goto_34

    :cond_33
    move-object v5, v10

    :goto_34
    const-string v0, "arguments"

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-static {v0}, Lc1/c;->b(Ljava/util/Map;)Landroid/os/Bundle;

    move-result-object v6

    const-string v0, "arrayArguments"

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-static {v0}, Lc1/c;->c(Ljava/util/Map;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    const-string v0, "package"

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    move-object v7, v0

    check-cast v7, Ljava/lang/String;

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_79

    const-string v0, "componentName"

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_79

    new-instance v1, Landroid/content/ComponentName;

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {v1, v7, v0}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object v8, v1

    goto :goto_7a

    :cond_79
    move-object v8, v10

    :goto_7a
    const-string v0, "type"

    invoke-virtual {p1, v0}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    move-object v9, v0

    check-cast v9, Ljava/lang/String;

    iget-object v1, p0, Lc1/c;->c:Lc1/b;

    invoke-virtual/range {v1 .. v9}, Lc1/b;->a(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Landroid/net/Uri;Landroid/os/Bundle;Ljava/lang/String;Landroid/content/ComponentName;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    iget-object v1, p1, Lu1/k;->a:Ljava/lang/String;

    const-string v2, "launch"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_ad

    if-eqz v0, :cond_a7

    iget-object p1, p0, Lc1/c;->c:Lc1/b;

    invoke-virtual {p1, v0}, Lc1/b;->b(Landroid/content/Intent;)Z

    move-result p1

    if-nez p1, :cond_a7

    const-string p1, "MethodCallHandlerImpl"

    const-string v1, "Cannot resolve explicit intent, falling back to implicit"

    invoke-static {p1, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    invoke-virtual {v0, v10}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    :cond_a7
    iget-object p1, p0, Lc1/c;->c:Lc1/b;

    invoke-virtual {p1, v0}, Lc1/b;->d(Landroid/content/Intent;)V

    goto :goto_c4

    :cond_ad
    iget-object v1, p1, Lu1/k;->a:Ljava/lang/String;

    const-string v2, "launchChooser"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_c8

    const-string v1, "chooserTitle"

    invoke-virtual {p1, v1}, Lu1/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    iget-object v1, p0, Lc1/c;->c:Lc1/b;

    invoke-virtual {v1, v0, p1}, Lc1/b;->c(Landroid/content/Intent;Ljava/lang/String;)V

    :goto_c4
    invoke-interface {p2, v10}, Lu1/l$d;->a(Ljava/lang/Object;)V

    goto :goto_f3

    :cond_c8
    iget-object v1, p1, Lu1/k;->a:Ljava/lang/String;

    const-string v2, "sendBroadcast"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_d8

    iget-object p1, p0, Lc1/c;->c:Lc1/b;

    invoke-virtual {p1, v0}, Lc1/b;->e(Landroid/content/Intent;)V

    goto :goto_c4

    :cond_d8
    iget-object p1, p1, Lu1/k;->a:Ljava/lang/String;

    const-string v1, "canResolveActivity"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_f0

    iget-object p1, p0, Lc1/c;->c:Lc1/b;

    invoke-virtual {p1, v0}, Lc1/b;->b(Landroid/content/Intent;)Z

    move-result p1

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p1

    invoke-interface {p2, p1}, Lu1/l$d;->a(Ljava/lang/Object;)V

    goto :goto_f3

    :cond_f0
    invoke-interface {p2}, Lu1/l$d;->c()V

    :goto_f3
    return-void
.end method
