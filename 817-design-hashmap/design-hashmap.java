import java.util.*;

// Pair class
class Pair<U, V> {
    U first;
    V second;

    public Pair(U f, V s) {
        this.first = f;
        this.second = s;
    }
}

// Bucket class
class Bucket {
    List<Pair<Integer, Integer>> list;

    public Bucket() {
        list = new LinkedList<>();
    }

    // Insert or update
    public void put(int key, int value) {
        for (Pair<Integer, Integer> p : list) {
            if (p.first.equals(key)) {
                p.second = value;
                return;
            }
        }
        list.add(new Pair<>(key, value));
    }

    // Get value
    public int get(int key) {
        for (Pair<Integer, Integer> p : list) {
            if (p.first.equals(key)) {
                return p.second;
            }
        }
        return -1;
    }

    // Remove key
    public void remove(int key) {
        Iterator<Pair<Integer, Integer>> it = list.iterator();
        while (it.hasNext()) {
            Pair<Integer, Integer> p = it.next();
            if (p.first.equals(key)) {
                it.remove();
                return;
            }
        }
    }
}

// Main HashMap class
class MyHashMap {
    private Bucket[] buckets;
    private int keyRange = 769;

    public MyHashMap() {
        buckets = new Bucket[keyRange];
        for (int i = 0; i < keyRange; i++) {
            buckets[i] = new Bucket();
        }
    }

    private int getBucketIndex(int key) {
        return key % keyRange;
    }

    // Put key-value
    public void put(int key, int value) {
        int bucketIdx = getBucketIndex(key);
        buckets[bucketIdx].put(key, value);
    }

    // Get value
    public int get(int key) {
        int bucketIdx = getBucketIndex(key);
        return buckets[bucketIdx].get(key);
    }

    // Remove key
    public void remove(int key) {
        int bucketIdx = getBucketIndex(key);
        buckets[bucketIdx].remove(key);
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */