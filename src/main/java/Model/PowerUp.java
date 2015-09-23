package Model;


public abstract class PowerUp extends Unit {
	
	private boolean status;
	
	public PowerUp () {
		status = false;
	}

	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}