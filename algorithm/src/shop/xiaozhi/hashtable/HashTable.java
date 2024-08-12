package shop.xiaozhi.hashtable;

public class HashTable {
    public static void main(String[] args) {
        int size = 0;
        Entry[] table = new Entry[16];

    }
}


class Entry {
    int hash; // 哈希码
    Object key; // 键
    Object value; // 值
    Entry next;

    public Entry(int hash, Object key, Object value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    // 根据hash码获取value
    public Object get(int hash, Object key) {
        return null;
    }


}
