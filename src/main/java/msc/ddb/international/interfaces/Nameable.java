package msc.ddb.international.interfaces;
/* 
 * The NAMEABLE INTERFACE allows to make each contractor have a name it can return.
 * As we use it with ENUM SUITs and RANKs, the setter method is not needed here.
 *
 * @author iham
 */

 public interface Nameable {

    /* 
     * A NAMEABLE has to return its name.
     * @return String
     */
    String getName();

    /* 
     * The setter for name - might be empty in some use cases.
     * 
     * @param name String
     */
    abstract void setName(String name) throws Exception;
}
