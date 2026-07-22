package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: /root/release/classes.dex */
public abstract class LinearTransformation {

    public static final class LinearTransformationBuilder {

        /* renamed from: x1, reason: collision with root package name */
        private final double f2307x1;

        /* renamed from: y1, reason: collision with root package name */
        private final double f2308y1;

        private LinearTransformationBuilder(double d3, double d4) {
            this.f2307x1 = d3;
            this.f2308y1 = d4;
        }

        public LinearTransformation and(double d3, double d4) {
            Preconditions.checkArgument(DoubleUtils.isFinite(d3) && DoubleUtils.isFinite(d4));
            double d5 = this.f2307x1;
            if (d3 != d5) {
                return withSlope((d4 - this.f2308y1) / (d3 - d5));
            }
            Preconditions.checkArgument(d4 != this.f2308y1);
            return new VerticalLinearTransformation(this.f2307x1);
        }

        public LinearTransformation withSlope(double d3) {
            Preconditions.checkArgument(!Double.isNaN(d3));
            return DoubleUtils.isFinite(d3) ? new RegularLinearTransformation(d3, this.f2308y1 - (this.f2307x1 * d3)) : new VerticalLinearTransformation(this.f2307x1);
        }
    }

    private static final class NaNLinearTransformation extends LinearTransformation {
        static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();

        private NaNLinearTransformation() {
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            return this;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d3) {
            return Double.NaN;
        }
    }

    private static final class RegularLinearTransformation extends LinearTransformation {

        @CheckForNull
        @LazyInit
        LinearTransformation inverse;
        final double slope;
        final double yIntercept;

        RegularLinearTransformation(double d3, double d4) {
            this.slope = d3;
            this.yIntercept = d4;
            this.inverse = null;
        }

        RegularLinearTransformation(double d3, double d4, LinearTransformation linearTransformation) {
            this.slope = d3;
            this.yIntercept = d4;
            this.inverse = linearTransformation;
        }

        private LinearTransformation createInverse() {
            double d3 = this.slope;
            return d3 != 0.0d ? new RegularLinearTransformation(1.0d / d3, (this.yIntercept * (-1.0d)) / d3, this) : new VerticalLinearTransformation(this.yIntercept, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return this.slope == 0.0d;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return this.slope;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.slope), Double.valueOf(this.yIntercept));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d3) {
            return (d3 * this.slope) + this.yIntercept;
        }
    }

    private static final class VerticalLinearTransformation extends LinearTransformation {

        @CheckForNull
        @LazyInit
        LinearTransformation inverse;

        /* renamed from: x, reason: collision with root package name */
        final double f2309x;

        VerticalLinearTransformation(double d3) {
            this.f2309x = d3;
            this.inverse = null;
        }

        VerticalLinearTransformation(double d3, LinearTransformation linearTransformation) {
            this.f2309x = d3;
            this.inverse = linearTransformation;
        }

        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(0.0d, this.f2309x, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return true;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f2309x));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d3) {
            throw new IllegalStateException();
        }
    }

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.INSTANCE;
    }

    public static LinearTransformation horizontal(double d3) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d3));
        return new RegularLinearTransformation(0.0d, d3);
    }

    public static LinearTransformationBuilder mapping(double d3, double d4) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d3) && DoubleUtils.isFinite(d4));
        return new LinearTransformationBuilder(d3, d4);
    }

    public static LinearTransformation vertical(double d3) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d3));
        return new VerticalLinearTransformation(d3);
    }

    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d3);
}
