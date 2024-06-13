package com.dedalus.control;

import com.dedalus.control.mock.FakingApiNinjaRestClient;
import com.dedalus.control.profile.FakingTestProfile;
import com.dedalus.model.CountryModel;
import com.dedalus.resource.CountryResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
@TestProfile(FakingTestProfile.class)
class CountryResourceFakingTest {
    @Inject
    CountryResource resource;
    @Inject
    CountryMapper countryMapper;

    @Test
    void testOneResultIsHandled() {
        List<CountryModel> result = resource.importCountries("Indonesia", 5);
        Assertions.assertEquals(1, result.size());
        CountryModel expected = countryMapper.mapApiNinjaToModel(FakingApiNinjaRestClient.DUMMY_MODEL);
        CountryModel actual = result.get(0);
        Assertions.assertNotNull(actual.getId());
        actual.setId(null);
        Assertions.assertEquals(expected, actual);
    }
}