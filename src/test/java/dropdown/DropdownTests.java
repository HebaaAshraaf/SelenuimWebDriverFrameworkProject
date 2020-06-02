package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropDownPage;

import static org.testng.Assert.*;

import java.util.List;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        String option = "Option 1";

        DropDownPage dropDownPage = homePage.clickDropDown();
        dropDownPage.selectFromDropDown(option);
        List<String> selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }
}
