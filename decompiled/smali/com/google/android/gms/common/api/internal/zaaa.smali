.class final Lcom/google/android/gms/common/api/internal/zaaa;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/common/api/internal/zaca;


# instance fields
.field private final zaa:Landroid/content/Context;

.field private final zab:Lcom/google/android/gms/common/api/internal/zabe;

.field private final zac:Landroid/os/Looper;

.field private final zad:Lcom/google/android/gms/common/api/internal/zabi;

.field private final zae:Lcom/google/android/gms/common/api/internal/zabi;

.field private final zaf:Ljava/util/Map;

.field private final zag:Ljava/util/Set;

.field private final zah:Lcom/google/android/gms/common/api/Api$Client;

.field private zai:Landroid/os/Bundle;

.field private zaj:Lcom/google/android/gms/common/ConnectionResult;

.field private zak:Lcom/google/android/gms/common/ConnectionResult;

.field private zal:Z

.field private final zam:Ljava/util/concurrent/locks/Lock;

.field private zan:I


# direct methods
.method private constructor <init>(Landroid/content/Context;Lcom/google/android/gms/common/api/internal/zabe;Ljava/util/concurrent/locks/Lock;Landroid/os/Looper;Lcom/google/android/gms/common/GoogleApiAvailabilityLight;Ljava/util/Map;Ljava/util/Map;Lcom/google/android/gms/common/internal/ClientSettings;Lcom/google/android/gms/common/api/Api$AbstractClientBuilder;Lcom/google/android/gms/common/api/Api$Client;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/Map;Ljava/util/Map;)V
    .registers 33

    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    new-instance v1, Ljava/util/WeakHashMap;

    invoke-direct {v1}, Ljava/util/WeakHashMap;-><init>()V

    invoke-static {v1}, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zag:Ljava/util/Set;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zaj:Lcom/google/android/gms/common/ConnectionResult;

    iput-object v1, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    const/4 v2, 0x0

    iput-boolean v2, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zal:Z

    iput v2, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I

    move-object/from16 v2, p1

    iput-object v2, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zaa:Landroid/content/Context;

    move-object/from16 v15, p2

    iput-object v15, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zab:Lcom/google/android/gms/common/api/internal/zabe;

    move-object/from16 v14, p3

    iput-object v14, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    move-object/from16 v13, p4

    iput-object v13, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zac:Landroid/os/Looper;

    move-object/from16 v3, p10

    iput-object v3, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zah:Lcom/google/android/gms/common/api/Api$Client;

    new-instance v12, Lcom/google/android/gms/common/api/internal/zabi;

    new-instance v11, Lcom/google/android/gms/common/api/internal/zax;

    invoke-direct {v11, v0, v1}, Lcom/google/android/gms/common/api/internal/zax;-><init>(Lcom/google/android/gms/common/api/internal/zaaa;Lcom/google/android/gms/common/api/internal/zaw;)V

    const/4 v10, 0x0

    const/16 v16, 0x0

    move-object v3, v12

    move-object/from16 v4, p1

    move-object/from16 v5, p2

    move-object/from16 v6, p3

    move-object/from16 v7, p4

    move-object/from16 v8, p5

    move-object/from16 v9, p7

    move-object/from16 v17, v11

    move-object/from16 v11, p14

    move-object v1, v12

    move-object/from16 v12, v16

    move-object/from16 v13, p12

    move-object/from16 v14, v17

    invoke-direct/range {v3 .. v14}, Lcom/google/android/gms/common/api/internal/zabi;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/api/internal/zabe;Ljava/util/concurrent/locks/Lock;Landroid/os/Looper;Lcom/google/android/gms/common/GoogleApiAvailabilityLight;Ljava/util/Map;Lcom/google/android/gms/common/internal/ClientSettings;Ljava/util/Map;Lcom/google/android/gms/common/api/Api$AbstractClientBuilder;Ljava/util/ArrayList;Lcom/google/android/gms/common/api/internal/zabz;)V

    iput-object v1, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    new-instance v1, Lcom/google/android/gms/common/api/internal/zabi;

    new-instance v14, Lcom/google/android/gms/common/api/internal/zaz;

    const/4 v3, 0x0

    invoke-direct {v14, v0, v3}, Lcom/google/android/gms/common/api/internal/zaz;-><init>(Lcom/google/android/gms/common/api/internal/zaaa;Lcom/google/android/gms/common/api/internal/zay;)V

    move-object v3, v1

    move-object/from16 v9, p6

    move-object/from16 v10, p8

    move-object/from16 v11, p13

    move-object/from16 v12, p9

    move-object/from16 v13, p11

    invoke-direct/range {v3 .. v14}, Lcom/google/android/gms/common/api/internal/zabi;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/api/internal/zabe;Ljava/util/concurrent/locks/Lock;Landroid/os/Looper;Lcom/google/android/gms/common/GoogleApiAvailabilityLight;Ljava/util/Map;Lcom/google/android/gms/common/internal/ClientSettings;Ljava/util/Map;Lcom/google/android/gms/common/api/Api$AbstractClientBuilder;Ljava/util/ArrayList;Lcom/google/android/gms/common/api/internal/zabz;)V

    iput-object v1, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    new-instance v1, Landroidx/collection/a;

    invoke-direct {v1}, Landroidx/collection/a;-><init>()V

    invoke-interface/range {p7 .. p7}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_7a
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_8c

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/common/api/Api$AnyClientKey;

    iget-object v4, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v1, v3, v4}, Landroidx/collection/g;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_7a

    :cond_8c
    invoke-interface/range {p6 .. p6}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_94
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_a6

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/common/api/Api$AnyClientKey;

    iget-object v4, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v1, v3, v4}, Landroidx/collection/g;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_94

    :cond_a6
    invoke-static {v1}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    iput-object v1, v0, Lcom/google/android/gms/common/api/internal/zaaa;->zaf:Ljava/util/Map;

    return-void
.end method

.method private final zaA(Lcom/google/android/gms/common/ConnectionResult;)V
    .registers 4

    iget v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1a

    const/4 v1, 0x2

    if-eq v0, v1, :cond_15

    new-instance p1, Ljava/lang/Exception;

    invoke-direct {p1}, Ljava/lang/Exception;-><init>()V

    const-string v0, "CompositeGAC"

    const-string v1, "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor"

    invoke-static {v0, v1, p1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1d

    :cond_15
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zab:Lcom/google/android/gms/common/api/internal/zabe;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/common/api/internal/zabe;->zaa(Lcom/google/android/gms/common/ConnectionResult;)V

    :cond_1a
    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaB()V

    :goto_1d
    const/4 p1, 0x0

    iput p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I

    return-void
.end method

.method private final zaB()V
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zag:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_6
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_16

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/common/api/internal/SignInConnectionListener;

    invoke-interface {v1}, Lcom/google/android/gms/common/api/internal/SignInConnectionListener;->onComplete()V

    goto :goto_6

    :cond_16
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zag:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    return-void
.end method

.method private final zaC()Z
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    if-eqz v0, :cond_d

    invoke-virtual {v0}, Lcom/google/android/gms/common/ConnectionResult;->getErrorCode()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_d

    const/4 v0, 0x1

    return v0

    :cond_d
    const/4 v0, 0x0

    return v0
.end method

.method private final zaD(Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;)Z
    .registers 3

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;->getClientKey()Lcom/google/android/gms/common/api/Api$AnyClientKey;

    move-result-object p1

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaf:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lcom/google/android/gms/common/api/internal/zabi;

    const-string v0, "GoogleApiClient is not configured to use the API required for this call."

    invoke-static {p1, v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    return p1
.end method

.method private static zaE(Lcom/google/android/gms/common/ConnectionResult;)Z
    .registers 1

    if-eqz p0, :cond_a

    invoke-virtual {p0}, Lcom/google/android/gms/common/ConnectionResult;->isSuccess()Z

    move-result p0

    if-eqz p0, :cond_a

    const/4 p0, 0x1

    return p0

    :cond_a
    const/4 p0, 0x0

    return p0
.end method

.method static bridge synthetic zaa(Lcom/google/android/gms/common/api/internal/zaaa;)Lcom/google/android/gms/common/ConnectionResult;
    .registers 1

    iget-object p0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    return-object p0
.end method

.method public static zag(Landroid/content/Context;Lcom/google/android/gms/common/api/internal/zabe;Ljava/util/concurrent/locks/Lock;Landroid/os/Looper;Lcom/google/android/gms/common/GoogleApiAvailabilityLight;Ljava/util/Map;Lcom/google/android/gms/common/internal/ClientSettings;Ljava/util/Map;Lcom/google/android/gms/common/api/Api$AbstractClientBuilder;Ljava/util/ArrayList;)Lcom/google/android/gms/common/api/internal/zaaa;
    .registers 26

    move-object/from16 v0, p7

    new-instance v6, Landroidx/collection/a;

    invoke-direct {v6}, Landroidx/collection/a;-><init>()V

    new-instance v7, Landroidx/collection/a;

    invoke-direct {v7}, Landroidx/collection/a;-><init>()V

    invoke-interface/range {p5 .. p5}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    const/4 v2, 0x0

    move-object v10, v2

    :goto_16
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    const/4 v3, 0x1

    if-eqz v2, :cond_44

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/common/api/Api$Client;

    invoke-interface {v4}, Lcom/google/android/gms/common/api/Api$Client;->providesSignIn()Z

    move-result v5

    if-ne v3, v5, :cond_30

    move-object v10, v4

    :cond_30
    invoke-interface {v4}, Lcom/google/android/gms/common/api/Api$Client;->requiresSignIn()Z

    move-result v3

    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/common/api/Api$AnyClientKey;

    if-eqz v3, :cond_40

    invoke-interface {v6, v2, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_16

    :cond_40
    invoke-interface {v7, v2, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_16

    :cond_44
    invoke-interface {v6}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    xor-int/2addr v1, v3

    const-string v2, "CompositeGoogleApiClient should not be used without any APIs that require sign-in."

    invoke-static {v1, v2}, Lcom/google/android/gms/common/internal/Preconditions;->checkState(ZLjava/lang/Object;)V

    new-instance v13, Landroidx/collection/a;

    invoke-direct {v13}, Landroidx/collection/a;-><init>()V

    new-instance v14, Landroidx/collection/a;

    invoke-direct {v14}, Landroidx/collection/a;-><init>()V

    invoke-interface/range {p7 .. p7}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_60
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_98

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/common/api/Api;

    invoke-virtual {v2}, Lcom/google/android/gms/common/api/Api;->zab()Lcom/google/android/gms/common/api/Api$AnyClientKey;

    move-result-object v3

    invoke-interface {v6, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_80

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-interface {v13, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_60

    :cond_80
    invoke-interface {v7, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_90

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-interface {v14, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_60

    :cond_90
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Each API in the isOptionalMap must have a corresponding client in the clients map."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_98
    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    new-instance v12, Ljava/util/ArrayList;

    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    invoke-interface/range {p9 .. p9}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x0

    :goto_a7
    if-ge v1, v0, :cond_d3

    move-object/from16 v2, p9

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/common/api/internal/zat;

    iget-object v4, v3, Lcom/google/android/gms/common/api/internal/zat;->zaa:Lcom/google/android/gms/common/api/Api;

    invoke-interface {v13, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_bd

    invoke-virtual {v11, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_c8

    :cond_bd
    iget-object v4, v3, Lcom/google/android/gms/common/api/internal/zat;->zaa:Lcom/google/android/gms/common/api/Api;

    invoke-interface {v14, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_cb

    invoke-virtual {v12, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :goto_c8
    add-int/lit8 v1, v1, 0x1

    goto :goto_a7

    :cond_cb
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Each ClientCallbacks must have a corresponding API in the isOptionalMap"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_d3
    new-instance v15, Lcom/google/android/gms/common/api/internal/zaaa;

    move-object v0, v15

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-object/from16 v8, p6

    move-object/from16 v9, p8

    invoke-direct/range {v0 .. v14}, Lcom/google/android/gms/common/api/internal/zaaa;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/api/internal/zabe;Ljava/util/concurrent/locks/Lock;Landroid/os/Looper;Lcom/google/android/gms/common/GoogleApiAvailabilityLight;Ljava/util/Map;Ljava/util/Map;Lcom/google/android/gms/common/internal/ClientSettings;Lcom/google/android/gms/common/api/Api$AbstractClientBuilder;Lcom/google/android/gms/common/api/Api$Client;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/Map;Ljava/util/Map;)V

    return-object v15
.end method

.method static bridge synthetic zah(Lcom/google/android/gms/common/api/internal/zaaa;)Lcom/google/android/gms/common/api/internal/zabi;
    .registers 1

    iget-object p0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    return-object p0
.end method

.method static bridge synthetic zai(Lcom/google/android/gms/common/api/internal/zaaa;)Lcom/google/android/gms/common/api/internal/zabi;
    .registers 1

    iget-object p0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    return-object p0
.end method

.method static bridge synthetic zaj(Lcom/google/android/gms/common/api/internal/zaaa;)Ljava/util/concurrent/locks/Lock;
    .registers 1

    iget-object p0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    return-object p0
.end method

.method static bridge synthetic zak(Lcom/google/android/gms/common/api/internal/zaaa;Lcom/google/android/gms/common/ConnectionResult;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaj:Lcom/google/android/gms/common/ConnectionResult;

    return-void
.end method

.method static bridge synthetic zal(Lcom/google/android/gms/common/api/internal/zaaa;Lcom/google/android/gms/common/ConnectionResult;)V
    .registers 2

    iput-object p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    return-void
.end method

.method static bridge synthetic zam(Lcom/google/android/gms/common/api/internal/zaaa;Z)V
    .registers 2

    iput-boolean p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zal:Z

    return-void
.end method

.method static bridge synthetic zan(Lcom/google/android/gms/common/api/internal/zaaa;IZ)V
    .registers 4

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zab:Lcom/google/android/gms/common/api/internal/zabe;

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gms/common/api/internal/zabe;->zac(IZ)V

    const/4 p1, 0x0

    iput-object p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    iput-object p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaj:Lcom/google/android/gms/common/ConnectionResult;

    return-void
.end method

.method static bridge synthetic zao(Lcom/google/android/gms/common/api/internal/zaaa;Landroid/os/Bundle;)V
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zai:Landroid/os/Bundle;

    if-nez v0, :cond_7

    iput-object p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zai:Landroid/os/Bundle;

    return-void

    :cond_7
    if-eqz p1, :cond_c

    invoke-virtual {v0, p1}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    :cond_c
    return-void
.end method

.method static bridge synthetic zap(Lcom/google/android/gms/common/api/internal/zaaa;)V
    .registers 5

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaj:Lcom/google/android/gms/common/ConnectionResult;

    invoke-static {v0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaE(Lcom/google/android/gms/common/ConnectionResult;)Z

    move-result v0

    if-eqz v0, :cond_55

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    invoke-static {v0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaE(Lcom/google/android/gms/common/ConnectionResult;)Z

    move-result v0

    const/4 v1, 0x1

    if-nez v0, :cond_2d

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaC()Z

    move-result v0

    if-eqz v0, :cond_18

    goto :goto_2d

    :cond_18
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    if-eqz v0, :cond_89

    iget v2, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I

    if-ne v2, v1, :cond_24

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaB()V

    return-void

    :cond_24
    invoke-direct {p0, v0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaA(Lcom/google/android/gms/common/ConnectionResult;)V

    iget-object p0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {p0}, Lcom/google/android/gms/common/api/internal/zabi;->zar()V

    return-void

    :cond_2d
    :goto_2d
    iget v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I

    if-eq v0, v1, :cond_4e

    const/4 v1, 0x2

    if-eq v0, v1, :cond_41

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    const-string v1, "CompositeGAC"

    const-string v2, "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_51

    :cond_41
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zab:Lcom/google/android/gms/common/api/internal/zabe;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/common/api/internal/zabe;

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zai:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Lcom/google/android/gms/common/api/internal/zabe;->zab(Landroid/os/Bundle;)V

    :cond_4e
    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaB()V

    :goto_51
    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I

    return-void

    :cond_55
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaj:Lcom/google/android/gms/common/ConnectionResult;

    if-eqz v0, :cond_73

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    invoke-static {v0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaE(Lcom/google/android/gms/common/ConnectionResult;)Z

    move-result v0

    if-nez v0, :cond_62

    goto :goto_73

    :cond_62
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/zabi;->zar()V

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaj:Lcom/google/android/gms/common/ConnectionResult;

    invoke-static {v0}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/common/ConnectionResult;

    invoke-direct {p0, v0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaA(Lcom/google/android/gms/common/ConnectionResult;)V

    return-void

    :cond_73
    :goto_73
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaj:Lcom/google/android/gms/common/ConnectionResult;

    if-eqz v0, :cond_89

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    if-eqz v1, :cond_89

    iget-object v2, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    iget v2, v2, Lcom/google/android/gms/common/api/internal/zabi;->zaf:I

    iget-object v3, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    iget v3, v3, Lcom/google/android/gms/common/api/internal/zabi;->zaf:I

    if-ge v2, v3, :cond_86

    move-object v0, v1

    :cond_86
    invoke-direct {p0, v0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaA(Lcom/google/android/gms/common/ConnectionResult;)V

    :cond_89
    return-void
.end method

.method static bridge synthetic zav(Lcom/google/android/gms/common/api/internal/zaaa;)Z
    .registers 1

    iget-boolean p0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zal:Z

    return p0
.end method

.method private final zaz()Landroid/app/PendingIntent;
    .registers 6

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zah:Lcom/google/android/gms/common/api/Api$Client;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    return-object v0

    :cond_6
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaa:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zab:Lcom/google/android/gms/common/api/internal/zabe;

    invoke-static {v1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v1

    iget-object v2, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zah:Lcom/google/android/gms/common/api/Api$Client;

    invoke-interface {v2}, Lcom/google/android/gms/common/api/Api$Client;->getSignInIntent()Landroid/content/Intent;

    move-result-object v2

    sget v3, Lcom/google/android/gms/internal/base/zap;->zaa:I

    const/high16 v4, 0x8000000

    or-int/2addr v3, v4

    invoke-static {v0, v1, v2, v3}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public final zab()Lcom/google/android/gms/common/ConnectionResult;
    .registers 2

    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public final zac(JLjava/util/concurrent/TimeUnit;)Lcom/google/android/gms/common/ConnectionResult;
    .registers 4

    new-instance p1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {p1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw p1
.end method

.method public final zad(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/ConnectionResult;
    .registers 4

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaf:Ljava/util/Map;

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Api;->zab()Lcom/google/android/gms/common/api/Api$AnyClientKey;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2a

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaC()Z

    move-result v0

    if-eqz v0, :cond_23

    new-instance p1, Lcom/google/android/gms/common/ConnectionResult;

    const/4 v0, 0x4

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaz()Landroid/app/PendingIntent;

    move-result-object v1

    invoke-direct {p1, v0, v1}, Lcom/google/android/gms/common/ConnectionResult;-><init>(ILandroid/app/PendingIntent;)V

    return-object p1

    :cond_23
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/common/api/internal/zabi;->zad(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/ConnectionResult;

    move-result-object p1

    return-object p1

    :cond_2a
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/common/api/internal/zabi;->zad(Lcom/google/android/gms/common/api/Api;)Lcom/google/android/gms/common/ConnectionResult;

    move-result-object p1

    return-object p1
.end method

.method public final zae(Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;)Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;
    .registers 6

    invoke-direct {p0, p1}, Lcom/google/android/gms/common/api/internal/zaaa;->zaD(Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;)Z

    move-result v0

    if-eqz v0, :cond_21

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaC()Z

    move-result v0

    if-eqz v0, :cond_1b

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/4 v1, 0x4

    const/4 v2, 0x0

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaz()Landroid/app/PendingIntent;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gms/common/api/Status;-><init>(ILjava/lang/String;Landroid/app/PendingIntent;)V

    invoke-virtual {p1, v0}, Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;->setFailedResult(Lcom/google/android/gms/common/api/Status;)V

    return-object p1

    :cond_1b
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/common/api/internal/zabi;->zae(Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;)Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;

    return-object p1

    :cond_21
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/common/api/internal/zabi;->zae(Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;)Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;

    return-object p1
.end method

.method public final zaf(Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;)Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;
    .registers 6

    invoke-direct {p0, p1}, Lcom/google/android/gms/common/api/internal/zaaa;->zaD(Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;)Z

    move-result v0

    if-eqz v0, :cond_22

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaC()Z

    move-result v0

    if-eqz v0, :cond_1b

    new-instance v0, Lcom/google/android/gms/common/api/Status;

    const/4 v1, 0x4

    const/4 v2, 0x0

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaz()Landroid/app/PendingIntent;

    move-result-object v3

    invoke-direct {v0, v1, v2, v3}, Lcom/google/android/gms/common/api/Status;-><init>(ILjava/lang/String;Landroid/app/PendingIntent;)V

    invoke-virtual {p1, v0}, Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;->setFailedResult(Lcom/google/android/gms/common/api/Status;)V

    return-object p1

    :cond_1b
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/common/api/internal/zabi;->zaf(Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;)Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;

    move-result-object p1

    return-object p1

    :cond_22
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0, p1}, Lcom/google/android/gms/common/api/internal/zabi;->zaf(Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;)Lcom/google/android/gms/common/api/internal/BaseImplementation$ApiMethodImpl;

    move-result-object p1

    return-object p1
.end method

.method public final zaq()V
    .registers 2

    const/4 v0, 0x2

    iput v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zal:Z

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    iput-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaj:Lcom/google/android/gms/common/ConnectionResult;

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/zabi;->zaq()V

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/zabi;->zaq()V

    return-void
.end method

.method public final zar()V
    .registers 2

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    iput-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zaj:Lcom/google/android/gms/common/ConnectionResult;

    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/zabi;->zar()V

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/zabi;->zar()V

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaB()V

    return-void
.end method

.method public final zas(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .registers 9

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->append(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;

    move-result-object v0

    const-string v1, "authClient"

    invoke-virtual {v0, v1}, Ljava/io/PrintWriter;->append(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "  "

    invoke-virtual {v2, v3}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, p2, p3, p4}, Lcom/google/android/gms/common/api/internal/zabi;->zas(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->append(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;

    move-result-object v0

    const-string v2, "anonClient"

    invoke-virtual {v0, v2}, Ljava/io/PrintWriter;->append(Ljava/lang/CharSequence;)Ljava/io/PrintWriter;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p1, v3}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/google/android/gms/common/api/internal/zabi;->zas(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    return-void
.end method

.method public final zat()V
    .registers 2

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/zabi;->zat()V

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/zabi;->zat()V

    return-void
.end method

.method public final zau()V
    .registers 4

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_5
    invoke-virtual {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zax()Z

    move-result v0

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v1}, Lcom/google/android/gms/common/api/internal/zabi;->zar()V

    new-instance v1, Lcom/google/android/gms/common/ConnectionResult;

    const/4 v2, 0x4

    invoke-direct {v1, v2}, Lcom/google/android/gms/common/ConnectionResult;-><init>(I)V

    iput-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    if-eqz v0, :cond_28

    new-instance v0, Lcom/google/android/gms/internal/base/zau;

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zac:Landroid/os/Looper;

    invoke-direct {v0, v1}, Lcom/google/android/gms/internal/base/zau;-><init>(Landroid/os/Looper;)V

    new-instance v1, Lcom/google/android/gms/common/api/internal/zav;

    invoke-direct {v1, p0}, Lcom/google/android/gms/common/api/internal/zav;-><init>(Lcom/google/android/gms/common/api/internal/zaaa;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_2b

    :cond_28
    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaB()V
    :try_end_2b
    .catchall {:try_start_5 .. :try_end_2b} :catchall_31

    :goto_2b
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void

    :catchall_31
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method public final zaw()Z
    .registers 4

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_5
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zad:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/zabi;->zaw()Z

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_22

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/zabi;->zaw()Z

    move-result v0

    if-nez v0, :cond_21

    invoke-direct {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaC()Z

    move-result v0

    if-nez v0, :cond_21

    iget v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I
    :try_end_1f
    .catchall {:try_start_5 .. :try_end_1f} :catchall_28

    if-ne v0, v2, :cond_22

    :cond_21
    const/4 v1, 0x1

    :cond_22
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return v1

    :catchall_28
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method public final zax()Z
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_5
    iget v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I
    :try_end_7
    .catchall {:try_start_5 .. :try_end_7} :catchall_13

    const/4 v1, 0x2

    if-ne v0, v1, :cond_c

    const/4 v0, 0x1

    goto :goto_d

    :cond_c
    const/4 v0, 0x0

    :goto_d
    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return v0

    :catchall_13
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method public final zay(Lcom/google/android/gms/common/api/internal/SignInConnectionListener;)Z
    .registers 3

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_5
    invoke-virtual {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zax()Z

    move-result v0

    if-nez v0, :cond_11

    invoke-virtual {p0}, Lcom/google/android/gms/common/api/internal/zaaa;->zaw()Z

    move-result v0

    if-eqz v0, :cond_33

    :cond_11
    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {v0}, Lcom/google/android/gms/common/api/internal/zabi;->zaw()Z

    move-result v0

    if-nez v0, :cond_33

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zag:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    iget p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I

    const/4 v0, 0x1

    if-nez p1, :cond_25

    iput v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zan:I

    :cond_25
    const/4 p1, 0x0

    iput-object p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zak:Lcom/google/android/gms/common/ConnectionResult;

    iget-object p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zae:Lcom/google/android/gms/common/api/internal/zabi;

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/internal/zabi;->zaq()V
    :try_end_2d
    .catchall {:try_start_5 .. :try_end_2d} :catchall_3a

    iget-object p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {p1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return v0

    :cond_33
    iget-object p1, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {p1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    const/4 p1, 0x0

    return p1

    :catchall_3a
    move-exception p1

    iget-object v0, p0, Lcom/google/android/gms/common/api/internal/zaaa;->zam:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw p1
.end method
