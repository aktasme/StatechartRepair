package apps;

import com.telelogic.rhapsody.core.*;

public class State extends Node
{
	IRPState state;
	
	int depth = -1;
	
	public State(IRPState state)
	{
		this.state = state;
	}

	@Override
	public void print() 
	{
		super.print();
		
		System.out.printf("State:%s depth:%d\n", state.getName(), depth);
	}
	
	/* Getters and Setters */
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
