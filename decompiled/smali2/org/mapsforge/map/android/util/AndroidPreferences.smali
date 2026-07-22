.class public Lorg/mapsforge/map/android/util/AndroidPreferences;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/mapsforge/map/model/common/PreferencesFacade;


# instance fields
.field private editor:Landroid/content/SharedPreferences$Editor;

.field private final sharedPreferences:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Landroid/content/SharedPreferences;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->sharedPreferences:Landroid/content/SharedPreferences;

    return-void
.end method

.method private createEditor()V
    .registers 2

    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    if-nez v0, :cond_c

    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iput-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    :cond_c
    return-void
.end method


# virtual methods
.method public declared-synchronized clear()V
    .registers 2

    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Lorg/mapsforge/map/android/util/AndroidPreferences;->createEditor()V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getBoolean(Ljava/lang/String;Z)Z
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result p1
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return p1

    :catchall_9
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getByte(Ljava/lang/String;B)B
    .registers 5

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result p1
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_29

    const/16 p2, -0x80

    if-lt p1, p2, :cond_12

    const/16 p2, 0x7f

    if-gt p1, p2, :cond_12

    int-to-byte p1, p1

    monitor-exit p0

    return p1

    :cond_12
    :try_start_12
    new-instance p2, Ljava/lang/IllegalStateException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "byte value out of range: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw p2
    :try_end_29
    .catchall {:try_start_12 .. :try_end_29} :catchall_29

    :catchall_29
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getDouble(Ljava/lang/String;D)D
    .registers 5

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-static {p2, p3}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide p2

    invoke-interface {v0, p1, p2, p3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide p1

    invoke-static {p1, p2}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide p1
    :try_end_f
    .catchall {:try_start_1 .. :try_end_f} :catchall_11

    monitor-exit p0

    return-wide p1

    :catchall_11
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getFloat(Ljava/lang/String;F)F
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getFloat(Ljava/lang/String;F)F

    move-result p1
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return p1

    :catchall_9
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getInt(Ljava/lang/String;I)I
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result p1
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return p1

    :catchall_9
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getLong(Ljava/lang/String;J)J
    .registers 5

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2, p3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide p1
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return-wide p1

    :catchall_9
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .registers 4

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1
    :try_end_7
    .catchall {:try_start_1 .. :try_end_7} :catchall_9

    monitor-exit p0

    return-object p1

    :catchall_9
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized putBoolean(Ljava/lang/String;Z)V
    .registers 4

    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Lorg/mapsforge/map/android/util/AndroidPreferences;->createEditor()V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized putByte(Ljava/lang/String;B)V
    .registers 4

    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Lorg/mapsforge/map/android/util/AndroidPreferences;->createEditor()V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized putDouble(Ljava/lang/String;D)V
    .registers 5

    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Lorg/mapsforge/map/android/util/AndroidPreferences;->createEditor()V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-static {p2, p3}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide p2

    invoke-interface {v0, p1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    :try_end_d
    .catchall {:try_start_1 .. :try_end_d} :catchall_f

    monitor-exit p0

    return-void

    :catchall_f
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized putFloat(Ljava/lang/String;F)V
    .registers 4

    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Lorg/mapsforge/map/android/util/AndroidPreferences;->createEditor()V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putFloat(Ljava/lang/String;F)Landroid/content/SharedPreferences$Editor;
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized putInt(Ljava/lang/String;I)V
    .registers 4

    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Lorg/mapsforge/map/android/util/AndroidPreferences;->createEditor()V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized putLong(Ljava/lang/String;J)V
    .registers 5

    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Lorg/mapsforge/map/android/util/AndroidPreferences;->createEditor()V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized putString(Ljava/lang/String;Ljava/lang/String;)V
    .registers 4

    monitor-enter p0

    :try_start_1
    invoke-direct {p0}, Lorg/mapsforge/map/android/util/AndroidPreferences;->createEditor()V

    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    :try_end_9
    .catchall {:try_start_1 .. :try_end_9} :catchall_b

    monitor-exit p0

    return-void

    :catchall_b
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized save()V
    .registers 2

    monitor-enter p0

    :try_start_1
    iget-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;

    if-eqz v0, :cond_b

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    const/4 v0, 0x0

    iput-object v0, p0, Lorg/mapsforge/map/android/util/AndroidPreferences;->editor:Landroid/content/SharedPreferences$Editor;
    :try_end_b
    .catchall {:try_start_1 .. :try_end_b} :catchall_d

    :cond_b
    monitor-exit p0

    return-void

    :catchall_d
    move-exception v0

    monitor-exit p0

    throw v0
.end method
