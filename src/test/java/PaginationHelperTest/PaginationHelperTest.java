package PaginationHelperTest;

import PaginationHelper.PaginationHelper;
import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class PaginationHelperTest {
    private PaginationHelper helper;
    Logger log=Logger.getLogger(Logger.class);

    @BeforeMethod
    public void setup() {

        helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
    }

    @Test(priority = 1, description = "This test is verifying item count", enabled = true)
    public void getItemCount() {
        log.info("Verifying item count is not null");
        Assert.assertNotNull(helper.itemCount());
        log.info("verifying item count should be equal to 6");
        Assert.assertEquals(6, helper.itemCount());
        log.info("Verifying the item count cannot be equal to a alphabetic value");
        Assert.assertNotEquals('z', helper.itemCount());
    }

    @Test(priority = 2, description = "This test is verifying Page count", enabled = true)
    public void getPageCount() {
        log.info("Verifying page count is not null");
        Assert.assertNotNull(helper.pageCount());
        log.info("Verifying page count should be equal 2");
        Assert.assertEquals(2, helper.pageCount());
        log.info("Verifying the page count cannot be equal to a alphabetic value");
        Assert.assertNotEquals('k', helper.pageCount());
    }

    @Test(priority = 3, description = "This test is verifying page item count if it matches with the required values", enabled = true)
    public void getPageItemCount() {
        log.info("Verifying if the first page has 4 values");
        Assert.assertEquals(4, helper.pageItemCount(0));
        log.info("Verifying if the first page has 2 values");
        Assert.assertEquals(2, helper.pageItemCount(1));
        //These assesrtions for different negative scenarios
        Assert.assertEquals(-1, helper.pageItemCount(2));
        Assert.assertNotEquals(-1, helper.pageItemCount(1));
        Assert.assertNotEquals('w', helper.pageItemCount(1));
        Assert.assertNotEquals(53, helper.pageItemCount(1));
    }

    @Test(priority = 1, description = "This test is verifying page index if it matches with the required values", enabled = true)
    public void getPageIndex() {
        /**
         * Page and Items are zero based index
         * helper.pageIndex(3); //should == 0
         * helper.pageIndex(4); //should == 0
         * helper.pageIndex(6); //should == 1
         * helper.pageIndex(10); //should == -1
         * helper.pageIndex(-15); //should == -1
         */
        Assert.assertEquals(0, helper.pageIndex(3));
        Assert.assertEquals(1, helper.pageIndex(4));
        Assert.assertEquals(1, helper.pageIndex(5));
        Assert.assertEquals(-1, helper.pageIndex(10));
        Assert.assertEquals(-1, helper.pageIndex(-15));
        Assert.assertNotEquals(-2,helper.pageIndex(5));
        Assert.assertNotEquals(1, helper.pageIndex(2));
        Assert.assertNotEquals(-2,helper.pageIndex(20));
        Assert.assertNotEquals('t',helper.pageIndex(-10));
    }

    @AfterMethod
    public void tearDown(){
        helper=null;
    }

}
