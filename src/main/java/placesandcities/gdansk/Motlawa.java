package placesandcities.gdansk;

import utilities.dialogsutilities.DialogsUtilities;
import utilities.healthutilities.Health;
import model.Player;
import relaxtype.IRelaxType;

import java.io.IOException;

public class Motlawa implements IRelaxType {

    DialogsUtilities dialogsUtilities = new DialogsUtilities();

    private final Health health = new Health();
    private final Player player = new Player();

    @Override
    public void relax() throws IOException {
        dialogsUtilities.printDialog("src/main/resources/placesandcitiesdialogs/motlawadialogs/dialog1.txt", "white");

        health.fillHealthPoints();
        player.setCoins(player.getCoins() - 5);
    }
}
