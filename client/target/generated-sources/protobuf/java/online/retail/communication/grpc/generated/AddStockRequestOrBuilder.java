// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: OnlineRetailService.proto

package online.retail.communication.grpc.generated;

public interface AddStockRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:online.retail.communication.grpc.generated.AddStockRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string productName = 1;</code>
   * @return The productName.
   */
  java.lang.String getProductName();
  /**
   * <code>string productName = 1;</code>
   * @return The bytes for productName.
   */
  com.google.protobuf.ByteString
      getProductNameBytes();

  /**
   * <code>int32 value = 2;</code>
   * @return The value.
   */
  int getValue();

  /**
   * <code>bool isSentByPrimary = 3;</code>
   * @return The isSentByPrimary.
   */
  boolean getIsSentByPrimary();
}
