package msc.ddb.international.interfaces;

import java.util.ArrayList;

import msc.ddb.international.game.Card;

public interface Packable {
    ArrayList<Card> createPack();
}