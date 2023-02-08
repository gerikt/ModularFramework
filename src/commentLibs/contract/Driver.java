package commentLibs.contract;

//This contains all the methods that don't include any WebElements


public interface Driver {

	public void openBrowserandNavigateTo(String url) throws Exception ;
	
	public void closeCurrentBrowser() throws Exception;
	
	public void closeAllBrowsers() throws Exception;

	public String getTitleofThePage() throws Exception;

	public String getCurrentUrl() throws Exception;
	
	public void navigateForward() throws Exception;
	
	public void navigateBackward() throws Exception;

	public void refresh() throws Exception;
	
	

}
