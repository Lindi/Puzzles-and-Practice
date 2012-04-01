package topcoder;
import java.util.*;

public class BusinessTasks {

	/**
	 * BusinessTasks - SRM 236 Div 1:
	 * N tasks are written down in the form of a circular list, 
	 * so the first task is adjacent to the last one. A number n is also given. 
	 * Starting with the first task, move clockwise 
	 * (from element 1 in the list to element 2 in the list and so on), 
	 * counting from 1 to n. When your count reaches n, remove that task 
	 * from the list and start counting from the next available task. 
	 * Repeat this procedure until one task remains. Return it.
	 */
	public static void main(String[] args) {
		//	Initialize an array of tasks
		List<String> tasks = new ArrayList<String>();
		tasks.add("A");
		tasks.add("B");
		tasks.add("C");
		tasks.add("D");
		tasks.add("E");
		tasks.add("F");
		tasks.add("G");
				
		//	Initialize n to be an arbitrary number of subtasks
		int n = 4 ;
		
		//	Initialize a counter at an initial value of 1 ;
		int j = 1 ;
		
		//	Iterate over tasks while tasks contains more than 1 item
		while ( tasks.size() > 1 ) {
			j += ( n - 1 );
			tasks.remove( j % tasks.size());
		}
		System.out.println(tasks.get(0));
	}

}
