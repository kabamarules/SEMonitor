package Views;


import Presenter.Presenter;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class View extends JPanel {

	protected Presenter callbackPresenter;

	public View(Presenter callbackPresenter) { 
		 this.callbackPresenter = callbackPresenter; 
	 }

	/**
	 * Redraws the view with the updated data
	 */
	abstract public void redraw();

}
