package $group$.helloworld;

import $group$.helloworld.auth.ExampleAuthenticator;
import $group$.helloworld.cli.RenderCommand;
import $group$.helloworld.core.Person;
import $group$.helloworld.core.Template;
import $group$.helloworld.core.User;
import $group$.helloworld.db.PersonDAO;
import $group$.helloworld.health.TemplateHealthCheck;
import $group$.helloworld.resources.HelloWorldResource;
import $group$.helloworld.resources.PeopleResource;
import $group$.helloworld.resources.PersonResource;
import $group$.helloworld.resources.ProtectedResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.auth.basic.BasicAuthProvider;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.HibernateBundle;
import com.yammer.dropwizard.migrations.MigrationsBundle;

public class HelloWorldApplication extends Service<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    private final HibernateBundle<HelloWorldConfiguration> hibernateBundle =
            new HibernateBundle<HelloWorldConfiguration>(Person.class) {
                

				@Override
				public DatabaseConfiguration getDatabaseConfiguration(
						HelloWorldConfiguration configuration) {
					return configuration.getDataBaseConfig();
				}
            };

   

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addCommand(new RenderCommand());
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<HelloWorldConfiguration>() {

			@Override
			public DatabaseConfiguration getDatabaseConfiguration(
					HelloWorldConfiguration configuration) {
				return configuration.getDataBaseConfig();
			}
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        final PersonDAO dao = new PersonDAO(hibernateBundle.getSessionFactory());
        final Template template = configuration.buildTemplate();

        environment.addHealthCheck(new TemplateHealthCheck(template));

        environment.addResource(new BasicAuthProvider<User>(new ExampleAuthenticator(), "secret"));
        environment.addResource(new HelloWorldResource(template));
        environment.addResource(new ProtectedResource());
        environment.addResource(new PeopleResource(dao));
        environment.addResource(new PersonResource(dao));
    }
}
