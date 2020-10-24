package com.scrolltest.apidemo.tests;

import com.scrolltest.apidemo.helpers.RateServiceHelper;
import com.scrolltest.apidemo.model.Rate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import java.util.List;

public class TestGETrate {

    private RateServiceHelper serviceHelper;

    @BeforeClass
    public void init() {
        serviceHelper = new RateServiceHelper();
    }


    @Test
    public void testGetAllrates() {
        List<Rate> rateList = serviceHelper.getRate();
        assertNotNull(rateList, "rateList list is empty");
        assertFalse(rateList.isEmpty(), "rateLists list is empty");
    }

}
