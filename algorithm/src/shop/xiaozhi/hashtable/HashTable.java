package shop.xiaozhi.hashtable;

public class HashTable {
    // 节点类
    static class Entry {
        int hash; // 哈希码
        Object key; // 键
        Object value; // 值
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }


    }

    Entry[] table = new Entry[16];
    int size = 0; // 元素个数

    // 根据hash码获取value
    Object get(int hash, Object key) {
        return null;
    }

    // 根据hash存放数据，如果key重复更新value
    void put(int hash, Object key, Object value) {

    }

    // 根据hash码删除
    Object remove(int hash, Object key) {
        return null;
    }

}


