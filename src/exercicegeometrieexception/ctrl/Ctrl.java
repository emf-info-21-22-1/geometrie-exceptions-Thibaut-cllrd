package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {
        try {
            double valueDouble = Double.parseDouble(value);
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Faut entrer un chiffre mon gaillard");
        } catch (IllegalArgumentException e) {
            refIhm.afficheMessage("Faut entrer un chiffre positif mon gaillard");
        }
    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {
        double valueAreaDouble = 0;
        double valueLongueurDouble = 0;
        try {
            valueAreaDouble = Double.parseDouble(valueArea);

            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Faut comprendre que tu peux pas mettre autre chose que des chiffres !");
        } catch (IllegalArgumentException e) {
            refIhm.afficheMessage("Faut comprendre que tu peux pas mettre du negatif !");
        }

        try {

            valueLongueurDouble = Double.parseDouble(valueLongueur);
            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
        } catch (NumberFormatException e) {
            refIhm.afficheMessage("Faut comprendre que tu peux pas mettre autre chose que des chiffres !");
        } catch (IllegalArgumentException e) {
            refIhm.afficheMessage("Faut comprendre que tu peux pas mettre du negatif !");
        }
    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
