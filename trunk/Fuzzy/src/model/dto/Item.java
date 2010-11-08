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
    int action, adventure, animation, biography, comedy,
        crime, documentary, drama, family, fantasy, film_noir,
        gameshow, history, horror, music, musical, mistery, news,
        reality_tv, romance, science_fiction, sport,
        talk_show, thriller, war, western;
    public int total() {
        int total=0;
        if(this.action!=0)
            total=total+1;
        if(this.adventure!=0)
            total=total+1;
        if(this.animation!=0)
            total=total+1;
        if(this.biography!=0)
            total=total+1;
        if(this.comedy!=0)
            total=total+1;
        if(this.crime!=0)
            total=total+1;
        if(this.documentary!=0)
            total=total+1;
        if(this.drama!=0)
            total=total+1;
        if(this.family!=0)
            total=total+1;
        if(this.fantasy!=0)
            total=total+1;
        if(this.film_noir!=0)
            total=total+1;
        if(this.gameshow!=0)
            total=total+1;
        if(this.history!=0)
            total=total+1;
        if(this.horror!=0)
            total=total+1;
        if(this.music!=0)
            total=total+1;
        if(this.musical!=0)
            total=total+1;
        if(this.mistery!=0)
            total=total+1;
        if(this.news!=0)
            total=news+1;
        if(this.reality_tv!=0)
            total=news+1;
        if(this.romance!=0)
            total=news+1;
        if(this.science_fiction!=0)
            total=news+1;
        if(this.sport!=0)
            total=news+1;
        if(this.talk_show!=0)
            total=news+1;
        if(this.thriller!=0)
            total=news+1;
        if(this.war!=0)
            total=news+1;
        if(this.western!=0)
            total=news+1;
        return total;
    }

    public int getAction() {
        return action;
    }

    public int getAdventure() {
        return adventure;
    }

    public void setAdventure(int adventure) {
        this.adventure = adventure;
    }

    public int getAnimation() {
        return animation;
    }

    public void setAnimation(int animation) {
        this.animation = animation;
    }

    public int getBiography() {
        return biography;
    }

    public void setBiography(int biography) {
        this.biography = biography;
    }

    public int getCrime() {
        return crime;
    }

    public void setCrime(int crime) {
        this.crime = crime;
    }

    public int getDocumentary() {
        return documentary;
    }

    public void setDocumentary(int documentary) {
        this.documentary = documentary;
    }

    public int getDrama() {
        return drama;
    }

    public void setDrama(int drama) {
        this.drama = drama;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getFantasy() {
        return fantasy;
    }

    public void setFantasy(int fantasy) {
        this.fantasy = fantasy;
    }

    public int getFilm_noir() {
        return film_noir;
    }

    public void setFilm_noir(int film_noir) {
        this.film_noir = film_noir;
    }

    public int getGameshow() {
        return gameshow;
    }

    public void setGameshow(int gameshow) {
        this.gameshow = gameshow;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getHorror() {
        return horror;
    }

    public void setHorror(int horror) {
        this.horror = horror;
    }

    public int getMistery() {
        return mistery;
    }

    public void setMistery(int mistery) {
        this.mistery = mistery;
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public int getMusical() {
        return musical;
    }

    public void setMusical(int musical) {
        this.musical = musical;
    }

    public int getNews() {
        return news;
    }

    public void setNews(int news) {
        this.news = news;
    }

    public int getReality_tv() {
        return reality_tv;
    }

    public void setReality_tv(int reality_tv) {
        this.reality_tv = reality_tv;
    }

    public int getRomance() {
        return romance;
    }

    public void setRomance(int romance) {
        this.romance = romance;
    }

    public int getScience_fiction() {
        return science_fiction;
    }

    public void setScience_fiction(int science_fiction) {
        this.science_fiction = science_fiction;
    }

    public int getTalk_show() {
        return talk_show;
    }

    public void setTalk_show(int talk_show) {
        this.talk_show = talk_show;
    }

    public int getThriller() {
        return thriller;
    }

    public void setThriller(int thriller) {
        this.thriller = thriller;
    }

    public int getWar() {
        return war;
    }

    public void setWar(int war) {
        this.war = war;
    }

    public int getWestern() {
        return western;
    }

    public void setWestern(int western) {
        this.western = western;
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
