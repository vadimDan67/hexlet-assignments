package exercise;

// BEGIN
import io.javalin.Javalin;
// END

public final class App {

    public static Javalin getApp() {

        // BEGIN
        // Создаем приложение
        var app = Javalin.create();

        // Описываем, что будет происходить при GET запросе на адрес /
        app.get("/welcome", ctx -> ctx.result("Welcome to Javalin!"));

        // Возвращаем настроенное приложение
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
