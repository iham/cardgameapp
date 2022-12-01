package msc.ddb.international.ranks;

import msc.ddb.international.interfaces.Nameable;
import msc.ddb.international.interfaces.Rankable;

/* 
 * The FRENCHRANK is a ENUM of all possible RANKs as used in French CARD PACKs/DECKs.
 * 
 * This enum implements RANKABLE and NAMEABLE to be
 * - an generalized TYPE-INTERFACE for CARDs and PACKs.
 * - each RANK has a mandatory name.
 * 
 * @autor Markus Hilbert (iham)
 */
public enum FrenchRank implements Nameable, Rankable {
    DEUCE("Deuce"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    ELEVEN("Eleven"),
    TWELVE("Twelve"),
    THIRTEEN("Thirteen"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace"),
    JOKER("Joker");

    private String name;

    /**
     * Each RANK has a CONSTANT and a name.
     */    
    private FrenchRank(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see msc.ddb.international.Nameable#setName(java.lang.String)
     * 
     * As an ENUM is a CONSTANT we don't allow to change the name after it is created.
     * This would change the name everywhere it is used.
     * We use the CARD to take this name and (maybe) change it there if needed.
     * 
     * @param name
     */
    public void setName(String name) throws Exception {
        throw new Exception("No name changes allowed here.");
    }

    /* 
     * @see msc.ddb.international.Nameable#getName()
     */
    public String getName() {
        return name;
    }

    public String toString() {
        return "Rank [name=" + name + "]";
    }

}
