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
public class Coffee extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4995150518301594423L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Coffee\",\"namespace\":\"iot\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"coffeeMachineId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"groupId\",\"type\":\"int\"},{\"name\":\"customerId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"timestamp\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"milligrams\",\"type\":\"int\"},{\"name\":\"dosage\",\"type\":\"int\"}],\"connect.name\":\"iot\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Coffee> ENCODER =
      new BinaryMessageEncoder<Coffee>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Coffee> DECODER =
      new BinaryMessageDecoder<Coffee>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Coffee> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Coffee> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Coffee>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Coffee to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Coffee from a ByteBuffer. */
  public static Coffee fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String id;
  @Deprecated public java.lang.String coffeeMachineId;
  @Deprecated public int groupId;
  @Deprecated public java.lang.String customerId;
  @Deprecated public org.joda.time.DateTime timestamp;
  @Deprecated public int milligrams;
  @Deprecated public int dosage;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Coffee() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param coffeeMachineId The new value for coffeeMachineId
   * @param groupId The new value for groupId
   * @param customerId The new value for customerId
   * @param timestamp The new value for timestamp
   * @param milligrams The new value for milligrams
   * @param dosage The new value for dosage
   */
  public Coffee(java.lang.String id, java.lang.String coffeeMachineId, java.lang.Integer groupId, java.lang.String customerId, org.joda.time.DateTime timestamp, java.lang.Integer milligrams, java.lang.Integer dosage) {
    this.id = id;
    this.coffeeMachineId = coffeeMachineId;
    this.groupId = groupId;
    this.customerId = customerId;
    this.timestamp = timestamp;
    this.milligrams = milligrams;
    this.dosage = dosage;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return coffeeMachineId;
    case 2: return groupId;
    case 3: return customerId;
    case 4: return timestamp;
    case 5: return milligrams;
    case 6: return dosage;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  protected static final org.apache.avro.data.TimeConversions.DateConversion DATE_CONVERSION = new org.apache.avro.data.TimeConversions.DateConversion();
  protected static final org.apache.avro.data.TimeConversions.TimeConversion TIME_CONVERSION = new org.apache.avro.data.TimeConversions.TimeConversion();
  protected static final org.apache.avro.data.TimeConversions.TimestampConversion TIMESTAMP_CONVERSION = new org.apache.avro.data.TimeConversions.TimestampConversion();
  protected static final org.apache.avro.Conversions.DecimalConversion DECIMAL_CONVERSION = new org.apache.avro.Conversions.DecimalConversion();

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      TIMESTAMP_CONVERSION,
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.String)value$; break;
    case 1: coffeeMachineId = (java.lang.String)value$; break;
    case 2: groupId = (java.lang.Integer)value$; break;
    case 3: customerId = (java.lang.String)value$; break;
    case 4: timestamp = (org.joda.time.DateTime)value$; break;
    case 5: milligrams = (java.lang.Integer)value$; break;
    case 6: dosage = (java.lang.Integer)value$; break;
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
   * Gets the value of the 'groupId' field.
   * @return The value of the 'groupId' field.
   */
  public java.lang.Integer getGroupId() {
    return groupId;
  }

  /**
   * Sets the value of the 'groupId' field.
   * @param value the value to set.
   */
  public void setGroupId(java.lang.Integer value) {
    this.groupId = value;
  }

  /**
   * Gets the value of the 'customerId' field.
   * @return The value of the 'customerId' field.
   */
  public java.lang.String getCustomerId() {
    return customerId;
  }

  /**
   * Sets the value of the 'customerId' field.
   * @param value the value to set.
   */
  public void setCustomerId(java.lang.String value) {
    this.customerId = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public org.joda.time.DateTime getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(org.joda.time.DateTime value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'milligrams' field.
   * @return The value of the 'milligrams' field.
   */
  public java.lang.Integer getMilligrams() {
    return milligrams;
  }

  /**
   * Sets the value of the 'milligrams' field.
   * @param value the value to set.
   */
  public void setMilligrams(java.lang.Integer value) {
    this.milligrams = value;
  }

  /**
   * Gets the value of the 'dosage' field.
   * @return The value of the 'dosage' field.
   */
  public java.lang.Integer getDosage() {
    return dosage;
  }

  /**
   * Sets the value of the 'dosage' field.
   * @param value the value to set.
   */
  public void setDosage(java.lang.Integer value) {
    this.dosage = value;
  }

  /**
   * Creates a new Coffee RecordBuilder.
   * @return A new Coffee RecordBuilder
   */
  public static iot.Coffee.Builder newBuilder() {
    return new iot.Coffee.Builder();
  }

  /**
   * Creates a new Coffee RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Coffee RecordBuilder
   */
  public static iot.Coffee.Builder newBuilder(iot.Coffee.Builder other) {
    return new iot.Coffee.Builder(other);
  }

  /**
   * Creates a new Coffee RecordBuilder by copying an existing Coffee instance.
   * @param other The existing instance to copy.
   * @return A new Coffee RecordBuilder
   */
  public static iot.Coffee.Builder newBuilder(iot.Coffee other) {
    return new iot.Coffee.Builder(other);
  }

  /**
   * RecordBuilder for Coffee instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Coffee>
    implements org.apache.avro.data.RecordBuilder<Coffee> {

    private java.lang.String id;
    private java.lang.String coffeeMachineId;
    private int groupId;
    private java.lang.String customerId;
    private org.joda.time.DateTime timestamp;
    private int milligrams;
    private int dosage;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(iot.Coffee.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.coffeeMachineId)) {
        this.coffeeMachineId = data().deepCopy(fields()[1].schema(), other.coffeeMachineId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.groupId)) {
        this.groupId = data().deepCopy(fields()[2].schema(), other.groupId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.customerId)) {
        this.customerId = data().deepCopy(fields()[3].schema(), other.customerId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[4].schema(), other.timestamp);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.milligrams)) {
        this.milligrams = data().deepCopy(fields()[5].schema(), other.milligrams);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.dosage)) {
        this.dosage = data().deepCopy(fields()[6].schema(), other.dosage);
        fieldSetFlags()[6] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Coffee instance
     * @param other The existing instance to copy.
     */
    private Builder(iot.Coffee other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.coffeeMachineId)) {
        this.coffeeMachineId = data().deepCopy(fields()[1].schema(), other.coffeeMachineId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.groupId)) {
        this.groupId = data().deepCopy(fields()[2].schema(), other.groupId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.customerId)) {
        this.customerId = data().deepCopy(fields()[3].schema(), other.customerId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[4].schema(), other.timestamp);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.milligrams)) {
        this.milligrams = data().deepCopy(fields()[5].schema(), other.milligrams);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.dosage)) {
        this.dosage = data().deepCopy(fields()[6].schema(), other.dosage);
        fieldSetFlags()[6] = true;
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
    public iot.Coffee.Builder setId(java.lang.String value) {
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
    public iot.Coffee.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
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
    public iot.Coffee.Builder setCoffeeMachineId(java.lang.String value) {
      validate(fields()[1], value);
      this.coffeeMachineId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'coffeeMachineId' field has been set.
      * @return True if the 'coffeeMachineId' field has been set, false otherwise.
      */
    public boolean hasCoffeeMachineId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'coffeeMachineId' field.
      * @return This builder.
      */
    public iot.Coffee.Builder clearCoffeeMachineId() {
      coffeeMachineId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'groupId' field.
      * @return The value.
      */
    public java.lang.Integer getGroupId() {
      return groupId;
    }

    /**
      * Sets the value of the 'groupId' field.
      * @param value The value of 'groupId'.
      * @return This builder.
      */
    public iot.Coffee.Builder setGroupId(int value) {
      validate(fields()[2], value);
      this.groupId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'groupId' field has been set.
      * @return True if the 'groupId' field has been set, false otherwise.
      */
    public boolean hasGroupId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'groupId' field.
      * @return This builder.
      */
    public iot.Coffee.Builder clearGroupId() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'customerId' field.
      * @return The value.
      */
    public java.lang.String getCustomerId() {
      return customerId;
    }

    /**
      * Sets the value of the 'customerId' field.
      * @param value The value of 'customerId'.
      * @return This builder.
      */
    public iot.Coffee.Builder setCustomerId(java.lang.String value) {
      validate(fields()[3], value);
      this.customerId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'customerId' field has been set.
      * @return True if the 'customerId' field has been set, false otherwise.
      */
    public boolean hasCustomerId() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'customerId' field.
      * @return This builder.
      */
    public iot.Coffee.Builder clearCustomerId() {
      customerId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public org.joda.time.DateTime getTimestamp() {
      return timestamp;
    }

    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public iot.Coffee.Builder setTimestamp(org.joda.time.DateTime value) {
      validate(fields()[4], value);
      this.timestamp = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public iot.Coffee.Builder clearTimestamp() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'milligrams' field.
      * @return The value.
      */
    public java.lang.Integer getMilligrams() {
      return milligrams;
    }

    /**
      * Sets the value of the 'milligrams' field.
      * @param value The value of 'milligrams'.
      * @return This builder.
      */
    public iot.Coffee.Builder setMilligrams(int value) {
      validate(fields()[5], value);
      this.milligrams = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'milligrams' field has been set.
      * @return True if the 'milligrams' field has been set, false otherwise.
      */
    public boolean hasMilligrams() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'milligrams' field.
      * @return This builder.
      */
    public iot.Coffee.Builder clearMilligrams() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'dosage' field.
      * @return The value.
      */
    public java.lang.Integer getDosage() {
      return dosage;
    }

    /**
      * Sets the value of the 'dosage' field.
      * @param value The value of 'dosage'.
      * @return This builder.
      */
    public iot.Coffee.Builder setDosage(int value) {
      validate(fields()[6], value);
      this.dosage = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'dosage' field has been set.
      * @return True if the 'dosage' field has been set, false otherwise.
      */
    public boolean hasDosage() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'dosage' field.
      * @return This builder.
      */
    public iot.Coffee.Builder clearDosage() {
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Coffee build() {
      try {
        Coffee record = new Coffee();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0], record.getConversion(0));
        record.coffeeMachineId = fieldSetFlags()[1] ? this.coffeeMachineId : (java.lang.String) defaultValue(fields()[1], record.getConversion(1));
        record.groupId = fieldSetFlags()[2] ? this.groupId : (java.lang.Integer) defaultValue(fields()[2], record.getConversion(2));
        record.customerId = fieldSetFlags()[3] ? this.customerId : (java.lang.String) defaultValue(fields()[3], record.getConversion(3));
        record.timestamp = fieldSetFlags()[4] ? this.timestamp : (org.joda.time.DateTime) defaultValue(fields()[4], record.getConversion(4));
        record.milligrams = fieldSetFlags()[5] ? this.milligrams : (java.lang.Integer) defaultValue(fields()[5], record.getConversion(5));
        record.dosage = fieldSetFlags()[6] ? this.dosage : (java.lang.Integer) defaultValue(fields()[6], record.getConversion(6));
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Coffee>
    WRITER$ = (org.apache.avro.io.DatumWriter<Coffee>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Coffee>
    READER$ = (org.apache.avro.io.DatumReader<Coffee>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
