package application;

public class DataHolder {
    private int matQuantity;
    private int numCamion;
    private int capCamion;
    private int numDepot;
    private int capDepot;
    private static DataHolder instance=new DataHolder();
    private DataHolder(){}

    public void setMatQuantity(int matQuantity) {
        this.matQuantity = matQuantity;
    }

    public void setNumCamion(int numCamion) {
        this.numCamion = numCamion;
    }

    public void setCapCamion(int capCamion) {
        this.capCamion = capCamion;
    }

    public void setNumDepot(int numDepot) {
        this.numDepot = numDepot;
    }

    public void setCapDepot(int capDepot) {
        this.capDepot = capDepot;
    }

    public int getMatQuantity() {
        return matQuantity;
    }

    public int getNumCamion() {
        return numCamion;
    }

    public int getCapCamion() {
        return capCamion;
    }

    public int getNumDepot() {
        return numDepot;
    }

    public int getCapDepot() {
        return capDepot;
    }

    public static DataHolder getInstance() {
        return instance;
    }
}
