.class public Lb0/w;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method private static a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .registers 5

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x0

    const/16 v2, 0x1f

    if-lt v0, v2, :cond_e

    invoke-static {p0, v1, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_e

    return-object p1

    :cond_e
    const/16 p1, 0x1d

    const-string v2, "android.permission.ACCESS_FINE_LOCATION"

    if-ge v0, p1, :cond_25

    invoke-static {p0, v1, v2}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_1b

    return-object v2

    :cond_1b
    const-string p1, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-static {p0, v1, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_24

    return-object p1

    :cond_24
    return-object v1

    :cond_25
    invoke-static {p0, v1, v2}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_2c

    return-object v2

    :cond_2c
    return-object v1
.end method

.method static b(Landroid/app/Activity;Ljava/lang/String;)I
    .registers 6

    const/4 v0, 0x0

    if-nez p0, :cond_4

    return v0

    :cond_4
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x17

    if-ge v1, v2, :cond_b

    return v0

    :cond_b
    invoke-static {p0, p1}, Lb0/w;->l(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    invoke-static {p0, p1}, Lb0/w;->f(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result v2

    const/4 v3, 0x1

    xor-int/2addr v2, v3

    if-eqz v1, :cond_1c

    if-nez v2, :cond_1a

    goto :goto_1d

    :cond_1a
    const/4 v3, 0x0

    goto :goto_1d

    :cond_1c
    move v3, v2

    :goto_1d
    if-nez v1, :cond_24

    if-eqz v3, :cond_24

    invoke-static {p0, p1}, Lb0/w;->h(Landroid/content/Context;Ljava/lang/String;)V

    :cond_24
    if-eqz v1, :cond_2a

    if-eqz v3, :cond_2a

    const/4 p0, 0x4

    return p0

    :cond_2a
    return v0
.end method

.method static c(Landroid/content/Context;I)Ljava/util/List;
    .registers 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I)",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    const/16 v1, 0x1f

    const/16 v2, 0x17

    const/4 v3, 0x0

    const-string v4, "android.permission.WRITE_CALENDAR"

    const/16 v5, 0x1d

    const/16 v6, 0x21

    packed-switch p1, :pswitch_data_26e

    :pswitch_13
    goto/16 :goto_26c

    :pswitch_15
    invoke-static {p0, v0, v4}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_26c

    :pswitch_20
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v6, :cond_26c

    const-string p1, "android.permission.BODY_SENSORS_BACKGROUND"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.BODY_SENSORS_BACKGROUND"

    goto/16 :goto_103

    :pswitch_30
    const-string p1, "android.permission.SCHEDULE_EXACT_ALARM"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    goto/16 :goto_256

    :pswitch_3a
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v6, :cond_26c

    const-string p1, "android.permission.READ_MEDIA_AUDIO"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.READ_MEDIA_AUDIO"

    goto/16 :goto_103

    :pswitch_4a
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v6, :cond_26c

    const-string p1, "android.permission.READ_MEDIA_VIDEO"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.READ_MEDIA_VIDEO"

    goto/16 :goto_103

    :pswitch_5a
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v6, :cond_26c

    const-string p1, "android.permission.NEARBY_WIFI_DEVICES"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.NEARBY_WIFI_DEVICES"

    goto/16 :goto_103

    :pswitch_6a
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v1, :cond_26c

    const-string p1, "android.permission.BLUETOOTH_CONNECT"

    invoke-static {p0, p1}, Lb0/w;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    if-eqz p0, :cond_26c

    :goto_76
    goto/16 :goto_103

    :pswitch_78
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v1, :cond_26c

    const-string p1, "android.permission.BLUETOOTH_ADVERTISE"

    invoke-static {p0, p1}, Lb0/w;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    if-eqz p0, :cond_26c

    goto :goto_76

    :pswitch_85
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v1, :cond_26c

    const-string p1, "android.permission.BLUETOOTH_SCAN"

    invoke-static {p0, p1}, Lb0/w;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    if-eqz p0, :cond_26c

    goto :goto_76

    :pswitch_92
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v2, :cond_26c

    const-string p1, "android.permission.ACCESS_NOTIFICATION_POLICY"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.ACCESS_NOTIFICATION_POLICY"

    goto :goto_103

    :pswitch_a1
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v2, :cond_26c

    const-string p1, "android.permission.REQUEST_INSTALL_PACKAGES"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.REQUEST_INSTALL_PACKAGES"

    goto :goto_103

    :pswitch_b0
    const-string p1, "android.permission.SYSTEM_ALERT_WINDOW"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    goto/16 :goto_256

    :pswitch_ba
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1e

    if-lt p1, v1, :cond_26c

    const-string p1, "android.permission.MANAGE_EXTERNAL_STORAGE"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.MANAGE_EXTERNAL_STORAGE"

    goto :goto_103

    :pswitch_cb
    const-string p1, "android.permission.BLUETOOTH"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    goto/16 :goto_256

    :pswitch_d5
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge p1, v5, :cond_da

    return-object v3

    :cond_da
    const-string p1, "android.permission.ACTIVITY_RECOGNITION"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.ACTIVITY_RECOGNITION"

    goto :goto_103

    :pswitch_e5
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-ge p1, v5, :cond_ea

    return-object v3

    :cond_ea
    const-string p1, "android.permission.ACCESS_MEDIA_LOCATION"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.ACCESS_MEDIA_LOCATION"

    goto :goto_103

    :pswitch_f5
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v6, :cond_26c

    const-string p1, "android.permission.POST_NOTIFICATIONS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.POST_NOTIFICATIONS"

    :goto_103
    invoke-virtual {v0, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_26c

    :pswitch_108
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v2, :cond_26c

    const-string p1, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    goto/16 :goto_256

    :pswitch_116
    const-string p1, "android.permission.READ_EXTERNAL_STORAGE"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_121

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_121
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v5, :cond_12d

    if-ne p1, v5, :cond_26c

    invoke-static {}, Lb0/v;->a()Z

    move-result p1

    if-eqz p1, :cond_26c

    :cond_12d
    const-string p1, "android.permission.WRITE_EXTERNAL_STORAGE"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.WRITE_EXTERNAL_STORAGE"

    goto :goto_103

    :pswitch_138
    const-string p1, "android.permission.SEND_SMS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_143

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_143
    const-string p1, "android.permission.RECEIVE_SMS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_14e

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_14e
    const-string p1, "android.permission.READ_SMS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_15b

    const-string p1, "android.permission.READ_SMS"

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_15b
    const-string p1, "android.permission.RECEIVE_WAP_PUSH"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_168

    const-string p1, "android.permission.RECEIVE_WAP_PUSH"

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_168
    const-string p1, "android.permission.RECEIVE_MMS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.RECEIVE_MMS"

    goto :goto_103

    :pswitch_173
    const-string p1, "android.permission.BODY_SENSORS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    goto/16 :goto_256

    :pswitch_17d
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v6, :cond_26c

    const-string p1, "android.permission.READ_MEDIA_IMAGES"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    goto/16 :goto_256

    :pswitch_18b
    const-string p1, "android.permission.READ_PHONE_STATE"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_196

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_196
    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-le p1, v5, :cond_1a7

    const-string v1, "android.permission.READ_PHONE_NUMBERS"

    invoke-static {p0, v0, v1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1a7

    const-string v1, "android.permission.READ_PHONE_NUMBERS"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_1a7
    const-string v1, "android.permission.CALL_PHONE"

    invoke-static {p0, v0, v1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1b4

    const-string v1, "android.permission.CALL_PHONE"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_1b4
    const-string v1, "android.permission.READ_CALL_LOG"

    invoke-static {p0, v0, v1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1c1

    const-string v1, "android.permission.READ_CALL_LOG"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_1c1
    const-string v1, "android.permission.WRITE_CALL_LOG"

    invoke-static {p0, v0, v1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1ce

    const-string v1, "android.permission.WRITE_CALL_LOG"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_1ce
    const-string v1, "com.android.voicemail.permission.ADD_VOICEMAIL"

    invoke-static {p0, v0, v1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1db

    const-string v1, "com.android.voicemail.permission.ADD_VOICEMAIL"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_1db
    const-string v1, "android.permission.USE_SIP"

    invoke-static {p0, v0, v1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1e8

    const-string v1, "android.permission.USE_SIP"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_1e8
    const/16 v1, 0x1a

    if-lt p1, v1, :cond_26c

    const-string p1, "android.permission.ANSWER_PHONE_CALLS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.ANSWER_PHONE_CALLS"

    goto/16 :goto_103

    :pswitch_1f8
    const-string p1, "android.permission.RECORD_AUDIO"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    goto :goto_256

    :pswitch_201
    return-object v3

    :pswitch_202
    const/4 v1, 0x4

    if-ne p1, v1, :cond_215

    sget p1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt p1, v5, :cond_215

    const-string p1, "android.permission.ACCESS_BACKGROUND_LOCATION"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.ACCESS_BACKGROUND_LOCATION"

    goto/16 :goto_103

    :cond_215
    const-string p1, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_220

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_220
    const-string p1, "android.permission.ACCESS_FINE_LOCATION"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.ACCESS_FINE_LOCATION"

    goto/16 :goto_103

    :pswitch_22c
    const-string p1, "android.permission.READ_CONTACTS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_237

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_237
    const-string p1, "android.permission.WRITE_CONTACTS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_242

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_242
    const-string p1, "android.permission.GET_ACCOUNTS"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    const-string p0, "android.permission.GET_ACCOUNTS"

    goto/16 :goto_103

    :pswitch_24e
    const-string p1, "android.permission.CAMERA"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    :goto_256
    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_26c

    :pswitch_25a
    invoke-static {p0, v0, v4}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_263

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_263
    const-string p1, "android.permission.READ_CALENDAR"

    invoke-static {p0, v0, p1}, Lb0/w;->e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z

    move-result p0

    if-eqz p0, :cond_26c

    goto :goto_256

    :cond_26c
    :goto_26c
    return-object v0

    nop

    :pswitch_data_26e
    .packed-switch 0x0
        :pswitch_25a
        :pswitch_24e
        :pswitch_22c
        :pswitch_202
        :pswitch_202
        :pswitch_202
        :pswitch_201
        :pswitch_1f8
        :pswitch_18b
        :pswitch_17d
        :pswitch_13
        :pswitch_201
        :pswitch_173
        :pswitch_138
        :pswitch_1f8
        :pswitch_116
        :pswitch_108
        :pswitch_f5
        :pswitch_e5
        :pswitch_d5
        :pswitch_201
        :pswitch_cb
        :pswitch_ba
        :pswitch_b0
        :pswitch_a1
        :pswitch_13
        :pswitch_13
        :pswitch_92
        :pswitch_85
        :pswitch_78
        :pswitch_6a
        :pswitch_5a
        :pswitch_4a
        :pswitch_3a
        :pswitch_30
        :pswitch_20
        :pswitch_15
        :pswitch_25a
    .end packed-switch
.end method

.method private static d(Landroid/content/Context;)Landroid/content/pm/PackageInfo;
    .registers 4

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x21

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object p0

    if-lt v1, v2, :cond_19

    const-wide/16 v1, 0x1000

    invoke-static {v1, v2}, Landroid/content/pm/PackageManager$PackageInfoFlags;->of(J)Landroid/content/pm/PackageManager$PackageInfoFlags;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;Landroid/content/pm/PackageManager$PackageInfoFlags;)Landroid/content/pm/PackageInfo;

    move-result-object p0

    return-object p0

    :cond_19
    const/16 v1, 0x1000

    invoke-virtual {v0, p0, v1}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object p0

    return-object p0
.end method

.method private static e(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)Z
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/ArrayList<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")Z"
        }
    .end annotation

    const/4 v0, 0x1

    const/4 v1, 0x0

    const-string v2, "permissions_handler"

    if-eqz p1, :cond_1f

    :try_start_6
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p1

    :cond_a
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1f

    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v3, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a

    return v0

    :catch_1d
    move-exception p0

    goto :goto_55

    :cond_1f
    if-nez p0, :cond_27

    const-string p0, "Unable to detect current Activity or App Context."

    invoke-static {v2, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return v1

    :cond_27
    invoke-static {p0}, Lb0/w;->d(Landroid/content/Context;)Landroid/content/pm/PackageInfo;

    move-result-object p0

    if-nez p0, :cond_33

    const-string p0, "Unable to get Package info, will not be able to determine permissions to request."

    invoke-static {v2, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return v1

    :cond_33
    new-instance p1, Ljava/util/ArrayList;

    iget-object p0, p0, Landroid/content/pm/PackageInfo;->requestedPermissions:[Ljava/lang/String;

    invoke-static {p0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object p0

    invoke-direct {p1, p0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object p0

    :cond_42
    invoke-interface {p0}, Ljava/util/Iterator;->hasNext()Z

    move-result p1

    if-eqz p1, :cond_5a

    invoke-interface {p0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/lang/String;

    invoke-virtual {p1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1
    :try_end_52
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_52} :catch_1d

    if-eqz p1, :cond_42

    return v0

    :goto_55
    const-string p1, "Unable to check manifest for permission: "

    invoke-static {v2, p1, p0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    :cond_5a
    return v1
.end method

.method static f(Landroid/app/Activity;Ljava/lang/String;)Z
    .registers 2

    invoke-static {p0, p1}, Landroidx/core/app/a;->f(Landroid/app/Activity;Ljava/lang/String;)Z

    move-result p0

    xor-int/lit8 p0, p0, 0x1

    return p0
.end method

.method static g(Ljava/lang/String;)I
    .registers 26

    move-object/from16 v0, p0

    invoke-virtual/range {p0 .. p0}, Ljava/lang/String;->hashCode()I

    invoke-virtual/range {p0 .. p0}, Ljava/lang/String;->hashCode()I

    move-result v1

    const/16 v2, 0x1e

    const/16 v3, 0x1d

    const/16 v4, 0x1c

    const/16 v5, 0x1b

    const/16 v6, 0x18

    const/16 v7, 0x17

    const/16 v8, 0x16

    const/16 v9, 0x14

    const/16 v10, 0x13

    const/16 v11, 0x12

    const/16 v12, 0x11

    const/16 v13, 0xf

    const/16 v14, 0xd

    const/16 v15, 0xc

    const/16 v16, 0x9

    const/16 v17, 0x8

    const/16 v18, 0x7

    const/16 v19, 0x4

    const/16 v20, 0x3

    const/16 v21, 0x2

    const/16 v22, 0x1

    const/16 v23, 0x0

    const/16 v24, -0x1

    sparse-switch v1, :sswitch_data_292

    goto/16 :goto_269

    :sswitch_3c
    const-string v1, "com.android.voicemail.permission.ADD_VOICEMAIL"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_46

    goto/16 :goto_269

    :cond_46
    const/16 v24, 0x28

    goto/16 :goto_269

    :sswitch_4a
    const-string v1, "android.permission.ACCESS_MEDIA_LOCATION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_54

    goto/16 :goto_269

    :cond_54
    const/16 v24, 0x27

    goto/16 :goto_269

    :sswitch_58
    const-string v1, "android.permission.BLUETOOTH_SCAN"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_62

    goto/16 :goto_269

    :cond_62
    const/16 v24, 0x26

    goto/16 :goto_269

    :sswitch_66
    const-string v1, "android.permission.ACCESS_BACKGROUND_LOCATION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_70

    goto/16 :goto_269

    :cond_70
    const/16 v24, 0x25

    goto/16 :goto_269

    :sswitch_74
    const-string v1, "android.permission.READ_CONTACTS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7e

    goto/16 :goto_269

    :cond_7e
    const/16 v24, 0x24

    goto/16 :goto_269

    :sswitch_82
    const-string v1, "android.permission.RECORD_AUDIO"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8c

    goto/16 :goto_269

    :cond_8c
    const/16 v24, 0x23

    goto/16 :goto_269

    :sswitch_90
    const-string v1, "android.permission.ACTIVITY_RECOGNITION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9a

    goto/16 :goto_269

    :cond_9a
    const/16 v24, 0x22

    goto/16 :goto_269

    :sswitch_9e
    const-string v1, "android.permission.REQUEST_INSTALL_PACKAGES"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a8

    goto/16 :goto_269

    :cond_a8
    const/16 v24, 0x21

    goto/16 :goto_269

    :sswitch_ac
    const-string v1, "android.permission.WRITE_EXTERNAL_STORAGE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_b6

    goto/16 :goto_269

    :cond_b6
    const/16 v24, 0x20

    goto/16 :goto_269

    :sswitch_ba
    const-string v1, "android.permission.GET_ACCOUNTS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_c4

    goto/16 :goto_269

    :cond_c4
    const/16 v24, 0x1f

    goto/16 :goto_269

    :sswitch_c8
    const-string v1, "android.permission.BLUETOOTH_ADVERTISE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_d2

    goto/16 :goto_269

    :cond_d2
    const/16 v24, 0x1e

    goto/16 :goto_269

    :sswitch_d6
    const-string v1, "android.permission.SCHEDULE_EXACT_ALARM"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_e0

    goto/16 :goto_269

    :cond_e0
    const/16 v24, 0x1d

    goto/16 :goto_269

    :sswitch_e4
    const-string v1, "android.permission.USE_SIP"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_ee

    goto/16 :goto_269

    :cond_ee
    const/16 v24, 0x1c

    goto/16 :goto_269

    :sswitch_f2
    const-string v1, "android.permission.READ_MEDIA_VIDEO"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_fc

    goto/16 :goto_269

    :cond_fc
    const/16 v24, 0x1b

    goto/16 :goto_269

    :sswitch_100
    const-string v1, "android.permission.READ_MEDIA_AUDIO"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10a

    goto/16 :goto_269

    :cond_10a
    const/16 v24, 0x1a

    goto/16 :goto_269

    :sswitch_10e
    const-string v1, "android.permission.WRITE_CALL_LOG"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_118

    goto/16 :goto_269

    :cond_118
    const/16 v24, 0x19

    goto/16 :goto_269

    :sswitch_11c
    const-string v1, "android.permission.WRITE_CALENDAR"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_126

    goto/16 :goto_269

    :cond_126
    const/16 v24, 0x18

    goto/16 :goto_269

    :sswitch_12a
    const-string v1, "android.permission.CAMERA"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_134

    goto/16 :goto_269

    :cond_134
    const/16 v24, 0x17

    goto/16 :goto_269

    :sswitch_138
    const-string v1, "android.permission.BODY_SENSORS_BACKGROUND"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_142

    goto/16 :goto_269

    :cond_142
    const/16 v24, 0x16

    goto/16 :goto_269

    :sswitch_146
    const-string v1, "android.permission.WRITE_CONTACTS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_150

    goto/16 :goto_269

    :cond_150
    const/16 v24, 0x15

    goto/16 :goto_269

    :sswitch_154
    const-string v1, "android.permission.READ_MEDIA_IMAGES"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_15e

    goto/16 :goto_269

    :cond_15e
    const/16 v24, 0x14

    goto/16 :goto_269

    :sswitch_162
    const-string v1, "android.permission.CALL_PHONE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_16c

    goto/16 :goto_269

    :cond_16c
    const/16 v24, 0x13

    goto/16 :goto_269

    :sswitch_170
    const-string v1, "android.permission.SEND_SMS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_17a

    goto/16 :goto_269

    :cond_17a
    const/16 v24, 0x12

    goto/16 :goto_269

    :sswitch_17e
    const-string v1, "android.permission.READ_PHONE_STATE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_188

    goto/16 :goto_269

    :cond_188
    const/16 v24, 0x11

    goto/16 :goto_269

    :sswitch_18c
    const-string v1, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_196

    goto/16 :goto_269

    :cond_196
    const/16 v24, 0x10

    goto/16 :goto_269

    :sswitch_19a
    const-string v1, "android.permission.READ_EXTERNAL_STORAGE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1a4

    goto/16 :goto_269

    :cond_1a4
    const/16 v24, 0xf

    goto/16 :goto_269

    :sswitch_1a8
    const-string v1, "android.permission.BLUETOOTH_CONNECT"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1b2

    goto/16 :goto_269

    :cond_1b2
    const/16 v24, 0xe

    goto/16 :goto_269

    :sswitch_1b6
    const-string v1, "android.permission.RECEIVE_SMS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1c0

    goto/16 :goto_269

    :cond_1c0
    const/16 v24, 0xd

    goto/16 :goto_269

    :sswitch_1c4
    const-string v1, "android.permission.RECEIVE_MMS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1ce

    goto/16 :goto_269

    :cond_1ce
    const/16 v24, 0xc

    goto/16 :goto_269

    :sswitch_1d2
    const-string v1, "android.permission.NEARBY_WIFI_DEVICES"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1dc

    goto/16 :goto_269

    :cond_1dc
    const/16 v24, 0xb

    goto/16 :goto_269

    :sswitch_1e0
    const-string v1, "android.permission.READ_PHONE_NUMBERS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1ea

    goto/16 :goto_269

    :cond_1ea
    const/16 v24, 0xa

    goto/16 :goto_269

    :sswitch_1ee
    const-string v1, "android.permission.BODY_SENSORS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1f8

    goto/16 :goto_269

    :cond_1f8
    const/16 v24, 0x9

    goto/16 :goto_269

    :sswitch_1fc
    const-string v1, "android.permission.RECEIVE_WAP_PUSH"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_206

    goto/16 :goto_269

    :cond_206
    const/16 v24, 0x8

    goto/16 :goto_269

    :sswitch_20a
    const-string v1, "android.permission.SYSTEM_ALERT_WINDOW"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_213

    goto :goto_269

    :cond_213
    const/16 v24, 0x7

    goto :goto_269

    :sswitch_216
    const-string v1, "android.permission.ACCESS_NOTIFICATION_POLICY"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_21f

    goto :goto_269

    :cond_21f
    const/16 v24, 0x6

    goto :goto_269

    :sswitch_222
    const-string v1, "android.permission.MANAGE_EXTERNAL_STORAGE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_22b

    goto :goto_269

    :cond_22b
    const/16 v24, 0x5

    goto :goto_269

    :sswitch_22e
    const-string v1, "android.permission.ACCESS_FINE_LOCATION"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_237

    goto :goto_269

    :cond_237
    const/16 v24, 0x4

    goto :goto_269

    :sswitch_23a
    const-string v1, "android.permission.READ_CALL_LOG"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_243

    goto :goto_269

    :cond_243
    const/16 v24, 0x3

    goto :goto_269

    :sswitch_246
    const-string v1, "android.permission.POST_NOTIFICATIONS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_24f

    goto :goto_269

    :cond_24f
    const/16 v24, 0x2

    goto :goto_269

    :sswitch_252
    const-string v1, "android.permission.READ_CALENDAR"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_25b

    goto :goto_269

    :cond_25b
    const/16 v24, 0x1

    goto :goto_269

    :sswitch_25e
    const-string v1, "android.permission.READ_SMS"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_267

    goto :goto_269

    :cond_267
    const/16 v24, 0x0

    :goto_269
    packed-switch v24, :pswitch_data_338

    return v9

    :pswitch_26d
    return v11

    :pswitch_26e
    return v4

    :pswitch_26f
    return v19

    :pswitch_270
    return v18

    :pswitch_271
    return v10

    :pswitch_272
    return v6

    :pswitch_273
    return v3

    :pswitch_274
    const/16 v0, 0x22

    return v0

    :pswitch_277
    const/16 v0, 0x20

    return v0

    :pswitch_27a
    const/16 v0, 0x21

    return v0

    :pswitch_27d
    return v22

    :pswitch_27e
    const/16 v0, 0x23

    return v0

    :pswitch_281
    return v21

    :pswitch_282
    return v16

    :pswitch_283
    return v13

    :pswitch_284
    return v2

    :pswitch_285
    const/16 v0, 0x1f

    return v0

    :pswitch_288
    return v15

    :pswitch_289
    return v7

    :pswitch_28a
    return v5

    :pswitch_28b
    return v8

    :pswitch_28c
    return v20

    :pswitch_28d
    return v17

    :pswitch_28e
    return v12

    :pswitch_28f
    return v23

    :pswitch_290
    return v14

    nop

    :sswitch_data_292
    .sparse-switch
        -0x7aed85b0 -> :sswitch_25e
        -0x72f13779 -> :sswitch_252
        -0x72ca2557 -> :sswitch_246
        -0x7286b8f4 -> :sswitch_23a
        -0x70918bc1 -> :sswitch_22e
        -0x6c1165bf -> :sswitch_222
        -0x6a47e915 -> :sswitch_216
        -0x5d1492dd -> :sswitch_20a
        -0x583351d1 -> :sswitch_1fc
        -0x49cb6684 -> :sswitch_1ee
        -0x456a1f70 -> :sswitch_1e0
        -0x363647ed -> :sswitch_1d2
        -0x3562fc09 -> :sswitch_1c4
        -0x3562e583 -> :sswitch_1b6
        -0x2f9abb27 -> :sswitch_1a8
        -0x1833add0 -> :sswitch_19a
        -0x3c1ac56 -> :sswitch_18c
        -0x550ba9 -> :sswitch_17e
        0x322a742 -> :sswitch_170
        0x6afff6d -> :sswitch_162
        0xa7a881c -> :sswitch_154
        0xcc96c13 -> :sswitch_146
        0x158e77d1 -> :sswitch_138
        0x1b9efa65 -> :sswitch_12a
        0x23fb06fe -> :sswitch_11c
        0x24658583 -> :sswitch_10e
        0x2933cd92 -> :sswitch_100
        0x2a564637 -> :sswitch_f2
        0x2ec2d2a2 -> :sswitch_e4
        0x39db9e69 -> :sswitch_d6
        0x4586b056 -> :sswitch_c8
        0x4bcdda0f -> :sswitch_ba
        0x516a29a7 -> :sswitch_ac
        0x69eee241 -> :sswitch_9e
        0x6a1dc9a7 -> :sswitch_90
        0x6d24f988 -> :sswitch_82
        0x75dd2d9c -> :sswitch_74
        0x78aeb38b -> :sswitch_66
        0x7aed10ce -> :sswitch_58
        0x7e09eacb -> :sswitch_4a
        0x7f2f307d -> :sswitch_3c
    .end sparse-switch

    :pswitch_data_338
    .packed-switch 0x0
        :pswitch_290
        :pswitch_28f
        :pswitch_28e
        :pswitch_28d
        :pswitch_28c
        :pswitch_28b
        :pswitch_28a
        :pswitch_289
        :pswitch_290
        :pswitch_288
        :pswitch_28d
        :pswitch_285
        :pswitch_290
        :pswitch_290
        :pswitch_284
        :pswitch_283
        :pswitch_28c
        :pswitch_28d
        :pswitch_290
        :pswitch_28d
        :pswitch_282
        :pswitch_281
        :pswitch_27e
        :pswitch_27d
        :pswitch_28f
        :pswitch_28d
        :pswitch_27a
        :pswitch_277
        :pswitch_28d
        :pswitch_274
        :pswitch_273
        :pswitch_281
        :pswitch_283
        :pswitch_272
        :pswitch_271
        :pswitch_270
        :pswitch_281
        :pswitch_26f
        :pswitch_26e
        :pswitch_26d
        :pswitch_28d
    .end packed-switch
.end method

.method private static h(Landroid/content/Context;Ljava/lang/String;)V
    .registers 3

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object p0

    invoke-interface {p0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object p0

    const-string p1, "sp_permission_handler_permission_was_denied_before"

    const/4 v0, 0x1

    invoke-interface {p0, p1, v0}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object p0

    invoke-interface {p0}, Landroid/content/SharedPreferences$Editor;->apply()V

    return-void
.end method

.method static i(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;
    .registers 3

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    invoke-interface {v0, p0}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    invoke-interface {v0, p1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    invoke-static {v0}, Lb0/w;->j(Ljava/util/Collection;)Ljava/lang/Integer;

    move-result-object p0

    return-object p0
.end method

.method static j(Ljava/util/Collection;)Ljava/lang/Integer;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Ljava/lang/Integer;",
            ">;)",
            "Ljava/lang/Integer;"
        }
    .end annotation

    const/4 v0, 0x4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {p0, v0}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_c

    return-object v0

    :cond_c
    const/4 v0, 0x2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p0, v1}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1c

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    return-object p0

    :cond_1c
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p0, v1}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2c

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    return-object p0

    :cond_2c
    const/4 v0, 0x3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p0, v1}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result p0

    if-eqz p0, :cond_3c

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    return-object p0

    :cond_3c
    const/4 p0, 0x1

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    return-object p0
.end method

.method static k(Landroid/app/Activity;Ljava/lang/String;I)I
    .registers 4

    const/4 v0, -0x1

    if-ne p2, v0, :cond_8

    invoke-static {p0, p1}, Lb0/w;->b(Landroid/app/Activity;Ljava/lang/String;)I

    move-result p0

    return p0

    :cond_8
    const/4 p0, 0x1

    return p0
.end method

.method private static l(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 3

    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object p0

    const-string p1, "sp_permission_handler_permission_was_denied_before"

    invoke-interface {p0, p1, v0}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result p0

    return p0
.end method
