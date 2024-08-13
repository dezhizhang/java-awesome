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
        int idx = hash & (table.length - 1);

        if (table[idx] == null) {
            return null;
        }

        Entry p = table[idx];
        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }

        return null;
    }

    // 根据hash存放数据，如果key重复更新value
    void put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            table[idx] = new Entry(hash, key, value);
        } else {
            Entry p = table[idx];
            while (true) {
                if (p.key.equals(key)) {
                    // 更新
                    p.value = value;
                    return;
                }
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            p.next = new Entry(hash, key, value);
        }
    }

    // 根据hash码删除
    Object remove(int hash, Object key) {
        return null;
    }

}


