/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model.dto;

/**
 *
 * @author keldor
 */
public class User implements java.io.Serializable{
    public int idUser;
    public int idItem;
    public String name;
    public String surname;
    public String age;
    public String occupation;
    public String sex;
    public String password;

    public User(int idUse, int idIte, String nam, String surnam, String ag, String occupa, String se, String pass){
        idUser = idUse;
        idItem = idIte;
        name = nam;
        surname = surnam;
        age = ag;
        occupation = occupa;
        sex = se;
        password = pass;
    }

    public User() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
