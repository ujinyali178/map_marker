.class final Lorg/apache/commons/io/serialization/WildcardClassNameMatcher;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lorg/apache/commons/io/serialization/ClassNameMatcher;


# instance fields
.field private final pattern:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/apache/commons/io/serialization/WildcardClassNameMatcher;->pattern:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public matches(Ljava/lang/String;)Z
    .registers 3

    iget-object v0, p0, Lorg/apache/commons/io/serialization/WildcardClassNameMatcher;->pattern:Ljava/lang/String;

    invoke-static {p1, v0}, Lorg/apache/commons/io/FilenameUtils;->wildcardMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result p1

    return p1
.end method
