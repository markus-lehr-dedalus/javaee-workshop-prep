package com.dedalus.control;

import com.dedalus.control.profile.MockingTestProfile;
import com.dedalus.model.CountryModel;
import com.dedalus.resource.CountryResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
@TestProfile(MockingTestProfile.class)
class CountryResourceFallbackTest {
    @Inject
    CountryResource resource;

    @Test
    void testFallbackTriggers() {
        List<CountryModel> result = resource.importCountries("Indonesia", 5);
        Assertions.assertEquals(ApiNinjaService.FALLBACK_COUNTRIES, result);
    }
}