package org.jboss.dna.common.math;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DurationOperations implements IMathOperations<Duration>, Comparator<Duration> {

    public Class<Duration> getOperandClass() {
        return Duration.class;
    }

    public Duration add( Duration value1, Duration value2 ) {
        if (value1 == null) return value2 != null ? value2 : createZeroValue();
        if (value2 == null) return value1;
        return value1.add(value2);
    }

    public Duration subtract( Duration value1, Duration value2 ) {
        if (value1 == null) return negate(value2);
        if (value2 == null) return value1;
        return value1.subtract(value2);
    }

    public Duration multiply( Duration value1, Duration value2 ) {
        if (value1 == null || value2 == null) return createZeroValue();
        return value1.multiply(value2.longValue());
    }

    public double divide( Duration value1, Duration value2 ) {
        if (value1 == null || value2 == null) throw new IllegalArgumentException();
        return value1.divide(value2);
    }

    public Duration negate( Duration value ) {
        if (value == null) return createZeroValue();
        return value.multiply(value.longValue() * -1);
    }

    public Duration increment( Duration value ) {
        if (value == null) return createZeroValue();
        return value.add(1l, TimeUnit.NANOSECONDS);
    }

    public Duration maximum( Duration value1, Duration value2 ) {
        if (value1 == null) return value2;
        if (value2 == null) return value1;
        return new Duration(Math.max(value1.longValue(), value2.longValue()));
    }

    public Duration minimum( Duration value1, Duration value2 ) {
        if (value1 == null) return value2;
        if (value2 == null) return value1;
        return new Duration(Math.min(value1.longValue(), value2.longValue()));
    }

    public int compare( Duration value1, Duration value2 ) {
        if (value1 == null) return value2 != null ? -1 : 0;
        if (value2 == null) return 1;
        return value1.compareTo(value2);
    }

    public BigDecimal asBigDecimal( Duration value ) {
        return value != null ? value.toBigDecimal() : null;
    }

    public Duration fromBigDecimal( BigDecimal value ) {
        return value != null ? new Duration(value.longValue()) : null;
    }

    public Duration createZeroValue() {
        return new Duration(0l);
    }

    public Duration create( int value ) {
        return new Duration(value);
    }

    public Duration create( long value ) {
        return new Duration(value);
    }

    public Duration create( double value ) {
        return new Duration((long)value);
    }

    public double sqrt( Duration value ) {
        return Math.sqrt(value.longValue());
    }

    public Comparator<Duration> getComparator() {
        return this;
    }

    public Duration random( Duration minimum, Duration maximum, Random rng ) {
        Duration difference = subtract(maximum, minimum);
        return new Duration(minimum.getDuratinInNanoseconds() + rng.nextInt(difference.intValue()));
    }

    public double doubleValue( Duration value ) {
        return value.doubleValue();
    }

    public float floatValue( Duration value ) {
        return value.floatValue();
    }

    public int intValue( Duration value ) {
        return value.intValue();
    }

    public long longValue( Duration value ) {
        return value.longValue();
    }

    public short shortValue( Duration value ) {
        return value.shortValue();
    }

    public int getExponentInScientificNotation( Duration value ) {
        long v = Math.abs(value.getDuratinInNanoseconds());
        int exp = 0;
        if (v > 1l) {
            while (v >= 10l) {
                v /= 10l;
                ++exp;
            }
        }
        return exp;
    }

    public Duration roundUp( Duration durationValue, int decimalShift ) {
        long value = durationValue.longValue();
        if (value == 0) return new Duration(0l);
        if (decimalShift >= 0) return durationValue;
        long shiftedValueP5 = Math.abs(value);
        for (int i = 0; i != (-decimalShift - 1); ++i)
            shiftedValueP5 /= 10l;
        shiftedValueP5 += 5l;
        long shiftedValue = shiftedValueP5 / 10l;
        if (shiftedValue * 10l - shiftedValueP5 >= 5) ++shiftedValue;
        shiftedValue *= Long.signum(value);
        for (int i = 0; i != -decimalShift; ++i)
            shiftedValue *= 10l;
        return new Duration(shiftedValue);
    }

    public Duration roundDown( Duration durationValue, int decimalShift ) {
        long value = durationValue.longValue();
        if (value == 0) return new Duration(0l);
        if (decimalShift >= 0) return durationValue;
        long shiftedValue = Math.abs(value);
        for (int i = 0; i != -decimalShift; ++i)
            shiftedValue /= 10l;
        shiftedValue *= Long.signum(value);
        for (int i = 0; i != -decimalShift; ++i)
            shiftedValue *= 10l;
        return new Duration(shiftedValue);
    }

    public Duration keepSignificantFigures( Duration value, int numSigFigs ) {
        if (numSigFigs < 0) return value;
        if (numSigFigs == 0) return new Duration(0l);
        int currentExp = getExponentInScientificNotation(value);
        int decimalShift = -currentExp + numSigFigs - 1;
        return roundUp(value, decimalShift);
    }
}
