package chap17;

import java.util.List;

/**
 * Since XML is very verbose, you are given a way of encoding it
 * where each tag gets mapped to a pre-defined integer value. The
 * language/grammar is as follows:
 * Element   --> Tag Attributes END Children END
 * Attribute --> Tag Value
 * END       --> 0
 * Tag       --> some predefined mapping to int
 * Value     --> string value END
 *
 * For example, the following XML might be converted into the
 * compressed string below (assuming a mapping of family -> 1,
 * person -> 2, firstName -> 3, lastName -> 4, state -> 5).
 *     <family lastName="McDowell" state="CA">
 *       <person firstName="Gayle">Some Message</person>
 *     </family>
 * Becomes:
 *     1 4 McDowell 5 CA 0 2 3 Gayle 0 Some Message 0 0
 * Write code to print the encoded version of an XML element
 * (passed in Element and Attribute objects).
 */
public class Q10 {
    public static String encode(Element root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }
    private static void encode(Element root, StringBuilder sb) {
        if (root == null) return;
        encode(root.getTag(), sb);
        for (Attribute a : root.getAttributes()) {
            encode(a, sb);
        }
        end(sb);
        if (root.hasValue()) {
            encode(root.getValue(), sb);
        }
        for (Element e : root.getChildren()) {
            encode(e, sb);
        }
        end(sb);
    }

    private static void encode(Attribute a, StringBuilder sb) {
        if (a == null) return;
        encode(a.getTag(), sb);
        encode(a.getValue(), sb);
    }

    private static void encode(String s, StringBuilder sb) {
        sb.append(s).append(" ");
    }

    private static void end(StringBuilder sb) {
        encode("0", sb);
    }

    class Element {
        /* Not implemented */
        String getTag() { return null; }
        List<Attribute> getAttributes() { return null; }
        List<Element> getChildren() { return null; }
        boolean hasValue() { return false; }
        String getValue() { return null; }
    }

    class Attribute {
        /* Not implemented */
        String getTag() { return null; }
        String getValue() { return null; }
    }
}
