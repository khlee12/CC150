
import java.util.*;


class CP1{
	
	public static void checkUnique(String str){
		//1.1ある文字列が、全てユニークである（重複する文字がない）かどうかを判定するアルゴリズムを実装してください。
		//また、それを実装するのに新たなデータ構造が使えない場合、どのようにすればよいですか？
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
	public static void checkUnique2(String str){
		if(str.length()>256)	System.out.println("It is not the unique string");
		boolean[] char_set = new boolean[256];
		for(int i=0;i<str.length();i++){
			int val = str.charAt(i);
			if(char_set[val]){
				System.out.println("It is not the unique string");
			}
			char_set[val] = true;
		}
		System.out.println("This is the unique string");
	}
	public static String reverse(String str){
		//1.2文字列を逆に並び替える関数を実装してください
		if(str==null)	return null;
		String[] arr = str.split("");
		
		for(int i=0;i<arr.length;i++){
			int last = arr.length-i-1;
			if(i==last)	break;
			String temp = arr[i];
			arr[i] = arr[last];
			arr[last] = temp;
		}
		StringBuffer result = new StringBuffer();
		for(String w : arr){
			result.append(w);
		}
		str = result.toString();
		return str;
	}
	public static boolean isSorted(String s, String t){
		//1.3二つの文字列が与えられたとき、片方がもう片方の並び替えになっているかどうかを
		//決定するメソッドを書いてください。
		if(s.length()!=t.length())	return false;
		int[] letters = new int[256];
		char[] s_array = s.toCharArray();
		for(char c : s_array){
			letters[c]++;
		}
		for(int i=0;i<t.length();i++){
			int c = (int)t.charAt(i);
			if(--letters[c] < 0){
				return false;
			}
		}
		return true;
	}
	
	public static String switchEmpty(String str){
		//1.4文字列内に出現する全ての空白文字を"%20"で置き換えるメソッドを書いてください。
		//ただし、文字列の後ろには新たに文字を追加するためのスペースが十分にある（バッファーサイズは気にしなくても良い）ことと、
		//その追加用スペースを除いた文字列の真の長さが与えられます。
		//入力 "Mr John Smith   "
		//出力 "Mr%20John%20Smith"
		if(str==null||str.matches("\\s+"))	return null;
		String[] arr = str.split("");
		StringBuffer result = new StringBuffer();
		String switchStr = "%20";
		boolean wasEmpty = false;
		//check the true end of this string
		int len = arr.length;
		for(int i=arr.length-1;i>0;i--){
			if(!arr[i].matches("\\s+")){
				len = i+1;
				break;
			}
		}
		for(int i=0;i<len;i++){
			//empty
			if(arr[i].matches("\\s+")){
				if(!wasEmpty){//the first space program met
					result.append(switchStr);
					wasEmpty=true;
				}else{
					//the second or third spaces
					continue;
				}
			}else{
			//not empty =>add
				result.append(arr[i]);
				wasEmpty=false;
			}
		}
		str = result.toString();
		return str;
	}
	public static String pressStr(String str){
		//1.5文字の連続する数を使って基本的な文字列圧縮を行うめそっとを実装してください。
		//例えば、[aabcccccaaa]は[a2b1c5a3]のようにしてください。
		//もし、圧縮変換された文字列がもとの文字列よりも短くならなかった場合は、元の文字列を返してください。
		if(str==null||str.matches("\\s+"))	return null;
		String[] arr = str.split("");
		String flag = arr[0];
		int times=0;
		StringBuffer result = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(flag)){
				times++;
			}
			else{
				result.append(flag);
				result.append(times);
				flag=arr[i];
				times=1;
				if(result.length()>=str.length()){
					return str;
				}
			}
		}
		result.append(flag);
		result.append(times);
		str = result.toString();
		return str;
	}
	public static void reverse90(int[][] pixels){
		//for i=0 to n
		//	temp = top[i]
		//	top[i] = left[i]
		//	left[i] = bottom[i]
		//	bottom[i] = right[i]
		//	right[i] = temp
		//swap for four elements
		int n = pixels.length;
		for(int layer = 0; layer<n/2; ++layer){
			int first = layer;
			int last = n-1-layer;
			for(int i=first; i<last; ++i){
				int offset = i-first;
				//save the top value
				int top = pixels[first][i];
				//from left to top
				pixels[first][i] = pixels[last-offset][first];
				//bottom -> left
				pixels[last-offset][first] = pixels[last][last-offset];
				//right ->bottom
				pixels[last][last-offset] = pixels[i][last];
				//top->right
				pixels[i][last] = top;
			}
		}		
	}
	public static void change2Zero(int[][] array){
		//1.7NxMの行列について、要素が０であれば、その行と列の全てを０にするようなアルゴリズムを書いてください。
		boolean[] row = new boolean[array.length];
		boolean[] column = new boolean[array[0].length];
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				if(array[i][j]==0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		//行iまたは列jが0を含んでいれば、arr[i][j]を０にする
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++)
				if(row[i] || column[j])	array[i][j] = 0;
		}
	}
	//片方の文字列が、もう片方の文字列の一部分になっているかどうかを調べるメソッド[isSubstring]が使えると判定します。
	//二つの文字列s１とs２が与えられた時、isSubstringメソッドを一度だけ使ってs２がs１を回転させたものかどうかを判定する
	//コードを書いてください。例えば、[waterbottle]は[erbottlewat]を回転させたものになっています。
	public static boolean isRotation(String s1, String s2){
		int len = s1.length();
		if(len==s2.length() && len > 0){
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
	private static boolean isSubstring(String s1, String s2) {
		// TODO Auto-generated method stub
		String term = ".*"+s2+".*";
		if(s1.matches(term)){
			return true;
		}
		return false;
	}
}