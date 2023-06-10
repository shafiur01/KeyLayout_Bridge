package combinatorics;

import java.util.Set;

public interface Permutation<E>
{
	//part of pre: element != null
	//part of pre: getDomain().contains(element)
	//part of post: rv != null
	//part of post: getDomain().contains(rv)
	public E getImage(E element);

	//part of pre: element != null
	//part of pre: getDomain().contains(element)
	//part of post: getDomain().contains(rv)
	public E getPreImage(E element);

	//part of post: rv != null
	//part of post: !rv.contains(null)
	public Set<E> getDomain();
}