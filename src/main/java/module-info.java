module com.example.javakoridorchiki {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.logging;
    requires io.grpc;
    requires io.grpc.stub;
    requires java.annotation;
    requires com.google.protobuf;
    requires com.google.common;
    requires io.grpc.protobuf;


    opens com.example.javakoridorchiki.Web.Grid to javafx.fxml;
    exports com.example.javakoridorchiki.Web.Grid;
    opens com.example.javakoridorchiki.Web.Login to javafx.fxml;
    exports com.example.javakoridorchiki.Web.Login;
    opens com.example.javakoridorchiki.Common.SocketMessage to com.google.gson;
    exports com.example.javakoridorchiki.Common.SocketMessage;
    exports com.example.javakoridorchiki.Common to com.google.gson;
    opens com.example.javakoridorchiki.Common to com.google.gson;
}