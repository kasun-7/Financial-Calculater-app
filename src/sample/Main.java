package sample;

import com.sun.media.sound.ModelDirectedPlayer;
import com.sun.org.apache.xml.internal.resolver.readers.TextCatalogReader;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.plugin2.main.server.HeartbeatThread;

import javax.swing.*;
import java.math.RoundingMode;
import java.security.Key;
import java.sql.Savepoint;
import java.text.DecimalFormat;

public class Main extends Application{
    Scene scene_Home, scene_Savings_Account, scene_Fixed_Deposit, scene_Mortgage, scene_Loan, scene_Help, scene;


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Financial Calculator");
        DecimalFormat Decimal = new DecimalFormat("0.00000000");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 180, 180);


        //Create Home page , tab Button and pane


        Image image_FinancialCalculator = new Image("FinancialCalculator.JPEG");
        ImageView H_FinancialCalculator = new ImageView();
        H_FinancialCalculator.setImage(image_FinancialCalculator);
        H_FinancialCalculator.setFitWidth(500);
        H_FinancialCalculator.setFitHeight(300);

        Label lb_home = new Label(" HOME ");
        lb_home.setLayoutX(200);
        lb_home.setLayoutY(20);
        lb_home.setStyle("-fx-font-size:30;-fx-text-alignment: left;-fx-font-weight:bold");


        Button b_Savings_Account = new Button("Savings_Account");
        b_Savings_Account.setLayoutX(90);
        b_Savings_Account.setLayoutY(70);
        b_Savings_Account.setPrefWidth(320);
        b_Savings_Account.setPrefHeight(30);

        b_Savings_Account.setStyle("-fx-font-size:13;-fx-text-alignment:center");
        b_Savings_Account.setOnAction(e -> primaryStage.setScene(scene_Savings_Account));

        Button b_Fixed_Deposit = new Button(" Fixed_Deposit ");
        b_Fixed_Deposit.setLayoutX(90);
        b_Fixed_Deposit.setLayoutY(110);
        b_Fixed_Deposit.setPrefWidth(320);
        b_Fixed_Deposit.setPrefHeight(30);

        b_Fixed_Deposit.setStyle("-fx-font-size:13;-fx-text-alignment:center");
        b_Fixed_Deposit.setOnAction(e -> primaryStage.setScene(scene_Fixed_Deposit));

        Button b_Mortgage = new Button(" Mortgage ");
        b_Mortgage.setLayoutX(90);
        b_Mortgage.setLayoutY(150);
        b_Mortgage.setPrefWidth(320);
        b_Mortgage.setPrefHeight(30);

        b_Mortgage.setStyle("-fx-font-size:13;-fx-text-alignment:center");
        b_Mortgage.setOnAction(e -> primaryStage.setScene(scene_Mortgage));


        Button b_Loan = new Button(" Loan ");
        b_Loan.setLayoutX(90);
        b_Loan.setLayoutY(190);
        b_Loan.setPrefWidth(320);
        b_Loan.setPrefHeight(30);

        b_Loan.setStyle("-fx-font-size:13;-fx-text-alignment:center");
        b_Loan.setOnAction(e -> primaryStage.setScene(scene_Loan));

        Button b_Help = new Button(" Help ");
        b_Help.setLayoutX(30);
        b_Help.setLayoutY(230);
        b_Help.setPrefWidth(130);
        b_Help.setPrefHeight(20);
        b_Help.setStyle("-fx-font-size:13;-fx-text-alignment:center");
        b_Help.setOnAction(e -> primaryStage.setScene(scene_Help));


        Button b_Exit = new Button("Exit");
        b_Exit.setLayoutX(340);
        b_Exit.setLayoutY(230);
        b_Exit.setPrefWidth(130);
        b_Exit.setPrefHeight(20);
        b_Exit.setStyle("-fx-font-size:13;-fx-text-alignment:center");


        Pane Home = new Pane();
        Pane Savings_Account = new Pane();
        Pane Fixed_deposit = new Pane();
        Pane Mortgage = new Pane();
        Pane Loan = new Pane();
        Pane Help = new Pane();


        Home.getChildren().add(H_FinancialCalculator);
        Home.getChildren().add(lb_home);
        Home.getChildren().add(b_Savings_Account);
        Home.getChildren().add(b_Fixed_Deposit);
        Home.getChildren().add(b_Mortgage);
        Home.getChildren().add(b_Loan);
        Home.getChildren().add(b_Help);
        Home.getChildren().add(b_Exit);

        scene_Home = new Scene(Home, 500, 300);
        primaryStage.setScene(scene_Home);
        primaryStage.show();


        //Savings_Account  Pane Content

        Image image_Savings_Account = new Image("Savings_Account.JPEG");
        ImageView Savings_image = new ImageView(image_Savings_Account);
        Savings_image.setImage(image_Savings_Account);
        Savings_image.setFitWidth(500);
        Savings_image.setFitHeight(300);


        Label SPS = new Label("Start_Principal");
        SPS.setLayoutY(10);
        SPS.setLayoutX(70);
        SPS.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        Label IS = new Label("INTEREST");
        IS.setLayoutY(40);
        IS.setLayoutX(70);
        IS.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        Label MPS = new Label("Month_Period");
        MPS.setLayoutY(70);
        MPS.setLayoutX(70);
        MPS.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        Label PS = new Label("PAYMENT");
        PS.setLayoutY(100);
        PS.setLayoutX(70);
        PS.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        Label FVS = new Label("Future_value");
        FVS.setLayoutY(130);
        FVS.setLayoutX(70);
        FVS.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        TextField SPS_TF = new TextField();
        SPS_TF.setLayoutY(10);
        SPS_TF.setLayoutX(170);

        TextField IS_TF = new TextField();
        IS_TF.setLayoutY(40);
        IS_TF.setLayoutX(170);

        TextField MPS_TF = new TextField();
        MPS_TF.setLayoutY(70);
        MPS_TF.setLayoutX(170);

        TextField PS_TF = new TextField();
        PS_TF.setLayoutY(100);
        PS_TF.setLayoutX(170);


        TextField FVS_TF = new TextField();
        FVS_TF.setLayoutY(130);
        FVS_TF.setLayoutX(170);
        Button CAL_S
        = new Button("Calculator");
        CAL_S.setLayoutY(170);
        CAL_S.setLayoutX(210);
        CAL_S.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        Button S_B = new Button("Back");
        S_B.setLayoutX(340);
        S_B.setLayoutY(230);
        S_B.setPrefWidth(130);
        S_B.setPrefHeight(20);
        S_B.setStyle("-fx-font-size:13px;-fx-text-alignment:center");
        S_B.setOnAction(e -> primaryStage.setScene(scene_Home));


        //Add a Content to Savings_Account Pane

        Savings_Account.getChildren().add(Savings_image);
        Savings_Account.getChildren().add(SPS);
        Savings_Account.getChildren().add(IS);
        Savings_Account.getChildren().add(MPS);
        Savings_Account.getChildren().add(PS);
        Savings_Account.getChildren().add(FVS);
        Savings_Account.getChildren().add(SPS_TF);
        Savings_Account.getChildren().add(IS_TF);
        Savings_Account.getChildren().add(MPS_TF);
        Savings_Account.getChildren().add(PS_TF);
        Savings_Account.getChildren().add(FVS_TF);
        Savings_Account.getChildren().add(CAL_S);
        Savings_Account.getChildren().add(S_B);


        scene_Savings_Account = new Scene(Savings_Account, 500, 300);

        //Fixed_deposit tab Pane Content

        Image image_Fixed_deposit = new Image("Fixed_Deposit.JPEG");
        ImageView Fixed_deposit_image = new ImageView(image_Fixed_deposit);
        Fixed_deposit_image.setImage(image_Fixed_deposit);
        Fixed_deposit_image.setFitWidth(500);
        Fixed_deposit_image.setFitHeight(300);


        Label SPI = new Label("Start_Principal");
        SPI.setLayoutY(10);
        SPI.setLayoutX(70);
        SPI.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        Label II = new Label("INTEREST");
        II.setLayoutY(40);
        II.setLayoutX(70);
        II.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        Label MPI = new Label("Month_Period");
        MPI.setLayoutY(70);
        MPI.setLayoutX(70);
        MPI.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        Label FVI = new Label("Future_value");
        FVI.setLayoutY(100);
        FVI.setLayoutX(70);
        FVI.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        TextField SPI_TF = new TextField();
        SPI_TF.setLayoutY(10);
        SPI_TF.setLayoutX(170);

        TextField II_TF = new TextField();
        II_TF.setLayoutY(40);
        II_TF.setLayoutX(170);

        TextField MPI_TF = new TextField();
        MPI_TF.setLayoutY(70);
        MPI_TF.setLayoutX(170);

        TextField FVI_TF = new TextField();
        FVI_TF.setLayoutY(100);
        FVI_TF.setLayoutX(170);


        Button CAL_FD = new Button("Calculator");
        CAL_FD.setLayoutY(170);
        CAL_FD.setLayoutX(210);
        CAL_FD.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        Button F_b = new Button("Back");
        F_b.setLayoutX(340);
        F_b.setLayoutY(230);
        F_b.setPrefWidth(130);
        F_b.setPrefHeight(20);
        F_b.setStyle("-fx-font-size:13px;-fx-text-alignment:center");
        F_b.setOnAction(e -> primaryStage.setScene(scene_Home));


        //Add a Content Fixed_deposit to Pane

        Fixed_deposit.getChildren().add(Fixed_deposit_image);
        Fixed_deposit.getChildren().add(SPI);
        Fixed_deposit.getChildren().add(II);
        Fixed_deposit.getChildren().add(MPI);
        Fixed_deposit.getChildren().add(FVI);
        Fixed_deposit.getChildren().add(SPI_TF);
        Fixed_deposit.getChildren().add(II_TF);
        Fixed_deposit.getChildren().add(MPI_TF);
        Fixed_deposit.getChildren().add(FVI_TF);
        Fixed_deposit.getChildren().add(CAL_FD);
        Fixed_deposit.getChildren().add(F_b);


        scene_Fixed_Deposit = new Scene(Fixed_deposit, 500, 300);

        //Mortgage tab Pane Content

        Image image_Mortgage = new Image("Mortgage.JPEG");
        ImageView Mortgage_image = new ImageView(image_Mortgage);
        Mortgage_image.setImage(image_Mortgage);
        Mortgage_image.setFitWidth(500);
        Mortgage_image.setFitHeight(300);

        Label SPM = new Label("Start_Principal");
        SPM.setLayoutY(10);
        SPM.setLayoutX(70);
        SPM.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        Label IM = new Label("INTEREST");
        IM.setLayoutY(40);
        IM.setLayoutX(70);
        IM.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        Label MPM = new Label("Month_Period");
        MPM.setLayoutY(70);
        MPM.setLayoutX(70);
        MPM.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        Label FVM = new Label("Future_value");
        FVM.setLayoutY(100);
        FVM.setLayoutX(70);
        FVM.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        TextField SPM_TF = new TextField();
        SPM_TF.setLayoutY(10);
        SPM_TF.setLayoutX(170);

        TextField IM_TF = new TextField();
        IM_TF.setLayoutY(40);
        IM_TF.setLayoutX(170);

        TextField MPM_TF = new TextField();
        MPM_TF.setLayoutY(70);
        MPM_TF.setLayoutX(170);

        TextField FVM_TF = new TextField();
        FVM_TF.setLayoutY(100);
        FVM_TF.setLayoutX(170);

        Button CAL_M = new Button("Calculator");
        CAL_M.setLayoutY(170);
        CAL_M.setLayoutX(210);
        CAL_M.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        Button M_b = new Button("Back");
        M_b.setLayoutX(340);
        M_b.setLayoutY(230);
        M_b.setPrefWidth(130);
        M_b.setPrefHeight(20);
        M_b.setStyle("-fx-font-size:13px;-fx-text-alignment:center");
        M_b.setOnAction(e -> primaryStage.setScene(scene_Home));


        //Add a Content Mortgage to Pane


        Mortgage.getChildren().add(Mortgage_image);
        Mortgage.getChildren().add(SPM);
        Mortgage.getChildren().add(IM);
        Mortgage.getChildren().add(MPM);
        Mortgage.getChildren().add(FVM);
        Mortgage.getChildren().add(SPM_TF);
        Mortgage.getChildren().add(IM_TF);
        Mortgage.getChildren().add(MPM_TF);
        Mortgage.getChildren().add(FVM_TF);
        Mortgage.getChildren().add(CAL_M);
        Mortgage.getChildren().add(M_b);


        scene_Mortgage = new Scene(Mortgage, 500, 300);

        //Loan tab Pane Content

        Image image_Loan = new Image("Loan.JPEG");
        ImageView Loan_image = new ImageView(image_Loan);
        Loan_image.setImage(image_Loan);
        Loan_image.setFitWidth(500);
        Loan_image.setFitHeight(300);

        Label SPL = new Label("Start_Principal");
        SPL.setLayoutY(10);
        SPL.setLayoutX(70);
        SPL.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        Label IL = new Label("INTEREST");
        IL.setLayoutY(40);
        IL.setLayoutX(70);
        IL.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        Label MPL = new Label("Month_Period");
        MPL.setLayoutY(70);
        MPL.setLayoutX(70);
        MPL.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        Label PL = new Label("PAYMENT");
        PL.setLayoutY(100);
        PL.setLayoutX(70);
        PL.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        Label FVL = new Label("Future_value");
        FVL.setLayoutY(130);
        FVL.setLayoutX(70);
        FVL.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        TextField SPL_TF = new TextField();
        SPL_TF.setLayoutY(10);
        SPL_TF.setLayoutX(170);

        TextField IL_TF = new TextField();
        IL_TF.setLayoutY(40);
        IL_TF.setLayoutX(170);

        TextField MPL_TF = new TextField();
        MPL_TF.setLayoutY(70);
        MPL_TF.setLayoutX(170);

        TextField PL_TF = new TextField();
        PL_TF.setLayoutY(100);
        PL_TF.setLayoutX(170);


        TextField FVL_TF = new TextField();
        FVL_TF.setLayoutY(130);
        FVL_TF.setLayoutX(170);

        Button CAL_L = new Button("Calculator");
        CAL_L.setLayoutY(170);
        CAL_L.setLayoutX(210);
        CAL_L.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");

        Button L_b = new Button("Back");
        L_b.setLayoutX(340);
        L_b.setLayoutY(230);
        L_b.setPrefWidth(130);
        L_b.setPrefHeight(20);
        L_b.setStyle("-fx-font-size:13px;-fx-text-alignment:center");
        L_b.setOnAction(e -> primaryStage.setScene(scene_Home));


        //Add a Content to Loan Pane

        Loan.getChildren().add(Loan_image);
        Loan.getChildren().add(SPL);
        Loan.getChildren().add(IL);
        Loan.getChildren().add(MPL);
        Loan.getChildren().add(PL);
        Loan.getChildren().add(FVL);
        Loan.getChildren().add(SPL_TF);
        Loan.getChildren().add(IL_TF);
        Loan.getChildren().add(MPL_TF);
        Loan.getChildren().add(PL_TF);
        Loan.getChildren().add(FVL_TF);
        Loan.getChildren().add(CAL_L);
        Loan.getChildren().add(L_b);

        scene_Loan = new Scene(Loan, 500, 300);


        //Help  Pane Content

        Image image_Help = new Image("Help.JPEG");
        ImageView Help_image = new ImageView(image_Help);
        Help_image.setImage(image_Help);
        Help_image.setFitWidth(500);
        Help_image.setFitHeight(300);

        Label l_help = new Label("Type your problem ; ");
        l_help.setLayoutX(90);
        l_help.setLayoutY(70);
        l_help.setStyle("-fx-font-size: 13;-fx-text-alignment: left;-fx-font-weight:bold");


        TextArea T_help = new TextArea();
        T_help.setLayoutX(90);
        T_help.setLayoutY(90);
        T_help.setPrefWidth(300);
        T_help.setPrefHeight(130);
        T_help.setStyle("-fx-font-size:13px");

        Button He_b = new Button("SENT->");
        He_b.setLayoutX(290);
        He_b.setLayoutY(200);
        He_b.setPrefWidth(100);
        He_b.setPrefHeight(10);
        He_b.setStyle("-fx-font-size:9px;-fx-text-alignment:center");


        Button H_b = new Button("Back");
        H_b.setLayoutX(340);
        H_b.setLayoutY(253);
        H_b.setPrefWidth(130);
        H_b.setPrefHeight(20);
        H_b.setStyle("-fx-font-size:13px;-fx-text-alignment:center");
        H_b.setOnAction(e -> primaryStage.setScene(scene_Home));


        //Add a Content to Help Pane

        Help.getChildren().add(Help_image);
        Help.getChildren().add(T_help);
        Help.getChildren().add(l_help);
        Help.getChildren().add(He_b);
        Help.getChildren().add(H_b);

        scene_Help = new Scene(Help, 500, 300);

        //Creating buttons for the keyboard.

        Button B_1 = new Button("1");
        B_1.setMinSize(10, 10);
        B_1.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");

        Button B_2 = new Button("2");
        B_2.setMinSize(10, 10);
        B_2.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");

        Button B_3 = new Button("3");
        B_3.setMinSize(10, 10);
        B_3.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");

        Button B_4 = new Button("4");
        B_4.setMinSize(10, 10);
        B_4.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");

        Button B_5 = new Button("5");
        B_5.setMinSize(10, 10);
        B_5.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");

        Button B_6 = new Button("6");
        B_6.setMinSize(10, 10);
        B_6.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");


        Button B_7 = new Button("7");
        B_7.setMinSize(10, 10);
        B_7.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");
        B_7.setFocusTraversable(false);


        Button B_8 = new Button("8");
        B_8.setMinSize(10, 10);
        B_8.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");


        Button B_9 = new Button("9");
        B_9.setMinSize(10, 10);
        B_9.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");


        Button B_0 = new Button("0");
        B_0.setMinSize(10, 10);
        B_0.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");


        Button D_B = new Button(".");
        D_B.setMinSize(10, 10);
        D_B.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");


        Button C_B = new Button("X");
        C_B.setMinSize(10, 10);
        GridPane grid_NUM = new GridPane();
        C_B.setStyle("-fx-font-size:13;-fx-text-alignment: center;-fx-background-radius: 13;-fx-background-color: aqua");



        //creat new gridpane  for  grid_NUM


        grid_NUM.setLayoutX(400);
        grid_NUM.setLayoutY(20);


        grid_NUM.add(B_1, 0, 2);
        grid_NUM.add(B_2, 1, 2);
        grid_NUM.add(B_3, 2, 2);
        grid_NUM.add(B_4, 0, 1);
        grid_NUM.add(B_5, 1, 1);
        grid_NUM.add(B_6, 2, 1);
        grid_NUM.add(B_7, 0, 0);
        grid_NUM.add(B_8, 1, 0);
        grid_NUM.add(B_9, 2, 0);
        grid_NUM.add(B_0, 0, 3);
        grid_NUM.add(D_B, 1, 3);
        grid_NUM.add(C_B, 2, 3);

        // NUM_pad

        B_1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "1";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal1);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal1);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal1);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal1);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal1);

                }

                SPS_TF.clear();
                IS_TF.clear();
                MPS_TF.clear();
                PS_TF.clear();
                FVI_TF.clear();
                SPI_TF.clear();
                II_TF.clear();
                MPI_TF.clear();
                FVI_TF.clear();
                SPM_TF.clear();
                FVM_TF.clear();
                IM_TF.clear();
                MPM_TF.clear();
                SPL_TF.clear();
                IL_TF.clear();
                MPL_TF.clear();
                PL_TF.clear();
                FVL_TF.clear();

            }
        });


        B_2.setFocusTraversable(false);
        B_2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal = "2";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal);
                }
            }
        });


        B_3.setFocusTraversable(false);
        B_3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal = "3";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal);
                }
            }
        });


        B_4.setFocusTraversable(false);
        B_4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal = "4";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal);
                }
            }
        });


        B_5.setFocusTraversable(false);
        B_5.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal = "5";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal);
                }
            }
        });


        B_6.setFocusTraversable(false);
        B_6.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal = "6";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal);
                }
            }
        });


        B_7.setFocusTraversable(false);
        B_7.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal = "7";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal);
                }
            }
        });


        B_8.setFocusTraversable(false);
        B_8.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal = "8";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal);
                }
            }
        });


        B_9.setFocusTraversable(false);
        B_9.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal = "9";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal);
                }
            }
        });


        B_0.setFocusTraversable(false);
        B_0.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal = "0";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal);
                }
            }
        });


        D_B.setFocusTraversable(false);
        D_B.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal = ".";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal);
                }
            }
        });


        B_1.setFocusTraversable(false);
        B_1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "1";
                if (SPI_TF.isFocused()) {
                    SPI_TF.setText(SPI_TF.getText() + buttonVal1);
                } else if (II_TF.isFocused()) {
                    II_TF.setText(II_TF.getText() + buttonVal1);
                } else if (MPI_TF.isFocused()) {
                    MPI_TF.setText(MPI_TF.getText() + buttonVal1);
                } else if (FVI_TF.isFocused()) {
                    FVI_TF.setText(FVI_TF.getText() + buttonVal1);

                }
            }
        });


        B_2.setFocusTraversable(false);
        B_2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "2";
                if (SPI_TF.isFocused()) {
                    SPI_TF.setText(SPI_TF.getText() + buttonVal1);
                } else if (II_TF.isFocused()) {
                    II_TF.setText(II_TF.getText() + buttonVal1);
                } else if (MPI_TF.isFocused()) {
                    MPI_TF.setText(MPI_TF.getText() + buttonVal1);
                } else if (FVI_TF.isFocused()) {
                    FVI_TF.setText(FVI_TF.getText() + buttonVal1);


                }
            }
        });


        B_3.setFocusTraversable(false);
        B_3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "3";
                if (SPI_TF.isFocused()) {
                    SPI_TF.setText(SPI_TF.getText() + buttonVal1);
                } else if (II_TF.isFocused()) {
                    II_TF.setText(II_TF.getText() + buttonVal1);
                } else if (MPI_TF.isFocused()) {
                    MPI_TF.setText(MPI_TF.getText() + buttonVal1);
                } else if (FVI_TF.isFocused()) {
                    FVI_TF.setText(FVI_TF.getText() + buttonVal1);


                }
            }
        });


        B_4.setFocusTraversable(false);
        B_4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "4";
                if (SPI_TF.isFocused()) {
                    SPI_TF.setText(SPI_TF.getText() + buttonVal1);
                } else if (II_TF.isFocused()) {
                    II_TF.setText(II_TF.getText() + buttonVal1);
                } else if (MPI_TF.isFocused()) {
                    MPI_TF.setText(MPI_TF.getText() + buttonVal1);
                } else if (FVI_TF.isFocused()) {
                    FVI_TF.setText(FVI_TF.getText() + buttonVal1);


                }
            }
        });


        B_5.setFocusTraversable(false);
        B_5.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "5";
                if (SPI_TF.isFocused()) {
                    SPI_TF.setText(SPI_TF.getText() + buttonVal1);
                } else if (II_TF.isFocused()) {
                    II_TF.setText(II_TF.getText() + buttonVal1);
                } else if (MPI_TF.isFocused()) {
                    MPI_TF.setText(MPI_TF.getText() + buttonVal1);
                } else if (FVI_TF.isFocused()) {
                    FVI_TF.setText(FVI_TF.getText() + buttonVal1);


                }
            }
        });


        B_6.setFocusTraversable(false);
        B_6.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "6";
                if (SPI_TF.isFocused()) {
                    SPI_TF.setText(SPI_TF.getText() + buttonVal1);
                } else if (II_TF.isFocused()) {
                    II_TF.setText(II_TF.getText() + buttonVal1);
                } else if (MPI_TF.isFocused()) {
                    MPI_TF.setText(MPI_TF.getText() + buttonVal1);
                } else if (FVI_TF.isFocused()) {
                    FVI_TF.setText(FVI_TF.getText() + buttonVal1);


                }
            }
        });


        B_7.setFocusTraversable(false);
        B_7.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "7";
                if (SPI_TF.isFocused()) {
                    SPI_TF.setText(SPI_TF.getText() + buttonVal1);
                } else if (II_TF.isFocused()) {
                    II_TF.setText(II_TF.getText() + buttonVal1);
                } else if (MPI_TF.isFocused()) {
                    MPI_TF.setText(MPI_TF.getText() + buttonVal1);
                } else if (FVI_TF.isFocused()) {
                    FVI_TF.setText(FVI_TF.getText() + buttonVal1);


                }
            }
        });


        B_8.setFocusTraversable(false);
        B_8.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "8";
                if (SPI_TF.isFocused()) {
                    SPI_TF.setText(SPI_TF.getText() + buttonVal1);
                } else if (II_TF.isFocused()) {
                    II_TF.setText(II_TF.getText() + buttonVal1);
                } else if (MPI_TF.isFocused()) {
                    MPI_TF.setText(MPI_TF.getText() + buttonVal1);
                } else if (FVI_TF.isFocused()) {
                    FVI_TF.setText(FVI_TF.getText() + buttonVal1);


                }
            }
        });


        B_9.setFocusTraversable(false);
        B_9.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "9";
                if (SPS_TF.isFocused()) {
                    SPS_TF.setText(SPS_TF.getText() + buttonVal1);
                } else if (IS_TF.isFocused()) {
                    IS_TF.setText(IS_TF.getText() + buttonVal1);
                } else if (MPS_TF.isFocused()) {
                    MPS_TF.setText(MPS_TF.getText() + buttonVal1);
                } else if (PS_TF.isFocused()) {
                    PS_TF.setText(PS_TF.getText() + buttonVal1);
                } else if (FVS_TF.isFocused()) {
                    FVS_TF.setText(FVS_TF.getText() + buttonVal1);
                }
            }
        });


        B_0.setFocusTraversable(false);
        B_0.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = "0";
                if (SPI_TF.isFocused()) {
                    SPI_TF.setText(SPI_TF.getText() + buttonVal1);
                } else if (II_TF.isFocused()) {
                    II_TF.setText(II_TF.getText() + buttonVal1);
                } else if (MPI_TF.isFocused()) {
                    MPI_TF.setText(MPI_TF.getText() + buttonVal1);
                } else if (FVI_TF.isFocused()) {
                    FVI_TF.setText(FVI_TF.getText() + buttonVal1);
                }
            }
        });


        D_B.setFocusTraversable(false);
        D_B.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal1 = ".";
                if (SPI_TF.isFocused()) {
                    SPI_TF.setText(SPI_TF.getText() + buttonVal1);
                } else if (II_TF.isFocused()) {
                    II_TF.setText(II_TF.getText() + buttonVal1);
                } else if (MPI_TF.isFocused()) {
                    MPI_TF.setText(MPI_TF.getText() + buttonVal1);
                } else if (FVI_TF.isFocused()) {
                    FVI_TF.setText(FVI_TF.getText() + buttonVal1);


                }
            }
        });


        B_1.setFocusTraversable(false);
        B_1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = "1";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);

                }
            }
        });


        B_2.setFocusTraversable(false);
        B_2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = "2";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);


                }
            }
        });


        B_3.setFocusTraversable(false);
        B_3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = "3";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);


                }
            }
        });


        B_4.setFocusTraversable(false);
        B_4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = "4";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);


                }
            }
        });


        B_5.setFocusTraversable(false);
        B_5.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = "5";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);


                }
            }
        });


        B_6.setFocusTraversable(false);
        B_6.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = "6";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);


                }
            }
        });


        B_7.setFocusTraversable(false);
        B_7.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = "7";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);


                }
            }
        });


        B_8.setFocusTraversable(false);
        B_8.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = "8";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);


                }
            }
        });


        B_9.setFocusTraversable(false);
        B_9.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = "9";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);


                }
            }
        });


        B_0.setFocusTraversable(false);
        B_0.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = "0";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);
                }
            }
        });


        D_B.setFocusTraversable(false);
        D_B.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal2 = ".";
                if (SPM_TF.isFocused()) {
                    SPM_TF.setText(SPM_TF.getText() + buttonVal2);
                } else if (IM_TF.isFocused()) {
                    IM_TF.setText(IM_TF.getText() + buttonVal2);
                } else if (MPM_TF.isFocused()) {
                    MPM_TF.setText(MPM_TF.getText() + buttonVal2);
                } else if (FVM_TF.isFocused()) {
                    FVM_TF.setText(FVM_TF.getText() + buttonVal2);


                }
            }
        });


        B_1.setFocusTraversable(false);
        B_1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = "1";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);

                }
            }
        });


        B_2.setFocusTraversable(false);
        B_2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = "2";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);
                }
            }
        });


        B_3.setFocusTraversable(false);
        B_3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = "3";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);
                }
            }
        });


        B_4.setFocusTraversable(false);
        B_4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = "4";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);
                }
            }
        });


        B_5.setFocusTraversable(false);
        B_5.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = "5";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);
                }
            }
        });


        B_6.setFocusTraversable(false);
        B_6.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = "6";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);
                }
            }
        });


        B_7.setFocusTraversable(false);
        B_7.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = "7";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);
                }
            }
        });


        B_8.setFocusTraversable(false);
        B_8.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = "8";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);
                }
            }
        });


        B_9.setFocusTraversable(false);
        B_9.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = "9";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);
                }
            }
        });


        B_0.setFocusTraversable(false);
        B_0.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = "0";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);
                }
            }
        });


        D_B.setFocusTraversable(false);
        D_B.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String buttonVal3 = ".";
                if (SPL_TF.isFocused()) {
                    SPL_TF.setText(SPL_TF.getText() + buttonVal3);
                } else if (IL_TF.isFocused()) {
                    IL_TF.setText(IL_TF.getText() + buttonVal3);
                } else if (MPL_TF.isFocused()) {
                    MPL_TF.setText(MPL_TF.getText() + buttonVal3);
                } else if (PL_TF.isFocused()) {
                    PL_TF.setText(PL_TF.getText() + buttonVal3);
                } else if (FVL_TF.isFocused()) {
                    FVL_TF.setText(FVL_TF.getText() + buttonVal3);


                }
            }
        });


        //Savings_Account NUM pad

        SPS_TF.setOnMouseClicked(e -> {
            Savings_Account.getChildren().add(grid_NUM);
        });
        IS_TF.setOnMouseClicked(e -> {
            Savings_Account.getChildren().add(grid_NUM);

        });
        MPS_TF.setOnMouseClicked(e -> {
            Savings_Account.getChildren().add(grid_NUM);
        });
        PS_TF.setOnMouseClicked(e -> {
            Savings_Account.getChildren().add(grid_NUM);
        });
        FVS_TF.setOnMouseClicked(e -> {
            Savings_Account.getChildren().add(grid_NUM);
        });


        //Fixed_deposit NUM pad
        SPI_TF.setOnMouseClicked(e -> {
            Fixed_deposit.getChildren().add(grid_NUM);
        });
        II_TF.setOnMouseClicked(e -> {
            Fixed_deposit.getChildren().add(grid_NUM);

        });
        MPI_TF.setOnMouseClicked(e -> {
            Fixed_deposit.getChildren().add(grid_NUM);

        });
        FVI_TF.setOnMouseClicked(e -> {
            Fixed_deposit.getChildren().add(grid_NUM);

        });


        //Mortgage NUM pad
        SPM_TF.setOnMouseClicked(e -> {
            Mortgage.getChildren().add(grid_NUM);
        });
        IM_TF.setOnMouseClicked(e -> {
            Mortgage.getChildren().add(grid_NUM);
        });
        MPM_TF.setOnMouseClicked(e -> {
            Mortgage.getChildren().add(grid_NUM);
        });
        FVM_TF.setOnMouseClicked(e -> {
            Mortgage.getChildren().add(grid_NUM);
        });

        //Loan NUM pad
        SPL_TF.setOnMouseClicked(e -> {
            Loan.getChildren().add(grid_NUM);
        });
        IL_TF.setOnMouseClicked(e -> {
            Loan.getChildren().add(grid_NUM);
        });
        MPL_TF.setOnMouseClicked(e -> {
            Loan.getChildren().add(grid_NUM);
        });
        PL_TF.setOnMouseClicked(e -> {
            Loan.getChildren().add(grid_NUM);
        });
        FVL_TF.setOnMouseClicked(e -> {
            Loan.getChildren().add(grid_NUM);
        });

                    //Mortgage Calculation

                    CAL_M.setOnAction(event -> {
                        if (MPM_TF.getText().equals("") && !SPM_TF.getText().equals("") && !IM_TF.getText().equals("") && !SPM_TF.getText().equals("")) {
                            Double p = Double.parseDouble(SPM_TF.getText());
                            Double r = (Double.parseDouble(IM.getText())) / 12 / 100;
                            int t = 12 * (Integer.parseInt(SPM_TF.getText()));
                            Double m = p * r * Math.pow(1 + r, t) / (Math.pow(1 + r, t) - 1);
                            DecimalFormat doubling = new DecimalFormat("##.##");
                            doubling.setRoundingMode(RoundingMode.DOWN);
                            String result11 = doubling.format(m);
                            MPM_TF.setText(String.valueOf(result11));
                        }

                        else if (SPM_TF.getText().equals("") && !MPM_TF.getText().equals("") && !IM_TF.getText().equals("") && !MPM_TF.getText().equals("")) {
                            Double r = (Double.parseDouble(IM_TF.getText())) / 12 / 100;
                            int t = 12 * (Integer.parseInt(MPM_TF.getText()));
                            Double m = Double.parseDouble(MPM_TF.getText());
                            Double p = m * (Math.pow(1 + r, t) - 1) / (r * Math.pow(1 + r, t));
                            DecimalFormat doubling = new DecimalFormat("##.##");
                            doubling.setRoundingMode(RoundingMode.DOWN);
                            String result12 = doubling.format(p);
                            SPM_TF.setText(String.valueOf(result12));
                        }


                        else if (IM_TF.getText().equals("") && !SPM_TF.getText().equals("") && !FVL_TF.getText().equals("") && !MPM_TF.getText().equals("")) {
                            Alert alert = new Alert(Alert.AlertType.NONE);
                            alert.setAlertType(Alert.AlertType.INFORMATION);
                            alert.setContentText(" Rate~~__ textfield must _be_ filled.");
                            alert.showAndWait();
                        }

                        else if (MPM_TF.getText().equals("") && !FVI_TF.getText().equals("") && !SPM_TF.getText().equals("") && IM_TF.getText().equals("")) {
                            Double r = (Double.parseDouble(IM_TF.getText()))/12/100;
                            Double m = Double.parseDouble(FVM_TF.getText());
                            Double p = Double.parseDouble(SPM_TF.getText());
                            Double t = ((Math.log((m/r)/((m/r)-p))/Math.log(1+r)));
                            DecimalFormat doubling = new DecimalFormat("##.##");
                            doubling.setRoundingMode(RoundingMode.DOWN);
                            String result13 = doubling.format(t);
                            MPM_TF.setText(String.valueOf(result13));

                        }
                    });


                     //Fixed_deposit Calculatin

                     CAL_FD.setOnAction(event -> {

                         if (FVI_TF.getText().equals("") && !SPI_TF.getText().equals("") && !II_TF.getText().equals("") && !MPI_TF.getText().equals("")) { ;
                             Double p = Double.parseDouble(SPI_TF.getText());
                             Double r = Double.parseDouble(II_TF.getText());
                             Double t = Double.parseDouble(MPI_TF.getText());
                             Double c = p * (Math.pow((1 + r / 100), t));
                             DecimalFormat doubling = new DecimalFormat("##.##");
                             doubling.setRoundingMode(RoundingMode.DOWN);
                             String result7 = doubling.format(c);
                             FVI_TF.setText(String.valueOf(result7));


                         } else if (SPI_TF.getText().equals("") && !FVI_TF.getText().equals("") && !II_TF.getText().equals("") && !MPI_TF.getText().equals("")){
                             Double r = Double.parseDouble(II_TF.getText());
                             Double t = Double.parseDouble(MPI_TF.getText());
                             Double c = Double.parseDouble(FVI_TF.getText());
                             Double p = c / (Math.pow((1 + r / 100), t));
                             DecimalFormat doubling = new DecimalFormat("##.##");
                             doubling.setRoundingMode(RoundingMode.DOWN);
                             String result8 = doubling.format(p);
                             SPI_TF.setText(String.valueOf(result8));

                         } else if (II_TF.getText().equals("") && !FVI_TF.getText().equals("") && !SPI_TF.getText().equals("") && !MPI_TF.getText().equals("")) {
                             Double p = Double.parseDouble(SPI_TF.getText());
                             Double t = Double.parseDouble(MPI_TF.getText());
                             Double c = Double.parseDouble(FVI_TF.getText());
                             Double r = 100 * ((Math.pow(c/p,1/t))-1);
                             DecimalFormat doubling = new DecimalFormat("##.##");
                             doubling.setRoundingMode(RoundingMode.DOWN);
                             String result9 = doubling.format(r);
                             II_TF.setText(String.valueOf(result9));


                         } else if (MPI_TF.getText().equals("") && FVI_TF.getText().equals("") && !SPI_TF.getText().equals("") && !II_TF.getText().equals("")) {
                             Double p = Double.parseDouble(SPI_TF.getText());
                             Double r = Double.parseDouble(II_TF.getText());
                             Double c = Double.parseDouble(FVI_TF.getText());
                             Double t = (Math.log(c)-Math.log(p))/(Math.log(1+r/100));
                             DecimalFormat doubling = new DecimalFormat("##.##");
                             doubling.setRoundingMode(RoundingMode.DOWN);
                             String result10 = doubling.format(t);
                             MPI_TF.setText(String.valueOf(result10));


                         }
                     });
            CAL_L.setOnAction(event -> {

                //Loan Calculation

                if (PL_TF.getText().equals("") && !SPL_TF.getText().equals("") && !IL_TF.getText().equals("") && !MPL_TF.getText().equals("")){
                    Double p = Double.parseDouble(SPL_TF.getText());
                    Double r = (Double.parseDouble(IL_TF.getText()))/12/100;
                    int t = 12 * (Integer.parseInt(MPL_TF.getText()));
                    Double m = p * r * Math.pow(1 + r,t)/(Math.pow(1+r,t)-1);
                    DecimalFormat doubling = new DecimalFormat("##.##");
                    doubling.setRoundingMode(RoundingMode.DOWN);
                    String result17 = doubling.format(m);
                    PL_TF.setText(String.valueOf(result17));




                }else if (SPL_TF.getText().equals("") && !IL_TF.getText().equals("") && !MPL_TF.getText().equals("") && !PL_TF.getText().equals("")){
                    Double r = (Double.parseDouble(IL_TF.getText()))/12/100;
                    int t = 12 * (Integer.parseInt(PL_TF.getText()));
                    Double m = Double.parseDouble(MPL_TF.getText());
                    Double p = m * (Math.pow(1+r,t)-1)/ (r * Math.pow(1+r,t));
                    DecimalFormat doubling = new DecimalFormat("##.##");
                    doubling.setRoundingMode(RoundingMode.DOWN);
                    String result16 = doubling.format(p);
                    MPI_TF.setText(String.valueOf(result16));


                }else if (IL_TF.getText().equals("") && !PL_TF.getText().equals("") && !SPL_TF.getText().equals("") && !MPL_TF.getText().equals("")){
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText(" texterro ````~~must be ERRO~`.");
                    alert.showAndWait();

                }else if (MPL_TF.getText().equals("") && !PL_TF.getText().equals("") && !SPL_TF.getText().equals("") && !IL_TF.getText().equals("")) {
                    Double r = (Double.parseDouble(IL_TF.getText())) / 12 / 100;
                    Double m = Double.parseDouble(PL_TF.getText());
                    Double p = Double.parseDouble(SPL_TF.getText());
                    Double t = ((Math.log((m / r) / ((m / r) - p)) / Math.log(1 + r)));
                    DecimalFormat doubling = new DecimalFormat("##.##");
                    doubling.setRoundingMode(RoundingMode.DOWN);
                    String result15 = doubling.format(t);
                    MPL_TF.setText(String.valueOf(result15));

                }
            });

                    //Savings_Account Calculation


        CAL_S.setOnAction(event -> {
           if (FVS_TF.getText().equals("") && !SPS_TF.getText().equals("") && !IS_TF.getText().equals("") && !MPS_TF.getText().equals("") && !PS_TF.getText().equals("")) {
                Double p = Double.parseDouble(SPS_TF.getText());
                Double r = Double.parseDouble(IS_TF.getText());
                int t = Integer.parseInt(MPS_TF.getText());
                Double pmt = Double.parseDouble(PS_TF.getText());
                Double x =Math.pow((1+(r/1200)),12*t);
                Double V = (pmt*((x-1)/(r/1200)))+(p*x);
                DecimalFormat doubling = new DecimalFormat("##.##");
                doubling.setRoundingMode(RoundingMode.DOWN);
                String result16 = doubling.format(V);
                FVS_TF.setText(String.valueOf(result16));



            } else if (SPS_TF.getText().equals("") && !FVS_TF.getText().equals("") && IS_TF.getText().equals("") && !MPS_TF.getText().equals("") && !PS_TF.getText().equals("")) {
                double V = Double.parseDouble(FVS_TF.getText());
                double r = Double.parseDouble(IS_TF.getText());
                int t = Integer.parseInt(MPS_TF.getText());
                double pmt = Double.parseDouble(PS_TF.getText());
                double x = Math.pow((1+(r/1200)),12*t);
                double P = Math.round(((V-(pmt*((x-1)/(r/1200))))/x)*100.0)/100.0;
               DecimalFormat doubling = new DecimalFormat("##.##");
               doubling.setRoundingMode(RoundingMode.DOWN);
               String result17 = doubling.format(P);
               SPS_TF.setText(String.valueOf(result17));



            } else if (IS_TF.getText().equals("") && !FVS_TF.getText().equals("") && !SPS_TF.getText().equals("") && !MPS_TF.getText().equals("") && !PS_TF.getText().equals("")) {
                double V = Double.parseDouble(FVS_TF.getText());
                double P = Double.parseDouble(SPS_TF.getText());
                int t = Integer.parseInt(MPS_TF.getText());
                double pmt = Double.parseDouble(PS_TF.getText());
                double r = (t*Math.pow(((V/P)),(1/(t*pmt))));
               DecimalFormat doubling = new DecimalFormat("##.##");
               doubling.setRoundingMode(RoundingMode.DOWN);
               String result15 = doubling.format(r);
               IS_TF.setText(String.valueOf(result15));}

           });
        }
    }
































































































                   

















































































































































        
