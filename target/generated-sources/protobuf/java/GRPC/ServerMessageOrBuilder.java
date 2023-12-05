// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto.proto

package GRPC;

public interface ServerMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:gRPC.ServerMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .gRPC.ServerMessage.Field field = 1;</code>
   */
  java.util.List<GRPC.ServerMessage.Field> 
      getFieldList();
  /**
   * <code>repeated .gRPC.ServerMessage.Field field = 1;</code>
   */
  GRPC.ServerMessage.Field getField(int index);
  /**
   * <code>repeated .gRPC.ServerMessage.Field field = 1;</code>
   */
  int getFieldCount();
  /**
   * <code>repeated .gRPC.ServerMessage.Field field = 1;</code>
   */
  java.util.List<? extends GRPC.ServerMessage.FieldOrBuilder> 
      getFieldOrBuilderList();
  /**
   * <code>repeated .gRPC.ServerMessage.Field field = 1;</code>
   */
  GRPC.ServerMessage.FieldOrBuilder getFieldOrBuilder(
      int index);

  /**
   * <code>repeated .gRPC.ClientInfo clients = 2;</code>
   */
  java.util.List<GRPC.ClientInfo> 
      getClientsList();
  /**
   * <code>repeated .gRPC.ClientInfo clients = 2;</code>
   */
  GRPC.ClientInfo getClients(int index);
  /**
   * <code>repeated .gRPC.ClientInfo clients = 2;</code>
   */
  int getClientsCount();
  /**
   * <code>repeated .gRPC.ClientInfo clients = 2;</code>
   */
  java.util.List<? extends GRPC.ClientInfoOrBuilder> 
      getClientsOrBuilderList();
  /**
   * <code>repeated .gRPC.ClientInfo clients = 2;</code>
   */
  GRPC.ClientInfoOrBuilder getClientsOrBuilder(
      int index);

  /**
   * <code>.gRPC.ClientInfo winner = 3;</code>
   * @return Whether the winner field is set.
   */
  boolean hasWinner();
  /**
   * <code>.gRPC.ClientInfo winner = 3;</code>
   * @return The winner.
   */
  GRPC.ClientInfo getWinner();
  /**
   * <code>.gRPC.ClientInfo winner = 3;</code>
   */
  GRPC.ClientInfoOrBuilder getWinnerOrBuilder();

  /**
   * <code>.gRPC.ClientInfo nextMoveBy = 4;</code>
   * @return Whether the nextMoveBy field is set.
   */
  boolean hasNextMoveBy();
  /**
   * <code>.gRPC.ClientInfo nextMoveBy = 4;</code>
   * @return The nextMoveBy.
   */
  GRPC.ClientInfo getNextMoveBy();
  /**
   * <code>.gRPC.ClientInfo nextMoveBy = 4;</code>
   */
  GRPC.ClientInfoOrBuilder getNextMoveByOrBuilder();
}