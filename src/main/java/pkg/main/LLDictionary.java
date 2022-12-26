package pkg.main;
public class LLDictionary<Key, E> implements ADTDictionary<Key, E> {
    private final LList<KVpair<Key, E>> list; //store dictionary

    //Constructor
    public LLDictionary() {
        list = new LList<>();
    }

    @Override
    public void clear() {
         list.clear();
    }

    @Override
    public void insert(Key key, E e) {
         KVpair<Key, E> temp = new KVpair<Key, E>(key, e);
         list.append(temp);
    }

    @Override
    public E remove(Key key) {
        E temp = find(key);
        if (temp != null)
            list.remove();
        return temp;
    }

    @Override
    public E removeAny() {
        if (size() != 0) {
            KVpair<Key, E> e = list.remove();
            return e.getValue();
        } else
            return null;
    }
    @Override
    public E find(Key key) {
        this.list.moveToStart();
        for (int i = 0; i < this.list.length(); i++) {
            KVpair<Key, E> temp = this.list.getValue();
            if (key.equals(temp.getKey())) {
                return temp.getValue();
            }
            this.list.next();
        }
            return null;
    }

    @Override
    public int size() {
        return list.length();
    }

}
