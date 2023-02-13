package interface_form.Set;

public class HashSet<E> implements Set<E>{

    // 최소 기본 용적(2^n 꼴 형태가 좋음)
    private final static int DEFAULT_CAPACITY = 1 << 4;

    // 3/4 이상 채워질 경우 resize하기 위함
    private final static float LOAD_FACTOR = 0.75f;

    Node<E>[] table;	// 요소의 정보를 담고있는 Node를 저장할 Node타입 배열
    private int size;	// 요소의 개수

    @SuppressWarnings("unchecked")
    public HashSet(){
        table = (Node<E> []) new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    private static final int hash(Object key){
        int hash;
        if(key == null){
            return 0;
        }else {
            return Math.abs(hash = key.hashCode()) ^ (hash >>> 16);
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {

        int newCapacity = table.length * 2;

        // 기존 테이블의 두배 용적으로 생성
        final Node<E>[] newTable = (Node<E>[]) new Node[newCapacity];

        // 0번째 index부터 차례대로 순회
        for (int i = 0; i < table.length; i++) {

            // 각 인덱스의 첫 번째 노드(head)
            Node<E> value = table[i];

            // 해당 값이 없을 경우 다음으로 넘어간다.
            if (value == null) {
                continue;
            }


            table[i] = null; // gc

            Node<E> nextNode;	// 현재 노드의 다음 노드를 가리키는 변수

            // 현재 인덱스에 연결 된 노드들을 순회한다.
            while (value != null) {

                int idx = value.hash % newCapacity;	// 새로운 인덱스를 구한다.

                /*
                 * 새로 담을 index에 요소(노드)가 존재할 경우
                 * == 새로 담을 newTalbe에 index값이 겹칠 경우 (해시 충돌)
                 */
                if (newTable[idx] != null) {
                    Node<E> tail = newTable[idx];

                    // 가장 마지막 노드로 간다.
                    while (tail.next != null) {
                        tail = tail.next;
                    }
                    /*
                     *  반드시 value가 참조하고 있는 다음 노드와의 연결을 끊어주어야 한다.
                     *  안하면 각 인덱스의 마지막 노드(tail)도 다른 노드를 참조하게 되어버려
                     *  잘못된 참조가 발생할 수 있다.
                     */
                    nextNode = value.next;
                    value.next = null;
                    tail.next = value;
                }
                // 충돌되지 않는다면(=빈 공간이라면 해당 노드를 추가)
                else {

                    /*
                     *  반드시 value가 참조하고 있는 다음 노드와의 연결을 끊어주어야 한다.
                     *  안하면 각 인덱스의 마지막 노드(tail)도 다른 노드를 참조하게 되어버려
                     *  잘못된 참조가 발생할 수 있다.
                     */
                    nextNode = value.next;
                    value.next = null;
                    newTable[idx] = value;
                }

                value = nextNode;	// 다음 노드로 이동
            }
        }
        table = null;
        table = newTable;	// 새로 생성한 table을 table변수에 연결
    }

    @Override
    public boolean add(E e) {
        return add(hash(e), e) == null;
    }

    private E add(int hash, E key) {
        int idx = hash % table.length;

        if(table[idx] == null){
            table[idx] = new Node<>(hash, key, null);
        }else{
            Node<E> temp = table[idx];
            Node<E> prev = null;
            while (temp != null){
                if((temp.hash == hash) && (temp.key == key || temp.key.equals(key))){
                    return key;
                }
                prev=temp;
                temp=temp.next;
            }
            prev.next = new Node<>(hash, key, null);
        }
        size++;

        // 데이터의 개수가 현재 table 용적의 75%을 넘어가는 경우 용적을 늘려준다.
        if (size >= LOAD_FACTOR * table.length) {
            resize();	// 아직 미구현 상태임
        }
        return null;	// 정상적으로 추가되었을 경우 null반환
    }


    @Override
    public boolean remove(Object o) {
        return remove(hash(o), o) != null;
    }

    private Object remove(int hash, Object key) {
        int idx = hash % table.length;

        Node<E> node = table[idx];
        Node<E> removeNode = null;
        Node<E> prev = null;

        if(node == null){
            return null;
        }

        while (node != null){
            if(node.hash == hash && (node.key == key || node.key.equals(key))){
                removeNode = node;
                if(prev == null){
                    table[idx] = node.next;
                    node=null;
                }else {
                    prev.next = node.next;
                    node=null;
                }
                size--;
                break;
            }
            prev=node;
            node=node.next;
        }
        return removeNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        int idx = hash(o) % table.length;
        Node<E> temp = table[idx];

        /*
         *  같은 객체 내용이어도 hash값은 다를 수 있다.
         *  하지만, 내용이 같은지를 알아보고 싶을 때 쓰는 메소드이기에
         *  hash값은 따로 비교 안해주어도 큰 지장 없다.
         *  단, o가 null인지는 확인해야한다.
         */
        while (temp != null) {
            // 같은 객체를 찾았을 경우 true리턴
            if ( o == temp.key || (o != null && (o.equals(temp.key)))) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    @Override
    public void clear() {
        if (table != null && size > 0) {
            for (int i = 0; i < table.length; i++) {
                table[i] = null;	// 모든 노드를 삭제한다.
            }
            size = 0;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {

        // 만약 파라미터 객체가 현재 객체와 동일한 객체라면 true
        if(o == this) {
            return true;
        }
        // 만약 o 객체가 HashSet이 아닌경우 false
        if(!(o instanceof HashSet)) {
            return false;
        }

        HashSet<E> oSet;

        /*
         *  Object로부터 HashSet<E>로 캐스팅 되어야 비교가 가능하기 때문에
         *  만약 캐스팅이 불가능할 경우 ClassCastException 이 발생한다.
         *  이 경우 false를 return 하도록 try-catch문을 사용해준다.
         */
        try {

            // HashSet 타입으로 캐스팅
            oSet = (HashSet<E>) o;
            // 사이즈(요소 개수)가 다르다는 것은 명백히 다른 객체다.
            if(oSet.size() != size) {
                return false;
            }

            for(int i = 0; i < oSet.table.length; i++) {
                Node<E> oTable = oSet.table[i];

                while(oTable != null) {
                    /*
                     * 서로 Capacity가 다를 수 있기 때문에 index에 연결 된 원소를을
                     * 비교하는 것이 아닌 contains로 원소의 존재 여부를 확인해야한다.
                     */
                    if(!contains(oTable)) {
                        return false;
                    }
                    oTable = oTable.next;
                }
            }

        } catch(ClassCastException e) {
            return false;
        }
        // 위 검사가 모두 완료되면 같은 객체임이 증명됨
        return true;

    }
}
