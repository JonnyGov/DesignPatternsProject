package gui;

public class SceneDirector {
	
	public void build(SceneBuilder builder) {
		builder.buildLoader();
		builder.buildScene();
		builder.buildController();
		builder.buildVersion();
		builder.buildAuthors();
		builder.buildInsurenceTitle();
		builder.buildViewPurchases();
		builder.buildButtons();
	}
}
