package iua.info3.structures;

import java.util.Arrays;

public class HashTableOpen<TypeKey extends Comparable, TypeValue> {
    AvlTree<HashEntry<TypeKey, TypeValue>>[] table;


    public HashTableOpen(int size) {
        this.table = new AvlTree[size];
        for (int i = 0; i < table.length; i++) {
            table[i] = new AvlTree<>();
        }
    }

    private int hashFunc(TypeKey key) {
        return (int) key % table.length;
    }

    public void insert(TypeKey clave, TypeValue value) throws Exception {
        int pos = hashFunc(clave);
        table[pos].insert(new HashEntry<>(clave, value));
    }

    public TypeValue get(TypeKey clave) throws Exception {
        int pos = hashFunc(clave);
        return table[pos].get(new HashEntry<>(clave, null)).value;
    }

    public void remove(TypeKey clave) throws Exception {
        int pos = hashFunc(clave);
        table[pos].remove(new HashEntry<>(clave, null));
    }

    private static class HashEntry<TypeKey extends Comparable, TypeValue> implements Comparable<HashEntry> {
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

        @Override
        public int compareTo(HashEntry hashEntry) {
            return key.compareTo(hashEntry.getKey());
        }
    }

    public static void main(String[] args) {
        HashTableOpen<Integer, String> miTable = new HashTableOpen<>(7);

        try {
            miTable.insert(0, "HOLA");
            miTable.insert(1, "CHAU");
            miTable.insert(7, "COLI");
            miTable.insert(8, "COLI2");

            System.out.println(miTable.get(1));
            miTable.remove(1);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(miTable.get(1));
        } catch (Exception e) {
            System.out.println("Se removió correctamente");
        }
    }
}
