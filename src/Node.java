class Node<E>{
          E element;
          Node next;
          Node prev;
          public Node(E element, Node next, Node prev){
              this.element = element;
              this.prev = prev;
              this.next = next;
          }
          public Node(E element){
              this(element, null, null);
          }
      }