package biblioteca.models.Item;

import biblioteca.models.ItemMultimidia.StatusItem;

public abstract class Item {
	
	private int id;
	private StatusItem status = StatusItem.DISPONIVEL;;
	
	public Item(int id, StatusItem status) {
		this.id = id;
		this.status = status;
	}
	
	public int getId() {
	      return this.id;
	}
	
	public void setId(int id) {
	    this.id = id;
	}
	
	public StatusItem getStatus() {
	      return this.status;
	}
	
	public void setStatus(StatusItem status) {
	    this.status = status;
	}
	
}
