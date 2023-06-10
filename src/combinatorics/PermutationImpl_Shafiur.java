package combinatorics;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
//EX: 	Assume Permutation p = <[2, 3, 5, 7], [11, 13, 17, 19], [23, 29], [31]>;
//		Then p.getImage(2)     --> 3
//			 p.getImage(5)     --> 7
//			 p.getImage(7)     --> 2
//			 p.getImage(13)    --> 17
//			 p.getImage(29)    --> 23
//			 p.getImage(31)    --> 31
//			 and others.
//		And  p.getPreImage(3)  --> 2
//			 p.getPreImage(2)  --> 7
//			 p.getPreImage(31) --> 31
//			 and others.
//		And  p.getDomain()     --> {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31}

public class PermutationImpl_Shafiur<E> implements Permutation<E>
{
	//Student: Select your own internal representation and associated instance variables
	Set<List<E>> setOfList = new HashSet<List<E>>();
	
	@SafeVarargs
	//part of pre: cycles != null
	//part of pre: nothing in cycles contains null
	public PermutationImpl_Shafiur(List<E>... cycles)
	{
		assert cycles != null : "The list of the cycles cant be null";
		boolean containsNull = false;
		// this for loop is doing two thing
		for(List<E> list : cycles)
		{
			containsNull = list.contains(null);
			if(containsNull)
			{
				break;
			}
			else
			{
				setOfList.add(list);
			}
		}
		assert containsNull == false : "The list of the cycles can't contain null";
	}

	//part of pre: element != null
	//part of pre: getDomain().contains(element)
	//part of post: rv != null
	//part of post: getDomain().contains(rv)
	@Override
	public E getImage(E element)
	{
		assert element!=null: "The element can't be null";
		assert getDomain().contains(element) : "The element should be in the domain";
		
		E image = null;
		for(List<E> list : setOfList)
		{
			if(list.contains(element))
			{
				int indexOfElement = list.indexOf(element);
				int indexOfImage = (indexOfElement + 1) % list.size();
				image = list.get(indexOfImage);
			}
			else
			{
				continue;
			}
		}
		assert image!=null : "The Image can't be null";
		assert getDomain().contains(image) : "The image should be in the domain";
		return image;
	}


	//part of pre: element != null
	//part of pre: getDomain().contains(element)
	//part of post: getDomain().contains(rv)
	@Override
	public E getPreImage(E element)
	{
		assert element!=null: "The element can't be null";
		assert getDomain().contains(element) : "The element should be in the domain";
		
		E preImage = null;
		for(List<E> list : setOfList)
		{
			if(list.contains(element))
			{
				int indexOfElement = list.indexOf(element);
				int indexOfImage = (list.size()+(indexOfElement - 1)) % list.size();
				preImage = list.get(indexOfImage);
			}
			else
			{
				continue;
			}
		}
		
		assert preImage!=null : "The Image can't be null";
		assert getDomain().contains(preImage) : "The image should be in the domain";
		return preImage;
	}

	
	//part of post: rv != null
	//part of post: !rv.contains(null)
	@Override
	public Set<E> getDomain()
	{
		Set<E> domain = new HashSet<E>();
		for(List<E> list : setOfList)
		{
			for(E element: list)
			{
				domain.add(element);
			}
		}
		
		assert domain!= null : "The domain can't be null";
		assert !domain.contains(null) : "The domain can't contain null";
		return domain;
	}
		
	
	public String toString()
	{
		String str = "";
		for(List<E> list : setOfList)
		{
			str += list + " ";
		}
		return str;
	}
}
