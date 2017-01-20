package net.sf.esfinge.comparison.layer;

import java.util.Collection;
import java.util.List;

import net.sf.esfinge.comparison.CompareException;
import net.sf.esfinge.comparison.ComparisonDescriptor;
import net.sf.esfinge.comparison.PropertyDescriptor;
import net.sf.esfinge.comparison.Repository;
import net.sf.esfinge.comparison.difference.Difference;
import net.sf.esfinge.comparison.difference.ListChanceDifference;
import net.sf.esfinge.comparison.difference.ListChange;
import net.sf.esfinge.comparison.utils.BeanUtils;


public class CollectionItensComparisonLayer extends ComparisonLayer {

	@Override
	public boolean compare(Object oldValue, Object newValue,
			List<Difference> difs, PropertyDescriptor descProp)
			throws CompareException {
		
		if(descProp.isCollectionComparison()){
			Collection oldCol = (Collection) oldValue;
			Collection newCol = (Collection) newValue;
			
			if(!descProp.isDeepComparison()){
				compareSimpleCollections(difs, descProp, oldCol, newCol);
			}else{
				compareComposedCollections(difs, descProp, oldCol, newCol);
			}
			
			return true;
		}
		return false;
	}

	private void compareComposedCollections(List<Difference> difs,
			PropertyDescriptor descProp, Collection oldCol, Collection newCol) throws CompareException {
		ComparisonDescriptor cd = Repository.getInstance().getMetadata(descProp.getAssociateType());
		searchForComplexAdditions(difs, descProp, oldCol, newCol, cd);
		searchForComplexRemovals(difs, descProp, oldCol, newCol, cd);
	}

	private void searchForComplexRemovals(List<Difference> difs,
			PropertyDescriptor descProp, Collection oldCol, Collection newCol,
			ComparisonDescriptor cd) {
		for(Object oldItem : oldCol){
			Object id = BeanUtils.getProperty(oldItem, cd.getIdProp());
			boolean found = false;
			IdSearch:
			for(Object newItem : newCol){
				if(id != null && id.equals(BeanUtils.getProperty(newItem, cd.getIdProp()))){
					found = true;
					break IdSearch;
				}
			}
			if(!found){
				difs.add(new ListChanceDifference(descProp.getName()+"[id="+id+"]", 
						oldItem, ListChange.REMOVED));
			}
		}
	}

	private void searchForComplexAdditions(List<Difference> difs,
			PropertyDescriptor descProp, Collection oldCol, Collection newCol,
			ComparisonDescriptor cd) throws CompareException {
		for(Object newItem : newCol){
			Object id = BeanUtils.getProperty(newItem, cd.getIdProp());
			if(id == null){
				difs.add(new ListChanceDifference(descProp.getName(), 
						newItem, ListChange.ADDED));
			}else{
				boolean found = false;
				IdSearch:
				for(Object oldItem : oldCol){
					if(id.equals(BeanUtils.getProperty(oldItem, cd.getIdProp()))){
						found = true;
						List<Difference> l;
						try {
							l = getComponent().compare(oldItem, newItem);
							for(Difference d : l){
								d.setPath(descProp.getName()+"[id="+id+"]."+ d.getPath());
								difs.add(d);
							}

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break IdSearch;
					}
				}
				if(!found){
					difs.add(new ListChanceDifference(descProp.getName()+"[id="+id+"]", 
							newItem, ListChange.ADDED));
				}
			}
			
		}
	}

	private void compareSimpleCollections(List<Difference> difs,
			PropertyDescriptor descProp, Collection oldCol, Collection newCol) {
		searchForSimpleAdditions(difs, descProp, oldCol, newCol);
		searchForSimpleRemovals(difs, descProp, oldCol, newCol);
	}

	private void searchForSimpleRemovals(List<Difference> difs,
			PropertyDescriptor descProp, Collection oldCol, Collection newCol) {
		for(Object item : oldCol){
			if(!newCol.contains(item)){
				difs.add(new ListChanceDifference(descProp.getName(), 
						item, ListChange.REMOVED));
			}
		}
	}

	private void searchForSimpleAdditions(List<Difference> difs,
			PropertyDescriptor descProp, Collection oldCol, Collection newCol) {
		for(Object item : newCol){
			if(!oldCol.contains(item)){
				difs.add(new ListChanceDifference(descProp.getName(), 
						item, ListChange.ADDED));
			}
		}
	}

}
