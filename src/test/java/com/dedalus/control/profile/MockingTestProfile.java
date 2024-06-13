package com.dedalus.control.profile;

import com.dedalus.control.mock.FailingApiNinjaRestClient;
import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Map;
import java.util.Set;

public class MockingTestProfile implements QuarkusTestProfile {
    @Override
    public Set<Class<?>> getEnabledAlternatives() {
        return Set.of(
                FailingApiNinjaRestClient.class
        );
    }

    @Override
    public Map<String, String> getConfigOverrides() {
        return Map.of(
                "quarkus.db.", "h2"
        );
    }
}
