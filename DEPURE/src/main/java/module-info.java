module com.typer.depure {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.typer.depure to javafx.fxml;
    exports com.typer.depure;
}