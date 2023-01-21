package interface_form;
/**
 * @param <E>
 *     제네릭: 데이터 형식에 의존하지 않고, 하나의 값이 여러 다른 데이터 타입들을 가질 수 있도록 하는 방법
 *           클래스 내부에서 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 것을 의미
 */

public interface List<E> {
    /**
     * 리스트에 요소 추가
     * @param value 리스트에 추가할 요소
     * @return 리스트에서 중복을 허용하지 않을 경우 중복되는 요소가 있으면 {@code false}를, 중복되는 요소가 없을 경우{@code true}를 반환
     */
    boolean add(E value);

    /**
     * 리스트에 요소를 특정 위치에 추가 -> 특정 위치 이후의 요소들은 뒤로 한칸씩 밀림
     * @param index 요소를 추가할 특정 위치 변수
     * @param value 추가할 요소
     */
    void add(int index, E value);

    /**
     * 리스트의 index 위치에 있는 요소를 삭제
     * @param index 리스트에서 삭제할 위치 변수
     * @return 삭제된 요소를 반환
     */
    E remove(int index);

    /**
     * 리스트에서 특정 요소를 삭제 -> 여러개일 경우 가장 처음 요소를 삭제
     * @param value 리스트에서 삭제할 요소
     * @return 리스트에 삭제할 요소가 없거나 삭제에 실패할 경우 {@code false}를, 성공할 경우{@code true}를 반환
     */
    boolean remove(Object value);

    /**
     * 리스트에 있는 특정 위치의 요소를 반환
     * @param index 리스트에 접근할 위치 변수
     * @return 리스트의 index 위치에 있는 요소 반환
     */
    E get(int index);

    /**
     * 리스트에서 특정 위치에 있는 요소를 새 요소로 대체
     * @param index 리스트에 접근할 위치 변수
     * @param value 새로 대체할 요소 변수
     */
    void set(int index, E value);

    /**
     * 특정 요소가 리스트에 있는지 여부를 확인
     * @param value 리스트에서 찾을 특정 요소 변수
     * @return 리스트에 특정 요소가 존재할 경우 {@code true}를, 존재하지 않을 경우{@code false}를 반환
     */
    boolean contains(Object value);

    /**
     * 리스트에 특정 요소가 몇 번째 위치에 있는지를 반환
     * @param value 리스트에서 위치를 찾을 요소
     * @return 리스트에서 처음으로 일치하는 요소의 위치를 반환 -> 요소가 없을 경우 -1
     */
    int indexOf(Object value);

    /**
     * 리스트에 있는 요소의 개수를 반환
     * @return 리스트에 있는 요소의 개수를 반환
     */
    int size();

    /**
     * 리스트에 요소가 비어있는지를 반환
     * @return 리스트에 요소가 없을 경우 {@code true}를, 있을 경우 {@code false}를 반환
     */
    boolean isEmpty();

    /**
     * 리스트에 있는 요소를 모두 삭제
     */
    public void clear();
}
