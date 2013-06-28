package org.example.helloworld;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.example.helloworld.core.Template;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.db.ManagedDataSourceFactory;

public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @Valid
    @NotNull
    private ManagedDataSourceFactory database = new ManagedDataSourceFactory();


    @Valid
    @NotNull
    private DatabaseConfiguration databaseConfig = new DatabaseConfiguration();
    
    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public Template buildTemplate() {
        return new Template(template, defaultName);
    }

    @JsonProperty("database")
    public DatabaseConfiguration getDataBaseConfig() {
        return databaseConfig;
    }

    @JsonProperty("database")
    public void setDataBaseConfig(DatabaseConfiguration databaseConfig) {
        this.databaseConfig = databaseConfig;
    }
}
