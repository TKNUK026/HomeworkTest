package com.nageshuk.gitrepositorylib;

import com.nageshuk.gitrepositorylib.model.Item;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Running test cases by assuming network connection is available.
 * */
public class GithubRepositoryParsingUnitTest {

    @Test
    public void fetchRepository_rightParameterPassed_success() {
        List<Item> item = GithubRepositorySDK.getRepositoryInfo("android", "rakutentech");
        assertFalse(item.isEmpty());
    }

    @Test
    public void fetchRepository_wrongParameterPassed_failed() {
        List<Item> item = GithubRepositorySDK.getRepositoryInfo("###", "$$$");
        assertTrue(item.isEmpty());
    }
}
