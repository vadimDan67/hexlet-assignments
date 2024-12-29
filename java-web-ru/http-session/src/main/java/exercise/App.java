package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        
        app.get("/users", ctx -> {
            var pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            var userNumber = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
            var intFrom = (pageNumber - 1) * userNumber;
            var intTo = pageNumber * userNumber;
            List<Map<String, String>> ret = new ArrayList<>();
            for (int i = 0; i < USERS.size(); i++) {
                if (i >= intFrom && i < intTo) {
                   ret.add(USERS.get(i));
                };
            }
            ctx.json(ret);
        });

        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
