package gui;

import java.util.List;
import java.util.Vector;

import domain.Event;


public class ExtendedIteratorEvents implements ExtendedIterator<Event>{
	Vector<Event> events;
	
	public ExtendedIteratorEvents(Vector<Event> events) {
		super();
		this.events = events;
	}

	int position=0;

	@Override
	public boolean hasNext() {
		return position<events.size();
	}

	@Override
	public Event next() {
		Event e=events.get(position);
		position++;
		return e;
	}

	@Override
	public Event previous() {
		Event e=events.get(position);
		position--;
		return e;
	}

	@Override
	public boolean hasPrevious() {
		return position>=0;
	}

	@Override
	public void goFirst() {
		position = 0;
		
	}

	@Override
	public void goLast() {
		position = events.size()-1;
		
	}

}
