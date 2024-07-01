package in.cdac.design.prototype.invoice;

import java.util.concurrent.ConcurrentHashMap;

public class ImplInvoicePrototypeRegistry implements InvoicePrototypeRegistry{

	ConcurrentHashMap<InvoiceType, Invoice>mapBasedOnType=new ConcurrentHashMap<>();
	
	@Override
	public void addPrototype(Invoice user) {
		 mapBasedOnType.put(user.getType(), user);
		
	}

	@Override
	public Invoice getPrototype(InvoiceType type) {
		  if(mapBasedOnType.containsKey(type))
			  return mapBasedOnType.get(type);
		return null;
	}

	@Override
	public Invoice clone(InvoiceType type) {
		if(mapBasedOnType.containsKey(type))
		    return mapBasedOnType.get(type).cloneObject();
		else
		    return null;
	}

}
