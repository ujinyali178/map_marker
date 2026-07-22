.class public Landroidx/core/app/s$e;
.super Landroidx/core/app/s$f;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/core/app/s;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "e"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/core/app/s$e$d;,
        Landroidx/core/app/s$e$c;,
        Landroidx/core/app/s$e$e;,
        Landroidx/core/app/s$e$a;,
        Landroidx/core/app/s$e$b;
    }
.end annotation


# instance fields
.field private e:I

.field private f:Landroidx/core/app/c1;

.field private g:Landroid/app/PendingIntent;

.field private h:Landroid/app/PendingIntent;

.field private i:Landroid/app/PendingIntent;

.field private j:Z

.field private k:Ljava/lang/Integer;

.field private l:Ljava/lang/Integer;

.field private m:Landroidx/core/graphics/drawable/IconCompat;

.field private n:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>()V
    .registers 1

    invoke-direct {p0}, Landroidx/core/app/s$f;-><init>()V

    return-void
.end method

.method private i()Ljava/lang/String;
    .registers 3

    iget v0, p0, Landroidx/core/app/s$e;->e:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_27

    const/4 v1, 0x2

    if-eq v0, v1, :cond_1c

    const/4 v1, 0x3

    if-eq v0, v1, :cond_d

    const/4 v0, 0x0

    return-object v0

    :cond_d
    iget-object v0, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object v0, v0, Landroidx/core/app/s$d;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lh/e;->g:I

    :goto_17
    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_1c
    iget-object v0, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object v0, v0, Landroidx/core/app/s$d;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lh/e;->f:I

    goto :goto_17

    :cond_27
    iget-object v0, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object v0, v0, Landroidx/core/app/s$d;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lh/e;->e:I

    goto :goto_17
.end method

.method private j(Landroidx/core/app/s$a;)Z
    .registers 3

    if-eqz p1, :cond_10

    invoke-virtual {p1}, Landroidx/core/app/s$a;->c()Landroid/os/Bundle;

    move-result-object p1

    const-string v0, "key_action_priority"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result p1

    if-eqz p1, :cond_10

    const/4 p1, 0x1

    goto :goto_11

    :cond_10
    const/4 p1, 0x0

    :goto_11
    return p1
.end method

.method private k(IILjava/lang/Integer;ILandroid/app/PendingIntent;)Landroidx/core/app/s$a;
    .registers 8

    if-nez p3, :cond_e

    iget-object p3, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object p3, p3, Landroidx/core/app/s$d;->a:Landroid/content/Context;

    invoke-static {p3, p4}, Landroidx/core/content/a;->getColor(Landroid/content/Context;I)I

    move-result p3

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    :cond_e
    new-instance p4, Landroid/text/SpannableStringBuilder;

    invoke-direct {p4}, Landroid/text/SpannableStringBuilder;-><init>()V

    iget-object v0, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object v0, v0, Landroidx/core/app/s$d;->a:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p2

    invoke-virtual {p4, p2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    new-instance p2, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {p3}, Ljava/lang/Integer;->intValue()I

    move-result p3

    invoke-direct {p2, p3}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/4 p3, 0x0

    invoke-virtual {p4}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v0

    const/16 v1, 0x12

    invoke-virtual {p4, p2, p3, v0, v1}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    new-instance p2, Landroidx/core/app/s$a$a;

    iget-object p3, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object p3, p3, Landroidx/core/app/s$d;->a:Landroid/content/Context;

    invoke-static {p3, p1}, Landroidx/core/graphics/drawable/IconCompat;->g(Landroid/content/Context;I)Landroidx/core/graphics/drawable/IconCompat;

    move-result-object p1

    invoke-direct {p2, p1, p4, p5}, Landroidx/core/app/s$a$a;-><init>(Landroidx/core/graphics/drawable/IconCompat;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V

    invoke-virtual {p2}, Landroidx/core/app/s$a$a;->a()Landroidx/core/app/s$a;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/core/app/s$a;->c()Landroid/os/Bundle;

    move-result-object p2

    const/4 p3, 0x1

    const-string p4, "key_action_priority"

    invoke-virtual {p2, p4, p3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    return-object p1
.end method

.method private l()Landroidx/core/app/s$a;
    .registers 9

    sget v0, Lh/c;->b:I

    sget v1, Lh/c;->a:I

    iget-object v7, p0, Landroidx/core/app/s$e;->g:Landroid/app/PendingIntent;

    if-nez v7, :cond_a

    const/4 v0, 0x0

    goto :goto_22

    :cond_a
    iget-boolean v2, p0, Landroidx/core/app/s$e;->j:Z

    if-eqz v2, :cond_10

    move v3, v0

    goto :goto_11

    :cond_10
    move v3, v1

    :goto_11
    if-eqz v2, :cond_16

    sget v0, Lh/e;->b:I

    goto :goto_18

    :cond_16
    sget v0, Lh/e;->a:I

    :goto_18
    move v4, v0

    iget-object v5, p0, Landroidx/core/app/s$e;->k:Ljava/lang/Integer;

    sget v6, Lh/b;->a:I

    move-object v2, p0

    invoke-direct/range {v2 .. v7}, Landroidx/core/app/s$e;->k(IILjava/lang/Integer;ILandroid/app/PendingIntent;)Landroidx/core/app/s$a;

    move-result-object v0

    :goto_22
    return-object v0
.end method

.method private m()Landroidx/core/app/s$a;
    .registers 7

    sget v1, Lh/c;->c:I

    iget-object v5, p0, Landroidx/core/app/s$e;->h:Landroid/app/PendingIntent;

    if-nez v5, :cond_14

    sget v2, Lh/e;->d:I

    iget-object v3, p0, Landroidx/core/app/s$e;->l:Ljava/lang/Integer;

    sget v4, Lh/b;->b:I

    iget-object v5, p0, Landroidx/core/app/s$e;->i:Landroid/app/PendingIntent;

    :goto_e
    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Landroidx/core/app/s$e;->k(IILjava/lang/Integer;ILandroid/app/PendingIntent;)Landroidx/core/app/s$a;

    move-result-object v0

    return-object v0

    :cond_14
    sget v2, Lh/e;->c:I

    iget-object v3, p0, Landroidx/core/app/s$e;->l:Ljava/lang/Integer;

    sget v4, Lh/b;->b:I

    goto :goto_e
.end method


# virtual methods
.method public a(Landroid/os/Bundle;)V
    .registers 5

    invoke-super {p0, p1}, Landroidx/core/app/s$f;->a(Landroid/os/Bundle;)V

    iget v0, p0, Landroidx/core/app/s$e;->e:I

    const-string v1, "android.callType"

    invoke-virtual {p1, v1, v0}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    iget-boolean v0, p0, Landroidx/core/app/s$e;->j:Z

    const-string v1, "android.callIsVideo"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    iget-object v0, p0, Landroidx/core/app/s$e;->f:Landroidx/core/app/c1;

    if-eqz v0, :cond_2f

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    if-lt v1, v2, :cond_26

    invoke-virtual {v0}, Landroidx/core/app/c1;->h()Landroid/app/Person;

    move-result-object v0

    invoke-static {v0}, Landroidx/core/app/s$e$d;->b(Landroid/app/Person;)Landroid/os/Parcelable;

    move-result-object v0

    const-string v1, "android.callPerson"

    goto :goto_2c

    :cond_26
    invoke-virtual {v0}, Landroidx/core/app/c1;->i()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "android.callPersonCompat"

    :goto_2c
    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    :cond_2f
    iget-object v0, p0, Landroidx/core/app/s$e;->m:Landroidx/core/graphics/drawable/IconCompat;

    if-eqz v0, :cond_51

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x17

    if-lt v1, v2, :cond_48

    iget-object v1, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object v1, v1, Landroidx/core/app/s$d;->a:Landroid/content/Context;

    invoke-virtual {v0, v1}, Landroidx/core/graphics/drawable/IconCompat;->s(Landroid/content/Context;)Landroid/graphics/drawable/Icon;

    move-result-object v0

    invoke-static {v0}, Landroidx/core/app/s$e$c;->a(Landroid/graphics/drawable/Icon;)Landroid/os/Parcelable;

    move-result-object v0

    const-string v1, "android.verificationIcon"

    goto :goto_4e

    :cond_48
    invoke-virtual {v0}, Landroidx/core/graphics/drawable/IconCompat;->q()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "android.verificationIconCompat"

    :goto_4e
    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    :cond_51
    iget-object v0, p0, Landroidx/core/app/s$e;->n:Ljava/lang/CharSequence;

    const-string v1, "android.verificationText"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putCharSequence(Ljava/lang/String;Ljava/lang/CharSequence;)V

    iget-object v0, p0, Landroidx/core/app/s$e;->g:Landroid/app/PendingIntent;

    const-string v1, "android.answerIntent"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    iget-object v0, p0, Landroidx/core/app/s$e;->h:Landroid/app/PendingIntent;

    const-string v1, "android.declineIntent"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    iget-object v0, p0, Landroidx/core/app/s$e;->i:Landroid/app/PendingIntent;

    const-string v1, "android.hangUpIntent"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    iget-object v0, p0, Landroidx/core/app/s$e;->k:Ljava/lang/Integer;

    if-eqz v0, :cond_7a

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const-string v1, "android.answerColor"

    invoke-virtual {p1, v1, v0}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    :cond_7a
    iget-object v0, p0, Landroidx/core/app/s$e;->l:Ljava/lang/Integer;

    if-eqz v0, :cond_87

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const-string v1, "android.declineColor"

    invoke-virtual {p1, v1, v0}, Landroid/os/BaseBundle;->putInt(Ljava/lang/String;I)V

    :cond_87
    return-void
.end method

.method public b(Landroidx/core/app/r;)V
    .registers 6

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x0

    const/16 v2, 0x1f

    if-lt v0, v2, :cond_98

    iget v0, p0, Landroidx/core/app/s$e;->e:I

    const/4 v2, 0x1

    if-eq v0, v2, :cond_51

    const/4 v2, 0x2

    if-eq v0, v2, :cond_44

    const/4 v2, 0x3

    if-eq v0, v2, :cond_35

    const-string v0, "NotifCompat"

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_5f

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unrecognized call type in CallStyle: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v3, p0, Landroidx/core/app/s$e;->e:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5f

    :cond_35
    iget-object v0, p0, Landroidx/core/app/s$e;->f:Landroidx/core/app/c1;

    invoke-virtual {v0}, Landroidx/core/app/c1;->h()Landroid/app/Person;

    move-result-object v0

    iget-object v1, p0, Landroidx/core/app/s$e;->i:Landroid/app/PendingIntent;

    iget-object v2, p0, Landroidx/core/app/s$e;->g:Landroid/app/PendingIntent;

    invoke-static {v0, v1, v2}, Landroidx/core/app/s$e$e;->c(Landroid/app/Person;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)Landroid/app/Notification$CallStyle;

    move-result-object v1

    goto :goto_5f

    :cond_44
    iget-object v0, p0, Landroidx/core/app/s$e;->f:Landroidx/core/app/c1;

    invoke-virtual {v0}, Landroidx/core/app/c1;->h()Landroid/app/Person;

    move-result-object v0

    iget-object v1, p0, Landroidx/core/app/s$e;->i:Landroid/app/PendingIntent;

    invoke-static {v0, v1}, Landroidx/core/app/s$e$e;->b(Landroid/app/Person;Landroid/app/PendingIntent;)Landroid/app/Notification$CallStyle;

    move-result-object v1

    goto :goto_5f

    :cond_51
    iget-object v0, p0, Landroidx/core/app/s$e;->f:Landroidx/core/app/c1;

    invoke-virtual {v0}, Landroidx/core/app/c1;->h()Landroid/app/Person;

    move-result-object v0

    iget-object v1, p0, Landroidx/core/app/s$e;->h:Landroid/app/PendingIntent;

    iget-object v2, p0, Landroidx/core/app/s$e;->g:Landroid/app/PendingIntent;

    invoke-static {v0, v1, v2}, Landroidx/core/app/s$e$e;->a(Landroid/app/Person;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)Landroid/app/Notification$CallStyle;

    move-result-object v1

    :cond_5f
    :goto_5f
    if-eqz v1, :cond_103

    invoke-interface {p1}, Landroidx/core/app/r;->a()Landroid/app/Notification$Builder;

    move-result-object p1

    invoke-static {v1, p1}, Landroidx/core/app/s$e$a;->a(Landroid/app/Notification$CallStyle;Landroid/app/Notification$Builder;)V

    iget-object p1, p0, Landroidx/core/app/s$e;->k:Ljava/lang/Integer;

    if-eqz p1, :cond_73

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    invoke-static {v1, p1}, Landroidx/core/app/s$e$e;->d(Landroid/app/Notification$CallStyle;I)Landroid/app/Notification$CallStyle;

    :cond_73
    iget-object p1, p0, Landroidx/core/app/s$e;->l:Ljava/lang/Integer;

    if-eqz p1, :cond_7e

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result p1

    invoke-static {v1, p1}, Landroidx/core/app/s$e$e;->f(Landroid/app/Notification$CallStyle;I)Landroid/app/Notification$CallStyle;

    :cond_7e
    iget-object p1, p0, Landroidx/core/app/s$e;->n:Ljava/lang/CharSequence;

    invoke-static {v1, p1}, Landroidx/core/app/s$e$e;->i(Landroid/app/Notification$CallStyle;Ljava/lang/CharSequence;)Landroid/app/Notification$CallStyle;

    iget-object p1, p0, Landroidx/core/app/s$e;->m:Landroidx/core/graphics/drawable/IconCompat;

    if-eqz p1, :cond_92

    iget-object v0, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object v0, v0, Landroidx/core/app/s$d;->a:Landroid/content/Context;

    invoke-virtual {p1, v0}, Landroidx/core/graphics/drawable/IconCompat;->s(Landroid/content/Context;)Landroid/graphics/drawable/Icon;

    move-result-object p1

    invoke-static {v1, p1}, Landroidx/core/app/s$e$e;->h(Landroid/app/Notification$CallStyle;Landroid/graphics/drawable/Icon;)Landroid/app/Notification$CallStyle;

    :cond_92
    iget-boolean p1, p0, Landroidx/core/app/s$e;->j:Z

    invoke-static {v1, p1}, Landroidx/core/app/s$e$e;->g(Landroid/app/Notification$CallStyle;Z)Landroid/app/Notification$CallStyle;

    goto :goto_103

    :cond_98
    invoke-interface {p1}, Landroidx/core/app/r;->a()Landroid/app/Notification$Builder;

    move-result-object p1

    iget-object v2, p0, Landroidx/core/app/s$e;->f:Landroidx/core/app/c1;

    if-eqz v2, :cond_a5

    invoke-virtual {v2}, Landroidx/core/app/c1;->c()Ljava/lang/CharSequence;

    move-result-object v2

    goto :goto_a6

    :cond_a5
    move-object v2, v1

    :goto_a6
    invoke-virtual {p1, v2}, Landroid/app/Notification$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    iget-object v2, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object v2, v2, Landroidx/core/app/s$d;->D:Landroid/os/Bundle;

    if-eqz v2, :cond_bf

    const-string v3, "android.text"

    invoke-virtual {v2, v3}, Landroid/os/BaseBundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_bf

    iget-object v1, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object v1, v1, Landroidx/core/app/s$d;->D:Landroid/os/Bundle;

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getCharSequence(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v1

    :cond_bf
    if-nez v1, :cond_c5

    invoke-direct {p0}, Landroidx/core/app/s$e;->i()Ljava/lang/String;

    move-result-object v1

    :cond_c5
    invoke-virtual {p1, v1}, Landroid/app/Notification$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/app/Notification$Builder;

    iget-object v1, p0, Landroidx/core/app/s$e;->f:Landroidx/core/app/c1;

    if-eqz v1, :cond_fe

    const/16 v2, 0x17

    if-lt v0, v2, :cond_e7

    invoke-virtual {v1}, Landroidx/core/app/c1;->a()Landroidx/core/graphics/drawable/IconCompat;

    move-result-object v1

    if-eqz v1, :cond_e7

    iget-object v1, p0, Landroidx/core/app/s$e;->f:Landroidx/core/app/c1;

    invoke-virtual {v1}, Landroidx/core/app/c1;->a()Landroidx/core/graphics/drawable/IconCompat;

    move-result-object v1

    iget-object v2, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object v2, v2, Landroidx/core/app/s$d;->a:Landroid/content/Context;

    invoke-virtual {v1, v2}, Landroidx/core/graphics/drawable/IconCompat;->s(Landroid/content/Context;)Landroid/graphics/drawable/Icon;

    move-result-object v1

    invoke-static {p1, v1}, Landroidx/core/app/s$e$c;->c(Landroid/app/Notification$Builder;Landroid/graphics/drawable/Icon;)V

    :cond_e7
    const/16 v1, 0x1c

    if-lt v0, v1, :cond_f5

    iget-object v0, p0, Landroidx/core/app/s$e;->f:Landroidx/core/app/c1;

    invoke-virtual {v0}, Landroidx/core/app/c1;->h()Landroid/app/Person;

    move-result-object v0

    invoke-static {p1, v0}, Landroidx/core/app/s$e$d;->a(Landroid/app/Notification$Builder;Landroid/app/Person;)Landroid/app/Notification$Builder;

    goto :goto_fe

    :cond_f5
    iget-object v0, p0, Landroidx/core/app/s$e;->f:Landroidx/core/app/c1;

    invoke-virtual {v0}, Landroidx/core/app/c1;->d()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Landroidx/core/app/s$e$b;->a(Landroid/app/Notification$Builder;Ljava/lang/String;)Landroid/app/Notification$Builder;

    :cond_fe
    :goto_fe
    const-string v0, "call"

    invoke-static {p1, v0}, Landroidx/core/app/s$e$b;->b(Landroid/app/Notification$Builder;Ljava/lang/String;)Landroid/app/Notification$Builder;

    :cond_103
    :goto_103
    return-void
.end method

.method protected c()Ljava/lang/String;
    .registers 2

    const-string v0, "androidx.core.app.NotificationCompat$CallStyle"

    return-object v0
.end method

.method public h()Ljava/util/ArrayList;
    .registers 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList<",
            "Landroidx/core/app/s$a;",
            ">;"
        }
    .end annotation

    invoke-direct {p0}, Landroidx/core/app/s$e;->m()Landroidx/core/app/s$a;

    move-result-object v0

    invoke-direct {p0}, Landroidx/core/app/s$e;->l()Landroidx/core/app/s$a;

    move-result-object v1

    new-instance v2, Ljava/util/ArrayList;

    const/4 v3, 0x3

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(I)V

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const/4 v0, 0x2

    iget-object v3, p0, Landroidx/core/app/s$f;->a:Landroidx/core/app/s$d;

    iget-object v3, v3, Landroidx/core/app/s$d;->b:Ljava/util/ArrayList;

    const/4 v4, 0x1

    if-eqz v3, :cond_4b

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1d
    :goto_1d
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4b

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/core/app/s$a;

    invoke-virtual {v5}, Landroidx/core/app/s$a;->j()Z

    move-result v6

    if-eqz v6, :cond_33

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_41

    :cond_33
    invoke-direct {p0, v5}, Landroidx/core/app/s$e;->j(Landroidx/core/app/s$a;)Z

    move-result v6

    if-eqz v6, :cond_3a

    goto :goto_41

    :cond_3a
    if-le v0, v4, :cond_41

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, -0x1

    :cond_41
    :goto_41
    if-eqz v1, :cond_1d

    if-ne v0, v4, :cond_1d

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, -0x1

    goto :goto_1d

    :cond_4b
    if-eqz v1, :cond_52

    if-lt v0, v4, :cond_52

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_52
    return-object v2
.end method
