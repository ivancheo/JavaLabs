module ru.nsu.shirokorad.lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ru.nsu.shirokorad.lab3 to javafx.fxml;
    exports ru.nsu.shirokorad.lab3;
    opens ru.nsu.shirokorad.lab3.view to javafx.fxml;
    exports ru.nsu.shirokorad.lab3.view;
}