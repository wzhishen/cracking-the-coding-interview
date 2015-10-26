package chap08;

import java.util.ArrayList;
import java.util.List;

/**
 * Explain the data structures and algorithms that you would
 * use to design an in-memory file system. Illustrate with an
 * example in code where possible.
 */
public class Q09 {
    public abstract class Entry {
        protected String name;
        protected Directory parent;
        protected long created;
        protected long modified;
        protected long accessed;
        public Entry(String n, Directory p) {
            name = n;
            parent = p;
            created = modified = accessed = System.currentTimeMillis();
        }
        public abstract int size();
        public abstract void clear();
        public String getPath() {
            if (parent == null) return "/" + name;
            return parent.getPath() + "/" + name;
        }
        public String getName() {
            return name;
        }
        public void rename(String name) {
            modified = System.currentTimeMillis();
            this.name = name;
        }
        public Directory getParent() {
            return parent;
        }
        public void setParent(Directory parent) {
            modified = System.currentTimeMillis();
            this.parent = parent;
        }
        public long getCreated() {
            return created;
        }
        public long getModified() {
            return modified;
        }
        public long getAccessed() {
            return accessed;
        }
    }
    public class Directory extends Entry {
        private List<Entry> contents;
        public Directory(String n, Directory p) {
            super(n, p);
            contents = new ArrayList<Entry>();
        }
        public int size() {
            int size = 0;
            for (Entry e : contents) size += e.size();
            return size;
        }
        public List<Entry> getContents() {
            accessed = System.currentTimeMillis();
            return contents;
        }
        public void add(Entry e) {
            modified = System.currentTimeMillis();
            contents.add(e);
        }
        public void merge(List<Entry> es) {
            modified = System.currentTimeMillis();
            contents.addAll(es);
        }
        public boolean remove(Entry e) {
            modified = System.currentTimeMillis();
            return contents.remove(e);
        }
        public void clear() {
            modified = System.currentTimeMillis();
            contents.clear();
        }
    }
    public abstract class File extends Entry {
        protected int size;
        public File(String n, Directory p) {
            super(n, p);
        }
        public int size() {
            return size;
        }
        public void clear() {
            setContent(null);
        }
        public abstract Object getContent();
        public abstract void setContent(Object content);
    }
    public class TextFile extends File {
        private String content;
        public TextFile(String n, Directory p) {
            this(n, p, null);
        }
        public TextFile(String n, Directory p, String c) {
            super(n, p);
            setContent(c);
        }
        public Object getContent() {
            accessed = System.currentTimeMillis();
            return content;
        }
        public void setContent(String s) {
            modified = System.currentTimeMillis();
            content = s;
            size = s.length();
        }
        public void setContent(Object c) {
            modified = System.currentTimeMillis();
            String s = c.toString();
            content = s;
            size = s.length();
        }
    }
    public class BinaryFile extends File {
        private byte[] content;
        public BinaryFile(String n, Directory p) {
            this(n, p, null);
        }
        public BinaryFile(String n, Directory p, byte[] c) {
            super(n, p);
            setContent(c);
        }
        public Object getContent() {
            accessed = System.currentTimeMillis();
            return content;
        }
        public void setContent(byte[] c) {
            modified = System.currentTimeMillis();
            content = c;
            size = c.length;
        }
        public void setContent(Object c) {
            modified = System.currentTimeMillis();
            byte[] b = c.toString().getBytes();
            content = b;
            size = b.length;
        }
    }
    public class Symlink extends Entry {
        Entry to;
        public Symlink(String n, Directory p) {
            this(n, p, null);
        }
        public Symlink(String n, Directory p, Entry t) {
            super(n, p);
            pointTo(t) ;
        }
        public void pointTo(Entry e) {
            modified = System.currentTimeMillis();
            to = e;
        }
        public Entry getActualEntry() {
            accessed = System.currentTimeMillis();
            return to;
        }
        public int size() {
            if (to == null) return 0;
            return to.size();
        }
        public void clear() {
            pointTo(null);
        }
    }
}
