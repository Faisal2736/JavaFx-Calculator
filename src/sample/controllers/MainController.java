package sample.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private  double[] tempValues = {0,0};
    private  Boolean[] operatorValues = new Boolean[4];

    public MainController()
    {
        for (int i = 0 ; i<4 ; i ++)
        {
            operatorValues[i] = false;
        }



        System.out.println("Controller Constructor is called");
    }


    @FXML
    private Label display;

    @FXML
    private Button ac , conversion ;

    //methods to handle events

    public void delete()
    {

        ac.setText("Ac");
        display.setText("0");
        for (int i=0 ; i<2 ; i++)
        {
            tempValues[i]= 0 ;
        }
        for (int i = 0 ; i<4 ; i ++)
        {
            operatorValues[i] = false;
        }

    }
    public void operatorPressed(Event event){
        Button button = (Button) event.getSource();
        tempValues[0]= Double.valueOf(display.getText());
        switch (button.getId())
        {

            case "plus":
                operatorValues[0]=true;
                break;
            case "minus":
                operatorValues[1]=true;
                break;
            case "times":
                operatorValues[2]=true;
                break;
            case "division":
                operatorValues[3]=true;
                break;
           default:
               System.out.println("");


        }
        display.setText("");

    }
    public void result() {

        double result = 0;
        tempValues[1]= Double.valueOf(display.getText());
        if (operatorValues[0]) {
            result = tempValues[0] + tempValues[1];
        }else if (operatorValues[1]) {
        result = tempValues[0] - tempValues[1]; }
        else if (operatorValues[2]) {
            result = tempValues[0] * tempValues[1]; }
        else if (operatorValues[3]) {
            result = tempValues[0] / tempValues[1]; }

            display.setText(String.valueOf(result));




    }

    public void buttonPressed(Event event)
    {

        if (display.getText().equals("0"))
        {
            ac.setText("C");
            display.setText("");
        }
        // tells the event source where event is performed
        Button button = (Button) event.getSource();
        switch (button.getId())
        {
            case "one":
                display.setText(display.getText()+"1");
                break;
            case "two":
                display.setText(display.getText()+"2");
                break;
            case "three":
                display.setText(display.getText()+"3");
                break;
            case "four":
                display.setText(display.getText()+"4");
                break;
            case "five":
                display.setText(display.getText()+"5");
                break;
            case "six":
                display.setText(display.getText()+"6");
                break;
            case "seven":
                display.setText(display.getText()+"7");
                break;
            case "eight":
                display.setText(display.getText()+"8");
                break;
            case "nine":
                display.setText(display.getText()+"9");
                break;
            case "zero":
                display.setText(display.getText()+"0");
                break;
            case "comma":
                display.setText(display.getText()+",");
                break;
            default:
                System.out.println("event id is not matching");

        }


    }

    public void conversion()
    {

        if (!display.getText().equals("0"))
        {
            double value = Double.parseDouble(display.getText());
            value *= -1;
            display.setText(String.valueOf(value));

        }

    }
    public void percent()
    {

        double value = Double.parseDouble(display.getText());
        value *= 0.01;
        display.setText(String.valueOf(value));


    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("initialize is called");


    }
}
