package iua.info3.structures;

import java.util.Arrays;

public class HashTable<TypeKey extends Comparable, TypeValue> {
    HashEntry<TypeKey, TypeValue>[] table;

    public HashTable(int size) {
        this.table = new HashEntry[size];
        Arrays.fill(table, null);
    }

    private int hashFunc(TypeKey key) {
        return (int) key % table.length;
    }

    public void insert(TypeKey clave, TypeValue value) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] != null) {
            throw new Exception("Colision");
        }
        table[pos] = new HashEntry<>(clave, value);
    }

    public TypeValue get(TypeKey clave) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] == null) {
            throw new Exception("404");
        } else if (!table[pos].getKey().equals(clave)) {
            throw new Exception("404");
        }

        return table[pos].getValue();
    }

    public void remove(TypeKey clave) throws Exception {
        int pos = hashFunc(clave);
        if (table[pos] == null) {
            throw new Exception("404");
        } else if (!table[pos].getKey().equals(clave)) {
            throw new Exception("404");
        }
        table[pos] = null;
    }

    private static class HashEntry<TypeKey, TypeValue> {
        TypeKey key;
        TypeValue value;

        public HashEntry(TypeKey key, TypeValue value) {
            this.key = key;
            this.value = value;
        }

        public TypeKey getKey() {
            return key;
        }

        public void setKey(TypeKey key) {
            this.key = key;
        }

        public TypeValue getValue() {
            return value;
        }

        public void setValue(TypeValue value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTable<Integer, String> miTable = new HashTable<>(7);

        try {
            miTable.insert(0, "HOLA");
            miTable.insert(1, "CHAU");
            miTable.insert(5, "COLI");

            System.out.println(miTable.get(1));
            System.out.println(miTable.get(7));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
