import java.util.*;


class CP2{
//	public static void main(String[] args) throws Exception{
//		DoubleLink<Integer> dlink3 = new DoubleLink<>();
//		dlink.add(4," kife ");
//        dlink3.addLast(0);
//        dlink3.addLast(2);
//        dlink3.addLast(2);
//        dlink3.addLast(1);
//        dlink3.addLast(0);
//        if(isPalindrome(dlink3))
//        	System.out.println("YES");
//        else
//        	System.out.println("NO");
//     }
	//解決法で、パラメータを配列としたが、ノードでもできる点に注意！
	public static void deleteDups(DoubleLink<Integer> array){
		//2.1ソートされていない連結リストから、重複する要素を削除するコードを書いてください。
		Hashtable ht = new Hashtable();
		//scan the node in list
		//if already in the list -> delete
		//else put into hash
		Node node = array.getHead();
		int count = 0;
		while(node!=null){
			Integer data = (Integer) node.element;
			if(ht.containsKey(data)){
				node = node.next;
				if(node==null)	array.removeLast();
				else	array.remove(count);
			}else{
				ht.put(data, true);
				node = node.next;
			}
			count++;
		}
	}
	//バッファが使用できない場合
	public static void deleteDups2(DoubleLink<Integer> array){
		Node head = array.getHead();
		if(head==null)	return;
		Node current = head;
		while(current!=null){
			Node runner = current;
			while(runner.next!=null){
				if(runner.next.element==current.element){
					runner.next  =runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	public static Node searchBackward(DoubleLink<Integer> array,int index){
		//2.2単方向連結リストにおいて、末尾から数えてk番目の要素を見つけるアルゴリズムを実装してください。
		if(index>array.size()||index<0||array==null)	return null;
		Node head = array.getHead();
		Node result = head;
		int pos = array.size()-index-1;
		for(int i=0;i<pos;i++){
			result = result.next;
		}
		return result;
	}
	public static Node searchBackward2(DoubleLink<Integer> array, int index){
		if(index>array.size()||index<0||array==null)	return null;
		Node head1 = array.getHead();
		Node head2 = array.getHead();
		for(int i=0;i<index-1;i++){
			head2 = head2.next;
		}
		while(head2.next!=null){
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1;
	}
	public static void deleteCentral(){
		//2.3単方向連結リストにおいて、中央の要素のみアクセス可能であるとします。
		//その要素を削除するアルゴリズムを実装してください。
		//*****削除するノードがリストの末尾である場合、この問題を解くことはできない。
		//delete node
		//next = node.next
		//node.data = next.data
		//n.next = next.next;
	}
	public static void seperateByX(DoubleLink<Integer> array, Integer x){
		//2.4ある数が与えられたとき、連結リストの要素を並び替え、xより小さいものが前に来るようにするコードを書いてください。
		//scan the array
		//if element is greater than x, add in the last
		Node current = array.getHead();
		Node previous = null;
		Integer tail = (Integer)array.getTail().element;
		boolean flag = false;
		int count = 0;
		while((Integer)current.element != tail){
			if(count==1){
				previous = array.getHead();
			}
			count++;
			flag = false;
			if((Integer)current.element>x){
				Integer temp = (Integer)current.element;
				previous.next = current.next;
				current = previous;
				array.addLast(temp);
				flag = true;
			}
			current  = current.next;
			if(previous!=null&&!flag)	previous = previous.next;
		}
	}
	public static DoubleLink<Integer> calculate(DoubleLink<Integer> array1, DoubleLink<Integer> array2){
		//2.5各ノードの要素が１桁の和数である連結リストで表れた二つの数があります。
		//一の位がリストの先頭になるように、各位の数は逆順に並んでいます。
		//このとき、二つの数の和を求め、それを連結リストで表したものを返す関数を書いてください。
		//上位の桁から順方向に連結されたリストを解いて、同様に書いてみてください。
		if(array1==null||array2==null)	return null;
		Node runner  = array1.getHead();
		Node chaster = array2.getHead();
		if(array1.size()<array2.size()){
			runner = array2.getHead();
			chaster = array1.getHead();
		}
		
		DoubleLink<Integer> result = new DoubleLink<Integer>();
		while(runner!=null){
			int para = 0;
			if(chaster!=null){
				//add and put into result
				Integer sum =  (Integer)runner.element + (Integer)chaster.element+para;
				Integer one = sum%10;
				if(one>10)	para = 1;
				result.addLast(one);
			}
			Integer sum =  (Integer)runner.element+para;
			Integer one = sum%10;
			if(one>0)	para = 1;
			result.addLast(one);
		}
		return result;
	}
	public static Node findBeginning(DoubleLink<Integer> array){
		//2.6循環する連結リストを与えられたとき、循環する部分の最初のノードを返すアルゴリズムを実装してください。
		//return the same node that both node's next node is the same
		
		return null;
	}
	public static boolean isPalindrome(DoubleLink<Integer> array){
		//2.7連結リストが回文（先頭から巡回しても末尾から巡回しても、
		//各ノードの要素が全く同じになっている）かどうかを調べる関数を実装してください
		//check whether the length is odd number
		if(array.size()%2==0)	return false;
		if(array.size()==1)	return true;
		
		//put the elements of array into the stack
		Stack<Integer> buffer = new Stack<Integer>();
		Node<Integer> runner = array.getHead();
		while(runner!=null){
			Integer element = runner.element;
			buffer.push(element);
			runner = runner.next;
		}
		//check whether the array element and the stack is the same or not
		runner = array.getHead();
		while(runner!=null){
			Integer temp = buffer.pop();
			if(temp!=runner.element)	return false;
			runner = runner.next;
		}
		return true;
	}
}