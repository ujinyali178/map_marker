.class public Landroidx/exifinterface/media/a;
.super Ljava/lang/Object;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/exifinterface/media/a$c;,
        Landroidx/exifinterface/media/a$b;,
        Landroidx/exifinterface/media/a$g;,
        Landroidx/exifinterface/media/a$e;,
        Landroidx/exifinterface/media/a$d;,
        Landroidx/exifinterface/media/a$f;
    }
.end annotation


# static fields
.field public static final A:[I

.field static final B:[B

.field private static final C:[B

.field private static final D:[B

.field private static final E:[B

.field private static final F:[B

.field private static final G:[B

.field private static final H:[B

.field private static final I:[B

.field private static final J:[B

.field private static final K:[B

.field private static final L:[B

.field private static final M:[B

.field private static final N:[B

.field private static final O:[B

.field private static final P:[B

.field private static final Q:[B

.field private static final R:[B

.field private static final S:[B

.field private static final T:[B

.field private static U:Ljava/text/SimpleDateFormat;

.field private static V:Ljava/text/SimpleDateFormat;

.field static final W:[Ljava/lang/String;

.field static final X:[I

.field static final Y:[B

.field private static final Z:[Landroidx/exifinterface/media/a$e;

.field private static final a0:[Landroidx/exifinterface/media/a$e;

.field private static final b0:[Landroidx/exifinterface/media/a$e;

.field private static final c0:[Landroidx/exifinterface/media/a$e;

.field private static final d0:[Landroidx/exifinterface/media/a$e;

.field private static final e0:Landroidx/exifinterface/media/a$e;

.field private static final f0:[Landroidx/exifinterface/media/a$e;

.field private static final g0:[Landroidx/exifinterface/media/a$e;

.field private static final h0:[Landroidx/exifinterface/media/a$e;

.field private static final i0:[Landroidx/exifinterface/media/a$e;

.field static final j0:[[Landroidx/exifinterface/media/a$e;

.field private static final k0:[Landroidx/exifinterface/media/a$e;

.field private static final l0:[Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/util/HashMap<",
            "Ljava/lang/Integer;",
            "Landroidx/exifinterface/media/a$e;",
            ">;"
        }
    .end annotation
.end field

.field private static final m0:[Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/exifinterface/media/a$e;",
            ">;"
        }
    .end annotation
.end field

.field private static final n0:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final o0:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field static final p0:Ljava/nio/charset/Charset;

.field static final q0:[B

.field private static final r0:[B

.field private static final s0:Ljava/util/regex/Pattern;

.field private static final t0:Ljava/util/regex/Pattern;

.field private static final u0:Ljava/util/regex/Pattern;

.field private static final v:Z

.field private static final v0:Ljava/util/regex/Pattern;

.field private static final w:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final x:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public static final y:[I

.field public static final z:[I


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/io/FileDescriptor;

.field private c:Landroid/content/res/AssetManager$AssetInputStream;

.field private d:I

.field private e:Z

.field private final f:[Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[",
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/exifinterface/media/a$d;",
            ">;"
        }
    .end annotation
.end field

.field private g:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private h:Ljava/nio/ByteOrder;

.field private i:Z

.field private j:Z

.field private k:Z

.field private l:I

.field private m:I

.field private n:[B

.field private o:I

.field private p:I

.field private q:I

.field private r:I

.field private s:I

.field private t:Z

.field private u:Z


# direct methods
.method static constructor <clinit>()V
    .registers 30

    const-string v0, "ExifInterface"

    const/4 v1, 0x3

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    sput-boolean v0, Landroidx/exifinterface/media/a;->v:Z

    const/4 v0, 0x4

    new-array v3, v0, [Ljava/lang/Integer;

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    const/4 v6, 0x0

    aput-object v5, v3, v6

    const/4 v7, 0x6

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v3, v4

    const/4 v8, 0x2

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v2, v3, v8

    const/16 v10, 0x8

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v3, v1

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    sput-object v3, Landroidx/exifinterface/media/a;->w:Ljava/util/List;

    new-array v3, v0, [Ljava/lang/Integer;

    aput-object v9, v3, v6

    const/4 v12, 0x7

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v3, v4

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v14

    aput-object v14, v3, v8

    const/4 v14, 0x5

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    aput-object v15, v3, v1

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    sput-object v3, Landroidx/exifinterface/media/a;->x:Ljava/util/List;

    new-array v3, v1, [I

    fill-array-data v3, :array_cd4

    sput-object v3, Landroidx/exifinterface/media/a;->y:[I

    new-array v3, v4, [I

    aput v0, v3, v6

    sput-object v3, Landroidx/exifinterface/media/a;->z:[I

    new-array v3, v4, [I

    aput v10, v3, v6

    sput-object v3, Landroidx/exifinterface/media/a;->A:[I

    new-array v3, v1, [B

    fill-array-data v3, :array_cde

    sput-object v3, Landroidx/exifinterface/media/a;->B:[B

    new-array v3, v0, [B

    fill-array-data v3, :array_ce4

    sput-object v3, Landroidx/exifinterface/media/a;->C:[B

    new-array v3, v0, [B

    fill-array-data v3, :array_cea

    sput-object v3, Landroidx/exifinterface/media/a;->D:[B

    new-array v3, v0, [B

    fill-array-data v3, :array_cf0

    sput-object v3, Landroidx/exifinterface/media/a;->E:[B

    new-array v3, v7, [B

    fill-array-data v3, :array_cf6

    sput-object v3, Landroidx/exifinterface/media/a;->F:[B

    const/16 v3, 0xa

    new-array v12, v3, [B

    fill-array-data v12, :array_cfe

    sput-object v12, Landroidx/exifinterface/media/a;->G:[B

    new-array v12, v10, [B

    fill-array-data v12, :array_d08

    sput-object v12, Landroidx/exifinterface/media/a;->H:[B

    new-array v12, v0, [B

    fill-array-data v12, :array_d10

    sput-object v12, Landroidx/exifinterface/media/a;->I:[B

    new-array v12, v0, [B

    fill-array-data v12, :array_d16

    sput-object v12, Landroidx/exifinterface/media/a;->J:[B

    new-array v12, v0, [B

    fill-array-data v12, :array_d1c

    sput-object v12, Landroidx/exifinterface/media/a;->K:[B

    new-array v12, v0, [B

    fill-array-data v12, :array_d22

    sput-object v12, Landroidx/exifinterface/media/a;->L:[B

    new-array v12, v0, [B

    fill-array-data v12, :array_d28

    sput-object v12, Landroidx/exifinterface/media/a;->M:[B

    new-array v12, v0, [B

    fill-array-data v12, :array_d2e

    sput-object v12, Landroidx/exifinterface/media/a;->N:[B

    new-array v12, v1, [B

    fill-array-data v12, :array_d34

    sput-object v12, Landroidx/exifinterface/media/a;->O:[B

    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v12

    const-string v3, "VP8X"

    invoke-virtual {v3, v12}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v3

    sput-object v3, Landroidx/exifinterface/media/a;->P:[B

    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v3

    const-string v12, "VP8L"

    invoke-virtual {v12, v3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v3

    sput-object v3, Landroidx/exifinterface/media/a;->Q:[B

    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v3

    const-string v12, "VP8 "

    invoke-virtual {v12, v3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v3

    sput-object v3, Landroidx/exifinterface/media/a;->R:[B

    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v3

    const-string v12, "ANIM"

    invoke-virtual {v12, v3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v3

    sput-object v3, Landroidx/exifinterface/media/a;->S:[B

    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v3

    const-string v12, "ANMF"

    invoke-virtual {v12, v3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v3

    sput-object v3, Landroidx/exifinterface/media/a;->T:[B

    const-string v16, ""

    const-string v17, "BYTE"

    const-string v18, "STRING"

    const-string v19, "USHORT"

    const-string v20, "ULONG"

    const-string v21, "URATIONAL"

    const-string v22, "SBYTE"

    const-string v23, "UNDEFINED"

    const-string v24, "SSHORT"

    const-string v25, "SLONG"

    const-string v26, "SRATIONAL"

    const-string v27, "SINGLE"

    const-string v28, "DOUBLE"

    const-string v29, "IFD"

    filled-new-array/range {v16 .. v29}, [Ljava/lang/String;

    move-result-object v3

    sput-object v3, Landroidx/exifinterface/media/a;->W:[Ljava/lang/String;

    const/16 v3, 0xe

    new-array v12, v3, [I

    fill-array-data v12, :array_d3a

    sput-object v12, Landroidx/exifinterface/media/a;->X:[I

    new-array v12, v10, [B

    fill-array-data v12, :array_d5a

    sput-object v12, Landroidx/exifinterface/media/a;->Y:[B

    const/16 v12, 0x2a

    new-array v12, v12, [Landroidx/exifinterface/media/a$e;

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "NewSubfileType"

    const/16 v7, 0xfe

    invoke-direct {v3, v10, v7, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "SubfileType"

    const/16 v10, 0xff

    invoke-direct {v3, v7, v10, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v3, v12, v4

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "ImageWidth"

    const/16 v10, 0x100

    invoke-direct {v3, v7, v10, v1, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    aput-object v3, v12, v8

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "ImageLength"

    const/16 v10, 0x101

    invoke-direct {v3, v7, v10, v1, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    aput-object v3, v12, v1

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "BitsPerSample"

    const/16 v10, 0x102

    invoke-direct {v3, v7, v10, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v3, v12, v0

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "Compression"

    const/16 v10, 0x103

    invoke-direct {v3, v7, v10, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v3, v12, v14

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "PhotometricInterpretation"

    const/16 v10, 0x106

    invoke-direct {v3, v7, v10, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v7, 0x6

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "ImageDescription"

    const/16 v10, 0x10e

    invoke-direct {v3, v7, v10, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v7, 0x7

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "Make"

    const/16 v10, 0x10f

    invoke-direct {v3, v7, v10, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0x8

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "Model"

    const/16 v10, 0x110

    invoke-direct {v3, v7, v10, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0x9

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "StripOffsets"

    const/16 v7, 0x111

    invoke-direct {v3, v10, v7, v1, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/16 v7, 0xa

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "Orientation"

    const/16 v10, 0x112

    invoke-direct {v3, v7, v10, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0xb

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "SamplesPerPixel"

    const/16 v7, 0x115

    invoke-direct {v3, v10, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0xc

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "RowsPerStrip"

    const/16 v7, 0x116

    invoke-direct {v3, v10, v7, v1, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/16 v7, 0xd

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "StripByteCounts"

    const/16 v7, 0x117

    invoke-direct {v3, v10, v7, v1, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/16 v7, 0xe

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "XResolution"

    const/16 v10, 0x11a

    invoke-direct {v3, v7, v10, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0xf

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "YResolution"

    const/16 v7, 0x11b

    invoke-direct {v3, v10, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0x10

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "PlanarConfiguration"

    const/16 v7, 0x11c

    invoke-direct {v3, v10, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0x11

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "ResolutionUnit"

    const/16 v7, 0x128

    invoke-direct {v3, v10, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0x12

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "TransferFunction"

    const/16 v7, 0x12d

    invoke-direct {v3, v10, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0x13

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "Software"

    const/16 v7, 0x131

    invoke-direct {v3, v10, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0x14

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "DateTime"

    const/16 v7, 0x132

    invoke-direct {v3, v10, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0x15

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "Artist"

    const/16 v10, 0x13b

    invoke-direct {v3, v7, v10, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0x16

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v7, "WhitePoint"

    const/16 v10, 0x13e

    invoke-direct {v3, v7, v10, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v7, 0x17

    aput-object v3, v12, v7

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v10, "PrimaryChromaticities"

    const/16 v6, 0x13f

    invoke-direct {v3, v10, v6, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x18

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "SubIFDPointer"

    const/16 v10, 0x14a

    invoke-direct {v3, v6, v10, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x19

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "JPEGInterchangeFormat"

    const/16 v10, 0x201

    invoke-direct {v3, v6, v10, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1a

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "JPEGInterchangeFormatLength"

    const/16 v10, 0x202

    invoke-direct {v3, v6, v10, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1b

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "YCbCrCoefficients"

    const/16 v10, 0x211

    invoke-direct {v3, v6, v10, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1c

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "YCbCrSubSampling"

    const/16 v10, 0x212

    invoke-direct {v3, v6, v10, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1d

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "YCbCrPositioning"

    const/16 v10, 0x213

    invoke-direct {v3, v6, v10, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1e

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "ReferenceBlackWhite"

    const/16 v10, 0x214

    invoke-direct {v3, v6, v10, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1f

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "Copyright"

    const v10, 0x8298

    invoke-direct {v3, v6, v10, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x20

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "ExifIFDPointer"

    const v10, 0x8769

    invoke-direct {v3, v6, v10, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x21

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSInfoIFDPointer"

    const v10, 0x8825

    invoke-direct {v3, v6, v10, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x22

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "SensorTopBorder"

    invoke-direct {v3, v6, v0, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x23

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "SensorLeftBorder"

    invoke-direct {v3, v6, v14, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x24

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "SensorBottomBorder"

    const/4 v10, 0x6

    invoke-direct {v3, v6, v10, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x25

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "SensorRightBorder"

    const/4 v10, 0x7

    invoke-direct {v3, v6, v10, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x26

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "ISO"

    invoke-direct {v3, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x27

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "JpgFromRaw"

    const/16 v7, 0x2e

    invoke-direct {v3, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x28

    aput-object v3, v12, v6

    new-instance v3, Landroidx/exifinterface/media/a$e;

    const-string v6, "Xmp"

    const/16 v7, 0x2bc

    invoke-direct {v3, v6, v7, v4}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x29

    aput-object v3, v12, v6

    sput-object v12, Landroidx/exifinterface/media/a;->Z:[Landroidx/exifinterface/media/a$e;

    const/16 v3, 0x4a

    new-array v3, v3, [Landroidx/exifinterface/media/a$e;

    new-instance v6, Landroidx/exifinterface/media/a$e;

    const-string v7, "ExposureTime"

    const v10, 0x829a

    invoke-direct {v6, v7, v10, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v7, 0x0

    aput-object v6, v3, v7

    new-instance v6, Landroidx/exifinterface/media/a$e;

    const-string v7, "FNumber"

    const v10, 0x829d

    invoke-direct {v6, v7, v10, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v6, v3, v4

    new-instance v6, Landroidx/exifinterface/media/a$e;

    const-string v7, "ExposureProgram"

    const v10, 0x8822

    invoke-direct {v6, v7, v10, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v6, v3, v8

    new-instance v6, Landroidx/exifinterface/media/a$e;

    const-string v7, "SpectralSensitivity"

    const v10, 0x8824

    invoke-direct {v6, v7, v10, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v6, v3, v1

    new-instance v6, Landroidx/exifinterface/media/a$e;

    const-string v7, "PhotographicSensitivity"

    const v10, 0x8827

    invoke-direct {v6, v7, v10, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v6, v3, v0

    new-instance v6, Landroidx/exifinterface/media/a$e;

    const-string v7, "OECF"

    const v10, 0x8828

    const/4 v4, 0x7

    invoke-direct {v6, v7, v10, v4}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v6, v3, v14

    new-instance v6, Landroidx/exifinterface/media/a$e;

    const-string v7, "SensitivityType"

    const v10, 0x8830

    invoke-direct {v6, v7, v10, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v7, 0x6

    aput-object v6, v3, v7

    new-instance v6, Landroidx/exifinterface/media/a$e;

    const-string v7, "StandardOutputSensitivity"

    const v10, 0x8831

    invoke-direct {v6, v7, v10, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v6, v3, v4

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "RecommendedExposureIndex"

    const v7, 0x8832

    invoke-direct {v4, v6, v7, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x8

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ISOSpeed"

    const v7, 0x8833

    invoke-direct {v4, v6, v7, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x9

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ISOSpeedLatitudeyyy"

    const v7, 0x8834

    invoke-direct {v4, v6, v7, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0xa

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ISOSpeedLatitudezzz"

    const v7, 0x8835

    invoke-direct {v4, v6, v7, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0xb

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ExifVersion"

    const v7, 0x9000

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0xc

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "DateTimeOriginal"

    const v7, 0x9003

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0xd

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "DateTimeDigitized"

    const v7, 0x9004

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0xe

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "OffsetTime"

    const v7, 0x9010

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0xf

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "OffsetTimeOriginal"

    const v7, 0x9011

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x10

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "OffsetTimeDigitized"

    const v7, 0x9012

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x11

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ComponentsConfiguration"

    const v7, 0x9101

    const/4 v10, 0x7

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x12

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "CompressedBitsPerPixel"

    const v7, 0x9102

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x13

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ShutterSpeedValue"

    const v7, 0x9201

    const/16 v10, 0xa

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x14

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ApertureValue"

    const v7, 0x9202

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x15

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "BrightnessValue"

    const v7, 0x9203

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x16

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ExposureBiasValue"

    const v7, 0x9204

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x17

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "MaxApertureValue"

    const v7, 0x9205

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x18

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SubjectDistance"

    const v7, 0x9206

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x19

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "MeteringMode"

    const v7, 0x9207

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1a

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "LightSource"

    const v7, 0x9208

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1b

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "Flash"

    const v7, 0x9209

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1c

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "FocalLength"

    const v7, 0x920a

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1d

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SubjectArea"

    const v7, 0x9214

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1e

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "MakerNote"

    const v7, 0x927c

    const/4 v10, 0x7

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1f

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "UserComment"

    const v7, 0x9286

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x20

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SubSecTime"

    const v7, 0x9290

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x21

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SubSecTimeOriginal"

    const v7, 0x9291

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x22

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SubSecTimeDigitized"

    const v7, 0x9292

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x23

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "FlashpixVersion"

    const v7, 0xa000

    const/4 v10, 0x7

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x24

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ColorSpace"

    const v7, 0xa001

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x25

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "PixelXDimension"

    const v7, 0xa002

    invoke-direct {v4, v6, v7, v1, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/16 v6, 0x26

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "PixelYDimension"

    const v7, 0xa003

    invoke-direct {v4, v6, v7, v1, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/16 v6, 0x27

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "RelatedSoundFile"

    const v7, 0xa004

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x28

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "InteroperabilityIFDPointer"

    const v7, 0xa005

    invoke-direct {v4, v6, v7, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x29

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "FlashEnergy"

    const v7, 0xa20b

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x2a

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SpatialFrequencyResponse"

    const v7, 0xa20c

    const/4 v10, 0x7

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x2b

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "FocalPlaneXResolution"

    const v7, 0xa20e

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x2c

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "FocalPlaneYResolution"

    const v7, 0xa20f

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x2d

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "FocalPlaneResolutionUnit"

    const v7, 0xa210

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x2e

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SubjectLocation"

    const v7, 0xa214

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x2f

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ExposureIndex"

    const v7, 0xa215

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x30

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SensingMethod"

    const v7, 0xa217

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x31

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "FileSource"

    const v7, 0xa300

    const/4 v10, 0x7

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x32

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SceneType"

    const v7, 0xa301

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x33

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "CFAPattern"

    const v7, 0xa302

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x34

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "CustomRendered"

    const v7, 0xa401

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x35

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ExposureMode"

    const v7, 0xa402

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x36

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "WhiteBalance"

    const v7, 0xa403

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x37

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "DigitalZoomRatio"

    const v7, 0xa404

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x38

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "FocalLengthIn35mmFilm"

    const v7, 0xa405

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x39

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SceneCaptureType"

    const v7, 0xa406

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x3a

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "GainControl"

    const v7, 0xa407

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x3b

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "Contrast"

    const v7, 0xa408

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x3c

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "Saturation"

    const v7, 0xa409

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x3d

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "Sharpness"

    const v7, 0xa40a

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x3e

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "DeviceSettingDescription"

    const v7, 0xa40b

    const/4 v10, 0x7

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x3f

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "SubjectDistanceRange"

    const v7, 0xa40c

    invoke-direct {v4, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x40

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "ImageUniqueID"

    const v7, 0xa420

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x41

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "CameraOwnerName"

    const v7, 0xa430

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x42

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "BodySerialNumber"

    const v7, 0xa431

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x43

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "LensSpecification"

    const v7, 0xa432

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x44

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "LensMake"

    const v7, 0xa433

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x45

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "LensModel"

    const v7, 0xa434

    invoke-direct {v4, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x46

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "Gamma"

    const v7, 0xa500

    invoke-direct {v4, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x47

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "DNGVersion"

    const v7, 0xc612

    const/4 v10, 0x1

    invoke-direct {v4, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x48

    aput-object v4, v3, v6

    new-instance v4, Landroidx/exifinterface/media/a$e;

    const-string v6, "DefaultCropSize"

    const v7, 0xc620

    invoke-direct {v4, v6, v7, v1, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/16 v6, 0x49

    aput-object v4, v3, v6

    sput-object v3, Landroidx/exifinterface/media/a;->a0:[Landroidx/exifinterface/media/a$e;

    const/16 v4, 0x20

    new-array v4, v4, [Landroidx/exifinterface/media/a$e;

    new-instance v6, Landroidx/exifinterface/media/a$e;

    const-string v7, "GPSVersionID"

    const/4 v0, 0x1

    const/4 v10, 0x0

    invoke-direct {v6, v7, v10, v0}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v6, v4, v10

    new-instance v6, Landroidx/exifinterface/media/a$e;

    const-string v7, "GPSLatitudeRef"

    invoke-direct {v6, v7, v0, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v6, v4, v0

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSLatitude"

    const/16 v7, 0xa

    invoke-direct {v0, v6, v8, v14, v7}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    aput-object v0, v4, v8

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSLongitudeRef"

    invoke-direct {v0, v6, v1, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSLongitude"

    const/4 v10, 0x4

    invoke-direct {v0, v6, v10, v14, v7}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    aput-object v0, v4, v10

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSAltitudeRef"

    const/4 v7, 0x1

    invoke-direct {v0, v6, v14, v7}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v14

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSAltitude"

    const/4 v7, 0x6

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSTimeStamp"

    const/4 v7, 0x7

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSSatellites"

    const/16 v7, 0x8

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSStatus"

    const/16 v7, 0x9

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSMeasureMode"

    const/16 v7, 0xa

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDOP"

    const/16 v7, 0xb

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSSpeedRef"

    const/16 v7, 0xc

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSSpeed"

    const/16 v7, 0xd

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSTrackRef"

    const/16 v7, 0xe

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSTrack"

    const/16 v7, 0xf

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSImgDirectionRef"

    const/16 v7, 0x10

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSImgDirection"

    const/16 v7, 0x11

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSMapDatum"

    const/16 v7, 0x12

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDestLatitudeRef"

    const/16 v7, 0x13

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDestLatitude"

    const/16 v7, 0x14

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDestLongitudeRef"

    const/16 v7, 0x15

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x15

    aput-object v0, v4, v6

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDestLongitude"

    const/16 v7, 0x16

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x16

    aput-object v0, v4, v6

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDestBearingRef"

    const/16 v7, 0x17

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v4, v7

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDestBearing"

    const/16 v7, 0x18

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x18

    aput-object v0, v4, v6

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDestDistanceRef"

    const/16 v7, 0x19

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x19

    aput-object v0, v4, v6

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDestDistance"

    const/16 v7, 0x1a

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1a

    aput-object v0, v4, v6

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSProcessingMethod"

    const/16 v7, 0x1b

    const/4 v10, 0x7

    invoke-direct {v0, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1b

    aput-object v0, v4, v6

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSAreaInformation"

    const/16 v7, 0x1c

    invoke-direct {v0, v6, v7, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1c

    aput-object v0, v4, v6

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDateStamp"

    const/16 v7, 0x1d

    invoke-direct {v0, v6, v7, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1d

    aput-object v0, v4, v6

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSDifferential"

    const/16 v7, 0x1e

    invoke-direct {v0, v6, v7, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1e

    aput-object v0, v4, v6

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v6, "GPSHPositioningError"

    const/16 v7, 0x1f

    invoke-direct {v0, v6, v7, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v6, 0x1f

    aput-object v0, v4, v6

    sput-object v4, Landroidx/exifinterface/media/a;->b0:[Landroidx/exifinterface/media/a$e;

    const/4 v0, 0x1

    new-array v6, v0, [Landroidx/exifinterface/media/a$e;

    new-instance v7, Landroidx/exifinterface/media/a$e;

    const-string v10, "InteroperabilityIndex"

    invoke-direct {v7, v10, v0, v8}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v0, 0x0

    aput-object v7, v6, v0

    sput-object v6, Landroidx/exifinterface/media/a;->c0:[Landroidx/exifinterface/media/a$e;

    const/16 v7, 0x25

    new-array v7, v7, [Landroidx/exifinterface/media/a$e;

    new-instance v10, Landroidx/exifinterface/media/a$e;

    const-string v14, "NewSubfileType"

    const/16 v8, 0xfe

    const/4 v1, 0x4

    invoke-direct {v10, v14, v8, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v10, v7, v0

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v8, "SubfileType"

    const/16 v10, 0xff

    invoke-direct {v0, v8, v10, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v8, 0x1

    aput-object v0, v7, v8

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v8, "ThumbnailImageWidth"

    const/16 v10, 0x100

    const/4 v14, 0x3

    invoke-direct {v0, v8, v10, v14, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/4 v8, 0x2

    aput-object v0, v7, v8

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v8, "ThumbnailImageLength"

    const/16 v10, 0x101

    invoke-direct {v0, v8, v10, v14, v1}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    aput-object v0, v7, v14

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v8, "BitsPerSample"

    const/16 v10, 0x102

    invoke-direct {v0, v8, v10, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "Compression"

    const/16 v8, 0x103

    invoke-direct {v0, v1, v8, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v1, 0x5

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "PhotometricInterpretation"

    const/16 v8, 0x106

    invoke-direct {v0, v1, v8, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v1, 0x6

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "ImageDescription"

    const/16 v8, 0x10e

    const/4 v10, 0x2

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v1, 0x7

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "Make"

    const/16 v8, 0x10f

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x8

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "Model"

    const/16 v8, 0x110

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x9

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "StripOffsets"

    const/16 v8, 0x111

    const/4 v10, 0x4

    const/4 v14, 0x3

    invoke-direct {v0, v1, v8, v14, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/16 v1, 0xa

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "ThumbnailOrientation"

    const/16 v8, 0x112

    invoke-direct {v0, v1, v8, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0xb

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "SamplesPerPixel"

    const/16 v8, 0x115

    invoke-direct {v0, v1, v8, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0xc

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "RowsPerStrip"

    const/16 v8, 0x116

    const/4 v10, 0x4

    invoke-direct {v0, v1, v8, v14, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/16 v1, 0xd

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "StripByteCounts"

    const/16 v8, 0x117

    invoke-direct {v0, v1, v8, v14, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/16 v1, 0xe

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "XResolution"

    const/16 v8, 0x11a

    const/4 v10, 0x5

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0xf

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "YResolution"

    const/16 v8, 0x11b

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x10

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "PlanarConfiguration"

    const/16 v8, 0x11c

    const/4 v10, 0x3

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x11

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "ResolutionUnit"

    const/16 v8, 0x128

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x12

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "TransferFunction"

    const/16 v8, 0x12d

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x13

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "Software"

    const/16 v8, 0x131

    const/4 v10, 0x2

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x14

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "DateTime"

    const/16 v8, 0x132

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x15

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "Artist"

    const/16 v8, 0x13b

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x16

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "WhitePoint"

    const/16 v8, 0x13e

    const/4 v10, 0x5

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x17

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "PrimaryChromaticities"

    const/16 v8, 0x13f

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x18

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "SubIFDPointer"

    const/16 v8, 0x14a

    const/4 v10, 0x4

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x19

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "JPEGInterchangeFormat"

    const/16 v8, 0x201

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x1a

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "JPEGInterchangeFormatLength"

    const/16 v8, 0x202

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x1b

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "YCbCrCoefficients"

    const/16 v8, 0x211

    const/4 v10, 0x5

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x1c

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "YCbCrSubSampling"

    const/16 v8, 0x212

    const/4 v10, 0x3

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x1d

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "YCbCrPositioning"

    const/16 v8, 0x213

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x1e

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "ReferenceBlackWhite"

    const/16 v8, 0x214

    const/4 v10, 0x5

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x1f

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "Copyright"

    const v8, 0x8298

    const/4 v10, 0x2

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x20

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "ExifIFDPointer"

    const v8, 0x8769

    const/4 v10, 0x4

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x21

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "GPSInfoIFDPointer"

    const v8, 0x8825

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x22

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "DNGVersion"

    const v8, 0xc612

    const/4 v10, 0x1

    invoke-direct {v0, v1, v8, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/16 v1, 0x23

    aput-object v0, v7, v1

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "DefaultCropSize"

    const v8, 0xc620

    const/4 v10, 0x4

    const/4 v14, 0x3

    invoke-direct {v0, v1, v8, v14, v10}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;III)V

    const/16 v1, 0x24

    aput-object v0, v7, v1

    sput-object v7, Landroidx/exifinterface/media/a;->d0:[Landroidx/exifinterface/media/a$e;

    new-instance v0, Landroidx/exifinterface/media/a$e;

    const-string v1, "StripOffsets"

    const/16 v8, 0x111

    invoke-direct {v0, v1, v8, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    sput-object v0, Landroidx/exifinterface/media/a;->e0:Landroidx/exifinterface/media/a$e;

    new-array v0, v14, [Landroidx/exifinterface/media/a$e;

    new-instance v1, Landroidx/exifinterface/media/a$e;

    const-string v8, "ThumbnailImage"

    const/16 v10, 0x100

    const/4 v14, 0x7

    invoke-direct {v1, v8, v10, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v8, 0x0

    aput-object v1, v0, v8

    new-instance v1, Landroidx/exifinterface/media/a$e;

    const-string v8, "CameraSettingsIFDPointer"

    const/16 v10, 0x2020

    const/4 v14, 0x4

    invoke-direct {v1, v8, v10, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v8, 0x1

    aput-object v1, v0, v8

    new-instance v1, Landroidx/exifinterface/media/a$e;

    const-string v8, "ImageProcessingIFDPointer"

    const/16 v10, 0x2040

    invoke-direct {v1, v8, v10, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v8, 0x2

    aput-object v1, v0, v8

    sput-object v0, Landroidx/exifinterface/media/a;->f0:[Landroidx/exifinterface/media/a$e;

    new-array v1, v8, [Landroidx/exifinterface/media/a$e;

    new-instance v8, Landroidx/exifinterface/media/a$e;

    const-string v10, "PreviewImageStart"

    move-object/from16 v16, v11

    const/16 v11, 0x101

    invoke-direct {v8, v10, v11, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v10, 0x0

    aput-object v8, v1, v10

    new-instance v8, Landroidx/exifinterface/media/a$e;

    const-string v10, "PreviewImageLength"

    const/16 v11, 0x102

    invoke-direct {v8, v10, v11, v14}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v10, 0x1

    aput-object v8, v1, v10

    sput-object v1, Landroidx/exifinterface/media/a;->g0:[Landroidx/exifinterface/media/a$e;

    new-array v8, v10, [Landroidx/exifinterface/media/a$e;

    new-instance v11, Landroidx/exifinterface/media/a$e;

    const-string v14, "AspectFrame"

    const/16 v10, 0x1113

    move-object/from16 v20, v13

    const/4 v13, 0x3

    invoke-direct {v11, v14, v10, v13}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v10, 0x0

    aput-object v11, v8, v10

    sput-object v8, Landroidx/exifinterface/media/a;->h0:[Landroidx/exifinterface/media/a$e;

    const/4 v11, 0x1

    new-array v14, v11, [Landroidx/exifinterface/media/a$e;

    new-instance v11, Landroidx/exifinterface/media/a$e;

    const-string v10, "ColorSpace"

    move-object/from16 v21, v2

    const/16 v2, 0x37

    invoke-direct {v11, v10, v2, v13}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v2, 0x0

    aput-object v11, v14, v2

    sput-object v14, Landroidx/exifinterface/media/a;->i0:[Landroidx/exifinterface/media/a$e;

    const/16 v10, 0xa

    new-array v10, v10, [[Landroidx/exifinterface/media/a$e;

    aput-object v12, v10, v2

    const/4 v2, 0x1

    aput-object v3, v10, v2

    const/4 v2, 0x2

    aput-object v4, v10, v2

    aput-object v6, v10, v13

    const/4 v2, 0x4

    aput-object v7, v10, v2

    const/4 v3, 0x5

    aput-object v12, v10, v3

    const/4 v3, 0x6

    aput-object v0, v10, v3

    const/4 v0, 0x7

    aput-object v1, v10, v0

    const/16 v0, 0x8

    aput-object v8, v10, v0

    const/16 v0, 0x9

    aput-object v14, v10, v0

    sput-object v10, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    new-array v0, v3, [Landroidx/exifinterface/media/a$e;

    new-instance v1, Landroidx/exifinterface/media/a$e;

    const-string v3, "SubIFDPointer"

    const/16 v4, 0x14a

    invoke-direct {v1, v3, v4, v2}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v3, 0x0

    aput-object v1, v0, v3

    new-instance v1, Landroidx/exifinterface/media/a$e;

    const-string v3, "ExifIFDPointer"

    const v4, 0x8769

    invoke-direct {v1, v3, v4, v2}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v3, 0x1

    aput-object v1, v0, v3

    new-instance v1, Landroidx/exifinterface/media/a$e;

    const-string v3, "GPSInfoIFDPointer"

    const v4, 0x8825

    invoke-direct {v1, v3, v4, v2}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v3, 0x2

    aput-object v1, v0, v3

    new-instance v1, Landroidx/exifinterface/media/a$e;

    const-string v3, "InteroperabilityIFDPointer"

    const v4, 0xa005

    invoke-direct {v1, v3, v4, v2}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v3, 0x3

    aput-object v1, v0, v3

    new-instance v1, Landroidx/exifinterface/media/a$e;

    const-string v3, "CameraSettingsIFDPointer"

    const/16 v4, 0x2020

    const/4 v6, 0x1

    invoke-direct {v1, v3, v4, v6}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    aput-object v1, v0, v2

    new-instance v1, Landroidx/exifinterface/media/a$e;

    const-string v2, "ImageProcessingIFDPointer"

    const/16 v3, 0x2040

    invoke-direct {v1, v2, v3, v6}, Landroidx/exifinterface/media/a$e;-><init>(Ljava/lang/String;II)V

    const/4 v2, 0x5

    aput-object v1, v0, v2

    sput-object v0, Landroidx/exifinterface/media/a;->k0:[Landroidx/exifinterface/media/a$e;

    array-length v0, v10

    new-array v0, v0, [Ljava/util/HashMap;

    sput-object v0, Landroidx/exifinterface/media/a;->l0:[Ljava/util/HashMap;

    array-length v0, v10

    new-array v0, v0, [Ljava/util/HashMap;

    sput-object v0, Landroidx/exifinterface/media/a;->m0:[Ljava/util/HashMap;

    new-instance v0, Ljava/util/HashSet;

    const-string v1, "FNumber"

    const-string v2, "DigitalZoomRatio"

    const-string v3, "ExposureTime"

    const-string v4, "SubjectDistance"

    const-string v6, "GPSTimeStamp"

    filled-new-array {v1, v2, v3, v4, v6}, [Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    sput-object v0, Landroidx/exifinterface/media/a;->n0:Ljava/util/HashSet;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Landroidx/exifinterface/media/a;->o0:Ljava/util/HashMap;

    const-string v0, "US-ASCII"

    invoke-static {v0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v0

    sput-object v0, Landroidx/exifinterface/media/a;->p0:Ljava/nio/charset/Charset;

    const-string v1, "Exif\u0000\u0000"

    invoke-virtual {v1, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v1

    sput-object v1, Landroidx/exifinterface/media/a;->q0:[B

    const-string v1, "http://ns.adobe.com/xap/1.0/\u0000"

    invoke-virtual {v1, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v0

    sput-object v0, Landroidx/exifinterface/media/a;->r0:[B

    new-instance v0, Ljava/text/SimpleDateFormat;

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v2, "yyyy:MM:dd HH:mm:ss"

    invoke-direct {v0, v2, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    sput-object v0, Landroidx/exifinterface/media/a;->U:Ljava/text/SimpleDateFormat;

    const-string v2, "UTC"

    invoke-static {v2}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/text/DateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v2, "yyyy-MM-dd HH:mm:ss"

    invoke-direct {v0, v2, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    sput-object v0, Landroidx/exifinterface/media/a;->V:Ljava/text/SimpleDateFormat;

    const-string v1, "UTC"

    invoke-static {v1}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/text/DateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    const/4 v7, 0x0

    :goto_c25
    sget-object v0, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v1, v0

    if-ge v7, v1, :cond_c60

    sget-object v1, Landroidx/exifinterface/media/a;->l0:[Ljava/util/HashMap;

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    aput-object v2, v1, v7

    sget-object v1, Landroidx/exifinterface/media/a;->m0:[Ljava/util/HashMap;

    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    aput-object v2, v1, v7

    aget-object v0, v0, v7

    array-length v1, v0

    const/4 v2, 0x0

    :goto_c40
    if-ge v2, v1, :cond_c5d

    aget-object v3, v0, v2

    sget-object v4, Landroidx/exifinterface/media/a;->l0:[Ljava/util/HashMap;

    aget-object v4, v4, v7

    iget v6, v3, Landroidx/exifinterface/media/a$e;->a:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v4, v6, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v4, Landroidx/exifinterface/media/a;->m0:[Ljava/util/HashMap;

    aget-object v4, v4, v7

    iget-object v6, v3, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    invoke-virtual {v4, v6, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v2, v2, 0x1

    goto :goto_c40

    :cond_c5d
    add-int/lit8 v7, v7, 0x1

    goto :goto_c25

    :cond_c60
    sget-object v0, Landroidx/exifinterface/media/a;->o0:Ljava/util/HashMap;

    sget-object v1, Landroidx/exifinterface/media/a;->k0:[Landroidx/exifinterface/media/a$e;

    const/4 v2, 0x0

    aget-object v2, v1, v2

    iget v2, v2, Landroidx/exifinterface/media/a$e;->a:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v2, 0x1

    aget-object v2, v1, v2

    iget v2, v2, Landroidx/exifinterface/media/a$e;->a:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v2, 0x2

    aget-object v2, v1, v2

    iget v2, v2, Landroidx/exifinterface/media/a$e;->a:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v2, 0x3

    aget-object v2, v1, v2

    iget v2, v2, Landroidx/exifinterface/media/a$e;->a:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    move-object/from16 v3, v21

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v2, 0x4

    aget-object v2, v1, v2

    iget v2, v2, Landroidx/exifinterface/media/a$e;->a:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    move-object/from16 v3, v20

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const/4 v2, 0x5

    aget-object v1, v1, v2

    iget v1, v1, Landroidx/exifinterface/media/a$e;->a:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    move-object/from16 v2, v16

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, ".*[1-9].*"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/exifinterface/media/a;->s0:Ljava/util/regex/Pattern;

    const-string v0, "^(\\d{2}):(\\d{2}):(\\d{2})$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/exifinterface/media/a;->t0:Ljava/util/regex/Pattern;

    const-string v0, "^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/exifinterface/media/a;->u0:Ljava/util/regex/Pattern;

    const-string v0, "^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Landroidx/exifinterface/media/a;->v0:Ljava/util/regex/Pattern;

    return-void

    nop

    :array_cd4
    .array-data 4
        0x8
        0x8
        0x8
    .end array-data

    :array_cde
    .array-data 1
        -0x1t
        -0x28t
        -0x1t
    .end array-data

    :array_ce4
    .array-data 1
        0x66t
        0x74t
        0x79t
        0x70t
    .end array-data

    :array_cea
    .array-data 1
        0x6dt
        0x69t
        0x66t
        0x31t
    .end array-data

    :array_cf0
    .array-data 1
        0x68t
        0x65t
        0x69t
        0x63t
    .end array-data

    :array_cf6
    .array-data 1
        0x4ft
        0x4ct
        0x59t
        0x4dt
        0x50t
        0x0t
    .end array-data

    nop

    :array_cfe
    .array-data 1
        0x4ft
        0x4ct
        0x59t
        0x4dt
        0x50t
        0x55t
        0x53t
        0x0t
        0x49t
        0x49t
    .end array-data

    nop

    :array_d08
    .array-data 1
        -0x77t
        0x50t
        0x4et
        0x47t
        0xdt
        0xat
        0x1at
        0xat
    .end array-data

    :array_d10
    .array-data 1
        0x65t
        0x58t
        0x49t
        0x66t
    .end array-data

    :array_d16
    .array-data 1
        0x49t
        0x48t
        0x44t
        0x52t
    .end array-data

    :array_d1c
    .array-data 1
        0x49t
        0x45t
        0x4et
        0x44t
    .end array-data

    :array_d22
    .array-data 1
        0x52t
        0x49t
        0x46t
        0x46t
    .end array-data

    :array_d28
    .array-data 1
        0x57t
        0x45t
        0x42t
        0x50t
    .end array-data

    :array_d2e
    .array-data 1
        0x45t
        0x58t
        0x49t
        0x46t
    .end array-data

    :array_d34
    .array-data 1
        -0x63t
        0x1t
        0x2at
    .end array-data

    :array_d3a
    .array-data 4
        0x0
        0x1
        0x1
        0x2
        0x4
        0x8
        0x1
        0x1
        0x2
        0x4
        0x8
        0x4
        0x8
        0x1
    .end array-data

    :array_d5a
    .array-data 1
        0x41t
        0x53t
        0x43t
        0x49t
        0x49t
        0x0t
        0x0t
        0x0t
    .end array-data
.end method

.method public constructor <init>(Ljava/io/InputStream;)V
    .registers 3

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroidx/exifinterface/media/a;-><init>(Ljava/io/InputStream;I)V

    return-void
.end method

.method public constructor <init>(Ljava/io/InputStream;I)V
    .registers 6

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v1, v0

    new-array v1, v1, [Ljava/util/HashMap;

    iput-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    new-instance v1, Ljava/util/HashSet;

    array-length v0, v0

    invoke-direct {v1, v0}, Ljava/util/HashSet;-><init>(I)V

    iput-object v1, p0, Landroidx/exifinterface/media/a;->g:Ljava/util/Set;

    sget-object v0, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    iput-object v0, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    if-eqz p1, :cond_6e

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    const/4 v1, 0x1

    if-ne p2, v1, :cond_20

    const/4 p2, 0x1

    goto :goto_21

    :cond_20
    const/4 p2, 0x0

    :goto_21
    if-eqz p2, :cond_41

    new-instance p2, Ljava/io/BufferedInputStream;

    sget-object v2, Landroidx/exifinterface/media/a;->q0:[B

    array-length v2, v2

    invoke-direct {p2, p1, v2}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    invoke-static {p2}, Landroidx/exifinterface/media/a;->x(Ljava/io/BufferedInputStream;)Z

    move-result p1

    if-nez p1, :cond_39

    const-string p1, "ExifInterface"

    const-string p2, "Given data does not follow the structure of an Exif-only data."

    invoke-static {p1, p2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_39
    iput-boolean v1, p0, Landroidx/exifinterface/media/a;->e:Z

    iput-object v0, p0, Landroidx/exifinterface/media/a;->c:Landroid/content/res/AssetManager$AssetInputStream;

    iput-object v0, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    move-object p1, p2

    goto :goto_6a

    :cond_41
    instance-of p2, p1, Landroid/content/res/AssetManager$AssetInputStream;

    if-eqz p2, :cond_4d

    move-object p2, p1

    check-cast p2, Landroid/content/res/AssetManager$AssetInputStream;

    iput-object p2, p0, Landroidx/exifinterface/media/a;->c:Landroid/content/res/AssetManager$AssetInputStream;

    :goto_4a
    iput-object v0, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    goto :goto_6a

    :cond_4d
    instance-of p2, p1, Ljava/io/FileInputStream;

    if-eqz p2, :cond_67

    move-object p2, p1

    check-cast p2, Ljava/io/FileInputStream;

    invoke-virtual {p2}, Ljava/io/FileInputStream;->getFD()Ljava/io/FileDescriptor;

    move-result-object v1

    invoke-static {v1}, Landroidx/exifinterface/media/a;->E(Ljava/io/FileDescriptor;)Z

    move-result v1

    if-eqz v1, :cond_67

    iput-object v0, p0, Landroidx/exifinterface/media/a;->c:Landroid/content/res/AssetManager$AssetInputStream;

    invoke-virtual {p2}, Ljava/io/FileInputStream;->getFD()Ljava/io/FileDescriptor;

    move-result-object p2

    iput-object p2, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    goto :goto_6a

    :cond_67
    iput-object v0, p0, Landroidx/exifinterface/media/a;->c:Landroid/content/res/AssetManager$AssetInputStream;

    goto :goto_4a

    :goto_6a
    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->J(Ljava/io/InputStream;)V

    return-void

    :cond_6e
    new-instance p1, Ljava/lang/NullPointerException;

    const-string p2, "inputStream cannot be null"

    invoke-direct {p1, p2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .registers 4

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v1, v0

    new-array v1, v1, [Ljava/util/HashMap;

    iput-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    new-instance v1, Ljava/util/HashSet;

    array-length v0, v0

    invoke-direct {v1, v0}, Ljava/util/HashSet;-><init>(I)V

    iput-object v1, p0, Landroidx/exifinterface/media/a;->g:Ljava/util/Set;

    sget-object v0, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    iput-object v0, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    if-eqz p1, :cond_1c

    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->w(Ljava/lang/String;)V

    return-void

    :cond_1c
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "filename cannot be null"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private A([B)Z
    .registers 5

    const/4 v0, 0x0

    const/4 v1, 0x0

    :try_start_2
    new-instance v2, Landroidx/exifinterface/media/a$b;

    invoke-direct {v2, p1}, Landroidx/exifinterface/media/a$b;-><init>([B)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_7} :catch_2e
    .catchall {:try_start_2 .. :try_end_7} :catchall_27

    :try_start_7
    invoke-direct {p0, v2}, Landroidx/exifinterface/media/a;->M(Landroidx/exifinterface/media/a$b;)Ljava/nio/ByteOrder;

    move-result-object p1

    iput-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v2, p1}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    invoke-virtual {v2}, Landroidx/exifinterface/media/a$b;->readShort()S

    move-result p1
    :try_end_14
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_14} :catch_24
    .catchall {:try_start_7 .. :try_end_14} :catchall_21

    const/16 v1, 0x4f52

    if-eq p1, v1, :cond_1c

    const/16 v1, 0x5352

    if-ne p1, v1, :cond_1d

    :cond_1c
    const/4 v0, 0x1

    :cond_1d
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    return v0

    :catchall_21
    move-exception p1

    move-object v1, v2

    goto :goto_28

    :catch_24
    nop

    move-object v1, v2

    goto :goto_2f

    :catchall_27
    move-exception p1

    :goto_28
    if-eqz v1, :cond_2d

    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    :cond_2d
    throw p1

    :catch_2e
    nop

    :goto_2f
    if-eqz v1, :cond_34

    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    :cond_34
    return v0
.end method

.method private B([B)Z
    .registers 6

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    sget-object v2, Landroidx/exifinterface/media/a;->H:[B

    array-length v3, v2

    if-ge v1, v3, :cond_11

    aget-byte v3, p1, v1

    aget-byte v2, v2, v1

    if-eq v3, v2, :cond_e

    return v0

    :cond_e
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_11
    const/4 p1, 0x1

    return p1
.end method

.method private C([B)Z
    .registers 7

    invoke-static {}, Ljava/nio/charset/Charset;->defaultCharset()Ljava/nio/charset/Charset;

    move-result-object v0

    const-string v1, "FUJIFILMCCD-RAW"

    invoke-virtual {v1, v0}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    :goto_c
    array-length v3, v0

    if-ge v2, v3, :cond_19

    aget-byte v3, p1, v2

    aget-byte v4, v0, v2

    if-eq v3, v4, :cond_16

    return v1

    :cond_16
    add-int/lit8 v2, v2, 0x1

    goto :goto_c

    :cond_19
    const/4 p1, 0x1

    return p1
.end method

.method private D([B)Z
    .registers 5

    const/4 v0, 0x0

    const/4 v1, 0x0

    :try_start_2
    new-instance v2, Landroidx/exifinterface/media/a$b;

    invoke-direct {v2, p1}, Landroidx/exifinterface/media/a$b;-><init>([B)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_7} :catch_2a
    .catchall {:try_start_2 .. :try_end_7} :catchall_23

    :try_start_7
    invoke-direct {p0, v2}, Landroidx/exifinterface/media/a;->M(Landroidx/exifinterface/media/a$b;)Ljava/nio/ByteOrder;

    move-result-object p1

    iput-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v2, p1}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    invoke-virtual {v2}, Landroidx/exifinterface/media/a$b;->readShort()S

    move-result p1
    :try_end_14
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_14} :catch_20
    .catchall {:try_start_7 .. :try_end_14} :catchall_1d

    const/16 v1, 0x55

    if-ne p1, v1, :cond_19

    const/4 v0, 0x1

    :cond_19
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    return v0

    :catchall_1d
    move-exception p1

    move-object v1, v2

    goto :goto_24

    :catch_20
    nop

    move-object v1, v2

    goto :goto_2b

    :catchall_23
    move-exception p1

    :goto_24
    if-eqz v1, :cond_29

    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    :cond_29
    throw p1

    :catch_2a
    nop

    :goto_2b
    if-eqz v1, :cond_30

    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    :cond_30
    return v0
.end method

.method private static E(Ljava/io/FileDescriptor;)Z
    .registers 4

    const-wide/16 v0, 0x0

    :try_start_2
    sget v2, Landroid/system/OsConstants;->SEEK_CUR:I

    invoke-static {p0, v0, v1, v2}, Landroidx/exifinterface/media/b$a;->c(Ljava/io/FileDescriptor;JI)J
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_7} :catch_9

    const/4 p0, 0x1

    return p0

    :catch_9
    nop

    sget-boolean p0, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p0, :cond_15

    const-string p0, "ExifInterface"

    const-string v0, "The file descriptor for the given input is not seekable"

    invoke-static {p0, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_15
    const/4 p0, 0x0

    return p0
.end method

.method private F(Ljava/util/HashMap;)Z
    .registers 7

    const-string v0, "BitsPerSample"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/exifinterface/media/a$d;

    if-eqz v0, :cond_45

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, v1}, Landroidx/exifinterface/media/a$d;->o(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [I

    sget-object v1, Landroidx/exifinterface/media/a;->y:[I

    invoke-static {v1, v0}, Ljava/util/Arrays;->equals([I[I)Z

    move-result v2

    const/4 v3, 0x1

    if-eqz v2, :cond_1c

    return v3

    :cond_1c
    iget v2, p0, Landroidx/exifinterface/media/a;->d:I

    const/4 v4, 0x3

    if-ne v2, v4, :cond_45

    const-string v2, "PhotometricInterpretation"

    invoke-virtual {p1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/exifinterface/media/a$d;

    if-eqz p1, :cond_45

    iget-object v2, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result p1

    if-ne p1, v3, :cond_3b

    sget-object v2, Landroidx/exifinterface/media/a;->A:[I

    invoke-static {v0, v2}, Ljava/util/Arrays;->equals([I[I)Z

    move-result v2

    if-nez v2, :cond_44

    :cond_3b
    const/4 v2, 0x6

    if-ne p1, v2, :cond_45

    invoke-static {v0, v1}, Ljava/util/Arrays;->equals([I[I)Z

    move-result p1

    if-eqz p1, :cond_45

    :cond_44
    return v3

    :cond_45
    sget-boolean p1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p1, :cond_50

    const-string p1, "ExifInterface"

    const-string v0, "Unsupported data type value"

    invoke-static {p1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_50
    const/4 p1, 0x0

    return p1
.end method

.method private static G(I)Z
    .registers 2

    const/4 v0, 0x4

    if-eq p0, v0, :cond_e

    const/16 v0, 0xd

    if-eq p0, v0, :cond_e

    const/16 v0, 0xe

    if-ne p0, v0, :cond_c

    goto :goto_e

    :cond_c
    const/4 p0, 0x0

    return p0

    :cond_e
    :goto_e
    const/4 p0, 0x1

    return p0
.end method

.method private H(Ljava/util/HashMap;)Z
    .registers 4

    const-string v0, "ImageLength"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/exifinterface/media/a$d;

    const-string v1, "ImageWidth"

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/exifinterface/media/a$d;

    if-eqz v0, :cond_28

    if-eqz p1, :cond_28

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, v1}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v0

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {p1, v1}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result p1

    const/16 v1, 0x200

    if-gt v0, v1, :cond_28

    if-gt p1, v1, :cond_28

    const/4 p1, 0x1

    return p1

    :cond_28
    const/4 p1, 0x0

    return p1
.end method

.method private I([B)Z
    .registers 6

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    sget-object v2, Landroidx/exifinterface/media/a;->L:[B

    array-length v3, v2

    if-ge v1, v3, :cond_11

    aget-byte v3, p1, v1

    aget-byte v2, v2, v1

    if-eq v3, v2, :cond_e

    return v0

    :cond_e
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_11
    const/4 v1, 0x0

    :goto_12
    sget-object v2, Landroidx/exifinterface/media/a;->M:[B

    array-length v3, v2

    if-ge v1, v3, :cond_27

    sget-object v3, Landroidx/exifinterface/media/a;->L:[B

    array-length v3, v3

    add-int/2addr v3, v1

    add-int/lit8 v3, v3, 0x4

    aget-byte v3, p1, v3

    aget-byte v2, v2, v1

    if-eq v3, v2, :cond_24

    return v0

    :cond_24
    add-int/lit8 v1, v1, 0x1

    goto :goto_12

    :cond_27
    const/4 p1, 0x1

    return p1
.end method

.method private J(Ljava/io/InputStream;)V
    .registers 6

    if-eqz p1, :cond_b3

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_4
    :try_start_4
    sget-object v2, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v2, v2

    if-ge v1, v2, :cond_15

    iget-object v2, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    aput-object v3, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    :cond_15
    iget-boolean v1, p0, Landroidx/exifinterface/media/a;->e:Z

    if-nez v1, :cond_27

    new-instance v1, Ljava/io/BufferedInputStream;

    const/16 v2, 0x1388

    invoke-direct {v1, p1, v2}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    invoke-direct {p0, v1}, Landroidx/exifinterface/media/a;->i(Ljava/io/BufferedInputStream;)I

    move-result p1

    iput p1, p0, Landroidx/exifinterface/media/a;->d:I

    move-object p1, v1

    :cond_27
    iget v1, p0, Landroidx/exifinterface/media/a;->d:I

    invoke-static {v1}, Landroidx/exifinterface/media/a;->Y(I)Z

    move-result v1

    if-eqz v1, :cond_62

    new-instance v0, Landroidx/exifinterface/media/a$g;

    invoke-direct {v0, p1}, Landroidx/exifinterface/media/a$g;-><init>(Ljava/io/InputStream;)V

    iget-boolean p1, p0, Landroidx/exifinterface/media/a;->e:Z

    if-eqz p1, :cond_3c

    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->p(Landroidx/exifinterface/media/a$g;)V

    goto :goto_58

    :cond_3c
    iget p1, p0, Landroidx/exifinterface/media/a;->d:I

    const/16 v1, 0xc

    if-ne p1, v1, :cond_46

    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->g(Landroidx/exifinterface/media/a$g;)V

    goto :goto_58

    :cond_46
    const/4 v1, 0x7

    if-ne p1, v1, :cond_4d

    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->j(Landroidx/exifinterface/media/a$g;)V

    goto :goto_58

    :cond_4d
    const/16 v1, 0xa

    if-ne p1, v1, :cond_55

    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->o(Landroidx/exifinterface/media/a$g;)V

    goto :goto_58

    :cond_55
    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->m(Landroidx/exifinterface/media/a$g;)V

    :goto_58
    iget p1, p0, Landroidx/exifinterface/media/a;->p:I

    int-to-long v1, p1

    invoke-virtual {v0, v1, v2}, Landroidx/exifinterface/media/a$g;->e(J)V

    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->X(Landroidx/exifinterface/media/a$b;)V

    goto :goto_87

    :cond_62
    new-instance v1, Landroidx/exifinterface/media/a$b;

    invoke-direct {v1, p1}, Landroidx/exifinterface/media/a$b;-><init>(Ljava/io/InputStream;)V

    iget p1, p0, Landroidx/exifinterface/media/a;->d:I

    const/4 v2, 0x4

    if-ne p1, v2, :cond_70

    invoke-direct {p0, v1, v0, v0}, Landroidx/exifinterface/media/a;->h(Landroidx/exifinterface/media/a$b;II)V

    goto :goto_87

    :cond_70
    const/16 v0, 0xd

    if-ne p1, v0, :cond_78

    invoke-direct {p0, v1}, Landroidx/exifinterface/media/a;->k(Landroidx/exifinterface/media/a$b;)V

    goto :goto_87

    :cond_78
    const/16 v0, 0x9

    if-ne p1, v0, :cond_80

    invoke-direct {p0, v1}, Landroidx/exifinterface/media/a;->l(Landroidx/exifinterface/media/a$b;)V

    goto :goto_87

    :cond_80
    const/16 v0, 0xe

    if-ne p1, v0, :cond_87

    invoke-direct {p0, v1}, Landroidx/exifinterface/media/a;->s(Landroidx/exifinterface/media/a$b;)V
    :try_end_87
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_87} :catch_93
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_4 .. :try_end_87} :catch_91
    .catchall {:try_start_4 .. :try_end_87} :catchall_8f

    :cond_87
    :goto_87
    invoke-direct {p0}, Landroidx/exifinterface/media/a;->a()V

    sget-boolean p1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p1, :cond_a7

    goto :goto_a4

    :catchall_8f
    move-exception p1

    goto :goto_a8

    :catch_91
    move-exception p1

    goto :goto_94

    :catch_93
    move-exception p1

    :goto_94
    :try_start_94
    sget-boolean v0, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v0, :cond_9f

    const-string v1, "ExifInterface"

    const-string v2, "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."

    invoke-static {v1, v2, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_9f
    .catchall {:try_start_94 .. :try_end_9f} :catchall_8f

    :cond_9f
    invoke-direct {p0}, Landroidx/exifinterface/media/a;->a()V

    if-eqz v0, :cond_a7

    :goto_a4
    invoke-direct {p0}, Landroidx/exifinterface/media/a;->L()V

    :cond_a7
    return-void

    :goto_a8
    invoke-direct {p0}, Landroidx/exifinterface/media/a;->a()V

    sget-boolean v0, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v0, :cond_b2

    invoke-direct {p0}, Landroidx/exifinterface/media/a;->L()V

    :cond_b2
    throw p1

    :cond_b3
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "inputstream shouldn\'t be null"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private K(Landroidx/exifinterface/media/a$b;)V
    .registers 5

    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->M(Landroidx/exifinterface/media/a$b;)Ljava/nio/ByteOrder;

    move-result-object v0

    iput-object v0, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {p1, v0}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v0

    iget v1, p0, Landroidx/exifinterface/media/a;->d:I

    const/4 v2, 0x7

    if-eq v1, v2, :cond_36

    const/16 v2, 0xa

    if-eq v1, v2, :cond_36

    const/16 v1, 0x2a

    if-ne v0, v1, :cond_1b

    goto :goto_36

    :cond_1b
    new-instance p1, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid start code: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_36
    :goto_36
    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v0

    const/16 v1, 0x8

    if-lt v0, v1, :cond_46

    add-int/lit8 v0, v0, -0x8

    if-lez v0, :cond_45

    invoke-virtual {p1, v0}, Landroidx/exifinterface/media/a$b;->d(I)V

    :cond_45
    return-void

    :cond_46
    new-instance p1, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid first Ifd offset: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private L()V
    .registers 8

    const/4 v0, 0x0

    :goto_1
    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    array-length v1, v1

    if-ge v0, v1, :cond_88

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "The size of tag group["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v2, "]: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v2, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v2, v2, v0

    invoke-virtual {v2}, Ljava/util/HashMap;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "ExifInterface"

    invoke-static {v2, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v1, v0

    invoke-virtual {v1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_38
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_84

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/exifinterface/media/a$d;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "tagName: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, ", tagType: "

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Landroidx/exifinterface/media/a$d;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, ", tagValue: \'"

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v4, v3}, Landroidx/exifinterface/media/a$d;->n(Ljava/nio/ByteOrder;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "\'"

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_38

    :cond_84
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    :cond_88
    return-void
.end method

.method private M(Landroidx/exifinterface/media/a$b;)Ljava/nio/ByteOrder;
    .registers 5

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readShort()S

    move-result p1

    const/16 v0, 0x4949

    const-string v1, "ExifInterface"

    if-eq p1, v0, :cond_35

    const/16 v0, 0x4d4d

    if-ne p1, v0, :cond_1a

    sget-boolean p1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p1, :cond_17

    const-string p1, "readExifSegment: Byte Align MM"

    invoke-static {v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_17
    sget-object p1, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    return-object p1

    :cond_1a
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid byte order: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_35
    sget-boolean p1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p1, :cond_3e

    const-string p1, "readExifSegment: Byte Align II"

    invoke-static {v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_3e
    sget-object p1, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    return-object p1
.end method

.method private N([BI)V
    .registers 4

    new-instance v0, Landroidx/exifinterface/media/a$g;

    invoke-direct {v0, p1}, Landroidx/exifinterface/media/a$g;-><init>([B)V

    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->K(Landroidx/exifinterface/media/a$b;)V

    invoke-direct {p0, v0, p2}, Landroidx/exifinterface/media/a;->O(Landroidx/exifinterface/media/a$g;I)V

    return-void
.end method

.method private O(Landroidx/exifinterface/media/a$g;I)V
    .registers 32

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p2

    iget-object v3, v0, Landroidx/exifinterface/media/a;->g:Ljava/util/Set;

    iget v4, v1, Landroidx/exifinterface/media/a$b;->f:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readShort()S

    move-result v3

    sget-boolean v4, Landroidx/exifinterface/media/a;->v:Z

    const-string v5, "ExifInterface"

    if-eqz v4, :cond_2f

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "numberOfDirectoryEntry: "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_2f
    if-gtz v3, :cond_32

    return-void

    :cond_32
    const/4 v4, 0x0

    const/4 v6, 0x0

    :goto_34
    const/4 v7, 0x5

    if-ge v6, v3, :cond_317

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v12

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v13

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v15

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->a()I

    move-result v14

    int-to-long v8, v14

    const-wide/16 v18, 0x4

    add-long v8, v8, v18

    sget-object v14, Landroidx/exifinterface/media/a;->l0:[Ljava/util/HashMap;

    aget-object v14, v14, v2

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v14, v11}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/exifinterface/media/a$e;

    sget-boolean v14, Landroidx/exifinterface/media/a;->v:Z

    const/4 v10, 0x3

    if-eqz v14, :cond_90

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static/range {p2 .. p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v23

    aput-object v23, v7, v4

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v23

    const/16 v21, 0x1

    aput-object v23, v7, v21

    if-eqz v11, :cond_74

    iget-object v4, v11, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    goto :goto_75

    :cond_74
    const/4 v4, 0x0

    :goto_75
    const/16 v22, 0x2

    aput-object v4, v7, v22

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v7, v10

    invoke-static {v15}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    const/16 v20, 0x4

    aput-object v4, v7, v20

    const-string v4, "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"

    invoke-static {v4, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_90
    const/4 v4, 0x7

    if-nez v11, :cond_ae

    if-eqz v14, :cond_a9

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Skip the tag entry since tag number is not defined: "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    :goto_a2
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_a9
    move-object v10, v5

    move/from16 v25, v6

    goto/16 :goto_127

    :cond_ae
    if-lez v13, :cond_10e

    sget-object v7, Landroidx/exifinterface/media/a;->X:[I

    array-length v10, v7

    if-lt v13, v10, :cond_b6

    goto :goto_10e

    :cond_b6
    invoke-virtual {v11, v13}, Landroidx/exifinterface/media/a$e;->a(I)Z

    move-result v10

    if-nez v10, :cond_da

    if-eqz v14, :cond_a9

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Skip the tag entry since data format ("

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v10, Landroidx/exifinterface/media/a;->W:[Ljava/lang/String;

    aget-object v10, v10, v13

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v10, ") is unexpected for tag: "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v10, v11, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_a2

    :cond_da
    if-ne v13, v4, :cond_de

    iget v13, v11, Landroidx/exifinterface/media/a$e;->c:I

    :cond_de
    move-object v10, v5

    int-to-long v4, v15

    aget v7, v7, v13

    move/from16 v25, v6

    int-to-long v6, v7

    mul-long v4, v4, v6

    const-wide/16 v6, 0x0

    cmp-long v26, v4, v6

    if-ltz v26, :cond_f7

    const-wide/32 v6, 0x7fffffff

    cmp-long v26, v4, v6

    if-lez v26, :cond_f5

    goto :goto_f7

    :cond_f5
    const/4 v6, 0x1

    goto :goto_12a

    :cond_f7
    :goto_f7
    if-eqz v14, :cond_129

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Skip the tag entry since the number of components is invalid: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v10, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_129

    :cond_10e
    :goto_10e
    move-object v10, v5

    move/from16 v25, v6

    if-eqz v14, :cond_127

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Skip the tag entry since data format is invalid: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v10, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_127
    :goto_127
    const-wide/16 v4, 0x0

    :cond_129
    :goto_129
    const/4 v6, 0x0

    :goto_12a
    if-nez v6, :cond_134

    invoke-virtual {v1, v8, v9}, Landroidx/exifinterface/media/a$g;->e(J)V

    move/from16 v26, v3

    move-object v8, v10

    goto/16 :goto_30e

    :cond_134
    const-string v6, "Compression"

    cmp-long v7, v4, v18

    if-lez v7, :cond_1be

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v7

    move/from16 v26, v3

    if-eqz v14, :cond_159

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-wide/from16 v27, v8

    const-string v8, "seek to data offset: "

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v10, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_15b

    :cond_159
    move-wide/from16 v27, v8

    :goto_15b
    iget v3, v0, Landroidx/exifinterface/media/a;->d:I

    const/4 v8, 0x7

    if-ne v3, v8, :cond_1b5

    iget-object v3, v11, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    const-string v8, "MakerNote"

    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_16d

    iput v7, v0, Landroidx/exifinterface/media/a;->q:I

    goto :goto_1b5

    :cond_16d
    const/4 v3, 0x6

    if-ne v2, v3, :cond_1b5

    iget-object v8, v11, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    const-string v9, "ThumbnailImage"

    invoke-virtual {v9, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1b5

    iput v7, v0, Landroidx/exifinterface/media/a;->r:I

    iput v15, v0, Landroidx/exifinterface/media/a;->s:I

    iget-object v8, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v3, v8}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v3

    iget v8, v0, Landroidx/exifinterface/media/a;->r:I

    int-to-long v8, v8

    move/from16 v18, v15

    iget-object v15, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v8, v9, v15}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v8

    iget v9, v0, Landroidx/exifinterface/media/a;->s:I

    move-object/from16 v24, v10

    int-to-long v9, v9

    iget-object v15, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v9, v10, v15}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v9

    iget-object v10, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v15, 0x4

    aget-object v10, v10, v15

    invoke-virtual {v10, v6, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v3, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v15

    const-string v10, "JPEGInterchangeFormat"

    invoke-virtual {v3, v10, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v3, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v15

    const-string v8, "JPEGInterchangeFormatLength"

    invoke-virtual {v3, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1b9

    :cond_1b5
    :goto_1b5
    move-object/from16 v24, v10

    move/from16 v18, v15

    :goto_1b9
    int-to-long v7, v7

    invoke-virtual {v1, v7, v8}, Landroidx/exifinterface/media/a$g;->e(J)V

    goto :goto_1c6

    :cond_1be
    move/from16 v26, v3

    move-wide/from16 v27, v8

    move-object/from16 v24, v10

    move/from16 v18, v15

    :goto_1c6
    sget-object v3, Landroidx/exifinterface/media/a;->o0:Ljava/util/HashMap;

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    if-eqz v14, :cond_1f3

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "nextIfdType: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v8, " byteCount: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    move-object/from16 v8, v24

    invoke-static {v8, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1f5

    :cond_1f3
    move-object/from16 v8, v24

    :goto_1f5
    const/16 v7, 0x8

    if-eqz v3, :cond_296

    const-wide/16 v4, -0x1

    const/4 v6, 0x3

    if-eq v13, v6, :cond_21b

    const/4 v6, 0x4

    if-eq v13, v6, :cond_216

    if-eq v13, v7, :cond_211

    const/16 v6, 0x9

    if-eq v13, v6, :cond_20c

    const/16 v6, 0xd

    if-eq v13, v6, :cond_20c

    goto :goto_220

    :cond_20c
    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v4

    goto :goto_21f

    :cond_211
    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readShort()S

    move-result v4

    goto :goto_21f

    :cond_216
    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->b()J

    move-result-wide v4

    goto :goto_220

    :cond_21b
    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v4

    :goto_21f
    int-to-long v4, v4

    :goto_220
    if-eqz v14, :cond_23a

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    const/4 v9, 0x0

    aput-object v7, v6, v9

    iget-object v7, v11, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    const/4 v9, 0x1

    aput-object v7, v6, v9

    const-string v7, "Offset: %d, tagName: %s"

    invoke-static {v7, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v8, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_23a
    const-wide/16 v6, 0x0

    cmp-long v9, v4, v6

    if-lez v9, :cond_279

    iget-object v6, v0, Landroidx/exifinterface/media/a;->g:Ljava/util/Set;

    long-to-int v7, v4

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_258

    invoke-virtual {v1, v4, v5}, Landroidx/exifinterface/media/a$g;->e(J)V

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-direct {v0, v1, v3}, Landroidx/exifinterface/media/a;->O(Landroidx/exifinterface/media/a$g;I)V

    goto :goto_28f

    :cond_258
    if-eqz v14, :cond_28f

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Skip jump into the IFD since it has already been read: IfdType "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v3, " (at "

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    const-string v3, ")"

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_28c

    :cond_279
    if-eqz v14, :cond_28f

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Skip jump into the IFD since its offset is invalid: "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_28c
    invoke-static {v8, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_28f
    :goto_28f
    move-wide/from16 v9, v27

    :goto_291
    invoke-virtual {v1, v9, v10}, Landroidx/exifinterface/media/a$g;->e(J)V

    goto/16 :goto_30e

    :cond_296
    move-wide/from16 v9, v27

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->a()I

    move-result v3

    iget v12, v0, Landroidx/exifinterface/media/a;->p:I

    add-int/2addr v3, v12

    long-to-int v5, v4

    new-array v4, v5, [B

    invoke-virtual {v1, v4}, Landroidx/exifinterface/media/a$b;->readFully([B)V

    new-instance v5, Landroidx/exifinterface/media/a$d;

    int-to-long v14, v3

    move-wide/from16 v19, v14

    move-object v14, v5

    move/from16 v3, v18

    move v15, v13

    move/from16 v16, v3

    move-wide/from16 v17, v19

    move-object/from16 v19, v4

    invoke-direct/range {v14 .. v19}, Landroidx/exifinterface/media/a$d;-><init>(IIJ[B)V

    iget-object v3, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v2

    iget-object v4, v11, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v3, v11, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    const-string v4, "DNGVersion"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2cd

    const/4 v3, 0x3

    iput v3, v0, Landroidx/exifinterface/media/a;->d:I

    :cond_2cd
    iget-object v3, v11, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    const-string v4, "Make"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2e1

    iget-object v3, v11, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    const-string v4, "Model"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2ef

    :cond_2e1
    iget-object v3, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v5, v3}, Landroidx/exifinterface/media/a$d;->n(Ljava/nio/ByteOrder;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "PENTAX"

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_302

    :cond_2ef
    iget-object v3, v11, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    invoke-virtual {v6, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_304

    iget-object v3, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v5, v3}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v3

    const v4, 0xffff

    if-ne v3, v4, :cond_304

    :cond_302
    iput v7, v0, Landroidx/exifinterface/media/a;->d:I

    :cond_304
    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->a()I

    move-result v3

    int-to-long v3, v3

    cmp-long v5, v3, v9

    if-eqz v5, :cond_30e

    goto :goto_291

    :cond_30e
    :goto_30e
    add-int/lit8 v6, v25, 0x1

    int-to-short v6, v6

    move-object v5, v8

    move/from16 v3, v26

    const/4 v4, 0x0

    goto/16 :goto_34

    :cond_317
    move-object v8, v5

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v2

    sget-boolean v3, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v3, :cond_333

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    const/4 v6, 0x0

    aput-object v5, v4, v6

    const-string v5, "nextIfdOffset: %d"

    invoke-static {v5, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v8, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_333
    int-to-long v4, v2

    const-wide/16 v9, 0x0

    cmp-long v6, v4, v9

    if-lez v6, :cond_370

    iget-object v6, v0, Landroidx/exifinterface/media/a;->g:Ljava/util/Set;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-interface {v6, v9}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_366

    invoke-virtual {v1, v4, v5}, Landroidx/exifinterface/media/a$g;->e(J)V

    iget-object v2, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v3, 0x4

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_358

    invoke-direct {v0, v1, v3}, Landroidx/exifinterface/media/a;->O(Landroidx/exifinterface/media/a$g;I)V

    goto :goto_386

    :cond_358
    iget-object v2, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v2, v2, v7

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_386

    invoke-direct {v0, v1, v7}, Landroidx/exifinterface/media/a;->O(Landroidx/exifinterface/media/a$g;I)V

    goto :goto_386

    :cond_366
    if-eqz v3, :cond_386

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Stop reading file since re-reading an IFD may cause an infinite loop: "

    goto :goto_379

    :cond_370
    if-eqz v3, :cond_386

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Stop reading file since a wrong offset may cause an infinite loop: "

    :goto_379
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v8, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_386
    :goto_386
    return-void
.end method

.method private P(Ljava/lang/String;)V
    .registers 4

    const/4 v0, 0x0

    :goto_1
    sget-object v1, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v1, v1

    if-ge v0, v1, :cond_10

    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v1, v0

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_10
    return-void
.end method

.method private Q(ILjava/lang/String;Ljava/lang/String;)V
    .registers 6

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v0, p1

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_26

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v0, p1

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_26

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v0, p1

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, p3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object p3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object p1, p3, p1

    invoke-virtual {p1, p2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_26
    return-void
.end method

.method private R(Landroidx/exifinterface/media/a$g;I)V
    .registers 7

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v0, p2

    const-string v1, "ImageLength"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/exifinterface/media/a$d;

    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v1, p2

    const-string v2, "ImageWidth"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/exifinterface/media/a$d;

    if-eqz v0, :cond_1c

    if-nez v1, :cond_55

    :cond_1c
    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v0, p2

    const-string v1, "JPEGInterchangeFormat"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/exifinterface/media/a$d;

    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v1, p2

    const-string v2, "JPEGInterchangeFormatLength"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/exifinterface/media/a$d;

    if-eqz v0, :cond_55

    if-eqz v1, :cond_55

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, v1}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v1

    iget-object v2, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, v2}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v0

    int-to-long v2, v1

    invoke-virtual {p1, v2, v3}, Landroidx/exifinterface/media/a$g;->e(J)V

    new-array v0, v0, [B

    invoke-virtual {p1, v0}, Ljava/io/InputStream;->read([B)I

    new-instance p1, Landroidx/exifinterface/media/a$b;

    invoke-direct {p1, v0}, Landroidx/exifinterface/media/a$b;-><init>([B)V

    invoke-direct {p0, p1, v1, p2}, Landroidx/exifinterface/media/a;->h(Landroidx/exifinterface/media/a$b;II)V

    :cond_55
    return-void
.end method

.method private T(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .registers 14

    sget-boolean v0, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v0, :cond_27

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "saveJpegAttributes starting with (inputStream: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ", outputStream: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ExifInterface"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_27
    new-instance v0, Landroidx/exifinterface/media/a$b;

    invoke-direct {v0, p1}, Landroidx/exifinterface/media/a$b;-><init>(Ljava/io/InputStream;)V

    new-instance p1, Landroidx/exifinterface/media/a$c;

    sget-object v1, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-direct {p1, p2, v1}, Landroidx/exifinterface/media/a$c;-><init>(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V

    invoke-virtual {v0}, Landroidx/exifinterface/media/a$b;->readByte()B

    move-result p2

    const-string v1, "Invalid marker"

    const/4 v2, -0x1

    if-ne p2, v2, :cond_120

    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$c;->b(I)V

    invoke-virtual {v0}, Landroidx/exifinterface/media/a$b;->readByte()B

    move-result p2

    const/16 v3, -0x28

    if-ne p2, v3, :cond_11a

    invoke-virtual {p1, v3}, Landroidx/exifinterface/media/a$c;->b(I)V

    const/4 p2, 0x0

    const-string v3, "Xmp"

    invoke-virtual {p0, v3}, Landroidx/exifinterface/media/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    if-eqz v4, :cond_62

    iget-boolean v4, p0, Landroidx/exifinterface/media/a;->u:Z

    if-eqz v4, :cond_62

    iget-object p2, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object p2, p2, v5

    invoke-virtual {p2, v3}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/exifinterface/media/a$d;

    :cond_62
    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$c;->b(I)V

    const/16 v4, -0x1f

    invoke-virtual {p1, v4}, Landroidx/exifinterface/media/a$c;->b(I)V

    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->c0(Landroidx/exifinterface/media/a$c;)I

    if-eqz p2, :cond_76

    iget-object v6, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v6, v6, v5

    invoke-virtual {v6, v3, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_76
    const/16 p2, 0x1000

    new-array v3, p2, [B

    :cond_7a
    :goto_7a
    invoke-virtual {v0}, Landroidx/exifinterface/media/a$b;->readByte()B

    move-result v6

    if-ne v6, v2, :cond_114

    invoke-virtual {v0}, Landroidx/exifinterface/media/a$b;->readByte()B

    move-result v6

    const/16 v7, -0x27

    if-eq v6, v7, :cond_10a

    const/16 v7, -0x26

    if-eq v6, v7, :cond_10a

    const-string v7, "Invalid length"

    if-eq v6, v4, :cond_b8

    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$c;->b(I)V

    invoke-virtual {p1, v6}, Landroidx/exifinterface/media/a$c;->b(I)V

    invoke-virtual {v0}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v6

    invoke-virtual {p1, v6}, Landroidx/exifinterface/media/a$c;->f(I)V

    add-int/lit8 v6, v6, -0x2

    if-ltz v6, :cond_b2

    :goto_a1
    if-lez v6, :cond_7a

    invoke-static {v6, p2}, Ljava/lang/Math;->min(II)I

    move-result v7

    invoke-virtual {v0, v3, v5, v7}, Landroidx/exifinterface/media/a$b;->read([BII)I

    move-result v7

    if-ltz v7, :cond_7a

    invoke-virtual {p1, v3, v5, v7}, Landroidx/exifinterface/media/a$c;->write([BII)V

    sub-int/2addr v6, v7

    goto :goto_a1

    :cond_b2
    new-instance p1, Ljava/io/IOException;

    invoke-direct {p1, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_b8
    invoke-virtual {v0}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v8

    add-int/lit8 v8, v8, -0x2

    if-ltz v8, :cond_104

    const/4 v7, 0x6

    new-array v9, v7, [B

    if-lt v8, v7, :cond_e1

    invoke-virtual {v0, v9}, Ljava/io/InputStream;->read([B)I

    move-result v10

    if-ne v10, v7, :cond_d9

    sget-object v10, Landroidx/exifinterface/media/a;->q0:[B

    invoke-static {v9, v10}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v10

    if-eqz v10, :cond_e1

    add-int/lit8 v8, v8, -0x6

    invoke-virtual {v0, v8}, Landroidx/exifinterface/media/a$b;->d(I)V

    goto :goto_7a

    :cond_d9
    new-instance p1, Ljava/io/IOException;

    const-string p2, "Invalid exif"

    invoke-direct {p1, p2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_e1
    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$c;->b(I)V

    invoke-virtual {p1, v6}, Landroidx/exifinterface/media/a$c;->b(I)V

    add-int/lit8 v6, v8, 0x2

    invoke-virtual {p1, v6}, Landroidx/exifinterface/media/a$c;->f(I)V

    if-lt v8, v7, :cond_f3

    add-int/lit8 v8, v8, -0x6

    invoke-virtual {p1, v9}, Landroidx/exifinterface/media/a$c;->write([B)V

    :cond_f3
    :goto_f3
    if-lez v8, :cond_7a

    invoke-static {v8, p2}, Ljava/lang/Math;->min(II)I

    move-result v6

    invoke-virtual {v0, v3, v5, v6}, Landroidx/exifinterface/media/a$b;->read([BII)I

    move-result v6

    if-ltz v6, :cond_7a

    invoke-virtual {p1, v3, v5, v6}, Landroidx/exifinterface/media/a$c;->write([BII)V

    sub-int/2addr v8, v6

    goto :goto_f3

    :cond_104
    new-instance p1, Ljava/io/IOException;

    invoke-direct {p1, v7}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_10a
    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$c;->b(I)V

    invoke-virtual {p1, v6}, Landroidx/exifinterface/media/a$c;->b(I)V

    invoke-static {v0, p1}, Landroidx/exifinterface/media/b;->e(Ljava/io/InputStream;Ljava/io/OutputStream;)I

    return-void

    :cond_114
    new-instance p1, Ljava/io/IOException;

    invoke-direct {p1, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_11a
    new-instance p1, Ljava/io/IOException;

    invoke-direct {p1, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_120
    new-instance p1, Ljava/io/IOException;

    invoke-direct {p1, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private U(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .registers 8

    sget-boolean v0, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v0, :cond_27

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "savePngAttributes starting with (inputStream: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ", outputStream: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ExifInterface"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_27
    new-instance v0, Landroidx/exifinterface/media/a$b;

    invoke-direct {v0, p1}, Landroidx/exifinterface/media/a$b;-><init>(Ljava/io/InputStream;)V

    new-instance p1, Landroidx/exifinterface/media/a$c;

    sget-object v1, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-direct {p1, p2, v1}, Landroidx/exifinterface/media/a$c;-><init>(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V

    sget-object p2, Landroidx/exifinterface/media/a;->H:[B

    array-length v2, p2

    invoke-static {v0, p1, v2}, Landroidx/exifinterface/media/b;->f(Ljava/io/InputStream;Ljava/io/OutputStream;I)V

    iget v2, p0, Landroidx/exifinterface/media/a;->p:I

    const/4 v3, 0x4

    if-nez v2, :cond_4b

    invoke-virtual {v0}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result p2

    invoke-virtual {p1, p2}, Landroidx/exifinterface/media/a$c;->c(I)V

    add-int/2addr p2, v3

    add-int/2addr p2, v3

    invoke-static {v0, p1, p2}, Landroidx/exifinterface/media/b;->f(Ljava/io/InputStream;Ljava/io/OutputStream;I)V

    goto :goto_5b

    :cond_4b
    array-length p2, p2

    sub-int/2addr v2, p2

    sub-int/2addr v2, v3

    sub-int/2addr v2, v3

    invoke-static {v0, p1, v2}, Landroidx/exifinterface/media/b;->f(Ljava/io/InputStream;Ljava/io/OutputStream;I)V

    invoke-virtual {v0}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result p2

    add-int/2addr p2, v3

    add-int/2addr p2, v3

    invoke-virtual {v0, p2}, Landroidx/exifinterface/media/a$b;->d(I)V

    :goto_5b
    const/4 p2, 0x0

    :try_start_5c
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_61
    .catchall {:try_start_5c .. :try_end_61} :catchall_90

    :try_start_61
    new-instance p2, Landroidx/exifinterface/media/a$c;

    invoke-direct {p2, v2, v1}, Landroidx/exifinterface/media/a$c;-><init>(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V

    invoke-direct {p0, p2}, Landroidx/exifinterface/media/a;->c0(Landroidx/exifinterface/media/a$c;)I

    iget-object p2, p2, Landroidx/exifinterface/media/a$c;->c:Ljava/io/OutputStream;

    check-cast p2, Ljava/io/ByteArrayOutputStream;

    invoke-virtual {p2}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object p2

    invoke-virtual {p1, p2}, Landroidx/exifinterface/media/a$c;->write([B)V

    new-instance v1, Ljava/util/zip/CRC32;

    invoke-direct {v1}, Ljava/util/zip/CRC32;-><init>()V

    array-length v4, p2

    sub-int/2addr v4, v3

    invoke-virtual {v1, p2, v3, v4}, Ljava/util/zip/CRC32;->update([BII)V

    invoke-virtual {v1}, Ljava/util/zip/CRC32;->getValue()J

    move-result-wide v3

    long-to-int p2, v3

    invoke-virtual {p1, p2}, Landroidx/exifinterface/media/a$c;->c(I)V
    :try_end_86
    .catchall {:try_start_61 .. :try_end_86} :catchall_8d

    invoke-static {v2}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    invoke-static {v0, p1}, Landroidx/exifinterface/media/b;->e(Ljava/io/InputStream;Ljava/io/OutputStream;)I

    return-void

    :catchall_8d
    move-exception p1

    move-object p2, v2

    goto :goto_91

    :catchall_90
    move-exception p1

    :goto_91
    invoke-static {p2}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    throw p1
.end method

.method private V(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    .registers 22

    move-object/from16 v1, p0

    move-object/from16 v0, p1

    move-object/from16 v2, p2

    sget-boolean v3, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v3, :cond_2d

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "saveWebpAttributes starting with (inputStream: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v4, ", outputStream: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "ExifInterface"

    invoke-static {v4, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_2d
    new-instance v3, Landroidx/exifinterface/media/a$b;

    sget-object v4, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    invoke-direct {v3, v0, v4}, Landroidx/exifinterface/media/a$b;-><init>(Ljava/io/InputStream;Ljava/nio/ByteOrder;)V

    new-instance v5, Landroidx/exifinterface/media/a$c;

    invoke-direct {v5, v2, v4}, Landroidx/exifinterface/media/a$c;-><init>(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V

    sget-object v2, Landroidx/exifinterface/media/a;->L:[B

    array-length v6, v2

    invoke-static {v3, v5, v6}, Landroidx/exifinterface/media/b;->f(Ljava/io/InputStream;Ljava/io/OutputStream;I)V

    sget-object v6, Landroidx/exifinterface/media/a;->M:[B

    array-length v7, v6

    const/4 v8, 0x4

    add-int/2addr v7, v8

    invoke-virtual {v3, v7}, Landroidx/exifinterface/media/a$b;->d(I)V

    const/4 v7, 0x0

    :try_start_48
    new-instance v9, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v9}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_4d
    .catch Ljava/lang/Exception; {:try_start_48 .. :try_end_4d} :catch_1f3
    .catchall {:try_start_48 .. :try_end_4d} :catchall_1f1

    :try_start_4d
    new-instance v10, Landroidx/exifinterface/media/a$c;

    invoke-direct {v10, v9, v4}, Landroidx/exifinterface/media/a$c;-><init>(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V

    iget v4, v1, Landroidx/exifinterface/media/a;->p:I

    if-eqz v4, :cond_75

    array-length v0, v2

    add-int/2addr v0, v8

    array-length v2, v6

    add-int/2addr v0, v2

    sub-int/2addr v4, v0

    sub-int/2addr v4, v8

    sub-int/2addr v4, v8

    invoke-static {v3, v10, v4}, Landroidx/exifinterface/media/b;->f(Ljava/io/InputStream;Ljava/io/OutputStream;I)V

    invoke-virtual {v3, v8}, Landroidx/exifinterface/media/a$b;->d(I)V

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v0

    rem-int/lit8 v2, v0, 0x2

    if-eqz v2, :cond_6d

    add-int/lit8 v0, v0, 0x1

    :cond_6d
    invoke-virtual {v3, v0}, Landroidx/exifinterface/media/a$b;->d(I)V

    :goto_70
    invoke-direct {v1, v10}, Landroidx/exifinterface/media/a;->c0(Landroidx/exifinterface/media/a$c;)I

    goto/16 :goto_1cb

    :cond_75
    new-array v2, v8, [B

    invoke-virtual {v3, v2}, Ljava/io/InputStream;->read([B)I

    move-result v4

    if-ne v4, v8, :cond_1e3

    sget-object v4, Landroidx/exifinterface/media/a;->P:[B

    invoke-static {v2, v4}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v6

    const/16 v11, 0x8

    const/4 v12, 0x0

    const/4 v13, 0x1

    if-eqz v6, :cond_cf

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v2

    rem-int/lit8 v6, v2, 0x2

    if-ne v6, v13, :cond_94

    add-int/lit8 v6, v2, 0x1

    goto :goto_95

    :cond_94
    move v6, v2

    :goto_95
    new-array v6, v6, [B

    invoke-virtual {v3, v6}, Ljava/io/InputStream;->read([B)I

    aget-byte v14, v6, v12

    or-int/2addr v11, v14

    int-to-byte v11, v11

    aput-byte v11, v6, v12

    shr-int/2addr v11, v13

    and-int/2addr v11, v13

    if-ne v11, v13, :cond_a5

    const/4 v12, 0x1

    :cond_a5
    invoke-virtual {v10, v4}, Landroidx/exifinterface/media/a$c;->write([B)V

    invoke-virtual {v10, v2}, Landroidx/exifinterface/media/a$c;->c(I)V

    invoke-virtual {v10, v6}, Landroidx/exifinterface/media/a$c;->write([B)V

    if-eqz v12, :cond_c7

    sget-object v2, Landroidx/exifinterface/media/a;->S:[B

    invoke-direct {v1, v3, v10, v2, v7}, Landroidx/exifinterface/media/a;->b(Landroidx/exifinterface/media/a$b;Landroidx/exifinterface/media/a$c;[B[B)V

    :goto_b5
    new-array v2, v8, [B

    invoke-virtual {v0, v2}, Ljava/io/InputStream;->read([B)I

    sget-object v4, Landroidx/exifinterface/media/a;->T:[B

    invoke-static {v2, v4}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v4

    if-nez v4, :cond_c3

    goto :goto_70

    :cond_c3
    invoke-direct {v1, v3, v10, v2}, Landroidx/exifinterface/media/a;->c(Landroidx/exifinterface/media/a$b;Landroidx/exifinterface/media/a$c;[B)V

    goto :goto_b5

    :cond_c7
    sget-object v0, Landroidx/exifinterface/media/a;->R:[B

    sget-object v2, Landroidx/exifinterface/media/a;->Q:[B

    invoke-direct {v1, v3, v10, v0, v2}, Landroidx/exifinterface/media/a;->b(Landroidx/exifinterface/media/a$b;Landroidx/exifinterface/media/a$c;[B[B)V

    goto :goto_70

    :cond_cf
    sget-object v0, Landroidx/exifinterface/media/a;->R:[B

    invoke-static {v2, v0}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v6

    if-nez v6, :cond_df

    sget-object v6, Landroidx/exifinterface/media/a;->Q:[B

    invoke-static {v2, v6}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v6

    if-eqz v6, :cond_1cb

    :cond_df
    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v6

    rem-int/lit8 v7, v6, 0x2

    if-ne v7, v13, :cond_ea

    add-int/lit8 v7, v6, 0x1

    goto :goto_eb

    :cond_ea
    move v7, v6

    :goto_eb
    const/4 v14, 0x3

    new-array v15, v14, [B

    invoke-static {v2, v0}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v16

    const/16 v8, 0x2f

    if-eqz v16, :cond_124

    invoke-virtual {v3, v15}, Ljava/io/InputStream;->read([B)I

    new-array v13, v14, [B

    invoke-virtual {v3, v13}, Ljava/io/InputStream;->read([B)I

    move-result v11

    if-ne v11, v14, :cond_11c

    sget-object v11, Landroidx/exifinterface/media/a;->O:[B

    invoke-static {v11, v13}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v11

    if-eqz v11, :cond_11c

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v11

    shl-int/lit8 v13, v11, 0x12

    shr-int/lit8 v13, v13, 0x12

    shl-int/lit8 v14, v11, 0x2

    shr-int/lit8 v14, v14, 0x12

    add-int/lit8 v7, v7, -0xa

    move/from16 v17, v14

    move v14, v13

    const/4 v13, 0x0

    goto :goto_15a

    :cond_11c
    new-instance v0, Ljava/io/IOException;

    const-string v2, "Encountered error while checking VP8 signature"

    invoke-direct {v0, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_124
    sget-object v11, Landroidx/exifinterface/media/a;->Q:[B

    invoke-static {v2, v11}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v11

    if-eqz v11, :cond_155

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readByte()B

    move-result v11

    if-ne v11, v8, :cond_14d

    invoke-virtual {v3}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v11

    and-int/lit16 v14, v11, 0x3fff

    add-int/2addr v14, v13

    const v17, 0xfffc000

    and-int v17, v11, v17

    ushr-int/lit8 v17, v17, 0xe

    add-int/lit8 v17, v17, 0x1

    const/high16 v18, 0x10000000

    and-int v18, v11, v18

    if-eqz v18, :cond_149

    goto :goto_14a

    :cond_149
    const/4 v13, 0x0

    :goto_14a
    add-int/lit8 v7, v7, -0x5

    goto :goto_15a

    :cond_14d
    new-instance v0, Ljava/io/IOException;

    const-string v2, "Encountered error while checking VP8L signature"

    invoke-direct {v0, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_155
    const/4 v11, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/16 v17, 0x0

    :goto_15a
    invoke-virtual {v10, v4}, Landroidx/exifinterface/media/a$c;->write([B)V

    const/16 v4, 0xa

    invoke-virtual {v10, v4}, Landroidx/exifinterface/media/a$c;->c(I)V

    new-array v4, v4, [B

    if-eqz v13, :cond_16d

    aget-byte v13, v4, v12

    or-int/lit8 v13, v13, 0x10

    int-to-byte v13, v13

    aput-byte v13, v4, v12

    :cond_16d
    aget-byte v13, v4, v12

    const/16 v16, 0x8

    or-int/lit8 v13, v13, 0x8

    int-to-byte v13, v13

    aput-byte v13, v4, v12

    add-int/lit8 v14, v14, -0x1

    add-int/lit8 v12, v17, -0x1

    int-to-byte v13, v14

    const/16 v17, 0x4

    aput-byte v13, v4, v17

    const/4 v13, 0x5

    shr-int/lit8 v8, v14, 0x8

    int-to-byte v8, v8

    aput-byte v8, v4, v13

    const/4 v8, 0x6

    shr-int/lit8 v13, v14, 0x10

    int-to-byte v13, v13

    aput-byte v13, v4, v8

    const/4 v8, 0x7

    int-to-byte v13, v12

    aput-byte v13, v4, v8

    shr-int/lit8 v8, v12, 0x8

    int-to-byte v8, v8

    const/16 v13, 0x8

    aput-byte v8, v4, v13

    const/16 v8, 0x9

    shr-int/lit8 v12, v12, 0x10

    int-to-byte v12, v12

    aput-byte v12, v4, v8

    invoke-virtual {v10, v4}, Landroidx/exifinterface/media/a$c;->write([B)V

    invoke-virtual {v10, v2}, Landroidx/exifinterface/media/a$c;->write([B)V

    invoke-virtual {v10, v6}, Landroidx/exifinterface/media/a$c;->c(I)V

    invoke-static {v2, v0}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v0

    if-eqz v0, :cond_1b8

    invoke-virtual {v10, v15}, Landroidx/exifinterface/media/a$c;->write([B)V

    sget-object v0, Landroidx/exifinterface/media/a;->O:[B

    invoke-virtual {v10, v0}, Landroidx/exifinterface/media/a$c;->write([B)V

    :goto_1b4
    invoke-virtual {v10, v11}, Landroidx/exifinterface/media/a$c;->c(I)V

    goto :goto_1c6

    :cond_1b8
    sget-object v0, Landroidx/exifinterface/media/a;->Q:[B

    invoke-static {v2, v0}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v0

    if-eqz v0, :cond_1c6

    const/16 v0, 0x2f

    invoke-virtual {v10, v0}, Ljava/io/OutputStream;->write(I)V

    goto :goto_1b4

    :cond_1c6
    :goto_1c6
    invoke-static {v3, v10, v7}, Landroidx/exifinterface/media/b;->f(Ljava/io/InputStream;Ljava/io/OutputStream;I)V

    goto/16 :goto_70

    :cond_1cb
    :goto_1cb
    invoke-static {v3, v10}, Landroidx/exifinterface/media/b;->e(Ljava/io/InputStream;Ljava/io/OutputStream;)I

    invoke-virtual {v9}, Ljava/io/ByteArrayOutputStream;->size()I

    move-result v0

    sget-object v2, Landroidx/exifinterface/media/a;->M:[B

    array-length v3, v2

    add-int/2addr v0, v3

    invoke-virtual {v5, v0}, Landroidx/exifinterface/media/a$c;->c(I)V

    invoke-virtual {v5, v2}, Landroidx/exifinterface/media/a$c;->write([B)V

    invoke-virtual {v9, v5}, Ljava/io/ByteArrayOutputStream;->writeTo(Ljava/io/OutputStream;)V
    :try_end_1df
    .catch Ljava/lang/Exception; {:try_start_4d .. :try_end_1df} :catch_1ee
    .catchall {:try_start_4d .. :try_end_1df} :catchall_1eb

    invoke-static {v9}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    return-void

    :cond_1e3
    :try_start_1e3
    new-instance v0, Ljava/io/IOException;

    const-string v2, "Encountered invalid length while parsing WebP chunk type"

    invoke-direct {v0, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1eb
    .catch Ljava/lang/Exception; {:try_start_1e3 .. :try_end_1eb} :catch_1ee
    .catchall {:try_start_1e3 .. :try_end_1eb} :catchall_1eb

    :catchall_1eb
    move-exception v0

    move-object v7, v9

    goto :goto_1fc

    :catch_1ee
    move-exception v0

    move-object v7, v9

    goto :goto_1f4

    :catchall_1f1
    move-exception v0

    goto :goto_1fc

    :catch_1f3
    move-exception v0

    :goto_1f4
    :try_start_1f4
    new-instance v2, Ljava/io/IOException;

    const-string v3, "Failed to save WebP file"

    invoke-direct {v2, v3, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
    :try_end_1fc
    .catchall {:try_start_1f4 .. :try_end_1fc} :catchall_1f1

    :goto_1fc
    invoke-static {v7}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    throw v0
.end method

.method private X(Landroidx/exifinterface/media/a$b;)V
    .registers 6

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v1, 0x4

    aget-object v0, v0, v1

    const-string v1, "Compression"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/exifinterface/media/a$d;

    const/4 v2, 0x6

    if-eqz v1, :cond_2b

    iget-object v3, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v1, v3}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v1

    iput v1, p0, Landroidx/exifinterface/media/a;->o:I

    const/4 v3, 0x1

    if-eq v1, v3, :cond_21

    if-eq v1, v2, :cond_2d

    const/4 v2, 0x7

    if-eq v1, v2, :cond_21

    goto :goto_30

    :cond_21
    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->F(Ljava/util/HashMap;)Z

    move-result v1

    if-eqz v1, :cond_30

    invoke-direct {p0, p1, v0}, Landroidx/exifinterface/media/a;->v(Landroidx/exifinterface/media/a$b;Ljava/util/HashMap;)V

    goto :goto_30

    :cond_2b
    iput v2, p0, Landroidx/exifinterface/media/a;->o:I

    :cond_2d
    invoke-direct {p0, p1, v0}, Landroidx/exifinterface/media/a;->u(Landroidx/exifinterface/media/a$b;Ljava/util/HashMap;)V

    :cond_30
    :goto_30
    return-void
.end method

.method private static Y(I)Z
    .registers 2

    const/4 v0, 0x4

    if-eq p0, v0, :cond_12

    const/16 v0, 0x9

    if-eq p0, v0, :cond_12

    const/16 v0, 0xd

    if-eq p0, v0, :cond_12

    const/16 v0, 0xe

    if-ne p0, v0, :cond_10

    goto :goto_12

    :cond_10
    const/4 p0, 0x1

    return p0

    :cond_12
    :goto_12
    const/4 p0, 0x0

    return p0
.end method

.method private Z(II)V
    .registers 9

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v0, p1

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    const-string v1, "ExifInterface"

    if-nez v0, :cond_86

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v0, p2

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_18

    goto/16 :goto_86

    :cond_18
    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v0, p1

    const-string v2, "ImageLength"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/exifinterface/media/a$d;

    iget-object v3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, p1

    const-string v4, "ImageWidth"

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/exifinterface/media/a$d;

    iget-object v5, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v5, v5, p2

    invoke-virtual {v5, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/exifinterface/media/a$d;

    iget-object v5, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v5, v5, p2

    invoke-virtual {v5, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/exifinterface/media/a$d;

    if-eqz v0, :cond_7c

    if-nez v3, :cond_49

    goto :goto_7c

    :cond_49
    if-eqz v2, :cond_75

    if-nez v4, :cond_4e

    goto :goto_75

    :cond_4e
    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, v1}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v0

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v3, v1}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v1

    iget-object v3, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v2, v3}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v2

    iget-object v3, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v4, v3}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v3

    if-ge v0, v2, :cond_85

    if-ge v1, v3, :cond_85

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v0, p1

    aget-object v2, v0, p2

    aput-object v2, v0, p1

    aput-object v1, v0, p2

    goto :goto_85

    :cond_75
    :goto_75
    sget-boolean p1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p1, :cond_85

    const-string p1, "Second image does not contain valid size information"

    goto :goto_82

    :cond_7c
    :goto_7c
    sget-boolean p1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p1, :cond_85

    const-string p1, "First image does not contain valid size information"

    :goto_82
    invoke-static {v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_85
    :goto_85
    return-void

    :cond_86
    :goto_86
    sget-boolean p1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p1, :cond_8f

    const-string p1, "Cannot perform swap since only one image data exists"

    invoke-static {v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_8f
    return-void
.end method

.method private a()V
    .registers 7

    const-string v0, "DateTimeOriginal"

    invoke-virtual {p0, v0}, Landroidx/exifinterface/media/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_1c

    const-string v2, "DateTime"

    invoke-virtual {p0, v2}, Landroidx/exifinterface/media/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_1c

    iget-object v3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v1

    invoke-static {v0}, Landroidx/exifinterface/media/a$d;->e(Ljava/lang/String;)Landroidx/exifinterface/media/a$d;

    move-result-object v0

    invoke-virtual {v3, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1c
    const-string v0, "ImageWidth"

    invoke-virtual {p0, v0}, Landroidx/exifinterface/media/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-wide/16 v3, 0x0

    if-nez v2, :cond_33

    iget-object v2, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v2, v2, v1

    iget-object v5, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v3, v4, v5}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v5

    invoke-virtual {v2, v0, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_33
    const-string v0, "ImageLength"

    invoke-virtual {p0, v0}, Landroidx/exifinterface/media/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_48

    iget-object v2, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v2, v2, v1

    iget-object v5, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v3, v4, v5}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v5

    invoke-virtual {v2, v0, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_48
    const-string v0, "Orientation"

    invoke-virtual {p0, v0}, Landroidx/exifinterface/media/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_5d

    iget-object v2, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v2, v1

    iget-object v2, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v3, v4, v2}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_5d
    const-string v0, "LightSource"

    invoke-virtual {p0, v0}, Landroidx/exifinterface/media/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_73

    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    iget-object v2, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v3, v4, v2}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_73
    return-void
.end method

.method private a0(Landroidx/exifinterface/media/a$g;I)V
    .registers 12

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v0, p2

    const-string v1, "DefaultCropSize"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/exifinterface/media/a$d;

    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v1, p2

    const-string v2, "SensorTopBorder"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/exifinterface/media/a$d;

    iget-object v2, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v2, v2, p2

    const-string v3, "SensorLeftBorder"

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/exifinterface/media/a$d;

    iget-object v3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, p2

    const-string v4, "SensorBottomBorder"

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/exifinterface/media/a$d;

    iget-object v4, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v4, v4, p2

    const-string v5, "SensorRightBorder"

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/exifinterface/media/a$d;

    const-string v5, "ImageLength"

    const-string v6, "ImageWidth"

    if-eqz v0, :cond_be

    iget p1, v0, Landroidx/exifinterface/media/a$d;->a:I

    const/4 v1, 0x5

    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v4, 0x2

    const-string v7, "Invalid crop size values. cropSize="

    const-string v8, "ExifInterface"

    if-ne p1, v1, :cond_84

    iget-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, p1}, Landroidx/exifinterface/media/a$d;->o(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Landroidx/exifinterface/media/a$f;

    if-eqz p1, :cond_6d

    array-length v0, p1

    if-eq v0, v4, :cond_5c

    goto :goto_6d

    :cond_5c
    aget-object v0, p1, v3

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v0, v1}, Landroidx/exifinterface/media/a$d;->h(Landroidx/exifinterface/media/a$f;Ljava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v0

    aget-object p1, p1, v2

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {p1, v1}, Landroidx/exifinterface/media/a$d;->h(Landroidx/exifinterface/media/a$f;Ljava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object p1

    goto :goto_a2

    :cond_6d
    :goto_6d
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    :goto_79
    invoke-virtual {p2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v8, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_84
    iget-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, p1}, Landroidx/exifinterface/media/a$d;->o(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [I

    if-eqz p1, :cond_b1

    array-length v0, p1

    if-eq v0, v4, :cond_92

    goto :goto_b1

    :cond_92
    aget v0, p1, v3

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v0, v1}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v0

    aget p1, p1, v2

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {p1, v1}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object p1

    :goto_a2
    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v1, p2

    invoke-virtual {v1, v6, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object p2, v0, p2

    invoke-virtual {p2, v5, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_102

    :cond_b1
    :goto_b1
    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/util/Arrays;->toString([I)Ljava/lang/String;

    move-result-object p1

    goto :goto_79

    :cond_be
    if-eqz v1, :cond_ff

    if-eqz v2, :cond_ff

    if-eqz v3, :cond_ff

    if-eqz v4, :cond_ff

    iget-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v1, p1}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result p1

    iget-object v0, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v3, v0}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v0

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v4, v1}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v1

    iget-object v3, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v2, v3}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v2

    if-le v0, p1, :cond_102

    if-le v1, v2, :cond_102

    sub-int/2addr v0, p1

    sub-int/2addr v1, v2

    iget-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v0, p1}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object p1

    iget-object v0, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v1, v0}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v0

    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v1, p2

    invoke-virtual {v1, v5, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object p1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object p1, p1, p2

    invoke-virtual {p1, v6, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_102

    :cond_ff
    invoke-direct {p0, p1, p2}, Landroidx/exifinterface/media/a;->R(Landroidx/exifinterface/media/a$g;I)V

    :cond_102
    :goto_102
    return-void
.end method

.method private b(Landroidx/exifinterface/media/a$b;Landroidx/exifinterface/media/a$c;[B[B)V
    .registers 8

    :cond_0
    const/4 v0, 0x4

    new-array v1, v0, [B

    invoke-virtual {p1, v1}, Ljava/io/InputStream;->read([B)I

    move-result v2

    if-eq v2, v0, :cond_45

    new-instance p1, Ljava/io/IOException;

    new-instance p2, Ljava/lang/StringBuilder;

    invoke-direct {p2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "Encountered invalid length while copying WebP chunks up tochunk type "

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v0, Ljava/lang/String;

    sget-object v1, Landroidx/exifinterface/media/a;->p0:Ljava/nio/charset/Charset;

    invoke-direct {v0, p3, v1}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-virtual {p2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-nez p4, :cond_24

    const-string p3, ""

    goto :goto_3a

    :cond_24
    new-instance p3, Ljava/lang/StringBuilder;

    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, " or "

    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p4, v1}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    :goto_3a
    invoke-virtual {p2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_45
    invoke-direct {p0, p1, p2, v1}, Landroidx/exifinterface/media/a;->c(Landroidx/exifinterface/media/a$b;Landroidx/exifinterface/media/a$c;[B)V

    invoke-static {v1, p3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v0

    if-nez v0, :cond_56

    if-eqz p4, :cond_0

    invoke-static {v1, p4}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_56
    return-void
.end method

.method private b0()V
    .registers 10

    const/4 v0, 0x0

    const/4 v1, 0x5

    invoke-direct {p0, v0, v1}, Landroidx/exifinterface/media/a;->Z(II)V

    const/4 v2, 0x4

    invoke-direct {p0, v0, v2}, Landroidx/exifinterface/media/a;->Z(II)V

    invoke-direct {p0, v1, v2}, Landroidx/exifinterface/media/a;->Z(II)V

    iget-object v3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v4, 0x1

    aget-object v3, v3, v4

    const-string v5, "PixelXDimension"

    invoke-virtual {v3, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/exifinterface/media/a$d;

    iget-object v5, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v4, v5, v4

    const-string v5, "PixelYDimension"

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/exifinterface/media/a$d;

    const-string v5, "ImageLength"

    const-string v6, "ImageWidth"

    if-eqz v3, :cond_3b

    if-eqz v4, :cond_3b

    iget-object v7, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v7, v0

    invoke-virtual {v7, v6, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v0

    invoke-virtual {v3, v5, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3b
    iget-object v3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v2

    invoke-virtual {v3}, Ljava/util/HashMap;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_5c

    iget-object v3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v1

    invoke-direct {p0, v3}, Landroidx/exifinterface/media/a;->H(Ljava/util/HashMap;)Z

    move-result v3

    if-eqz v3, :cond_5c

    iget-object v3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v4, v3, v1

    aput-object v4, v3, v2

    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    aput-object v4, v3, v1

    :cond_5c
    iget-object v3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v2

    invoke-direct {p0, v3}, Landroidx/exifinterface/media/a;->H(Ljava/util/HashMap;)Z

    move-result v3

    if-nez v3, :cond_6d

    const-string v3, "ExifInterface"

    const-string v4, "No image meets the size requirements of a thumbnail image."

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_6d
    const-string v3, "ThumbnailOrientation"

    const-string v4, "Orientation"

    invoke-direct {p0, v0, v3, v4}, Landroidx/exifinterface/media/a;->Q(ILjava/lang/String;Ljava/lang/String;)V

    const-string v7, "ThumbnailImageLength"

    invoke-direct {p0, v0, v7, v5}, Landroidx/exifinterface/media/a;->Q(ILjava/lang/String;Ljava/lang/String;)V

    const-string v8, "ThumbnailImageWidth"

    invoke-direct {p0, v0, v8, v6}, Landroidx/exifinterface/media/a;->Q(ILjava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v1, v3, v4}, Landroidx/exifinterface/media/a;->Q(ILjava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v1, v7, v5}, Landroidx/exifinterface/media/a;->Q(ILjava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v1, v8, v6}, Landroidx/exifinterface/media/a;->Q(ILjava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v2, v4, v3}, Landroidx/exifinterface/media/a;->Q(ILjava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v2, v5, v7}, Landroidx/exifinterface/media/a;->Q(ILjava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v2, v6, v8}, Landroidx/exifinterface/media/a;->Q(ILjava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private c(Landroidx/exifinterface/media/a$b;Landroidx/exifinterface/media/a$c;[B)V
    .registers 6

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v0

    invoke-virtual {p2, p3}, Landroidx/exifinterface/media/a$c;->write([B)V

    invoke-virtual {p2, v0}, Landroidx/exifinterface/media/a$c;->c(I)V

    rem-int/lit8 p3, v0, 0x2

    const/4 v1, 0x1

    if-ne p3, v1, :cond_11

    add-int/lit8 v0, v0, 0x1

    :cond_11
    invoke-static {p1, p2, v0}, Landroidx/exifinterface/media/b;->f(Ljava/io/InputStream;Ljava/io/OutputStream;I)V

    return-void
.end method

.method private c0(Landroidx/exifinterface/media/a$c;)I
    .registers 18

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    sget-object v2, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v3, v2

    new-array v3, v3, [I

    array-length v2, v2

    new-array v2, v2, [I

    sget-object v4, Landroidx/exifinterface/media/a;->k0:[Landroidx/exifinterface/media/a$e;

    array-length v5, v4

    const/4 v6, 0x0

    const/4 v7, 0x0

    :goto_11
    if-ge v7, v5, :cond_1d

    aget-object v8, v4, v7

    iget-object v8, v8, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    invoke-direct {v0, v8}, Landroidx/exifinterface/media/a;->P(Ljava/lang/String;)V

    add-int/lit8 v7, v7, 0x1

    goto :goto_11

    :cond_1d
    iget-boolean v4, v0, Landroidx/exifinterface/media/a;->i:Z

    const-string v5, "StripByteCounts"

    const-string v7, "JPEGInterchangeFormatLength"

    const-string v8, "StripOffsets"

    const-string v9, "JPEGInterchangeFormat"

    if-eqz v4, :cond_3a

    iget-boolean v4, v0, Landroidx/exifinterface/media/a;->j:Z

    if-eqz v4, :cond_34

    invoke-direct {v0, v8}, Landroidx/exifinterface/media/a;->P(Ljava/lang/String;)V

    invoke-direct {v0, v5}, Landroidx/exifinterface/media/a;->P(Ljava/lang/String;)V

    goto :goto_3a

    :cond_34
    invoke-direct {v0, v9}, Landroidx/exifinterface/media/a;->P(Ljava/lang/String;)V

    invoke-direct {v0, v7}, Landroidx/exifinterface/media/a;->P(Ljava/lang/String;)V

    :cond_3a
    :goto_3a
    const/4 v4, 0x0

    :goto_3b
    sget-object v10, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v10, v10

    if-ge v4, v10, :cond_6b

    iget-object v10, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v10, v10, v4

    invoke-virtual {v10}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v10

    invoke-interface {v10}, Ljava/util/Set;->toArray()[Ljava/lang/Object;

    move-result-object v10

    array-length v11, v10

    const/4 v12, 0x0

    :goto_4e
    if-ge v12, v11, :cond_68

    aget-object v13, v10, v12

    check-cast v13, Ljava/util/Map$Entry;

    invoke-interface {v13}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v14

    if-nez v14, :cond_65

    iget-object v14, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v14, v14, v4

    invoke-interface {v13}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v13

    invoke-virtual {v14, v13}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_65
    add-int/lit8 v12, v12, 0x1

    goto :goto_4e

    :cond_68
    add-int/lit8 v4, v4, 0x1

    goto :goto_3b

    :cond_6b
    iget-object v4, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v10, 0x1

    aget-object v4, v4, v10

    invoke-virtual {v4}, Ljava/util/HashMap;->isEmpty()Z

    move-result v4

    const-wide/16 v11, 0x0

    if-nez v4, :cond_8b

    iget-object v4, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v4, v4, v6

    sget-object v13, Landroidx/exifinterface/media/a;->k0:[Landroidx/exifinterface/media/a$e;

    aget-object v13, v13, v10

    iget-object v13, v13, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    iget-object v14, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v11, v12, v14}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v14

    invoke-virtual {v4, v13, v14}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_8b
    iget-object v4, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v13, 0x2

    aget-object v4, v4, v13

    invoke-virtual {v4}, Ljava/util/HashMap;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_a9

    iget-object v4, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v4, v4, v6

    sget-object v14, Landroidx/exifinterface/media/a;->k0:[Landroidx/exifinterface/media/a$e;

    aget-object v14, v14, v13

    iget-object v14, v14, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    iget-object v15, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v11, v12, v15}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v15

    invoke-virtual {v4, v14, v15}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_a9
    iget-object v4, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v14, 0x3

    aget-object v4, v4, v14

    invoke-virtual {v4}, Ljava/util/HashMap;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_c7

    iget-object v4, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v4, v4, v10

    sget-object v15, Landroidx/exifinterface/media/a;->k0:[Landroidx/exifinterface/media/a$e;

    aget-object v15, v15, v14

    iget-object v15, v15, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    iget-object v14, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v11, v12, v14}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v14

    invoke-virtual {v4, v15, v14}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_c7
    iget-boolean v4, v0, Landroidx/exifinterface/media/a;->i:Z

    const/4 v14, 0x4

    if-eqz v4, :cond_10a

    iget-boolean v4, v0, Landroidx/exifinterface/media/a;->j:Z

    if-eqz v4, :cond_ed

    iget-object v4, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v4, v4, v14

    iget-object v7, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v6, v7}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v7

    invoke-virtual {v4, v8, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v4, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v4, v4, v14

    iget v7, v0, Landroidx/exifinterface/media/a;->m:I

    iget-object v15, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v7, v15}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v7

    invoke-virtual {v4, v5, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_10a

    :cond_ed
    iget-object v4, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v4, v4, v14

    iget-object v5, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v11, v12, v5}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v5

    invoke-virtual {v4, v9, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v4, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v4, v4, v14

    iget v5, v0, Landroidx/exifinterface/media/a;->m:I

    int-to-long v11, v5

    iget-object v5, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v11, v12, v5}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v5

    invoke-virtual {v4, v7, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_10a
    :goto_10a
    const/4 v4, 0x0

    :goto_10b
    sget-object v5, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v5, v5

    if-ge v4, v5, :cond_13f

    iget-object v5, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v5, v5, v4

    invoke-virtual {v5}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    const/4 v7, 0x0

    :cond_11d
    :goto_11d
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_137

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/Map$Entry;

    invoke-interface {v11}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/exifinterface/media/a$d;

    invoke-virtual {v11}, Landroidx/exifinterface/media/a$d;->p()I

    move-result v11

    if-le v11, v14, :cond_11d

    add-int/2addr v7, v11

    goto :goto_11d

    :cond_137
    aget v5, v2, v4

    add-int/2addr v5, v7

    aput v5, v2, v4

    add-int/lit8 v4, v4, 0x1

    goto :goto_10b

    :cond_13f
    const/16 v4, 0x8

    const/4 v5, 0x0

    :goto_142
    sget-object v7, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v7, v7

    if-ge v5, v7, :cond_166

    iget-object v7, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v7, v5

    invoke-virtual {v7}, Ljava/util/HashMap;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_163

    aput v4, v3, v5

    iget-object v7, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v7, v5

    invoke-virtual {v7}, Ljava/util/HashMap;->size()I

    move-result v7

    mul-int/lit8 v7, v7, 0xc

    add-int/2addr v7, v13

    add-int/2addr v7, v14

    aget v11, v2, v5

    add-int/2addr v7, v11

    add-int/2addr v4, v7

    :cond_163
    add-int/lit8 v5, v5, 0x1

    goto :goto_142

    :cond_166
    iget-boolean v5, v0, Landroidx/exifinterface/media/a;->i:Z

    if-eqz v5, :cond_18f

    iget-boolean v5, v0, Landroidx/exifinterface/media/a;->j:Z

    if-eqz v5, :cond_17c

    iget-object v5, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v5, v5, v14

    iget-object v7, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v4, v7}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v7

    invoke-virtual {v5, v8, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_18a

    :cond_17c
    iget-object v5, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v5, v5, v14

    int-to-long v7, v4

    iget-object v11, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v7, v8, v11}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v7

    invoke-virtual {v5, v9, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :goto_18a
    iput v4, v0, Landroidx/exifinterface/media/a;->l:I

    iget v5, v0, Landroidx/exifinterface/media/a;->m:I

    add-int/2addr v4, v5

    :cond_18f
    iget v5, v0, Landroidx/exifinterface/media/a;->d:I

    if-ne v5, v14, :cond_195

    add-int/lit8 v4, v4, 0x8

    :cond_195
    sget-boolean v5, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v5, :cond_1db

    const/4 v5, 0x0

    :goto_19a
    sget-object v7, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v7, v7

    if-ge v5, v7, :cond_1db

    const/4 v7, 0x5

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v6

    aget v8, v3, v5

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v10

    iget-object v8, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v8, v8, v5

    invoke-virtual {v8}, Ljava/util/HashMap;->size()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v13

    aget v8, v2, v5

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    const/4 v9, 0x3

    aput-object v8, v7, v9

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v14

    const-string v8, "index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d"

    invoke-static {v8, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    const-string v8, "ExifInterface"

    invoke-static {v8, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    add-int/lit8 v5, v5, 0x1

    goto :goto_19a

    :cond_1db
    iget-object v2, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v2, v2, v10

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1fb

    iget-object v2, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v2, v2, v6

    sget-object v5, Landroidx/exifinterface/media/a;->k0:[Landroidx/exifinterface/media/a$e;

    aget-object v5, v5, v10

    iget-object v5, v5, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    aget v7, v3, v10

    int-to-long v7, v7

    iget-object v9, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v7, v8, v9}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1fb
    iget-object v2, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v2, v2, v13

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_21b

    iget-object v2, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v2, v2, v6

    sget-object v5, Landroidx/exifinterface/media/a;->k0:[Landroidx/exifinterface/media/a$e;

    aget-object v5, v5, v13

    iget-object v5, v5, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    aget v7, v3, v13

    int-to-long v7, v7

    iget-object v9, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v7, v8, v9}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v7

    invoke-virtual {v2, v5, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_21b
    iget-object v2, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v5, 0x3

    aget-object v2, v2, v5

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_23c

    iget-object v2, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v2, v2, v10

    sget-object v7, Landroidx/exifinterface/media/a;->k0:[Landroidx/exifinterface/media/a$e;

    aget-object v7, v7, v5

    iget-object v7, v7, Landroidx/exifinterface/media/a$e;->b:Ljava/lang/String;

    aget v5, v3, v5

    int-to-long v8, v5

    iget-object v5, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v8, v9, v5}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v5

    invoke-virtual {v2, v7, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_23c
    iget v2, v0, Landroidx/exifinterface/media/a;->d:I

    const/16 v5, 0xe

    if-eq v2, v14, :cond_25b

    const/16 v7, 0xd

    if-eq v2, v7, :cond_252

    if-eq v2, v5, :cond_249

    goto :goto_263

    :cond_249
    sget-object v2, Landroidx/exifinterface/media/a;->N:[B

    invoke-virtual {v1, v2}, Landroidx/exifinterface/media/a$c;->write([B)V

    invoke-virtual {v1, v4}, Landroidx/exifinterface/media/a$c;->c(I)V

    goto :goto_263

    :cond_252
    invoke-virtual {v1, v4}, Landroidx/exifinterface/media/a$c;->c(I)V

    sget-object v2, Landroidx/exifinterface/media/a;->I:[B

    invoke-virtual {v1, v2}, Landroidx/exifinterface/media/a$c;->write([B)V

    goto :goto_263

    :cond_25b
    invoke-virtual {v1, v4}, Landroidx/exifinterface/media/a$c;->f(I)V

    sget-object v2, Landroidx/exifinterface/media/a;->q0:[B

    invoke-virtual {v1, v2}, Landroidx/exifinterface/media/a$c;->write([B)V

    :goto_263
    iget-object v2, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    sget-object v7, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    if-ne v2, v7, :cond_26c

    const/16 v2, 0x4d4d

    goto :goto_26e

    :cond_26c
    const/16 v2, 0x4949

    :goto_26e
    invoke-virtual {v1, v2}, Landroidx/exifinterface/media/a$c;->d(S)V

    iget-object v2, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v1, v2}, Landroidx/exifinterface/media/a$c;->a(Ljava/nio/ByteOrder;)V

    const/16 v2, 0x2a

    invoke-virtual {v1, v2}, Landroidx/exifinterface/media/a$c;->f(I)V

    const-wide/16 v7, 0x8

    invoke-virtual {v1, v7, v8}, Landroidx/exifinterface/media/a$c;->e(J)V

    const/4 v2, 0x0

    :goto_281
    sget-object v7, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v7, v7

    if-ge v2, v7, :cond_34b

    iget-object v7, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v7, v2

    invoke-virtual {v7}, Ljava/util/HashMap;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_344

    iget-object v7, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v7, v2

    invoke-virtual {v7}, Ljava/util/HashMap;->size()I

    move-result v7

    invoke-virtual {v1, v7}, Landroidx/exifinterface/media/a$c;->f(I)V

    aget v7, v3, v2

    add-int/2addr v7, v13

    iget-object v8, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v8, v8, v2

    invoke-virtual {v8}, Ljava/util/HashMap;->size()I

    move-result v8

    mul-int/lit8 v8, v8, 0xc

    add-int/2addr v7, v8

    add-int/2addr v7, v14

    iget-object v8, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v8, v8, v2

    invoke-virtual {v8}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_2b6
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_302

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/Map$Entry;

    sget-object v11, Landroidx/exifinterface/media/a;->m0:[Ljava/util/HashMap;

    aget-object v11, v11, v2

    invoke-interface {v9}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/exifinterface/media/a$e;

    iget v11, v11, Landroidx/exifinterface/media/a$e;->a:I

    invoke-interface {v9}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/exifinterface/media/a$d;

    invoke-virtual {v9}, Landroidx/exifinterface/media/a$d;->p()I

    move-result v12

    invoke-virtual {v1, v11}, Landroidx/exifinterface/media/a$c;->f(I)V

    iget v11, v9, Landroidx/exifinterface/media/a$d;->a:I

    invoke-virtual {v1, v11}, Landroidx/exifinterface/media/a$c;->f(I)V

    iget v11, v9, Landroidx/exifinterface/media/a$d;->b:I

    invoke-virtual {v1, v11}, Landroidx/exifinterface/media/a$c;->c(I)V

    if-le v12, v14, :cond_2f1

    int-to-long v10, v7

    invoke-virtual {v1, v10, v11}, Landroidx/exifinterface/media/a$c;->e(J)V

    add-int/2addr v7, v12

    goto :goto_300

    :cond_2f1
    iget-object v9, v9, Landroidx/exifinterface/media/a$d;->d:[B

    invoke-virtual {v1, v9}, Landroidx/exifinterface/media/a$c;->write([B)V

    if-ge v12, v14, :cond_300

    :goto_2f8
    if-ge v12, v14, :cond_300

    invoke-virtual {v1, v6}, Landroidx/exifinterface/media/a$c;->b(I)V

    add-int/lit8 v12, v12, 0x1

    goto :goto_2f8

    :cond_300
    :goto_300
    const/4 v10, 0x1

    goto :goto_2b6

    :cond_302
    if-nez v2, :cond_317

    iget-object v7, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v7, v14

    invoke-virtual {v7}, Ljava/util/HashMap;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_317

    aget v7, v3, v14

    int-to-long v7, v7

    invoke-virtual {v1, v7, v8}, Landroidx/exifinterface/media/a$c;->e(J)V

    const-wide/16 v7, 0x0

    goto :goto_31c

    :cond_317
    const-wide/16 v7, 0x0

    invoke-virtual {v1, v7, v8}, Landroidx/exifinterface/media/a$c;->e(J)V

    :goto_31c
    iget-object v9, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v9, v9, v2

    invoke-virtual {v9}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_328
    :goto_328
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_346

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/util/Map$Entry;

    invoke-interface {v10}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroidx/exifinterface/media/a$d;

    iget-object v10, v10, Landroidx/exifinterface/media/a$d;->d:[B

    array-length v11, v10

    if-le v11, v14, :cond_328

    array-length v11, v10

    invoke-virtual {v1, v10, v6, v11}, Landroidx/exifinterface/media/a$c;->write([BII)V

    goto :goto_328

    :cond_344
    const-wide/16 v7, 0x0

    :cond_346
    add-int/lit8 v2, v2, 0x1

    const/4 v10, 0x1

    goto/16 :goto_281

    :cond_34b
    iget-boolean v2, v0, Landroidx/exifinterface/media/a;->i:Z

    if-eqz v2, :cond_356

    invoke-virtual/range {p0 .. p0}, Landroidx/exifinterface/media/a;->r()[B

    move-result-object v2

    invoke-virtual {v1, v2}, Landroidx/exifinterface/media/a$c;->write([B)V

    :cond_356
    iget v2, v0, Landroidx/exifinterface/media/a;->d:I

    if-ne v2, v5, :cond_362

    rem-int/lit8 v2, v4, 0x2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_362

    invoke-virtual {v1, v6}, Landroidx/exifinterface/media/a$c;->b(I)V

    :cond_362
    sget-object v2, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {v1, v2}, Landroidx/exifinterface/media/a$c;->a(Ljava/nio/ByteOrder;)V

    return v4
.end method

.method private f(Ljava/lang/String;)Landroidx/exifinterface/media/a$d;
    .registers 4

    if-eqz p1, :cond_2f

    const-string v0, "ISOSpeedRatings"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_17

    sget-boolean p1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p1, :cond_15

    const-string p1, "ExifInterface"

    const-string v0, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY."

    invoke-static {p1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_15
    const-string p1, "PhotographicSensitivity"

    :cond_17
    const/4 v0, 0x0

    :goto_18
    sget-object v1, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v1, v1

    if-ge v0, v1, :cond_2d

    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v1, v0

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/exifinterface/media/a$d;

    if-eqz v1, :cond_2a

    return-object v1

    :cond_2a
    add-int/lit8 v0, v0, 0x1

    goto :goto_18

    :cond_2d
    const/4 p1, 0x0

    return-object p1

    :cond_2f
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "tag shouldn\'t be null"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private g(Landroidx/exifinterface/media/a$g;)V
    .registers 14

    const-string v0, "yes"

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    if-lt v1, v2, :cond_146

    new-instance v1, Landroid/media/MediaMetadataRetriever;

    invoke-direct {v1}, Landroid/media/MediaMetadataRetriever;-><init>()V

    :try_start_d
    new-instance v2, Landroidx/exifinterface/media/a$a;

    invoke-direct {v2, p0, p1}, Landroidx/exifinterface/media/a$a;-><init>(Landroidx/exifinterface/media/a;Landroidx/exifinterface/media/a$g;)V

    invoke-static {v1, v2}, Landroidx/exifinterface/media/b$b;->a(Landroid/media/MediaMetadataRetriever;Landroid/media/MediaDataSource;)V

    const/16 v2, 0x21

    invoke-virtual {v1, v2}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x22

    invoke-virtual {v1, v3}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x1a

    invoke-virtual {v1, v4}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x11

    invoke-virtual {v1, v5}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    const/4 v6, 0x0

    if-eqz v4, :cond_47

    const/16 v0, 0x1d

    invoke-virtual {v1, v0}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v6

    const/16 v0, 0x1e

    invoke-virtual {v1, v0}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v0

    const/16 v4, 0x1f

    invoke-virtual {v1, v4}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v4

    goto :goto_62

    :cond_47
    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_60

    const/16 v0, 0x12

    invoke-virtual {v1, v0}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v6

    const/16 v0, 0x13

    invoke-virtual {v1, v0}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v0

    const/16 v4, 0x18

    invoke-virtual {v1, v4}, Landroid/media/MediaMetadataRetriever;->extractMetadata(I)Ljava/lang/String;

    move-result-object v4

    goto :goto_62

    :cond_60
    move-object v0, v6

    move-object v4, v0

    :goto_62
    const/4 v5, 0x0

    if-eqz v6, :cond_78

    iget-object v7, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v7, v5

    const-string v8, "ImageWidth"

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v9

    iget-object v10, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v9, v10}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_78
    if-eqz v0, :cond_8d

    iget-object v7, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v7, v5

    const-string v8, "ImageLength"

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v9

    iget-object v10, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v9, v10}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_8d
    const/4 v7, 0x6

    if-eqz v4, :cond_b7

    const/4 v8, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v9

    const/16 v10, 0x5a

    if-eq v9, v10, :cond_a7

    const/16 v10, 0xb4

    if-eq v9, v10, :cond_a5

    const/16 v10, 0x10e

    if-eq v9, v10, :cond_a2

    goto :goto_a8

    :cond_a2
    const/16 v8, 0x8

    goto :goto_a8

    :cond_a5
    const/4 v8, 0x3

    goto :goto_a8

    :cond_a7
    const/4 v8, 0x6

    :goto_a8
    iget-object v9, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v9, v9, v5

    const-string v10, "Orientation"

    iget-object v11, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v8, v11}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v8

    invoke-virtual {v9, v10, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_b7
    if-eqz v2, :cond_10a

    if-eqz v3, :cond_10a

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    if-le v3, v7, :cond_102

    int-to-long v8, v2

    invoke-virtual {p1, v8, v9}, Landroidx/exifinterface/media/a$g;->e(J)V

    new-array v8, v7, [B

    invoke-virtual {p1, v8}, Ljava/io/InputStream;->read([B)I

    move-result v9

    if-ne v9, v7, :cond_fa

    add-int/2addr v2, v7

    add-int/lit8 v3, v3, -0x6

    sget-object v7, Landroidx/exifinterface/media/a;->q0:[B

    invoke-static {v8, v7}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v7

    if-eqz v7, :cond_f2

    new-array v7, v3, [B

    invoke-virtual {p1, v7}, Ljava/io/InputStream;->read([B)I

    move-result p1

    if-ne p1, v3, :cond_ea

    iput v2, p0, Landroidx/exifinterface/media/a;->p:I

    invoke-direct {p0, v7, v5}, Landroidx/exifinterface/media/a;->N([BI)V

    goto :goto_10a

    :cond_ea
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Can\'t read exif"

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_f2
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Invalid identifier"

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_fa
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Can\'t read identifier"

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_102
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Invalid exif length"

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_10a
    :goto_10a
    sget-boolean p1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p1, :cond_134

    const-string p1, "ExifInterface"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Heif meta: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "x"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, ", rotation "

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_134
    .catch Ljava/lang/RuntimeException; {:try_start_d .. :try_end_134} :catch_13a
    .catchall {:try_start_d .. :try_end_134} :catchall_138

    :cond_134
    invoke-virtual {v1}, Landroid/media/MediaMetadataRetriever;->release()V

    return-void

    :catchall_138
    move-exception p1

    goto :goto_142

    :catch_13a
    :try_start_13a
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    const-string v0, "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."

    invoke-direct {p1, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_142
    .catchall {:try_start_13a .. :try_end_142} :catchall_138

    :goto_142
    invoke-virtual {v1}, Landroid/media/MediaMetadataRetriever;->release()V

    throw p1

    :cond_146
    new-instance p1, Ljava/lang/UnsupportedOperationException;

    const-string v0, "Reading EXIF from HEIF files is supported from SDK 28 and above"

    invoke-direct {p1, v0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private h(Landroidx/exifinterface/media/a$b;II)V
    .registers 25

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, p3

    sget-boolean v3, Landroidx/exifinterface/media/a;->v:Z

    const-string v4, "ExifInterface"

    if-eqz v3, :cond_20

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "getJpegAttributes starting with: "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v4, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_20
    sget-object v3, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {v1, v3}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readByte()B

    move-result v3

    const-string v5, "Invalid marker: "

    const/4 v6, -0x1

    if-ne v3, v6, :cond_1d8

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readByte()B

    move-result v7

    const/16 v8, -0x28

    if-ne v7, v8, :cond_1bd

    const/4 v3, 0x2

    const/4 v5, 0x2

    :goto_38
    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readByte()B

    move-result v7

    if-ne v7, v6, :cond_1a0

    const/4 v7, 0x1

    add-int/2addr v5, v7

    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readByte()B

    move-result v8

    sget-boolean v9, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v9, :cond_62

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Found JPEG segment indicator: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    and-int/lit16 v11, v8, 0xff

    invoke-static {v11}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v4, v10}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_62
    add-int/2addr v5, v7

    const/16 v10, -0x27

    if-eq v8, v10, :cond_19a

    const/16 v10, -0x26

    if-ne v8, v10, :cond_6d

    goto/16 :goto_19a

    :cond_6d
    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v10

    sub-int/2addr v10, v3

    add-int/2addr v5, v3

    if-eqz v9, :cond_9e

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "JPEG segment: "

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    and-int/lit16 v11, v8, 0xff

    invoke-static {v11}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v11, " (length: "

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v11, v10, 0x2

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v11, ")"

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v4, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_9e
    const-string v9, "Invalid length"

    if-ltz v10, :cond_194

    const/16 v11, -0x1f

    const/4 v12, 0x0

    if-eq v8, v11, :cond_121

    const/4 v11, -0x2

    if-eq v8, v11, :cond_f3

    packed-switch v8, :pswitch_data_1f4

    packed-switch v8, :pswitch_data_200

    packed-switch v8, :pswitch_data_20a

    packed-switch v8, :pswitch_data_214

    :goto_b6
    move-object/from16 v20, v4

    goto/16 :goto_182

    :pswitch_ba
    invoke-virtual {v1, v7}, Landroidx/exifinterface/media/a$b;->d(I)V

    iget-object v7, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v7, v2

    const/4 v8, 0x4

    if-eq v2, v8, :cond_c7

    const-string v11, "ImageLength"

    goto :goto_c9

    :cond_c7
    const-string v11, "ThumbnailImageLength"

    :goto_c9
    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v12

    int-to-long v12, v12

    iget-object v14, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v12, v13, v14}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v12

    invoke-virtual {v7, v11, v12}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v7, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v7, v2

    if-eq v2, v8, :cond_e0

    const-string v8, "ImageWidth"

    goto :goto_e2

    :cond_e0
    const-string v8, "ThumbnailImageWidth"

    :goto_e2
    invoke-virtual/range {p1 .. p1}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v11

    int-to-long v11, v11

    iget-object v13, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v11, v12, v13}, Landroidx/exifinterface/media/a$d;->f(JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v11

    invoke-virtual {v7, v8, v11}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v10, v10, -0x5

    goto :goto_b6

    :cond_f3
    new-array v8, v10, [B

    invoke-virtual {v1, v8}, Ljava/io/InputStream;->read([B)I

    move-result v11

    if-ne v11, v10, :cond_119

    const-string v10, "UserComment"

    invoke-virtual {v0, v10}, Landroidx/exifinterface/media/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    if-nez v11, :cond_115

    iget-object v11, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v7, v11, v7

    new-instance v11, Ljava/lang/String;

    sget-object v13, Landroidx/exifinterface/media/a;->p0:Ljava/nio/charset/Charset;

    invoke-direct {v11, v8, v13}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-static {v11}, Landroidx/exifinterface/media/a$d;->e(Ljava/lang/String;)Landroidx/exifinterface/media/a$d;

    move-result-object v8

    invoke-virtual {v7, v10, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_115
    move-object/from16 v20, v4

    goto/16 :goto_181

    :cond_119
    new-instance v1, Ljava/io/IOException;

    const-string v2, "Invalid exif"

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_121
    new-array v8, v10, [B

    invoke-virtual {v1, v8}, Landroidx/exifinterface/media/a$b;->readFully([B)V

    add-int v11, v5, v10

    sget-object v13, Landroidx/exifinterface/media/a;->q0:[B

    invoke-static {v8, v13}, Landroidx/exifinterface/media/b;->g([B[B)Z

    move-result v14

    if-eqz v14, :cond_147

    array-length v7, v13

    invoke-static {v8, v7, v10}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v7

    add-int v5, p2, v5

    array-length v8, v13

    add-int/2addr v5, v8

    iput v5, v0, Landroidx/exifinterface/media/a;->p:I

    invoke-direct {v0, v7, v2}, Landroidx/exifinterface/media/a;->N([BI)V

    new-instance v5, Landroidx/exifinterface/media/a$b;

    invoke-direct {v5, v7}, Landroidx/exifinterface/media/a$b;-><init>([B)V

    invoke-direct {v0, v5}, Landroidx/exifinterface/media/a;->X(Landroidx/exifinterface/media/a$b;)V

    goto :goto_17e

    :cond_147
    sget-object v13, Landroidx/exifinterface/media/a;->r0:[B

    invoke-static {v8, v13}, Landroidx/exifinterface/media/b;->g([B[B)Z

    move-result v14

    if-eqz v14, :cond_17e

    array-length v14, v13

    add-int/2addr v5, v14

    array-length v13, v13

    invoke-static {v8, v13, v10}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v8

    const-string v10, "Xmp"

    invoke-virtual {v0, v10}, Landroidx/exifinterface/media/a;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    if-nez v13, :cond_17e

    iget-object v13, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v13, v13, v12

    new-instance v15, Landroidx/exifinterface/media/a$d;

    const/16 v16, 0x1

    array-length v14, v8

    move-object/from16 v20, v4

    int-to-long v3, v5

    move v5, v14

    move-object v14, v15

    move-object v6, v15

    move/from16 v15, v16

    move/from16 v16, v5

    move-wide/from16 v17, v3

    move-object/from16 v19, v8

    invoke-direct/range {v14 .. v19}, Landroidx/exifinterface/media/a$d;-><init>(IIJ[B)V

    invoke-virtual {v13, v10, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iput-boolean v7, v0, Landroidx/exifinterface/media/a;->u:Z

    goto :goto_180

    :cond_17e
    :goto_17e
    move-object/from16 v20, v4

    :goto_180
    move v5, v11

    :goto_181
    const/4 v10, 0x0

    :goto_182
    if-ltz v10, :cond_18e

    invoke-virtual {v1, v10}, Landroidx/exifinterface/media/a$b;->d(I)V

    add-int/2addr v5, v10

    move-object/from16 v4, v20

    const/4 v3, 0x2

    const/4 v6, -0x1

    goto/16 :goto_38

    :cond_18e
    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v9}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_194
    new-instance v1, Ljava/io/IOException;

    invoke-direct {v1, v9}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_19a
    :goto_19a
    iget-object v2, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v1, v2}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    return-void

    :cond_1a0
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid marker:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    and-int/lit16 v3, v7, 0xff

    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1bd
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    and-int/lit16 v3, v3, 0xff

    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_1d8
    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    and-int/lit16 v3, v3, 0xff

    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1

    nop

    :pswitch_data_1f4
    .packed-switch -0x40
        :pswitch_ba
        :pswitch_ba
        :pswitch_ba
        :pswitch_ba
    .end packed-switch

    :pswitch_data_200
    .packed-switch -0x3b
        :pswitch_ba
        :pswitch_ba
        :pswitch_ba
    .end packed-switch

    :pswitch_data_20a
    .packed-switch -0x37
        :pswitch_ba
        :pswitch_ba
        :pswitch_ba
    .end packed-switch

    :pswitch_data_214
    .packed-switch -0x33
        :pswitch_ba
        :pswitch_ba
        :pswitch_ba
    .end packed-switch
.end method

.method private i(Ljava/io/BufferedInputStream;)I
    .registers 3

    const/16 v0, 0x1388

    invoke-virtual {p1, v0}, Ljava/io/BufferedInputStream;->mark(I)V

    new-array v0, v0, [B

    invoke-virtual {p1, v0}, Ljava/io/InputStream;->read([B)I

    invoke-virtual {p1}, Ljava/io/BufferedInputStream;->reset()V

    invoke-static {v0}, Landroidx/exifinterface/media/a;->z([B)Z

    move-result p1

    if-eqz p1, :cond_15

    const/4 p1, 0x4

    return p1

    :cond_15
    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->C([B)Z

    move-result p1

    if-eqz p1, :cond_1e

    const/16 p1, 0x9

    return p1

    :cond_1e
    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->y([B)Z

    move-result p1

    if-eqz p1, :cond_27

    const/16 p1, 0xc

    return p1

    :cond_27
    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->A([B)Z

    move-result p1

    if-eqz p1, :cond_2f

    const/4 p1, 0x7

    return p1

    :cond_2f
    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->D([B)Z

    move-result p1

    if-eqz p1, :cond_38

    const/16 p1, 0xa

    return p1

    :cond_38
    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->B([B)Z

    move-result p1

    if-eqz p1, :cond_41

    const/16 p1, 0xd

    return p1

    :cond_41
    invoke-direct {p0, v0}, Landroidx/exifinterface/media/a;->I([B)Z

    move-result p1

    if-eqz p1, :cond_4a

    const/16 p1, 0xe

    return p1

    :cond_4a
    const/4 p1, 0x0

    return p1
.end method

.method private j(Landroidx/exifinterface/media/a$g;)V
    .registers 7

    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->m(Landroidx/exifinterface/media/a$g;)V

    iget-object p1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v0, 0x1

    aget-object p1, p1, v0

    const-string v1, "MakerNote"

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/exifinterface/media/a$d;

    if-eqz p1, :cond_ed

    new-instance v1, Landroidx/exifinterface/media/a$g;

    iget-object p1, p1, Landroidx/exifinterface/media/a$d;->d:[B

    invoke-direct {v1, p1}, Landroidx/exifinterface/media/a$g;-><init>([B)V

    iget-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v1, p1}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    sget-object p1, Landroidx/exifinterface/media/a;->F:[B

    array-length v2, p1

    new-array v2, v2, [B

    invoke-virtual {v1, v2}, Landroidx/exifinterface/media/a$b;->readFully([B)V

    const-wide/16 v3, 0x0

    invoke-virtual {v1, v3, v4}, Landroidx/exifinterface/media/a$g;->e(J)V

    sget-object v3, Landroidx/exifinterface/media/a;->G:[B

    array-length v4, v3

    new-array v4, v4, [B

    invoke-virtual {v1, v4}, Landroidx/exifinterface/media/a$b;->readFully([B)V

    invoke-static {v2, p1}, Ljava/util/Arrays;->equals([B[B)Z

    move-result p1

    if-eqz p1, :cond_3f

    const-wide/16 v2, 0x8

    :goto_3b
    invoke-virtual {v1, v2, v3}, Landroidx/exifinterface/media/a$g;->e(J)V

    goto :goto_48

    :cond_3f
    invoke-static {v4, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result p1

    if-eqz p1, :cond_48

    const-wide/16 v2, 0xc

    goto :goto_3b

    :cond_48
    :goto_48
    const/4 p1, 0x6

    invoke-direct {p0, v1, p1}, Landroidx/exifinterface/media/a;->O(Landroidx/exifinterface/media/a$g;I)V

    iget-object p1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v1, 0x7

    aget-object p1, p1, v1

    const-string v2, "PreviewImageStart"

    invoke-virtual {p1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/exifinterface/media/a$d;

    iget-object v2, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v2, v1

    const-string v2, "PreviewImageLength"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/exifinterface/media/a$d;

    if-eqz p1, :cond_7c

    if-eqz v1, :cond_7c

    iget-object v2, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    const-string v4, "JPEGInterchangeFormat"

    invoke-virtual {v2, v4, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object p1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object p1, p1, v3

    const-string v2, "JPEGInterchangeFormatLength"

    invoke-virtual {p1, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_7c
    iget-object p1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/16 v1, 0x8

    aget-object p1, p1, v1

    const-string v1, "AspectFrame"

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/exifinterface/media/a$d;

    if-eqz p1, :cond_ed

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {p1, v1}, Landroidx/exifinterface/media/a$d;->o(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [I

    if-eqz p1, :cond_d3

    array-length v1, p1

    const/4 v2, 0x4

    if-eq v1, v2, :cond_9b

    goto :goto_d3

    :cond_9b
    const/4 v1, 0x2

    aget v1, p1, v1

    const/4 v2, 0x0

    aget v3, p1, v2

    if-le v1, v3, :cond_ed

    const/4 v4, 0x3

    aget v4, p1, v4

    aget p1, p1, v0

    if-le v4, p1, :cond_ed

    sub-int/2addr v1, v3

    add-int/2addr v1, v0

    sub-int/2addr v4, p1

    add-int/2addr v4, v0

    if-ge v1, v4, :cond_b4

    add-int/2addr v1, v4

    sub-int v4, v1, v4

    sub-int/2addr v1, v4

    :cond_b4
    iget-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v1, p1}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object p1

    iget-object v0, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v4, v0}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v0

    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v1, v1, v2

    const-string v3, "ImageWidth"

    invoke-virtual {v1, v3, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object p1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object p1, p1, v2

    const-string v1, "ImageLength"

    invoke-virtual {p1, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_ed

    :cond_d3
    :goto_d3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Invalid aspect frame values. frame="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/util/Arrays;->toString([I)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v0, "ExifInterface"

    invoke-static {v0, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_ed
    :goto_ed
    return-void
.end method

.method private k(Landroidx/exifinterface/media/a$b;)V
    .registers 8

    sget-boolean v0, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v0, :cond_1a

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "getPngAttributes starting with: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ExifInterface"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1a
    sget-object v0, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {p1, v0}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    sget-object v0, Landroidx/exifinterface/media/a;->H:[B

    array-length v1, v0

    invoke-virtual {p1, v1}, Landroidx/exifinterface/media/a$b;->d(I)V

    array-length v0, v0

    const/4 v1, 0x0

    add-int/2addr v0, v1

    :goto_28
    :try_start_28
    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v2

    const/4 v3, 0x4

    add-int/2addr v0, v3

    new-array v4, v3, [B

    invoke-virtual {p1, v4}, Ljava/io/InputStream;->read([B)I

    move-result v5

    if-ne v5, v3, :cond_d2

    add-int/2addr v0, v3

    const/16 v3, 0x10

    if-ne v0, v3, :cond_4c

    sget-object v3, Landroidx/exifinterface/media/a;->J:[B

    invoke-static {v4, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v3

    if-eqz v3, :cond_44

    goto :goto_4c

    :cond_44
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Encountered invalid PNG file--IHDR chunk should appearas the first chunk"

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_4c
    :goto_4c
    sget-object v3, Landroidx/exifinterface/media/a;->K:[B

    invoke-static {v4, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v3

    if-eqz v3, :cond_55

    goto :goto_8b

    :cond_55
    sget-object v3, Landroidx/exifinterface/media/a;->I:[B

    invoke-static {v4, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v3

    if-eqz v3, :cond_ca

    new-array v3, v2, [B

    invoke-virtual {p1, v3}, Ljava/io/InputStream;->read([B)I

    move-result v5

    if-ne v5, v2, :cond_af

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result p1

    new-instance v2, Ljava/util/zip/CRC32;

    invoke-direct {v2}, Ljava/util/zip/CRC32;-><init>()V

    invoke-virtual {v2, v4}, Ljava/util/zip/CRC32;->update([B)V

    invoke-virtual {v2, v3}, Ljava/util/zip/CRC32;->update([B)V

    invoke-virtual {v2}, Ljava/util/zip/CRC32;->getValue()J

    move-result-wide v4

    long-to-int v5, v4

    if-ne v5, p1, :cond_8c

    iput v0, p0, Landroidx/exifinterface/media/a;->p:I

    invoke-direct {p0, v3, v1}, Landroidx/exifinterface/media/a;->N([BI)V

    invoke-direct {p0}, Landroidx/exifinterface/media/a;->b0()V

    new-instance p1, Landroidx/exifinterface/media/a$b;

    invoke-direct {p1, v3}, Landroidx/exifinterface/media/a$b;-><init>([B)V

    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->X(Landroidx/exifinterface/media/a$b;)V

    :goto_8b
    return-void

    :cond_8c
    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string p1, ", calculated CRC value: "

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/util/zip/CRC32;->getValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v0, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_af
    new-instance p1, Ljava/io/IOException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Failed to read given length for given PNG chunk type: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v4}, Landroidx/exifinterface/media/b;->a([B)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_ca
    add-int/lit8 v2, v2, 0x4

    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$b;->d(I)V

    add-int/2addr v0, v2

    goto/16 :goto_28

    :cond_d2
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Encountered invalid length while parsing PNG chunktype"

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_da
    .catch Ljava/io/EOFException; {:try_start_28 .. :try_end_da} :catch_da

    :catch_da
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Encountered corrupt PNG file."

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private l(Landroidx/exifinterface/media/a$b;)V
    .registers 9

    sget-boolean v0, Landroidx/exifinterface/media/a;->v:Z

    const-string v1, "ExifInterface"

    if-eqz v0, :cond_1a

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "getRafAttributes starting with: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1a
    const/16 v2, 0x54

    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$b;->d(I)V

    const/4 v2, 0x4

    new-array v3, v2, [B

    new-array v4, v2, [B

    new-array v2, v2, [B

    invoke-virtual {p1, v3}, Ljava/io/InputStream;->read([B)I

    invoke-virtual {p1, v4}, Ljava/io/InputStream;->read([B)I

    invoke-virtual {p1, v2}, Ljava/io/InputStream;->read([B)I

    invoke-static {v3}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->getInt()I

    move-result v3

    invoke-static {v4}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/nio/ByteBuffer;->getInt()I

    move-result v4

    invoke-static {v2}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->getInt()I

    move-result v2

    new-array v4, v4, [B

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->a()I

    move-result v5

    sub-int v5, v3, v5

    invoke-virtual {p1, v5}, Landroidx/exifinterface/media/a$b;->d(I)V

    invoke-virtual {p1, v4}, Ljava/io/InputStream;->read([B)I

    new-instance v5, Landroidx/exifinterface/media/a$b;

    invoke-direct {v5, v4}, Landroidx/exifinterface/media/a$b;-><init>([B)V

    const/4 v4, 0x5

    invoke-direct {p0, v5, v3, v4}, Landroidx/exifinterface/media/a;->h(Landroidx/exifinterface/media/a$b;II)V

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->a()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$b;->d(I)V

    sget-object v2, Ljava/nio/ByteOrder;->BIG_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v2

    if-eqz v0, :cond_85

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "numberOfDirectoryEntry: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_85
    const/4 v0, 0x0

    const/4 v3, 0x0

    :goto_87
    if-ge v3, v2, :cond_e4

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v4

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readUnsignedShort()I

    move-result v5

    sget-object v6, Landroidx/exifinterface/media/a;->e0:Landroidx/exifinterface/media/a$e;

    iget v6, v6, Landroidx/exifinterface/media/a$e;->a:I

    if-ne v4, v6, :cond_de

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readShort()S

    move-result v2

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readShort()S

    move-result p1

    iget-object v3, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v2, v3}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v3

    iget-object v4, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {p1, v4}, Landroidx/exifinterface/media/a$d;->j(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v4

    iget-object v5, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v5, v5, v0

    const-string v6, "ImageLength"

    invoke-virtual {v5, v6, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v3, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v3, v0

    const-string v3, "ImageWidth"

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-boolean v0, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v0, :cond_dd

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Updated to length: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v2, ", width: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-static {v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_dd
    return-void

    :cond_de
    invoke-virtual {p1, v5}, Landroidx/exifinterface/media/a$b;->d(I)V

    add-int/lit8 v3, v3, 0x1

    goto :goto_87

    :cond_e4
    return-void
.end method

.method private m(Landroidx/exifinterface/media/a$g;)V
    .registers 5

    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->K(Landroidx/exifinterface/media/a$b;)V

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroidx/exifinterface/media/a;->O(Landroidx/exifinterface/media/a$g;I)V

    invoke-direct {p0, p1, v0}, Landroidx/exifinterface/media/a;->a0(Landroidx/exifinterface/media/a$g;I)V

    const/4 v0, 0x5

    invoke-direct {p0, p1, v0}, Landroidx/exifinterface/media/a;->a0(Landroidx/exifinterface/media/a$g;I)V

    const/4 v0, 0x4

    invoke-direct {p0, p1, v0}, Landroidx/exifinterface/media/a;->a0(Landroidx/exifinterface/media/a$g;I)V

    invoke-direct {p0}, Landroidx/exifinterface/media/a;->b0()V

    iget p1, p0, Landroidx/exifinterface/media/a;->d:I

    const/16 v0, 0x8

    if-ne p1, v0, :cond_54

    iget-object p1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v0, 0x1

    aget-object p1, p1, v0

    const-string v1, "MakerNote"

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/exifinterface/media/a$d;

    if-eqz p1, :cond_54

    new-instance v1, Landroidx/exifinterface/media/a$g;

    iget-object p1, p1, Landroidx/exifinterface/media/a$d;->d:[B

    invoke-direct {v1, p1}, Landroidx/exifinterface/media/a$g;-><init>([B)V

    iget-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v1, p1}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    const/4 p1, 0x6

    invoke-virtual {v1, p1}, Landroidx/exifinterface/media/a$b;->d(I)V

    const/16 p1, 0x9

    invoke-direct {p0, v1, p1}, Landroidx/exifinterface/media/a;->O(Landroidx/exifinterface/media/a$g;I)V

    iget-object v1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object p1, v1, p1

    const-string v1, "ColorSpace"

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/exifinterface/media/a$d;

    if-eqz p1, :cond_54

    iget-object v2, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v2, v0

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_54
    return-void
.end method

.method private o(Landroidx/exifinterface/media/a$g;)V
    .registers 6

    sget-boolean v0, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v0, :cond_1a

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "getRw2Attributes starting with: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ExifInterface"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1a
    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->m(Landroidx/exifinterface/media/a$g;)V

    iget-object p1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v0, 0x0

    aget-object p1, p1, v0

    const-string v1, "JpgFromRaw"

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/exifinterface/media/a$d;

    if-eqz p1, :cond_3a

    new-instance v1, Landroidx/exifinterface/media/a$b;

    iget-object v2, p1, Landroidx/exifinterface/media/a$d;->d:[B

    invoke-direct {v1, v2}, Landroidx/exifinterface/media/a$b;-><init>([B)V

    iget-wide v2, p1, Landroidx/exifinterface/media/a$d;->c:J

    long-to-int p1, v2

    const/4 v2, 0x5

    invoke-direct {p0, v1, p1, v2}, Landroidx/exifinterface/media/a;->h(Landroidx/exifinterface/media/a$b;II)V

    :cond_3a
    iget-object p1, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object p1, p1, v0

    const-string v0, "ISO"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Landroidx/exifinterface/media/a$d;

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    const-string v2, "PhotographicSensitivity"

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/exifinterface/media/a$d;

    if-eqz p1, :cond_5e

    if-nez v0, :cond_5e

    iget-object v0, p0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v0, v0, v1

    invoke-virtual {v0, v2, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_5e
    return-void
.end method

.method private p(Landroidx/exifinterface/media/a$g;)V
    .registers 4

    sget-object v0, Landroidx/exifinterface/media/a;->q0:[B

    array-length v1, v0

    invoke-virtual {p1, v1}, Landroidx/exifinterface/media/a$b;->d(I)V

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->available()I

    move-result v1

    new-array v1, v1, [B

    invoke-virtual {p1, v1}, Landroidx/exifinterface/media/a$b;->readFully([B)V

    array-length p1, v0

    iput p1, p0, Landroidx/exifinterface/media/a;->p:I

    const/4 p1, 0x0

    invoke-direct {p0, v1, p1}, Landroidx/exifinterface/media/a;->N([BI)V

    return-void
.end method

.method private s(Landroidx/exifinterface/media/a$b;)V
    .registers 7

    sget-boolean v0, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v0, :cond_1a

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "getWebpAttributes starting with: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "ExifInterface"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1a
    sget-object v0, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {p1, v0}, Landroidx/exifinterface/media/a$b;->c(Ljava/nio/ByteOrder;)V

    sget-object v0, Landroidx/exifinterface/media/a;->L:[B

    array-length v0, v0

    invoke-virtual {p1, v0}, Landroidx/exifinterface/media/a$b;->d(I)V

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v0

    add-int/lit8 v0, v0, 0x8

    sget-object v1, Landroidx/exifinterface/media/a;->M:[B

    array-length v2, v1

    invoke-virtual {p1, v2}, Landroidx/exifinterface/media/a$b;->d(I)V

    array-length v1, v1

    add-int/lit8 v1, v1, 0x8

    :goto_34
    const/4 v2, 0x4

    :try_start_35
    new-array v3, v2, [B

    invoke-virtual {p1, v3}, Ljava/io/InputStream;->read([B)I

    move-result v4

    if-ne v4, v2, :cond_96

    add-int/2addr v1, v2

    invoke-virtual {p1}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v4

    add-int/2addr v1, v2

    sget-object v2, Landroidx/exifinterface/media/a;->N:[B

    invoke-static {v2, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v2

    if-eqz v2, :cond_7d

    new-array v0, v4, [B

    invoke-virtual {p1, v0}, Ljava/io/InputStream;->read([B)I

    move-result p1

    if-ne p1, v4, :cond_62

    iput v1, p0, Landroidx/exifinterface/media/a;->p:I

    const/4 p1, 0x0

    invoke-direct {p0, v0, p1}, Landroidx/exifinterface/media/a;->N([BI)V

    new-instance p1, Landroidx/exifinterface/media/a$b;

    invoke-direct {p1, v0}, Landroidx/exifinterface/media/a$b;-><init>([B)V

    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->X(Landroidx/exifinterface/media/a$b;)V

    goto :goto_87

    :cond_62
    new-instance p1, Ljava/io/IOException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Failed to read given length for given PNG chunk type: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v3}, Landroidx/exifinterface/media/b;->a([B)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_7d
    rem-int/lit8 v2, v4, 0x2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_84

    add-int/lit8 v4, v4, 0x1

    :cond_84
    add-int/2addr v1, v4

    if-ne v1, v0, :cond_88

    :goto_87
    return-void

    :cond_88
    if-gt v1, v0, :cond_8e

    invoke-virtual {p1, v4}, Landroidx/exifinterface/media/a$b;->d(I)V

    goto :goto_34

    :cond_8e
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Encountered WebP file with invalid chunk size"

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_96
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Encountered invalid length while parsing WebP chunktype"

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
    :try_end_9e
    .catch Ljava/io/EOFException; {:try_start_35 .. :try_end_9e} :catch_9e

    :catch_9e
    new-instance p1, Ljava/io/IOException;

    const-string v0, "Encountered corrupt WebP file."

    invoke-direct {p1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static t(Ljava/lang/String;)Landroid/util/Pair;
    .registers 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Landroid/util/Pair<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    const-string v0, ","

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    const/4 v2, 0x0

    const/4 v3, 0x1

    const/4 v4, 0x2

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    const/4 v6, -0x1

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    if-eqz v1, :cond_a6

    invoke-virtual {p0, v0, v6}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object p0

    aget-object v0, p0, v2

    invoke-static {v0}, Landroidx/exifinterface/media/a;->t(Ljava/lang/String;)Landroid/util/Pair;

    move-result-object v0

    iget-object v1, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ne v1, v4, :cond_29

    return-object v0

    :cond_29
    :goto_29
    array-length v1, p0

    if-ge v3, v1, :cond_a5

    aget-object v1, p0, v3

    invoke-static {v1}, Landroidx/exifinterface/media/a;->t(Ljava/lang/String;)Landroid/util/Pair;

    move-result-object v1

    iget-object v2, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Integer;

    iget-object v4, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    invoke-virtual {v2, v4}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4d

    iget-object v2, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Integer;

    iget-object v4, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    invoke-virtual {v2, v4}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4b

    goto :goto_4d

    :cond_4b
    const/4 v2, -0x1

    goto :goto_55

    :cond_4d
    :goto_4d
    iget-object v2, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    :goto_55
    iget-object v4, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-eq v4, v6, :cond_80

    iget-object v4, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v4, Ljava/lang/Integer;

    iget-object v8, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {v4, v8}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_77

    iget-object v1, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Integer;

    iget-object v4, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    invoke-virtual {v1, v4}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_80

    :cond_77
    iget-object v1, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_81

    :cond_80
    const/4 v1, -0x1

    :goto_81
    if-ne v2, v6, :cond_8b

    if-ne v1, v6, :cond_8b

    new-instance p0, Landroid/util/Pair;

    invoke-direct {p0, v5, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p0

    :cond_8b
    if-ne v2, v6, :cond_97

    new-instance v0, Landroid/util/Pair;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {v0, v1, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_a2

    :cond_97
    if-ne v1, v6, :cond_a2

    new-instance v0, Landroid/util/Pair;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {v0, v1, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    :cond_a2
    :goto_a2
    add-int/lit8 v3, v3, 0x1

    goto :goto_29

    :cond_a5
    return-object v0

    :cond_a6
    const-string v0, "/"

    invoke-virtual {p0, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    const-wide/16 v8, 0x0

    if-eqz v1, :cond_105

    invoke-virtual {p0, v0, v6}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object p0

    array-length v0, p0

    if-ne v0, v4, :cond_ff

    :try_start_b7
    aget-object v0, p0, v2

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    double-to-long v0, v0

    aget-object p0, p0, v3

    invoke-static {p0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-long v2, v2

    const/16 p0, 0xa

    cmp-long v4, v0, v8

    if-ltz v4, :cond_f5

    cmp-long v4, v2, v8

    if-gez v4, :cond_d0

    goto :goto_f5

    :cond_d0
    const/4 v4, 0x5

    const-wide/32 v8, 0x7fffffff

    cmp-long v6, v0, v8

    if-gtz v6, :cond_eb

    cmp-long v0, v2, v8

    if-lez v0, :cond_dd

    goto :goto_eb

    :cond_dd
    new-instance v0, Landroid/util/Pair;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0

    :cond_eb
    :goto_eb
    new-instance p0, Landroid/util/Pair;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-direct {p0, v0, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p0

    :cond_f5
    :goto_f5
    new-instance v0, Landroid/util/Pair;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p0

    invoke-direct {v0, p0, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_fe
    .catch Ljava/lang/NumberFormatException; {:try_start_b7 .. :try_end_fe} :catch_ff

    return-object v0

    :catch_ff
    :cond_ff
    new-instance p0, Landroid/util/Pair;

    invoke-direct {p0, v5, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p0

    :cond_105
    :try_start_105
    invoke-static {p0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    const/4 v3, 0x4

    cmp-long v4, v1, v8

    if-ltz v4, :cond_130

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    const-wide/32 v10, 0xffff

    cmp-long v4, v1, v10

    if-gtz v4, :cond_130

    new-instance v0, Landroid/util/Pair;

    const/4 v1, 0x3

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0

    :cond_130
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    cmp-long v2, v0, v8

    if-gez v2, :cond_144

    new-instance v0, Landroid/util/Pair;

    const/16 v1, 0x9

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {v0, v1, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0

    :cond_144
    new-instance v0, Landroid/util/Pair;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {v0, v1, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_14d
    .catch Ljava/lang/NumberFormatException; {:try_start_105 .. :try_end_14d} :catch_14e

    return-object v0

    :catch_14e
    :try_start_14e
    invoke-static {p0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    new-instance p0, Landroid/util/Pair;

    const/16 v0, 0xc

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-direct {p0, v0, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_15c
    .catch Ljava/lang/NumberFormatException; {:try_start_14e .. :try_end_15c} :catch_15d

    return-object p0

    :catch_15d
    new-instance p0, Landroid/util/Pair;

    invoke-direct {p0, v5, v7}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object p0
.end method

.method private u(Landroidx/exifinterface/media/a$b;Ljava/util/HashMap;)V
    .registers 7

    const-string v0, "JPEGInterchangeFormat"

    invoke-virtual {p2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/exifinterface/media/a$d;

    const-string v1, "JPEGInterchangeFormatLength"

    invoke-virtual {p2, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Landroidx/exifinterface/media/a$d;

    if-eqz v0, :cond_6c

    if-eqz p2, :cond_6c

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, v1}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result v0

    iget-object v1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {p2, v1}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result p2

    iget v1, p0, Landroidx/exifinterface/media/a;->d:I

    const/4 v2, 0x7

    if-ne v1, v2, :cond_28

    iget v1, p0, Landroidx/exifinterface/media/a;->q:I

    add-int/2addr v0, v1

    :cond_28
    if-lez v0, :cond_4a

    if-lez p2, :cond_4a

    const/4 v1, 0x1

    iput-boolean v1, p0, Landroidx/exifinterface/media/a;->i:Z

    iget-object v1, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    if-nez v1, :cond_46

    iget-object v1, p0, Landroidx/exifinterface/media/a;->c:Landroid/content/res/AssetManager$AssetInputStream;

    if-nez v1, :cond_46

    iget-object v1, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    if-nez v1, :cond_46

    new-array v1, p2, [B

    int-to-long v2, v0

    invoke-virtual {p1, v2, v3}, Ljava/io/InputStream;->skip(J)J

    invoke-virtual {p1, v1}, Ljava/io/InputStream;->read([B)I

    iput-object v1, p0, Landroidx/exifinterface/media/a;->n:[B

    :cond_46
    iput v0, p0, Landroidx/exifinterface/media/a;->l:I

    iput p2, p0, Landroidx/exifinterface/media/a;->m:I

    :cond_4a
    sget-boolean p1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz p1, :cond_6c

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Setting thumbnail attributes with offset: "

    invoke-virtual {p1, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v0, ", length: "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string p2, "ExifInterface"

    invoke-static {p2, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_6c
    return-void
.end method

.method private v(Landroidx/exifinterface/media/a$b;Ljava/util/HashMap;)V
    .registers 22

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    const-string v3, "StripOffsets"

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/exifinterface/media/a$d;

    const-string v4, "StripByteCounts"

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/exifinterface/media/a$d;

    if-eqz v3, :cond_eb

    if-eqz v2, :cond_eb

    iget-object v4, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v3, v4}, Landroidx/exifinterface/media/a$d;->o(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v3}, Landroidx/exifinterface/media/b;->d(Ljava/lang/Object;)[J

    move-result-object v3

    iget-object v4, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v2, v4}, Landroidx/exifinterface/media/a$d;->o(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Landroidx/exifinterface/media/b;->d(Ljava/lang/Object;)[J

    move-result-object v2

    const-string v4, "ExifInterface"

    if-eqz v3, :cond_e6

    array-length v5, v3

    if-nez v5, :cond_37

    goto/16 :goto_e6

    :cond_37
    if-eqz v2, :cond_e0

    array-length v5, v2

    if-nez v5, :cond_3e

    goto/16 :goto_e0

    :cond_3e
    array-length v5, v3

    array-length v6, v2

    if-eq v5, v6, :cond_48

    const-string v1, "stripOffsets and stripByteCounts should have same length."

    invoke-static {v4, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_48
    const-wide/16 v5, 0x0

    array-length v7, v2

    const/4 v8, 0x0

    const/4 v9, 0x0

    :goto_4d
    if-ge v9, v7, :cond_55

    aget-wide v10, v2, v9

    add-long/2addr v5, v10

    add-int/lit8 v9, v9, 0x1

    goto :goto_4d

    :cond_55
    long-to-int v6, v5

    new-array v5, v6, [B

    const/4 v7, 0x1

    iput-boolean v7, v0, Landroidx/exifinterface/media/a;->k:Z

    iput-boolean v7, v0, Landroidx/exifinterface/media/a;->j:Z

    iput-boolean v7, v0, Landroidx/exifinterface/media/a;->i:Z

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    :goto_62
    array-length v12, v3

    if-ge v9, v12, :cond_d2

    aget-wide v12, v3, v9

    long-to-int v13, v12

    aget-wide v14, v2, v9

    long-to-int v12, v14

    array-length v14, v3

    sub-int/2addr v14, v7

    if-ge v9, v14, :cond_7c

    add-int v14, v13, v12

    int-to-long v14, v14

    add-int/lit8 v16, v9, 0x1

    aget-wide v16, v3, v16

    cmp-long v18, v14, v16

    if-eqz v18, :cond_7c

    iput-boolean v8, v0, Landroidx/exifinterface/media/a;->k:Z

    :cond_7c
    sub-int/2addr v13, v10

    if-gez v13, :cond_85

    const-string v1, "Invalid strip offset value"

    invoke-static {v4, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_85
    int-to-long v14, v13

    invoke-virtual {v1, v14, v15}, Ljava/io/InputStream;->skip(J)J

    move-result-wide v16

    const-string v7, " bytes."

    cmp-long v18, v16, v14

    if-eqz v18, :cond_a8

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to skip "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_a8
    add-int/2addr v10, v13

    new-array v13, v12, [B

    invoke-virtual {v1, v13}, Ljava/io/InputStream;->read([B)I

    move-result v14

    if-eq v14, v12, :cond_c9

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to read "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_c9
    add-int/2addr v10, v12

    invoke-static {v13, v8, v5, v11, v12}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    add-int/2addr v11, v12

    add-int/lit8 v9, v9, 0x1

    const/4 v7, 0x1

    goto :goto_62

    :cond_d2
    iput-object v5, v0, Landroidx/exifinterface/media/a;->n:[B

    iget-boolean v1, v0, Landroidx/exifinterface/media/a;->k:Z

    if-eqz v1, :cond_eb

    aget-wide v1, v3, v8

    long-to-int v2, v1

    iput v2, v0, Landroidx/exifinterface/media/a;->l:I

    iput v6, v0, Landroidx/exifinterface/media/a;->m:I

    goto :goto_eb

    :cond_e0
    :goto_e0
    const-string v1, "stripByteCounts should not be null or have zero length."

    invoke-static {v4, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_e6
    :goto_e6
    const-string v1, "stripOffsets should not be null or have zero length."

    invoke-static {v4, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    :cond_eb
    :goto_eb
    return-void
.end method

.method private w(Ljava/lang/String;)V
    .registers 4

    if-eqz p1, :cond_2e

    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/exifinterface/media/a;->c:Landroid/content/res/AssetManager$AssetInputStream;

    iput-object p1, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    :try_start_7
    new-instance v1, Ljava/io/FileInputStream;

    invoke-direct {v1, p1}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_c
    .catchall {:try_start_7 .. :try_end_c} :catchall_29

    :try_start_c
    invoke-virtual {v1}, Ljava/io/FileInputStream;->getFD()Ljava/io/FileDescriptor;

    move-result-object p1

    invoke-static {p1}, Landroidx/exifinterface/media/a;->E(Ljava/io/FileDescriptor;)Z

    move-result p1

    if-eqz p1, :cond_1d

    invoke-virtual {v1}, Ljava/io/FileInputStream;->getFD()Ljava/io/FileDescriptor;

    move-result-object p1

    iput-object p1, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    goto :goto_1f

    :cond_1d
    iput-object v0, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    :goto_1f
    invoke-direct {p0, v1}, Landroidx/exifinterface/media/a;->J(Ljava/io/InputStream;)V
    :try_end_22
    .catchall {:try_start_c .. :try_end_22} :catchall_26

    invoke-static {v1}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    return-void

    :catchall_26
    move-exception p1

    move-object v0, v1

    goto :goto_2a

    :catchall_29
    move-exception p1

    :goto_2a
    invoke-static {v0}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    throw p1

    :cond_2e
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "filename cannot be null"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method private static x(Ljava/io/BufferedInputStream;)Z
    .registers 5

    sget-object v0, Landroidx/exifinterface/media/a;->q0:[B

    array-length v1, v0

    invoke-virtual {p0, v1}, Ljava/io/BufferedInputStream;->mark(I)V

    array-length v0, v0

    new-array v0, v0, [B

    invoke-virtual {p0, v0}, Ljava/io/InputStream;->read([B)I

    invoke-virtual {p0}, Ljava/io/BufferedInputStream;->reset()V

    const/4 p0, 0x0

    const/4 v1, 0x0

    :goto_11
    sget-object v2, Landroidx/exifinterface/media/a;->q0:[B

    array-length v3, v2

    if-ge v1, v3, :cond_20

    aget-byte v3, v0, v1

    aget-byte v2, v2, v1

    if-eq v3, v2, :cond_1d

    return p0

    :cond_1d
    add-int/lit8 v1, v1, 0x1

    goto :goto_11

    :cond_20
    const/4 p0, 0x1

    return p0
.end method

.method private y([B)Z
    .registers 16

    const/4 v0, 0x0

    const/4 v1, 0x0

    :try_start_2
    new-instance v2, Landroidx/exifinterface/media/a$b;

    invoke-direct {v2, p1}, Landroidx/exifinterface/media/a$b;-><init>([B)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_7} :catch_8d
    .catchall {:try_start_2 .. :try_end_7} :catchall_8b

    :try_start_7
    invoke-virtual {v2}, Landroidx/exifinterface/media/a$b;->readInt()I

    move-result v1

    int-to-long v3, v1

    const/4 v1, 0x4

    new-array v5, v1, [B

    invoke-virtual {v2, v5}, Ljava/io/InputStream;->read([B)I

    sget-object v6, Landroidx/exifinterface/media/a;->C:[B

    invoke-static {v5, v6}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v5
    :try_end_18
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_18} :catch_88
    .catchall {:try_start_7 .. :try_end_18} :catchall_85

    if-nez v5, :cond_1e

    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    return v0

    :cond_1e
    const-wide/16 v5, 0x10

    const-wide/16 v7, 0x8

    const-wide/16 v9, 0x1

    cmp-long v11, v3, v9

    if-nez v11, :cond_34

    :try_start_28
    invoke-virtual {v2}, Landroidx/exifinterface/media/a$b;->readLong()J

    move-result-wide v3
    :try_end_2c
    .catch Ljava/lang/Exception; {:try_start_28 .. :try_end_2c} :catch_88
    .catchall {:try_start_28 .. :try_end_2c} :catchall_85

    cmp-long v11, v3, v5

    if-gez v11, :cond_35

    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    return v0

    :cond_34
    move-wide v5, v7

    :cond_35
    :try_start_35
    array-length v11, p1

    int-to-long v11, v11

    cmp-long v13, v3, v11

    if-lez v13, :cond_3d

    array-length p1, p1
    :try_end_3c
    .catch Ljava/lang/Exception; {:try_start_35 .. :try_end_3c} :catch_88
    .catchall {:try_start_35 .. :try_end_3c} :catchall_85

    int-to-long v3, p1

    :cond_3d
    sub-long/2addr v3, v5

    cmp-long p1, v3, v7

    if-gez p1, :cond_46

    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    return v0

    :cond_46
    :try_start_46
    new-array p1, v1, [B

    const-wide/16 v5, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    :goto_4c
    const-wide/16 v11, 0x4

    div-long v11, v3, v11

    cmp-long v13, v5, v11

    if-gez v13, :cond_81

    invoke-virtual {v2, p1}, Ljava/io/InputStream;->read([B)I

    move-result v11
    :try_end_58
    .catch Ljava/lang/Exception; {:try_start_46 .. :try_end_58} :catch_88
    .catchall {:try_start_46 .. :try_end_58} :catchall_85

    if-eq v11, v1, :cond_5e

    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    return v0

    :cond_5e
    cmp-long v11, v5, v9

    if-nez v11, :cond_63

    goto :goto_7f

    :cond_63
    :try_start_63
    sget-object v11, Landroidx/exifinterface/media/a;->D:[B

    invoke-static {p1, v11}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v11

    const/4 v12, 0x1

    if-eqz v11, :cond_6e

    const/4 v7, 0x1

    goto :goto_77

    :cond_6e
    sget-object v11, Landroidx/exifinterface/media/a;->E:[B

    invoke-static {p1, v11}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v11
    :try_end_74
    .catch Ljava/lang/Exception; {:try_start_63 .. :try_end_74} :catch_88
    .catchall {:try_start_63 .. :try_end_74} :catchall_85

    if-eqz v11, :cond_77

    const/4 v8, 0x1

    :cond_77
    :goto_77
    if-eqz v7, :cond_7f

    if-eqz v8, :cond_7f

    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    return v12

    :cond_7f
    :goto_7f
    add-long/2addr v5, v9

    goto :goto_4c

    :cond_81
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    goto :goto_9e

    :catchall_85
    move-exception p1

    move-object v1, v2

    goto :goto_9f

    :catch_88
    move-exception p1

    move-object v1, v2

    goto :goto_8e

    :catchall_8b
    move-exception p1

    goto :goto_9f

    :catch_8d
    move-exception p1

    :goto_8e
    :try_start_8e
    sget-boolean v2, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v2, :cond_99

    const-string v2, "ExifInterface"

    const-string v3, "Exception parsing HEIF file type box."

    invoke-static {v2, v3, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_99
    .catchall {:try_start_8e .. :try_end_99} :catchall_8b

    :cond_99
    if-eqz v1, :cond_9e

    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    :cond_9e
    :goto_9e
    return v0

    :goto_9f
    if-eqz v1, :cond_a4

    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    :cond_a4
    throw p1
.end method

.method private static z([B)Z
    .registers 5

    const/4 v0, 0x0

    const/4 v1, 0x0

    :goto_2
    sget-object v2, Landroidx/exifinterface/media/a;->B:[B

    array-length v3, v2

    if-ge v1, v3, :cond_11

    aget-byte v3, p0, v1

    aget-byte v2, v2, v1

    if-eq v3, v2, :cond_e

    return v0

    :cond_e
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_11
    const/4 p0, 0x1

    return p0
.end method


# virtual methods
.method public S()V
    .registers 14

    iget v0, p0, Landroidx/exifinterface/media/a;->d:I

    invoke-static {v0}, Landroidx/exifinterface/media/a;->G(I)Z

    move-result v0

    if-eqz v0, :cond_16b

    iget-object v0, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    if-nez v0, :cond_19

    iget-object v0, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    if-eqz v0, :cond_11

    goto :goto_19

    :cond_11
    new-instance v0, Ljava/io/IOException;

    const-string v1, "ExifInterface does not support saving attributes for the current input."

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_19
    :goto_19
    iget-boolean v0, p0, Landroidx/exifinterface/media/a;->i:Z

    if-eqz v0, :cond_2e

    iget-boolean v0, p0, Landroidx/exifinterface/media/a;->j:Z

    if-eqz v0, :cond_2e

    iget-boolean v0, p0, Landroidx/exifinterface/media/a;->k:Z

    if-eqz v0, :cond_26

    goto :goto_2e

    :cond_26
    new-instance v0, Ljava/io/IOException;

    const-string v1, "ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips"

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2e
    :goto_2e
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/exifinterface/media/a;->t:Z

    invoke-virtual {p0}, Landroidx/exifinterface/media/a;->q()[B

    move-result-object v1

    iput-object v1, p0, Landroidx/exifinterface/media/a;->n:[B

    const/4 v1, 0x0

    :try_start_38
    const-string v2, "temp"

    const-string v3, "tmp"

    invoke-static {v2, v3}, Ljava/io/File;->createTempFile(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    iget-object v3, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    const-wide/16 v4, 0x0

    if-eqz v3, :cond_4e

    new-instance v3, Ljava/io/FileInputStream;

    iget-object v6, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    invoke-direct {v3, v6}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    goto :goto_5c

    :cond_4e
    iget-object v3, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    sget v6, Landroid/system/OsConstants;->SEEK_SET:I

    invoke-static {v3, v4, v5, v6}, Landroidx/exifinterface/media/b$a;->c(Ljava/io/FileDescriptor;JI)J

    new-instance v3, Ljava/io/FileInputStream;

    iget-object v6, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    invoke-direct {v3, v6}, Ljava/io/FileInputStream;-><init>(Ljava/io/FileDescriptor;)V
    :try_end_5c
    .catch Ljava/lang/Exception; {:try_start_38 .. :try_end_5c} :catch_159
    .catchall {:try_start_38 .. :try_end_5c} :catchall_156

    :goto_5c
    :try_start_5c
    new-instance v6, Ljava/io/FileOutputStream;

    invoke-direct {v6, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_61
    .catch Ljava/lang/Exception; {:try_start_5c .. :try_end_61} :catch_152
    .catchall {:try_start_5c .. :try_end_61} :catchall_14e

    :try_start_61
    invoke-static {v3, v6}, Landroidx/exifinterface/media/b;->e(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    :try_end_64
    .catch Ljava/lang/Exception; {:try_start_61 .. :try_end_64} :catch_14c
    .catchall {:try_start_61 .. :try_end_64} :catchall_14a

    invoke-static {v3}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    invoke-static {v6}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    const/4 v3, 0x0

    :try_start_6b
    new-instance v6, Ljava/io/FileInputStream;

    invoke-direct {v6, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_70
    .catch Ljava/lang/Exception; {:try_start_6b .. :try_end_70} :catch_d6
    .catchall {:try_start_6b .. :try_end_70} :catchall_d2

    :try_start_70
    iget-object v7, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    if-eqz v7, :cond_7c

    new-instance v7, Ljava/io/FileOutputStream;

    iget-object v8, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    invoke-direct {v7, v8}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    goto :goto_8a

    :cond_7c
    iget-object v7, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    sget v8, Landroid/system/OsConstants;->SEEK_SET:I

    invoke-static {v7, v4, v5, v8}, Landroidx/exifinterface/media/b$a;->c(Ljava/io/FileDescriptor;JI)J

    new-instance v7, Ljava/io/FileOutputStream;

    iget-object v8, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    invoke-direct {v7, v8}, Ljava/io/FileOutputStream;-><init>(Ljava/io/FileDescriptor;)V
    :try_end_8a
    .catch Ljava/lang/Exception; {:try_start_70 .. :try_end_8a} :catch_cd
    .catchall {:try_start_70 .. :try_end_8a} :catchall_d2

    :goto_8a
    :try_start_8a
    new-instance v8, Ljava/io/BufferedInputStream;

    invoke-direct {v8, v6}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_8f
    .catch Ljava/lang/Exception; {:try_start_8a .. :try_end_8f} :catch_c7
    .catchall {:try_start_8a .. :try_end_8f} :catchall_d2

    :try_start_8f
    new-instance v9, Ljava/io/BufferedOutputStream;

    invoke-direct {v9, v7}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_94
    .catch Ljava/lang/Exception; {:try_start_8f .. :try_end_94} :catch_c1
    .catchall {:try_start_8f .. :try_end_94} :catchall_bd

    :try_start_94
    iget v10, p0, Landroidx/exifinterface/media/a;->d:I

    const/4 v11, 0x4

    if-ne v10, v11, :cond_9d

    invoke-direct {p0, v8, v9}, Landroidx/exifinterface/media/a;->T(Ljava/io/InputStream;Ljava/io/OutputStream;)V

    goto :goto_ac

    :cond_9d
    const/16 v11, 0xd

    if-ne v10, v11, :cond_a5

    invoke-direct {p0, v8, v9}, Landroidx/exifinterface/media/a;->U(Ljava/io/InputStream;Ljava/io/OutputStream;)V

    goto :goto_ac

    :cond_a5
    const/16 v11, 0xe

    if-ne v10, v11, :cond_ac

    invoke-direct {p0, v8, v9}, Landroidx/exifinterface/media/a;->V(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    :try_end_ac
    .catch Ljava/lang/Exception; {:try_start_94 .. :try_end_ac} :catch_b8
    .catchall {:try_start_94 .. :try_end_ac} :catchall_13c

    :cond_ac
    :goto_ac
    invoke-static {v8}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    invoke-static {v9}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    iput-object v1, p0, Landroidx/exifinterface/media/a;->n:[B

    return-void

    :catch_b8
    move-exception v1

    move-object v12, v6

    move-object v6, v1

    move-object v1, v12

    goto :goto_db

    :catchall_bd
    move-exception v0

    move-object v9, v1

    goto/16 :goto_13d

    :catch_c1
    move-exception v9

    move-object v12, v9

    move-object v9, v1

    move-object v1, v6

    move-object v6, v12

    goto :goto_db

    :catch_c7
    move-exception v8

    move-object v9, v1

    move-object v1, v6

    move-object v6, v8

    move-object v8, v9

    goto :goto_db

    :catch_cd
    move-exception v7

    move-object v8, v1

    move-object v9, v8

    move-object v1, v6

    goto :goto_d9

    :catchall_d2
    move-exception v0

    move-object v9, v1

    goto/16 :goto_13e

    :catch_d6
    move-exception v7

    move-object v8, v1

    move-object v9, v8

    :goto_d9
    move-object v6, v7

    move-object v7, v9

    :goto_db
    :try_start_db
    new-instance v10, Ljava/io/FileInputStream;

    invoke-direct {v10, v2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_e0
    .catch Ljava/lang/Exception; {:try_start_db .. :try_end_e0} :catch_113
    .catchall {:try_start_db .. :try_end_e0} :catchall_111

    :try_start_e0
    iget-object v1, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    if-nez v1, :cond_f3

    iget-object v1, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    sget v11, Landroid/system/OsConstants;->SEEK_SET:I

    invoke-static {v1, v4, v5, v11}, Landroidx/exifinterface/media/b$a;->c(Ljava/io/FileDescriptor;JI)J

    new-instance v1, Ljava/io/FileOutputStream;

    iget-object v4, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    invoke-direct {v1, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/FileDescriptor;)V

    goto :goto_fa

    :cond_f3
    new-instance v1, Ljava/io/FileOutputStream;

    iget-object v4, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    invoke-direct {v1, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    :goto_fa
    move-object v7, v1

    invoke-static {v10, v7}, Landroidx/exifinterface/media/b;->e(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    :try_end_fe
    .catch Ljava/lang/Exception; {:try_start_e0 .. :try_end_fe} :catch_10f
    .catchall {:try_start_e0 .. :try_end_fe} :catchall_10c

    :try_start_fe
    invoke-static {v10}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    invoke-static {v7}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    new-instance v0, Ljava/io/IOException;

    const-string v1, "Failed to save new file"

    invoke-direct {v0, v1, v6}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0
    :try_end_10c
    .catchall {:try_start_fe .. :try_end_10c} :catchall_13c

    :catchall_10c
    move-exception v0

    move-object v1, v10

    goto :goto_135

    :catch_10f
    move-exception v1

    goto :goto_116

    :catchall_111
    move-exception v0

    goto :goto_135

    :catch_113
    move-exception v3

    move-object v10, v1

    move-object v1, v3

    :goto_116
    :try_start_116
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Failed to save new file. Original file is stored in "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
    :try_end_131
    .catchall {:try_start_116 .. :try_end_131} :catchall_131

    :catchall_131
    move-exception v1

    move-object v0, v1

    move-object v1, v10

    const/4 v3, 0x1

    :goto_135
    :try_start_135
    invoke-static {v1}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    invoke-static {v7}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    throw v0
    :try_end_13c
    .catchall {:try_start_135 .. :try_end_13c} :catchall_13c

    :catchall_13c
    move-exception v0

    :goto_13d
    move-object v1, v8

    :goto_13e
    invoke-static {v1}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    invoke-static {v9}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    if-nez v3, :cond_149

    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    :cond_149
    throw v0

    :catchall_14a
    move-exception v0

    goto :goto_150

    :catch_14c
    move-exception v0

    goto :goto_154

    :catchall_14e
    move-exception v0

    move-object v6, v1

    :goto_150
    move-object v1, v3

    goto :goto_164

    :catch_152
    move-exception v0

    move-object v6, v1

    :goto_154
    move-object v1, v3

    goto :goto_15b

    :catchall_156
    move-exception v0

    move-object v6, v1

    goto :goto_164

    :catch_159
    move-exception v0

    move-object v6, v1

    :goto_15b
    :try_start_15b
    new-instance v2, Ljava/io/IOException;

    const-string v3, "Failed to copy original file to temp file"

    invoke-direct {v2, v3, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
    :try_end_163
    .catchall {:try_start_15b .. :try_end_163} :catchall_163

    :catchall_163
    move-exception v0

    :goto_164
    invoke-static {v1}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    invoke-static {v6}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    throw v0

    :cond_16b
    new-instance v0, Ljava/io/IOException;

    const-string v1, "ExifInterface only supports saving attributes for JPEG, PNG, and WebP formats."

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public W(Ljava/lang/String;Ljava/lang/String;)V
    .registers 20

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    if-eqz v1, :cond_332

    const-string v3, "DateTime"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    const-string v4, " : "

    const-string v5, "Invalid value for "

    const-string v6, "ExifInterface"

    if-nez v3, :cond_26

    const-string v3, "DateTimeOriginal"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_26

    const-string v3, "DateTimeDigitized"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6d

    :cond_26
    if-eqz v2, :cond_6d

    sget-object v3, Landroidx/exifinterface/media/a;->u0:Ljava/util/regex/Pattern;

    invoke-virtual {v3, v2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/regex/Matcher;->find()Z

    move-result v3

    sget-object v7, Landroidx/exifinterface/media/a;->v0:Ljava/util/regex/Pattern;

    invoke-virtual {v7, v2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/regex/Matcher;->find()Z

    move-result v7

    invoke-virtual/range {p2 .. p2}, Ljava/lang/String;->length()I

    move-result v8

    const/16 v9, 0x13

    if-ne v8, v9, :cond_54

    if-nez v3, :cond_49

    if-nez v7, :cond_49

    goto :goto_54

    :cond_49
    if-eqz v7, :cond_6d

    const-string v3, "-"

    const-string v7, ":"

    invoke-virtual {v2, v3, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    goto :goto_6d

    :cond_54
    :goto_54
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    :goto_59
    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v6, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-void

    :cond_6d
    :goto_6d
    const-string v3, "ISOSpeedRatings"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_80

    sget-boolean v1, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v1, :cond_7e

    const-string v1, "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY."

    invoke-static {v6, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    :cond_7e
    const-string v1, "PhotographicSensitivity"

    :cond_80
    const/4 v3, 0x2

    const/4 v7, 0x1

    if-eqz v2, :cond_f4

    sget-object v8, Landroidx/exifinterface/media/a;->n0:Ljava/util/HashSet;

    invoke-virtual {v8, v1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_f4

    const-string v8, "GPSTimeStamp"

    invoke-virtual {v1, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_df

    sget-object v8, Landroidx/exifinterface/media/a;->t0:Ljava/util/regex/Pattern;

    invoke-virtual {v8, v2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v8

    invoke-virtual {v8}, Ljava/util/regex/Matcher;->find()Z

    move-result v9

    if-nez v9, :cond_a6

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    goto :goto_59

    :cond_a6
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v7}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v4, "/1,"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8, v3}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v4, 0x3

    invoke-virtual {v8, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v4, "/1"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_f4

    :cond_df
    :try_start_df
    invoke-static {v2}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v8

    new-instance v10, Landroidx/exifinterface/media/a$f;

    invoke-direct {v10, v8, v9}, Landroidx/exifinterface/media/a$f;-><init>(D)V

    invoke-virtual {v10}, Landroidx/exifinterface/media/a$f;->toString()Ljava/lang/String;

    move-result-object v2
    :try_end_ec
    .catch Ljava/lang/NumberFormatException; {:try_start_df .. :try_end_ec} :catch_ed

    goto :goto_f4

    :catch_ed
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    goto/16 :goto_59

    :cond_f4
    :goto_f4
    const/4 v4, 0x0

    const/4 v5, 0x0

    :goto_f6
    sget-object v8, Landroidx/exifinterface/media/a;->j0:[[Landroidx/exifinterface/media/a$e;

    array-length v8, v8

    if-ge v5, v8, :cond_331

    const/4 v8, 0x4

    if-ne v5, v8, :cond_104

    iget-boolean v8, v0, Landroidx/exifinterface/media/a;->i:Z

    if-nez v8, :cond_104

    goto/16 :goto_329

    :cond_104
    sget-object v8, Landroidx/exifinterface/media/a;->m0:[Ljava/util/HashMap;

    aget-object v8, v8, v5

    invoke-virtual {v8, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/exifinterface/media/a$e;

    if-eqz v8, :cond_329

    if-nez v2, :cond_11b

    iget-object v8, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v8, v8, v5

    invoke-virtual {v8, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_329

    :cond_11b
    invoke-static {v2}, Landroidx/exifinterface/media/a;->t(Ljava/lang/String;)Landroid/util/Pair;

    move-result-object v9

    iget v10, v8, Landroidx/exifinterface/media/a$e;->c:I

    iget-object v11, v9, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v11, Ljava/lang/Integer;

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    const/4 v12, -0x1

    if-eq v10, v11, :cond_1eb

    iget v10, v8, Landroidx/exifinterface/media/a$e;->c:I

    iget-object v11, v9, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v11, Ljava/lang/Integer;

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    if-ne v10, v11, :cond_13a

    goto/16 :goto_1eb

    :cond_13a
    iget v10, v8, Landroidx/exifinterface/media/a$e;->d:I

    if-eq v10, v12, :cond_158

    iget-object v11, v9, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v11, Ljava/lang/Integer;

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    if-eq v10, v11, :cond_154

    iget v10, v8, Landroidx/exifinterface/media/a$e;->d:I

    iget-object v11, v9, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v11, Ljava/lang/Integer;

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    if-ne v10, v11, :cond_158

    :cond_154
    iget v8, v8, Landroidx/exifinterface/media/a$e;->d:I

    goto/16 :goto_1ed

    :cond_158
    iget v10, v8, Landroidx/exifinterface/media/a$e;->c:I

    if-eq v10, v7, :cond_1e9

    const/4 v11, 0x7

    if-eq v10, v11, :cond_1e9

    if-ne v10, v3, :cond_163

    goto/16 :goto_1e9

    :cond_163
    sget-boolean v10, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v10, :cond_329

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Given tag ("

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v11, ") value didn\'t match with one of expected formats: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v11, Landroidx/exifinterface/media/a;->W:[Ljava/lang/String;

    iget v13, v8, Landroidx/exifinterface/media/a$e;->c:I

    aget-object v13, v11, v13

    invoke-virtual {v10, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v13, v8, Landroidx/exifinterface/media/a$e;->d:I

    const-string v14, ""

    const-string v15, ", "

    if-ne v13, v12, :cond_18c

    move-object v8, v14

    goto :goto_19f

    :cond_18c
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v8, v8, Landroidx/exifinterface/media/a$e;->d:I

    aget-object v8, v11, v8

    invoke-virtual {v13, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    :goto_19f
    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v8, " (guess: "

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v8, v9, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v8, Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    aget-object v8, v11, v8

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v8, v9, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v8, Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    if-ne v8, v12, :cond_1bf

    goto :goto_1d8

    :cond_1bf
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v9, v9, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v9, Ljava/lang/Integer;

    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v9

    aget-object v9, v11, v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    :goto_1d8
    invoke-virtual {v10, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v8, ")"

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v6, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_329

    :cond_1e9
    :goto_1e9
    move v8, v10

    goto :goto_1ed

    :cond_1eb
    :goto_1eb
    iget v8, v8, Landroidx/exifinterface/media/a$e;->c:I

    :goto_1ed
    const-string v9, "/"

    const-string v10, ","

    packed-switch v8, :pswitch_data_33a

    :pswitch_1f4
    const/4 v15, 0x1

    sget-boolean v3, Landroidx/exifinterface/media/a;->v:Z

    if-eqz v3, :cond_32a

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Data format isn\'t one of expected formats: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v6, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_32a

    :pswitch_20f
    invoke-virtual {v2, v10, v12}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v8

    array-length v9, v8

    new-array v9, v9, [D

    const/4 v10, 0x0

    :goto_217
    array-length v11, v8

    if-ge v10, v11, :cond_225

    aget-object v11, v8, v10

    invoke-static {v11}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v11

    aput-wide v11, v9, v10

    add-int/lit8 v10, v10, 0x1

    goto :goto_217

    :cond_225
    iget-object v8, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v8, v8, v5

    iget-object v10, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v9, v10}, Landroidx/exifinterface/media/a$d;->b([DLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v9

    invoke-virtual {v8, v1, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_329

    :pswitch_234
    invoke-virtual {v2, v10, v12}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v8

    array-length v10, v8

    new-array v10, v10, [Landroidx/exifinterface/media/a$f;

    const/4 v11, 0x0

    :goto_23c
    array-length v13, v8

    if-ge v11, v13, :cond_264

    aget-object v13, v8, v11

    invoke-virtual {v13, v9, v12}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v13

    new-instance v14, Landroidx/exifinterface/media/a$f;

    aget-object v15, v13, v4

    invoke-static {v15}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v3

    double-to-long v3, v3

    aget-object v13, v13, v7

    move-object/from16 v16, v8

    invoke-static {v13}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v7

    double-to-long v7, v7

    invoke-direct {v14, v3, v4, v7, v8}, Landroidx/exifinterface/media/a$f;-><init>(JJ)V

    aput-object v14, v10, v11

    add-int/lit8 v11, v11, 0x1

    move-object/from16 v8, v16

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v7, 0x1

    goto :goto_23c

    :cond_264
    iget-object v3, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v5

    iget-object v4, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v10, v4}, Landroidx/exifinterface/media/a$d;->d([Landroidx/exifinterface/media/a$f;Ljava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v4

    goto :goto_28f

    :pswitch_26f
    invoke-virtual {v2, v10, v12}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v3

    array-length v4, v3

    new-array v4, v4, [I

    const/4 v7, 0x0

    :goto_277
    array-length v8, v3

    if-ge v7, v8, :cond_285

    aget-object v8, v3, v7

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    aput v8, v4, v7

    add-int/lit8 v7, v7, 0x1

    goto :goto_277

    :cond_285
    iget-object v3, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v5

    iget-object v7, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v4, v7}, Landroidx/exifinterface/media/a$d;->c([ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v4

    :goto_28f
    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_329

    :pswitch_294
    invoke-virtual {v2, v10, v12}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v3

    array-length v4, v3

    new-array v4, v4, [Landroidx/exifinterface/media/a$f;

    const/4 v7, 0x0

    :goto_29c
    array-length v8, v3

    if-ge v7, v8, :cond_2c0

    aget-object v8, v3, v7

    invoke-virtual {v8, v9, v12}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v8

    new-instance v10, Landroidx/exifinterface/media/a$f;

    const/4 v11, 0x0

    aget-object v13, v8, v11

    invoke-static {v13}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v13

    double-to-long v13, v13

    const/4 v15, 0x1

    aget-object v8, v8, v15

    invoke-static {v8}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v11

    double-to-long v11, v11

    invoke-direct {v10, v13, v14, v11, v12}, Landroidx/exifinterface/media/a$f;-><init>(JJ)V

    aput-object v10, v4, v7

    add-int/lit8 v7, v7, 0x1

    const/4 v12, -0x1

    goto :goto_29c

    :cond_2c0
    const/4 v15, 0x1

    iget-object v3, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v5

    iget-object v7, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v4, v7}, Landroidx/exifinterface/media/a$d;->i([Landroidx/exifinterface/media/a$f;Ljava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v4

    goto :goto_325

    :pswitch_2cc
    const/4 v3, -0x1

    const/4 v15, 0x1

    invoke-virtual {v2, v10, v3}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v3

    array-length v4, v3

    new-array v4, v4, [J

    const/4 v7, 0x0

    :goto_2d6
    array-length v8, v3

    if-ge v7, v8, :cond_2e4

    aget-object v8, v3, v7

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v8

    aput-wide v8, v4, v7

    add-int/lit8 v7, v7, 0x1

    goto :goto_2d6

    :cond_2e4
    iget-object v3, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v5

    iget-object v7, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v4, v7}, Landroidx/exifinterface/media/a$d;->g([JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v4

    goto :goto_325

    :pswitch_2ef
    const/4 v3, -0x1

    const/4 v15, 0x1

    invoke-virtual {v2, v10, v3}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v3

    array-length v4, v3

    new-array v4, v4, [I

    const/4 v7, 0x0

    :goto_2f9
    array-length v8, v3

    if-ge v7, v8, :cond_307

    aget-object v8, v3, v7

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    aput v8, v4, v7

    add-int/lit8 v7, v7, 0x1

    goto :goto_2f9

    :cond_307
    iget-object v3, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v5

    iget-object v7, v0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-static {v4, v7}, Landroidx/exifinterface/media/a$d;->k([ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;

    move-result-object v4

    goto :goto_325

    :pswitch_312
    const/4 v15, 0x1

    iget-object v3, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v5

    invoke-static {v2}, Landroidx/exifinterface/media/a$d;->e(Ljava/lang/String;)Landroidx/exifinterface/media/a$d;

    move-result-object v4

    goto :goto_325

    :pswitch_31c
    const/4 v15, 0x1

    iget-object v3, v0, Landroidx/exifinterface/media/a;->f:[Ljava/util/HashMap;

    aget-object v3, v3, v5

    invoke-static {v2}, Landroidx/exifinterface/media/a$d;->a(Ljava/lang/String;)Landroidx/exifinterface/media/a$d;

    move-result-object v4

    :goto_325
    invoke-virtual {v3, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_32a

    :cond_329
    :goto_329
    const/4 v15, 0x1

    :cond_32a
    :goto_32a
    add-int/lit8 v5, v5, 0x1

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v7, 0x1

    goto/16 :goto_f6

    :cond_331
    return-void

    :cond_332
    new-instance v1, Ljava/lang/NullPointerException;

    const-string v2, "tag shouldn\'t be null"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_data_33a
    .packed-switch 0x1
        :pswitch_31c
        :pswitch_312
        :pswitch_2ef
        :pswitch_2cc
        :pswitch_294
        :pswitch_1f4
        :pswitch_312
        :pswitch_1f4
        :pswitch_26f
        :pswitch_234
        :pswitch_1f4
        :pswitch_20f
    .end packed-switch
.end method

.method public d(Ljava/lang/String;)Ljava/lang/String;
    .registers 8

    if-eqz p1, :cond_af

    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->f(Ljava/lang/String;)Landroidx/exifinterface/media/a$d;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_ae

    sget-object v2, Landroidx/exifinterface/media/a;->n0:Ljava/util/HashSet;

    invoke-virtual {v2, p1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_18

    iget-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, p1}, Landroidx/exifinterface/media/a$d;->n(Ljava/nio/ByteOrder;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_18
    const-string v2, "GPSTimeStamp"

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_a3

    iget p1, v0, Landroidx/exifinterface/media/a$d;->a:I

    const/4 v2, 0x5

    const-string v3, "ExifInterface"

    if-eq p1, v2, :cond_42

    const/16 v2, 0xa

    if-eq p1, v2, :cond_42

    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "GPS Timestamp format is not rational. format="

    invoke-virtual {p1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v0, v0, Landroidx/exifinterface/media/a$d;->a:I

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :goto_3e
    invoke-static {v3, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    return-object v1

    :cond_42
    iget-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, p1}, Landroidx/exifinterface/media/a$d;->o(Ljava/nio/ByteOrder;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, [Landroidx/exifinterface/media/a$f;

    if-eqz p1, :cond_8d

    array-length v0, p1

    const/4 v2, 0x3

    if-eq v0, v2, :cond_51

    goto :goto_8d

    :cond_51
    new-array v0, v2, [Ljava/lang/Object;

    const/4 v1, 0x0

    aget-object v2, p1, v1

    iget-wide v3, v2, Landroidx/exifinterface/media/a$f;->a:J

    long-to-float v3, v3

    iget-wide v4, v2, Landroidx/exifinterface/media/a$f;->b:J

    long-to-float v2, v4

    div-float/2addr v3, v2

    float-to-int v2, v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    aget-object v2, p1, v1

    iget-wide v3, v2, Landroidx/exifinterface/media/a$f;->a:J

    long-to-float v3, v3

    iget-wide v4, v2, Landroidx/exifinterface/media/a$f;->b:J

    long-to-float v2, v4

    div-float/2addr v3, v2

    float-to-int v2, v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    aget-object p1, p1, v1

    iget-wide v2, p1, Landroidx/exifinterface/media/a$f;->a:J

    long-to-float v2, v2

    iget-wide v3, p1, Landroidx/exifinterface/media/a$f;->b:J

    long-to-float p1, v3

    div-float/2addr v2, p1

    float-to-int p1, v2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p1

    aput-object p1, v0, v1

    const-string p1, "%02d:%02d:%02d"

    invoke-static {p1, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    return-object p1

    :cond_8d
    :goto_8d
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid GPS Timestamp array. array="

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/util/Arrays;->toString([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_3e

    :cond_a3
    :try_start_a3
    iget-object p1, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {v0, p1}, Landroidx/exifinterface/media/a$d;->l(Ljava/nio/ByteOrder;)D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object p1
    :try_end_ad
    .catch Ljava/lang/NumberFormatException; {:try_start_a3 .. :try_end_ad} :catch_ae

    return-object p1

    :catch_ae
    :cond_ae
    return-object v1

    :cond_af
    new-instance p1, Ljava/lang/NullPointerException;

    const-string v0, "tag shouldn\'t be null"

    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public e(Ljava/lang/String;I)I
    .registers 4

    if-eqz p1, :cond_11

    invoke-direct {p0, p1}, Landroidx/exifinterface/media/a;->f(Ljava/lang/String;)Landroidx/exifinterface/media/a$d;

    move-result-object p1

    if-nez p1, :cond_9

    return p2

    :cond_9
    :try_start_9
    iget-object v0, p0, Landroidx/exifinterface/media/a;->h:Ljava/nio/ByteOrder;

    invoke-virtual {p1, v0}, Landroidx/exifinterface/media/a$d;->m(Ljava/nio/ByteOrder;)I

    move-result p1
    :try_end_f
    .catch Ljava/lang/NumberFormatException; {:try_start_9 .. :try_end_f} :catch_10

    return p1

    :catch_10
    return p2

    :cond_11
    new-instance p1, Ljava/lang/NullPointerException;

    const-string p2, "tag shouldn\'t be null"

    invoke-direct {p1, p2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw p1
.end method

.method public n()I
    .registers 3

    const-string v0, "Orientation"

    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Landroidx/exifinterface/media/a;->e(Ljava/lang/String;I)I

    move-result v0

    packed-switch v0, :pswitch_data_16

    const/4 v0, 0x0

    return v0

    :pswitch_c
    const/16 v0, 0x5a

    return v0

    :pswitch_f
    const/16 v0, 0x10e

    return v0

    :pswitch_12
    const/16 v0, 0xb4

    return v0

    nop

    :pswitch_data_16
    .packed-switch 0x3
        :pswitch_12
        :pswitch_12
        :pswitch_f
        :pswitch_c
        :pswitch_c
        :pswitch_f
    .end packed-switch
.end method

.method public q()[B
    .registers 3

    iget v0, p0, Landroidx/exifinterface/media/a;->o:I

    const/4 v1, 0x6

    if-eq v0, v1, :cond_b

    const/4 v1, 0x7

    if-ne v0, v1, :cond_9

    goto :goto_b

    :cond_9
    const/4 v0, 0x0

    return-object v0

    :cond_b
    :goto_b
    invoke-virtual {p0}, Landroidx/exifinterface/media/a;->r()[B

    move-result-object v0

    return-object v0
.end method

.method public r()[B
    .registers 12

    const-string v0, "ExifInterface"

    iget-boolean v1, p0, Landroidx/exifinterface/media/a;->i:Z

    const/4 v2, 0x0

    if-nez v1, :cond_8

    return-object v2

    :cond_8
    iget-object v1, p0, Landroidx/exifinterface/media/a;->n:[B

    if-eqz v1, :cond_d

    return-object v1

    :cond_d
    :try_start_d
    iget-object v1, p0, Landroidx/exifinterface/media/a;->c:Landroid/content/res/AssetManager$AssetInputStream;
    :try_end_f
    .catch Ljava/lang/Exception; {:try_start_d .. :try_end_f} :catch_95
    .catchall {:try_start_d .. :try_end_f} :catchall_92

    if-eqz v1, :cond_2e

    :try_start_11
    invoke-virtual {v1}, Ljava/io/InputStream;->markSupported()Z

    move-result v3

    if-eqz v3, :cond_1c

    invoke-virtual {v1}, Ljava/io/InputStream;->reset()V

    :goto_1a
    move-object v3, v2

    goto :goto_4f

    :cond_1c
    const-string v3, "Cannot read thumbnail from inputstream without mark/reset support"

    invoke-static {v0, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_21
    .catch Ljava/lang/Exception; {:try_start_11 .. :try_end_21} :catch_29
    .catchall {:try_start_11 .. :try_end_21} :catchall_25

    invoke-static {v1}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    return-object v2

    :catchall_25
    move-exception v0

    move-object v3, v2

    goto/16 :goto_a8

    :catch_29
    move-exception v3

    move-object v4, v3

    move-object v3, v2

    goto/16 :goto_99

    :cond_2e
    :try_start_2e
    iget-object v1, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    if-eqz v1, :cond_3a

    new-instance v1, Ljava/io/FileInputStream;

    iget-object v3, p0, Landroidx/exifinterface/media/a;->a:Ljava/lang/String;

    invoke-direct {v1, v3}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    goto :goto_1a

    :cond_3a
    iget-object v1, p0, Landroidx/exifinterface/media/a;->b:Ljava/io/FileDescriptor;

    invoke-static {v1}, Landroidx/exifinterface/media/b$a;->b(Ljava/io/FileDescriptor;)Ljava/io/FileDescriptor;

    move-result-object v1
    :try_end_40
    .catch Ljava/lang/Exception; {:try_start_2e .. :try_end_40} :catch_95
    .catchall {:try_start_2e .. :try_end_40} :catchall_92

    const-wide/16 v3, 0x0

    :try_start_42
    sget v5, Landroid/system/OsConstants;->SEEK_SET:I

    invoke-static {v1, v3, v4, v5}, Landroidx/exifinterface/media/b$a;->c(Ljava/io/FileDescriptor;JI)J

    new-instance v3, Ljava/io/FileInputStream;

    invoke-direct {v3, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/FileDescriptor;)V
    :try_end_4c
    .catch Ljava/lang/Exception; {:try_start_42 .. :try_end_4c} :catch_8d
    .catchall {:try_start_42 .. :try_end_4c} :catchall_8a

    move-object v10, v3

    move-object v3, v1

    move-object v1, v10

    :goto_4f
    :try_start_4f
    iget v4, p0, Landroidx/exifinterface/media/a;->l:I

    iget v5, p0, Landroidx/exifinterface/media/a;->p:I

    add-int/2addr v4, v5

    int-to-long v4, v4

    invoke-virtual {v1, v4, v5}, Ljava/io/InputStream;->skip(J)J

    move-result-wide v4

    iget v6, p0, Landroidx/exifinterface/media/a;->l:I

    iget v7, p0, Landroidx/exifinterface/media/a;->p:I
    :try_end_5d
    .catch Ljava/lang/Exception; {:try_start_4f .. :try_end_5d} :catch_88
    .catchall {:try_start_4f .. :try_end_5d} :catchall_a7

    add-int/2addr v6, v7

    int-to-long v6, v6

    const-string v8, "Corrupted image"

    cmp-long v9, v4, v6

    if-nez v9, :cond_82

    :try_start_65
    iget v4, p0, Landroidx/exifinterface/media/a;->m:I

    new-array v4, v4, [B

    invoke-virtual {v1, v4}, Ljava/io/InputStream;->read([B)I

    move-result v5

    iget v6, p0, Landroidx/exifinterface/media/a;->m:I

    if-ne v5, v6, :cond_7c

    iput-object v4, p0, Landroidx/exifinterface/media/a;->n:[B
    :try_end_73
    .catch Ljava/lang/Exception; {:try_start_65 .. :try_end_73} :catch_88
    .catchall {:try_start_65 .. :try_end_73} :catchall_a7

    invoke-static {v1}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    if-eqz v3, :cond_7b

    invoke-static {v3}, Landroidx/exifinterface/media/b;->b(Ljava/io/FileDescriptor;)V

    :cond_7b
    return-object v4

    :cond_7c
    :try_start_7c
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4, v8}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v4

    :cond_82
    new-instance v4, Ljava/io/IOException;

    invoke-direct {v4, v8}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_88
    .catch Ljava/lang/Exception; {:try_start_7c .. :try_end_88} :catch_88
    .catchall {:try_start_7c .. :try_end_88} :catchall_a7

    :catch_88
    move-exception v4

    goto :goto_99

    :catchall_8a
    move-exception v0

    move-object v3, v1

    goto :goto_a9

    :catch_8d
    move-exception v3

    move-object v4, v3

    move-object v3, v1

    move-object v1, v2

    goto :goto_99

    :catchall_92
    move-exception v0

    move-object v3, v2

    goto :goto_a9

    :catch_95
    move-exception v3

    move-object v1, v2

    move-object v4, v3

    move-object v3, v1

    :goto_99
    :try_start_99
    const-string v5, "Encountered exception while getting thumbnail"

    invoke-static {v0, v5, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_9e
    .catchall {:try_start_99 .. :try_end_9e} :catchall_a7

    invoke-static {v1}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    if-eqz v3, :cond_a6

    invoke-static {v3}, Landroidx/exifinterface/media/b;->b(Ljava/io/FileDescriptor;)V

    :cond_a6
    return-object v2

    :catchall_a7
    move-exception v0

    :goto_a8
    move-object v2, v1

    :goto_a9
    invoke-static {v2}, Landroidx/exifinterface/media/b;->c(Ljava/io/Closeable;)V

    if-eqz v3, :cond_b1

    invoke-static {v3}, Landroidx/exifinterface/media/b;->b(Ljava/io/FileDescriptor;)V

    :cond_b1
    throw v0
.end method
