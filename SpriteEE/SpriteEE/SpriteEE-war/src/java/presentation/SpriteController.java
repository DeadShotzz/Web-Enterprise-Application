/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.SpriteFacade;
import business.Sprite;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author tgk
 */
@ManagedBean(name = "SpriteController")
@RequestScoped
public class SpriteController {
    @EJB
    private SpriteFacade spriteFacade;
     
    private Sprite sprite;
    /**
     * Creates a new instance of SpriteController
     */
    public SpriteController() {
       this.sprite = new Sprite();
    }



    //retrieves the current sprite
    public Sprite getSprite() {
       return sprite;
    }

    // Returns the total number of messages
    public int getNumberOfSprites(){
       return spriteFacade.findAll().size();
    }

    // Saves the sprite and then returns the string "theend" to navigate to "theend.xhtml"
    public String postSprite(){
       this.spriteFacade.create(sprite);
       return "theend";
    }

}
