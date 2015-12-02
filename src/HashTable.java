import java.util.*;


//ある文字列が、全てユニークである（重複する文字がない）かどうかを判定するアルゴリズムを実装してください。
//また、それを実装するのに新たなデータ構造が使えない場合、どのようにすればよいですか？
class HashTable{
	public static void main(String[] args){
		String str = "abc";
		String str2 = "aab";
		checkUnique(str);
		checkUnique(str2);
	}
	public static void checkUnique(String str){
		Hashtable ht = new Hashtable();
		//Scan the string and put into the hash
		for(int i=0;i<str.length();i++){
			//if hash have this character->print and end
			if(ht.get(str.charAt(i))!=null){
				System.out.println("It is not the unique string");
				return;
			}else{
				//else->put
				ht.put(str.charAt(i), true);
			}
		}
		System.out.println("This is the unique String");
	}
}