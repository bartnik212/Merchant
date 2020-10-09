package checker;


public class WorkersChecker {

    private static boolean shipyardVisited;
    private static boolean ironWorksVisited;
    private static boolean sawmillVisited;

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


    public boolean isSawmillVisited() {
        return sawmillVisited;
    }

    public void setSawmillVisited() {
        sawmillVisited = true;
    }
}
