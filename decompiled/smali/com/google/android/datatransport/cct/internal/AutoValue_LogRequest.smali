.class final Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;
.super Lcom/google/android/datatransport/cct/internal/LogRequest;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest$Builder;
    }
.end annotation


# instance fields
.field private final clientInfo:Lcom/google/android/datatransport/cct/internal/ClientInfo;

.field private final logEvents:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Lcom/google/android/datatransport/cct/internal/LogEvent;",
            ">;"
        }
    .end annotation
.end field

.field private final logSource:Ljava/lang/Integer;

.field private final logSourceName:Ljava/lang/String;

.field private final qosTier:Lcom/google/android/datatransport/cct/internal/QosTier;

.field private final requestTimeMs:J

.field private final requestUptimeMs:J


# direct methods
.method private constructor <init>(JJLcom/google/android/datatransport/cct/internal/ClientInfo;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/google/android/datatransport/cct/internal/QosTier;)V
    .registers 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JJ",
            "Lcom/google/android/datatransport/cct/internal/ClientInfo;",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Lcom/google/android/datatransport/cct/internal/LogEvent;",
            ">;",
            "Lcom/google/android/datatransport/cct/internal/QosTier;",
            ")V"
        }
    .end annotation

    invoke-direct {p0}, Lcom/google/android/datatransport/cct/internal/LogRequest;-><init>()V

    iput-wide p1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->requestTimeMs:J

    iput-wide p3, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->requestUptimeMs:J

    iput-object p5, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->clientInfo:Lcom/google/android/datatransport/cct/internal/ClientInfo;

    iput-object p6, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logSource:Ljava/lang/Integer;

    iput-object p7, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logSourceName:Ljava/lang/String;

    iput-object p8, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logEvents:Ljava/util/List;

    iput-object p9, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->qosTier:Lcom/google/android/datatransport/cct/internal/QosTier;

    return-void
.end method

.method synthetic constructor <init>(JJLcom/google/android/datatransport/cct/internal/ClientInfo;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/google/android/datatransport/cct/internal/QosTier;Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest$1;)V
    .registers 11

    invoke-direct/range {p0 .. p9}, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;-><init>(JJLcom/google/android/datatransport/cct/internal/ClientInfo;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/google/android/datatransport/cct/internal/QosTier;)V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .registers 9

    const/4 v0, 0x1

    if-ne p1, p0, :cond_4

    return v0

    :cond_4
    instance-of v1, p1, Lcom/google/android/datatransport/cct/internal/LogRequest;

    const/4 v2, 0x0

    if-eqz v1, :cond_87

    check-cast p1, Lcom/google/android/datatransport/cct/internal/LogRequest;

    iget-wide v3, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->requestTimeMs:J

    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getRequestTimeMs()J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-nez v1, :cond_85

    iget-wide v3, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->requestUptimeMs:J

    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getRequestUptimeMs()J

    move-result-wide v5

    cmp-long v1, v3, v5

    if-nez v1, :cond_85

    iget-object v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->clientInfo:Lcom/google/android/datatransport/cct/internal/ClientInfo;

    if-nez v1, :cond_2a

    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getClientInfo()Lcom/google/android/datatransport/cct/internal/ClientInfo;

    move-result-object v1

    if-nez v1, :cond_85

    goto :goto_34

    :cond_2a
    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getClientInfo()Lcom/google/android/datatransport/cct/internal/ClientInfo;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_85

    :goto_34
    iget-object v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logSource:Ljava/lang/Integer;

    if-nez v1, :cond_3f

    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getLogSource()Ljava/lang/Integer;

    move-result-object v1

    if-nez v1, :cond_85

    goto :goto_49

    :cond_3f
    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getLogSource()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_85

    :goto_49
    iget-object v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logSourceName:Ljava/lang/String;

    if-nez v1, :cond_54

    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getLogSourceName()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_85

    goto :goto_5e

    :cond_54
    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getLogSourceName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_85

    :goto_5e
    iget-object v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logEvents:Ljava/util/List;

    if-nez v1, :cond_69

    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getLogEvents()Ljava/util/List;

    move-result-object v1

    if-nez v1, :cond_85

    goto :goto_73

    :cond_69
    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getLogEvents()Ljava/util/List;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_85

    :goto_73
    iget-object v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->qosTier:Lcom/google/android/datatransport/cct/internal/QosTier;

    invoke-virtual {p1}, Lcom/google/android/datatransport/cct/internal/LogRequest;->getQosTier()Lcom/google/android/datatransport/cct/internal/QosTier;

    move-result-object p1

    if-nez v1, :cond_7e

    if-nez p1, :cond_85

    goto :goto_86

    :cond_7e
    invoke-virtual {v1, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_85

    goto :goto_86

    :cond_85
    const/4 v0, 0x0

    :goto_86
    return v0

    :cond_87
    return v2
.end method

.method public getClientInfo()Lcom/google/android/datatransport/cct/internal/ClientInfo;
    .registers 2

    iget-object v0, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->clientInfo:Lcom/google/android/datatransport/cct/internal/ClientInfo;

    return-object v0
.end method

.method public getLogEvents()Ljava/util/List;
    .registers 2
    .annotation runtime Lcom/google/firebase/encoders/annotations/Encodable$Field;
        name = "logEvent"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Lcom/google/android/datatransport/cct/internal/LogEvent;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logEvents:Ljava/util/List;

    return-object v0
.end method

.method public getLogSource()Ljava/lang/Integer;
    .registers 2

    iget-object v0, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logSource:Ljava/lang/Integer;

    return-object v0
.end method

.method public getLogSourceName()Ljava/lang/String;
    .registers 2

    iget-object v0, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logSourceName:Ljava/lang/String;

    return-object v0
.end method

.method public getQosTier()Lcom/google/android/datatransport/cct/internal/QosTier;
    .registers 2

    iget-object v0, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->qosTier:Lcom/google/android/datatransport/cct/internal/QosTier;

    return-object v0
.end method

.method public getRequestTimeMs()J
    .registers 3

    iget-wide v0, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->requestTimeMs:J

    return-wide v0
.end method

.method public getRequestUptimeMs()J
    .registers 3

    iget-wide v0, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->requestUptimeMs:J

    return-wide v0
.end method

.method public hashCode()I
    .registers 8

    iget-wide v0, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->requestTimeMs:J

    const/16 v2, 0x20

    ushr-long v3, v0, v2

    xor-long/2addr v0, v3

    long-to-int v1, v0

    const v0, 0xf4243

    xor-int/2addr v1, v0

    mul-int v1, v1, v0

    iget-wide v3, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->requestUptimeMs:J

    ushr-long v5, v3, v2

    xor-long v2, v5, v3

    long-to-int v3, v2

    xor-int/2addr v1, v3

    mul-int v1, v1, v0

    iget-object v2, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->clientInfo:Lcom/google/android/datatransport/cct/internal/ClientInfo;

    const/4 v3, 0x0

    if-nez v2, :cond_1f

    const/4 v2, 0x0

    goto :goto_23

    :cond_1f
    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    :goto_23
    xor-int/2addr v1, v2

    mul-int v1, v1, v0

    iget-object v2, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logSource:Ljava/lang/Integer;

    if-nez v2, :cond_2c

    const/4 v2, 0x0

    goto :goto_30

    :cond_2c
    invoke-virtual {v2}, Ljava/lang/Integer;->hashCode()I

    move-result v2

    :goto_30
    xor-int/2addr v1, v2

    mul-int v1, v1, v0

    iget-object v2, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logSourceName:Ljava/lang/String;

    if-nez v2, :cond_39

    const/4 v2, 0x0

    goto :goto_3d

    :cond_39
    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_3d
    xor-int/2addr v1, v2

    mul-int v1, v1, v0

    iget-object v2, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logEvents:Ljava/util/List;

    if-nez v2, :cond_46

    const/4 v2, 0x0

    goto :goto_4a

    :cond_46
    invoke-interface {v2}, Ljava/util/List;->hashCode()I

    move-result v2

    :goto_4a
    xor-int/2addr v1, v2

    mul-int v1, v1, v0

    iget-object v0, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->qosTier:Lcom/google/android/datatransport/cct/internal/QosTier;

    if-nez v0, :cond_52

    goto :goto_56

    :cond_52
    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v3

    :goto_56
    xor-int v0, v1, v3

    return v0
.end method

.method public toString()Ljava/lang/String;
    .registers 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "LogRequest{requestTimeMs="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->requestTimeMs:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, ", requestUptimeMs="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-wide v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->requestUptimeMs:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v1, ", clientInfo="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->clientInfo:Lcom/google/android/datatransport/cct/internal/ClientInfo;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ", logSource="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logSource:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ", logSourceName="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logSourceName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ", logEvents="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->logEvents:Ljava/util/List;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ", qosTier="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/google/android/datatransport/cct/internal/AutoValue_LogRequest;->qosTier:Lcom/google/android/datatransport/cct/internal/QosTier;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
