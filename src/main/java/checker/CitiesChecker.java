package checker;


public class CitiesChecker {

    private static boolean shipyardVisited;
    private static boolean ironWorksVisited;
    private static boolean samwillVisited;

    public boolean isShipyardVisited() {
        return shipyardVisited;
    }

    public void setShipyardVisited() {
        shipyardVisited = true;
    }

    public boolean isIronWorksVisited() {
        return ironWorksVisited;
    }

    public void setIronWorksVisited() {
        ironWorksVisited = true;
    }


    public boolean isSamwillVisited() {
        return samwillVisited;
    }

    public void setSamwillVisited() {
        samwillVisited = true;
    }
}
