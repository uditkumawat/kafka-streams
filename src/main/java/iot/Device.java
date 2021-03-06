/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package iot;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Device extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1945917550986196343L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Device\",\"namespace\":\"iot\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"serial\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"coffeeMachineId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"longitude\",\"type\":\"double\"},{\"name\":\"latitude\",\"type\":\"double\"}],\"connect.name\":\"iot\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Device> ENCODER =
      new BinaryMessageEncoder<Device>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Device> DECODER =
      new BinaryMessageDecoder<Device>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Device> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Device> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Device>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Device to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Device from a ByteBuffer. */
  public static Device fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String id;
  @Deprecated public java.lang.String serial;
  @Deprecated public java.lang.String coffeeMachineId;
  @Deprecated public double longitude;
  @Deprecated public double latitude;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Device() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param serial The new value for serial
   * @param coffeeMachineId The new value for coffeeMachineId
   * @param longitude The new value for longitude
   * @param latitude The new value for latitude
   */
  public Device(java.lang.String id, java.lang.String serial, java.lang.String coffeeMachineId, java.lang.Double longitude, java.lang.Double latitude) {
    this.id = id;
    this.serial = serial;
    this.coffeeMachineId = coffeeMachineId;
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return serial;
    case 2: return coffeeMachineId;
    case 3: return longitude;
    case 4: return latitude;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.String)value$; break;
    case 1: serial = (java.lang.String)value$; break;
    case 2: coffeeMachineId = (java.lang.String)value$; break;
    case 3: longitude = (java.lang.Double)value$; break;
    case 4: latitude = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'serial' field.
   * @return The value of the 'serial' field.
   */
  public java.lang.String getSerial() {
    return serial;
  }

  /**
   * Sets the value of the 'serial' field.
   * @param value the value to set.
   */
  public void setSerial(java.lang.String value) {
    this.serial = value;
  }

  /**
   * Gets the value of the 'coffeeMachineId' field.
   * @return The value of the 'coffeeMachineId' field.
   */
  public java.lang.String getCoffeeMachineId() {
    return coffeeMachineId;
  }

  /**
   * Sets the value of the 'coffeeMachineId' field.
   * @param value the value to set.
   */
  public void setCoffeeMachineId(java.lang.String value) {
    this.coffeeMachineId = value;
  }

  /**
   * Gets the value of the 'longitude' field.
   * @return The value of the 'longitude' field.
   */
  public java.lang.Double getLongitude() {
    return longitude;
  }

  /**
   * Sets the value of the 'longitude' field.
   * @param value the value to set.
   */
  public void setLongitude(java.lang.Double value) {
    this.longitude = value;
  }

  /**
   * Gets the value of the 'latitude' field.
   * @return The value of the 'latitude' field.
   */
  public java.lang.Double getLatitude() {
    return latitude;
  }

  /**
   * Sets the value of the 'latitude' field.
   * @param value the value to set.
   */
  public void setLatitude(java.lang.Double value) {
    this.latitude = value;
  }

  /**
   * Creates a new Device RecordBuilder.
   * @return A new Device RecordBuilder
   */
  public static iot.Device.Builder newBuilder() {
    return new iot.Device.Builder();
  }

  /**
   * Creates a new Device RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Device RecordBuilder
   */
  public static iot.Device.Builder newBuilder(iot.Device.Builder other) {
    return new iot.Device.Builder(other);
  }

  /**
   * Creates a new Device RecordBuilder by copying an existing Device instance.
   * @param other The existing instance to copy.
   * @return A new Device RecordBuilder
   */
  public static iot.Device.Builder newBuilder(iot.Device other) {
    return new iot.Device.Builder(other);
  }

  /**
   * RecordBuilder for Device instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Device>
    implements org.apache.avro.data.RecordBuilder<Device> {

    private java.lang.String id;
    private java.lang.String serial;
    private java.lang.String coffeeMachineId;
    private double longitude;
    private double latitude;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(iot.Device.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.serial)) {
        this.serial = data().deepCopy(fields()[1].schema(), other.serial);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.coffeeMachineId)) {
        this.coffeeMachineId = data().deepCopy(fields()[2].schema(), other.coffeeMachineId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.longitude)) {
        this.longitude = data().deepCopy(fields()[3].schema(), other.longitude);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.latitude)) {
        this.latitude = data().deepCopy(fields()[4].schema(), other.latitude);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Device instance
     * @param other The existing instance to copy.
     */
    private Builder(iot.Device other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.serial)) {
        this.serial = data().deepCopy(fields()[1].schema(), other.serial);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.coffeeMachineId)) {
        this.coffeeMachineId = data().deepCopy(fields()[2].schema(), other.coffeeMachineId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.longitude)) {
        this.longitude = data().deepCopy(fields()[3].schema(), other.longitude);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.latitude)) {
        this.latitude = data().deepCopy(fields()[4].schema(), other.latitude);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public iot.Device.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public iot.Device.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'serial' field.
      * @return The value.
      */
    public java.lang.String getSerial() {
      return serial;
    }

    /**
      * Sets the value of the 'serial' field.
      * @param value The value of 'serial'.
      * @return This builder.
      */
    public iot.Device.Builder setSerial(java.lang.String value) {
      validate(fields()[1], value);
      this.serial = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'serial' field has been set.
      * @return True if the 'serial' field has been set, false otherwise.
      */
    public boolean hasSerial() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'serial' field.
      * @return This builder.
      */
    public iot.Device.Builder clearSerial() {
      serial = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'coffeeMachineId' field.
      * @return The value.
      */
    public java.lang.String getCoffeeMachineId() {
      return coffeeMachineId;
    }

    /**
      * Sets the value of the 'coffeeMachineId' field.
      * @param value The value of 'coffeeMachineId'.
      * @return This builder.
      */
    public iot.Device.Builder setCoffeeMachineId(java.lang.String value) {
      validate(fields()[2], value);
      this.coffeeMachineId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'coffeeMachineId' field has been set.
      * @return True if the 'coffeeMachineId' field has been set, false otherwise.
      */
    public boolean hasCoffeeMachineId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'coffeeMachineId' field.
      * @return This builder.
      */
    public iot.Device.Builder clearCoffeeMachineId() {
      coffeeMachineId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'longitude' field.
      * @return The value.
      */
    public java.lang.Double getLongitude() {
      return longitude;
    }

    /**
      * Sets the value of the 'longitude' field.
      * @param value The value of 'longitude'.
      * @return This builder.
      */
    public iot.Device.Builder setLongitude(double value) {
      validate(fields()[3], value);
      this.longitude = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'longitude' field has been set.
      * @return True if the 'longitude' field has been set, false otherwise.
      */
    public boolean hasLongitude() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'longitude' field.
      * @return This builder.
      */
    public iot.Device.Builder clearLongitude() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'latitude' field.
      * @return The value.
      */
    public java.lang.Double getLatitude() {
      return latitude;
    }

    /**
      * Sets the value of the 'latitude' field.
      * @param value The value of 'latitude'.
      * @return This builder.
      */
    public iot.Device.Builder setLatitude(double value) {
      validate(fields()[4], value);
      this.latitude = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'latitude' field has been set.
      * @return True if the 'latitude' field has been set, false otherwise.
      */
    public boolean hasLatitude() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'latitude' field.
      * @return This builder.
      */
    public iot.Device.Builder clearLatitude() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Device build() {
      try {
        Device record = new Device();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.serial = fieldSetFlags()[1] ? this.serial : (java.lang.String) defaultValue(fields()[1]);
        record.coffeeMachineId = fieldSetFlags()[2] ? this.coffeeMachineId : (java.lang.String) defaultValue(fields()[2]);
        record.longitude = fieldSetFlags()[3] ? this.longitude : (java.lang.Double) defaultValue(fields()[3]);
        record.latitude = fieldSetFlags()[4] ? this.latitude : (java.lang.Double) defaultValue(fields()[4]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Device>
    WRITER$ = (org.apache.avro.io.DatumWriter<Device>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Device>
    READER$ = (org.apache.avro.io.DatumReader<Device>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
