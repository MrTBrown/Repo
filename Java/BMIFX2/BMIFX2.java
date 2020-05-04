import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.geometry.*;
import javafx.event.*;




/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 31.01.2019
 * @author 
 */

public class BMIFX2 extends Application {
  // Anfang Attribute
  private Polygon polygon1 = new Polygon();
  private Button button1 = new Button();
  private Label lGrosseinm = new Label();
  private Label lGewichtinkg = new Label();
  private RadioButton rbM = new RadioButton();
  private RadioButton rbW = new RadioButton();
  private ToggleGroup toggleGroup1 = new ToggleGroup();       // Radiobuttons werden zu dieser Gruppe hinugef�gt, damit nur einer pro Gruppe aktiviert ist
  private TextArea outputField = new TextArea();
  private TextField size = new TextField();
  private TextField weight = new TextField();
  // Ende Attribute
  private double s = 0;    // size
  private double w = 0;     // weight
  private double b = 0;      // bmi
  private String ausgabe;
  private String styleOutput = "-fx-control-inner-background: #FF3333; -fx-text-inner-color: #FFFF00;";
  
  public void start(Stage primaryStage) { 
    
    Pane root = new Pane();
    Scene scene = new Scene(root, 268, 234);
                      
    root.setBackground(new Background(new BackgroundFill(Color.rgb(100,255,100), CornerRadii.EMPTY, Insets.EMPTY)));
 
    // Anfang Komponenten
    
    polygon1.getPoints().addAll(new Double[]{162.0, 50.0, 202.0, 90.0, 242.0, 50.0});
    root.getChildren().add(polygon1);
    
    
    
    button1.setLayoutX(152);
    button1.setLayoutY(96);
    button1.setPrefHeight(33);
    button1.setPrefWidth(104);
    button1.setOnAction(
      (event) -> {button1_Action(event);} 
    );
    button1.setContentDisplay(ContentDisplay.CENTER);
    button1.setText("calculate");
    button1.setFont(Font.font("Dialog", FontWeight.BOLD, 18));
    button1.setDefaultButton(true);
    root.getChildren().add(button1);
        
    
    lGrosseinm.setLayoutX(8);
    lGrosseinm.setLayoutY(8);
    lGrosseinm.setPrefHeight(17);
    lGrosseinm.setPrefWidth(129);
    lGrosseinm.setText("Groesse in m");
    root.getChildren().add(lGrosseinm);
    
    lGewichtinkg.setLayoutX(8);
    lGewichtinkg.setLayoutY(72);
    lGewichtinkg.setPrefHeight(20);
    lGewichtinkg.setPrefWidth(110);
    lGewichtinkg.setText("Gewicht in kg");
    root.getChildren().add(lGewichtinkg);
    
    rbM.setLayoutX(160);
    rbM.setLayoutY(8);
    rbM.setPrefHeight(25);
    rbM.setPrefWidth(40);
    rbM.setSelected(true);
    rbM.setText("m");
    rbM.setToggleGroup(toggleGroup1);
    root.getChildren().add(rbM);
    
    rbW.setLayoutX(208);
    rbW.setLayoutY(8);
    rbW.setPrefHeight(25);
    rbW.setPrefWidth(38);
    rbW.setToggleGroup(toggleGroup1);
    rbW.setText("w");
    root.getChildren().add(rbW);
    
    outputField.setLayoutX(8);
    outputField.setLayoutY(160);
    outputField.setPrefHeight(65);
    outputField.setPrefWidth(249);
    outputField.setStyle(styleOutput);
    outputField.setFont(Font.font("Dialog", 18));
    outputField.setEditable(false);
    root.getChildren().add(outputField);
    
    size.setLayoutX(8);
    size.setLayoutY(32);
    size.setPrefHeight(33);
    size.setPrefWidth(73);
    size.setAlignment(Pos.CENTER);
    size.setFont(Font.font("Dialog", 18));
    root.getChildren().add(size);
    
    weight.setLayoutX(8);
    weight.setLayoutY(96);
    weight.setPrefHeight(33);
    weight.setPrefWidth(73);
    weight.setAlignment(Pos.CENTER);
    weight.setFont(Font.font("Dialog", 18));
    root.getChildren().add(weight);
    // Ende Komponenten
    
    primaryStage.setResizable(false);
    primaryStage.setOnCloseRequest(e -> System.exit(0));
    primaryStage.setTitle("BMIFX2");
    primaryStage.setOpacity(0.8);
    primaryStage.setScene(scene);
    primaryStage.show();
  } // end of public BMIFX
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    launch(args);
  } // end of main
  
  public void button1_Action(Event evt) {
    
    s = Double.parseDouble(size.getText());
    w = Double.parseDouble(weight.getText());
    b = w / (s * s);
    b = (double)Math.round(b * 100)/100;     // round ezeugt eine Integer Zahl. Ohne cast w�rde die durch int die Kommazahl zu z.B. 22 werden und aufgrund von double 22.0 werden! wir wollen aber echte Nachkommastellen z.. 22.24
    if (rbM.isSelected()) {      
       ausgabe = "Sehr geehrter Herr,\nIhr BMI betraegt: "+Double.toString(b);
    }
    if (rbW.isSelected()) {      
      ausgabe = "Sehr geehrte Dame,\nIhr BMI betraegt: "+Double.toString(b);
    }
    outputField.setText(ausgabe);
    
    
  } // end of button1_Action

  // Ende Methoden
} // end of class BMIFX

