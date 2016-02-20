/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.Game;
import models.Card;
import models.spGame;
import models.usGame;
import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {

    public Result index() {

        return Results.html();
    }

    public Result acesUpSP() {

        return Results.html().template("views/AcesUp/AcesUpSP.flt.html");
    }

    public Result acesUp() {

        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }

    // ======================================================================================
    /*
    public Result acesUp() {

        return Results.html().template("views/AcesUp/AcesUp.flt.html");
    }
    */
    // ======================================================================================

    public Result gameGetUS() {
        Game g = new usGame();
        g.buildDeck();
        g.shuffle();
        g.dealFour();
        g.error=false;

        return Results.json().render(g);
    }

    public Result gameGetSP() {
        spGame g = new spGame();
        g.buildDeck();
        g.shuffle();
        g.dealFour();
        g.error=false;

        return Results.json().render(g);
    }

    // ======================================================================================
    /*
    public Result gameGetE(){
        // Game gE = new englishVersion();
        char answer = 'E';
        Game g = new Game();
        g.buildDeck(answer);
        g.shuffle();
        g.dealFour();
        g.error = false;

        return Results.json().render(g);
    }
    public Result gameGetS(){
        // Game gS = new spanishVersion();
        // gS.buildDeck(answer);
        char answer = 'S';
        Game g = new Game();
        g.buildDeck(answer);
        g.shuffle();
        g.dealFour();
        g.error = false;

        return Results.json().render(g);
    }
    */
    // ======================================================================================


    // Since Spanish version and US version have different deck. Thus it needs different deal

    public Result dealPost(Context context, usGame g) {
        if(context.getRequestPath().contains("deal")){
            g.dealFour();
        }
        g.error = false;
        return Results.json().render(g);
    }

    public Result dealPostSP(Context context, spGame g) {
        if(context.getRequestPath().contains("deal")){
            g.dealFour();
        }
        g.error = false;
        return Results.json().render(g);
    }

    // Do I need to create two REMOVE too?! WHAAAAAAATTTTTTTTTTTTT

    public Result removeCard(Context context, @PathParam("column") int colNumber, Game g){
        g.remove(colNumber);
        return  Results.json().render(g);
    }

    // Since Spanish version and US version have different logic. Thus it needs different moveCard

    public Result moveCard(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, usGame g){
        g.move(colFrom,colTo);
        g.error = false;
        return  Results.json().render(g);
    }

    public Result moveCardSP(Context context, @PathParam("columnFrom") int colFrom, @PathParam("columnTo") int colTo, spGame g){
        g.move(colFrom,colTo);
        g.error = false;
        return  Results.json().render(g);
    }

}
