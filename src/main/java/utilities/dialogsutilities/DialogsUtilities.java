package utilities.dialogsutilities;

import textcolor.ColorText;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DialogsUtilities {

    public void printGreenDialog(String path) throws FileNotFoundException {
        ColorText colorText = new ColorText();

        File file = new File(path);
        Scanner inputfile = new Scanner(file);

        while (inputfile.hasNext()) {
            System.out.println(colorText.GREEN + inputfile.nextLine() + colorText.TEXTRESET);
        }

        inputfile.close();
    }
}
