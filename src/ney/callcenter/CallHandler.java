package ney.callcenter;

import java.util.ArrayList;
import java.util.LinkedList;

public class CallHandler {
	private int levels;
	private ArrayList<LinkedList<Call>> callsQueue;
	private ArrayList<Employee[]> empLevels;

	// changed it to taking in a fully made array of arrays so one could
	// determine the number of levels and types themselves
	public CallHandler(ArrayList<Employee[]> empLevels) {
		this.levels = empLevels.size();
		this.empLevels = empLevels;

		callsQueue = new ArrayList<LinkedList<Call>>();
	}

	public Employee getCallHandler(Call call) {
		for (int level = call.getRank(); level < levels - 1; level++) {
			Employee[] employeeLevel = empLevels.get(level);
			for (Employee emp : employeeLevel) {
				if (emp.isFree()) {
					return emp;
				}
			}
		}
		return null;
	}

	public void dispatchCall(Call call) {
		// try to route the call to an employee with minimal rank
		Employee emp = getCallHandler(call);
		if (emp != null) {
			emp.receiveCall(call);
		} else {
			// place the call into corresponding call queue according to
			// its rank
			call.reply("Please wait for free employee to reply");
			callsQueue.get(call.getRank()).add(call);
		}
	}

	public void getNextCall(Employee emp) {
		// check the queues, starting from the highest rank this
		// employee can serve
		for (int rank = emp.getRank(); rank >= 0; rank--) {
			LinkedList<Call> que = callsQueue.get(rank);
			Call call = que.getFirst();// remove the first call, if any
			que.removeFirst();
			if (call != null) {
				emp.receiveCall(call);
				return;
			}
		}
	}
}
