package msc.ddb.international.suits;

import msc.ddb.international.interfaces.Nameable;
import msc.ddb.international.interfaces.Suitable;
/* 
 * The FRENCHSUIT is a ENUM of all possible SUITs as used in French CARD PACKs/DECKs.
 * 
 * This enum implements SUITEABLE and NAMEABLE to be
 * - an generalized TYPE-INTERFACE for CARDs and PACKs.
 * - each SUIT has a mandatory name.
 * 
 * @autor Markus Hilbert (iham)
 */
public enum FrenchSuit implements Nameable, Suitable {
    CLUB("Club"),
    DIAMOND("Diamond"),
    HEART("Heart"),
    SPADE("Spade");
    
    /**
     * Each SUIT has a CONSTANT and a name.
     */
    private String name;

    /**
     * each SUIT CONSTANT is constracted by its given name.
     * @param name
     */
    private FrenchSuit(String name) {
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
        return "Suit [name=" + name + "]";
    }
}
