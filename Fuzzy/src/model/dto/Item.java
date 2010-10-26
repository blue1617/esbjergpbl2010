/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dto;

/**
 *
 * @author keldor
 */
public class Item {
    int idItem;
    int sport, comedy, action;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getComedy() {
        return comedy;
    }

    public void setComedy(int comedy) {
        this.comedy = comedy;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }


}
