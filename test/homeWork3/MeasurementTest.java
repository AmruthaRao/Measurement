package homeWork3;

import  org.junit.Test;

    import static org.junit.Assert.*;

public class MeasurementTest {

  @Test
  public void oneKilometerShouldBeEqualToOneKilometer() {
    assertEquals(Measurement.km(1), Measurement.km(1));
  }
  @Test
  public void oneKilometerIsEqualToThousandMeters() {
    assertEquals(Measurement.km(1), Measurement.meter(1000));
  }

  @Test
  public void distanceAndWeightCannotBeCompared() {
    assertNotEquals(Measurement.km(1), Measurement.kg(1));
  }

  @Test
  public void inchesAndMeterAreCompared() {
    assertEquals(Measurement.inch(1), Measurement.meter(0.0254));
  }

  @Test
  public void feetAndMeterAreCompared() {
    assertEquals(Measurement.feet(1), Measurement.meter(0.3048));
  }

  @Test
  public void oneKilometerPlusOneKilometerIsTwoKilometer() throws Exception {
    Measurement distance = Measurement.km(1);
    distance.add(distance);
  }

  @Test
  public void oneKilometerPlusThousandMetersIsTwoKilometers() throws Exception {
    Measurement distanceInKilometer = Measurement.km(1);
    Measurement distanceInMeters = Measurement.meter(1000);
    distanceInKilometer.add(distanceInMeters);
  }



}
