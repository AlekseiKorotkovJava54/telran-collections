package telran.util;

import java.util.Comparator;

public class TreeMap<K, V> extends AbstractMap<K, V> implements SortedMap<K, V> {

	@Override
	public K firstKey() {
		return ((TreeSet<Entry<K, V>>) set).first().getKey();
	}

	@Override
	public K lastKey() {
		return ((TreeSet<Entry<K, V>>) set).last().getKey();
	}

	@Override
	public K floorKey(K key) {
		return ((TreeSet<Entry<K, V>>) set).floor(new Entry<>(key, null)).getKey();
	}

	@Override
	public K ceilingKey(K key) {
		return ((TreeSet<Entry<K, V>>) set).ceiling(new Entry<>(key, null)).getKey();
	}

	@Override
	protected Set<K> getEmptyKeySet() {
		return new TreeSet<K>();
	}
	public TreeMap() {
		set = new TreeSet<>();
	}
	public TreeMap(Comparator<Entry<K, V>> comp) {
		set = new TreeSet<>(comp);
	}

}
