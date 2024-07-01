package in.cdac.queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));

	}

	public static String solve(String A) {
		StringBuffer res = new StringBuffer(" ");
		Queue<Character> q = new LinkedList<>();
		HashMap<Character,Integer> hs = new HashMap<>();
		q.add(A.charAt(0));
		res.append(A.charAt(0));
		hs.put(A.charAt(0),1);
		// int[] freqOfChar=new int[26];
		for (int i = 1; i < A.length(); i++) {
            
			hs.put(A.charAt(i),);
             if (q.peek().charValue() == A.charAt(i)) {
				while (!q.isEmpty() && A.charAt(i)==q.peek().charValue() && hs.containsKey(q.peek())) {
					q.poll();
				}
				if (q.isEmpty())
					res.append('#');
				else
					res.append(q.peek());
			} else {
				if (!hs.contains(A.charAt(i))) {
					
					hs.add(A.charAt(i));
					q.add(A.charAt(i));
				}
				res.append(q.peek());

			}

		}

		return res.toString().trim();
	}

}
