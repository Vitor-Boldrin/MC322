package biblioteca.models.Item;

import biblioteca.models.ItemMultimidia.StatusItem;

public abstract class Item {
	
	private int id;
	private StatusItem status = StatusItem.DISPONIVEL;;
	
	public Item(int id) {
		this.id = id;
	}
	
	public int getId() {
	      return this.id;
	}
	
	public void setId(int id) {
	    this.id = id;
	}
	
	public StatusItem getStatusItem() {
	      return this.status;
	}
	
	public void setStatusItem(StatusItem status) {
	    this.status = status;
	}
	
}
