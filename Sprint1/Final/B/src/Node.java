class Node<V> {
    private V value;
    private Node<V> next;
    public Node(V value, Node<V> next) {
        this.value = value;
        this.next = next; }
    public V getValue() {
        return value; }
    public Node<V> getNext() {
        return next; }
    public void setNext(Node<V> next) {
        this.next = next; }
    public boolean hasNext() {
        return next != null; }
    public void setValue(V value) {
        this.value = value; }
}