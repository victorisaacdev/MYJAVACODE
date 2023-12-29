module com.example.depuretutortyper {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.depuretutortyper to javafx.fxml;
    exports com.example.depuretutortyper;
}