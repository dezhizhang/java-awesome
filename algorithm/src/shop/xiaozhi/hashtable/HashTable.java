package shop.xiaozhi.hashtable;

public class HashTable {
    public static void main(String[] args) {


    }
}


class Entry {
    int hash; // 哈希码
    Object key; // 键
    Object value; // 值
    Entry next;
    int size = 0;
    Entry[] table = new Entry[16];

    public Entry(int hash, Object key, Object value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    // 根据hash码获取value
    public Object get(int hash, Object k) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            return null;
        }
        Entry p = table[idx];
        while (p != null) {
            if (p.key.equals(k)) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    // 向hash表存入新key value,如果key重复则更新value
    public void put(int hash, Object key, Object value) {
        int idx = hash & table.length - 1;

        // idx处有空位直接新增
        if (table[idx] == null) {
            table[idx] = new Entry(hash, key, value);
        } else {
            Entry p = table[idx];
            while (true) {
                // 更新新节点
                if (p.key.equals(key)) {
                    p.value = value;
                    return;
                }
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }
            // 添加新节点
            p.next = new Entry(hash, key, value);
        }
        size++;
    }




}
