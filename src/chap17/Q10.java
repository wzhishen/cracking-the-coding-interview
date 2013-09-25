package chap17;

public class Q10 {
//    Since XML is very verbose, you are given a way of encoding it where each
//    tag gets mapped to a pre-defined integer value. The language/grammar is as
//    follows:
//    Element --> Tag Attributes END Children END
//    Attribute --> Tag Value
//    END --> 0
//    Tag --> some predefined mapping to int
//    Value --> string value END
//    For example, the following XML might be converted into the compressed string
//    below (assuming a mapping of family -> 1, person ->2, firstName ->
//    3, lastName -> 4, state -> 5).
//    <family lastName="McDowell" state="CA">
//    <person firstName="Gayle">Some Message</person>
//    </family>
//    Becomes:
//    1 4 McDowell 5 CA 0 2 3 Gayle 0 Some Message 0 0.
//    Write code to print the encoded version of an XML element (passed in Element
//    and Attribute objects).
    
    void encode(Element root, StringBuffer sb) {
        if (root == null) return;
        encode(root.getTagName(), sb);
        for (Attribute a : root.attributes()) {
            encode(a, sb);
        }
        encode("0", sb);
        if (root.hasValue())
            encode(root.getValue(), sb);
        for (Element e : root.children()) {
            encode(e, sb);
        }
        encode("0", sb);
    }
    void encode(String s, StringBuffer sb) {
        sb.append(s).append(" ");
    }
    
    void encode(Attribute a, StringBuffer sb) {
        encode(a.getTagName(), sb);
        encode(a.getValue(), sb);
    }
    
    class Element {
        String getTagName() {return null;}
        Attribute[] attributes() {return null;}
        Element[] children() {return null;}
        String getValue() {return null;}
        boolean hasValue() {return false;}
    }
    
    class Attribute {
        String getTagName() {return null;}
        String getValue() {return null;}
    }

}
