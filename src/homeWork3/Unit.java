package homeWork3;

enum UnitType {
  WEIGHT(Unit.GRAMS),
  DISTANCE(Unit.METER);

  private final Unit baseUnit;

  UnitType(Unit baseUnit) {
    this.baseUnit = baseUnit;
  }
}

public enum Unit {

  KILOMETER(1000.0, UnitType.DISTANCE),
  METER(1.0, UnitType.DISTANCE),
  FEET(0.3048, UnitType.DISTANCE),
  INCH(0.0254, UnitType.DISTANCE),

  KILOGRAMS(1000.0, UnitType.WEIGHT),
  GRAMS(1.0, UnitType.WEIGHT),
  POUND(453.592, UnitType.WEIGHT);

  private double conversionFactor;
  private UnitType unitType;

  Unit(double conversionFactor, UnitType unitType) {
    this.conversionFactor = conversionFactor;
    this.unitType = unitType;

  }

  public boolean isComparable(Unit unit){
    return this.unitType == unit.unitType;
  }
  public double convertToBaseUnit(double value){
    return (value * conversionFactor);
  }
  public double convert(double value){
    return value/ conversionFactor;
  }




}
