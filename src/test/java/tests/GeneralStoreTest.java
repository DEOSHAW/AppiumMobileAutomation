package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.Baseclass;
import pageobject.GeneralStore;

public class GeneralStoreTest extends Baseclass
{
	@Test
	void NavigateToShoppingPage() throws InterruptedException
	{
		GeneralStore ob=new GeneralStore(driver);
		String title=ob.navigateToProductsPage();
		Assert.assertEquals(title, "Products");
		String productTitle=ob.scrollToProduct();
		Assert.assertEquals(productTitle, "Nike SFB Jungle");
		Assert.assertEquals(ob.validateAddToCart(), "Cart");
	}
}
