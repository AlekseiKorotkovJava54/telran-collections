package telran.util;

import java.util.Iterator;

import telran.util.LinkedList.Node;

public class LinkedHashSet<T> extends AbstractCollection<T> implements Set<T> {
	
	HashMap<T, Node<T>> map = new HashMap<>();
	LinkedList<T> list = new LinkedList<>();
	
	@Override
	public T get(T pattern) {
		Node<T> node = map.get(pattern);
		return node == null ? null : node.data;
	}

	@Override
	public boolean add(T obj) {
		boolean res = false;
		Node<T> addNode = new Node<>(obj);
		Node<T> node = map.putIfAbsent(obj, addNode);
		if(node == null) {
			res = true;
			list.addNode(size, addNode);
			size++;
		}
		return res;
	}

	@Override
	public boolean remove(T pattern) {
		Node<T> node = map.get(pattern);
		boolean res = false;
		if (node != null) {
			res = true;
			list.removeNode(node);
			map.remove(pattern);
			size--;
		}
		
		return res;
	}

	@Override
	public boolean contains(T pattern) {
		Node<T> node = map.get(pattern);
		return node == null ? false : true;
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

}
