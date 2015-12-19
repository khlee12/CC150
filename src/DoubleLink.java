public class DoubleLink<E>{
       private Node head = null;//头指针
       private Node tail = null;//尾指针
       private int size;//链表元素个数
   
       public DoubleLink(){ //构造一个空LinkedList
           size = 0;
       }
     //内部类 
//      private class Node{
//          E element;
//          Node next;
//          Node prev;
//          public Node(E element, Node next, Node prev){
//              this.element = element;
//              this.prev = prev;
//              this.next = next;
//          }
//          public Node(E element){
//              this(element, null, null);
//          }
//      }
        //返回元素个数
      public int size(){
          return size;
      }
      //判断是否为空
      public boolean isEmpty(){
          return size == 0;
      }
     //添加链首元素 算法时间复杂度O(1)
      public void addFirst(E element){
          Node tmp = new Node(element, head, null);
          if(head != null){ head.prev = tmp; }
          head = tmp;
          if(tail == null) { tail = tmp; }
          size ++;
      }
        //添加链尾元素 算法时间复杂度:O(1)
      public void addLast(E element){
          Node tmp = new Node(element, null, tail);
          if(head == null)
              head = tmp;
          if(tail != null)
              tail.next = tmp;
          tail = tmp;
          size ++;
      }
        //从头开始遍历 O(n)
      public String iterateForward(){
          Node temp = head;
          StringBuilder s = new StringBuilder();
          while(temp != null){
              s.append(temp.element + " ");
              temp = temp.next;          }
          return s.toString();
      }
        //从尾部开始遍历 算法时间复杂度:O(n)
      public String iterateBackward(){
          Node temp = tail;
          StringBuilder s = new StringBuilder();
          while(temp != null){
              s.append(temp.element + " ");
              temp = temp.prev;
          }
          return s.toString();
      }
        //移除链首元素  算法时间复杂度:O(1)
      public E removeFirst(){
          if(head == null)
              return null;
          E element = (E) head.element;
          head = head.next;
          if(head == null)
              tail = null;
          else
              head.prev = null;
          size --;
          return element;
      }
        //移除链尾元素 算法时间复杂度:O(1)
      public E removeLast(){
          if(tail == null)
              return null;
          E element = (E) tail.element;
          tail = tail.prev;
          if(tail == null)
              head = null;
          else
              tail.next = null;
          size --;
          return element;
      }
        //指定位置 添加元素 平均算法时间复杂度:O(n)
      public void add(int index, E element){
          //index can only be 0 ~ size()
          if(index < 0 || index > size)
              throw new IndexOutOfBoundsException();
          if(index == 0)
              addFirst(element);
          else if(index == size)
              addLast(element);
          else{
              Node temp = head;
             for(int i=0; i<index; i++){
                 temp = temp.next;
             }
             Node insert = new Node(element, temp, temp.prev);
             temp.prev.next = insert;
             temp.prev = insert;
             size ++;
         }
     }
            //移除指定位置元素 算法时间复杂度:O(n) 
     public E remove(int index){
         E element = null;
         if(index < 0 || index >=size)
             throw new IndexOutOfBoundsException();
         if(index == 0)
             removeFirst();
         else if(index == size-1)
             removeLast();
         else{
             Node temp = head;
             for(int i=0; i<index; i++){
                 temp = temp.next;
             }
             element = (E) temp.element;
             temp.next.prev = temp.prev;
             temp.prev.next = temp.next;
             temp.next = null;
             temp.prev = null;
             size --;
         }
         return element;
     }
            //判断是否包含某一元素 平均算法时间复杂度:O(n)
     public boolean contains(E element){
         return indexOf(element) != -1;
     }
     //return the index of the first occurence 
     public int indexOf(E element){
         Node temp = head;
         int index = -1;
         while(temp != null){
             index ++;
             if(temp.element.equals(element)){
                 return index;
             }
             temp = temp.next;
         }
         return -1;
     }
            //修改指定位置元素 平均算法时间复杂度:O(n)
     public void set(int index, E element){
         if(index<0 || index>=size)
             throw new IndexOutOfBoundsException();
         else{
             Node temp = head;
             for(int i=0; i<index; i++){
                 temp = temp.next;
             }
             temp.element = element;
         }
     }
            //获得指定位置的元素 平均算法时间复杂度:O(n)
     public E get(int index){
         if(index<0 || index>=size)
             throw new IndexOutOfBoundsException();
         else{
             Node temp = head;
             for(int i=0; i<index; i++){
                 temp = temp.next;
             }
             return (E) temp.element;
         }
     }
     public Node getHead(){
    	 return head;
     }
     public Node getTail(){
    	 Node result = head;
    	 while(result.next!=null){
    		 result = result.next;
    	 }
    	 return result;
     }
     //这里可以直接设置head = tail = null
     public void clear(){
         Node temp = head;
         while(head != null){
             temp = head.next;
             head.prev = head.next = null;
             head = temp;
         }
         temp = null;
         tail.prev = tail.next = null;
         size = 0;
     }
}