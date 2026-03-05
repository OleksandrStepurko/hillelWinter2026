package org.example;
/**
 * This class represents an immutable object with two fields: id and str.
 * The class provides a constructor to initialize these fields and getter methods to retrieve their values.
 * The toString method is overridden to provide a string representation of the object.
 *
 * @author  Oleksandr Stepurko
 * @version 0.0.3
 * @since 11.09.2025
 */
public class ImmClazz {
   private final Integer id;
   private final String str;

    public ImmClazz(Integer id, String str) {
        this.id = new Integer(id);
        this.str = new String(str);
    }
    public Integer getId() {
        return new Integer(id);
    }
    public String getStr() {
        return new String(str);
    }

    public String toString() {
        return "ImmClazz{" +
                "id=" + id +
                ", str='" + str + '\'' +
                '}';
    }
}
