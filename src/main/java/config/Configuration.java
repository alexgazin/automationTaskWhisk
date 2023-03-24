package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src/main/resources/app.properties"
})
public interface Configuration extends Config {

    @Key("api_host")
    String api_host();

    @Key("web_host")
    String web_host();

    @Key("token")
    String token();
}