package msc.ddb.international.packcreations;

import java.util.ArrayList;

import msc.ddb.international.Card;
import msc.ddb.international.ranks.FrenchRank;

public class FrenchPack52WithJokers extends FrenchPack52 {

    @Override
    public ArrayList<Card> createPack() {
        ArrayList<Card> cards = super.createPack();

        // add Jokers
        cards.add( new Card(FrenchRank.JOKER) );
        cards.add( new Card(FrenchRank.JOKER) );

        return cards;
    }

}