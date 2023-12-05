// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto.proto

package GRPC;

/**
 * <pre>
 * Main client server interaction objects
 * Used since sending data using sockets
 * </pre>
 *
 * Protobuf type {@code gRPC.ClientMessage}
 */
public  final class ClientMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:gRPC.ClientMessage)
    ClientMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ClientMessage.newBuilder() to construct.
  private ClientMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ClientMessage() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ClientMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ClientMessage(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            GRPC.ClientInfo.Builder subBuilder = null;
            if (identity_ != null) {
              subBuilder = identity_.toBuilder();
            }
            identity_ = input.readMessage(GRPC.ClientInfo.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(identity_);
              identity_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {

            row_ = input.readInt32();
            break;
          }
          case 24: {

            column_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return GRPC.ServiceProto.internal_static_gRPC_ClientMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return GRPC.ServiceProto.internal_static_gRPC_ClientMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GRPC.ClientMessage.class, GRPC.ClientMessage.Builder.class);
  }

  public static final int IDENTITY_FIELD_NUMBER = 1;
  private GRPC.ClientInfo identity_;
  /**
   * <code>.gRPC.ClientInfo identity = 1;</code>
   * @return Whether the identity field is set.
   */
  public boolean hasIdentity() {
    return identity_ != null;
  }
  /**
   * <code>.gRPC.ClientInfo identity = 1;</code>
   * @return The identity.
   */
  public GRPC.ClientInfo getIdentity() {
    return identity_ == null ? GRPC.ClientInfo.getDefaultInstance() : identity_;
  }
  /**
   * <code>.gRPC.ClientInfo identity = 1;</code>
   */
  public GRPC.ClientInfoOrBuilder getIdentityOrBuilder() {
    return getIdentity();
  }

  public static final int ROW_FIELD_NUMBER = 2;
  private int row_;
  /**
   * <code>int32 row = 2;</code>
   * @return The row.
   */
  public int getRow() {
    return row_;
  }

  public static final int COLUMN_FIELD_NUMBER = 3;
  private int column_;
  /**
   * <code>int32 column = 3;</code>
   * @return The column.
   */
  public int getColumn() {
    return column_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (identity_ != null) {
      output.writeMessage(1, getIdentity());
    }
    if (row_ != 0) {
      output.writeInt32(2, row_);
    }
    if (column_ != 0) {
      output.writeInt32(3, column_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (identity_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getIdentity());
    }
    if (row_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, row_);
    }
    if (column_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, column_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof GRPC.ClientMessage)) {
      return super.equals(obj);
    }
    GRPC.ClientMessage other = (GRPC.ClientMessage) obj;

    if (hasIdentity() != other.hasIdentity()) return false;
    if (hasIdentity()) {
      if (!getIdentity()
          .equals(other.getIdentity())) return false;
    }
    if (getRow()
        != other.getRow()) return false;
    if (getColumn()
        != other.getColumn()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasIdentity()) {
      hash = (37 * hash) + IDENTITY_FIELD_NUMBER;
      hash = (53 * hash) + getIdentity().hashCode();
    }
    hash = (37 * hash) + ROW_FIELD_NUMBER;
    hash = (53 * hash) + getRow();
    hash = (37 * hash) + COLUMN_FIELD_NUMBER;
    hash = (53 * hash) + getColumn();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GRPC.ClientMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GRPC.ClientMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GRPC.ClientMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GRPC.ClientMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GRPC.ClientMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GRPC.ClientMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GRPC.ClientMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GRPC.ClientMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static GRPC.ClientMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static GRPC.ClientMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GRPC.ClientMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GRPC.ClientMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(GRPC.ClientMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Main client server interaction objects
   * Used since sending data using sockets
   * </pre>
   *
   * Protobuf type {@code gRPC.ClientMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:gRPC.ClientMessage)
      GRPC.ClientMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return GRPC.ServiceProto.internal_static_gRPC_ClientMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return GRPC.ServiceProto.internal_static_gRPC_ClientMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GRPC.ClientMessage.class, GRPC.ClientMessage.Builder.class);
    }

    // Construct using GRPC.ClientMessage.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (identityBuilder_ == null) {
        identity_ = null;
      } else {
        identity_ = null;
        identityBuilder_ = null;
      }
      row_ = 0;

      column_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return GRPC.ServiceProto.internal_static_gRPC_ClientMessage_descriptor;
    }

    @java.lang.Override
    public GRPC.ClientMessage getDefaultInstanceForType() {
      return GRPC.ClientMessage.getDefaultInstance();
    }

    @java.lang.Override
    public GRPC.ClientMessage build() {
      GRPC.ClientMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public GRPC.ClientMessage buildPartial() {
      GRPC.ClientMessage result = new GRPC.ClientMessage(this);
      if (identityBuilder_ == null) {
        result.identity_ = identity_;
      } else {
        result.identity_ = identityBuilder_.build();
      }
      result.row_ = row_;
      result.column_ = column_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof GRPC.ClientMessage) {
        return mergeFrom((GRPC.ClientMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GRPC.ClientMessage other) {
      if (other == GRPC.ClientMessage.getDefaultInstance()) return this;
      if (other.hasIdentity()) {
        mergeIdentity(other.getIdentity());
      }
      if (other.getRow() != 0) {
        setRow(other.getRow());
      }
      if (other.getColumn() != 0) {
        setColumn(other.getColumn());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      GRPC.ClientMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (GRPC.ClientMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private GRPC.ClientInfo identity_;
    private com.google.protobuf.SingleFieldBuilderV3<
        GRPC.ClientInfo, GRPC.ClientInfo.Builder, GRPC.ClientInfoOrBuilder> identityBuilder_;
    /**
     * <code>.gRPC.ClientInfo identity = 1;</code>
     * @return Whether the identity field is set.
     */
    public boolean hasIdentity() {
      return identityBuilder_ != null || identity_ != null;
    }
    /**
     * <code>.gRPC.ClientInfo identity = 1;</code>
     * @return The identity.
     */
    public GRPC.ClientInfo getIdentity() {
      if (identityBuilder_ == null) {
        return identity_ == null ? GRPC.ClientInfo.getDefaultInstance() : identity_;
      } else {
        return identityBuilder_.getMessage();
      }
    }
    /**
     * <code>.gRPC.ClientInfo identity = 1;</code>
     */
    public Builder setIdentity(GRPC.ClientInfo value) {
      if (identityBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        identity_ = value;
        onChanged();
      } else {
        identityBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.gRPC.ClientInfo identity = 1;</code>
     */
    public Builder setIdentity(
        GRPC.ClientInfo.Builder builderForValue) {
      if (identityBuilder_ == null) {
        identity_ = builderForValue.build();
        onChanged();
      } else {
        identityBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.gRPC.ClientInfo identity = 1;</code>
     */
    public Builder mergeIdentity(GRPC.ClientInfo value) {
      if (identityBuilder_ == null) {
        if (identity_ != null) {
          identity_ =
            GRPC.ClientInfo.newBuilder(identity_).mergeFrom(value).buildPartial();
        } else {
          identity_ = value;
        }
        onChanged();
      } else {
        identityBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.gRPC.ClientInfo identity = 1;</code>
     */
    public Builder clearIdentity() {
      if (identityBuilder_ == null) {
        identity_ = null;
        onChanged();
      } else {
        identity_ = null;
        identityBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.gRPC.ClientInfo identity = 1;</code>
     */
    public GRPC.ClientInfo.Builder getIdentityBuilder() {
      
      onChanged();
      return getIdentityFieldBuilder().getBuilder();
    }
    /**
     * <code>.gRPC.ClientInfo identity = 1;</code>
     */
    public GRPC.ClientInfoOrBuilder getIdentityOrBuilder() {
      if (identityBuilder_ != null) {
        return identityBuilder_.getMessageOrBuilder();
      } else {
        return identity_ == null ?
            GRPC.ClientInfo.getDefaultInstance() : identity_;
      }
    }
    /**
     * <code>.gRPC.ClientInfo identity = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        GRPC.ClientInfo, GRPC.ClientInfo.Builder, GRPC.ClientInfoOrBuilder> 
        getIdentityFieldBuilder() {
      if (identityBuilder_ == null) {
        identityBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            GRPC.ClientInfo, GRPC.ClientInfo.Builder, GRPC.ClientInfoOrBuilder>(
                getIdentity(),
                getParentForChildren(),
                isClean());
        identity_ = null;
      }
      return identityBuilder_;
    }

    private int row_ ;
    /**
     * <code>int32 row = 2;</code>
     * @return The row.
     */
    public int getRow() {
      return row_;
    }
    /**
     * <code>int32 row = 2;</code>
     * @param value The row to set.
     * @return This builder for chaining.
     */
    public Builder setRow(int value) {
      
      row_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 row = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearRow() {
      
      row_ = 0;
      onChanged();
      return this;
    }

    private int column_ ;
    /**
     * <code>int32 column = 3;</code>
     * @return The column.
     */
    public int getColumn() {
      return column_;
    }
    /**
     * <code>int32 column = 3;</code>
     * @param value The column to set.
     * @return This builder for chaining.
     */
    public Builder setColumn(int value) {
      
      column_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 column = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearColumn() {
      
      column_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:gRPC.ClientMessage)
  }

  // @@protoc_insertion_point(class_scope:gRPC.ClientMessage)
  private static final GRPC.ClientMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GRPC.ClientMessage();
  }

  public static GRPC.ClientMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ClientMessage>
      PARSER = new com.google.protobuf.AbstractParser<ClientMessage>() {
    @java.lang.Override
    public ClientMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ClientMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ClientMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ClientMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public GRPC.ClientMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
