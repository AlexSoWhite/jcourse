//Операции
//        - Положить по ключу значение:          public void put(Object key, Object value);
//        - Получить по ключу:                   public Object get(Object key);
//        - Получить по ключу,                   public Object get(Object key, Object bydefault);
//        если значение null, тогда надо
//        вернуть значение по умолчанию,
//        которое задается вторым параметром.
//        Значение по умолчанию необходимо
//        сохранить.
//        - Удалить по ключу, возвращает текущее public Object remove(Object key);
//        значение
//        - Проверить наличие ключа:             public boolean keyContains(Object key);
//        - Получить список ключей:              public List getKeys();
//        - Получить список значений:            public List getValues();
//        - Получить список пар: ключ, значение: public List getEntries();
//        - Размер словаря:                      public int size();
//        - Пустой или нет:                      public boolean isEmpty();



class Node{
    public Object key;
    public Object value;
    Node(Object key, Object value){
        this.key = key;
        this.value = value;
    }
}

public class Map {
    private MyList list;

    Map(){
        this.list= new MyList();
    }
    public void put(Object key, Object value){
        this.list.add(new Node(key, value));
    }

    public Object get(Object key){
        for (int i = 0; i < this.list.size(); i ++) {
            Node curr = (Node) this.list.get(i);
            if (curr.key == key)
                return curr.value;
        }
        return null;
    }

    public Object get(Object key, Object bydefault){
        int sz = this.list.size();
        for (int i = 0; i < sz; i ++) {
            Node curr = (Node) this.list.get(i);
            if (curr.key == key)
                return curr.value == null ? bydefault : curr.value;
        }
        return bydefault;
    }

    public Object remove(Object key){
        int sz = this.list.size();
        for (int i = 0; i < sz; i ++) {
            Node curr = (Node) this.list.get(i);
            if (curr.key == key) {
                curr = (Node) this.list.remove(i);
                return curr.value;
            }
        }
        return null;
    }

    public boolean keyContains(Object key){
        int sz = this.list.size();
        for (int i = 0; i < sz; i ++) {
            Node curr = (Node) this.list.get(i);
            if (curr.key == key)
                return true;
        }
        return false;
    }

    public MyList getKeys(){
        int sz = this.list.size();
        MyList keys = new MyList();
        for (int i = 0; i < sz; i ++) {
            Node curr = (Node) this.list.get(i);
            keys.add(curr.key);
        }
        return keys;
    }

    public MyList getValues(){
        int sz = this.list.size();
        MyList values = new MyList();
        for (int i = 0; i < sz; i ++) {
            Node curr = (Node) this.list.get(i);
            values.add(curr.value);
        }
        return values;
    }

    public MyList getEntries(){
        int sz = this.list.size();
        MyList entries = new MyList();
        for (int i = 0; i < sz; i ++) {
            Node curr = (Node) this.list.get(i);
            entries.add(curr);
        }
        return entries;
    }

    public int size(){
        return this.list.size();
    }

    public boolean isEmpty(){
        return this.list.isEmpty();
    }
}
