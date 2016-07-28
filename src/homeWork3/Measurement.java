package homeWork3;


public class Measurement {

  private final double value;
  private final Unit unit;


  private Measurement(double value, Unit unit) {
    this.value = value;
    this.unit = unit;

  }

  public static Measurement inch(double value) {
    return new Measurement(value, Unit.INCH);
  }

  public static Measurement feet(double value) {
    return new Measurement(value, Unit.FEET);
  }

  public static Measurement km(double value) {
    return new Measurement(value, Unit.KILOMETER);
  }

  public static Measurement meter(double value) {
    return new Measurement(value, Unit.METER);
  }


  public static Measurement kg(double value) {
    return new Measurement(value, Unit.KILOGRAMS);
  }

  public static Measurement gram(double value) {
    return new Measurement(value, Unit.GRAMS);
  }

  public static Measurement pound(double value) {
    return new Measurement(value, Unit.POUND);
  }


  public Measurement add(Measurement other) throws Exception {
    if (!this.unit.isComparable(other.unit)) {
      throw new Exception("Cannot add " + this.unit + " and " + other.unit);
    }
    double total = this.unit.convertToBaseUnit(this.value) + other.unit.convertToBaseUnit(other.value);
    return new Measurement(this.unit.convert(total), this.unit);
  }
  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(value);
    result = (int) (temp ^ (temp >>> 32));
    result = 31 * result + (unit != null ? unit.hashCode() : 0);
    return result;
  }
  @Override
  public boolean equals(Object other) {
    if (other == null)
      return false;
    if (other.getClass() != this.getClass())
      return false;
    Measurement otherMeasurement = (Measurement) other;
    if (!this.unit.isComparable(otherMeasurement.unit))
      return false;

    return Math.round(this.unit.convertToBaseUnit(value) * 10) ==
        Math.round(otherMeasurement.unit.convertToBaseUnit(otherMeasurement.value) * 10);


  }
}