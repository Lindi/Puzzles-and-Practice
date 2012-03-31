package topcoder;

import java.util.*;

public class MatchMaker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Comparator<Member> comparator = new Comparator<Member>() {
			public int compare(Member m1, Member m2) {
				return m1.compareTo(m2);
			}
		};
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("Lindi", 2, 1));
		list.add(new Member("Juli", 5, 2));
		list.add(new Member("Klaus", 5, 3));
		list.add(new Member("Joe", 7, 4));
		Collections.sort(list, comparator);
		Iterator<Member> iterator = list.iterator();
		while (iterator.hasNext()) {
			Member member = iterator.next();
			System.out.println(member.name + " score: " + member.score);
		}

		String member = "Lindi F F A A B C D E F";
		StringTokenizer tokenizer = new StringTokenizer(member);
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
	}

	private static class Member implements Comparable<Member> {
		public int index;
		public int score;
		public String name;
		public String gender ;
		public String seeking ;
		public String[] answers ;
		
		public Member () { 
			
		}
		public Member( String name, int score, int index ) {
			this.name = name ;
			this.score = score ;
			this.index = index ;
		}
		public int compareTo(Member member) {
			if (score < member.score) {
				return 1;
			} else if (score > member.score) {
				return -1;
			}
			// If they're equal, use their index number
			if (index > member.index) {
				return 1;
			}
			return -1;
		}
	}

	public static String[] getBestMatches(String[] members, String currentUserName, int sf) {

		// Find the current user in the array of members and mark their location
		List<Member> memberList = new ArrayList<Member>();
		Member currentUser = new Member();
		for (int i = 0; i < members.length; i++) {
			Member member = getMember( members[i], i );
			if ( member.name == currentUserName ) {
				currentUser = member ;
			} else {
				memberList.add(member);
			}
		}
		
		Comparator<Member> comparator = new Comparator<Member>() {
			public int compare(Member m1, Member m2) {
				return m1.compareTo(m2);
			}
		};
		List<Member> matches = new ArrayList<Member>() ;
		Iterator<Member> iterator = memberList.iterator();
		while ( iterator.hasNext()) {
			Member member = iterator.next();
			for ( int i = 0; i < member.answers.length; i++ ) {
				if ( member.answers[i] == currentUser.answers[i]) {
					member.score++ ;
				}
			}
			if ( member.score >= sf && member.gender == currentUser.seeking ) {
				matches.add(member);
			}
		}
		Collections.sort(matches,comparator);
		String[] matchNames = new String[matches.size()];
		iterator = matches.iterator() ;
		int i = 0 ;
		while ( iterator.hasNext()) {
			Member member = iterator.next();
			matchNames[i++] = member.name ;
		}
		return matchNames ;
		
		
		
		// Iterate over the members array, and for each member ...
		// Extract the member's name
		// If the member's name is the same as the current user's name, skip
		// that member's list entry
		// Extract the member's requested gender
		// If the member's gender is the same as the current user's requested
		// gender
		// Extract the member's gender
		// Extract the member's answers
		// Count the number of answers that the member had in common with the
		// current user

		// Add each potential mate (each member with an sf score greater than or
		// equal to sf) to a TreeMap
		// Extract each potential mate
	}

	private static Member getMember( String description, int index ) {

		StringTokenizer tokenizer = new StringTokenizer(description);
		// Extract the current user's name
		String name = tokenizer.nextToken();

		// Extract the current user's gender
		String gender = tokenizer.nextToken();

		// Extract the current user's requested gender
		String seeking = tokenizer.nextToken();

		// Extract the current user's answers
		String[] answers = new String[tokenizer.countTokens()];
		for ( int j = 0; tokenizer.hasMoreTokens();) {
			answers[j++] = tokenizer.nextToken();
		}
		Member member = new Member( );
		member.name = name ;
		member.gender = gender ;
		member.index = index ;
		member.seeking = seeking ;
		member.answers = answers ;
		member.score = 0 ;
		return member;
	}

}
