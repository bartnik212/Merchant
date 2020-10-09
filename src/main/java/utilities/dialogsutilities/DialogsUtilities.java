package utilities.dialogsutilities;

import textcolor.ColorText;

import java.io.*;
import java.util.Scanner;

public class DialogsUtilities {

    private static final ColorText colorText = new ColorText();


    public void printDialog(String path, String color) throws IOException {
        String chosenColor = chooseColor(color);

        File file = new File(path);
        Scanner inputfile = new Scanner(file);

        while (inputfile.hasNext()) {
            System.out.println(chosenColor + inputfile.nextLine() + colorText.TEXTRESET);
        }

        inputfile.close();

    }

    private String chooseColor(String color) {
        String chosenColor;

        if (color.equalsIgnoreCase("green")) {
            chosenColor = colorText.GREEN;
        } else if (color.equalsIgnoreCase("yellow")) {
            chosenColor = colorText.YELLOW;
        } else if (color.equalsIgnoreCase("red")) {
            chosenColor = colorText.RED;
        } else if (color.equalsIgnoreCase("blue")) {
            chosenColor = colorText.BLUE;
        } else {
            chosenColor = colorText.WHITE;
        }
        return chosenColor;
    }
}

