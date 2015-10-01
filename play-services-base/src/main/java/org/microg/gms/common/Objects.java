package org.microg.gms.common;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mopar on 10/1/15.
 */
public class Objects {
    private Objects() {
        throw new RuntimeException("no");
    }

    /**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     * Consequently, if both arguments are {@code null}, {@code true}
     * is returned and if exactly one argument is {@code null}, {@code
     * false} is returned.  Otherwise, equality is determined by using
     * the {@link Object#equals equals} method of the first
     * argument.
     *
     * @param a an object
     * @param b an object to be compared with {@code a} for equality
     * @return {@code true} if the arguments are equal to each other
     * and {@code false} otherwise
     * @see Object#equals(Object)
     */
    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    /**
     * Returns the hash code of a non-{@code null} argument and 0 for
     * a {@code null} argument.
     *
     * @param o an object
     * @return the hash code of a non-{@code null} argument and 0 for
     * a {@code null} argument
     * @see Object#hashCode
     */
    public static int hashCode(Object o) {
        return o != null ? o.hashCode() : 0;
    }

    /**
     * Generates a hash code for a sequence of input values. The hash
     * code is generated as if all the input values were placed into an
     * array, and that array were hashed by calling {@link
     * Arrays#hashCode(Object[])}.
     * <p/>
     * <p>This method is useful for implementing {@link
     * Object#hashCode()} on objects containing multiple fields. For
     * example, if an object that has three fields, {@code x}, {@code
     * y}, and {@code z}, one could write:
     * <p/>
     * <blockquote><pre>
     * &#064;Override public int hashCode() {
     *     return Objects.hash(x, y, z);
     * }
     * </pre></blockquote>
     * <p/>
     * <b>Warning: When a single object reference is supplied, the returned
     * value does not equal the hash code of that object reference.</b> This
     * value can be computed by calling {@link #hashCode(Object)}.
     *
     * @param values the values to be hashed
     * @return a hash value of the sequence of input values
     * @see Arrays#hashCode(Object[])
     * @see List#hashCode
     */
    public static int hash(Object... values) {
        return Arrays.hashCode(values);
    }

    /**
     * Checks that the specified object reference is not {@code null}. This
     * method is designed primarily for doing parameter validation in methods
     * and constructors, as demonstrated below:
     * <blockquote><pre>
     * public Foo(Bar bar) {
     *     this.bar = Objects.requireNonNull(bar);
     * }
     * </pre></blockquote>
     *
     * @param obj the object reference to check for nullity
     * @param <T> the type of the reference
     * @return {@code obj} if not {@code null}
     * @throws NullPointerException if {@code obj} is {@code null}
     */
    public static <T> T requireNonNull(T obj) {
        if (obj == null)
            throw new NullPointerException();
        return obj;
    }

    /**
     * Checks that the specified object reference is not {@code null} and
     * throws a customized {@link NullPointerException} if it is. This method
     * is designed primarily for doing parameter validation in methods and
     * constructors with multiple parameters, as demonstrated below:
     * <blockquote><pre>
     * public Foo(Bar bar, Baz baz) {
     *     this.bar = Objects.requireNonNull(bar, "bar must not be null");
     *     this.baz = Objects.requireNonNull(baz, "baz must not be null");
     * }
     * </pre></blockquote>
     *
     * @param obj     the object reference to check for nullity
     * @param message detail message to be used in the event that a {@code
     *                NullPointerException} is thrown
     * @param <T> the type of the reference
     * @return {@code obj} if not {@code null}
     * @throws NullPointerException if {@code obj} is {@code null}
     */
    public static <T> T requireNonNull(T obj, String message) {
        if (obj == null)
            throw new NullPointerException(message);
        return obj;
    }

    public static boolean jsonEquals(Object var0, Object var1) {
        if(var0 == null && var1 == null) {
            return true;
        } else if(var0 != null && var1 != null) {
            Object var6;
            if(var0 instanceof JSONObject && var1 instanceof JSONObject) {
                JSONObject var10 = (JSONObject)var0;
                JSONObject var11 = (JSONObject)var1;
                if(var10.length() != var11.length()) {
                    return false;
                } else {
                    Iterator var12 = var10.keys();

                    while(var12.hasNext()) {
                        String var13 = (String)var12.next();
                        if(!var11.has(var13)) {
                            return false;
                        }

                        try {
                            var6 = var10.get(var13);
                            Object var7 = var11.get(var13);
                            if(!jsonEquals(var6, var7)) {
                                return false;
                            }
                        } catch (JSONException var8) {
                            return false;
                        }
                    }

                    return true;
                }
            } else if(var0 instanceof JSONArray && var1 instanceof JSONArray) {
                JSONArray var2 = (JSONArray)var0;
                JSONArray var3 = (JSONArray)var1;
                if(var2.length() != var3.length()) {
                    return false;
                } else {
                    for(int var4 = 0; var4 < var2.length(); ++var4) {
                        try {
                            Object var5 = var2.get(var4);
                            var6 = var3.get(var4);
                            if(!jsonEquals(var5, var6)) {
                                return false;
                            }
                        } catch (JSONException var9) {
                            return false;
                        }
                    }

                    return true;
                }
            } else {
                return var0.equals(var1);
            }
        } else {
            return false;
        }
    }
}
