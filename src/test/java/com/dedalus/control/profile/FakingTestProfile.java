package com.dedalus.control.profile;

import com.dedalus.control.mock.FailingApiNinjaRestClient;
import com.dedalus.control.mock.FakingApiNinjaRestClient;
import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Set;

public class FakingTestProfile implements QuarkusTestProfile {
    @Override
    public Set<Class<?>> getEnabledAlternatives() {
        return Set.of(
                FakingApiNinjaRestClient.class
        );
    }
}
