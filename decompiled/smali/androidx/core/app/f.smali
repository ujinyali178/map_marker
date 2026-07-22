.class public Landroidx/core/app/f;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroidx/core/app/f;->a:Ljava/lang/Object;

    return-void
.end method

.method public static a(Landroid/content/Context;)Ljava/lang/String;
    .registers 9

    sget-object v0, Landroidx/core/app/f;->a:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    const-string v1, ""
    :try_end_5
    .catchall {:try_start_3 .. :try_end_5} :catchall_69

    :try_start_5
    const-string v2, "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"

    invoke-virtual {p0, v2}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v2
    :try_end_b
    .catch Ljava/io/FileNotFoundException; {:try_start_5 .. :try_end_b} :catch_67
    .catchall {:try_start_5 .. :try_end_b} :catchall_69

    :try_start_b
    invoke-static {}, Landroid/util/Xml;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v3

    const-string v4, "UTF-8"

    invoke-interface {v3, v2, v4}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v4

    :cond_18
    :goto_18
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v5

    const/4 v6, 0x1

    if-eq v5, v6, :cond_41

    const/4 v6, 0x3

    if-ne v5, v6, :cond_28

    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v7

    if-le v7, v4, :cond_41

    :cond_28
    if-eq v5, v6, :cond_18

    const/4 v6, 0x4

    if-ne v5, v6, :cond_2e

    goto :goto_18

    :cond_2e
    invoke-interface {v3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "locales"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_18

    const/4 v4, 0x0

    const-string v5, "application_locales"

    invoke-interface {v3, v4, v5}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1
    :try_end_41
    .catch Lorg/xmlpull/v1/XmlPullParserException; {:try_start_b .. :try_end_41} :catch_49
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_41} :catch_49
    .catchall {:try_start_b .. :try_end_41} :catchall_47

    :cond_41
    if-eqz v2, :cond_53

    :goto_43
    :try_start_43
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V
    :try_end_46
    .catch Ljava/io/IOException; {:try_start_43 .. :try_end_46} :catch_53
    .catchall {:try_start_43 .. :try_end_46} :catchall_69

    goto :goto_53

    :catchall_47
    move-exception p0

    goto :goto_61

    :catch_49
    :try_start_49
    const-string v3, "AppLocalesStorageHelper"

    const-string v4, "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_50
    .catchall {:try_start_49 .. :try_end_50} :catchall_47

    if-eqz v2, :cond_53

    goto :goto_43

    :catch_53
    :cond_53
    :goto_53
    :try_start_53
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_5a

    goto :goto_5f

    :cond_5a
    const-string v2, "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"

    invoke-virtual {p0, v2}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    :goto_5f
    monitor-exit v0
    :try_end_60
    .catchall {:try_start_53 .. :try_end_60} :catchall_69

    return-object v1

    :goto_61
    if-eqz v2, :cond_66

    :try_start_63
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V
    :try_end_66
    .catch Ljava/io/IOException; {:try_start_63 .. :try_end_66} :catch_66
    .catchall {:try_start_63 .. :try_end_66} :catchall_69

    :catch_66
    :cond_66
    :try_start_66
    throw p0

    :catch_67
    monitor-exit v0

    return-object v1

    :catchall_69
    move-exception p0

    monitor-exit v0
    :try_end_6b
    .catchall {:try_start_66 .. :try_end_6b} :catchall_69

    throw p0
.end method
